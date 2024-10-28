package com.entity.model;

import com.entity.ShebeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 设备
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShebeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 设备名称
     */
    private String shebeiName;


    /**
     * 设备编号
     */
    private String shebeiUuidNumber;


    /**
     * 设备照片
     */
    private String shebeiPhoto;


    /**
     * 设备类型
     */
    private Integer shebeiTypes;


    /**
     * 设备库存
     */
    private Integer shebeiKucunNumber;


    /**
     * 租赁原价/天
     */
    private Double shebeiOldMoney;


    /**
     * 租赁现价/天
     */
    private Double shebeiNewMoney;


    /**
     * 设备热度
     */
    private Integer shebeiClicknum;


    /**
     * 设备介绍
     */
    private String shebeiContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer shebeiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：设备名称
	 */
    public String getShebeiName() {
        return shebeiName;
    }


    /**
	 * 设置：设备名称
	 */
    public void setShebeiName(String shebeiName) {
        this.shebeiName = shebeiName;
    }
    /**
	 * 获取：设备编号
	 */
    public String getShebeiUuidNumber() {
        return shebeiUuidNumber;
    }


    /**
	 * 设置：设备编号
	 */
    public void setShebeiUuidNumber(String shebeiUuidNumber) {
        this.shebeiUuidNumber = shebeiUuidNumber;
    }
    /**
	 * 获取：设备照片
	 */
    public String getShebeiPhoto() {
        return shebeiPhoto;
    }


    /**
	 * 设置：设备照片
	 */
    public void setShebeiPhoto(String shebeiPhoto) {
        this.shebeiPhoto = shebeiPhoto;
    }
    /**
	 * 获取：设备类型
	 */
    public Integer getShebeiTypes() {
        return shebeiTypes;
    }


    /**
	 * 设置：设备类型
	 */
    public void setShebeiTypes(Integer shebeiTypes) {
        this.shebeiTypes = shebeiTypes;
    }
    /**
	 * 获取：设备库存
	 */
    public Integer getShebeiKucunNumber() {
        return shebeiKucunNumber;
    }


    /**
	 * 设置：设备库存
	 */
    public void setShebeiKucunNumber(Integer shebeiKucunNumber) {
        this.shebeiKucunNumber = shebeiKucunNumber;
    }
    /**
	 * 获取：租赁原价/天
	 */
    public Double getShebeiOldMoney() {
        return shebeiOldMoney;
    }


    /**
	 * 设置：租赁原价/天
	 */
    public void setShebeiOldMoney(Double shebeiOldMoney) {
        this.shebeiOldMoney = shebeiOldMoney;
    }
    /**
	 * 获取：租赁现价/天
	 */
    public Double getShebeiNewMoney() {
        return shebeiNewMoney;
    }


    /**
	 * 设置：租赁现价/天
	 */
    public void setShebeiNewMoney(Double shebeiNewMoney) {
        this.shebeiNewMoney = shebeiNewMoney;
    }
    /**
	 * 获取：设备热度
	 */
    public Integer getShebeiClicknum() {
        return shebeiClicknum;
    }


    /**
	 * 设置：设备热度
	 */
    public void setShebeiClicknum(Integer shebeiClicknum) {
        this.shebeiClicknum = shebeiClicknum;
    }
    /**
	 * 获取：设备介绍
	 */
    public String getShebeiContent() {
        return shebeiContent;
    }


    /**
	 * 设置：设备介绍
	 */
    public void setShebeiContent(String shebeiContent) {
        this.shebeiContent = shebeiContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShebeiDelete() {
        return shebeiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setShebeiDelete(Integer shebeiDelete) {
        this.shebeiDelete = shebeiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
