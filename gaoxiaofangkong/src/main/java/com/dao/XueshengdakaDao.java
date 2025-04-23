package com.dao;

import com.entity.XueshengdakaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengdakaView;

/**
 * 打卡 Dao 接口
 *
 * @author 
 */
public interface XueshengdakaDao extends BaseMapper<XueshengdakaEntity> {

   List<XueshengdakaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
