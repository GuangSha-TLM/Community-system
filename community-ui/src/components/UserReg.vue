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
                                <label for="exampleInputgrand">选择你的年级</label>
                                <el-select  v-model="user.grade" placeholder="请选择"  style="width: 100%;">
                                <el-option
                                v-for="item in yearsList"
                                    :key="item"
                                    :label="item"
                                    :value="item"
                                             >
                                              
                                </el-option>
                            </el-select>
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
                            <label for="exampleInputprofessional">选择你的专业</label>
                            <el-select v-model="user.professional" placeholder="请选择" style="width: 100%;">

                                <el-option-group
                                    v-for="group in professionalList[user.college -1]"
                                    :key="group.label"
                                    :label="group.label">

                                <el-option
                                    v-for="item in group.professionalList"
                                    :key="item.professionalList"
                                    :label="item.label"
                                    :value="item">
                                </el-option>
                                </el-option-group>
                            </el-select></div>

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
            //获取今年年份-5，开始循环
            startYear: 2019,
        numYearsToShow: 5, // 显示最新的5个年份选项,
            
                    options: [
                        { value: 1, label: "信息学院" },
                        { value: 2, label: "财经学院" },
                        { value: 3, label: "艺术学院" },
                        { value: 4, label: "通识学院" }
        ],

        professionalList:[
                //信息学院
                [
                {
                    value:1,
                    label: '软件工程',
                    professionalList: ['软件工程1班', '软件工程2班','软件工程3班','软件工程4班','软件工程5班','软件工程6班']
                }, {
                    value:2,
                    label: '计算机科学与技术',
                    professionalList: ['计算机科学与技术1班', '计算机科学与技术2班','计算机科学与技术3班',
                                        '计算机科学与技术4班','计算机科学与技术5班','计算机科学与技术6班']
                },{
                    value:3,
                    label: '电子商务',
                    professionalList: ['电子商务1班', '电子商务2班','电子商务3班','电子商务4班','电子商务5班','电子商务6班']
                    },

                ],
                //财经学院
                [
                {
                    value:1,
                    label: '审计学',
                    professionalList: ['审计学1班', '审计学2班','审计学3班','审计学4班','审计学5班','审计学6班']
                }, {
                    value:2,
                    label: '会计学',
                    professionalList: ['会计学1班', '会计学2班','会计学3班','会计学4班','会计学5班','会计学6班']
                },{
                    value:3,
                    label: '国际经济与贸易',
                    professionalList: ['国际经济与贸易1班', '国际经济与贸易2班','国际经济与贸易3班',
                                        '国际经济与贸易4班','国际经济与贸易5班','国际经济与贸易6班']
                },{
                    value:4,
                    label: '财务管理',
                    professionalList: ['财务管理1班', '财务管理2班','财务管理3班','财务管理4班','财务管理5班','财务管理6班']
                }, {
                    value:5,
                    label: '工商管理',
                    professionalList: ['工商管理1班', '工商管理2班','工商管理3班','工商管理4班','工商管理5班','工商管理6班']
                },{
                    value:6,
                    label: '人力资源管理',
                    professionalList: ['人力资源管理1班', '人力资源管理2班','人力资源管理3班',
                                        '人力资源管理4班','人力资源管理5班','人力资源管理6班']
                    },

                ],
                //艺术学院
                [
                {
                    value:1,
                    label: '视觉传达设计',
                    professionalList: ['视觉传达设计1班', '视觉传达设计2班','视觉传达设计3班',
                                        '视觉传达设计4班','视觉传达设计5班','视觉传达设计6班']
                }, {
                    value:2,
                    label: '环境设计',
                    professionalList: ['环境设计1班', '环境设计2班','环境设计3班','环境设计4班','环境设计5班','环境设计6班']
                },{
                    value:3,
                    label: '影视摄影与制作',
                    professionalList: ['影视摄影与制作1班', '影视摄影与制作2班','影视摄影与制作3班',
                                        '影视摄影与制作4班','影视摄影与制作5班','影视摄影与制作6班']
                    },

                ],
                //通识学院
                [
                {
                    value:1,
                    label: '汉语言文学',
                    professionalList: ['汉语言文学1班', '汉语言文学2班','汉语言文学3班',
                                        '汉语言文学4班','汉语言文学5班','汉语言文学6班']
                }, {
                    value:2,
                    label: '应用心理学',
                    professionalList: ['应用心理学1班', '应用心理学2班','应用心理学3班',
                                        '应用心理学4班','应用心理学5班','应用心理学6班']
                },{
                    value:3,
                    label: '学前教育 (师范类)',
                    professionalList: ['学前教育 (师范类)1班', '学前教育 (师范类)2班','学前教育 (师范类)3班',
                                        '学前教育 (师范类)4班','学前教育 (师范类)5班','学前教育 (师范类)6班']

                    },

                ]
                ],
        
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
            yearsList: []
        }

 

    },
    mounted() {
        const currentDate = new Date();
        const currentYear = currentDate.getFullYear();
        for (let i = currentYear - 4; i <= currentYear; i++) {
            this.yearsList.push(i);
        }
        console.log(this.yearsList);
    },

    methods: {  
 

        //提交登入
        async submit() {
            this.switchbutton = true;
            const { username, password, againPassword, name, org, grade, college, professional } = this.user;
            // 判断用户名是否为空
            if (this.user.username === '') {
                alert('用户名不能为空');
                this.switchbutton = false;
                return;
            }
            if (this.user.password === ''|| againPassword === '') {
                alert('密码不能为空');
                this.switchbutton = false;
                return;
            }
            if (this.user.name === '') {
                alert('姓名不能为空');
                this.switchbutton = false;
                return;
            }
            if (this.user.studentId === '') {
                alert('学号不能为空');
                this.switchbutton = false;
                return;
            }
            if (this.user.grade === '') {
                alert('年级不能为空');
                this.switchbutton = false;
                return;
            }
            if (this.user.college === '') {
                alert('学院不能为空');
                this.switchbutton = false;
                return;
            }
            if (this.user.professional === '') {
                alert('专业不能为空');
                this.switchbutton = false;
                return;
            }

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
