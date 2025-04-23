
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
 * 居家
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/laoshijujia")
public class LaoshijujiaController {
    private static final Logger logger = LoggerFactory.getLogger(LaoshijujiaController.class);

    @Autowired
    private LaoshijujiaService laoshijujiaService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private LaoshiService laoshiService;

    @Autowired
    private XueshengService xueshengService;


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
        PageUtils page = laoshijujiaService.queryPage(params);

        //字典表数据转换
        List<LaoshijujiaView> list =(List<LaoshijujiaView>)page.getList();
        for(LaoshijujiaView c:list){
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
        LaoshijujiaEntity laoshijujia = laoshijujiaService.selectById(id);
        if(laoshijujia !=null){
            //entity转view
            LaoshijujiaView view = new LaoshijujiaView();
            BeanUtils.copyProperties( laoshijujia , view );//把实体数据重构到view中

                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(laoshijujia.getLaoshiId());
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
    public R save(@RequestBody LaoshijujiaEntity laoshijujia, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,laoshijujia:{}",this.getClass().getName(),laoshijujia.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老师".equals(role))
            laoshijujia.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<LaoshijujiaEntity> queryWrapper = new EntityWrapper<LaoshijujiaEntity>()
            .eq("laoshi_id", laoshijujia.getLaoshiId())
            .eq("laoshijujia_zhuangtai_types", laoshijujia.getLaoshijujiaZhuangtaiTypes())
            .eq("jujia_time", new SimpleDateFormat("yyyy-MM-dd").format(laoshijujia.getJujiaTime()))
            .eq("xueshengjujia_address", laoshijujia.getXueshengjujiaAddress())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaoshijujiaEntity laoshijujiaEntity = laoshijujiaService.selectOne(queryWrapper);
        if(laoshijujiaEntity==null){
            laoshijujia.setInsertTime(new Date());
            laoshijujia.setCreateTime(new Date());
            laoshijujiaService.insert(laoshijujia);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LaoshijujiaEntity laoshijujia, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,laoshijujia:{}",this.getClass().getName(),laoshijujia.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老师".equals(role))
//            laoshijujia.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<LaoshijujiaEntity> queryWrapper = new EntityWrapper<LaoshijujiaEntity>()
            .notIn("id",laoshijujia.getId())
            .andNew()
            .eq("laoshi_id", laoshijujia.getLaoshiId())
            .eq("laoshijujia_zhuangtai_types", laoshijujia.getLaoshijujiaZhuangtaiTypes())
            .eq("jujia_time", new SimpleDateFormat("yyyy-MM-dd").format(laoshijujia.getJujiaTime()))
            .eq("xueshengjujia_address", laoshijujia.getXueshengjujiaAddress())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaoshijujiaEntity laoshijujiaEntity = laoshijujiaService.selectOne(queryWrapper);
        if(laoshijujiaEntity==null){
            laoshijujiaService.updateById(laoshijujia);//根据id更新
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
        laoshijujiaService.deleteBatchIds(Arrays.asList(ids));
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
            List<LaoshijujiaEntity> laoshijujiaList = new ArrayList<>();//上传的东西
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
                            LaoshijujiaEntity laoshijujiaEntity = new LaoshijujiaEntity();
//                            laoshijujiaEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            laoshijujiaEntity.setLaoshijujiaZhuangtaiTypes(Integer.valueOf(data.get(0)));   //居家状态 要改的
//                            laoshijujiaEntity.setJujiaTime(sdf.parse(data.get(0)));          //居家日期 要改的
//                            laoshijujiaEntity.setXueshengjujiaAddress(data.get(0));                    //居家位置 要改的
//                            laoshijujiaEntity.setLaoshijujiaContent("");//详情和图片
//                            laoshijujiaEntity.setInsertTime(date);//时间
//                            laoshijujiaEntity.setCreateTime(date);//时间
                            laoshijujiaList.add(laoshijujiaEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        laoshijujiaService.insertBatch(laoshijujiaList);
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
