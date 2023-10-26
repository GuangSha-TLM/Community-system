<template>
    <div class="Register">
        <div>
            <Top></Top>
        </div>

        <!-- Main content -->
        <section>
            <div class="container">
                <!-- Title -->
                <!-- Section title -->
                <div class="row mb-5 justify-content-center text-center">
                    <div class="col-lg-6">

                        <h2 class=" mt-4">注册您的账户</h2>
                        <div class="mt-2">
                            <p class="lead lh-180">Register Your Account</p>
                        </div>

                        <div>
                            <div class="form-group">
                                <label for="exampleInputusername">账号</label>
                                <input type="text" class="form-control" id="exampleInputusername"
                                v-model="user.username">
                                <small id="username" class="form-text text-muted">We'll never share your account
                                    information with anyone
                                    else.</small>
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">密码</label>
                                <input type="password" class="form-control" id="exampleInputPassword1"
                                    v-model="user.password">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputagainPassword1">再次输入密码</label>
                                <input type="password" class="form-control" id="exampleInputagainPassword1"
                                    v-model="user.againPassword">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputname">输入姓名</label>
                                <input type="text" class="form-control" id="exampleInputname"
                                    v-model="user.name">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputcollege">选择你的学院</label>
                                <el-select  v-model="user.college" placeholder="请选择"  style="width: 100%;">
                                <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value"
                                        >
                                </el-option>
                            </el-select>
                            </div>

                            <div class="form-group">
                                <label for="exampleInputgrand">选择你的年级</label>
                                <el-select  v-model="user.grand" placeholder="请选择"  style="width: 100%;">
                                <el-option
                                v-for="item in grandList"
                                :key="item"
                                :label="item"
                                :value="item"
                                             >
                                </el-option>
                            </el-select>
                            </div>
                            
                            
                            <!-- org:班级 -->
                            <div class="form-group">
                                <label for="exampleInputorg">选择你的班级</label>
                                <input type="text" class="form-control" id="exampleInputorg"
                                    v-model="user.org">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputstudentId">输入你的学号</label>
                                <input type="text" class="form-control" id="exampleInputstudentId"
                                    v-model="user.studentId">
                            </div>

 

                            <button class="btn btn-primary" style="width:100%" @click="submit()"
                                :disabled="switchbutton">Submit</button>

                            

                        </div>
                    </div>
                </div>

            </div>
        </section>

        <footer class="position-relative" id="footer-main">
            <Foot></Foot>
        </footer>
    </div>
</template>
  
<script>
import Foot from './fream/Foot.vue';
import Top from './fream/LoginTop.vue';
import { synRequestPost, synRequestGet } from "../../static/request"

export default {
    name: 'Register',
    components: {
        Foot, Top
    },
    
  
    data() {
        return {
            grandList: [ 2019 ,2020 ,2021 ,2022 ,2023 ,2024 ,2025],

            options: [{
                value: 0,
                label: '信息学院'
                }, {
                value: 1,
                label: '财经学院'
                }, {
                value: 2,
                label: '艺术学院'
                }, {
                value: 3,
                label: '通识学院'
                }],
                
            
            user: {
                userName: "",
                passWord: "",
                againPassword: "",
                name: "",
                college: null,
                org: "",
                grade: "",
                studentId: "",


            },
            input: "",
            //按钮开关
            switchbutton: false,
        }

    },
    mounted() {

    },

    methods: {
        //提交登入
        async submit() {
            this.switchbutton = true;
            //密码的重复输入正确判断
            if (this.user.password !== this.user.againPassword) {
                alert('密码设置失败');
                return;
            }

            let obj = await synRequestPost("/user/userReg", this.user);
  
            if (obj.code == '0x200') {
                this.$router.push("/user/login");
            }


            this.switchbutton = false;
        },
    }
}

</script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    h1,
    h2 {
        font-weight: normal;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }
</style>
  