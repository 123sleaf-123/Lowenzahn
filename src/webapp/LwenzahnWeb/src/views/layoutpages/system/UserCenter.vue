<template>
    <div>

        <div style="margin: auto">
            <el-avatar :size="300" :src="this.user.managerAvatar"></el-avatar>
            <span style="font-size: 150px; color: #a926a8;">
                {{ this.user.managerName }}
            </span>
        </div>
        <div style="margin: auto">
            <el-descriptions
                title="Profile"
                column="1"
                border
            >
                <el-descriptions-item>
                    <template #label>
                        <div class="cell-item">
                            <el-icon>
                                <user />
                            </el-icon>
                            Username
                        </div>
                    </template>
                    {{ this.user.managerName }}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template #label>
                        <div class="cell-item">
                            <el-icon>
                                <male />
                            </el-icon>
                            /
                            <el-icon>
                                <female />
                            </el-icon>
                            User Gender
                        </div>
                    </template>
                    {{ this.user.managerGender }}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template #label>
                        <div class="cell-item">
                            <el-icon>
                                <tools />
                            </el-icon>
                            User Birthday
                        </div>
                    </template>
                    {{ this.user.managerBirthday }}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template #label>
                        <div class="cell-item">
                            <el-icon>
                                <tools />
                            </el-icon>
                            User Level
                        </div>
                    </template>
                    <el-tag :color="color">{{ this.level }}</el-tag>
                </el-descriptions-item>
            </el-descriptions>
            <el-descriptions
                column="1"
                border
            >
                <el-descriptions-item>
                    <template #label>
                        <div class="cell-item">
                            <el-icon>
                                <comment />
                            </el-icon>
                            Description
                        </div>
                    </template>
                    {{ this.user.managerDescription }}
                </el-descriptions-item>
            </el-descriptions>
        </div>
    </div>
</template>

<script>
import axios from "axios"
export default {
    data() {
        return {
            user: {
                managerId: null,
                managerPassword: null,
                managerName: null,
                managerPower: null,
                managerBirthday: null,
                managerGender: null,
                managerDescription: null,
                managerAvatar: null,
            },
            level: null,
            color: null,
        }
    },
    methods: {
        async queryUser() {
            axios.get("http://localhost:9090/manager/queryUser", {
            }).then((res) => {
                this.user = res.data;
                console.log(this.user);
                this.setLevel();
            })
        },
        setLevel() {
            switch (this.user.managerPower) {
                case 0:
                    this.level = 'Super Admin';
                    this.color = 'ff0000';
                    break;
                case 1:
                    this.level = 'Admin';
                    this.color = 'ff6600';
                    break;
                case 2:
                    this.level = 'Normal User';
                    this.color = 'ffcc00';
                    break;
                default:
                    this.level = 'Normal User';
                    this.color = 'ffcc00';
            };
            console.log(this.user);
        }
    },
    mounted() {
        this.queryUser();
    },
}
</script>

<style>
.cell-item {
  display: flex;
  align-items: center;
}
</style>