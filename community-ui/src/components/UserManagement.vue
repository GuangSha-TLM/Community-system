<template>
    <div>
        <!-- Main content -->
        <section v-if="view">
            <div class="container">
                <!-- 添加功能 -->
                <div class="addButton">
                    <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
                             点我添加
                         </el-button>
                        <el-drawer
                        title="我是标题"
                        :visible.sync="drawer"
                        :direction="direction"
                        :before-close="handleClose">
                        <div>
                            <div>
                                名字:
                                <el-input v-model="addInfo.name" placeholder="添加名字"></el-input>
                            </div>
                            <br><br>
                            <div>
                                用户名:
                                <el-input v-model="addInfo.username" placeholder="添加用户名"></el-input>
                            </div>
                            <br><br>
                            <div>
                                密码:
                                <el-input v-model="addInfo.password" placeholder="添加密码"></el-input>
                            </div>
                            <br><br>
                            <div>
                                班级:
                                <el-input v-model="addInfo.org" placeholder="添加班级"></el-input>
                            </div>
                             <br><br>
                            <el-button type="primary" @click="submitAdd()">提交</el-button>
                        </div>
                        </el-drawer>
                </div>
                <!-- ----------------- -->
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">序号</th>
                            <th scope="col">学院</th>
                            <th scope="col">专业</th>
                            <th scope="col">班级</th>
                            <th scope="col">姓名</th>
                            <!-- <th scope="col">创建时间</th> -->
                            <th scope="col">操作</th>
                        </tr>

                    </thead>
                    <tbody>
                        <tr v-for="obj in list" :key="obj.index">
                            <th scope="row">{{ obj.id }}</th>
                            <td>{{ obj.college }}</td>
                            <td>{{ obj.professional }}</td>
                            <td>{{ obj.org }}</td>
                            <td>{{ obj.name }}</td>
                            <!-- <td>{{ obj.createTime }}</td> -->

                            <td>
                                <el-link type="primary" @click="openView(obj)">查看</el-link>

                                <el-link type="primary" @click="openUpdateUserInfoWindows(obj.id)">修改</el-link>

                                <el-drawer title="我是标题" :visible.sync="updateWindows" :with-header="false">
                                    <div>
                                        <div>
                                            学院:
                                            <el-select v-model="input" placeholder="请选择">
                                                <el-option v-for="item in college" :key="item.value" :label="item.text"
                                                    :value="item.value">
                                                </el-option>
                                            </el-select>
                                        </div> <br><br>
                                        <div>
                                            专业:
                                            <el-input v-model="userInfo.professional" placeholder="更改专业"></el-input>
                                        </div>
                                        <br><br>
                                        <div>
                                            班级:
                                            <el-input v-model="userInfo.org" placeholder="更改班级"></el-input>
                                        </div>
                                        <br><br>
                                        <div>
                                            姓名:
                                            <el-input v-model="userInfo.name" placeholder="更改姓名"></el-input>
                                        </div>
                                         <br><br>

                                        <!-- <div>
                                            创建时间:
                                            <el-input v-model="userInfo.createTime" placeholder="创建时间"></el-input>
                                        </div>
                                        <br><br> -->

                                        <div>
                                            用户名:
                                        <el-input v-model="userInfo.username" placeholder="更改用户名"></el-input>
                                        </div>
                                        <br><br>

                                        <div>
                                            密码:
                                        <el-input v-model="userInfo.password" placeholder="更改密码"></el-input>
                                        </div>
                                        <br><br>

                                        <div>
                                            学号:
                                        <el-input v-model="userInfo.studentId" placeholder="更改学号"></el-input>
                                        </div>
                                        <br><br>

                                        <!-- <div>
                                            登录时间:
                                        <el-input v-model="userInfo.loginTime" placeholder="更改登陆时间"></el-input>
                                        </div>
                                        <br><br>
                                        -->
                                        <!-- <div>
                                            创建人:
                                        <el-input v-model="userInfo.createBy" placeholder="更改创建人"></el-input>
                                        </div>
                                        <br><br>  -->


                                        <el-button type="primary" @click="updateUserInfo()">提交</el-button>
                                    </div>
                                </el-drawer>


                                <el-link type="success" @click="deleteById(obj.id)">删除</el-link>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <el-pagination :page-size="100" :pager-count="11" @current-change="getMerchantInformation"
                    layout="prev, pager, next" :total="count">
                </el-pagination>
            </div>
        </section>

        <!-- View content  -->
        <section v-else class="table">
            <!-- 用户名 -->
            <div class="row" >
            <div>
                <div class="cell key">
                        用户名
                    </div>
                <div class="cell value">
                    {{ schoolView.username }}
                </div>
            </div>
            </div>

            <!-- 密码 -->
            <div class="row">
            <div>
                <div class=" cell key">
                    密码
                </div>
                <div class="cell value">
                    {{ schoolView.password }}
                </div>
            </div>
            </div>

            <!-- 学号 -->
                <div class="row">
                <div>
                    <div class=" cell key">
                        学号
                    </div>
                    <div class="cell value">
                        {{ schoolView.studentId }}
                    </div>
                </div>
                </div>

                <!-- 登录时间 -->
                <!-- <div class="row">
                <div>
                    <div class=" cell key">
                        登录时间
                    </div>
                    <div class="cell value">
                        {{ schoolView.loginTime }}
                    </div>
                </div>
                </div> -->

                <!-- 创建人 -->
                <!-- <div class="row">
                <div>
                    <div class=" cell key">
                        创建人
                    </div>
                    <div class="cell value">
                        {{ schoolView.createBy }}
                    </div>
                </div>
                </div> -->

            <div class="check">
                <div >
                    <el-link type="primary" @click="openUpdateUserInfoWindows(schoolView.id)">修改</el-link>
                </div>
                <div >
                    <el-link type="success" @click="deleteById(schoolView.id)">删除</el-link>
                </div>
            </div>


        </section>

    </div>
