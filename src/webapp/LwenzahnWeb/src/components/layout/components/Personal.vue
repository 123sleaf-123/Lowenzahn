<!--
 * @Author: your name
 * @Date: 2021-01-15 16:42:16
 * @LastEditTime: 2022-04-28 16:38:32
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue3-element-admin\src\components\layout\components\Personal.vue
-->
<template>
    <div class="ve_personal">
        <el-button-group>
            <el-button
                title="Refresh"
                style="border: none; font-size: 20px"
                circle
                plain
                @click="reload()"
            >
                <el-icon :size="30" style="vertical-align: middle">
                    <Refresh />
                </el-icon>
            </el-button>
            <el-button
                title="Full-screen"
                style="border: none; font-size: 20px"
                circle
                plain
                @click="toggle()"
            >
                <el-icon :size="25" style="vertical-align: middle">
                    <full-screen />
                </el-icon>
            </el-button>
            <el-button
                :title="dark ? 'Darkness' : 'Lighting'"
                style="border: none; font-size: 20px"
                circle
                plain
                @click="toggleTheme()"
            >
                <el-icon :size="30" style="vertical-align: middle">
                    <component :is="dark ? 'moon' : 'sunny'" />
                </el-icon>
            </el-button>
        </el-button-group>
        <el-divider direction="vertical"></el-divider>
        <el-dropdown @command="handleCommand">
            <span class="ve_nav_dropdown">
                Hello!{{ uname }}
                <el-icon>
                    <arrow-down-bold />
                </el-icon>
            </span>
            <template #dropdown>
                <el-dropdown-menu>
                    <el-dropdown-item>
                        <el-icon><Setting /></el-icon>Settings
                    </el-dropdown-item>
                    <el-dropdown-item :command="{ name: 'Login' }">
                        <el-icon><SwitchButton /></el-icon>Sign Out
                    </el-dropdown-item>
                </el-dropdown-menu>
            </template>
        </el-dropdown>
        <!-- <router-link :to="{ name: 'Login' }">
            <el-link :underline="false">退出</el-link>
        </router-link> -->
    </div>
</template>

<script setup>
import { useStore } from "vuex";
import { useRouter } from "vue-router";
import { inject, computed, ref } from "vue";
import { useFullscreen } from "@vueuse/core";
const { toggle } = useFullscreen();
const store = useStore();
const router = useRouter();
const uname = computed(() => store.getters.uname);
const reload = inject("reload");
const handleCommand = (command) => {
    router.push(command);
};
const dark = ref(false);
const toggleTheme = () => {
    dark.value = !dark.value;
    document.documentElement.classList.toggle("dark");
};
</script>

<style lang="scss" scoped>
.ve_personal {
    flex: 1;
    align-items: center;
    text-align: right;
    :deep(.el-dropdown) {
        vertical-align: baseline !important;
    }
    .ve_nav_dropdown {
        font-weight: bold;
    }
}
</style>
