
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
 * 学生留言
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xueshengliuyan")
public class XueshengliuyanController {
    private static final Logger logger = LoggerFactory.getLogger(XueshengliuyanController.class);

    @Autowired
    private XueshengliuyanService xueshengliuyanService;


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
        PageUtils page = xueshengliuyanService.queryPage(params);

        //字典表数据转换
        List<XueshengliuyanView> list =(List<XueshengliuyanView>)page.getList();
        for(XueshengliuyanView c:list){
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
        XueshengliuyanEntity xueshengliuyan = xueshengliuyanService.selectById(id);
        if(xueshengliuyan !=null){
            //entity转view
            XueshengliuyanView view = new XueshengliuyanView();
            BeanUtils.copyProperties( xueshengliuyan , view );//把实体数据重构到view中

                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(xueshengliuyan.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(xueshengliuyan.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
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
    public R save(@RequestBody XueshengliuyanEntity xueshengliuyan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xueshengliuyan:{}",this.getClass().getName(),xueshengliuyan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xueshengliuyan.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("老师".equals(role))
            xueshengliuyan.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XueshengliuyanEntity> queryWrapper = new EntityWrapper<XueshengliuyanEntity>()
            .eq("xuesheng_id", xueshengliuyan.getXueshengId())
            .eq("laoshi_id", xueshengliuyan.getLaoshiId())
            .eq("liuyan_text", xueshengliuyan.getLiuyanText())
            .eq("huifu_text", xueshengliuyan.getHuifuText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengliuyanEntity xueshengliuyanEntity = xueshengliuyanService.selectOne(queryWrapper);
        if(xueshengliuyanEntity==null){
            xueshengliuyan.setInsertTime(new Date());
            xueshengliuyan.setCreateTime(new Date());
            xueshengliuyanService.insert(xueshengliuyan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XueshengliuyanEntity xueshengliuyan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xueshengliuyan:{}",this.getClass().getName(),xueshengliuyan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xueshengliuyan.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("老师".equals(role))
//            xueshengliuyan.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XueshengliuyanEntity> queryWrapper = new EntityWrapper<XueshengliuyanEntity>()
            .notIn("id",xueshengliuyan.getId())
            .andNew()
            .eq("xuesheng_id", xueshengliuyan.getXueshengId())
            .eq("laoshi_id", xueshengliuyan.getLaoshiId())
            .eq("liuyan_text", xueshengliuyan.getLiuyanText())
            .eq("huifu_text", xueshengliuyan.getHuifuText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengliuyanEntity xueshengliuyanEntity = xueshengliuyanService.selectOne(queryWrapper);
        xueshengliuyan.setUpdateTime(new Date());
        if(xueshengliuyanEntity==null){
            xueshengliuyanService.updateById(xueshengliuyan);//根据id更新
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
        xueshengliuyanService.deleteBatchIds(Arrays.asList(ids));
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
            List<XueshengliuyanEntity> xueshengliuyanList = new ArrayList<>();//上传的东西
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
                            XueshengliuyanEntity xueshengliuyanEntity = new XueshengliuyanEntity();
//                            xueshengliuyanEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xueshengliuyanEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            xueshengliuyanEntity.setInsertTime(date);//时间
//                            xueshengliuyanEntity.setLiuyanText(data.get(0));                    //留言内容 要改的
//                            xueshengliuyanEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            xueshengliuyanEntity.setHuifuText(data.get(0));                    //回复内容 要改的
//                            xueshengliuyanEntity.setCreateTime(date);//时间
                            xueshengliuyanList.add(xueshengliuyanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xueshengliuyanService.insertBatch(xueshengliuyanList);
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
