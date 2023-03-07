<template>
    <div>
        <div>
            <el-form :model="form" style="width: 50%;" label-width="130px">
                <el-form-item label="Warehouse ID">
                    <el-input v-model="form.warehouseId" placeholder="Type warehouse ID" />
                </el-form-item>
                <el-form-item label="Good Name">
                    <el-input v-model="form.goodName" placeholder="Type good name">
                        <template #append>
                            <el-select v-model="form.searchMode" style="width: 130px" default-first-option>
                                <el-option label="Fuzzy Search" value="2" />
                                <el-option label="Accurate Search" value="1" />
                            </el-select>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item label="Good Type">
                    <el-select v-model="form.goodType" placeholder="Please Select">
                        <el-option 
                        v-for="item in goodsType"
                        :label="item"
                        :value="item"
                        ></el-option>
                    </el-select>
                    <el-button type="info" icon="Refresh" @click="reset">Reset</el-button>
                    <el-button type="success" icon="Search" @click="searchGoodsWithConditions">Search</el-button>
                </el-form-item>
            </el-form>
        </div>
        <div style="text-align: -webkit-center">
            <el-table :data="goodsInfo.slice((currentPage-1)*pagesize,currentPage*pagesize)" style="width: 100%" empty-text="There aren't any good info!">
                <el-table-column prop="goodsName" label="Name"></el-table-column>
                <el-table-column prop="goodsType" label="Type"></el-table-column>
                <el-table-column prop="warehouseId" label="Warehouse"></el-table-column>
                <el-table-column prop="shelfId" label="Shelf ID"></el-table-column>
                <el-table-column prop="positionCode" label="Shelf Position"></el-table-column>
                <el-table-column prop="rowPosition" label="Row"></el-table-column>
                <el-table-column prop="columnPosition" label="Column"></el-table-column>
                <el-table-column label="Location Code">
                    <template #default="scope">
                        <div>
                            {{ scope.row.warehouseId }}-{{ scope.row.positionCode }}-{{ scope.row.rowPosition }}-{{ scope.row.columnPosition }}
                        </div>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[10, 20, 30, 40, 50]"
            :page-size="pagesize"
            :total="goodsInfo.length"
            layout="total, sizes, prev, pager, next, jumper">
            </el-pagination>
        </div>
    </div>
</template>

