<!--
 * @Author: your name
 * @Date: 2021-01-07 11:50:47
 * @LastEditTime: 2021-10-15 17:18:43
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue3-element-admin\src\components\layout\navbar.vue
-->
<template>
    <div class="ve_nav_bar">
        <hamburger></hamburger>
        <breadcrumb></breadcrumb>
        <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=298 height=52 src="//music.163.com/outchain/player?type=2&id=1971144922&auto=1&height=32"></iframe>
        <personal></personal>
    </div>
</template>
<script setup>
import Hamburger from "./components/Hamburger.vue";
import Breadcrumb from "./components/Breadcrumb.vue";
import Personal from "./components/Personal.vue";
</script>
<style lang="scss" scoped>
.ve_nav_bar {
    display: flex;
    align-items: center;
    height: 100%;
}
</style>
