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
 * 打卡
 *
 * @author 
 * @email
 */
@TableName("laoshidaka")
public class LaoshidakaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LaoshidakaEntity() {

	}

	public LaoshidakaEntity(T t) {
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
     * 打卡状态
     */
    @TableField(value = "laoshidaka_zhuangtai_types")

    private Integer laoshidakaZhuangtaiTypes;


    /**
     * 打卡日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Laoshidaka{" +
            "id=" + id +
            ", laoshiId=" + laoshiId +
            ", laoshidakaZhuangtaiTypes=" + laoshidakaZhuangtaiTypes +
            ", insertTime=" + insertTime +
            ", laoshidakaContent=" + laoshidakaContent +
            ", createTime=" + createTime +
        "}";
    }
}
