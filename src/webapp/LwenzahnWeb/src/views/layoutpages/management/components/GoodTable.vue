<template>
  <div style="text-align: -webkit-center">
    <el-container>
      <el-header>
        <h1>Goods</h1>
      </el-header>
      <el-main>
        <el-button-group>
          <el-button type="primary" @click="getGoods" icon="MessageBox">Show</el-button>
        </el-button-group>
        <el-table :data="goods" style="width: 100%">
          <el-table-column prop="gid" label="Good id"></el-table-column>
          <el-table-column prop="goodName" label="Good Name"></el-table-column>
          <el-table-column prop="type" label="Type"></el-table-column>
          <el-table-column prop="shelfid" label="Shelfid"></el-table-column>
          <el-table-column prop="floor" label="Floor"></el-table-column>
          <el-table-column prop="start" label="Start"></el-table-column>
          <el-table-column prop="end" label="End"></el-table-column>
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
        url: "http://localhost:8080/good",
        method: 'GET',
      }).then((res) => {
        console.log(res.data);
        this.goods = res.data;
      });
    },

  },
};
</script>

<style>
</style>