<script>
import axios from "axios"
export default {
    data() {
        return {
            form: {
                warehouseId: null,
                searchMode: 2,
                goodName: null,
                goodType: null,
            },
            goodsInfo: [],
            goodsType: [],
            pagesize:10,//默认分页每页数据量
            currentPage:1,//默认展示第一页数据
        }
    },
    methods: {
        searchGoods() {
            axios.get("http://47.106.174.78:9090/good/queryGoods", {
            }).then((res) => {
                console.log(res.data);
                this.goodsInfo = res.data;
            });
        },
        searchGoodsType() {
            axios.get("http://47.106.174.78:9090/good/queryGoodsTypes", {
            }).then((res) => {
                console.log(res.data);
                this.goodsType = res.data;
            });
        },
        reset() {
            this.form.warehouseId = null,
            this.form.searchMode = 2,
            this.form.goodName = null;
            this.form.goodType = null;
        },
        isEmpty(str) {
            if (str == '' || str == "" || str == null || str == undefined) return true;
            else return false;
        },
        searchGoodsWithConditions() {
            console.log(this.form);
            if(this.isEmpty(this.form.goodName) && this.isEmpty(this.form.warehouseId) && this.isEmpty(this.form.goodType)) {
                axios.get("http://47.106.174.78:9090/good/queryGoods",  {
                }).then((res) => {
                    console.log(res.data);
                    this.goodsInfo = res.data;
                });
                return;
            }
            if(this.isEmpty(this.form.goodName) && !this.isEmpty(this.form.warehouseId) && this.isEmpty(this.form.goodType)) {
                axios.post("http://47.106.174.78:9090/good/queryGoodsByWarehouse", { 
                    warehouseId: this.form.warehouseId,
                }).then((res) => {
                    console.log(res.data);
                    this.goodsInfo = res.data;
                });
                return;
            }
            if(!this.isEmpty(this.form.goodName) && this.isEmpty(this.form.warehouseId) && this.isEmpty(this.form.goodType) && this.form.searchMode == 1) {
                axios.post("http://47.106.174.78:9090/good/queryGoodsByName",  {
                    goodsName: this.form.goodName,
                }).then((res) => {
                    console.log(res.data);
                    this.goodsInfo = res.data;
                });
                return;
            }
            if(!this.isEmpty(this.form.goodName) && this.isEmpty(this.form.warehouseId) && this.isEmpty(this.form.goodType) && this.form.searchMode == 2) {
                axios.post("http://47.106.174.78:9090/good/queryGoodsByNameInclude",  {
                    goodsName: this.form.goodName,
                }).then((res) => {
                    console.log(res.data);
                    this.goodsInfo = res.data;
                });
                return;
            }
            if(this.isEmpty(this.form.goodName) && this.isEmpty(this.form.warehouseId) && !this.isEmpty(this.form.goodType)) {
                axios.post("http://47.106.174.78:9090/good/queryGoodsByType",  {
                    goodsType: this.form.goodType,
                }).then((res) => {
                    console.log(res.data);
                    this.goodsInfo = res.data;
                });
                return;
            }
            if(!this.isEmpty(this.form.goodName) && !this.isEmpty(this.form.warehouseId) && this.isEmpty(this.form.goodType) && this.form.searchMode == 1) {
                axios.post("http://47.106.174.78:9090/good/queryGoodsByWarehousesAndName",  {
                    warehouseId: this.form.warehouseId,
                    goodsName: this.form.goodName,
                }).then((res) => {
                    console.log(res.data);
                    this.goodsInfo = res.data;
                });
                return;
            }
            if(!this.isEmpty(this.form.goodName) && !this.isEmpty(this.form.warehouseId) && this.isEmpty(this.form.goodType) && this.form.searchMode == 2) {
                axios.post("http://47.106.174.78:9090/good/queryGoodsByWarehousesAndNameInclude",  {
                    warehouseId: this.form.warehouseId,
                    goodsName: this.form.goodName,
                }).then((res) => {
                    console.log(res.data);
                    this.goodsInfo = res.data;
                });
                return;
            }
            if(this.isEmpty(this.form.goodName) && !this.isEmpty(this.form.warehouseId) && !this.isEmpty(this.form.goodType)) {
                axios.post("http://47.106.174.78:9090/good/queryGoodsByWarehousesAndType",  {
                    warehouseId: this.form.warehouseId,
                    goodsType: this.form.goodType,
                }).then((res) => {
                    console.log(res.data);
                    this.goodsInfo = res.data;
                });
                return;
            }
            if(!this.isEmpty(this.form.goodName) && this.isEmpty(this.form.warehouseId) && !this.isEmpty(this.form.goodType)) {
                if (this.form.searchMode == 1)
                    axios.post("http://47.106.174.78:9090/good/queryGoodsByNameAndType",  {
                        goodsName: this.form.goodName,
                        goodsType: this.form.goodType,
                    }).then((res) => {
                        console.log(res.data);
                        this.goodsInfo = res.data;
                    });
                else {
                    axios.post("http://47.106.174.78:9090/good/queryGoodsByNameIncludeAndType",  {
                        goodsName: this.form.goodName,
                        goodsType: this.form.goodType,
                    }).then((res) => {
                        console.log(res.data);
                        this.goodsInfo = res.data;
                    });
                }
                return;
            }
            if(!this.isEmpty(this.form.goodName) && !this.isEmpty(this.form.warehouseId) && !this.isEmpty(this.form.goodType)) {
                if (this.form.searchMode == 1)
                    axios.post("http://47.106.174.78:9090/good/queryGoodsByWarehousesNameAndType",  {
                        warehouseId: this.form.warehouseId,
                        goodsName: this.form.goodName,
                        goodsType: this.form.goodType,
                    }).then((res) => {
                        console.log(res.data);
                        this.goodsInfo = res.data;
                    });
                else {
                    axios.post("http://47.106.174.78:9090/good/queryGoodsByWarehousesNameIncludeAndType",  {
                        warehouseId: this.form.warehouseId,
                        goodsName: this.form.goodName,
                        goodsType: this.form.goodType,
                    }).then((res) => {
                        console.log(res.data);
                        this.goodsInfo = res.data;
                    });
                }
            }
        },
        handleSizeChange: function(val) {
            this.pagesize = val;
        },
        handleCurrentChange: function(currentPage) {
            this.currentPage = currentPage;
        },
    },
    mounted() {
        this.searchGoods();
        this.searchGoodsType();
    },
}
</script>

<style>
</style>