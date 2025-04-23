package com.entity.view;

import com.entity.XueshengliuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xueshengliuyan")
public class XueshengliuyanView extends XueshengliuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 laoshi
			/**
			* 老师姓名
			*/
			private String laoshiName;
			/**
			* 老师手机号
			*/
			private String laoshiPhone;
			/**
			* 老师身份证号
			*/
			private String laoshiIdNumber;
			/**
			* 老师头像
			*/
			private String laoshiPhoto;
			/**
			* 是否在校
			*/
			private Integer laoshizaixiaoTypes;
				/**
				* 是否在校的值
				*/
				private String laoshizaixiaoValue;
			/**
			* 电子邮箱
			*/
			private String laoshiEmail;

		//级联表 xuesheng
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 是否在校
			*/
			private Integer xueshengzaixiaoTypes;
				/**
				* 是否在校的值
				*/
				private String xueshengzaixiaoValue;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;

	public XueshengliuyanView() {

	}

	public XueshengliuyanView(XueshengliuyanEntity xueshengliuyanEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengliuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















				//级联表的get和set laoshi


					/**
					* 获取： 老师姓名
					*/
					public String getLaoshiName() {
						return laoshiName;
					}
					/**
					* 设置： 老师姓名
					*/
					public void setLaoshiName(String laoshiName) {
						this.laoshiName = laoshiName;
					}

					/**
					* 获取： 老师手机号
					*/
					public String getLaoshiPhone() {
						return laoshiPhone;
					}
					/**
					* 设置： 老师手机号
					*/
					public void setLaoshiPhone(String laoshiPhone) {
						this.laoshiPhone = laoshiPhone;
					}

					/**
					* 获取： 老师身份证号
					*/
					public String getLaoshiIdNumber() {
						return laoshiIdNumber;
					}
					/**
					* 设置： 老师身份证号
					*/
					public void setLaoshiIdNumber(String laoshiIdNumber) {
						this.laoshiIdNumber = laoshiIdNumber;
					}

					/**
					* 获取： 老师头像
					*/
					public String getLaoshiPhoto() {
						return laoshiPhoto;
					}
					/**
					* 设置： 老师头像
					*/
					public void setLaoshiPhoto(String laoshiPhoto) {
						this.laoshiPhoto = laoshiPhoto;
					}

					/**
					* 获取： 是否在校
					*/
					public Integer getLaoshizaixiaoTypes() {
						return laoshizaixiaoTypes;
					}
					/**
					* 设置： 是否在校
					*/
					public void setLaoshizaixiaoTypes(Integer laoshizaixiaoTypes) {
						this.laoshizaixiaoTypes = laoshizaixiaoTypes;
					}


						/**
						* 获取： 是否在校的值
						*/
						public String getLaoshizaixiaoValue() {
							return laoshizaixiaoValue;
						}
						/**
						* 设置： 是否在校的值
						*/
						public void setLaoshizaixiaoValue(String laoshizaixiaoValue) {
							this.laoshizaixiaoValue = laoshizaixiaoValue;
						}

					/**
					* 获取： 电子邮箱
					*/
					public String getLaoshiEmail() {
						return laoshiEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setLaoshiEmail(String laoshiEmail) {
						this.laoshiEmail = laoshiEmail;
					}

















				//级联表的get和set xuesheng


					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}

					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}

					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}

					/**
					* 获取： 是否在校
					*/
					public Integer getXueshengzaixiaoTypes() {
						return xueshengzaixiaoTypes;
					}
					/**
					* 设置： 是否在校
					*/
					public void setXueshengzaixiaoTypes(Integer xueshengzaixiaoTypes) {
						this.xueshengzaixiaoTypes = xueshengzaixiaoTypes;
					}


						/**
						* 获取： 是否在校的值
						*/
						public String getXueshengzaixiaoValue() {
							return xueshengzaixiaoValue;
						}
						/**
						* 设置： 是否在校的值
						*/
						public void setXueshengzaixiaoValue(String xueshengzaixiaoValue) {
							this.xueshengzaixiaoValue = xueshengzaixiaoValue;
						}

					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}













}
