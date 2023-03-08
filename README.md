# README

这是一个前后端分离的项目。
This is a front and rear end separation project.

## 如何运行 How to run

### 数据库 Database

安装MySQL或者Mariadb。新建数据库zuizhong，将zuizhong.sql导入数据库

Import the database zuizhong to MySQL.

### 连接 Connection

Modify src/main/resources/application.yml, replace with your MySQL username and password 

### 后端 Back End - Spring

- 用Maven打包项目
```shell
cd ./
mvn clean # 清理已生成文件（可选）
mvn package # 打包项目可运行jar
```

- 运行可执行jar文件
```shell
cd ./target
java -jar xxx.jar
```

### 前端 Front end - Vue

Then is the front end system. This is a Vue project.

- 先安装node.js或者bun
```shell
cd ./src/webapp/LwenzahnWeb
npm i # npm install 或者 bun i
```

- Wait and start.

```shell
npm run serve # 或者 bun run serve
```

- 打包成静态网页（可选），可以在根目录得到dist文件夹，打开index.html即可浏览。
```shell
npm run build # 或者 bun run build
```

## 项目结构

1. 后端项目： Lowenzahn Warehouse Management System
src/main下的文件结构
```
├─java
│  └─com
│      └─Lwenzahn
│          ├─controller
│          │  └─dto
│          ├─mapper
│          ├─pojo
│          └─service
│              └─impl
└─resources
└─mybatis
```
- com.Lwenzahn包是后端项目的逻辑核心，main方法所在的主运行程序文件LwenzahnApplication.java就在这个目录下。
- com.Lwenzahn包下的pojo包是存放描述各角色实体对象（管理员、货物、仓库以及工人）的类文件命名规则为实体类名.java。
- com.Lwenzahn包下的mapper包是声明对各实体对象进行操作的Mapper接口类文件，命名规则为实体类名Mapper.java。当Controller类调用经过MyBatis的@Autowired注解的对应mapper，实际上是调用MyBatis自动生成的查询方法。
- com.Lwenzahn包下的service包是声明对各实体对象所提供的服务的Service接口类文件，命名规则为实体类名Service.java。其实现类则存放在Service包的impl包中，命名规则为实体类名ServiceImpl.java。当Controller类调用经过@Resource注解的Service接口类变量的方法时，实际上是调用实现类的重写方法。
- com.Lwenzahn包下的controller包则是存放操作个各实体对象，能够对实体对象进行转换使得数据前后端传输，并实现前后端分离的Controller类。
  - 内置经过MyBatis的@Autowired注解的对应Mapper，或者经过@Resource注解的对应Service。
  - 以此为基础提供能响应前端post或get的方法，命名规则为实体类名Controller.java。
  - 包下的DTO包为各对应实体的实体子集，仅包含实体的部分属性，以方便调用，命名规则为实体类名DTO.java。

Resouces下目前只有项目配置文件application.yml，其他文件暂时没有任何作用。

2. 前端项目： Lowenzahn Web
由于是修改开源项目而成，而且项目设计也非常工程化，有很多我暂时无力使用和控制的功能。
```
src
    ├─api
    │  └─modules
    ├─assets
    ├─components
    │  ├─dashboard
    │  ├─layout
    │  │  └─components
    │  └─veBaseComponents
    ├─directives
    │  └─modules
    ├─plugins
    ├─router
    ├─store
    │  └─modules
    │      └─app
    ├─styles
    ├─utils
    └─views
        └─layoutpages
            ├─leisure
            ├─management
            │  └─components
            └─system
                └─components
```
- Api文件夹下面是一些工程配置文件，包括文件形式存储的数据（在modules子文件夹中），以及mock等的配置文件。
- Components文件夹下面是应用于主界面的一些组件的vue文件。
- Plugins文件夹下面是一些用于直接引入axios、element plus等模组并进行基本配置的文件。
- Views文件夹下的layoutpages的management是实际上真正自主可控的部分，包括各个显示页面及其部件（Component子目录下）。大部分的组建的vue文件就在这里。
- Router文件架下面主要是vue router转跳的设置。每一个界面的转跳都需要用到router.push()方法。
- system文件下主要是主界面，其中login.vue是着力修改的文件，并在此文件实现了登录功能的前端部分。基本吃透了这个文件相关的部分。

## Q&A

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
