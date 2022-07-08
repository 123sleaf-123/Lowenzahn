<!--
 * @Author: your name
 * @Date: 2021-03-16 11:32:02
 * @LastEditTime: 2021-10-15 17:37:44
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue3-element-admin\src\components\dashboard\Shortcuts.vue
-->
<template>
    <el-row :gutter="20" style="padding-bottom: 10px">
        <el-col :span="12">
            <div class="ve-card ve_card1" @click="query">
                <el-icon>
                    <HomeFilled />
                </el-icon>
                <div>
                    <p>Warehouses</p>
                    <span>{{ this.warehouses }}</span>
                </div>
            </div>
        </el-col>
        <el-col :span="12">
            <div class="ve-card ve_card2">
                <el-icon>
                    <Setting />
                </el-icon>
                <div>
                    <p>Managers</p>
                    <span>{{ this.managers }}</span>
                </div>
            </div>
        </el-col>
    </el-row>
    <el-row :gutter="20" style="padding-top: 10px">
        <el-col :span="12">
            <div class="ve-card ve_card3">
                <el-icon>
                    <el-icon>
                        <UserFilled />
                    </el-icon>
                </el-icon>
                <div>
                    <p>Workers</p>
                    <span>{{ this.workers }}</span>
                </div>
            </div>
        </el-col>
        <el-col :span="12">
            <div class="ve-card ve_card4">
                <el-icon>
                    <Goods />
                </el-icon>
                <div>
                    <p>Goods</p>
                    <span>{{ this.goods }}</span>
                </div>
            </div>
        </el-col>
    </el-row>
</template>

<script>
import axios from "axios"
export default {
    data() {
        return {
            warehouses: null,
            workers: null,
            managers: null,
            goods: null
        }
    },
    methods: {
        query() {
            axios({
                url: "http://localhost:8080/warehouses",
                method: 'GET',
            }).then((res) => {
                console.log(res.data);
                this.warehouses = res.data.length;
            });
            axios({
                url: "http://localhost:8080/worker",
                method: 'GET',
            }).then((res) => {
                console.log(res.data);
                this.workers = res.data.length;
            });
            axios({
                url: "http://localhost:8080/manager",
                method: 'GET',
            }).then((res) => {
                console.log(res.data);
                this.managers = res.data.length;
            });
            axios({
                url: "http://localhost:8080/good",
                method: 'GET',
            }).then((res) => {
                console.log(res.data);
                this.goods = res.data.length;
            });
        }
    }
}
</script>

<style lang="scss" scoped>
.el-row {
    height: 50%;

    padding-right: 10px;
}

.ve-card {
    border-radius: 10px;
    height: 100%;
    display: flex;
    align-items: center;
    transition: all 500ms;
    color: #fff;

    &:hover {
        box-shadow: 3px 3px 6px 1px rgba(0, 0, 0, 0.2);
        background: #fff;
    }

    i {
        font-size: 100px;
        margin: 0 20px;
    }

    div {
        flex: 1;
        padding-right: 12px;

        p {
            margin: 0;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        span {
            font-size: 60px;
            font-weight: bold;
        }
    }
}

.ve_card1 {
    background: #409eff;

    &:hover {
        color: #409eff;
    }
}

.ve_card2 {
    background: #67c23a;

    &:hover {
        color: #67c23a;
    }
}

.ve_card3 {
    background: #e6a23c;

    &:hover {
        color: #e6a23c;
    }
}

.ve_card4 {
    background: #f56c6c;

    &:hover {
        color: #f56c6c;
    }
}
</style>
