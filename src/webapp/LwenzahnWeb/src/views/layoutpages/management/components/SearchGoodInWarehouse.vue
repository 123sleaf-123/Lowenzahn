<template>
    <div>
        <el-dialog :title="title" append-to-body destroy-on-close :model-value="showDialog" @close="closeDialog()">
            <div style="text-align: -webkit-center">
                <el-table :data="goodsInfo" style="width: 100%" empty-text="There aren't any good info!">
                    <el-table-column prop="goodName" label="Name"></el-table-column>
                    <el-table-column prop="type" label="Type"></el-table-column>
                    <el-table-column prop="position" label="Pos"></el-table-column>
                    <el-table-column prop="storeFloor" label="Floor"></el-table-column>
                </el-table>
            </div>
            <template v-slot:footer>
                <span style="text-align: -webkit-center">
                    <el-button type="primary" @click="getGoodInfo" icon="Refresh"></el-button>
                    <el-button @click="closeDialog" icon="Back">Back</el-button>
                    <!-- <el-button type="primary" @click="onSubmit()">确定</el-button> -->
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
import { reactive, toRefs, ref } from "vue";

import axios from "axios";
export default {
    data() {
        return {
            goodsInfo: [],
            // whData: rowData
        }
    },
    props: {
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
    },
    watch: {
        rowData(newVal, oldVal) {
            // if (newVal != null) { this.whData = newVal.data; }
            this.whData = newVal.data;
            console.log(this.whData);
        }
    },
    emits: "closeDialog",
    methods: {
        closeDialog() {
            this.$emit("closeDialog", false);
        },
        getGoodInfo() {
            console.log(this.whData);
            axios.post("http://localhost:8080/warehouses/queryGoods", this.whData).then((res) => {
                console.log(res.data);
                this.goodsInfo = res.data;
            });
        },
    }
};
// goodsInfo;
// const props = defineProps({
//     showDialog: {
//         type: Boolean,
//         default: true,
//     },
//     title: {
//         type: String,
//         default: "添加",
//     },
//     rowData: {
//         type: Object,
//         default: null,
//     },
// });
// this.title, this.rowData = toRefs(props);
</script>

<style>
</style>