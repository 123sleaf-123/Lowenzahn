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
          <el-table-column prop="warehouseId" label="Warehouse id"></el-table-column>
          <el-table-column prop="warehouseName" label="Warehouse Name">
            <template #default="scope">
              <span v-if="!is_editing">{{ scope.row.warehouseName }}</span>
              <el-input v-model="scope.row.warehouseName" v-else-if="scope.$index === row_editing"></el-input>
            </template>
          </el-table-column>
          <el-table-column prop="warehouseArea" label="warehouseArea">
            <template #default="scope">
              <span v-if="!is_editing">{{ scope.row.warehouseArea }}</span>
              <el-input v-model="scope.row.warehouseArea" v-else-if="scope.$index === row_editing"></el-input>
            </template>
          </el-table-column>
          <el-table-column prop="warehouseAddress" label="warehouseAddress">
            <template #default="scope">
              <span v-if="!is_editing">{{ scope.row.warehouseAddress }}</span>
              <el-input v-model="scope.row.warehouseAddress" v-else-if="scope.$index === row_editing"></el-input>
            </template>
          </el-table-column>
          <el-table-column label="Operations">
            <template #default="scope">
              <el-button v-show="!is_editing || (!is_editing && scope.$index === row_editing)" type="primary" round @click.prevent="editRow(scope.$index)" icon="Edit">Edit
              </el-button>
              <el-button v-show="!is_editing || (!is_editing && scope.$index === row_editing)" type="danger" round @click.prevent="deleteRow(scope.$index)"
                icon="Delete">
                Del
              </el-button>
              <el-button v-show="is_editing && scope.$index === row_editing" type="success" round @click.prevent="saveChange(scope.$index)"
                icon="Check">Save</el-button>
              <el-button v-show="is_editing && scope.$index === row_editing" type="info" round @click="onEditing" icon="close">Cancel</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-main>
    </el-container>
    <AddWhDialog :show-dialog="is_adding" :title="addTitle" @closeDialog="closeAdding"></AddWhDialog>
    <!-- <EditWarehouse key="is_editing" :show-dialog="is_editing" :title="editTitle" :rowData="this.warehouse"
      @closeDialog="closeEditing"></EditWarehouse> -->
    <DeleteWarehouse key="is_deleting" :show-dialog="is_deleting" :title="deleteTitle" :rowData="this.warehouse"
      @closeDialog="cancelDeleting"></DeleteWarehouse>
    <!-- <SearchGoodInWarehouse key="is_searching" :show-dialog="is_searching" :title="searchingTitle"
      :rowData="this.warehouse" @closeDialog="cancelDeleting"></SearchGoodInWarehouse> -->
  </div>
</template>

<script>
import axios from "axios";
import AddWhDialog from "./AddWhDialog.vue";
import EditWarehouse from "./EditWarehouse.vue";
import DeleteWarehouse from "./DeleteWarehouse.vue";
// import SearchGoodInWarehouse from "./SearchGoodInWarehouse.vue"
export default {
  name: "WarehouseTable",
  components: {
    AddWhDialog,
    EditWarehouse,
    DeleteWarehouse,
    // SearchGoodInWarehouse,
  },
  data() {
    return {
      warehouses: [],
      warehouse: null,
      addTitle: 'New Warehouse',
      editTitle: 'Warehouse Information',
      deleteTitle: 'WARNING!',
      searchingTitle: 'Warehouse Goods',
      is_adding: false,
      is_editing: false,
      is_deleting: false,
      is_searching: false,
      row_editing: -1,
    }
  },
  methods: {
    getWarehouses() {
      axios({
        url: "http://localhost:9090/warehouses",
        method: 'GET',
      }).then((res) => {
        console.log(res.data);
        this.warehouses = res.data;
      });
    },
    onAdding() {
      this.is_adding = true;
    },
    onEditing() {
      this.is_editing = !this.is_editing;
      this.row_editing = index;
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
      this.warehouse = row.data;
    },
    editRow(index) {
      this.warehouse = this.warehouses[index];
      this.is_editing = true;
      this.row_editing = index;
      console.log(this.row_editing);
    },
    deleteRow(index) {
      this.warehouse = this.warehouses[index];
      this.is_deleting = true;
    },
    saveChange(index) {
      this.warehouse = this.warehouses[index];
      this.is_editing = false;
      axios.post("http://localhost:9090/warehouses/updating", this.warehouse).then(res => {
        console.log(res)
      })
    }
  },
};
</script>

<style>
</style>