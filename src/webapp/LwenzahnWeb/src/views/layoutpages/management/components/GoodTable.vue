<template>
  <div style="text-align: -webkit-center">
    <el-container>
      <el-header>
        <h1>Goods</h1>
      </el-header>
      <el-main>
        <el-button-group>
          <el-button type="primary" @click="this.reload" icon="Refresh">Refresh</el-button>
        </el-button-group>
        <el-table :data="goods.slice((currentPage-1)*pagesize,currentPage*pagesize)" style="width: 100%">
          <el-table-column prop="goodsImagePath" label="Image">
            <template #default="scope">
               <img :src="scope.row.goodsImagePath" min-width="70" height="70"/>
            </template>
          </el-table-column>
          <el-table-column prop="goodsId" label="Good id"></el-table-column>
          <el-table-column prop="goodsName" label="Good Name"></el-table-column>
          <el-table-column prop="goodsType" label="Type">
            <template #default="scope">
              <span v-if="scope.row.goodsType === 'weapon'">
                <el-icon>
                  <Back />
                </el-icon> {{ scope.row.goodsType }}
              </span>
              <span v-else>
                {{ scope.row.goodsType }}
              </span>
            </template>
          </el-table-column>
          <el-table-column prop="goodsWeight" label="Weight (Kg)">
            <template #default="scope">
              <div v-if="scope.row.goodsWeight === undefined">No Weight Data.</div>
              <div v-else>{{ scope.row.goodsWeight }}</div>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10, 20, 30, 40, 50]"
        :page-size="pagesize"
        :total="goods.length"
        layout="total, sizes, prev, pager, next, jumper">
        </el-pagination>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "GoodTable",
  components: {
  },
  data() {
    return {
      goods: [],
      pagesize:10,//默认分页每页数据量
      currentPage:1,//默认展示第一页数据
    }
  },
  methods: {
    getGoods() {
      axios({
        url: "http://47.106.174.78:9090/good",
        method: 'GET',
      }).then((res) => {
        console.log(res.data);
        this.goods = res.data;
      });
    },
    handleSizeChange: function(val) {
        this.pagesize = val;
    },
    handleCurrentChange: function(currentPage) {
        this.currentPage = currentPage;
    },
  },
  mounted() {
    this.getGoods();
  }
};
</script>

<style>
</style>