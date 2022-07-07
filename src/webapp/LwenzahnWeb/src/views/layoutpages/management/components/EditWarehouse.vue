<template>
  <el-dialog :title="title" append-to-body destroy-on-close :model-value="showDialog" @close="closeDialog()">
    <!-- <span>{{ rowData }}</span> -->
    <!-- 表单 -->
    <el-form :model="form" ref="formRef" :rules="rules" label-width="100px" :inline="false">
      <el-form-item prop="whid" label="Wh ID">
        <el-input v-model="id" placeholder="" clearable></el-input>
      </el-form-item>
      <el-form-item prop="whName" label="Wh Name">
        <el-input v-model="name" placeholder="" clearable></el-input>
      </el-form-item>
      <el-form-item prop="area" label="Area">
        <el-input v-model="area" placeholder="" clearable></el-input>
      </el-form-item>
      <el-form-item prop="address" label="Address">
        <el-input v-model="address" placeholder="" clearable></el-input>
      </el-form-item>
    </el-form>

    <template v-slot:footer>
      <span>
        <el-button @click="closeDialog()">取消</el-button>
        <el-button type="primary" @click="onSubmit()">确定</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { reactive, toRefs, ref } from "vue";
import axios from "axios";
const rules = {
  name: [
    {
      required: true,
      message: "请输入用户名",
      trigger: "blur",
    },
  ],
  userName: [
    {
      required: true,
      message: "请输入账户",
      trigger: "blur",
    },
  ],
  password: [
    {
      required: true,
      message: "请输入密码",
      trigger: "blur",
    },
  ],
  role: [
    {
      required: true,
      message: "请选择角色",
      trigger: "change",
    },
  ],
};
const props = defineProps({
  showDialog: {
    type: Boolean,
    default: true,
  },
  title: {
    type: String,
    default: "添加",
  },
  rowData: {
    type: Object,
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
  id: "",
  name: "",
  area: "",
  address: "",
});
const { id, name, area, address } = toRefs(form);
const roleList = ref([]);

/**
 * @description: 初始化
 * @param {*}
 * @return {*}
 */
// rowData.value &&
//   ((name.value = rowData.value.name),
//     (userName.value = rowData.value.userName),
//     (password.value = rowData.value.password),
//     (role.value = rowData.value.role),
//     (status.value = rowData.value.status));
/**
 * @description: 获取角色列表
 * @param {*}
 * @return {*}
 */
const getRoleList = async () => {
  const { code, data } = await VE_API.system.roleList(
    {
      page: 1,
      limit: 10,
    },
    { Global: false }
  );
  if (code == "00") {
    const { list } = data;
    roleList.value = list;
  }
};
getRoleList();
/**
 * @description:提交
 * @param {*}
 * @return {*}
 */
const onSubmit = () => {
  axios.post("http://localhost:8080/warehouses/updating", {
    id: id.value,
    whName: name.value,
    area: area.value,
    address: address.value,
  }).then(res => {
    console.log(res)
  })
};
</script>

<style lang="scss" scoped>
</style>
