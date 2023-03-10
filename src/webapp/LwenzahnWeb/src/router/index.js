/*
 * @Author: your name
 * @Date: 2021-01-07 11:41:32
 * @LastEditTime: 2021-03-24 16:14:18
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \Lowenzahn\src\router\index.js
 */
import { createRouter, createWebHashHistory } from "vue-router";
import globalRoutes from "./globalRoutes";
import mainRoutes from "./mainRoutes";

const router = createRouter({
    mode: "history",
    base: "/lowenzahn/",
    history: createWebHashHistory(),
    scrollBehavior: () => ({ y: 0 }),
    isAddDynamicMenuRoutes: false, // 是否已经添加动态(菜单)路由
    routes: globalRoutes.concat(mainRoutes),
});
export default router;
