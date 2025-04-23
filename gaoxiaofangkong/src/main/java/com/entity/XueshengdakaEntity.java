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
@TableName("xueshengdaka")
public class XueshengdakaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengdakaEntity() {

	}

	public XueshengdakaEntity(T t) {
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
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 打卡状态
     */
    @TableField(value = "xueshengdaka_zhuangtai_types")

    private Integer xueshengdakaZhuangtaiTypes;


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
    @TableField(value = "xueshengdaka_content")

    private String xueshengdakaContent;


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
	 * 设置：打卡状态
	 */
    public Integer getXueshengdakaZhuangtaiTypes() {
        return xueshengdakaZhuangtaiTypes;
    }
    /**
	 * 获取：打卡状态
	 */

    public void setXueshengdakaZhuangtaiTypes(Integer xueshengdakaZhuangtaiTypes) {
        this.xueshengdakaZhuangtaiTypes = xueshengdakaZhuangtaiTypes;
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
    public String getXueshengdakaContent() {
        return xueshengdakaContent;
    }
    /**
	 * 获取：打卡备注
	 */

    public void setXueshengdakaContent(String xueshengdakaContent) {
        this.xueshengdakaContent = xueshengdakaContent;
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
        return "Xueshengdaka{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", xueshengdakaZhuangtaiTypes=" + xueshengdakaZhuangtaiTypes +
            ", insertTime=" + insertTime +
            ", xueshengdakaContent=" + xueshengdakaContent +
            ", createTime=" + createTime +
        "}";
    }
}
