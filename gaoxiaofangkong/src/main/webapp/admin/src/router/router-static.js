import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import diqu from '@/views/modules/diqu/list'
    import fanxiaoshenqing from '@/views/modules/fanxiaoshenqing/list'
    import laoshi from '@/views/modules/laoshi/list'
    import laoshidaka from '@/views/modules/laoshidaka/list'
    import laoshifanxiaoshenqing from '@/views/modules/laoshifanxiaoshenqing/list'
    import laoshijujia from '@/views/modules/laoshijujia/list'
    import news from '@/views/modules/news/list'
    import qingjiashenqing from '@/views/modules/qingjiashenqing/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import xueshengdaka from '@/views/modules/xueshengdaka/list'
    import xueshengjujia from '@/views/modules/xueshengjujia/list'
    import xueshengliuyan from '@/views/modules/xueshengliuyan/list'
    import dictionaryDiqu from '@/views/modules/dictionaryDiqu/list'
    import dictionaryDiquZhuangtai from '@/views/modules/dictionaryDiquZhuangtai/list'
    import dictionaryFanxiaoshenqingYesno from '@/views/modules/dictionaryFanxiaoshenqingYesno/list'
    import dictionaryLaoshidakaZhuangtai from '@/views/modules/dictionaryLaoshidakaZhuangtai/list'
    import dictionaryLaoshifanxiaoshenqingYesno from '@/views/modules/dictionaryLaoshifanxiaoshenqingYesno/list'
    import dictionaryLaoshijujiaZhuangtai from '@/views/modules/dictionaryLaoshijujiaZhuangtai/list'
    import dictionaryLaoshizaixiao from '@/views/modules/dictionaryLaoshizaixiao/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionaryQingjiashenqingYesno from '@/views/modules/dictionaryQingjiashenqingYesno/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryXueshengdakaZhuangtai from '@/views/modules/dictionaryXueshengdakaZhuangtai/list'
    import dictionaryXueshengjujiaZhuangtai from '@/views/modules/dictionaryXueshengjujiaZhuangtai/list'
    import dictionaryXueshengzaixiao from '@/views/modules/dictionaryXueshengzaixiao/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryDiqu',
        name: '地区类型',
        component: dictionaryDiqu
    }
    ,{
        path: '/dictionaryDiquZhuangtai',
        name: '风险等级',
        component: dictionaryDiquZhuangtai
    }
    ,{
        path: '/dictionaryFanxiaoshenqingYesno',
        name: '审核状态',
        component: dictionaryFanxiaoshenqingYesno
    }
    ,{
        path: '/dictionaryLaoshidakaZhuangtai',
        name: '打卡状态',
        component: dictionaryLaoshidakaZhuangtai
    }
    ,{
        path: '/dictionaryLaoshifanxiaoshenqingYesno',
        name: '审核状态',
        component: dictionaryLaoshifanxiaoshenqingYesno
    }
    ,{
        path: '/dictionaryLaoshijujiaZhuangtai',
        name: '居家状态',
        component: dictionaryLaoshijujiaZhuangtai
    }
    ,{
        path: '/dictionaryLaoshizaixiao',
        name: '是否在校',
        component: dictionaryLaoshizaixiao
    }
    ,{
        path: '/dictionaryNews',
        name: '资讯类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionaryQingjiashenqingYesno',
        name: '审核状态',
        component: dictionaryQingjiashenqingYesno
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryXueshengdakaZhuangtai',
        name: '打卡状态',
        component: dictionaryXueshengdakaZhuangtai
    }
    ,{
        path: '/dictionaryXueshengjujiaZhuangtai',
        name: '居家状态',
        component: dictionaryXueshengjujiaZhuangtai
    }
    ,{
        path: '/dictionaryXueshengzaixiao',
        name: '是否在校',
        component: dictionaryXueshengzaixiao
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/diqu',
        name: '地区',
        component: diqu
      }
    ,{
        path: '/fanxiaoshenqing',
        name: '学生返校申请',
        component: fanxiaoshenqing
      }
    ,{
        path: '/laoshi',
        name: '老师',
        component: laoshi
      }
    ,{
        path: '/laoshidaka',
        name: '打卡',
        component: laoshidaka
      }
    ,{
        path: '/laoshifanxiaoshenqing',
        name: '老师返校申请',
        component: laoshifanxiaoshenqing
      }
    ,{
        path: '/laoshijujia',
        name: '居家',
        component: laoshijujia
      }
    ,{
        path: '/news',
        name: '疫情资讯',
        component: news
      }
    ,{
        path: '/qingjiashenqing',
        name: '学生请假申请',
        component: qingjiashenqing
      }
    ,{
        path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
    ,{
        path: '/xueshengdaka',
        name: '打卡',
        component: xueshengdaka
      }
    ,{
        path: '/xueshengjujia',
        name: '居家',
        component: xueshengjujia
      }
    ,{
        path: '/xueshengliuyan',
        name: '学生留言',
        component: xueshengliuyan
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
