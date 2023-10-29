<!--
 * @Author: tianleiyu 
 * @Date: 2023-10-29 10:33:58
 * @LastEditTime: 2023-10-29 17:06:42
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /community-ui/src/components/fream/LoginTop.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div class="top">
        <div class="modal fade" tabindex="-1" role="dialog" id="modal-cookies" data-backdrop="false"
            aria-labelledby="modal-cookies" aria-hidden="true">
            <div class="modal-dialog modal-dialog-aside left-4 right-4 bottom-4">
                <div class="modal-content bg-dark-dark">
                    <div class="modal-body">
                        <!-- Text -->
                        <p class="text-sm text-white mb-3">
                            We use cookies so that our themes work for you. By using our website, you agree to our use of
                            cookies.
                        </p>
                        <!-- Buttons -->
                        <a class="btn btn-sm btn-white" target="_blank">Learn more</a>
                        <button type="button" class="btn btn-sm btn-primary mr-2" data-dismiss="modal">OK</button>
                    </div>
                </div>
            </div>
        </div>
        <a class="btn btn-block btn-dark text-truncate rounded-0 py-2 d-none d-lg-block"
            style="z-index: 1000;color:aliceblue" target="_blank">
            哈尔滨广厦学院 <strong>投诉系统 </strong> 测试版本 v0.1
        </a>

        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-white">
                <div class="container">
                    <!-- Brand -->
                    <a class="navbar-brand" href="/h">
                        <img alt="Image placeholder" style="height:3.4rem" src="#" id="navbar-logo">
                    </a>
                    <!-- Toggler -->
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <!-- Collapse -->
                    <div class="collapse navbar-collapse" id="navbarCollapse">

                        <el-input placeholder="请输入内容" v-if="isActive" v-model="activeLikeToGetByTitleBo.title" @input="searchInfo"
                            class="input-with-select">
                            <el-button slot="append" icon="el-icon-search" @click="searchInfo"></el-button>
                        </el-input>
                        <div class="result">
                            <div class="result-item" v-for="(item,index) in list" :key="index">
                                {{item.title}}
                            </div>
                        </div>
                        
                        <ul class="navbar-nav mt-4 mt-lg-0 ml-auto" v-if="isLogin">
                            <li class="nav-item ">
                                <a class="nav-link" href="#">{{ username }} </a>
                            </li>
                        </ul>

                        <ul class="navbar-nav mt-4 mt-lg-0 ml-auto" v-else>
                            <li class="nav-item ">
                                <a class="nav-link" href="#">Help </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="/Login">登入 </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="/UserReg">注册 </a>
                            </li>
                        </ul>


                    </div>
                </div>
            </nav>


        </div>
    </div>
</template>
  
<script>

import { synRequestPost, synRequestGet } from "../../../static/request"
export default {
    name: 'Foot',
    data() {
        return {
            username: localStorage.getItem('username'),
            token: getCookie("token"),
            isLogin: false,
            isActive:false,
            activeLikeToGetByTitleBo: {
                token: "",
                title: '',
                status:0,
                delFlag:0
            },
            list:[]

        }
    },
    mounted() {
        this.isLoginInfo();
        console.log(this.$route.path);
    },
    methods: {
        isLoginInfo() {
            if (this.token == "" || this.token == null) {
                this.isLogin = false;
            } else {
                this.isLogin = true;
            }

            if (this.$route.path == '/ActivityManagement') {
                this.isActive = true;
            }else{
                this.isActive = false;
            }
        },
        async searchInfo() {
            this.activeLikeToGetByTitleBo.token = this.token;
            let obj = await synRequestPost("/activity/likeToGet", this.activeLikeToGetByTitleBo);
            console.log(obj);
            if (obj.code == "0x200") {
                this.list = obj.data;

            }
        },
    },
    watch:{
        '$route':'isLoginInfo'
    }
}
</script>
  
  
  