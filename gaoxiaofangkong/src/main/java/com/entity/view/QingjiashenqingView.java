package com.entity.view;

import com.entity.QingjiashenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生请假申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("qingjiashenqing")
public class QingjiashenqingView extends QingjiashenqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 审核状态的值
		*/
		private String qingjiashenqingYesnoValue;



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

	public QingjiashenqingView() {

	}

	public QingjiashenqingView(QingjiashenqingEntity qingjiashenqingEntity) {
		try {
			BeanUtils.copyProperties(this, qingjiashenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 审核状态的值
			*/
			public String getQingjiashenqingYesnoValue() {
				return qingjiashenqingYesnoValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setQingjiashenqingYesnoValue(String qingjiashenqingYesnoValue) {
				this.qingjiashenqingYesnoValue = qingjiashenqingYesnoValue;
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
