<template>
  <div style="text-align: -webkit-center">
    <el-container>
      <el-header>
        <h1>Warehouses</h1>
      </el-header>
      <el-main>
        <div style="text-align:end">
          <el-button-group>
            <el-button @click="getWarehouses" icon="Refresh"></el-button>
            <el-button type="primary" @click="onAdding">
              <el-icon class="el-icon--right">
                <Plus />
              </el-icon>
            </el-button>
          </el-button-group>
        </div>
        <el-table :data="warehouses" style="width: 100%" empty-text="There aren't any warehouse!">
          <el-table-column prop="whid" label="Warehouse id"></el-table-column>
          <el-table-column prop="whName" label="Warehouse Name"></el-table-column>
          <el-table-column prop="area" label="Area"></el-table-column>
          <el-table-column prop="address" label="Address"></el-table-column>
          <el-table-column label="Operations">
            <template #default="scope">
              <el-button type="primary" round @click.prevent="editRow(scope.$index)" icon="Edit">Edit</el-button>
              <el-button type="danger" round @click.prevent="deleteRow(scope.$index)">
                Remove
              </el-button>
            </template>
            <!-- <el-button type="primary" round @click="onEditing" icon="Edit">Edit</el-button> -->
            <!-- <el-popconfirm title="Are you sure to delete this?">
              <template #reference>
                <el-button type="danger" round @click="deleteItem">Delete</el-button>
              </template>
            </el-popconfirm> -->
            <!-- <el-button type="danger" round @click="onDeleting">Delete</el-button> -->
          </el-table-column>
        </el-table>
      </el-main>
    </el-container>
    <AddWhDialog :show-dialog="is_adding" :title="addTitle" @close-dialog="closeAdding"></AddWhDialog>
    <EditWarehouse key="is_editing" :show-dialog="is_editing" :title="editTitle" :rowData="this.warehouse"
      @close-dialog="closeEditing"></EditWarehouse>
    <!-- <DeleteWarehouse :show-dialog="is_deleting" :title="deleteTitle" :rowData="this.warehouse" @close-dialog="cancelDeleting" ref="delChild"></DeleteWarehouse> -->
    <DeleteWarehouse key="is_deleting" :show-dialog="is_deleting" :title="deleteTitle" :rowData="this.warehouse"
      @close-dialog="cancelDeleting"></DeleteWarehouse>
  </div>
</template>

<script>
import axios from "axios";
import AddWhDialog from "./AddWhDialog.vue";
import EditWarehouse from "./EditWarehouse.vue";
import DeleteWarehouse from "./DeleteWarehouse.vue";
export default {
  name: "WarehouseTable",
  components: {
    warehouseItem,
    AddWhDialog,
    EditWarehouse,
    DeleteWarehouse,
  },
  data() {
    return {
      warehouses: [],
      warehouse: null,
      addTitle: 'New Warehouse',
      editTitle: 'Warehouse Information',
      deleteTitle: 'WARNING!',
      is_adding: false,
      is_editing: false,
      is_deleting: false,
      // editWarehouse: null,
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
    closeEditing() {
      this.is_editing = false;
    },
    cancelDeleting() {
      this.is_deleting = false;
    },
    clickRow(row) {
      console.log(row);
      console.log(row.data);
      this.warehouse = row.data;
    },
    editRow(index) {
      this.warehouse = this.warehouses[index];
      this.is_editing = true;
    },
    deleteRow(index) {
      this.warehouse = this.warehouses[index];
      this.is_deleting = true;
    },
  },
};
</script>

<style>
</style>