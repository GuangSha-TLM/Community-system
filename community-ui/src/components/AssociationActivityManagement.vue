<!--
 * @Author: tianleiyu 
 * @Date: 2023-11-10 13:39:11
 * @LastEditTime: 2023-11-10 19:27:13
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /community-ui/src/components/AssociationActivityManagement.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div>
        <div class="content">

            <el-button type="text" @click="dialogFormVisible = true">新增活动</el-button>

            <router-link class="item" v-for="(item, index) in list" :key="item.id"
                :to="{ name: 'ActivityItem', params: { id: item.id } }">
                <div class="item_id">{{ index + 1 }}</div>
                <div class="item_title">{{ item.title }}</div>
                <div class="item_time">{{ item.startTime }}</div>
                <!-- 删除按钮 -->
                <div class="item_del" @click="delActive(item.id)"><i class="el-icon-delete"></i></div>
                <div class="item_icon"><i class="el-icon-arrow-right"></i></div>
            </router-link>

            <el-dialog title="新增活动" :visible.sync="dialogFormVisible">
                <el-form :model="activeAddBo">
                    <el-form-item label="活动标题" :label-width="formLabelWidth">
                        <el-input v-model="activeAddBo.title" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="活动详细" :label-width="formLabelWidth">
                        <el-input v-model="activeAddBo.context" autocomplete="off"></el-input>
                    </el-form-item>
                    
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="close">取 消</el-button>
                    <el-button type="primary" @click="addActive">确 定</el-button>
                </div>
            </el-dialog>
        </div>
    </div>
</template>

<script>
import Foot from './fream/Foot.vue';
import Top from './fream/LoginTop.vue';
import { synRequestPost, synRequestGet } from "../../static/request"

export default {
    components: {
        Foot, Top
    },
    data() {
        return {
            token: getCookie("token"),
            //用户数据集合
            list: [],
            //分页查询
            pagingToGetUserDataBo: {
                start: 0,
                size: 100,
                name: "",
                status: 0,
                delFlag: 0,
            },
            dialogFormVisible: false,

            //添加活动
            activeAddBo:{
                token:'',
                title:'',
                context:''
                
            },
            formLabelWidth: '120px',
            // 删除活动
            activeDeleteByIdBo:{
                token :'',
                id:''
            }
        }
    },
    mounted() {
        this.getMerchantInformation();
    },

    methods: {
        //跳转指定页面
        async getMerchantInformation() {
            let obj = await synRequestPost(`/activity/selectByToken?token=${this.token}`);
            if (obj.code == "0x200") {
                this.list = obj.data;
            }
        },
        close(){
            this.dialogFormVisible = false
            this.activeAddBo.active.title = ''
            this.activeAddBo.active.context = ''
        },
        async addActive(){
            this.activeAddBo.token = this.token
            let obj = await synRequestPost('/activity/add', this.activeAddBo);
            if (obj.code == "0x200") {
                this.dialogFormVisible = false
                this.$message({
                    message: '增加成功!',
                    type: 'success'
                });
                this.getMerchantInformation();
            }
        },
        async delActive(id){
            this.activeDeleteByIdBo.token = this.token
            this.activeDeleteByIdBo.id = id
            let obj = await synRequestPost('/activity/delete', this.activeDeleteByIdBo);
            if (obj.code == "0x200") {
                this.$message({
                    message: '删除成功',
                    type: 'success'
                });
                this.getMerchantInformation();
            }
        }

    },
    watch: {

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
.item_del{
    color: #67C23A;
}

</style>
