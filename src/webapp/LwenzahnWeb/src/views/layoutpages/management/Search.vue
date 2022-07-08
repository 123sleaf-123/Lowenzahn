<template>
    <div>
        <div>
            <el-form>
                <el-form-item prop="whid">
                    <el-input v-model="this.whid" placeholder="Search Goods by warehouse ID" style="width: 20%" />
                    <el-button type="primary" icon="Search" @click="searchGoodsBywhid">Search</el-button>
                </el-form-item>
            </el-form>
        </div>
        <div style="text-align: -webkit-center">
            <el-table :data="goodsInfo" style="width: 100%" empty-text="There aren't any good info!">
                <el-table-column prop="goodName" label="Good Name"></el-table-column>
                <el-table-column prop="type" label="Type"></el-table-column>
                <el-table-column prop="position" label="Pos"></el-table-column>
                <el-table-column prop="storeFloor" label="Floor"></el-table-column>
            </el-table>
        </div>
    </div>
</template>

<script>
import axios from "axios"
export default {
    data() {
        return {
            whid: null,
            goodsInfo: [],
        }
    },
    methods: {
        searchGoodsBywhid() {
            axios.post("http://localhost:8080/warehouses/queryGoods", {
                whid: this.whid
            }).then((res) => {
                console.log(res.data);
                this.goodsInfo = res.data;
            });
        }
    },
}
</script>

<style>
</style>