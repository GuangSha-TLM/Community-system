<!--
 * @Author: tianleiyu
 * @Date: 2023-11-10 13:39:11
 * @LastEditTime: 2023-11-19 12:16:55
 * @LastEditors: tianleiyu
 * @Description:
 * @FilePath: /community-ui/src/components/AssociationActivityManagement.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div>
        <div class="content">

            <el-button type="text" @click="dialogFormVisible = true">新增活动</el-button>

            <div v-for="(item, index) in list" :key="item.id" class="item">
                <router-link :to="{ name: 'ActivityItem', params: { id: item.id } }" class="item_link">
                    <div class="item_id">{{ index + 1 }}</div>
                    <div class="item_title">{{ item.title }}</div>
                    <div class="item_time">{{ item.startTime }}</div>
                </router-link>
                <div class="item_but">
                    <!-- 删除按钮 -->
                    <div class="item_del" @click="delActive(item.id)"><i class="el-icon-delete"></i></div>
                    <div class="item_icon"><i class="el-icon-arrow-right"></i></div>
                </div>

            </div>


            <el-dialog title="新增活动" :visible.sync="dialogFormVisible" width="100%" top="0">
                <el-form :model="activeAddBo">
                    <el-form-item label="活动标题" :label-width="formLabelWidth">
                        <el-input v-model="activeAddBo.title" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="活动详细" :label-width="formLabelWidth">
                        <quill-editor v-model="context" ref="myTextEditor" :options="editorOptions" />

                        <el-upload class="upload-demo" action="#" drag :file-list="fileList" style="display: none;"
                            :on-change="handleChange" :http-request="confirmUpload">
                            <i class="el-icon-upload"></i>
                            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                            <div class="el-upload__tip" slot="tip">上传Excel格式文件</div>
                        </el-upload>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="close">取 消</el-button>
                    <el-button type="primary" @click="addActive">确 定</el-button>
                </div>
            </el-dialog>
        </div>
    </div>
</template>

<script>
import { quillEditor, Quill } from 'vue-quill-editor'
import { container, ImageExtend, QuillWatch } from 'quill-image-extend-module'
Quill.register('modules/ImageExtend', ImageExtend)
import "quill/dist/quill.core.css"; // import styles
import "quill/dist/quill.snow.css"; // for snow theme
import "quill/dist/quill.bubble.css"; // for bubble theme

import Foot from './fream/Foot.vue';
import Top from './fream/LoginTop.vue';
import { synRequestPost, synRequestGet } from "../../static/request"

export default {
    components: {
        Foot, Top, quillEditor
    },
    data() {
        return {
            token: getCookie("token"),
            //用户数据集合
            list: [],
            //上传图片的集合
            fileList: [],
            //分页查询
            pagingToGetUserDataBo: {
                start: 0,
                size: 100,
                name: "",
                status: 0,
                delFlag: 0,
            },
            dialogFormVisible: false,
            //添加活动
            activeAddBo: {
                token: '',
                title: '',
            },
            context:'',
            formLabelWidth: '120px',
            // 删除活动
            activeDeleteByIdBo: {
                token: '',
                id: ''
            },
            // 富文本框参数设置
            editorOptions: {
                modules: {
                    toolbar: {
                        container: container,
                        handlers: {
                            'image': function (value) { //劫持原来的图片的点击事件
                                if (value) {
                                    // 自动触发element的点击事件
                                    document.querySelector('.upload-demo input').click()
                                } else {
                                    this.quill.format('image', false)
                                }
                            }

                        }
                    }
                }
            },
        }
    },

    mounted() {
        this.getMerchantInformation();

    },

    methods: {
        //element的上传
        async confirmUpload() {
            //上传图片
            const formData = new FormData();
            this.fileList.forEach(val => formData.append("file", val.raw))
            formData.append("token", this.token);
            let res = await synRequestPost("/img/imgUpDown", formData);
            this.fileList = [];
            console.log(res);
            var url = res.data
            let quill = this.$refs.myTextEditor.quill
            // 获取光标所在位置
            let length = quill.getSelection().index
            // 插入图片 dt.url为服务器返回的图片地址
            quill.insertEmbed(length, 'image', url)
            // 调整光标到最后
            quill.setSelection(length + 1)

        },
        handleChange(file, fileList) { //文件数量改变
            this.fileList = fileList;
        },
        //跳转指定页面
        async getMerchantInformation() {
            let obj = await synRequestPost(`/activity/selectByToken?token=${this.token}`);
            if (obj.code == "0x200") {
                this.list = obj.data;
            }
        },
        close() {
            this.dialogFormVisible = false
            this.activeAddBo.active.title = ''
            this.activeAddBo.active.context = ''
        },
        async addActive() {
            this.activeAddBo.context = this.$refs.myTextEditor.quill.root.innerHTML;
            this.activeAddBo.token = this.token
            let obj = await synRequestPost(`/activity/add?context=${this.context}`, this.activeAddBo);
            if (obj.code == "0x200") {
                this.dialogFormVisible = false
                this.$message({
                    message: '增加成功!',
                    type: 'success'
                });
                this.getMerchantInformation();
            }
        },
        async delActive(id) {
            this.activeDeleteByIdBo.token = this.token
            this.activeDeleteByIdBo.id = id
            let obj = await synRequestPost('/activity/delete', this.activeDeleteByIdBo);
            if (obj.code == "0x200") {
                this.$message({
                    message: '删除成功',
                    type: 'success'
                });
                this.getMerchantInformation();
            }
        }

    },
    computed: {
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
.item_link{
    width: 60%;
    display: flex;
    justify-content: space-between;
    margin: 20px 0;
}
.item_but{
    width: 15%;
    display: flex;
    justify-content: space-between;
    margin: 20px 0;
}
.item_del {
    color: #67C23A;
}
</style>
