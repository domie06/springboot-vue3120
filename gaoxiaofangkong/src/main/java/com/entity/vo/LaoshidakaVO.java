package com.entity.vo;

import com.entity.LaoshidakaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 打卡
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("laoshidaka")
public class LaoshidakaVO implements Serializable {
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
     * 打卡状态
     */

    @TableField(value = "laoshidaka_zhuangtai_types")
    private Integer laoshidakaZhuangtaiTypes;


    /**
     * 打卡日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 打卡备注
     */

    @TableField(value = "laoshidaka_content")
    private String laoshidakaContent;


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
	 * 设置：打卡状态
	 */
    public Integer getLaoshidakaZhuangtaiTypes() {
        return laoshidakaZhuangtaiTypes;
    }


    /**
	 * 获取：打卡状态
	 */

    public void setLaoshidakaZhuangtaiTypes(Integer laoshidakaZhuangtaiTypes) {
        this.laoshidakaZhuangtaiTypes = laoshidakaZhuangtaiTypes;
    }
    /**
	 * 设置：打卡日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：打卡日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：打卡备注
	 */
    public String getLaoshidakaContent() {
        return laoshidakaContent;
    }


    /**
	 * 获取：打卡备注
	 */

    public void setLaoshidakaContent(String laoshidakaContent) {
        this.laoshidakaContent = laoshidakaContent;
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
