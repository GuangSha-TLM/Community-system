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
                                    <button class="btn btn-primary" @click="lookSignInWindow = true">查看签到状态</button>
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
                        <el-slider v-model="sendNotificationBo.signInTime" :min="1" :max="10"></el-slider>{{
                            sendNotificationBo.signInTime }} 分钟
                        <span slot="footer" class="dialog-footer">
                            <el-button @click="SignInWindow = false">取 消</el-button>
                            <el-button type="primary" @click="showModal">确 定</el-button>
                        </span>
                    </el-dialog>
                    <el-dialog title="查看签到人员" :visible.sync="lookSignInWindow" width="50%">
                        <div class="showSign">
                            <div class="left">
                            <p>已签到:</p>
                            <div v-for="(item, index) in signedData" :key="index">
                                {{ item.name }}
                            </div>
                        </div>
                        <div class="right">
                            <p>未签到:</p>
                            <div v-for="(item, index) in unsignedData" :key="index">
                                {{ item.name }}
                            </div>
                        </div>
                        </div>
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
            // 查看签到人员的弹窗
            lookSignInWindow: false,
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
            sendNotificationBo: {
                token: '',
                content: '',
                signInTime: 0
            },
            //websockt
            ws: {},
            user: JSON.parse(localStorage.getItem("user")),
            socket: null,
            webSocketIp: "127.0.0.1",
            webSocketPort: 8008,

            signInFrom: [],
            // adminCheckInStatusInRealTimeBo:{
            //     token:'',
            //     content:''
            // }
        }
    },
    mounted() {
        this.getMerchantInformation()
        // this.setupWebSocket() 
        if (this.user.role > 0) {
            setInterval(() => {
                 // 替换为您的消息内容
                if (this.socket && this.socket.readyState === WebSocket.OPEN) {
                    // this.adminCheckInStatusInRealTimeBo.token= this.token
                    // this.adminCheckInStatusInRealTimeBo.content= this.sendNotificationBo.content
                    this.socket.send(this.token);
                }
            }, 500);
        }
    },

    components: {
        ClassManagement
    },
    methods: {
        setupWebSocket() {
            // const contestId = 80; // 用于示例的contest_id
            // alert(this.getHashVariable("contestId"));
            this.socket = new WebSocket("ws://" + this.webSocketIp + ":" + this.webSocketPort + `/websocket/${this.token}`);

            this.socket.onopen = () => {
                this.socketStatus = '已连接';
                console.log('连接成功');
            };

            this.socket.onmessage = (event) => {
                // console.log(event);
                let obj = JSON.parse(event.data);
                this.signInFrom = obj.data
                console.log(obj);
            };

            this.socket.onclose = () => {
                this.socketStatus = '已关闭';
                console.log("close");
            };
        },
        async showModal() {
            this.sendNotificationBo.token = this.token
            let obj = await synRequestPost("/community/sendNotificationNew", this.sendNotificationBo);
            if (obj.code == "0x200") {
                this.SignInWindow = false
                this.setupWebSocket()
            }
            // console.log(obj);
        },

        //跳转指定页面
        async getMerchantInformation() {
            let res = await synRequestPost(`/community/communityAndUser?token=${this.token}`);
            if (res.code == "0x200") {
                this.list = res.data;
                console.log(this.list);
            }
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

    },
    computed: {
        parsedData() {
            return this.signInFrom.map(item => {
                const [name, status] = item.split(/(已签到|未签到)/);
                return { name: name.trim(), status: status.trim() };
            });
        },
        signedData() {
            // console.log(this.parsedData);
            return this.parsedData.filter(item => item.status === '已签到');
        },
        unsignedData() {
            // console.log(this.parsedData);
            return this.parsedData.filter(item => item.status === '未签到');
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

.but {
    border: none;
    background-color: #fff;
    color: #42b983;
}
.card-title{
    display: flex;

}
.showSign{
    display: flex;
    justify-content: space-between
}
.showSign .left{
    width: 50%;
}
.showSign .right{
    width: 50%;
}
.el-input {
    margin-bottom: 30px;
}

</style>
