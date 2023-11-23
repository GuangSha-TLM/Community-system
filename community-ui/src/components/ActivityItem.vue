<!--
 * @Author: tianleiyu
 * @Date: 2023-10-29 13:15:48
 * @LastEditTime: 2023-11-19 12:36:46
 * @LastEditors: tianleiyu
 * @Description:
 * @FilePath: /community-ui/src/components/ActivityItem.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div>
        <!-- <div>
            <Top></Top>
        </div> -->

        <div class="content" >
            <div class="title">
                {{ list.activeToGetBo.title }}
            </div>
            <div class="item_list">
                <div class="item">
                    创建时间: {{ list.activeToGetBo.createTime }}
                </div>
                <div class="item">
                    <router-link :to="{name:'ApplyAddAssociation',
                    params:{id:list.communityInActiveBo.id}}">社团:{{ list.communityInActiveBo.name }}</router-link>

                </div>
                <div class="item">
                    创建人:{{ list.communityInActiveBo.username }}
                </div>
            </div>
            <div class="context" v-html="list.activeToGetBo.context">

            </div>

        </div>


        <!-- <footer class="position-relative" id="footer-main">
            <Foot></Foot>
        </footer> -->
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
            activeSelectByIdBo: {
                token: "",
                id: this.$route.params.id
            },
            list:{

            }
        }
    },

    mounted() {
        this.getActiveInfo()
    },

    methods: {
        //获取活动详情
        async getActiveInfo() {
            this.activeSelectByIdBo.token = this.token;
            console.log(this.activeSelectByIdBo);
            let obj = await synRequestPost("/activity/select", this.activeSelectByIdBo);
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
    color: black;
}

.content {
    width: 70%;
    margin: 0 15%;
    display: flex;
    flex-direction: column;
}
.title{
    font-size: 70px;
}
.item_list{
    display: flex;
    justify-content: space-around;
}

.context{
    margin-top: 30px;
}
img{
    width: 100%;
    height: auto;
}
</style>
