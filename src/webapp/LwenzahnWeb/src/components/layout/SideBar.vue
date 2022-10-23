<!--
 * @Author: your name
 * @Date: 2021-01-07 16:21:00
 * @LastEditTime: 2021-10-15 17:16:31
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue3-element-admin\src\components\layout\SideBar.vue
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
const deliverance  = 'https://upload-bbs.mihoyo.com/upload/2022/09/01/76413883/df2be5de1b041c48436262704a11a5e4_3242604389942984127.png?x-oss-process=image//resize,s_500/quality,q_80/auto-orient,0/interlace,1/format,png';
const realm = 'https://upload-bbs.mihoyo.com/upload/2022/09/01/76413883/879b3e226aef59e64a3bd4e4e1f8caa8_7059912764470960966.png?x-oss-process=image//resize,s_500/quality,q_80/auto-orient,0/interlace,1/format,png';
const gold = 'https://upload-bbs.mihoyo.com/upload/2022/09/01/76413883/6e709bd2e4d2450faf4417e978b17e3d_7551664541755581185.png?x-oss-process=image//resize,s_500/quality,q_80/auto-orient,0/interlace,1/format,png';
const restrict = 'https://upload-bbs.mihoyo.com/upload/2022/09/01/76413883/0ae3843cd640fc0b7555a24504358423_924073242095675008.png?x-oss-process=image//resize,s_500/quality,q_80/auto-orient,0/interlace,1/format,png';
const stars = 'https://upload-bbs.mihoyo.com/upload/2022/09/01/76413883/bb47ef143630353ada0189dd768e3a3c_6046008501742423349.png?x-oss-process=image//resize,s_500/quality,q_80/auto-orient,0/interlace,1/format,png';
const infinity = 'https://upload-bbs.mihoyo.com/upload/2022/09/01/76413883/91bc7b95ea7c07082c78800c606121ab_4595837322903012138.png?x-oss-process=image//resize,s_500/quality,q_80/auto-orient,0/interlace,1/format,png';
const light = 'https://upload-bbs.mihoyo.com/upload/2022/09/01/76413883/ea2a1d97df931d49c5cf192b10a82d7c_2952544506445421444.png?x-oss-process=image//resize,s_500/quality,q_80/auto-orient,0/interlace,1/format,png';
const vicissitude = 'https://upload-bbs.mihoyo.com/upload/2022/09/01/76413883/4ae693643977536311c612e196d65d23_5867757470877592391.png?x-oss-process=image//resize,s_500/quality,q_80/auto-orient,0/interlace,1/format,png';
const setsuna = 'https://upload-bbs.mihoyo.com/upload/2022/09/01/76413883/cc5e8686260f07df1da12afeb5a18730_8181300956407481074.png?x-oss-process=image//resize,s_500/quality,q_80/auto-orient,0/interlace,1/format,png';
const bodhi = 'https://upload-bbs.mihoyo.com/upload/2022/09/01/76413883/19a91be4cac07738ed6c317aafaa4d9c_2402733630003657235.png?x-oss-process=image//resize,s_500/quality,q_80/auto-orient,0/interlace,1/format,png';
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
