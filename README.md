# README

This is a front and rear end separation project.

## How to run

### Database

Import the database zuizhong to MySQL.

### Connection

Modify src/main/resources/application.yml, replace with your MySQL username and password 

### Back End

Select LwenzahnApplication.java, run the main method. Then the back end system is running now.

### Front end

Then is the front end system. This is a Vue project.

```shell
cd src/webapp/LwenzahnWeb/src

npm i
```

Wait and start.

```shell
npm run serve
```

## Problems & Solutions

### How to add typescript to a vue project

### 1. How to transmit data to subcomponents dynamically?

Example:
We can add key to subComponent in _SuperComponent.vue_:

```html

<template>
    <subComponent key='aKey' :data="this.Data"></subComponent>
</template>
<script>
import subComponent from "RelativePathOfSubComponent"
    component: {
        subComponent,
    }
    data() {
        Data: aData(Eg. 11.1, 'hello', false)
        aKey: aData1(Eg. 11, 'bye', true)
    }
    ...
    Data = bData;
    ...
    // We want to transmit this.Data with another value to subComponent now
    aKey = bData1; (note: bData1 != aData1)


</script>
```

When the value of aKey change, the subComponent will be re-rendered. At this moment, this.Data will be transmitted to
subComponent again

### 2. How to automatically refresh a web page in vue3?

In vue3 setup is important, so in App.vue, we can write a reload function:

```html

<template>
    <router-view v-if="isRouterAlive"></router-view>
</template>

<script setup>
import { ref, nextTick, provide } from "vue";
const isRouterAlive = ref(true);
const reload = () => {
    isRouterAlive.value = false;
    nextTick(() => {
        isRouterAlive.value = true;
    });
};
provide("reload", reload);


</script>
```

And in the target vue file, we can write these:

```html

<script>
    const reload = inject("reload");


</script>
```

Then we can call reload() statement where we need to refresh the web page.

### 3. How to locate a row in an el-table?

At any el-table-column in the el-table, we can run such codes:

```html

<template #default="scope">
    // Use the value of one of the attributes of rows in an el-table 
    {{ scope.row.attributeName }}
    
    // Get the row index
    scope.$index
    
    // Pass row index to an method
    <el-button @click.prevent="func(scope.$index)"></el-button>
</template>
```

### 4. How to init the web pages?
Using mounted() function in export default

```html
mounted() {
    // this.getGoods();
    // ...
    // Do what you want to init
}
```
