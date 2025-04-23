package com.dao;

import com.entity.LaoshijujiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LaoshijujiaView;

/**
 * 居家 Dao 接口
 *
 * @author 
 */
public interface LaoshijujiaDao extends BaseMapper<LaoshijujiaEntity> {

   List<LaoshijujiaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
