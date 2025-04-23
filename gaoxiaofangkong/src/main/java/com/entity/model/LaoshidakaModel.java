package com.entity.model;

import com.entity.LaoshidakaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 打卡
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LaoshidakaModel implements Serializable {
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
     * 打卡状态
     */
    private Integer laoshidakaZhuangtaiTypes;


    /**
     * 打卡日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 打卡备注
     */
    private String laoshidakaContent;


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
	 * 获取：打卡状态
	 */
    public Integer getLaoshidakaZhuangtaiTypes() {
        return laoshidakaZhuangtaiTypes;
    }


    /**
	 * 设置：打卡状态
	 */
    public void setLaoshidakaZhuangtaiTypes(Integer laoshidakaZhuangtaiTypes) {
        this.laoshidakaZhuangtaiTypes = laoshidakaZhuangtaiTypes;
    }
    /**
	 * 获取：打卡日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：打卡日期
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：打卡备注
	 */
    public String getLaoshidakaContent() {
        return laoshidakaContent;
    }


    /**
	 * 设置：打卡备注
	 */
    public void setLaoshidakaContent(String laoshidakaContent) {
        this.laoshidakaContent = laoshidakaContent;
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
