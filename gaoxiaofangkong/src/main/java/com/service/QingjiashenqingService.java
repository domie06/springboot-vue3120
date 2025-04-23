package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QingjiashenqingEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 学生请假申请 服务类
 */
public interface QingjiashenqingService extends IService<QingjiashenqingEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}