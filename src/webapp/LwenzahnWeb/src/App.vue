<!--
 * @Author: your name
 * @Date: 2021-01-07 09:49:29
 * @LastEditTime: 2021-11-01 14:08:55
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue3-element-admin\src\App.vue
-->
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

<style lang="scss" scoped>
</style>
