<!--
 * @Author: tianleiyu 
 * @Date: 2023-11-05 20:12:55
 * @LastEditTime: 2023-11-07 20:19:57
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
                            <tr v-for="(obj, index) in list" :key="obj.id" :class="{ active: (obj.read == 0) }">
                                <th scope="row">{{ index + 1 }}</th>
                                <td>{{ obj.noticeName }}</td>
                                <td>{{ obj.name }}</td>
                                <td>{{ obj.context }}</td>
                                <td>
                                    <el-link type="success" @click="manage(index)">去处理</el-link>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                </div>
            </section>

            <el-dialog title="是否通过?" :visible.sync="dialogVisible" width="30%" @close="close">
                <span slot="footer" class="dialog-footer">
                    <el-input placeholder="请输入内容" v-model="communityReplyNoticeBo.context" clearable>
                    </el-input>
                    <el-button @click="applyForCommunity(1)">拒绝</el-button>
                    <el-button type="primary" @click="applyForCommunity(0)">同意</el-button>
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
            list: [],
            noticeSelectByNoticeIdBo: {
                token: '',
                id: ''
            },
            dialogVisible: false,
            communityReplyNoticeBo: {
                token: '',
                context: '',
                noticeId: '',
                status: ''
            }

        }
    },
    mounted() {
        this.getMerchantInformation(),
        //接收信息
            this.$bus.$on('hello',(data)=>{
                if(this.list.length == 0){
                    this.list = data
                }
            })
    },

    methods: {
        //跳转指定页面
        async getMerchantInformation() {
            this.list = this.$route.params.list
        },
        async manage(index) {

            this.noticeSelectByNoticeIdBo.token = this.token
            this.noticeSelectByNoticeIdBo.id = this.list[index].id
            this.communityReplyNoticeBo.noticeId = this.list[index].id
            let obj = await synRequestPost("/notice/select_id", this.noticeSelectByNoticeIdBo);
            if (this.list[index].dealt != 0) {
                this.$message({
                    showClose: true,
                    message: '你已经处理过该条数据!',
                    type: 'warning'
                });
            }else{
                this.dialogVisible = true;
            }
        },
        async applyForCommunity(value) {
            this.communityReplyNoticeBo.token = this.token
            this.communityReplyNoticeBo.status = value
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
        }


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
</style>
