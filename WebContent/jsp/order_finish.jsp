<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>快递管理</title>
 <link href="css/default.css" rel="stylesheet" type="text/css" />
 <link rel="stylesheet" type="text/css" href="js/eazyui/themes/black/easyui.css" />
 <link rel="stylesheet" type="text/css" href="js/eazyui/themes/icon.css" />
 <script type="text/javascript" src="js/eazyui/jquery.min.js"></script>
 <script type="text/javascript" src="js/eazyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/eazyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/DateFormat.js"></script>
</head>
<body>
	<div style="margin: 20px 20px;">
		订单号： <input class="easyui-textbox" type="text" name="ordernum"
			id="ordernum" /> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">查询</a>
	</div>
	<table id="dg" class="easyui-datagrid"  style="width: 100%; height: auto;" 
			url="order/getorders?orderstatus=2" method="post" toolbar="#toolbar" 
			fitColumns="true" singleSelect="true" pageSize="30" pagination ="true">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="orderid" hidden=true>orderid</th>
				<th field="routeid" hidden=true>routeid</th>
				<th field="vehicleid" hidden=true>vehicleid</th>
				<th field="ordernum" width="40">订单编号</th>
				<th field="orderstatus" width="40" formatter="formatStatus">订单状态</th>
				<th field="orderower" width=50>下单人</th>
				<th field="orerowercontact" width=50>下单人联系方式 </th>
				<th field="orderoweraddress" width=50>下单人地址 </th>
				<th field="orderweight" width=50>订单总重 </th>
				<th field="ordercurrency" width=50>订单金额 </th>
				<th field="vehiclename" width=50>车辆 </th>
				<th field="routename" width=50>路线 </th>
				<th field="ordercreate" width="50" formatter="formatDatebox">创建时间</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="destroyUser()">确认到达</a>
	</div>



	<script type="text/javascript">

		function destroyUser() {
			var row = $("#dg").datagrid("getSelected");
			if (row) {
				$.messager.confirm('确认对话框', '确认送达！！！', function(r) {
					if (r) {
						$.post('order/orderfinish', {
							orderid : row.orderid
						}, function(result) {
							if (result.status == 200) {
								$('#dg').datagrid('reload'); // reload the user data
							} else {
								$.messager.show({ // show error message
									title : 'Error',
									msg : result.msg
								});
							}
						}, 'json');
					}
				});
			} else {
				$.messager.alert('提示', '请选择一条记录');
			}
		}

		function submitForm() {
			var param = {
				ordernum : $('#ordernum').val()
			};
			$('#dg').datagrid('load', param);
		}
		  function	formatStatus(value){
			  if(value ==undefined || value ==""){
				  return "";
			  }
			  if(value =="1"){
				  return "等待发货";
			  }
			  if(value =="2"){
				  return "配送中";
			  }
			  if(value =="3"){
				  return "完成";
			  }
			  
		  }
		
	</script>
</body>
</html>