</template>

<script>

import { synRequestPost, synRequestGet } from "../../static/request"

export default {
    data() {
        return {
            // 添加
            drawer: false,
            direction: 'ltr',
            addInfo: {
                name: "",
                username: "",
                password: "",
                org: '',
            },

            token: getCookie("token"),
            user: {
                username: "",
                password: "",
            },
            //查看
            schoolView: {

            },
            //按钮开关
            switchbutton: false,
            //用户数据集合
            list: null,
            count: 0,

            //分页查询
            pagingToGetUserDataBo: {
                start: 0,
                size: 100,
                name: "",
                status: 0,
                delFlag: 0,
            },

            //通过id删除
            userDeleteByIdBo: {
                token: "",
                id: -1
            },

            //查重用户通过id
            userSelectByUserIdBo: {
                token: "",
                id: -1,
            },

            //修改窗口
            updateWindows: false,

            //用户信息
            userInfo: {
                id: -1,
                username: "",
                password: "",
                name: "",
                college: '',
                studentId: '',
                org: '',
                professional: '',
                grade: '',
                // loginTime: '',
                // createBy: '',
                // createTime: '',
                // updateBy: '',
                // updateTime: '',
                // status: '',
            },
            //更新用户信息
            userUpdateByUserIdBo: {
                token: "",
                user: {
                    id: -1,
                    username: "",
                    password: "",
                    name: "",
                    college: '',
                    studentId: '',
                    org: '',
                    professional: '',
                    grade: '',
                    // loginTime: '',
                    // createBy: '',
                    // createTime: '',
                    // updateBy: '',
                    // updateTime: '',
                    // status:'',
                }
            },
            //查看
            view: true,
            input: '',
            //学院信息
            college: [
                {
                    value: 1,
                    text: '信息学院'
                },
                {
                    value: 2,
                    text: '财经学院'
                },
                {
                    value: 3,
                    text: '艺术与传媒学院'
                },
                {
                    value: 4,
                    text: '通识学院'
                }
            ],
        }
    },
    mounted() {
        this.userDeleteByIdBo.token = getCookie("token");
        this.getMerchantInformation(1)
    },

    methods: {
        /**
         *  修改用户信息
         */
        async updateUserInfo() {
            //todo userInfo 要求username 和password 和name 不可以为空
            this.userUpdateByUserIdBo.token = this.token;
            this.userUpdateByUserIdBo.user.id = this.userInfo.id;
            this.userUpdateByUserIdBo.user.username = this.userInfo.username;
            this.userUpdateByUserIdBo.user.password = this.userInfo.password;
            this.userUpdateByUserIdBo.user.name = this.userInfo.name;
            this.userUpdateByUserIdBo.user.college = this.input;
            this.userUpdateByUserIdBo.user.studentId = this.userInfo.studentId;
            this.userUpdateByUserIdBo.user.org = this.userInfo.org;
            this.userUpdateByUserIdBo.user.professional = this.userInfo.professional;
            this.userUpdateByUserIdBo.user.grade = this.userInfo.grade;
            // this.userUpdateByUserIdBo.user.loginTime = this.userInfo.loginTime;
            this.userUpdateByUserIdBo.user.createTime = this.userInfo.createTime;
            this.userUpdateByUserIdBo.user.createBy = this.userInfo.createBy;
            // this.userUpdateByUserIdBo.user.updateBy = this.userInfo.updateBy;
            // this.userUpdateByUserIdBo.user.updateTime = this.userInfo.updateTime;

            console.log(this.userUpdateByUserIdBo);
            let obj = await synRequestPost("/user/update", this.userUpdateByUserIdBo);
            alert(obj.message);
            this.updateWindows = false
            this.getMerchantInformation(1);
        },

        //更新用户信息
        async openUpdateUserInfoWindows(id) {
            this.userSelectByUserIdBo.id = id;
            this.userSelectByUserIdBo.token = this.token;
            let obj = await synRequestPost("/user/select", this.userSelectByUserIdBo);
            this.userInfo = obj.data;
            // this.userInfo.college = this.college[this.userInfo.college]
            console.log(this.userInfo);
            this.view = true
            this.updateWindows = true;
        },

        //跳转指定页面
        async getMerchantInformation(val) {
            this.pagingToGetUserDataBo.start = (val - 1) * this.pagingToGetUserDataBo.size;
            let obj = await synRequestPost("/user/findAll", this.pagingToGetUserDataBo);
            console.log(obj);
            if (obj.code == "0x200") {
                this.list = obj.data;

            }
        },

        //删除用户通过id
        async deleteById(id) {
            this.userDeleteByIdBo.id = id;
            this.userDeleteByIdBo.token = this.token;
            let obj = await synRequestPost("/user/delete", this.userDeleteByIdBo);
            alert(obj.message);
            this.getMerchantInformation(1);

        },

        //查看功能
        openView(obj) {
            this.view = false
            console.log(obj);
            if (obj.college) {
                obj.college = this.college[obj.college].text
            }
            this.schoolView = obj
        },
        // 关闭添加功能
        // handleClose(done) {
        //     this.$confirm('确认关闭？')
        //         .then(_ => {
        //             done();
        //         })
        //         .catch(_ => { });
        // },
        // 添加功能
        submitAdd(obj) {
            console.log(obj);
            this.addInfo = obj;
            if (this.addInfo) {
                this.list.push(this.addInfo);
                this.addInfo = '';
            }
        }
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

.check  {
    display: flex;
    justify-content: center;
    flex-direction: row;
}
.check div {
    margin: 10px;
}

.key {
    margin: 15px;
    font-size: 22px;
}

.value {
    margin: 15px;
    font-size: 20px;
}

.table {
  display: table;
  width: 100%;
}


.row {
  display: table-row;
}

.cell {
  display: table-cell;
  padding: 8px; /* 可以调整单元格内边距 */
  /* border: 1px solid #ccc; 可以添加边框 */
}

.key {
  font-weight: bold; /* 可以使键加粗 */
}


</style>
