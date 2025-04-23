package com.dao;

import com.entity.LaoshifanxiaoshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LaoshifanxiaoshenqingView;

/**
 * 老师返校申请 Dao 接口
 *
 * @author 
 */
public interface LaoshifanxiaoshenqingDao extends BaseMapper<LaoshifanxiaoshenqingEntity> {

   List<LaoshifanxiaoshenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
