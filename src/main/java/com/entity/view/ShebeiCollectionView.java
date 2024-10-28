package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShebeiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 设备收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shebei_collection")
public class ShebeiCollectionView extends ShebeiCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String shebeiCollectionValue;

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



	public ShebeiCollectionView() {

	}

	public ShebeiCollectionView(ShebeiCollectionEntity shebeiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, shebeiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getShebeiCollectionValue() {
		return shebeiCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setShebeiCollectionValue(String shebeiCollectionValue) {
		this.shebeiCollectionValue = shebeiCollectionValue;
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
		return "ShebeiCollectionView{" +
			", shebeiCollectionValue=" + shebeiCollectionValue +
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
