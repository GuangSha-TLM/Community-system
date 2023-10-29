<template>
    <div class="hello">
        <div class="top">
            <Top></Top>
        </div>
        <div class="content">
            <div class="left">
                <div class="complaint tab" @click="colorChange(1)"
                    :class="{ 'my-button': true, 'clicked': activeColor === 1 }">
                    <router-link to="/ClassManagement">班级管理</router-link>
                </div>
                <div class="user tab" @click="colorChange(2)" :class="{ 'my-button': true, 'clicked': activeColor === 2 }">
                    <router-link to="/userManagement">用户管理</router-link>
                </div>
                <div class="Associa tab" @click="colorChange(3)"
                    :class="{ 'my-button': true, 'clicked': activeColor === 3 }">
                    <router-link to="/AssociationManager">社团管理</router-link>
                </div>
                <div class="Activity tab" @click="colorChange(4)" :class="{ 'my-button': true, 'clicked': activeColor === 4 }">
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
            Admin: false,
            //颜色属性s
            activeColor: ''
        }
    },
    methods: {
        colorChange(num) {
            this.activeColor = num;
        }
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
}

.my-button {
    background-color: #fff;
    color: #fff;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
}

.clicked {
    background-color: #3498db;
}
</style>

