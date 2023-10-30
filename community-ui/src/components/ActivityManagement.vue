<template>
    <div>
    
        <!-- <div>
            <Top></Top>
        </div> -->
        <div class="content">
            <router-link class="item" v-for="item in list" :key="item.index" :to="{name:'ActivityItem',params:{id:item.id}}">
                <div class="item_id">{{ item.id }}</div>
                <div class="item_title">{{ item.title }}</div>
                <div class="item_time">{{ item.startTime }}</div>
                <div class="item_icon"><i class="el-icon-arrow-right"></i></div>
            </router-link>
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
            user: {
                username: "",
                password: "",
            },
            //查看学院
            schoolView: {

            },
            //按钮开关
            switchbutton: false,
            //用户数据集合
            list: null,
            param:this.$route.params.list,
            count: 0,

            //分页查询
            pagingToGetUserDataBo: {
                start: 0,
                size: 100,
                name: "",
                status: 0,
                delFlag: 0,
            },

            //通过id删除
            deleteByIdBo: {
                token: "",
                id: -1
            },

            //查重用户通过id
            selectByIdBo: {
                token: "",
                id: -1,
            },

            //修改窗口
            updateWindows: false,

            //用户信息
            userInfo: {
                id: -1,
                username: "",
                password: "",
                name: "",
                org: '',
                college: '',
                grade: '',
                studentId: '',
            },
            //更新用户信息
            updataByIdBo: {
                token: "",
                user: {
                    id: -1,
                    username: "",
                    password: "",
                    name: "",
                    org: '',
                    college: '',
                    grade: '',
                    studentId: '',
                }
            },
            //查看
            view: true,
            input: '',
            //学院信息
            college: [
                {
                    value: 1,
                    text: '信息学院'
                },
                {
                    value: 2,
                    text: '财经学院'
                },
                {
                    value: 3,
                    text: '艺术与传媒学院'
                },
                {
                    value: 4,
                    text: '通识学院'
                }
            ],
        }
    },
    mounted() {
        this.getMerchantInformation()
    },

    methods: {
        /**
         *  修改用户信息
         */
        async updateUserInfo() {
            //todo userInfo 要求username 和password 和name 不可以为空
            this.updataByIdBo.token = this.token;
            this.updataByIdBo.user.college = this.input;
            this.updataByIdBo.user.org = this.userInfo.org;
            this.updataByIdBo.user.grade = this.userInfo.grade;
            this.updataByIdBo.user.studentId = this.userInfo.studentId;
            this.updataByIdBo.user.password = this.userInfo.password;
            this.updataByIdBo.user.username = this.userInfo.username;
            this.updataByIdBo.user.name = this.userInfo.name;
            this.updataByIdBo.user.id = this.userInfo.id;
            console.log(this.updataByIdBo);
            let obj = await synRequestPost("/user/update", this.updataByIdBo);
            alert(obj.message);
            this.updateWindows = false
            this.getMerchantInformation(1);
        },

        //更新用户信息
        async openUpdateUserInfoWindows(id) {
            this.selectByIdBo.id = id;
            this.selectByIdBo.token = this.token;
            let obj = await synRequestPost("/user/select", this.selectByIdBo);
            this.userInfo = obj.data;
            // this.userInfo.college = this.college[this.userInfo.college]
            console.log(this.userInfo);
            this.view = true
            this.updateWindows = true;
        },

        //跳转指定页面
        async getMerchantInformation() {
            let obj = await synRequestPost("/activity/findAll");
            console.log(obj);
            if (obj.code == "0x200") {
                this.list = obj.data;

            }
        },

        //删除用户通过id
        async deleteById(id) {
            this.deleteByIdBo.id = id;
            this.deleteByIdBo.token = this.token;
            let obj = await synRequestPost("/user/delete", this.deleteByIdBo);
            alert(obj.message);
            this.getMerchantInformation(1);

        },

        //查看功能
        openView(obj) {
            this.view = false
            console.log(obj);
            if (obj.college) {
                obj.college = this.college[obj.college].text
            }
            this.schoolView = obj
        }
    },
    
    

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

.content{
    width: 70%;
    margin: 0 15%;
}
.item{
    width: 100%;
    display: flex;
    justify-content: space-between;
    margin: 20px 0 ;
}
</style>
