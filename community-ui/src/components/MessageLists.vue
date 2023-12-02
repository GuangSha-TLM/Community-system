<!--
 * @Author: tianleiyu
 * @Date: 2023-11-05 20:12:55
 * @LastEditTime: 2023-12-02 15:30:35
 * @LastEditors: tianleiyu
 * @Description:
 * @FilePath: /community-ui/src/components/MessageLists.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div>
        <div class="content">
            <section>
                <div class="container">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">序号</th>
                                <th scope="col">简要</th>
                                <th scope="col">申请人</th>
                                <th scope="col">申请原因</th>
                                <th scope="col">操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(obj, index) in messageList" :key="obj.id">

                                <th scope="row"><el-badge style="margin: 0;" :is-dot="obj.read == 0"
                                        class="item"></el-badge>{{ index + 1 }}
                                </th>
                                <td>{{ obj.noticeName }}</td>
                                <td>{{ obj.name }}</td>
                                <td>{{ obj.context }}</td>
                                <td>
                                    <el-link v-if="obj.kinds == 0" type="success" @click="read(index)">标为已读</el-link>
                                    <el-link v-else type="success" @click="manage(index)">去处理</el-link>
                                </td>

                            </tr>
                        </tbody>
                    </table>

                </div>
            </section>

            <el-dialog :title="title" :visible.sync="dialogVisible" width="30%" @close="close">
                <span slot="footer" class="dialog-footer">
                    <el-input placeholder="请输入内容" v-model="communityReplyNoticeBo.content" clearable>
                    </el-input>
                    <el-button class="but" v-if="signIn" @click="sign()">签到</el-button>
                    <div v-else class="but">
                        <el-button @click="applyForCommunity(1)">拒绝</el-button>
                        <el-button type="primary" @click="applyForCommunity(0)">同意</el-button>
                    </div>

                </span>
            </el-dialog>
        </div>

    </div>
</template>

<script>
import { synRequestPost, synRequestGet } from "../../static/request"

export default {
    data() {
        return {
            token: getCookie("token"),
            messageList: [],
            noticeSelectByNoticeIdBo: {
                token: '',
                id: ''
            },
            dialogVisible: false,
            communityReplyNoticeBo: {
                token: '',
                content: '',
                noticeId: '',
                result: ''
            },
            //回复的头
            title: '是否通过?',
            //判断回复的是否是一个签到
            signIn: false,
            //签到回复的内容
            receiveNotificationsBo:{
                token:'',
                content:'',
                noticeId:''
            },
            

        }
    },
    //接收LoginTop的'MessageList'
    created() {
        this.$bus.$on('MessageList', this.UpdatedMessageList);
    },
    mounted() {
        this.getMerchantInformation()
    },
    methods: {
        async sign(){
            this.receiveNotificationsBo.token = this.token;
            this.receiveNotificationsBo.content = this.communityReplyNoticeBo.content;
            console.log(1111);
            let obj = await synRequestPost("/community/receiveNotificationsNew", this.receiveNotificationsBo);
            console.log(obj);
            this.communityReplyNoticeBo.content=''
            this.dialogVisible= false
        },
        //发送空的MessageLists给LoginTop，解决刷新数据为空问题
        async getMerchantInformation() {
            this.$bus.$emit('messageListEmpty');
        },
        async manage(index) {
            if (this.messageList[index].kinds === 2) {
                this.title = '签到'
                this.signIn= true
            } else if (this.messageList[index].kinds === 1) {
                this.title = '是否同意?'
                this.signIn = false
            }
            if (this.messageList[index].dealt != 0) {
                this.$message({
                    showClose: true,
                    message: '这条数据不需要处理!',
                    type: 'warning'
                });
            } else {
                this.read(index);
                this.dialogVisible = true;
            }
        },
        async read(index) {
            this.noticeSelectByNoticeIdBo.token = this.token
            console.log(index);
            this.noticeSelectByNoticeIdBo.id = this.messageList[index].id
            this.communityReplyNoticeBo.noticeId = this.messageList[index].id
            this.receiveNotificationsBo.noticeId = this.messageList[index].id
            let obj = await synRequestPost("/notice/select_id", this.noticeSelectByNoticeIdBo);
            this.getMerchantInformation();
        },
        async applyForCommunity(value) {
            this.communityReplyNoticeBo.token = this.token
            this.communityReplyNoticeBo.result = value
            let obj = await synRequestPost("/community/reply_notice", this.communityReplyNoticeBo);
            if (obj.code == "0x200") {
                this.dialogVisible = false;
                this.$message({
                    showClose: true,
                    message: '回复成功!',
                    type: 'success'
                });
                this.getMerchantInformation()
            }
        },
        //关闭的回调
        close() {
            this.dialogVisible = false;
            this.communityReplyNoticeBo.context = ''
            this.getMerchantInformation()
        },
        // 将传入的MessageList进行更新
        UpdatedMessageList(MessageList) {
            // 处理更新后的 messageList
            this.messageList = MessageList;
        }
    },
    watch: {
        messageList(newMessageList) {
            if (newMessageList == undefined || newMessageList.length == 0) {
                this.getMerchantInformation()
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
    color: black;
}

.content {
    width: 70%;
    margin: 0 15%;
}

.item {
    width: 100%;
    display: flex;
    justify-content: space-between;
    margin: 20px 0;
}

.active {
    background-color: #42b983;
}

.but{
    margin: 10px 0;
}
/deep/ .el-badge__content {
    right: 0;
    left: 0;
    top: 13px
}
</style>
