package com.entity.model;

import com.entity.LaoshijujiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 居家
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LaoshijujiaModel implements Serializable {
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
     * 居家状态
     */
    private Integer laoshijujiaZhuangtaiTypes;


    /**
     * 居家日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jujiaTime;


    /**
     * 居家位置
     */
    private String xueshengjujiaAddress;


    /**
     * 居家备注
     */
    private String laoshijujiaContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：居家状态
	 */
    public Integer getLaoshijujiaZhuangtaiTypes() {
        return laoshijujiaZhuangtaiTypes;
    }


    /**
	 * 设置：居家状态
	 */
    public void setLaoshijujiaZhuangtaiTypes(Integer laoshijujiaZhuangtaiTypes) {
        this.laoshijujiaZhuangtaiTypes = laoshijujiaZhuangtaiTypes;
    }
    /**
	 * 获取：居家日期
	 */
    public Date getJujiaTime() {
        return jujiaTime;
    }


    /**
	 * 设置：居家日期
	 */
    public void setJujiaTime(Date jujiaTime) {
        this.jujiaTime = jujiaTime;
    }
    /**
	 * 获取：居家位置
	 */
    public String getXueshengjujiaAddress() {
        return xueshengjujiaAddress;
    }


    /**
	 * 设置：居家位置
	 */
    public void setXueshengjujiaAddress(String xueshengjujiaAddress) {
        this.xueshengjujiaAddress = xueshengjujiaAddress;
    }
    /**
	 * 获取：居家备注
	 */
    public String getLaoshijujiaContent() {
        return laoshijujiaContent;
    }


    /**
	 * 设置：居家备注
	 */
    public void setLaoshijujiaContent(String laoshijujiaContent) {
        this.laoshijujiaContent = laoshijujiaContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
