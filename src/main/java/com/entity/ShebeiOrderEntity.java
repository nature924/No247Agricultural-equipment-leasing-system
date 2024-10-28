package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 设备订单
 *
 * @author 
 * @email
 */
@TableName("shebei_order")
public class ShebeiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShebeiOrderEntity() {

	}

	public ShebeiOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "shebei_order_uuid_number")

    private String shebeiOrderUuidNumber;


    /**
     * 收货地址
     */
    @ColumnInfo(comment="收货地址",type="int(11)")
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 设备
     */
    @ColumnInfo(comment="设备",type="int(11)")
    @TableField(value = "shebei_id")

    private Integer shebeiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 租赁天数
     */
    @ColumnInfo(comment="租赁天数",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 租赁日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="租赁日期",type="timestamp")
    @TableField(value = "shebei_order_time")

    private Date shebeiOrderTime;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "shebei_order_true_price")

    private Double shebeiOrderTruePrice;


    /**
     * 快递公司
     */
    @ColumnInfo(comment="快递公司",type="varchar(200)")
    @TableField(value = "shebei_order_courier_name")

    private String shebeiOrderCourierName;


    /**
     * 快递单号
     */
    @ColumnInfo(comment="快递单号",type="varchar(200)")
    @TableField(value = "shebei_order_courier_number")

    private String shebeiOrderCourierNumber;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "shebei_order_types")

    private Integer shebeiOrderTypes;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "shebei_order_payment_types")

    private Integer shebeiOrderPaymentTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "shebei_order_yesno_types")

    private Integer shebeiOrderYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "shebei_order_yesno_text")

    private String shebeiOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "shebei_order_shenhe_time")

    private Date shebeiOrderShenheTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ShebeiOrder{" +
            ", id=" + id +
            ", shebeiOrderUuidNumber=" + shebeiOrderUuidNumber +
            ", addressId=" + addressId +
            ", shebeiId=" + shebeiId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", shebeiOrderTime=" + DateUtil.convertString(shebeiOrderTime,"yyyy-MM-dd") +
            ", shebeiOrderTruePrice=" + shebeiOrderTruePrice +
            ", shebeiOrderCourierName=" + shebeiOrderCourierName +
            ", shebeiOrderCourierNumber=" + shebeiOrderCourierNumber +
            ", shebeiOrderTypes=" + shebeiOrderTypes +
            ", shebeiOrderPaymentTypes=" + shebeiOrderPaymentTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", shebeiOrderYesnoTypes=" + shebeiOrderYesnoTypes +
            ", shebeiOrderYesnoText=" + shebeiOrderYesnoText +
            ", shebeiOrderShenheTime=" + DateUtil.convertString(shebeiOrderShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
