package com.entity.view;

import com.entity.LaoshidakaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 打卡
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("laoshidaka")
public class LaoshidakaView extends LaoshidakaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 打卡状态的值
		*/
		private String laoshidakaZhuangtaiValue;



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

	public LaoshidakaView() {

	}

	public LaoshidakaView(LaoshidakaEntity laoshidakaEntity) {
		try {
			BeanUtils.copyProperties(this, laoshidakaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 打卡状态的值
			*/
			public String getLaoshidakaZhuangtaiValue() {
				return laoshidakaZhuangtaiValue;
			}
			/**
			* 设置： 打卡状态的值
			*/
			public void setLaoshidakaZhuangtaiValue(String laoshidakaZhuangtaiValue) {
				this.laoshidakaZhuangtaiValue = laoshidakaZhuangtaiValue;
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




















}
