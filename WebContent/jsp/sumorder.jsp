<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title></title>
 <link href="css/default.css" rel="stylesheet" type="text/css" />
 <link rel="stylesheet" type="text/css" href="js/eazyui/themes/black/easyui.css" />
 <link rel="stylesheet" type="text/css" href="js/eazyui/themes/icon.css" />
 <script type="text/javascript" src="js/eazyui/jquery.min.js"></script>
 <script type="text/javascript" src="js/eazyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/eazyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body style="padding:0">  
<div>
	统计时间:
	<input class="easyui-datebox" type="text" name="date" data-options="required:true" id="dateid"></input>
	统计类型
	<select id="sumlevel">
		<option value="1">按月份统计</option>
		<option value="2">按季度统计</option>
		<option value="3">按年份统计</option>
	</select>
	图形形状
	<select id="pictype">
		<option value="1">柱状图</option>
		<option value="2">饼状图</option>
	</select>
	统计数据
	<select id="sumtype">
		<option value="1">盈利</option>
		<option value="2">运货量</option>
	</select>
	<button type="button" onclick="change()">获取</button>
</div>
<div style="padding:10px;clear: both;">  
    <div id="psLine" style="height:700px;"></div>  
</div>  
</body>  
<script src="js/echarts-all.js"></script>  
<script type="text/javascript">  
    //图表  
    var psLineChar = echarts.init(document.getElementById('psLine'));  
  
    //查询  
    function loadDrugs() {
    	 var date = $('#dateid').datebox('getValue');
         if(date ==undefined || date ==""){
        	 alert('请选择统计的时间!');
          	return;
         }
    	
        psLineChar.clear();  
        psLineChar.showLoading({text: '正在努力的读取数据中...'});  
        var sumlevel = $('#sumlevel').val();
        var pictype = $('#pictype').val();
        var sumtype = $('#sumtype').val();
        $.getJSON('order/sumorder', {date:date,sumlevel:sumlevel,pictype:pictype,sumtype:sumtype},function (data) {  
        	//data = eval("("+data+")");
            if (data.status ==200) {  
                psLineChar.setOption(data.data, true);  
                psLineChar.hideLoading();  
            } else {  
                alert('提示', data.msg);  
            }  
        });  
    }  
    //载入图表  
    //loadDrugs();  
    
    function change(){
    	loadDrugs();
    }
</script> 