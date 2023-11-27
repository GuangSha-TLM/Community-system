<!--
 * @Author: tianleiyu
 * @Date: 2023-10-29 17:49:10
 * @LastEditTime: 2023-11-20 21:30:26
 * @LastEditors: tianleiyu
 * @Description:
 * @FilePath: /community-ui/src/components/UserCenter.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div>
        <el-collapse v-model="activeName" accordion>
            <el-collapse-item title="用户信息" name="1">
                <Userinfo/>
            </el-collapse-item>
            <router-link to="/AssociationManager" v-if="user.role > 1">
                <el-collapse-item title="社团管理" name="2"/>
            </router-link>
            <router-link to="/AssociationActivityManagement" v-if="user.role > 1">
            <el-collapse-item title="活动管理" name="3"/>
        </router-link>
        </el-collapse>
    </div>
</template>

<script>
import Userinfo from "./Userinfo";
import { synRequestPost, synRequestGet } from "../../static/request"

export default {
    data() {
        return {
            token: getCookie("token"),

            user: JSON.parse(localStorage.getItem("user")),
            activeName:0,
        }
    },
    mounted() {

    },
    methods: {
        //跳转指定页面
        async getMerchantInformation() {
        },
    },
    components: {
        Userinfo,
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
