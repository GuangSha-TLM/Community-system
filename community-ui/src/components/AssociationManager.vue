<template>
    <div>
        <div class="content">
            <section>
                <div class="container">
                    <!-- 发起签到按钮 与 拉取人员按钮-->
                    <div class="top">
                        <div class="col-md-12">
                            <div class="card-header">
                                <h4 class="card-title">
                                    <button class="btn btn-primary" @click="SignInWindow = true">发起签到</button>
                                    <button class="btn btn-primary" @click="dialogVisible = true">拉取人员</button>

                                </h4>
                            </div>
                        </div>

                    </div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">序号</th>
                                <th scope="col">名字</th>
                                <th scope="col">年级</th>
                                <th scope="col">班级</th>
                                <th scope="col">学号</th>
                                <th scope="col">操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(obj, index) in list" :key="obj.id">
                                <th scope="row">{{ index + 1 }}</th>
                                <td>{{ obj.name }}</td>
                                <td>{{ obj.grade }}</td>
                                <td>{{ obj.professional }}</td>
                                <td>{{ obj.studentId }}</td>
                                <td>
                                    <el-link type="success" @click="deleteById(obj.userId)">删除</el-link>
                                </td>
                            </tr>

                        </tbody>
                    </table>

                    <el-dialog title="拉取用户" :visible.sync="dialogVisible" width="80%" top="0">
                        <ClassManagement></ClassManagement>
                    </el-dialog>

                    <el-dialog title="发起签到" :visible.sync="SignInWindow" width="50%">
                        <el-input v-model="sendNotificationBo.content" placeholder="请输入签到内容"></el-input>
                        <span slot="footer" class="dialog-footer">
                            <el-button @click="SignInWindow = false">取 消</el-button>
                            <el-button type="primary" @click="showModal">确 定</el-button>
                        </span>
                    </el-dialog>
                </div>
            </section>
        </div>

    </div>
</template>

<script>
import ClassManagement from "./ClassManagement.vue"
import { synRequestPost, synRequestGet } from "../../static/request"

export default {
    data() {
        return {
            //控制拉取人员弹窗
            dialogVisible: false,
            // 签到弹窗
            SignInWindow: false,
            communityUserdeleteUserBo: {
                token: '',
                userId: ''
            },
            token: getCookie("token"),
            communitySelectByIdBo: {
                token: "",
                id: this.$route.params.id
            },
            list: [],
            //签到信息
            sendNotificationBo:{
                token:'',
                content:''
            }
        }
    },
    mounted() {
        this.getMerchantInformation()
    },

    components: {
        ClassManagement
    },
    methods: {

        async showModal() {
            this.sendNotificationBo.token = this.token
            let obj = await synRequestPost("/community/sendNotification",this.sendNotificationBo);
            console.log(obj);
            this.SignInWindow= false
        },

        //跳转指定页面
        async getMerchantInformation() {
            let res = await synRequestPost(`/community/communityAndUser?token=${this.token}`);
            if (res.code == "0x200") {
                this.list = res.data;
            }
            // console.log(this.list);
        },
        async deleteById(id) {
            if (confirm('确定要移除该用户吗？')) {
                console.log(id);
                this.communityUserdeleteUserBo.token = this.token;
                this.communityUserdeleteUserBo.userId = id;
                let obj = await synRequestPost("/communityUser/communityUserdeleteUser",
                    this.communityUserdeleteUserBo
                );
                if (obj.code === "0x200") {
                    this.$message({
                        showClose: true,
                        message: '删除成功!',
                        type: 'success'
                    });
                    this.getMerchantInformation();
                } else {
                    this.$message.error(`修改失败,${obj.message}!`);
                }
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

.but {
    border: none;
    background-color: #fff;
    color: #42b983;
}

</style>
