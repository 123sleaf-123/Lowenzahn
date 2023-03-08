<!--
 * @Author: your name
 * @Date: 2021-01-07 16:21:00
 * @LastEditTime: 2021-10-15 17:16:31
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \Lowenzahn\src\components\layout\SideBar.vue
-->
<template>
    <router-link to="/">
        <logo />
    </router-link>
    <!-- <personal-panel></personal-panel> -->
    <div class="ve_el_menu">
        <el-scrollbar>
            <el-menu
                :default-active="defaultActive"
                :collapse="opened"
                :collapseTransition="false"
                unique-opened
                :background-color="sideBgColor"
                :text-color="sideTextColor"
                :active-text-color="sideActiveTextColor"
            >
                <slide-menu
                    v-for="item in menus"
                    :key="item.id"
                    :menu="item"
                ></slide-menu>
            </el-menu>
            <el-image v-show="!opened" style="width: 200px; height: 200px" :src="realm" />
            <div>
                <el-image v-show="opened" style="width: 60px; height: 60px" :src="deliverance" />
            </div>
            <div>
                <el-image v-show="opened" style="width: 60px; height: 60px" :src="realm" />
            </div>
            <div>
                <el-image v-show="opened" style="width: 60px; height: 60px" :src="gold" />
            </div>
            <div>
                <el-image v-show="opened" style="width: 60px; height: 60px" :src="restrict" />
            </div>
            <div>
                <el-image v-show="opened" style="width: 60px; height: 60px" :src="stars" />
            </div>
            <div>
                <el-image v-show="opened" style="width: 60px; height: 60px" :src="infinity" />
            </div>
            <div>
                <el-image v-show="opened" style="width: 60px; height: 60px" :src="light" />
            </div>
            <div>
                <el-image v-show="opened" style="width: 60px; height: 60px" :src="vicissitude" />
            </div>
            <div>
                <el-image v-show="opened" style="width: 60px; height: 60px" :src="setsuna" />
            </div>
        </el-scrollbar>
    </div>
</template>

<script setup>
import {
    nav_height,
    sideBgColor,
    sideTextColor,
    sideActiveTextColor,
} from "@/styles/variables.scss.js";
import { computed } from "vue";
import { useStore } from "vuex";
import { useRoute } from "vue-router";
import Logo from "./components/Logo";
import PersonalPanel from "./components/PersonalPanel"
import SlideMenu from "./components/SlideMenu";

const store = useStore();
const route = useRoute();
const opened = computed(() => store.getters.opened);
const menus = computed(() => store.getters.menuList);
const defaultActive = computed(() => {
    let i = route.name.indexOf("/");
    if (i < 0) {
        return "/" + route.name;
    } else {
        return "/" + route.name.slice(0, i);
    }
});
// const pic_src = '/刻印/高清png图片/';
// const pics = 
// [
//     '救世.webp',
//     '真我.webp',
//     '黄金.webp',
//     '戒律.webp',
//     '繁星.webp',
//     '无限.webp',
//     '旭光.webp',
//     '浮生.webp',
//     '刹那.webp',
//     '天慧.webp',
// ]
const pic_src = 'https://i.postimg.cc/';
const pics = 
[
    '9Qykb28h/image.webp',
    'JhPPYzj9/image.webp',
    'MHhs031H/image.webp',
    'B677bn6x/image.webp',
    'bv8BF5W2/image.webp',
    'bvzmRtSx/image.webp',
    'K8hqRVZs/image.webp',
    'BvgVWgf7/image.webp',
    'h4w3qvNn/image.webp',
    'vZ7P9zT8/image.webp',
]
const deliverance  = pic_src + pics[0];
const realm = pic_src + pics[1];
const gold = pic_src + pics[2];
const restrict = pic_src + pics[3];
const stars = pic_src + pics[4];
const infinity = pic_src + pics[5];
const light = pic_src + pics[6];
const vicissitude = pic_src + pics[7];
const setsuna = pic_src + pics[8];
const bodhi = pic_src + pics[9];
</script>

<style lang="scss" scoped>
a:active {
    color: $base-color;
}
.ve_el_menu {
    background: $sideBgColor;
    height: calc(100vh - v-bind(nav_height));
}
</style>
