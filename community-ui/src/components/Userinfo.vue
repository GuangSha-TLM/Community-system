<!--
 * @Author: tianleiyu 
 * @Date: 2023-11-09 16:14:29
 * @LastEditTime: 2023-12-04 20:02:17
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /community-ui/src/components/Userinfo.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div class="userInfo">
        <div class="info">
            <div class="username partition">
                <span class="info_key">用户名:</span><span class="value">{{ userInfo.username }}</span>
            </div>
            <div class="name partition">
                <span class="info_key">姓名:</span><span class="value">{{ userInfo.name }}</span>
            </div>
            <div class="college partition">
                <span class="info_key">学院:</span><span class="value">{{ userInfo.college }}</span>
            </div>

            <div class="professional partition">
                <span class="info_key">专业:</span><span class="value">{{ userInfo.professional }}</span>
            </div>
            <div class="grade partition">
                <span class="info_key">年级:</span><span class="value">{{ userInfo.grade }}</span><span
                    class="info_key">级</span>
            </div>

        </div>
        <div class="but">
            <div>
                <el-button type="primary" @click="updateuserInfo" class="update button" round>更改信息</el-button>

                <el-dialog title="新增活动" :visible.sync="dialogFormVisible">
                    <el-form :model="userUpdateByUserIdBo.user">
                        <el-form-item label="用户名">
                            <el-input v-model="userUpdateByUserIdBo.user.username" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="姓名">
                            <el-input v-model="userUpdateByUserIdBo.user.name" autocomplete="off"></el-input>
                        </el-form-item>

                        <el-form-item label="学院">
                            <div>
                                <el-select v-model="userUpdateByUserIdBo.user.college" placeholder="请选择">
                                    <el-option v-for="item in options" :key="item.value" :label="item.label"
                                        :value="item.value">
                                    </el-option>
                                </el-select>
                            </div>
                        </el-form-item>
                        <el-form-item label="年级">
                            <div>
                                <el-select v-model="userUpdateByUserIdBo.user.grade" placeholder="请选择">
                                    <el-option v-for="item in grandList" :key="item" :label="item" :value="item">
                                    </el-option>
                                </el-select>
                            </div>
                        </el-form-item>

                        <el-form-item label="专业">
                            <el-select v-model="userUpdateByUserIdBo.user.professional" placeholder="请选择">
                                <el-option-group v-for="group in professionalList[userUpdateByUserIdBo.user.college - 1]" :key="group.value"
                                    :label="group.label">
                                    <el-option v-for="item in group.professionalList" :key="item.professionalList"
                                        :label="item.label" :value="item">
                                    </el-option>
                                </el-option-group>
                            </el-select>
                        </el-form-item>


                    </el-form>
                    <div slot="footer" class="dialog-footer">
                        <el-button @click="dialogFormVisible = false">取 消</el-button>
                        <el-button type="primary" @click="updateUser">确 定</el-button>
                    </div>
                </el-dialog>
            </div>
            <div>
                <!-- <el-button type="primary" class="button"  round>注销</el-button> -->
                
            </div>

        </div>
    </div>
</template>

<script>
import { synRequestPost, synRequestGet } from "../../static/request"

