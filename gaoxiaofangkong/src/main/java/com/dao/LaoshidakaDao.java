package com.dao;

import com.entity.LaoshidakaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LaoshidakaView;

/**
 * 打卡 Dao 接口
 *
 * @author 
 */
public interface LaoshidakaDao extends BaseMapper<LaoshidakaEntity> {

   List<LaoshidakaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
