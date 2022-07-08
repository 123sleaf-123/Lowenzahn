<template>
  <div>
    <el-dialog :title="title" append-to-body destroy-on-close :model-value="showDialog" @close="closeDialog()">
      <template v-slot:footer>
        <span>
          <el-button type="info" @click="closeDialog()">Cancel</el-button>
          <el-button type="danger" @click="onSubmit()">Delete</el-button>
        </span>
      </template>
    </el-dialog>
  </div>

</template>

<script setup>
import { reactive, toRefs, ref, watch } from "vue";
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
// console.log(rowData.data);
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
/**
 * @description:提交
 * @param {*}
 * @return {*}
 */
const onSubmit = () => {
  axios.post("http://localhost:8080/warehouses/deleting", rowData.value).then(res => {
    console.log(res)
  })
  emit("closeDialog", false);
};
</script>

<style lang="scss" scoped>
</style>
