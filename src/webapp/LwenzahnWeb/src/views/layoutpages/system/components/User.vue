<template>
    <el-dialog
        :title="title"
        append-to-body
        destroy-on-close
        :model-value="showDialog"
        @close="closeDialog()"
    >
        <!-- <span>{{ rowData }}</span> -->
        <!-- 表单 -->
        <el-form
            :model="props.userData"
            ref="formRef"
            :rules="rules"
            label-width="100px"
            :inline="false"
        >
            <el-form-item label="User Name" prop="props.userData.userName">
                <el-input
                    v-model="props.userData.userName"
                    placeholder=""
                    clearable
                ></el-input>
            </el-form-item>
            <el-form-item label="Gender" prop="props.userData.gender">
                <el-input
                    v-model="props.userData.gender"
                    placeholder=""
                    clearable
                ></el-input>
            </el-form-item>
            <el-form-item label="Birthday" prop="props.userData.birthday">
                <el-date-picker v-model="props.userData.birthday"></el-date-picker>
            </el-form-item>
            <el-form-item label="Birthday" prop="props.userData.description">
                <el-date-picker v-model="props.userData.birthday"></el-date-picker>
            </el-form-item>
            <template v-slot:footer>
            </template>
            <span>
                <el-button @click="closeDialog()">取消</el-button>
                <el-button type="primary" @click="onSubmit()">确定</el-button>
            </span>
        </el-form>

    </el-dialog>
</template>

<script setup>
import axios from "axios";
import { reactive, toRefs, ref } from "vue";
const rules = {
    userName: [
        {
            required: true,
            message: "Please Type Username",
            trigger: "blur",
        },
    ],
    gender: [
        {
            required: true,
            message: "Please Type User Gender",
            trigger: "blur",
        },
    ],
    birthday: [
        {
            required: false,
            message: "Please Type Your Birthday",
            trigger: "blur",
        },
    ],
    description: [
        {
            required: false,
            message: "You can describe yourself",
            trigger: "blur",
        }
    ]
};
const props = defineProps({
    showDialog: {
        type: Boolean,
        default: true,
    },
    userData: {
        default: null,
    },
});
const emit = defineEmits(["closeDialog"]);
const { title, rowData } = toRefs(props);
const closeDialog = () => {
    emit("closeDialog", false);
};
const formRef = ref(null);
const form = reactive({
    userName: "",
    gender: "",
    birthday: "",
    description: "",
});
const { userName, gender, birthday, description} = toRefs(form);
const roleList = ref([]);
/**
 * @description:提交
 * @param {*}
 * @return {*}
 */
const onSubmit = () => {
    axios.post("", {

    }).then(res => {
        console.log(res);
    })
    closeDialog();
};
</script>

<style lang="scss" scoped></style>