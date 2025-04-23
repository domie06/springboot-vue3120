package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 居家
 *
 * @author 
 * @email
 */
@TableName("laoshijujia")
public class LaoshijujiaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LaoshijujiaEntity() {

	}

	public LaoshijujiaEntity(T t) {
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
    @TableField(value = "id")

    private Integer id;


    /**
     * 老师
     */
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 居家状态
     */
    @TableField(value = "laoshijujia_zhuangtai_types")

    private Integer laoshijujiaZhuangtaiTypes;


    /**
     * 居家日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "jujia_time")

    private Date jujiaTime;


    /**
     * 居家位置
     */
    @TableField(value = "xueshengjujia_address")

    private String xueshengjujiaAddress;


    /**
     * 居家备注
     */
    @TableField(value = "laoshijujia_content")

    private String laoshijujiaContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：居家状态
	 */
    public Integer getLaoshijujiaZhuangtaiTypes() {
        return laoshijujiaZhuangtaiTypes;
    }
    /**
	 * 获取：居家状态
	 */

    public void setLaoshijujiaZhuangtaiTypes(Integer laoshijujiaZhuangtaiTypes) {
        this.laoshijujiaZhuangtaiTypes = laoshijujiaZhuangtaiTypes;
    }
    /**
	 * 设置：居家日期
	 */
    public Date getJujiaTime() {
        return jujiaTime;
    }
    /**
	 * 获取：居家日期
	 */

    public void setJujiaTime(Date jujiaTime) {
        this.jujiaTime = jujiaTime;
    }
    /**
	 * 设置：居家位置
	 */
    public String getXueshengjujiaAddress() {
        return xueshengjujiaAddress;
    }
    /**
	 * 获取：居家位置
	 */

    public void setXueshengjujiaAddress(String xueshengjujiaAddress) {
        this.xueshengjujiaAddress = xueshengjujiaAddress;
    }
    /**
	 * 设置：居家备注
	 */
    public String getLaoshijujiaContent() {
        return laoshijujiaContent;
    }
    /**
	 * 获取：居家备注
	 */

    public void setLaoshijujiaContent(String laoshijujiaContent) {
        this.laoshijujiaContent = laoshijujiaContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

    @Override
    public String toString() {
        return "Laoshijujia{" +
            "id=" + id +
            ", laoshiId=" + laoshiId +
            ", laoshijujiaZhuangtaiTypes=" + laoshijujiaZhuangtaiTypes +
            ", jujiaTime=" + jujiaTime +
            ", xueshengjujiaAddress=" + xueshengjujiaAddress +
            ", laoshijujiaContent=" + laoshijujiaContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
