<template>
  <div style="text-align: -webkit-center">
    <el-container>
      <el-header>
        <h1>Workers</h1>
      </el-header>
      <el-main>
        <el-button-group>
          <el-button type="primary" @click="getWorkers" icon="Refresh">Refresh</el-button>
          <el-button type="primary" @click="onAdding">
            New WKR<el-icon class="el-icon--right">
              <Plus />
            </el-icon>
          </el-button>
        </el-button-group>
        <el-table :data="goods" style="width: 100%">
          <el-table-column prop="wkrid" label="Worker id">
          </el-table-column>
          <el-table-column prop="wkrName" label="Worker Name">
            <template #default="scope">
              <span v-if="!is_editing">{{ scope.row.wkrName }}</span>
              <el-input v-model="scope.row.wkrName" v-else></el-input>
            </template>
          </el-table-column>
          <el-table-column prop="pwd" label="Password">
            <template #default="scope">
              <span v-if="!is_editing">{{ scope.row.pwd }}</span>
              <el-input v-model="scope.row.pwd" v-else></el-input>
            </template>
          </el-table-column>
          <el-table-column label="Operations">
            <template #default="scope">
              <!-- <el-button type="primary" round @click.prevent="editRow(scope.$index)" icon="Edit">Edit</el-button>
              <el-button type="danger" round @click.prevent="deleteRow(scope.$index)" icon="Delete">Del</el-button> -->
              <el-button v-show="!is_editing" type="primary" round @click="onEditing" icon="Edit">Edit</el-button>
              <el-button v-show="!is_editing" type="danger" round @click="deleteRow(scope.$index)" icon="Delete">Del
              </el-button>
              <el-button v-show="is_editing" type="info" round @click="onEditing" icon="close">Cancel</el-button>
              <el-button v-show="is_editing" type="success" round @click.prevent="saveChange(scope.$index)"
                icon="Check">Save</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-main>
    </el-container>
    <AddWorker :show-dialog="is_adding" :title="addTitle" @close-dialog="closeAdding"></AddWorker>
    <!-- <EditWorker key="is_editing" :show-dialog="is_editing" :title="editTitle" :rowData="this.good"
      @close-dialog="closeEditing"></EditWorker> -->
    <DeleteWorker key="is_deleting" :show-dialog="is_deleting" :title="deleteTitle" :rowData="this.warehouse"
      @close-dialog="cancelDeleting"></DeleteWorker>
  </div>
</template>

<script>
import axios from "axios";
import AddWorker from "./AddWorker.vue"
import EditWorker from "./EditWorker"
import DeleteWorker from './DeleteWorker.vue'
export default {
  name: "WorkerTable",
  components: {
    AddWorker,
    EditWorker,
    DeleteWorker,
  },
  data() {
    return {
      goods: [],
      good: null,
      addTitle: 'New Worker',
      editTitle: 'Worker Information',
      deleteTitle: 'WARNING!',
      is_adding: false,
      is_editing: false,
      is_deleting: false,
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
    onAdding() {
      this.is_adding = true;
    },
    onEditing() {
      this.is_editing = !this.is_editing;
    },
    closeAdding() {
      this.is_adding = false;
    },
    closeEditing() {
      this.is_editing = false;
    },
    cancelDeleting() {
      this.is_deleting = false;
    },
    clickRow(row) {
      console.log(row);
      console.log(row.data);
      this.good = row.data;
    },
    editRow(index) {
      this.good = this.goods[index];
      this.is_editing = true;
    },
    deleteRow(index) {
      this.good = this.goods[index];
      this.is_deleting = true;
    },
    saveChange(index) {
      this.good = this.goods[index];
      this.is_editing = false;
      axios.post("http://localhost:8080/worker/updating", this.good).then(res => {
        console.log(res)
      })
    }
  },
};
</script>

<style>
</style>