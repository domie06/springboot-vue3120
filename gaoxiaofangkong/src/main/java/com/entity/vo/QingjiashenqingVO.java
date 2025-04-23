package com.entity.vo;

import com.entity.QingjiashenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 学生请假申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qingjiashenqing")
public class QingjiashenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生
     */

    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 申请编号
     */

    @TableField(value = "qingjiashenqing_uuid_number")
    private String qingjiashenqingUuidNumber;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 请假开始日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qingjiashenqing_kaishi_time")
    private Date qingjiashenqingKaishiTime;


    /**
     * 请假结束日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qingjiashenqing_jieshu_time")
    private Date qingjiashenqingJieshuTime;


    /**
     * 申请理由
     */

    @TableField(value = "qingjiashenqing_content")
    private String qingjiashenqingContent;


    /**
     * 审核状态
     */

    @TableField(value = "qingjiashenqing_yesno_types")
    private Integer qingjiashenqingYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "qingjiashenqing_yesno_text")
    private String qingjiashenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "update_time")
    private Date updateTime;


    /**
     * 创建时间
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
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：申请编号
	 */
    public String getQingjiashenqingUuidNumber() {
        return qingjiashenqingUuidNumber;
    }


    /**
	 * 获取：申请编号
	 */

    public void setQingjiashenqingUuidNumber(String qingjiashenqingUuidNumber) {
        this.qingjiashenqingUuidNumber = qingjiashenqingUuidNumber;
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
	 * 设置：请假开始日期
	 */
    public Date getQingjiashenqingKaishiTime() {
        return qingjiashenqingKaishiTime;
    }


    /**
	 * 获取：请假开始日期
	 */

    public void setQingjiashenqingKaishiTime(Date qingjiashenqingKaishiTime) {
        this.qingjiashenqingKaishiTime = qingjiashenqingKaishiTime;
    }
    /**
	 * 设置：请假结束日期
	 */
    public Date getQingjiashenqingJieshuTime() {
        return qingjiashenqingJieshuTime;
    }


    /**
	 * 获取：请假结束日期
	 */

    public void setQingjiashenqingJieshuTime(Date qingjiashenqingJieshuTime) {
        this.qingjiashenqingJieshuTime = qingjiashenqingJieshuTime;
    }
    /**
	 * 设置：申请理由
	 */
    public String getQingjiashenqingContent() {
        return qingjiashenqingContent;
    }


    /**
	 * 获取：申请理由
	 */

    public void setQingjiashenqingContent(String qingjiashenqingContent) {
        this.qingjiashenqingContent = qingjiashenqingContent;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getQingjiashenqingYesnoTypes() {
        return qingjiashenqingYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setQingjiashenqingYesnoTypes(Integer qingjiashenqingYesnoTypes) {
        this.qingjiashenqingYesnoTypes = qingjiashenqingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getQingjiashenqingYesnoText() {
        return qingjiashenqingYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setQingjiashenqingYesnoText(String qingjiashenqingYesnoText) {
        this.qingjiashenqingYesnoText = qingjiashenqingYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
