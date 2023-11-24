<template>
    <div>
        <div class="content">
            <router-link class="item" v-for="(item,index) in list" :key="item.id"
                :to="{ name: 'ActivityItem', params: { id: item.id } }">
                <div class="item_id">{{ index + 1 }}</div>
                <div class="item_title">{{ item.title }}</div>
                <div class="item_time">{{ item.startTime }}</div>
                <div class="item_icon"><i class="el-icon-arrow-right"></i></div>
            </router-link>
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

        }
    },
    mounted() {
        //接收LoginTop的数据
        this.$bus.$on("searchList", this.handleParamsChange);

        this.getMerchantInformation();
    },

    methods: {

        //跳转指定页面
        async getMerchantInformation() {
            let obj = await synRequestPost("/activity/findAll");
            if (obj.code == "0x200") {
                this.list = obj.data;
            }
        },
        handleParamsChange(data) {
            this.list= [ ]
               console.log(data);
            this.list = data;
        },

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
</style>
