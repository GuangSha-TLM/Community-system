

// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'

import 'element-ui/lib/theme-chalk/index.css';
import { mavonEditor } from "mavon-editor";

Vue.config.productionTip = false
Vue.use(ElementUI);


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  // 安装全局事件总线
  beforeCreate(){
    Vue.prototype.$bus = this
    //接受数据
    // this.$bus.$on("xxxx",function)
    // 发送数据
    // this.$bus.$emit("xxxx",数据)
  }
})

