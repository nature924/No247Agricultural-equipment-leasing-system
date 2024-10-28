package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShebeiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 设备订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shebei_order")
public class ShebeiOrderView extends ShebeiOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String shebeiOrderValue;
	/**
	* 支付类型的值
	*/
	@ColumnInfo(comment="支付类型的字典表值",type="varchar(200)")
	private String shebeiOrderPaymentValue;
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String shebeiOrderYesnoValue;

	//级联表 收货地址
					 
		/**
		* 收货地址 的 创建用户
		*/
		@ColumnInfo(comment="创建用户",type="int(20)")
		private Integer addressYonghuId;
		/**
		* 收货人
		*/

		@ColumnInfo(comment="收货人",type="varchar(200)")
		private String addressName;
		/**
		* 电话
		*/

		@ColumnInfo(comment="电话",type="varchar(200)")
		private String addressPhone;
		/**
		* 地址
		*/

		@ColumnInfo(comment="地址",type="varchar(200)")
		private String addressDizhi;
		/**
		* 是否默认地址
		*/
		@ColumnInfo(comment="是否默认地址",type="int(11)")
		private Integer isdefaultTypes;
			/**
			* 是否默认地址的值
			*/
			@ColumnInfo(comment="是否默认地址的字典表值",type="varchar(200)")
			private String isdefaultValue;
	//级联表 设备
		/**
		* 设备名称
		*/

		@ColumnInfo(comment="设备名称",type="varchar(200)")
		private String shebeiName;
		/**
		* 设备编号
		*/

		@ColumnInfo(comment="设备编号",type="varchar(200)")
		private String shebeiUuidNumber;
		/**
		* 设备照片
		*/

		@ColumnInfo(comment="设备照片",type="varchar(200)")
		private String shebeiPhoto;
		/**
		* 设备类型
		*/
		@ColumnInfo(comment="设备类型",type="int(11)")
		private Integer shebeiTypes;
			/**
			* 设备类型的值
			*/
			@ColumnInfo(comment="设备类型的字典表值",type="varchar(200)")
			private String shebeiValue;
		/**
		* 设备库存
		*/

		@ColumnInfo(comment="设备库存",type="int(11)")
		private Integer shebeiKucunNumber;
		/**
		* 租赁原价/天
		*/
		@ColumnInfo(comment="租赁原价/天",type="decimal(10,2)")
		private Double shebeiOldMoney;
		/**
		* 租赁现价/天
		*/
		@ColumnInfo(comment="租赁现价/天",type="decimal(10,2)")
		private Double shebeiNewMoney;
		/**
		* 设备热度
		*/

		@ColumnInfo(comment="设备热度",type="int(11)")
		private Integer shebeiClicknum;
		/**
		* 设备介绍
		*/

		@ColumnInfo(comment="设备介绍",type="longtext")
		private String shebeiContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shebeiDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public ShebeiOrderView() {

	}

	public ShebeiOrderView(ShebeiOrderEntity shebeiOrderEntity) {
		try {
			BeanUtils.copyProperties(this, shebeiOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getShebeiOrderValue() {
		return shebeiOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setShebeiOrderValue(String shebeiOrderValue) {
		this.shebeiOrderValue = shebeiOrderValue;
	}
	//当前表的
	/**
	* 获取： 支付类型的值
	*/
	public String getShebeiOrderPaymentValue() {
		return shebeiOrderPaymentValue;
	}
	/**
	* 设置： 支付类型的值
	*/
	public void setShebeiOrderPaymentValue(String shebeiOrderPaymentValue) {
		this.shebeiOrderPaymentValue = shebeiOrderPaymentValue;
	}
	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getShebeiOrderYesnoValue() {
		return shebeiOrderYesnoValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setShebeiOrderYesnoValue(String shebeiOrderYesnoValue) {
		this.shebeiOrderYesnoValue = shebeiOrderYesnoValue;
	}


	//级联表的get和set 收货地址
		/**
		* 获取：收货地址 的 创建用户
		*/
		public Integer getAddressYonghuId() {
			return addressYonghuId;
		}
		/**
		* 设置：收货地址 的 创建用户
		*/
		public void setAddressYonghuId(Integer addressYonghuId) {
			this.addressYonghuId = addressYonghuId;
		}

		/**
		* 获取： 收货人
		*/
		public String getAddressName() {
			return addressName;
		}
		/**
		* 设置： 收货人
		*/
		public void setAddressName(String addressName) {
			this.addressName = addressName;
		}

		/**
		* 获取： 电话
		*/
		public String getAddressPhone() {
			return addressPhone;
		}
		/**
		* 设置： 电话
		*/
		public void setAddressPhone(String addressPhone) {
			this.addressPhone = addressPhone;
		}

		/**
		* 获取： 地址
		*/
		public String getAddressDizhi() {
			return addressDizhi;
		}
		/**
		* 设置： 地址
		*/
		public void setAddressDizhi(String addressDizhi) {
			this.addressDizhi = addressDizhi;
		}
		/**
		* 获取： 是否默认地址
		*/
		public Integer getIsdefaultTypes() {
			return isdefaultTypes;
		}
		/**
		* 设置： 是否默认地址
		*/
		public void setIsdefaultTypes(Integer isdefaultTypes) {
			this.isdefaultTypes = isdefaultTypes;
		}


			/**
			* 获取： 是否默认地址的值
			*/
			public String getIsdefaultValue() {
				return isdefaultValue;
			}
			/**
			* 设置： 是否默认地址的值
			*/
			public void setIsdefaultValue(String isdefaultValue) {
				this.isdefaultValue = isdefaultValue;
			}
	//级联表的get和set 设备

		/**
		* 获取： 设备名称
		*/
		public String getShebeiName() {
			return shebeiName;
		}
		/**
		* 设置： 设备名称
		*/
		public void setShebeiName(String shebeiName) {
			this.shebeiName = shebeiName;
		}

		/**
		* 获取： 设备编号
		*/
		public String getShebeiUuidNumber() {
			return shebeiUuidNumber;
		}
		/**
		* 设置： 设备编号
		*/
		public void setShebeiUuidNumber(String shebeiUuidNumber) {
			this.shebeiUuidNumber = shebeiUuidNumber;
		}

		/**
		* 获取： 设备照片
		*/
		public String getShebeiPhoto() {
			return shebeiPhoto;
		}
		/**
		* 设置： 设备照片
		*/
		public void setShebeiPhoto(String shebeiPhoto) {
			this.shebeiPhoto = shebeiPhoto;
		}
		/**
		* 获取： 设备类型
		*/
		public Integer getShebeiTypes() {
			return shebeiTypes;
		}
		/**
		* 设置： 设备类型
		*/
		public void setShebeiTypes(Integer shebeiTypes) {
			this.shebeiTypes = shebeiTypes;
		}


			/**
			* 获取： 设备类型的值
			*/
			public String getShebeiValue() {
				return shebeiValue;
			}
			/**
			* 设置： 设备类型的值
			*/
			public void setShebeiValue(String shebeiValue) {
				this.shebeiValue = shebeiValue;
			}

		/**
		* 获取： 设备库存
		*/
		public Integer getShebeiKucunNumber() {
			return shebeiKucunNumber;
		}
		/**
		* 设置： 设备库存
		*/
		public void setShebeiKucunNumber(Integer shebeiKucunNumber) {
			this.shebeiKucunNumber = shebeiKucunNumber;
		}

		/**
		* 获取： 租赁原价/天
		*/
		public Double getShebeiOldMoney() {
			return shebeiOldMoney;
		}
		/**
		* 设置： 租赁原价/天
		*/
		public void setShebeiOldMoney(Double shebeiOldMoney) {
			this.shebeiOldMoney = shebeiOldMoney;
		}

		/**
		* 获取： 租赁现价/天
		*/
		public Double getShebeiNewMoney() {
			return shebeiNewMoney;
		}
		/**
		* 设置： 租赁现价/天
		*/
		public void setShebeiNewMoney(Double shebeiNewMoney) {
			this.shebeiNewMoney = shebeiNewMoney;
		}

		/**
		* 获取： 设备热度
		*/
		public Integer getShebeiClicknum() {
			return shebeiClicknum;
		}
		/**
		* 设置： 设备热度
		*/
		public void setShebeiClicknum(Integer shebeiClicknum) {
			this.shebeiClicknum = shebeiClicknum;
		}

		/**
		* 获取： 设备介绍
		*/
		public String getShebeiContent() {
			return shebeiContent;
		}
		/**
		* 设置： 设备介绍
		*/
		public void setShebeiContent(String shebeiContent) {
			this.shebeiContent = shebeiContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShebeiDelete() {
			return shebeiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShebeiDelete(Integer shebeiDelete) {
			this.shebeiDelete = shebeiDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}


	@Override
	public String toString() {
		return "ShebeiOrderView{" +
			", shebeiOrderValue=" + shebeiOrderValue +
			", shebeiOrderPaymentValue=" + shebeiOrderPaymentValue +
			", shebeiOrderYesnoValue=" + shebeiOrderYesnoValue +
			", addressName=" + addressName +
			", addressPhone=" + addressPhone +
			", addressDizhi=" + addressDizhi +
			", shebeiName=" + shebeiName +
			", shebeiUuidNumber=" + shebeiUuidNumber +
			", shebeiPhoto=" + shebeiPhoto +
			", shebeiKucunNumber=" + shebeiKucunNumber +
			", shebeiOldMoney=" + shebeiOldMoney +
			", shebeiNewMoney=" + shebeiNewMoney +
			", shebeiClicknum=" + shebeiClicknum +
			", shebeiContent=" + shebeiContent +
			", shebeiDelete=" + shebeiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
