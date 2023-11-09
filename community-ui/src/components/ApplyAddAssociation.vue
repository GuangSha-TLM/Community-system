<!--
 * @Author: tianleiyu 
 * @Date: 2023-11-02 14:08:57
 * @LastEditTime: 2023-11-07 18:30:53
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /community-ui/src/components/ApplyAddAssociation.vue
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
                                <th scope="col">社团名</th>
                                <th scope="col">社团介绍</th>
                                <th scope="col">创建用户</th>
                                <th scope="col">操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(obj, index) in list" :key="index">
                                <th scope="row">{{ index + 1 }}</th>
                                <td>{{ obj.name }}</td>
                                <td>{{ obj.introduce }}</td>
                                <td>{{ obj.username }}</td>
                                <td>
                                    <el-link type="success" @click="applyCommunity(index)">申请加入</el-link>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <el-dialog title="申请原因" :visible.sync="dialogVisible" width="30%">
                        <el-input v-model="applyIndexCommunity.text" placeholder="输入你想申请的原因"></el-input>
                        <span slot="footer" class="dialog-footer">
                            <el-button @click="dialogVisible = false">取 消</el-button>
                            <el-button type="primary" @click="applyForCommunity">确 定</el-button>
                        </span>
                    </el-dialog>

                </div>
            </section>
        </div>

    </div>
</template>

<script>

import { synRequestPost, synRequestGet } from "../../static/request"

export default {
    data() {
        return {
            list: [],
            dialogVisible: false,
            token: getCookie("token"),
            id: this.$route.params.id,
            communitySendNoticeBo: {
                token: '',
                applyContext: "",
                communityId: '',
                communityAdminName: ''
            },
            applyIndexCommunity: {
                token: '',
                text: "",
                communityId: '',
                communityAdminName: ''
            }

        }
    },
    mounted() {
        this.getMerchantInformation()
    },

    methods: {
        async applyForCommunity() {
            this.communitySendNoticeBo.token = this.token;
            this.communitySendNoticeBo.applyContext = this.applyIndexCommunity.text;
            this.communitySendNoticeBo.communityId = this.applyIndexCommunity.communityId;
            this.communitySendNoticeBo.communityAdminName = this.applyIndexCommunity.communityAdminName;
            let obj = await synRequestPost("/community/send_notice", this.communitySendNoticeBo);
            if (obj.code == "0x200") {
            this.$message({
          showClose: true,
          message: '发送成功!',
          type: 'success'
        });
            this.dialogVisible = false;}
        },
        applyCommunity(index) {
            this.applyIndexCommunity.communityId = this.list[index].communityId;
            this.applyIndexCommunity.communityAdminName = this.list[index].communityAdminName;
            this.dialogVisible = true;
        },
        //跳转指定页面
        async getMerchantInformation() {
            let obj = await synRequestPost("/community/communityAllname");
            
            if (obj.code == "0x200") {
                this.list = obj.data;
            }
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
