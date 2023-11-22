<template>
    <div>
        <!-- Main content -->
        <section>
            <div class="container">
                <!-- 下拉表格 -->
                <div class="bigfrom">
                    <div class="form-group">
                        <label for="exampleInputgrand">选择你的学院</label>
                        <el-select v-model="selectInfo.college" placeholder="请选择" style="width: 100%;">
                            <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputprofessional">选择你的专业</label>
                        <el-select v-model="selectInfo.professional" placeholder="请选择" style="width: 100%;">

                            <el-option-group v-for="group in professionalList[selectInfo.college - 1]" :key="group.value"
                                :label="group.label">
                                <el-option v-for="item in group.professionalList" :key="item.professionalList"
                                    :label="item.label" :value="item">
                                </el-option>
                            </el-option-group>

                        </el-select>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputgrand">选择你的年级</label>
                        <el-select v-model="selectInfo.grade" placeholder="请选择" style="width: 100%;">
                          <el-option v-for="item in yearsList"
                                     :key="item"
                                     :label="item"
                                     :value="item"
                          >
                            </el-option>
                        </el-select>
                    </div>
                    <div class="form-group but">
                        <button class="btn btn-primary" style="width:10%;margin-top:10px" @click="selectForm()"
                            :disabled="switchbutton">查询</button>
                    </div>

                </div>
                <!-- =========================================== -->
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">序号</th>
                            <th scope="col">姓名</th>
                            <th scope="col">学院</th>
                            <th scope="col">专业</th>
                            <th scope="col">年级</th>
                            <th scope="col">操作</th>
                        </tr>

                    </thead>
                    <tbody>
                        <tr v-for="(obj, index) in list" :key="obj.index">
                            <th scope="row">{{ index + 1 }}</th>
                            <td>{{ obj.name }}</td>
                            <td>{{ obj.college }}</td>
                            <td>{{ obj.professional }}</td>
                            <td>{{ obj.grade }}</td>
                            <td>
                                <!-- 拉取功能 -->
                                <el-link type="primary" @click="Pulling(obj.id)">拉取</el-link>

                                <el-link type="primary" @click="openUpdateuserInfoWindows(obj.id)">修改</el-link>
                                <!-- 修改窗口 -->
                                <el-drawer title="我是标题" :visible.sync="updateWindows" :with-header="false">
                                    <div>

                                        <div>
                                            学院:
                                            <el-select v-model="college" placeholder="请选择">
                                                <el-option v-for="item in options" :key="item.value" :label="item.label"
                                                    :value="item.value">
                                                </el-option>
                                            </el-select>
                                        </div>
                                        <br>
                                        专业:
                                        <el-select v-model="userInfo.professional" placeholder="请选择">
                                            <el-option-group v-for="group in professionalList[userInfo.college - 1]"
                                                :key="group.value" :label="group.label">
                                                <el-option v-for="item in group.professionalList"
                                                    :key="item.professionalList" :label="item.label" :value="item">
                                                </el-option>
                                            </el-option-group>
                                        </el-select>
                                        <br><br>
                                        <div>
                                            年级:
                                            <el-select v-model="userInfo.grade" placeholder="请选择">
                                                <el-option v-for="item in grandList" :key="item" :label="item"
                                                    :value="item">
                                                </el-option>
                                            </el-select>
                                        </div>
                                        <br><br>

                                        <el-button type="primary" @click="updateuserInfo()">提交</el-button>
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

    </div>
</template>

<script>

import { synRequestPost, synRequestGet } from "../../static/request"

