<template>
    <div>
        <div>
            <el-form>
                <el-form-item prop="warehouseId">
                    <el-input v-model="this.warehouseId" placeholder="Search Goods by warehouse ID"
                        style="width: 20%" />
                    <el-button type="primary" icon="Search" @click="searchGoodsBywhid">Search</el-button>
                </el-form-item>
            </el-form>
        </div>
        <div style="text-align: -webkit-center">
            <el-table :data="goodsInfo" style="width: 100%" empty-text="There aren't any good info!">
                <el-table-column prop="goodsName" label="Name"></el-table-column>
                <el-table-column prop="goodsType" label="Type"></el-table-column>
                <el-table-column prop="warehouseId" label="Warehouse"></el-table-column>
                <el-table-column prop="rowNum" label="Row"></el-table-column>
                <el-table-column prop="columnNum" label="Column"></el-table-column>
                <el-table-column prop="floorNum" label="Floor"></el-table-column>
                <el-table-column prop="positionNum" label="Position"></el-table-column>
                <el-table-column label="Location Code">
                    <template #default="scope">
                        <div>
                            {{ scope.row.warehouseId }}-{{ scope.row.rowNum }}-{{ scope.row.columnNum }}-{{ scope.row.floorNum }}-{{ scope.row.positionNum }}
                        </div>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
</template>

<script>
import axios from "axios"
export default {
    data() {
        return {
            warehouseId: null,
            goodsInfo: [],
        }
    },
    methods: {
        searchGoodsBywhid() {
            axios.post("http://localhost:9090/warehouses/queryGoods", {
                warehouseId: this.warehouseId
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