export default {
    data() {
        return {
            token: getCookie("token"),
            user: JSON.parse(localStorage.getItem("user")),
            userInfo: {},
            options: [
                { value: 1, label: "信息学院" },
                { value: 2, label: "财经学院" },
                { value: 3, label: "艺术学院" },
                { value: 4, label: "通识学院" }
            ],
            dialogFormVisible: false,
            professionalList: [
                //信息学院
                [
                    {
                        value: 1,
                        label: '软件工程',
                        professionalList: ['软件工程1班', '软件工程2班', '软件工程3班', '软件工程4班', '软件工程5班', '软件工程6班']
                    }, {
                        value: 2,
                        label: '计算机科学与技术',
                        professionalList: ['计算机科学与技术1班', '计算机科学与技术2班', '计算机科学与技术3班',
                            '计算机科学与技术4班', '计算机科学与技术5班', '计算机科学与技术6班']
                    }, {
                        value: 3,
                        label: '电子商务',
                        professionalList: ['电子商务1班', '电子商务2班', '电子商务3班', '电子商务4班', '电子商务5班', '电子商务6班']
                    },

                ],
                //财经学院
                [
                    {
                        value: 1,
                        label: '审计学',
                        professionalList: ['审计学1班', '审计学2班', '审计学3班', '审计学4班', '审计学5班', '审计学6班']
                    }, {
                        value: 2,
                        label: '会计学',
                        professionalList: ['会计学1班', '会计学2班', '会计学3班', '会计学4班', '会计学5班', '会计学6班']
                    }, {
                        value: 3,
                        label: '国际经济与贸易',
                        professionalList: ['国际经济与贸易1班', '国际经济与贸易2班', '国际经济与贸易3班',
                            '国际经济与贸易4班', '国际经济与贸易5班', '国际经济与贸易6班']
                    }, {
                        value: 4,
                        label: '财务管理',
                        professionalList: ['财务管理1班', '财务管理2班', '财务管理3班', '财务管理4班', '财务管理5班', '财务管理6班']
                    }, {
                        value: 5,
                        label: '工商管理',
                        professionalList: ['工商管理1班', '工商管理2班', '工商管理3班', '工商管理4班', '工商管理5班', '工商管理6班']
                    }, {
                        value: 6,
                        label: '人力资源管理',
                        professionalList: ['人力资源管理1班', '人力资源管理2班', '人力资源管理3班',
                            '人力资源管理4班', '人力资源管理5班', '人力资源管理6班']
                    },

                ],
                //艺术学院
                [
                    {
                        value: 1,
                        label: '视觉传达设计',
                        professionalList: ['视觉传达设计1班', '视觉传达设计2班', '视觉传达设计3班',
                            '视觉传达设计4班', '视觉传达设计5班', '视觉传达设计6班']
                    }, {
                        value: 2,
                        label: '环境设计',
                        professionalList: ['环境设计1班', '环境设计2班', '环境设计3班', '环境设计4班', '环境设计5班', '环境设计6班']
                    }, {
                        value: 3,
                        label: '影视摄影与制作',
                        professionalList: ['影视摄影与制作1班', '影视摄影与制作2班', '影视摄影与制作3班',
                            '影视摄影与制作4班', '影视摄影与制作5班', '影视摄影与制作6班']
                    },

                ],
                //通识学院
                [
                    {
                        value: 1,
                        label: '汉语言文学',
                        professionalList: ['汉语言文学1班', '汉语言文学2班', '汉语言文学3班',
                            '汉语言文学4班', '汉语言文学5班', '汉语言文学6班']
                    }, {
                        value: 2,
                        label: '应用心理学',
                        professionalList: ['应用心理学1班', '应用心理学2班', '应用心理学3班',
                            '应用心理学4班', '应用心理学5班', '应用心理学6班']
                    }, {
                        value: 3,
                        label: '学前教育 (师范类)',
                        professionalList: ['学前教育 (师范类)1班', '学前教育 (师范类)2班', '学前教育 (师范类)3班',
                            '学前教育 (师范类)4班', '学前教育 (师范类)5班', '学前教育 (师范类)6班']

                    },

                ]
            ],
            grandList: [2019, 2020, 2021, 2022, 2023, 2024, 2025],
            college: '',
            userUpdateByUserIdBo: {
                token: '',
                user: {
                    id: -1,
                    college: '',
                    professional: '',
                    grade: '',
                    name: '',
                    username: '',
                }
            },
            //查重用户通过id
            userSelectByUserIdBo: {
                token: "",
                id: -1,
            },
        }
    },
    mounted() {
        this.getMerchantInformation()
    },

    methods: {
        //初始化页面
        async getMerchantInformation() {
            this.userInfo = { ...this.user }
            this.userInfo.college = this.options[this.userInfo.college - 1].label
        },
        // close(){

        //     // Object.keys(this.user).forEach(key => (this.user[key] = ''));
        // },
        updateuserInfo() {
            console.log(JSON.parse(localStorage.getItem("user")));
            console.log(this.user);
            this.userUpdateByUserIdBo.user.id = this.user.id
            this.userUpdateByUserIdBo.user.college = this.user.college
            this.userUpdateByUserIdBo.user.professional = this.user.professional
            this.userUpdateByUserIdBo.user.grade = this.user.grade
            this.userUpdateByUserIdBo.user.name = this.user.name
            this.userUpdateByUserIdBo.user.username = this.user.username
            this.dialogFormVisible = true
        },
        async updateUser() {

            this.userUpdateByUserIdBo.token = this.token
            let obj = await synRequestPost("/user/update", this.userUpdateByUserIdBo);
            this.user = {}
            this.userSelectByUserIdBo.id = obj.data;
            this.userSelectByUserIdBo.token = this.token;
            let res = await synRequestPost("/user/select", this.userSelectByUserIdBo);

            if (res.code == "0x200") {
                this.user = res.data;
                localStorage.setItem("user",JSON.stringify(res.data));
                console.log(JSON.parse(localStorage.getItem("user")));
                this.getMerchantInformation()
                this.dialogFormVisible = false
                this.$message({
                    showClose: true,
                    message: '修改成功!',
                    type: 'success'
                });
            }
        }
    },
    computed: {

    }

}

</script>

<style scoped>
.userInfo {
    width: 80%;
    margin: 0 auto;
}

.info {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    /* margin-left: 10%; */
}

.partition {
    margin-bottom: 10px;
}

.info_key {
    font-size: 20px;
}

.value {
    font-size: 17px;
}

.update {
    margin-bottom: 10px;
}

.button {
    width: 100%;
}

/deep/.el-select {
    width: 100%;
}
</style>