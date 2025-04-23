package com.entity.model;

import com.entity.QingjiashenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生请假申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QingjiashenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 申请编号
     */
    private String qingjiashenqingUuidNumber;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 请假开始日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qingjiashenqingKaishiTime;


    /**
     * 请假结束日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qingjiashenqingJieshuTime;


    /**
     * 申请理由
     */
    private String qingjiashenqingContent;


    /**
     * 审核状态
     */
    private Integer qingjiashenqingYesnoTypes;


    /**
     * 审核意见
     */
    private String qingjiashenqingYesnoText;


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
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 设置：学生
	 */
    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：申请编号
	 */
    public String getQingjiashenqingUuidNumber() {
        return qingjiashenqingUuidNumber;
    }


    /**
	 * 设置：申请编号
	 */
    public void setQingjiashenqingUuidNumber(String qingjiashenqingUuidNumber) {
        this.qingjiashenqingUuidNumber = qingjiashenqingUuidNumber;
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
	 * 获取：请假开始日期
	 */
    public Date getQingjiashenqingKaishiTime() {
        return qingjiashenqingKaishiTime;
    }


    /**
	 * 设置：请假开始日期
	 */
    public void setQingjiashenqingKaishiTime(Date qingjiashenqingKaishiTime) {
        this.qingjiashenqingKaishiTime = qingjiashenqingKaishiTime;
    }
    /**
	 * 获取：请假结束日期
	 */
    public Date getQingjiashenqingJieshuTime() {
        return qingjiashenqingJieshuTime;
    }


    /**
	 * 设置：请假结束日期
	 */
    public void setQingjiashenqingJieshuTime(Date qingjiashenqingJieshuTime) {
        this.qingjiashenqingJieshuTime = qingjiashenqingJieshuTime;
    }
    /**
	 * 获取：申请理由
	 */
    public String getQingjiashenqingContent() {
        return qingjiashenqingContent;
    }


    /**
	 * 设置：申请理由
	 */
    public void setQingjiashenqingContent(String qingjiashenqingContent) {
        this.qingjiashenqingContent = qingjiashenqingContent;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getQingjiashenqingYesnoTypes() {
        return qingjiashenqingYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setQingjiashenqingYesnoTypes(Integer qingjiashenqingYesnoTypes) {
        this.qingjiashenqingYesnoTypes = qingjiashenqingYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getQingjiashenqingYesnoText() {
        return qingjiashenqingYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setQingjiashenqingYesnoText(String qingjiashenqingYesnoText) {
        this.qingjiashenqingYesnoText = qingjiashenqingYesnoText;
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
