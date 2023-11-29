<!--
 * @Author: tianleiyu 
 * @Date: 2023-11-22 11:14:11
 * @LastEditTime: 2023-11-27 16:39:32
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /community-ui/src/components/Home.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div class="hello">
        <div class="top">
            <Top></Top>
        </div>
        <div class="content">
            <!-- <div class="left">
            </div> -->
            <div class="rigth">
                <router-view />
            </div>
        </div>

        <footer class="position-relative" id="footer-main">
            <Foot></Foot>
        </footer>
    </div>
</template>
<script>
import Foot from './fream/Foot.vue';
import Top from './fream/LoginTop.vue'
import { synRequestPost, synRequestGet } from "../../static/request"l;

export default {
    name: 'Register',
    components: {
        Foot, Top
    },
    data() {
        return {
            Admin: false

        }
    },
    methods: {
    },
    mounted() {
    }

}
</script>
<style scoped>
.content {
    display: flex;

}
/* 
.left {
    height: 90%;
    width: 10%;
} */

.rigth {
    height: 90%;
    width: 90%;
    margin: 0 auto;

}

.tab {
    margin: 30px;
}

a {
    color: black;
}</style>
