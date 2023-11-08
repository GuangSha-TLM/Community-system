<template>
    <div>
        <div class="content">
            <section>
                <div class="container">
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
                                    <el-link type="success" @click="deleteById(obj.id)">删除</el-link>
                                </td>
                            </tr>
                        </tbody>
                    </table>
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
            token: getCookie("token"),
            communitySelectByIdBo: {
                token: "",
                id: this.$route.params.id
            },
            list: []
        }
    },
    mounted() {
        this.getMerchantInformation()
    },

    methods: {


        //跳转指定页面
        async getMerchantInformation() {
            // this.communitySelectByIdBo.token = this.token;
            // let obj = await synRequestPost("/community/select", this.communitySelectByIdBo);
            // console.log(obj);
            // if (obj.code == "0x200") {
            //     this.list = obj.data;
            // }
            let res = await synRequestPost(`/community/communityAndUser?token=${this.token}`);
            if (res.code == "0x200") {
                this.list = res.data;
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
