
import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import UserManagement from '@/components/UserManagement'
import ClassManagement from '@/components/ClassManagement'
import AssociationManager from '../components/AssociationManager.vue'
import ActivityManagement from '../components/ActivityManagement.vue'
import ActivityItem from '../components/ActivityItem.vue'
import UserCenter from '../components/UserCenter.vue'
import ApplyAddAssociation from '../components/ApplyAddAssociation.vue'
import MessageLists from '../components/MessageLists.vue'
import AssociationActivityManagement from '../components/AssociationActivityManagement.vue'

import Login from '@/components/Login.vue'
import UserReg from '@/components/UserReg.vue'
import Home from '@/components/Home';
import { get } from 'jquery'
Vue.use(Router)

const router =  new Router({
  mode: 'history',
  base: '/h',

  routes: [
    {
      path: '/',
      component: Home,
      children: [
        //活动管理面板
        {
          path: '/ActivityManagement',
          name: 'ActivityManagement',
          component: ActivityManagement,
          meta: { requiresAuth: true }
        },
        //活动详情面板
        {
          path: '/ActivityItem/:id',
          name: 'ActivityItem',
          component: ActivityItem,
          meta: { requiresAuth: true }
        },
        //用户管理面板
        {
          path: '/UserManagement',
          name: 'UserManagement',
          component: UserManagement,
          meta: { requiresAuth: true }
        },
        //班级管理面板
        {
          path: '/ClassManagement',
          name: 'ClassManagement',
          component: ClassManagement,
          meta: { requiresAuth: true }
        },
        // //社团管理面板
        {
          path: '/AssociationManager',
          name: 'AssociationManager',
          component: AssociationManager,
          meta: { requiresAuth: true }
        }
        , {
          path: '/UserCenter',
          name: 'UserCenter',
          component: UserCenter,
          meta: { requiresAuth: true }
        },
        {
          path: '/ApplyAddAssociation/:id',
          name: 'ApplyAddAssociation',
          component: ApplyAddAssociation,
          meta: { requiresAuth: true }
        }, {
          path: '/MessageLists',
          name: 'MessageLists',
          component: MessageLists,
          meta: { requiresAuth: true }
        },
        {
          path: '/AssociationActivityManagement',
          name: 'AssociationActivityManagement',
          component: AssociationActivityManagement,
          meta: { requiresAuth: true }
        }
      ]
    },
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    //用户登录界面
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    //用户注册界面
    {
      path: '/UserReg',
      name: 'UserReg',
      component: UserReg
    },
  ]
})

router.beforeEach((to, from, next) => {
  // to:可以获得你想要跳转到那个路由的信息
  //from: 可以获取到你从那个路由来的
  // next :  放行函数 next() 放行 next(path) 放行到那个指定路由 
  let token = getCookie('token')
  if (to.matched.some(record => record.meta.requiresAuth)) {
    // 需要身份验证的路由
    if (token) {
      next(); // 用户已登录，继续导航
    } else {
      next('/Login'); // 用户未登录，重定向到登录页
    }
  } else {
    next(); // 不需要身份验证的路由，直接继续导航
  }

})


export default router
