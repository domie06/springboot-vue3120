package com.entity.vo;

import com.entity.LaoshifanxiaoshenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 老师返校申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("laoshifanxiaoshenqing")
public class LaoshifanxiaoshenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 老师
     */

    @TableField(value = "laoshi_id")
    private Integer laoshiId;


    /**
     * 申请编号
     */

    @TableField(value = "laoshifanxiaoshenqing_uuid_number")
    private String laoshifanxiaoshenqingUuidNumber;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 申请返校日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "laoshifanxiaoshenqing_time")
    private Date laoshifanxiaoshenqingTime;


    /**
     * 健康码
     */

    @TableField(value = "jiankangma_photo")
    private String jiankangmaPhoto;


    /**
     * 行程码
     */

    @TableField(value = "xingchengma_photo")
    private String xingchengmaPhoto;


    /**
     * 核酸报告
     */

    @TableField(value = "hesuanbaogao_photo")
    private String hesuanbaogaoPhoto;


    /**
     * 申请理由
     */

    @TableField(value = "laoshifanxiaoshenqing_content")
    private String laoshifanxiaoshenqingContent;


    /**
     * 审核状态
     */

    @TableField(value = "laoshifanxiaoshenqing_yesno_types")
    private Integer laoshifanxiaoshenqingYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "laoshifanxiaoshenqing_yesno_text")
    private String laoshifanxiaoshenqingYesnoText;


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
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：申请编号
	 */
    public String getLaoshifanxiaoshenqingUuidNumber() {
        return laoshifanxiaoshenqingUuidNumber;
    }


    /**
	 * 获取：申请编号
	 */

    public void setLaoshifanxiaoshenqingUuidNumber(String laoshifanxiaoshenqingUuidNumber) {
        this.laoshifanxiaoshenqingUuidNumber = laoshifanxiaoshenqingUuidNumber;
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
	 * 设置：申请返校日期
	 */
    public Date getLaoshifanxiaoshenqingTime() {
        return laoshifanxiaoshenqingTime;
    }


    /**
	 * 获取：申请返校日期
	 */

    public void setLaoshifanxiaoshenqingTime(Date laoshifanxiaoshenqingTime) {
        this.laoshifanxiaoshenqingTime = laoshifanxiaoshenqingTime;
    }
    /**
	 * 设置：健康码
	 */
    public String getJiankangmaPhoto() {
        return jiankangmaPhoto;
    }


    /**
	 * 获取：健康码
	 */

    public void setJiankangmaPhoto(String jiankangmaPhoto) {
        this.jiankangmaPhoto = jiankangmaPhoto;
    }
    /**
	 * 设置：行程码
	 */
    public String getXingchengmaPhoto() {
        return xingchengmaPhoto;
    }


    /**
	 * 获取：行程码
	 */

    public void setXingchengmaPhoto(String xingchengmaPhoto) {
        this.xingchengmaPhoto = xingchengmaPhoto;
    }
    /**
	 * 设置：核酸报告
	 */
    public String getHesuanbaogaoPhoto() {
        return hesuanbaogaoPhoto;
    }


    /**
	 * 获取：核酸报告
	 */

    public void setHesuanbaogaoPhoto(String hesuanbaogaoPhoto) {
        this.hesuanbaogaoPhoto = hesuanbaogaoPhoto;
    }
    /**
	 * 设置：申请理由
	 */
    public String getLaoshifanxiaoshenqingContent() {
        return laoshifanxiaoshenqingContent;
    }


    /**
	 * 获取：申请理由
	 */

    public void setLaoshifanxiaoshenqingContent(String laoshifanxiaoshenqingContent) {
        this.laoshifanxiaoshenqingContent = laoshifanxiaoshenqingContent;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getLaoshifanxiaoshenqingYesnoTypes() {
        return laoshifanxiaoshenqingYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setLaoshifanxiaoshenqingYesnoTypes(Integer laoshifanxiaoshenqingYesnoTypes) {
        this.laoshifanxiaoshenqingYesnoTypes = laoshifanxiaoshenqingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getLaoshifanxiaoshenqingYesnoText() {
        return laoshifanxiaoshenqingYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setLaoshifanxiaoshenqingYesnoText(String laoshifanxiaoshenqingYesnoText) {
        this.laoshifanxiaoshenqingYesnoText = laoshifanxiaoshenqingYesnoText;
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
