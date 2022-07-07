<template>
  <div style="text-align: -webkit-center">
    <el-container>
      <el-header>
        <h1>Workers</h1>
      </el-header>
      <el-main>
        <el-button-group>
          <el-button type="primary" @click="getWorkers" icon="Refresh">Refresh</el-button>
        </el-button-group>
        <el-table :data="goods" style="width: 100%">
          <el-table-column prop="wkrid" label="Worker id"></el-table-column>
          <el-table-column prop="wkrName" label="Worker Name"></el-table-column>
          <el-table-column prop="pwd" label="Password"></el-table-column>
          <!-- <el-table-column prop="shelfid" label="Shelfid"></el-table-column>
          <el-table-column prop="floor" label="Floor"></el-table-column>
          <el-table-column prop="start" label="Start"></el-table-column>
          <el-table-column prop="end" label="End"></el-table-column> -->
          <el-table-column label="Operations">
            <el-button type="primary" round @click="onEditing" icon="Edit">Edit</el-button>
            <el-button type="danger" round @click="deleteItem">Delete</el-button>
          </el-table-column>
        </el-table>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "WorkerTable",
  components: {
  },
  data() {
    return {
      goods: [],
    }
  },
  methods: {
    getWorkers() {
      axios({
        url: "http://localhost:8080/worker",
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