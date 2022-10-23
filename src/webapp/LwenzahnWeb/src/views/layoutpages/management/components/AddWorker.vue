<template>
  <div>
    <el-dialog :title="title" append-to-body destroy-on-close :model-value="showDialog" @close="closeDialog()">
      <!-- <span>{{ rowData }}</span> -->
      <!-- 表单 -->
      <el-form :model="form" ref="formRef" :rules="rules" label-width="100px" :inline="false">
        <el-form-item prop="workerId" label="Wkr ID">
          <el-input v-model="workerId" placeholder="" clearable></el-input>
        </el-form-item>
        <el-form-item prop="workerName" label="Wkr Name">
          <el-input v-model="workerName" placeholder="" clearable></el-input>
        </el-form-item>
        <el-form-item prop="workerPassword" label="Password">
          <el-input type="password" show-password v-model="workerPassword" placeholder="" clearable></el-input>
        </el-form-item>
      </el-form>

      <template v-slot:footer>
        <span>
          <el-button @click="closeDialog()">取消</el-button>
          <el-button type="primary" @click="onSubmit()">确定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { reactive, toRefs, ref } from "vue";
import axios from "axios";
const rules = {
  workerId: [
    {
      required: true,
      message: "Type Worker ID",
      trigger: "blur",
    },
  ],
  workerName: [
    {
      required: true,
      message: "Type Worker Name",
      trigger: "blur",
    },
  ],
  workerPassword: [
    {
      required: true,
      message: "Type Your Password",
      trigger: "blur",
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
  workerId: "",
  workerName: "",
  workerPassword: "",
});
const { workerId, workerName, workerPassword } = toRefs(form);
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
  formRef.value.validate(async (valid) => {
    if (valid) {
      axios.post("http://localhost:9090/worker/adding", {
        workerId: workerId.value,
        workerName: workerName.value,
        workerPassword: workerPassword.value,
      }).then(res => {
        console.log(res)
      })
      emit("closeDialog", false);
    } else {
      console.log("error submit!!");
      return false;
    }
  });
};
</script>

<style lang="scss" scoped>
</style>
