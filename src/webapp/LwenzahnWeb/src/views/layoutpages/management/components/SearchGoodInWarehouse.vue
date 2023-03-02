<template>
    <div>
        <el-dialog :title="title" append-to-body destroy-on-close :model-value="showDialog" @close="closeDialog()">
            <div style="text-align: -webkit-center">
                <el-table :data="goodsInfo.slice((currentPage-1)*pagesize,currentPage*pagesize)" style="width: 100%" empty-text="There aren't any good info!">
                    <el-table-column prop="goodName" label="Name"></el-table-column>
                    <el-table-column prop="goodType" label="Type"></el-table-column>
                    <el-table-column prop="warehouseId" label="Pos"></el-table-column>
                    <el-table-column prop="storeFloor" label="Floor"></el-table-column>
                </el-table>
            </div>
            <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[10, 20, 30, 40, 50]"
            :page-size="pagesize"
            :total="goodsInfo.length"
            layout="total, sizes, prev, pager, next, jumper">
            </el-pagination>
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
            pagesize:10,//默认分页每页数据量
            currentPage:1,//默认展示第一页数据
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
            axios.get("http://localhost:9090/good/queryGoods").then((res) => {
                console.log(res.data);
                this.goodsInfo = res.data;
            });
        },
        handleSizeChange: function(val) {
        this.pagesize = val;
        },
        handleCurrentChange: function(currentPage) {
            this.currentPage = currentPage;
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