package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.FanxiaoshenqingDao;
import com.entity.FanxiaoshenqingEntity;
import com.service.FanxiaoshenqingService;
import com.entity.view.FanxiaoshenqingView;

/**
 * 学生返校申请 服务实现类
 */
@Service("fanxiaoshenqingService")
@Transactional
public class FanxiaoshenqingServiceImpl extends ServiceImpl<FanxiaoshenqingDao, FanxiaoshenqingEntity> implements FanxiaoshenqingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<FanxiaoshenqingView> page =new Query<FanxiaoshenqingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
