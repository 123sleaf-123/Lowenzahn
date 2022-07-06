<template>
  <tr>
    <!-- <th scope="row"></th> -->
    <th scope="row" v-show="!is_edit">{{ warehouse.whid }}</th>
    <td v-show="!is_edit">{{ warehouse.whName }}</td>
    <td v-show="!is_edit">{{ warehouse.area }}</td>
    <td v-show="!is_edit">{{ warehouse.address }}</td>
    <td v-show="!is_edit">
        <el-button type="primary" round @click="modifyItem">Modify</el-button>
        <el-button type="danger" round @click="deleteItem">Delete</el-button>
    </td>
    <td scope="row" v-show="is_edit"><input type="text" v-model.number="warehouse.whid"/></td>
    <td v-show="is_edit"><input type="text" v-model="warehouse.whName"/></td>
    <td v-show="is_edit"><input type="text" v-model.number="warehouse.area"/></td>
    <td v-show="is_edit"><input type="text" v-model="warehouse.address"/></td>
    <td v-show="is_edit">
        <el-button type="primary" round @click="accept">Save</el-button>
        <el-button type="info" round @click="abort">Cancel</el-button>
    </td>
  </tr>
</template>

<script>
import axios from 'axios'

export default {
  name: 'warehouseItem',
  data() {
    return {
      is_edit: false
    }
  },
  methods: {
    modifyItem() {
      this.is_edit=true
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
      this.is_edit=false
    },
    abort() {
      this.is_edit=false
    }
  },
  props: ['warehouse']
}
</script>

<style>
</style>