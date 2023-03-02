<template>
  <div style="text-align: -webkit-center">
    <el-container>
      <el-header>
        <h1>Workers</h1>
      </el-header>
      <el-main>
        <el-button-group>
          <el-button type="primary" @click="this.reload" icon="Refresh">Refresh</el-button>
          <el-button type="primary" @click="onAdding">
            New WKR<el-icon class="el-icon--right">
              <Plus />
            </el-icon>
          </el-button>
        </el-button-group>
        <el-table :data="workers.slice((currentPage-1)*pagesize,currentPage*pagesize)" style="width: 100%">
          <el-table-column prop="workerId" label="Worker ID">
          </el-table-column>
          <el-table-column prop="workerName" label="Worker Name">
            <template #default="scope">
              <span v-if="!is_editing">{{ scope.row.workerName }}</span>
              <el-input v-model="scope.row.workerName" v-else-if="scope.$index === row_editing"></el-input>
            </template>
          </el-table-column>
          <el-table-column prop="workerPassword" label="Password">
            <template #default="scope">
              <span v-if="!is_editing || scope.$index !== row_editing">******</span>
              <el-input type="password" show-password v-model="scope.row.workerPassword" v-else-if="scope.$index === row_editing"></el-input>
            </template>
          </el-table-column>
          <el-table-column label="Operations">
            <template #default="scope">
              <!-- <el-button type="primary" round @click.prevent="editRow(scope.$index)" icon="Edit">Edit</el-button>
              <el-button type="danger" round @click.prevent="deleteRow(scope.$index)" icon="Delete">Del</el-button> -->
              <el-button v-show="!is_editing || (!is_editing && scope.$index === row_editing)" type="primary" round
                @click="editRow(scope.$index)" icon="Edit">Edit</el-button>
              <el-button v-show="!is_editing || (!is_editing && scope.$index === row_editing)" type="danger" round
                @click="deleteRow(scope.$index)" icon="Delete">Del
              </el-button>
              <el-button v-show="is_editing && scope.$index === row_editing" type="success" round
                @click.prevent="saveChange(scope.$index)" icon="Check">Save</el-button>
              <el-button v-show="is_editing && scope.$index === row_editing" type="info" round
                @click.prevent="cancelChange(scope.$index)" icon="Close">Cancel</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10, 20, 30, 40, 50]"
        :page-size="pagesize"
        :total="workers.length"
        layout="total, sizes, prev, pager, next, jumper">
        </el-pagination>
      </el-main>
    </el-container>
    <AddWorker :show-dialog="is_adding" :title="addTitle" @close-dialog="closeAdding"></AddWorker>
    <!-- <EditWorker key="is_editing" :show-dialog="is_editing" :title="editTitle" :rowData="this.worker"
      @close-dialog="closeEditing"></EditWorker> -->
    <DeleteWorker key="is_deleting" :show-dialog="is_deleting" :title="deleteTitle" :rowData="this.worker"
      @closeDialog="cancelDeleting"></DeleteWorker>
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
      workers: [],
      worker: null,
      addTitle: 'New Worker',
      editTitle: 'Worker Information',
      deleteTitle: 'WARNING!',
      is_adding: false,
      is_editing: false,
      is_deleting: false,
      row_editing: -1,
      pagesize:10,//默认分页每页数据量
      currentPage:1,//默认展示第一页数据
    }
  },
  inject: ['reload'],
  methods: {
    getWorkers() {
      axios({
        url: "http://localhost:9090/worker",
        method: 'GET',
      }).then((res) => {
        console.log(res.data);
        this.workers = res.data;
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
      this.reload();
    },
    closeEditing() {
      this.is_editing = false;
    },
    cancelDeleting(status) {
      this.is_deleting = false;
      if (status == true) this.reload();
    },
    clickRow(row) {
      console.log(row);
      console.log(row.data);
      this.worker = row.data;
    },
    editRow(index) {
      this.worker = this.workers[index];
      this.is_editing = true;
      this.row_editing = index;
    },
    deleteRow(index) {
      this.worker = this.workers[index];
      this.is_deleting = true;
    },
    saveChange(index) {
      this.worker = this.workers[index];
      this.is_editing = false;
      axios.post("http://localhost:9090/worker/updating", this.worker).then(res => {
        console.log(res)
      })
      this.reload();
    },
    cancelChange(index) {
      this.editRow = index;
      this.workers[index] = this.worker;
      this.is_editing = false;
      this.reload();
    },
    handleSizeChange: function(val) {
        this.pagesize = val;
    },
    handleCurrentChange: function(currentPage) {
        this.currentPage = currentPage;
    },
  },
  mounted() {
    this.getWorkers();
  },
};
</script>

<style>
</style>