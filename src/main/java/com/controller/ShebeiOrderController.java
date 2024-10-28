
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 设备订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shebeiOrder")
public class ShebeiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ShebeiOrderController.class);

    private static final String TABLE_NAME = "shebeiOrder";

    @Autowired
    private ShebeiOrderService shebeiOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LiuyanService liuyanService;//留言反馈
    @Autowired
    private ShebeiService shebeiService;//设备
    @Autowired
    private ShebeiCollectionService shebeiCollectionService;//设备收藏
    @Autowired
    private ShebeiCommentbackService shebeiCommentbackService;//设备评价
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = shebeiOrderService.queryPage(params);

        //字典表数据转换
        List<ShebeiOrderView> list =(List<ShebeiOrderView>)page.getList();
        for(ShebeiOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShebeiOrderEntity shebeiOrder = shebeiOrderService.selectById(id);
        if(shebeiOrder !=null){
            //entity转view
            ShebeiOrderView view = new ShebeiOrderView();
            BeanUtils.copyProperties( shebeiOrder , view );//把实体数据重构到view中
            //级联表 收货地址
            //级联表
            AddressEntity address = addressService.selectById(shebeiOrder.getAddressId());
            if(address != null){
            BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setAddressId(address.getId());
            }
            //级联表 设备
            //级联表
            ShebeiEntity shebei = shebeiService.selectById(shebeiOrder.getShebeiId());
            if(shebei != null){
            BeanUtils.copyProperties( shebei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShebeiId(shebei.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shebeiOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShebeiOrderEntity shebeiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shebeiOrder:{}",this.getClass().getName(),shebeiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shebeiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        shebeiOrder.setCreateTime(new Date());
        shebeiOrder.setInsertTime(new Date());
        shebeiOrderService.insert(shebeiOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShebeiOrderEntity shebeiOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shebeiOrder:{}",this.getClass().getName(),shebeiOrder.toString());
        ShebeiOrderEntity oldShebeiOrderEntity = shebeiOrderService.selectById(shebeiOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shebeiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            shebeiOrderService.updateById(shebeiOrder);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ShebeiOrderEntity shebeiOrderEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,shebeiOrderEntity:{}",this.getClass().getName(),shebeiOrderEntity.toString());

        ShebeiOrderEntity oldShebeiOrder = shebeiOrderService.selectById(shebeiOrderEntity.getId());//查询原先数据

        if(shebeiOrderEntity.getShebeiOrderYesnoTypes() == 2){//通过
            shebeiOrderEntity.setShebeiOrderTypes(103);
        }else if(shebeiOrderEntity.getShebeiOrderYesnoTypes() == 3){//拒绝
            shebeiOrderEntity.setShebeiOrderTypes(106);
        }
        shebeiOrderEntity.setShebeiOrderShenheTime(new Date());//审核时间
        shebeiOrderService.updateById(shebeiOrderEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShebeiOrderEntity> oldShebeiOrderList =shebeiOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shebeiOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShebeiOrderEntity> shebeiOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShebeiOrderEntity shebeiOrderEntity = new ShebeiOrderEntity();
//                            shebeiOrderEntity.setShebeiOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            shebeiOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收货地址 要改的
//                            shebeiOrderEntity.setShebeiId(Integer.valueOf(data.get(0)));   //设备 要改的
//                            shebeiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shebeiOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //租赁天数 要改的
//                            shebeiOrderEntity.setShebeiOrderTime(sdf.parse(data.get(0)));          //租赁日期 要改的
//                            shebeiOrderEntity.setShebeiOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            shebeiOrderEntity.setShebeiOrderCourierName(data.get(0));                    //快递公司 要改的
//                            shebeiOrderEntity.setShebeiOrderCourierNumber(data.get(0));                    //快递单号 要改的
//                            shebeiOrderEntity.setShebeiOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            shebeiOrderEntity.setShebeiOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            shebeiOrderEntity.setInsertTime(date);//时间
//                            shebeiOrderEntity.setShebeiOrderYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            shebeiOrderEntity.setShebeiOrderYesnoText(data.get(0));                    //审核回复 要改的
//                            shebeiOrderEntity.setShebeiOrderShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            shebeiOrderEntity.setCreateTime(date);//时间
                            shebeiOrderList.add(shebeiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("shebeiOrderUuidNumber")){
                                    List<String> shebeiOrderUuidNumber = seachFields.get("shebeiOrderUuidNumber");
                                    shebeiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shebeiOrderUuidNumber = new ArrayList<>();
                                    shebeiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shebeiOrderUuidNumber",shebeiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<ShebeiOrderEntity> shebeiOrderEntities_shebeiOrderUuidNumber = shebeiOrderService.selectList(new EntityWrapper<ShebeiOrderEntity>().in("shebei_order_uuid_number", seachFields.get("shebeiOrderUuidNumber")));
                        if(shebeiOrderEntities_shebeiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShebeiOrderEntity s:shebeiOrderEntities_shebeiOrderUuidNumber){
                                repeatFields.add(s.getShebeiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shebeiOrderService.insertBatch(shebeiOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shebeiOrderService.queryPage(params);

        //字典表数据转换
        List<ShebeiOrderView> list =(List<ShebeiOrderView>)page.getList();
        for(ShebeiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShebeiOrderEntity shebeiOrder = shebeiOrderService.selectById(id);
            if(shebeiOrder !=null){


                //entity转view
                ShebeiOrderView view = new ShebeiOrderView();
                BeanUtils.copyProperties( shebeiOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(shebeiOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    ShebeiEntity shebei = shebeiService.selectById(shebeiOrder.getShebeiId());
                if(shebei != null){
                    BeanUtils.copyProperties( shebei , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShebeiId(shebei.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shebeiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShebeiOrderEntity shebeiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shebeiOrder:{}",this.getClass().getName(),shebeiOrder.toString());
            ShebeiEntity shebeiEntity = shebeiService.selectById(shebeiOrder.getShebeiId());
            if(shebeiEntity == null){
                return R.error(511,"查不到该设备");
            }
            // Double shebeiNewMoney = shebeiEntity.getShebeiNewMoney();

            if(false){
            }
            else if(shebeiEntity.getShebeiNewMoney() == null){
                return R.error(511,"租赁现价/天不能为空");
            }
            else if((shebeiEntity.getShebeiKucunNumber() -1)<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - shebeiEntity.getShebeiNewMoney()*1;//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            shebeiOrder.setShebeiOrderTypes(101);
            shebeiOrder.setShebeiOrderTruePrice(shebeiEntity.getShebeiNewMoney()*1); //设置实付价格
            shebeiOrder.setYonghuId(userId); //设置订单支付人id
            shebeiOrder.setShebeiOrderUuidNumber(String.valueOf(new Date().getTime()));
        shebeiOrder.setShebeiOrderYesnoTypes(1);
            shebeiOrder.setShebeiOrderPaymentTypes(1);
            shebeiOrder.setInsertTime(new Date());
            shebeiOrder.setCreateTime(new Date());
                shebeiEntity.setShebeiKucunNumber( shebeiEntity.getShebeiKucunNumber() -1);
                shebeiService.updateById(shebeiEntity);
                shebeiOrderService.insert(shebeiOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 取消申请
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            ShebeiOrderEntity shebeiOrder = shebeiOrderService.selectById(id);//当前表service
            Integer buyNumber = shebeiOrder.getBuyNumber();
            Integer shebeiOrderPaymentTypes = shebeiOrder.getShebeiOrderPaymentTypes();
            Integer shebeiId = shebeiOrder.getShebeiId();
            if(shebeiId == null)
                return R.error(511,"查不到该设备");
            ShebeiEntity shebeiEntity = shebeiService.selectById(shebeiId);
            if(shebeiEntity == null)
                return R.error(511,"查不到该设备");
            Double shebeiNewMoney = shebeiEntity.getShebeiNewMoney();
            if(shebeiNewMoney == null)
                return R.error(511,"设备价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

            //判断是什么支付方式 1代表余额 2代表积分
            if(shebeiOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = shebeiEntity.getShebeiNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


            }

            shebeiEntity.setShebeiKucunNumber(shebeiEntity.getShebeiKucunNumber() + 1);

        shebeiOrder.setShebeiOrderYesnoTypes(null);
            shebeiOrder.setShebeiOrderTypes(102);//设置订单状态为已取消申请
            shebeiOrderService.updateAllColumnById(shebeiOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            shebeiService.updateById(shebeiEntity);//更新订单中设备的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer shebeiCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            ShebeiOrderEntity shebeiOrder = shebeiOrderService.selectById(id);
        if(shebeiOrder == null)
            return R.error(511,"查不到该订单");
        Integer shebeiId = shebeiOrder.getShebeiId();
        if(shebeiId == null)
            return R.error(511,"查不到该设备");

        ShebeiCommentbackEntity shebeiCommentbackEntity = new ShebeiCommentbackEntity();
            shebeiCommentbackEntity.setId(id);
            shebeiCommentbackEntity.setShebeiId(shebeiId);
            shebeiCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            shebeiCommentbackEntity.setShebeiCommentbackText(commentbackText);
            shebeiCommentbackEntity.setInsertTime(new Date());
            shebeiCommentbackEntity.setReplyText(null);
            shebeiCommentbackEntity.setUpdateTime(null);
            shebeiCommentbackEntity.setCreateTime(new Date());
            shebeiCommentbackService.insert(shebeiCommentbackEntity);

            shebeiOrder.setShebeiOrderTypes(105);//设置订单状态为已评价
            shebeiOrderService.updateById(shebeiOrder);//根据id更新
            return R.ok();
    }

    /**
     * 同意租赁
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ,String shebeiOrderCourierNumber, String shebeiOrderCourierName , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ShebeiOrderEntity  shebeiOrderEntity = shebeiOrderService.selectById(id);
        shebeiOrderEntity.setShebeiOrderTypes(103);//设置订单状态为已同意租赁
        shebeiOrderEntity.setShebeiOrderCourierNumber(shebeiOrderCourierNumber);
        shebeiOrderEntity.setShebeiOrderCourierName(shebeiOrderCourierName);
        shebeiOrderService.updateById( shebeiOrderEntity);

        return R.ok();
    }


    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ShebeiOrderEntity  shebeiOrderEntity = shebeiOrderService.selectById(id);
        shebeiOrderEntity.setShebeiOrderTypes(104);//设置订单状态为收货
        shebeiOrderService.updateById( shebeiOrderEntity);
        return R.ok();
    }


    /**
     * 已归还
     */
    @RequestMapping("/yiguihuan")
    public R yiguihuan(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ShebeiOrderEntity  shebeiOrderEntity = shebeiOrderService.selectById(id);
        shebeiOrderEntity.setShebeiOrderTypes(107);//已归还
        shebeiOrderService.updateById( shebeiOrderEntity);

        ShebeiEntity shebeiEntity = shebeiService.selectById(shebeiOrderEntity.getShebeiId());
        if(shebeiEntity != null){
            shebeiEntity.setShebeiKucunNumber(shebeiEntity.getShebeiKucunNumber()+1);
        }

        return R.ok();
    }

}

