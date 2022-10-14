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
        <el-table :data="goods" style="width: 100%">
          <el-table-column label="Image">
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
    }
  },
  methods: {
    getGoods() {
      axios({
        url: "http://localhost:9090/good",
        method: 'GET',
      }).then((res) => {
        console.log(res.data);
        this.goods = res.data;
      });
    },
  },
  mounted() {
    this.getGoods();
  }
};
</script>

<style>
</style>