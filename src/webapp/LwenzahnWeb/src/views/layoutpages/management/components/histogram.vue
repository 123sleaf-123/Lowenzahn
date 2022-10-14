<template>
  <div id="main">
    <div id="chart1"style="height: 500px">

    </div>
  </div>
</template>

<script type="text/javascript">
import * as echarts from "echarts";
import $ from "jquery";
export default {
  name: "histogram",
  mounted() {

    // 获取页面div
    var myChart = echarts.init(document.getElementById('chart1'));
    var option;

    // 显示加载
    myChart.showLoading();

    //url为数据地址
    //数据格式
    //{xdata : [],ydta : []}
    $.getJSON('url', function (graph) {


      option = {
        // 标题设置
        title: {
          text: '柱状图',
          subtext: 'Default layout',
          top: 'bottom',
          left: 'right'
        },
        tooltip: {
          trigger: 'item',
          formatter: function (parms) {
            return ""
          }
        },
        // 工具栏设置
        toolbox: {
          feature: {
            saveAsImage: {},
            dataView: {},
            restore: {}
          }
        },
        // 饼状图设置
        xAxis: {
          type: 'category',
          data: graph.xdata
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            type: 'bar',
            name: '柱状图',
            data: graph.ydata
          }]
      }
      myChart.setOption(option);
    });

    option && myChart.setOption(option);
  }
}
</script>

<style scoped>

</style>
