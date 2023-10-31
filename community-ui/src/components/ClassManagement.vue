<template>
    <div>
        <!-- Main content -->
        <section v-if="view">
            <div class="container">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">序号</th>
                            <th scope="col">学院</th>
                            <th scope="col">专业</th>
                            <th scope="col">年级</th>
                            <th scope="col">班级名</th>
                            <th scope="col">操作</th>
                        </tr>

                    </thead>
                    <tbody>
                        <tr v-for="obj in list" :key="obj.index">
                            <th scope="row">{{ obj.id }}</th>
                            <td>{{ obj.college }}</td>
                            <td>{{ obj.professional }}</td>
                            <td>{{ obj.grade }}</td>
                            <td>{{ obj.name }}班</td>
                            <td>
                                <el-link type="primary" @click="openView(obj)">查看</el-link>

                                <el-link type="primary" @click="openUpdateorgInfoWindows(obj.id)">修改</el-link>

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
                                            年级:
                                            <el-input v-model="orgInfo.grade" placeholder="更改年级"></el-input>
                                        </div> <br><br>
                                       
                                        <el-button type="primary" @click="updateorgInfo()">提交</el-button>
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
            token: getCookie("token"),
            //查看
            schoolView: {

            },
            //按钮开关
            switchbutton: false,
            //用户数据集合
            list: null,
            count: 0,

            //分页查询
            orgPagingToGetDataBo: {
                start: 0,
                size: 100,
                name: "",
                status: 0,
                delFlag: 0,
            },

            //通过id删除
            orgDeleteByIdBo: {
                token: "",
                id: -1
            },

            //查重用户通过id
            orgSelectByIdBo: {
                token: "",
                id: -1,
            },

            //修改窗口
            updateWindows: false,

            //用户信息
            orgInfo: {
                id: -1,
                college: '',
                professional: '',
                grade: '',
                name: '',
            },
            //更新用户信息
            orgUpdateByIdBo: {
                token: "",
                org: {
                    id: -1,
                    college: '',
                    professional: '',
                    grade: '',
                    name: '',
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
        this.orgDeleteByIdBo.token = getCookie("token");
        this.getMerchantInformation(1)
    },

    methods: {
        /**
         *  修改用户信息
         */
        async updateorgInfo() {
            //todo orgInfo 要求username 和password 和name 不可以为空
            this.orgUpdateByIdBo.token = this.token;
            this.orgUpdateByIdBo.org.college = this.input;
            this.orgUpdateByIdBo.org.professional = this.orgInfo.professional;
            this.orgUpdateByIdBo.org.grade = this.orgInfo.grade;
            this.orgUpdateByIdBo.org.name = this.orgInfo.name;
            this.orgUpdateByIdBo.org.id = this.orgInfo.id;
            console.log(this.orgUpdateByIdBo);
            let obj = await synRequestPost("/org/update", this.orgUpdateByIdBo);
            alert(obj.message);
            this.updateWindows = false
            this.getMerchantInformation(1);
        },

        //更新用户信息
        async openUpdateorgInfoWindows(id) {
            this.orgSelectByIdBo.id = id;
            this.orgSelectByIdBo.token = this.token;
            let obj = await synRequestPost("/org/select", this.orgSelectByIdBo);
            this.orgInfo = obj.data;
            // this.orgInfo.college = this.college[this.orgInfo.college]
            console.log(this.orgInfo);
            this.view = true
            this.updateWindows = true;
        },

        //跳转指定页面
        async getMerchantInformation(val) {
            this.orgPagingToGetDataBo.start = (val - 1) * this.orgPagingToGetDataBo.size;
            let obj = await synRequestPost("/org/selectall", this.orgPagingToGetDataBo);
            console.log(obj);
            if (obj.code == "0x200") {
                this.list = obj.data;

            }
        },

        //删除用户通过id
        async deleteById(id) {
            this.orgDeleteByIdBo.id = id;
            this.orgDeleteByIdBo.token = this.token;
            let obj = await synRequestPost("/org/delete", this.orgDeleteByIdBo);
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
</style>
