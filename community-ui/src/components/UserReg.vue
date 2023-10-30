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
                                <label for="exampleInputstudentId">输入你的学号</label>
                                <input type="text" class="form-control" id="exampleInputstudentId"
                                    v-model="user.studentId">
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

                            <div class="form-group">
                                <label for="exampleInputprofessional">选择你的专业</label>

                                    <el-select  v-model="user.professional" placeholder="请选择"  style="width: 100%;">
                                        <el-option
                                            v-for="item in professionalList[user.college -1]"
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

                                    <el-select  v-model="user.org" placeholder="请选择"  style="width: 100%;">
                                        <el-option
                                            v-for="item in orgList"
                                                :key="item"
                                                :label="item"
                                                :value="item"
                                             >
                                </el-option>
                            </el-select>
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
            options: [
            { value: 1, label: "信息学院" },
            { value: 2, label: "财经学院" },
            { value: 3, label: "艺术学院" },
            { value: 4, label: "通识学院" }
            ],

            professionalList:[['软件工程','计算机科学与技术','电子商务'],
            ['审计学','会计学','国际经济与贸易','财务管理','工商管理','人力资源管理'],
            ['汉语言文学','应用心理学','学前教育 (师范类)'],
            ['视觉传达设计','环境设计','影视摄影与制作']],
            orgList:['1班','2班','3班','4班','5班','6班'],

            user: {
                userName: "",
                passWord: "",
                againPassword: "",
                name: "",
                college: null,
                org: "",
                grade: "",
                studentId: "",
                professional:"",


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