export default {
    data() {
        return {
          yearsList: [],
            communityUserAddBo: {
                token: '',
                communityUser: {
                    userId: ''
                }
            },
            //下拉表选择
            //年级
            //获取今年年份-5，开始循环
            startYear: 2019,
            numYearsToShow: 5, // 显示最新的5个年份选项,
            userSelectToGetBo: {
                token: "",
                college: '',
                professional: '',
                grade: '',

            },
            //属性
            selectInfo: {
                college: '',
                professional: '',
                grade: ''
            },
            //学院
            options: [
                { value: 1, label: "信息学院" },
                { value: 2, label: "财经学院" },
                { value: 3, label: "艺术学院" },
                { value: 4, label: "通识学院" }
            ],
            //专业
            professionalList: [
                //信息学院
                [
                    {
                        value: 1,
                        label: '软件工程',
                        professionalList: ['软件工程1班', '软件工程2班', '软件工程3班', '软件工程4班', '软件工程5班', '软件工程6班']
                    }, {
                        value: 2,
                        label: '计算机科学与技术',
                        professionalList: ['计算机科学与技术1班', '计算机科学与技术2班', '计算机科学与技术3班',
                            '计算机科学与技术4班', '计算机科学与技术5班', '计算机科学与技术6班']
                    }, {
                        value: 3,
                        label: '电子商务',
                        professionalList: ['电子商务1班', '电子商务2班', '电子商务3班', '电子商务4班', '电子商务5班', '电子商务6班']
                    },

                ],
                //财经学院
                [
                    {
                        value: 1,
                        label: '审计学',
                        professionalList: ['审计学1班', '审计学2班', '审计学3班', '审计学4班', '审计学5班', '审计学6班']
                    }, {
                        value: 2,
                        label: '会计学',
                        professionalList: ['会计学1班', '会计学2班', '会计学3班', '会计学4班', '会计学5班', '会计学6班']
                    }, {
                        value: 3,
                        label: '国际经济与贸易',
                        professionalList: ['国际经济与贸易1班', '国际经济与贸易2班', '国际经济与贸易3班',
                            '国际经济与贸易4班', '国际经济与贸易5班', '国际经济与贸易6班']
                    }, {
                        value: 4,
                        label: '财务管理',
                        professionalList: ['财务管理1班', '财务管理2班', '财务管理3班', '财务管理4班', '财务管理5班', '财务管理6班']
                    }, {
                        value: 5,
                        label: '工商管理',
                        professionalList: ['工商管理1班', '工商管理2班', '工商管理3班', '工商管理4班', '工商管理5班', '工商管理6班']
                    }, {
                        value: 6,
                        label: '人力资源管理',
                        professionalList: ['人力资源管理1班', '人力资源管理2班', '人力资源管理3班',
                            '人力资源管理4班', '人力资源管理5班', '人力资源管理6班']
                    },

                ],
                //艺术学院
                [
                    {
                        value: 1,
                        label: '视觉传达设计',
                        professionalList: ['视觉传达设计1班', '视觉传达设计2班', '视觉传达设计3班',
                            '视觉传达设计4班', '视觉传达设计5班', '视觉传达设计6班']
                    }, {
                        value: 2,
                        label: '环境设计',
                        professionalList: ['环境设计1班', '环境设计2班', '环境设计3班', '环境设计4班', '环境设计5班', '环境设计6班']
                    }, {
                        value: 3,
                        label: '影视摄影与制作',
                        professionalList: ['影视摄影与制作1班', '影视摄影与制作2班', '影视摄影与制作3班',
                            '影视摄影与制作4班', '影视摄影与制作5班', '影视摄影与制作6班']
                    },

                ],
                //通识学院
                [
                    {
                        value: 1,
                        label: '汉语言文学',
                        professionalList: ['汉语言文学1班', '汉语言文学2班', '汉语言文学3班',
                            '汉语言文学4班', '汉语言文学5班', '汉语言文学6班']
                    }, {
                        value: 2,
                        label: '应用心理学',
                        professionalList: ['应用心理学1班', '应用心理学2班', '应用心理学3班',
                            '应用心理学4班', '应用心理学5班', '应用心理学6班']
                    }, {
                        value: 3,
                        label: '学前教育 (师范类)',
                        professionalList: ['学前教育 (师范类)1班', '学前教育 (师范类)2班', '学前教育 (师范类)3班',
                            '学前教育 (师范类)4班', '学前教育 (师范类)5班', '学前教育 (师范类)6班']

                    },

                ]
            ],

            //token值获取1
            token: getCookie("token"),
            //查看方法
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
                college: '',
                professional: '',
                grade: '',
                name: '',
            },
            //更新用户信息
            userUpdateByUserIdBo: {
                token: "",
                user: {
                    id: -1,
                    college: '',
                    professional: '',
                    grade: '',
                    name: '',
                }
            },
            //学院的
            college: '',
        }
    },
    mounted() {
        this.userDeleteByIdBo.token = getCookie("token");
        this.getMerchantInformation();
          const currentDate = new Date();
          const currentYear = currentDate.getFullYear();
          for (let i = currentYear - 4; i <= currentYear; i++) {
            this.yearsList.push(i);
          }
          console.log(this.yearsList);
    },
    methods: {
        /**
         *  修改用户信息
         */
        async updateuserInfo() {
            //todo userInfo 要求username 和password 和name 不可以为空
            this.userUpdateByUserIdBo.token = this.token;
            this.userUpdateByUserIdBo.user.college = this.college;
            this.userUpdateByUserIdBo.user.professional = this.userInfo.professional;
            this.userUpdateByUserIdBo.user.grade = this.userInfo.grade;
            this.userUpdateByUserIdBo.user.name = this.userInfo.name;
            this.userUpdateByUserIdBo.user.id = this.userInfo.id;
            console.log(this.userUpdateByUserIdBo);
            let obj = await synRequestPost("/user/update", this.userUpdateByUserIdBo);
            if (obj.code == "0x200") {
                this.$message({
                    showClose: true,
                    message: '修改成功!',
                    type: 'success'
                });
            }
            this.updateWindows = false
            this.getMerchantInformation(1);
        },

        //更新用户信息
        async openUpdateuserInfoWindows(id) {
            this.userSelectByUserIdBo.id = id;
            this.userSelectByUserIdBo.token = this.token;
            let obj = await synRequestPost("/user/select", this.userSelectByUserIdBo);
            this.userInfo = obj.data;
            this.view = true
            this.updateWindows = true;
        },

        //跳转指定页面
        async getMerchantInformation(val) {
            this.pagingToGetUserDataBo.start = (val - 1) * this.pagingToGetUserDataBo.size;
            let obj = await synRequestPost("/user/findAll", this.pagingToGetUserDataBo);
            if (obj.code == "0x200") {
                this.list = obj.data;
                for (let i = 0; i < this.list.length; i++) {
                    this.list[i].college = this.options[this.list[i].college - 1].label
                }
            }
        },

        //删除用户通过id
        async deleteById(id) {
            this.userDeleteByIdBo.id = id;
            this.userDeleteByIdBo.token = this.token;
            let obj = await synRequestPost("/user/delete", this.userDeleteByIdBo);
            if (obj.code == "0x200") {
                this.$message({
                    showClose: true,
                    message: '修改成功!',
                    type: 'success'
                });
            } else {
                this.$message.error('修改失败!');
            }
            this.getMerchantInformation(1);

        },
        //下拉列表接口
        async selectForm() {
            this.list = [];
            this.userSelectToGetBo.token = this.token;
            this.userSelectToGetBo.college = this.selectInfo.college;
            this.userSelectToGetBo.grade = this.selectInfo.grade;
            this.userSelectToGetBo.professional = this.selectInfo.professional;
            let obj = await synRequestPost("/user/selectToGetUser", this.userSelectToGetBo);
            if (obj.code == "0x200") {
                this.list = obj.data.list;
                if (this.list.length == 0) {
                    this.$message.error('暂无数据!');
                }
            } else {
                this.$message.error('查询失败');
            }
            this.list = obj.data.list;
        },

        //拉取功能
        async Pulling(id) {
            this.communityUserAddBo.token = this.token;
            this.communityUserAddBo.communityUser.userId = id;
            let obj = await synRequestPost("/communityUser/communityUserAdd", this.communityUserAddBo);
            if (obj.code == "0x200") {
                //拉取成功弹窗
                this.$message({
                    message: '添加成功',
                    type: 'success'
                });
            } else {
                this.$message.error('添加失败');
            }
        },

    },
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

.check {
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
    padding: 8px;
    /* 可以调整单元格内边距 */
    /* border: 1px solid #ccc; 可以添加边框 */
}

.key {
    font-weight: bold;
    /* 可以使键加粗 */
}

.form-group {
    margin-right: 10px;
    float: left;
    width: 20%;
}

.but {
    display: flex;
}

.bigfrom {
    display: flex;
    align-items: flex-end;
}
</style>
