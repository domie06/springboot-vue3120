package com.entity.vo;

import com.entity.XueshengdakaEntity;
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
@TableName("xueshengdaka")
public class XueshengdakaVO implements Serializable {
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
     * 打卡状态
     */

    @TableField(value = "xueshengdaka_zhuangtai_types")
    private Integer xueshengdakaZhuangtaiTypes;


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

    @TableField(value = "xueshengdaka_content")
    private String xueshengdakaContent;


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

}
