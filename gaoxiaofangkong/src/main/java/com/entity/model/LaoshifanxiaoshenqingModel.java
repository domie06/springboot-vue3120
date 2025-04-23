package com.entity.model;

import com.entity.LaoshifanxiaoshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 老师返校申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LaoshifanxiaoshenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 申请编号
     */
    private String laoshifanxiaoshenqingUuidNumber;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 申请返校日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date laoshifanxiaoshenqingTime;


    /**
     * 健康码
     */
    private String jiankangmaPhoto;


    /**
     * 行程码
     */
    private String xingchengmaPhoto;


    /**
     * 核酸报告
     */
    private String hesuanbaogaoPhoto;


    /**
     * 申请理由
     */
    private String laoshifanxiaoshenqingContent;


    /**
     * 审核状态
     */
    private Integer laoshifanxiaoshenqingYesnoTypes;


    /**
     * 审核意见
     */
    private String laoshifanxiaoshenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


    /**
     * 创建时间
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
	 * 获取：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：老师
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：申请编号
	 */
    public String getLaoshifanxiaoshenqingUuidNumber() {
        return laoshifanxiaoshenqingUuidNumber;
    }


    /**
	 * 设置：申请编号
	 */
    public void setLaoshifanxiaoshenqingUuidNumber(String laoshifanxiaoshenqingUuidNumber) {
        this.laoshifanxiaoshenqingUuidNumber = laoshifanxiaoshenqingUuidNumber;
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
	 * 获取：申请返校日期
	 */
    public Date getLaoshifanxiaoshenqingTime() {
        return laoshifanxiaoshenqingTime;
    }


    /**
	 * 设置：申请返校日期
	 */
    public void setLaoshifanxiaoshenqingTime(Date laoshifanxiaoshenqingTime) {
        this.laoshifanxiaoshenqingTime = laoshifanxiaoshenqingTime;
    }
    /**
	 * 获取：健康码
	 */
    public String getJiankangmaPhoto() {
        return jiankangmaPhoto;
    }


    /**
	 * 设置：健康码
	 */
    public void setJiankangmaPhoto(String jiankangmaPhoto) {
        this.jiankangmaPhoto = jiankangmaPhoto;
    }
    /**
	 * 获取：行程码
	 */
    public String getXingchengmaPhoto() {
        return xingchengmaPhoto;
    }


    /**
	 * 设置：行程码
	 */
    public void setXingchengmaPhoto(String xingchengmaPhoto) {
        this.xingchengmaPhoto = xingchengmaPhoto;
    }
    /**
	 * 获取：核酸报告
	 */
    public String getHesuanbaogaoPhoto() {
        return hesuanbaogaoPhoto;
    }


    /**
	 * 设置：核酸报告
	 */
    public void setHesuanbaogaoPhoto(String hesuanbaogaoPhoto) {
        this.hesuanbaogaoPhoto = hesuanbaogaoPhoto;
    }
    /**
	 * 获取：申请理由
	 */
    public String getLaoshifanxiaoshenqingContent() {
        return laoshifanxiaoshenqingContent;
    }


    /**
	 * 设置：申请理由
	 */
    public void setLaoshifanxiaoshenqingContent(String laoshifanxiaoshenqingContent) {
        this.laoshifanxiaoshenqingContent = laoshifanxiaoshenqingContent;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getLaoshifanxiaoshenqingYesnoTypes() {
        return laoshifanxiaoshenqingYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setLaoshifanxiaoshenqingYesnoTypes(Integer laoshifanxiaoshenqingYesnoTypes) {
        this.laoshifanxiaoshenqingYesnoTypes = laoshifanxiaoshenqingYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getLaoshifanxiaoshenqingYesnoText() {
        return laoshifanxiaoshenqingYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setLaoshifanxiaoshenqingYesnoText(String laoshifanxiaoshenqingYesnoText) {
        this.laoshifanxiaoshenqingYesnoText = laoshifanxiaoshenqingYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
