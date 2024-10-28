package com.entity.vo;

import com.entity.ShebeiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 设备订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shebei_order")
public class ShebeiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "shebei_order_uuid_number")
    private String shebeiOrderUuidNumber;


    /**
     * 收货地址
     */

    @TableField(value = "address_id")
    private Integer addressId;


    /**
     * 设备
     */

    @TableField(value = "shebei_id")
    private Integer shebeiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 租赁天数
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 租赁日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shebei_order_time")
    private Date shebeiOrderTime;


    /**
     * 实付价格
     */

    @TableField(value = "shebei_order_true_price")
    private Double shebeiOrderTruePrice;


    /**
     * 快递公司
     */

    @TableField(value = "shebei_order_courier_name")
    private String shebeiOrderCourierName;


    /**
     * 快递单号
     */

    @TableField(value = "shebei_order_courier_number")
    private String shebeiOrderCourierNumber;


    /**
     * 订单类型
     */

    @TableField(value = "shebei_order_types")
    private Integer shebeiOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "shebei_order_payment_types")
    private Integer shebeiOrderPaymentTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 申请状态
     */

    @TableField(value = "shebei_order_yesno_types")
    private Integer shebeiOrderYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "shebei_order_yesno_text")
    private String shebeiOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shebei_order_shenhe_time")
    private Date shebeiOrderShenheTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单编号
	 */
    public String getShebeiOrderUuidNumber() {
        return shebeiOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setShebeiOrderUuidNumber(String shebeiOrderUuidNumber) {
        this.shebeiOrderUuidNumber = shebeiOrderUuidNumber;
    }
    /**
	 * 设置：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：设备
	 */
    public Integer getShebeiId() {
        return shebeiId;
    }


    /**
	 * 获取：设备
	 */

    public void setShebeiId(Integer shebeiId) {
        this.shebeiId = shebeiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：租赁天数
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：租赁天数
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：租赁日期
	 */
    public Date getShebeiOrderTime() {
        return shebeiOrderTime;
    }


    /**
	 * 获取：租赁日期
	 */

    public void setShebeiOrderTime(Date shebeiOrderTime) {
        this.shebeiOrderTime = shebeiOrderTime;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getShebeiOrderTruePrice() {
        return shebeiOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setShebeiOrderTruePrice(Double shebeiOrderTruePrice) {
        this.shebeiOrderTruePrice = shebeiOrderTruePrice;
    }
    /**
	 * 设置：快递公司
	 */
    public String getShebeiOrderCourierName() {
        return shebeiOrderCourierName;
    }


    /**
	 * 获取：快递公司
	 */

    public void setShebeiOrderCourierName(String shebeiOrderCourierName) {
        this.shebeiOrderCourierName = shebeiOrderCourierName;
    }
    /**
	 * 设置：快递单号
	 */
    public String getShebeiOrderCourierNumber() {
        return shebeiOrderCourierNumber;
    }


    /**
	 * 获取：快递单号
	 */

    public void setShebeiOrderCourierNumber(String shebeiOrderCourierNumber) {
        this.shebeiOrderCourierNumber = shebeiOrderCourierNumber;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getShebeiOrderTypes() {
        return shebeiOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setShebeiOrderTypes(Integer shebeiOrderTypes) {
        this.shebeiOrderTypes = shebeiOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getShebeiOrderPaymentTypes() {
        return shebeiOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setShebeiOrderPaymentTypes(Integer shebeiOrderPaymentTypes) {
        this.shebeiOrderPaymentTypes = shebeiOrderPaymentTypes;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getShebeiOrderYesnoTypes() {
        return shebeiOrderYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setShebeiOrderYesnoTypes(Integer shebeiOrderYesnoTypes) {
        this.shebeiOrderYesnoTypes = shebeiOrderYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getShebeiOrderYesnoText() {
        return shebeiOrderYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setShebeiOrderYesnoText(String shebeiOrderYesnoText) {
        this.shebeiOrderYesnoText = shebeiOrderYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getShebeiOrderShenheTime() {
        return shebeiOrderShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setShebeiOrderShenheTime(Date shebeiOrderShenheTime) {
        this.shebeiOrderShenheTime = shebeiOrderShenheTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
