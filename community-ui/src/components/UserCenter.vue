<!--
 * @Author: tianleiyu 
 * @Date: 2023-10-29 17:49:10
 * @LastEditTime: 2023-10-29 17:49:11
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /community-ui/src/components/UserCenter.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div>
       
    </div>
</template>

<script>

import { synRequestPost, synRequestGet } from "../../static/request"

export default {
    data() {
        return {
            token: getCookie("token"),
            communitySelectByIdBo:{
                token:"",
                id:this.$route.params.id
            }
        }
    },
    mounted() {
        this.getMerchantInformation()
        console.log(this.$route.params);
    },

    methods: {
        

        //跳转指定页面
        async getMerchantInformation() {
            this.communitySelectByIdBo.token = this.token;
            let obj = await synRequestPost("/community/select", this.communitySelectByIdBo);
            console.log(obj);
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
