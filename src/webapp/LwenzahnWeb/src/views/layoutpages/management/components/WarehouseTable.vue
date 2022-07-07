<template>
  <div style="text-align: -webkit-center">
    <el-container>
      <el-header>
        <h1>Warehouses</h1>
      </el-header>
      <el-main>
        <el-button-group>
          <el-button type="primary" @click="getWarehouses" icon="MessageBox">Show</el-button>
          <el-button type="primary" @click="onAdding">
            Add<el-icon class="el-icon--right">
              <Plus />
            </el-icon>
          </el-button>
        </el-button-group>
        <el-table :data="warehouses" style="width: 100%">
          <el-table-column prop="whid" label="Warehouse id"></el-table-column>
          <el-table-column prop="whName" label="Warehouse Name"></el-table-column>
          <el-table-column prop="area" label="Area"></el-table-column>
          <el-table-column prop="address" label="Address"></el-table-column>
          <el-table-column label="Operations">
            <el-button type="primary" round @click="onEditing" icon="Edit">Edit</el-button>
            <!-- <el-popconfirm title="Are you sure to delete this?">
              <template #reference>
                <el-button type="danger" round @click="deleteItem">Delete</el-button>
              </template>
            </el-popconfirm> -->
            <el-button type="danger" round @click="deleteItem">Delete</el-button>
          </el-table-column>
        </el-table>
      </el-main>
    </el-container>
  </div>
  <!-- <table class="table caption-top table-hover">
    <caption>
      <h1 class="text-center">Warehouse Management System</h1>
      <el-button-group>
        <el-button type="primary" @click="getWarehouses" icon="MessageBox">Show</el-button>
        <el-button type="primary" @click="onAdding">
          Add<el-icon class="el-icon--right">
            <Plus />
          </el-icon>
        </el-button>
      </el-button-group>
    </caption>
    <thead class="table-dark">
      <tr>
        <th scope="col">Warehouse id</th>
        <th scope="col">Warehouse Name</th>
        <th scope="col">Warehouse Area(m^2)</th>
        <th scope="col">Warehouse Address</th>
        <th scope="col">Operations</th>
      </tr>
    </thead>
    <tbody>
      <warehouseItem v-for="wh in warehouses" :key="wh.id" :warehouse="wh"></warehouseItem>
    </tbody>
  </table> -->
  <AddWhDialog :show-dialog="is_adding" :title="addTitle" @close-dialog="closeAdding"></AddWhDialog>
  <EditWarehouse :show-dialog="is_editing" :title="editTitle" @close-dialog="closeEditing"></EditWarehouse>
</template>

<script>
import axios from "axios";
import warehouseItem from "./warehouseItem.vue";
import AddWhDialog from "./AddWhDialog.vue";
import EditWarehouse from "./EditWarehouse.vue";
export default {
  name: "WarehouseTable",
  components: {
    warehouseItem,
    AddWhDialog,
    EditWarehouse,
  },
  data() {
    return {
      warehouses: [],
      addTitle: 'New Warehouse',
      editTitle: 'Edit Warehouse',
      is_adding: false,
      is_editing: false,
      editWarehouse: null,
    }
  },
  methods: {
    getWarehouses() {
      axios({
        url: "http://localhost:8080/warehouses",
        method: 'GET',
      }).then((res) => {
        console.log(res.data);
        this.warehouses = res.data;
      });
    },
    onAdding() {
      this.is_adding = true;
    },
    closeAdding() {
      this.is_adding = false;
    },
    // sumbitAdding
    onEditing() {
      this.is_edit = true;
      // this.editWarehouse = 
    },
    closeEditing() {
      this.is_edit = false;
    },
    addItem() {
      axios.post("http://localhost:8080/warehouses/adding", this.warehouse).then(res => {
        console.log(res)
      })
    },
    deleteItem() {
      axios.post("http://localhost:8080/warehouses/deleting", this.warehouse).then(res => {
        console.log(res)
      })
    },
    accept() {
      axios.post("http://localhost:8080/warehouses/updating", this.warehouse).then(res => {
        console.log(res)
      })
      this.is_edit = false
    },
    abort() {
      this.is_edit = false
    }
  },
};
</script>

<style>
</style>