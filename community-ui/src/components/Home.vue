<template>
    <div class="hello">
        <div class="top">
            <Top></Top>
        </div>
        <div class="content">
            <div class="left">
                <div class="complaintManagement tab" >
                    <router-link to="/ClassManagement">班级管理</router-link>
                </div>
                <div class="userMangement tab" >
                    <router-link to="/userManagement">用户管理</router-link>
                </div>
                <div class="AssociationManager tab">
                    <router-link to="/AssociationManager">社团管理</router-link>
                </div>
                <div class="ActivityManagement tab">
                        <router-link to="/ActivityManagement">活动管理</router-link>
                    </div>
            </div>
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
import { synRequestPost, synRequestGet } from "../../static/request"

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

.left {
    height: 90%;
    width: 15%;
}

.rigth {
    height: 90%;
    width: 85%;

}

.tab {
    margin: 30px;
}

a {
    color: black;
}</style>