
import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import UserManagement from '@/components/UserManagement'
import ClassManagement from '@/components/ClassManagement'
import AssociationManager from '@/components/AssociationManager'
import ActivityManagement from '../components/ActivityManagement.vue'
import ActivityItem from '../components/ActivityItem.vue'

import Login from '@/components/Login.vue'
import UserReg from '@/components/UserReg.vue'
import Home from '@/components/Home';
Vue.use(Router)

export default new Router({
  mode: 'history',
  base: '/h',
  
  routes: [
    {
      path: '/',
      component: Home,
      children: [
        {
          path: '/ClassManagement',
          name: 'ClassManagement',
          component: ClassManagement,
        },
        {
          path: '/userManagement',
          name: 'UserManagement',
          component: UserManagement
        },{
          path: '/AssociationManager',
          name: 'AssociationManager',
          component: AssociationManager
        }
        ,{
          path: '/ActivityManagement',
          name: 'ActivityManagement',
          component: ActivityManagement
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
    //用户管理面板
    {
      path: '/UserManagement',
      name: 'UserManagement',
      component: UserManagement
    },
    //班级管理面板
    {
      path: '/ClassManagement',
      name: 'ClassManagement',
      component: ClassManagement
    },
    //社团管理面板
    {
      path: '/AssociationManager',
      name: 'AssociationManager',
      component: AssociationManager
    },
    //活动管理面板
    {
      path: '/ActivityManagement',
      name: 'ActivityManagement',
      component: ActivityManagement
    },
    //活动详情面板
    {
      path: '/ActivityItem/:id',
      name: 'ActivityItem',
      component: ActivityItem
    }
  ]
})
