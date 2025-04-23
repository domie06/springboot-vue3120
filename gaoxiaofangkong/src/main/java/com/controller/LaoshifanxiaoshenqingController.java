
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 老师返校申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/laoshifanxiaoshenqing")
public class LaoshifanxiaoshenqingController {
    private static final Logger logger = LoggerFactory.getLogger(LaoshifanxiaoshenqingController.class);

    @Autowired
    private LaoshifanxiaoshenqingService laoshifanxiaoshenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private LaoshiService laoshiService;

    @Autowired
    private XueshengService xueshengService;


    @Autowired
    private DiquService diquService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = laoshifanxiaoshenqingService.queryPage(params);

        //字典表数据转换
        List<LaoshifanxiaoshenqingView> list =(List<LaoshifanxiaoshenqingView>)page.getList();
        for(LaoshifanxiaoshenqingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LaoshifanxiaoshenqingEntity laoshifanxiaoshenqing = laoshifanxiaoshenqingService.selectById(id);
        if(laoshifanxiaoshenqing !=null){
            //entity转view
            LaoshifanxiaoshenqingView view = new LaoshifanxiaoshenqingView();
            BeanUtils.copyProperties( laoshifanxiaoshenqing , view );//把实体数据重构到view中

                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(laoshifanxiaoshenqing.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LaoshifanxiaoshenqingEntity laoshifanxiaoshenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,laoshifanxiaoshenqing:{}",this.getClass().getName(),laoshifanxiaoshenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老师".equals(role))
            laoshifanxiaoshenqing.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<LaoshifanxiaoshenqingEntity> queryWrapper = new EntityWrapper<LaoshifanxiaoshenqingEntity>()
            .eq("laoshi_id", laoshifanxiaoshenqing.getLaoshiId())
            .eq("laoshifanxiaoshenqing_uuid_number", laoshifanxiaoshenqing.getLaoshifanxiaoshenqingUuidNumber())
            .eq("laoshifanxiaoshenqing_time", new SimpleDateFormat("yyyy-MM-dd").format(laoshifanxiaoshenqing.getLaoshifanxiaoshenqingTime()))
            .eq("laoshifanxiaoshenqing_yesno_types", laoshifanxiaoshenqing.getLaoshifanxiaoshenqingYesnoTypes())
            .eq("laoshifanxiaoshenqing_yesno_text", laoshifanxiaoshenqing.getLaoshifanxiaoshenqingYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaoshifanxiaoshenqingEntity laoshifanxiaoshenqingEntity = laoshifanxiaoshenqingService.selectOne(queryWrapper);
        if(laoshifanxiaoshenqingEntity==null){


            LaoshiEntity laoshiEntity = laoshiService.selectById(laoshifanxiaoshenqing.getLaoshiId());
            DiquEntity diquEntity = diquService.selectById(laoshiEntity.getDiquId());
            if(diquEntity.getDiquZhuangtaiTypes() != 1){
                laoshifanxiaoshenqing.setLaoshifanxiaoshenqingYesnoTypes(3);
                laoshifanxiaoshenqing.setLaoshifanxiaoshenqingYesnoText("当前老师在中高风险地区 不同意返校申请");
                laoshifanxiaoshenqing.setUpdateTime(new Date());
            }else{
                laoshifanxiaoshenqing.setLaoshifanxiaoshenqingYesnoTypes(1);
            }


            laoshifanxiaoshenqing.setInsertTime(new Date());
            laoshifanxiaoshenqing.setCreateTime(new Date());
            laoshifanxiaoshenqingService.insert(laoshifanxiaoshenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LaoshifanxiaoshenqingEntity laoshifanxiaoshenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,laoshifanxiaoshenqing:{}",this.getClass().getName(),laoshifanxiaoshenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老师".equals(role))
//            laoshifanxiaoshenqing.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<LaoshifanxiaoshenqingEntity> queryWrapper = new EntityWrapper<LaoshifanxiaoshenqingEntity>()
            .notIn("id",laoshifanxiaoshenqing.getId())
            .andNew()
            .eq("laoshi_id", laoshifanxiaoshenqing.getLaoshiId())
            .eq("laoshifanxiaoshenqing_uuid_number", laoshifanxiaoshenqing.getLaoshifanxiaoshenqingUuidNumber())
            .eq("insert_time", laoshifanxiaoshenqing.getInsertTime())
            .eq("laoshifanxiaoshenqing_time", laoshifanxiaoshenqing.getLaoshifanxiaoshenqingTime())
            .eq("laoshifanxiaoshenqing_yesno_types", laoshifanxiaoshenqing.getLaoshifanxiaoshenqingYesnoTypes())
            .eq("laoshifanxiaoshenqing_yesno_text", laoshifanxiaoshenqing.getLaoshifanxiaoshenqingYesnoText())
            .eq("update_time", laoshifanxiaoshenqing.getUpdateTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaoshifanxiaoshenqingEntity laoshifanxiaoshenqingEntity = laoshifanxiaoshenqingService.selectOne(queryWrapper);
        if("".equals(laoshifanxiaoshenqing.getJiankangmaPhoto()) || "null".equals(laoshifanxiaoshenqing.getJiankangmaPhoto())){
                laoshifanxiaoshenqing.setJiankangmaPhoto(null);
        }
        if("".equals(laoshifanxiaoshenqing.getXingchengmaPhoto()) || "null".equals(laoshifanxiaoshenqing.getXingchengmaPhoto())){
                laoshifanxiaoshenqing.setXingchengmaPhoto(null);
        }
        if("".equals(laoshifanxiaoshenqing.getHesuanbaogaoPhoto()) || "null".equals(laoshifanxiaoshenqing.getHesuanbaogaoPhoto())){
                laoshifanxiaoshenqing.setHesuanbaogaoPhoto(null);
        }
        laoshifanxiaoshenqing.setUpdateTime(new Date());
        if(laoshifanxiaoshenqingEntity==null){
            laoshifanxiaoshenqingService.updateById(laoshifanxiaoshenqing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        laoshifanxiaoshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<LaoshifanxiaoshenqingEntity> laoshifanxiaoshenqingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            LaoshifanxiaoshenqingEntity laoshifanxiaoshenqingEntity = new LaoshifanxiaoshenqingEntity();
//                            laoshifanxiaoshenqingEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            laoshifanxiaoshenqingEntity.setLaoshifanxiaoshenqingUuidNumber(data.get(0));                    //申请编号 要改的
//                            laoshifanxiaoshenqingEntity.setInsertTime(date);//时间
//                            laoshifanxiaoshenqingEntity.setLaoshifanxiaoshenqingTime(sdf.parse(data.get(0)));          //申请返校日期 要改的
//                            laoshifanxiaoshenqingEntity.setJiankangmaPhoto("");//详情和图片
//                            laoshifanxiaoshenqingEntity.setXingchengmaPhoto("");//详情和图片
//                            laoshifanxiaoshenqingEntity.setHesuanbaogaoPhoto("");//详情和图片
//                            laoshifanxiaoshenqingEntity.setLaoshifanxiaoshenqingContent("");//详情和图片
//                            laoshifanxiaoshenqingEntity.setLaoshifanxiaoshenqingYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            laoshifanxiaoshenqingEntity.setLaoshifanxiaoshenqingYesnoText(data.get(0));                    //审核意见 要改的
//                            laoshifanxiaoshenqingEntity.setUpdateTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            laoshifanxiaoshenqingEntity.setCreateTime(date);//时间
                            laoshifanxiaoshenqingList.add(laoshifanxiaoshenqingEntity);


                            //把要查询是否重复的字段放入map中
                                //申请编号
                                if(seachFields.containsKey("laoshifanxiaoshenqingUuidNumber")){
                                    List<String> laoshifanxiaoshenqingUuidNumber = seachFields.get("laoshifanxiaoshenqingUuidNumber");
                                    laoshifanxiaoshenqingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> laoshifanxiaoshenqingUuidNumber = new ArrayList<>();
                                    laoshifanxiaoshenqingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("laoshifanxiaoshenqingUuidNumber",laoshifanxiaoshenqingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //申请编号
                        List<LaoshifanxiaoshenqingEntity> laoshifanxiaoshenqingEntities_laoshifanxiaoshenqingUuidNumber = laoshifanxiaoshenqingService.selectList(new EntityWrapper<LaoshifanxiaoshenqingEntity>().in("laoshifanxiaoshenqing_uuid_number", seachFields.get("laoshifanxiaoshenqingUuidNumber")));
                        if(laoshifanxiaoshenqingEntities_laoshifanxiaoshenqingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LaoshifanxiaoshenqingEntity s:laoshifanxiaoshenqingEntities_laoshifanxiaoshenqingUuidNumber){
                                repeatFields.add(s.getLaoshifanxiaoshenqingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [申请编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        laoshifanxiaoshenqingService.insertBatch(laoshifanxiaoshenqingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
