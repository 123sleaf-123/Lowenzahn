<template>
  <div>
    <el-dialog :title="title" append-to-body destroy-on-close :model-value="showDialog" @close="closeDialog()">
      <!-- <span>{{ rowData }}</span> -->
      <!-- 表单 -->
      <el-form :model="form" ref="formRef" :rules="rules" label-width="100px" :inline="false">
        <el-form-item prop="warehouseId" label="Wh ID">
          <el-input v-model="warehouseId" placeholder="" clearable></el-input>
        </el-form-item>
        <el-form-item prop="warehouseName" label="Wh Name">
          <el-input v-model="warehouseName" placeholder="" clearable></el-input>
        </el-form-item>
        <el-form-item prop="warehouseArea" label="warehouseArea">
          <el-input v-model="warehouseArea" placeholder="" clearable></el-input>
        </el-form-item>
        <el-form-item prop="warehouseAddress" label="warehouseAddress">
          <el-input v-model="warehouseAddress" placeholder="" clearable></el-input>
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
  warehouseId: [
    {
      required: true,
      message: "请输入用户名",
      trigger: "blur",
    },
  ],
  warehouseName: [
    {
      required: true,
      message: "请输入账户",
      trigger: "blur",
    },
  ],
  warehouseArea: [
    {
      required: false,
      message: "请输入密码",
      trigger: "blur",
    },
  ],
  warehouseAddress: [
    {
      required: false,
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
  warehouseId: "",
  warehouseName: "",
  warehouseArea: "",
  warehouseAddress: "",
});
const { warehouseId, warehouseName, warehouseArea, warehouseAddress } = toRefs(form);
const roleList = ref([]);
/**
 * @description: 初始化
 * @param {*}
 * @return {*}
 */
rowData.value &&
  (
    (warehouseId.value = rowData.value.warehouseId),
    (warehouseName.value = rowData.value.warehouseName),
    (warehouseArea.value = rowData.value.warehouseArea),
    (warehouseAddress.value = rowData.value.warehouseAddress)
  );
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
// getRoleList();
/**
 * @description:提交
 * @param {*}
 * @return {*}
 */
const onSubmit = () => {
  console.log(rowData.value);
  formRef.value.validate(async (valid) => {
    if (valid) {
      axios.post("http://localhost:9090/warehouses/updating", {
        warehouseId: warehouseId.value,
        warehouseName: warehouseName.value,
        warehouseArea: warehouseArea.value,
        warehouseAddress: warehouseAddress.value,
      }).then(res => {
        console.log(res)
      })
      emit("closeDialog", false);
    } else {
      console.log("error submit!!");
      return false;
    }
  })
};
</script>

<style lang="scss" scoped>
</style>
