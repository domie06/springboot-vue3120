<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                   <el-col :span="12" v-if="flag=='laoshi'">
            <el-form-item class="select" label="地区" prop="diquId">
                <el-select v-model="ruleForm.diquId" filterable placeholder="请选择地区" @change="diquChange">
                    <el-option
                            v-for="(item,index) in diquOptions"
                            v-bind:key="item.id"
                                            :label="item.diquName"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
        </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='laoshi'" label='地区名称' prop="diquName">
                 <el-input v-model="diquForm.diquName" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='laoshi'" label='地址位置' prop="diquAddress">
                 <el-input v-model="diquForm.diquAddress" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='laoshi'" label='地区类型' prop="diquTypes">
                 <el-input v-model="diquForm.diquValue" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='laoshi'" label='风险等级' prop="diquZhuangtaiTypes">
                 <el-input v-model="diquForm.diquZhuangtaiValue" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='laoshi'"  label='老师姓名' prop="laoshiName">
               <el-input v-model="ruleForm.laoshiName"  placeholder='老师姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='laoshi'"  label='老师手机号' prop="laoshiPhone">
               <el-input v-model="ruleForm.laoshiPhone"  placeholder='老师手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='laoshi'"  label='老师身份证号' prop="laoshiIdNumber">
               <el-input v-model="ruleForm.laoshiIdNumber"  placeholder='老师身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='laoshi'" label='老师头像' prop="laoshiPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.laoshiPhoto?ruleForm.laoshiPhoto:''"
                         @change="laoshiPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='laoshi'"  label='是否在校' prop="laoshizaixiaoTypes">
                 <el-select v-model="ruleForm.laoshizaixiaoTypes"  placeholder='请选择是否在校'>
                     <el-option
                             v-for="(item,index) in laoshizaixiaoTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='laoshi'"  label='电子邮箱' prop="laoshiEmail">
               <el-input v-model="ruleForm.laoshiEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

        <el-col :span="12" v-if="flag=='xuesheng'">
            <el-form-item class="select" label="地区" prop="diquId">
                <el-select v-model="ruleForm.diquId" filterable placeholder="请选择地区" @change="diquChange">
                    <el-option
                            v-for="(item,index) in diquOptions"
                            v-bind:key="item.id"
                                            :label="item.diquName"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
        </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='xuesheng'" label='地区名称' prop="diquName">
                 <el-input v-model="diquForm.diquName" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='xuesheng'" label='地址位置' prop="diquAddress">
                 <el-input v-model="diquForm.diquAddress" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='xuesheng'" label='地区类型' prop="diquTypes">
                 <el-input v-model="diquForm.diquValue" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='xuesheng'" label='风险等级' prop="diquZhuangtaiTypes">
                 <el-input v-model="diquForm.diquZhuangtaiValue" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='xuesheng'"  label='学生姓名' prop="xueshengName">
               <el-input v-model="ruleForm.xueshengName"  placeholder='学生姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='xuesheng'"  label='学生手机号' prop="xueshengPhone">
               <el-input v-model="ruleForm.xueshengPhone"  placeholder='学生手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='xuesheng'"  label='学生身份证号' prop="xueshengIdNumber">
               <el-input v-model="ruleForm.xueshengIdNumber"  placeholder='学生身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='xuesheng'" label='学生头像' prop="xueshengPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.xueshengPhoto?ruleForm.xueshengPhoto:''"
                         @change="xueshengPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='xuesheng'"  label='是否在校' prop="xueshengzaixiaoTypes">
                 <el-select v-model="ruleForm.xueshengzaixiaoTypes"  placeholder='请选择是否在校'>
                     <el-option
                             v-for="(item,index) in xueshengzaixiaoTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='xuesheng'"  label='电子邮箱' prop="xueshengEmail">
               <el-input v-model="ruleForm.xueshengEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 学生
    // 注册的类型字段 学生
        // 性别
        sexTypesOptions : [],
        // 是否在校
        xueshengzaixiaoTypesOptions : [],
    // 注册的级联表 学生
        // 地区列表
        diquOptions : [],
        diquForm:{},
