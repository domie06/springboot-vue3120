package com.entity.view;

import com.entity.XueshengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xuesheng")
public class XueshengView extends XueshengEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		private String sexValue;
		/**
		* 是否在校的值
		*/
		private String xueshengzaixiaoValue;



		//级联表 diqu
			/**
			* 地区名称
			*/
			private String diquName;
			/**
			* 地址位置
			*/
			private String diquAddress;
			/**
			* 地区类型
			*/
			private Integer diquTypes;
				/**
				* 地区类型的值
				*/
				private String diquValue;
			/**
			* 风险等级
			*/
			private Integer diquZhuangtaiTypes;
				/**
				* 风险等级的值
				*/
				private String diquZhuangtaiValue;
			/**
			* 地区详情
			*/
			private String diquContent;

	public XueshengView() {

	}

	public XueshengView(XueshengEntity xueshengEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
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






				//级联表的get和set diqu

					/**
					* 获取： 地区名称
					*/
					public String getDiquName() {
						return diquName;
					}
					/**
					* 设置： 地区名称
					*/
					public void setDiquName(String diquName) {
						this.diquName = diquName;
					}

					/**
					* 获取： 地址位置
					*/
					public String getDiquAddress() {
						return diquAddress;
					}
					/**
					* 设置： 地址位置
					*/
					public void setDiquAddress(String diquAddress) {
						this.diquAddress = diquAddress;
					}

					/**
					* 获取： 地区类型
					*/
					public Integer getDiquTypes() {
						return diquTypes;
					}
					/**
					* 设置： 地区类型
					*/
					public void setDiquTypes(Integer diquTypes) {
						this.diquTypes = diquTypes;
					}


						/**
						* 获取： 地区类型的值
						*/
						public String getDiquValue() {
							return diquValue;
						}
						/**
						* 设置： 地区类型的值
						*/
						public void setDiquValue(String diquValue) {
							this.diquValue = diquValue;
						}

					/**
					* 获取： 风险等级
					*/
					public Integer getDiquZhuangtaiTypes() {
						return diquZhuangtaiTypes;
					}
					/**
					* 设置： 风险等级
					*/
					public void setDiquZhuangtaiTypes(Integer diquZhuangtaiTypes) {
						this.diquZhuangtaiTypes = diquZhuangtaiTypes;
					}


						/**
						* 获取： 风险等级的值
						*/
						public String getDiquZhuangtaiValue() {
							return diquZhuangtaiValue;
						}
						/**
						* 设置： 风险等级的值
						*/
						public void setDiquZhuangtaiValue(String diquZhuangtaiValue) {
							this.diquZhuangtaiValue = diquZhuangtaiValue;
						}

					/**
					* 获取： 地区详情
					*/
					public String getDiquContent() {
						return diquContent;
					}
					/**
					* 设置： 地区详情
					*/
					public void setDiquContent(String diquContent) {
						this.diquContent = diquContent;
					}
























}
