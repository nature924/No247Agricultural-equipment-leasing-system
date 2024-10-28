package com.entity.model;

import com.entity.ShebeiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 设备订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShebeiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String shebeiOrderUuidNumber;


    /**
     * 收货地址
     */
    private Integer addressId;


    /**
     * 设备
     */
    private Integer shebeiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 租赁天数
     */
    private Integer buyNumber;


    /**
     * 租赁日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shebeiOrderTime;


    /**
     * 实付价格
     */
    private Double shebeiOrderTruePrice;


    /**
     * 快递公司
     */
    private String shebeiOrderCourierName;


    /**
     * 快递单号
     */
    private String shebeiOrderCourierNumber;


    /**
     * 订单类型
     */
    private Integer shebeiOrderTypes;


    /**
     * 支付类型
     */
    private Integer shebeiOrderPaymentTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 申请状态
     */
    private Integer shebeiOrderYesnoTypes;


    /**
     * 审核回复
     */
    private String shebeiOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shebeiOrderShenheTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单编号
	 */
    public String getShebeiOrderUuidNumber() {
        return shebeiOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setShebeiOrderUuidNumber(String shebeiOrderUuidNumber) {
        this.shebeiOrderUuidNumber = shebeiOrderUuidNumber;
    }
    /**
	 * 获取：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 设置：收货地址
	 */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：设备
	 */
    public Integer getShebeiId() {
        return shebeiId;
    }


    /**
	 * 设置：设备
	 */
    public void setShebeiId(Integer shebeiId) {
        this.shebeiId = shebeiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：租赁天数
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：租赁天数
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：租赁日期
	 */
    public Date getShebeiOrderTime() {
        return shebeiOrderTime;
    }


    /**
	 * 设置：租赁日期
	 */
    public void setShebeiOrderTime(Date shebeiOrderTime) {
        this.shebeiOrderTime = shebeiOrderTime;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getShebeiOrderTruePrice() {
        return shebeiOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setShebeiOrderTruePrice(Double shebeiOrderTruePrice) {
        this.shebeiOrderTruePrice = shebeiOrderTruePrice;
    }
    /**
	 * 获取：快递公司
	 */
    public String getShebeiOrderCourierName() {
        return shebeiOrderCourierName;
    }


    /**
	 * 设置：快递公司
	 */
    public void setShebeiOrderCourierName(String shebeiOrderCourierName) {
        this.shebeiOrderCourierName = shebeiOrderCourierName;
    }
    /**
	 * 获取：快递单号
	 */
    public String getShebeiOrderCourierNumber() {
        return shebeiOrderCourierNumber;
    }


    /**
	 * 设置：快递单号
	 */
    public void setShebeiOrderCourierNumber(String shebeiOrderCourierNumber) {
        this.shebeiOrderCourierNumber = shebeiOrderCourierNumber;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getShebeiOrderTypes() {
        return shebeiOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setShebeiOrderTypes(Integer shebeiOrderTypes) {
        this.shebeiOrderTypes = shebeiOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getShebeiOrderPaymentTypes() {
        return shebeiOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setShebeiOrderPaymentTypes(Integer shebeiOrderPaymentTypes) {
        this.shebeiOrderPaymentTypes = shebeiOrderPaymentTypes;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getShebeiOrderYesnoTypes() {
        return shebeiOrderYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setShebeiOrderYesnoTypes(Integer shebeiOrderYesnoTypes) {
        this.shebeiOrderYesnoTypes = shebeiOrderYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getShebeiOrderYesnoText() {
        return shebeiOrderYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setShebeiOrderYesnoText(String shebeiOrderYesnoText) {
        this.shebeiOrderYesnoText = shebeiOrderYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getShebeiOrderShenheTime() {
        return shebeiOrderShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setShebeiOrderShenheTime(Date shebeiOrderShenheTime) {
        this.shebeiOrderShenheTime = shebeiOrderShenheTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