// 注册表 老师
    // 注册的类型字段 老师
        // 性别
        sexTypesOptions : [],
        // 是否在校
        laoshizaixiaoTypesOptions : [],
    // 注册的级联表 老师
        // 地区列表
        diquOptions : [],
        diquForm:{},
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 学生
    // 注册的级联表 学生
        if(table == 'xuesheng'){
            this.diquChange(this.ruleForm.diquId);
        }
// 注册表 老师
    // 注册的级联表 老师
        if(table == 'laoshi'){
            this.diquChange(this.ruleForm.diquId);
        }
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 学生 的级联表
    // 注册的级联表 学生
        // 地区列表
    this.$http({
        url: `diqu/page?page=1&limit=100`,
        method: "get"
    }).then(({ data }) => {
        if (data && data.code === 0) {
        this.diquOptions = data.data.list;
        }else{
            this.$message.error(data.msg);
        }
    });
// 注册表 老师 的级联表
    // 注册的级联表 老师
        // 地区列表
    this.$http({
        url: `diqu/page?page=1&limit=100`,
        method: "get"
    }).then(({ data }) => {
        if (data && data.code === 0) {
        this.diquOptions = data.data.list;
        }else{
            this.$message.error(data.msg);
        }
    });

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=laoshizaixiao_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.laoshizaixiaoTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=xueshengzaixiao_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.xueshengzaixiaoTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
  },
  methods: {
    laoshiPhotoUploadChange(fileUrls) {
        this.ruleForm.laoshiPhoto = fileUrls;
    },
    xueshengPhotoUploadChange(fileUrls) {
        this.ruleForm.xueshengPhoto = fileUrls;
    },
// 注册表的级联表
    diquChange(id){
        this.$http({
            url: `diqu/info/`+id,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.diquForm = data.data;
            }
        });
    },
// 注册表的级联表
    diquChange(id){
        this.$http({
            url: `diqu/info/`+id,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.diquForm = data.data;
            }
        });
    },


    onUpdateHandler() {
                         if((!this.ruleForm.diquId)&& 'laoshi'==this.flag){
                             this.$message.error('老师不能为空');
                             return
                         }

                         if((!this.ruleForm.laoshiName)&& 'laoshi'==this.flag){
                             this.$message.error('老师姓名不能为空');
                             return
                         }

                             if( 'laoshi' ==this.flag && this.ruleForm.laoshiPhone&&(!isMobile(this.ruleForm.laoshiPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.laoshiIdNumber)&& 'laoshi'==this.flag){
                             this.$message.error('老师身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.laoshiPhoto)&& 'laoshi'==this.flag){
                             this.$message.error('老师头像不能为空');
                             return
                         }

                         if((!this.ruleForm.laoshizaixiaoTypes)&& 'laoshi'==this.flag){
                             this.$message.error('是否在校不能为空');
                             return
                         }

                             if( 'laoshi' ==this.flag && this.ruleForm.laoshiEmail&&(!isEmail(this.ruleForm.laoshiEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.diquId)&& 'xuesheng'==this.flag){
                             this.$message.error('老师不能为空');
                             return
                         }

                         if((!this.ruleForm.xueshengName)&& 'xuesheng'==this.flag){
                             this.$message.error('学生姓名不能为空');
                             return
                         }

                             if( 'xuesheng' ==this.flag && this.ruleForm.xueshengPhone&&(!isMobile(this.ruleForm.xueshengPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.xueshengIdNumber)&& 'xuesheng'==this.flag){
                             this.$message.error('学生身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.xueshengPhoto)&& 'xuesheng'==this.flag){
                             this.$message.error('学生头像不能为空');
                             return
                         }

                         if((!this.ruleForm.xueshengzaixiaoTypes)&& 'xuesheng'==this.flag){
                             this.$message.error('是否在校不能为空');
                             return
                         }

                             if( 'xuesheng' ==this.flag && this.ruleForm.xueshengEmail&&(!isEmail(this.ruleForm.xueshengEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
        if((!this.ruleForm.sexTypes) && this.flag!='users'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
