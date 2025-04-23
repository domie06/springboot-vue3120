
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
 * 学生请假申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qingjiashenqing")
public class QingjiashenqingController {
    private static final Logger logger = LoggerFactory.getLogger(QingjiashenqingController.class);

    @Autowired
    private QingjiashenqingService qingjiashenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private XueshengService xueshengService;

    @Autowired
    private LaoshiService laoshiService;


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
        PageUtils page = qingjiashenqingService.queryPage(params);

        //字典表数据转换
        List<QingjiashenqingView> list =(List<QingjiashenqingView>)page.getList();
        for(QingjiashenqingView c:list){
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
        QingjiashenqingEntity qingjiashenqing = qingjiashenqingService.selectById(id);
        if(qingjiashenqing !=null){
            //entity转view
            QingjiashenqingView view = new QingjiashenqingView();
            BeanUtils.copyProperties( qingjiashenqing , view );//把实体数据重构到view中

                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(qingjiashenqing.getXueshengId());
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
    public R save(@RequestBody QingjiashenqingEntity qingjiashenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qingjiashenqing:{}",this.getClass().getName(),qingjiashenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            qingjiashenqing.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<QingjiashenqingEntity> queryWrapper = new EntityWrapper<QingjiashenqingEntity>()
            .eq("xuesheng_id", qingjiashenqing.getXueshengId())
            .eq("qingjiashenqing_uuid_number", qingjiashenqing.getQingjiashenqingUuidNumber())
            .eq("qingjiashenqing_kaishi_time", new SimpleDateFormat("yyyy-MM-dd").format(qingjiashenqing.getQingjiashenqingKaishiTime()))
            .eq("qingjiashenqing_jieshu_time", new SimpleDateFormat("yyyy-MM-dd").format(qingjiashenqing.getQingjiashenqingJieshuTime()))
            .eq("qingjiashenqing_yesno_types", qingjiashenqing.getQingjiashenqingYesnoTypes())
            .eq("qingjiashenqing_yesno_text", qingjiashenqing.getQingjiashenqingYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QingjiashenqingEntity qingjiashenqingEntity = qingjiashenqingService.selectOne(queryWrapper);
        if(qingjiashenqingEntity==null){
            qingjiashenqing.setInsertTime(new Date());
            qingjiashenqing.setQingjiashenqingYesnoTypes(1);
            qingjiashenqing.setCreateTime(new Date());
            qingjiashenqingService.insert(qingjiashenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QingjiashenqingEntity qingjiashenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,qingjiashenqing:{}",this.getClass().getName(),qingjiashenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            qingjiashenqing.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<QingjiashenqingEntity> queryWrapper = new EntityWrapper<QingjiashenqingEntity>()
            .notIn("id",qingjiashenqing.getId())
            .andNew()
            .eq("xuesheng_id", qingjiashenqing.getXueshengId())
            .eq("qingjiashenqing_uuid_number", qingjiashenqing.getQingjiashenqingUuidNumber())
            .eq("insert_time", qingjiashenqing.getInsertTime())
            .eq("qingjiashenqing_kaishi_time", qingjiashenqing.getQingjiashenqingKaishiTime())
            .eq("qingjiashenqing_jieshu_time", qingjiashenqing.getQingjiashenqingJieshuTime())
            .eq("qingjiashenqing_yesno_types", qingjiashenqing.getQingjiashenqingYesnoTypes())
            .eq("qingjiashenqing_yesno_text", qingjiashenqing.getQingjiashenqingYesnoText())
            .eq("update_time", qingjiashenqing.getUpdateTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QingjiashenqingEntity qingjiashenqingEntity = qingjiashenqingService.selectOne(queryWrapper);
        qingjiashenqing.setUpdateTime(new Date());
        if(qingjiashenqingEntity==null){
            qingjiashenqingService.updateById(qingjiashenqing);//根据id更新
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
        qingjiashenqingService.deleteBatchIds(Arrays.asList(ids));
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
            List<QingjiashenqingEntity> qingjiashenqingList = new ArrayList<>();//上传的东西
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
                            QingjiashenqingEntity qingjiashenqingEntity = new QingjiashenqingEntity();
//                            qingjiashenqingEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            qingjiashenqingEntity.setQingjiashenqingUuidNumber(data.get(0));                    //申请编号 要改的
//                            qingjiashenqingEntity.setInsertTime(date);//时间
//                            qingjiashenqingEntity.setQingjiashenqingKaishiTime(sdf.parse(data.get(0)));          //请假开始日期 要改的
//                            qingjiashenqingEntity.setQingjiashenqingJieshuTime(sdf.parse(data.get(0)));          //请假结束日期 要改的
//                            qingjiashenqingEntity.setQingjiashenqingContent("");//详情和图片
//                            qingjiashenqingEntity.setQingjiashenqingYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            qingjiashenqingEntity.setQingjiashenqingYesnoText(data.get(0));                    //审核意见 要改的
//                            qingjiashenqingEntity.setUpdateTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            qingjiashenqingEntity.setCreateTime(date);//时间
                            qingjiashenqingList.add(qingjiashenqingEntity);


                            //把要查询是否重复的字段放入map中
                                //申请编号
                                if(seachFields.containsKey("qingjiashenqingUuidNumber")){
                                    List<String> qingjiashenqingUuidNumber = seachFields.get("qingjiashenqingUuidNumber");
                                    qingjiashenqingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> qingjiashenqingUuidNumber = new ArrayList<>();
                                    qingjiashenqingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("qingjiashenqingUuidNumber",qingjiashenqingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //申请编号
                        List<QingjiashenqingEntity> qingjiashenqingEntities_qingjiashenqingUuidNumber = qingjiashenqingService.selectList(new EntityWrapper<QingjiashenqingEntity>().in("qingjiashenqing_uuid_number", seachFields.get("qingjiashenqingUuidNumber")));
                        if(qingjiashenqingEntities_qingjiashenqingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QingjiashenqingEntity s:qingjiashenqingEntities_qingjiashenqingUuidNumber){
                                repeatFields.add(s.getQingjiashenqingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [申请编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        qingjiashenqingService.insertBatch(qingjiashenqingList);
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
