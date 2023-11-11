<!--
 * @Author: tianleiyu
 * @Date: 2023-10-29 10:33:58
 * @LastEditTime: 2023-11-09 12:08:10
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

                        <el-input placeholder="请输入内容" v-if="isActive" v-model="activeLikeToGetByTitleBo.title"
                            @input="searchInfo" class="input-with-select">
                            <el-button slot="append" icon="el-icon-search" @click="searchInfo"></el-button>
                        </el-input>
                        <div class="result" v-if="searchList.length > 0 && activeLikeToGetByTitleBo.title != ''">
                            <div class="result-item" v-for="(item, index) in searchList" :key="index">
                                <div @click="emitBus">{{ item.title }}</div>
                            </div>
                        </div>

                        <ul class="navbar-nav mt-4 mt-lg-0 ml-auto" v-if="isLogin">
                            <el-dropdown>
                                <router-link to="/UserCenter">
                                    <li class="nav-item ">
                                        {{ username }}
                                    </li>
                                </router-link>
                                <el-dropdown-menu slot="dropdown">
                                    <router-link :to="{ name: 'MessageLists', params: { list: messageList } }">
                                        <el-dropdown-item>
                                            <el-badge :value="count" class="item">
                                                消息
                                            </el-badge>
                                        </el-dropdown-item>
                                    </router-link>
                                    <div @click="loginOut()">
                                        <el-dropdown-item>退出登陆</el-dropdown-item>
                                    </div>
                                </el-dropdown-menu>
                            </el-dropdown>
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
import { param } from 'jquery';

import { synRequestPost, synRequestGet } from "../../../static/request"
export default {
    name: 'Foot',
    data() {
        return {
            username: "",
            token: getCookie("token"),
            //登陆状态
            isLogin: false,
            //是否为活动面板
            isActive: false,
            //模糊查询
            activeLikeToGetByTitleBo: {
                token: "",
                title: '',
                status: 0,
                delFlag: 0
            },
            //查询
            searchList: [],
            messageList: [],
            count: 0

        }
    },
    mounted() {
        this.isLoginInfo();
        this.isActiveInfo();
    },
    methods: {

        //判断是否为登陆
        async isLoginInfo() {
            if (this.$route.path != "/Login") {
                var user = JSON.parse(localStorage.getItem("user"))

                if (user && user.username) {
                    this.username = user.username;
                    this.isLogin = true;
                    //查询是否有消息
                    let res = await synRequestPost(`/notice/select?token=${this.token}`);
                    this.messageList = res.data.noReadCounts;
                    this.count = res.data.count;
                } else {
                    this.$router.push("/Login");
                    this.isLogin = false;
                }
            }
        },
        // 判断是否为活动面板
        isActiveInfo() {
            if (this.$route.path == '/ActivityManagement') {
                this.isActive = true;
            } else {
                this.isActive = false;
            }
        },
        // 模糊查询
        async searchInfo() {
            this.activeLikeToGetByTitleBo.token = this.token;
            let obj = await synRequestPost("/activity/likeToGet", this.activeLikeToGetByTitleBo);
            if (obj.code == "0x200") {
                this.searchList = obj.data;

            }
        },
        emitBus() {
            this.$bus.$emit('searchList', this.searchList);
            this.searchList = [];
        },
        loginOut() {
            this.username = "";
            localStorage.removeItem('user')
            delCookie('token')
            this.$router.push('/Login');
        }

    },
    watch: {
        '$route': 'isActiveInfo',
        'username': 'isLoginInfo'

    }
}

</script>


