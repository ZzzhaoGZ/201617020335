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
			url="order/getorders?orderstatus=1" method="post" toolbar="#toolbar" 
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
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">分配车辆及路线</a> 
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 550px; height: 400px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons" shadow=true modal=true>
		<form id="fm" method="post">
			<table cellpadding="5" style="margin: auto;">
				<tr>
					<td>车辆:</td>
					<td>
						<input class="easyui-combobox" 	data-options="required:true,valueField: 'id',textField: 'text',    
        				url: 'vehicle/getvehiclecheckboxdata'" name="vehicleid" ></input>
					</td>
					<td>路线选择:</td>
					<td>
						<input class="easyui-combobox" 	data-options="required:true,valueField: 'id',textField: 'text',    
        				url: 'route/getroutecheckboxdata'" name="routeid" ></input>
					</td>
				</tr>
			</table>
			<hr/>
			<table cellpadding="5" style="margin: auto;">
				<tr style="display: none;">
					<td>ID:</td>
					<td><input class="easyui-textbox" type="hidden" name="orderid"></input>
					</td>
				</tr>
				<tr>
					<td>订单编号:</td>
					<td><input class="easyui-textbox" type="text"
						name="ordernum" data-options="disabled:true" id="editordernum" style="background-color:gray;"></input></td>
				</tr>
				<tr>
					<td>订单总重:</td>
					<td><input class="easyui-textbox" type="text"
						name="orderweight" data-options="disabled:true"></input></td>
				</tr>
				<tr>
					<td>订单金额:</td>
					<td><input class="easyui-textbox" type="text"
						name="ordercurrency" data-options="disabled:true"></input></td>
				</tr>
				<tr>
					<td>下单人:</td>
					<td><input class="easyui-textbox" type="text"
						name="orderower" data-options="disabled:true"></input></td>
				</tr>
				<tr>
					<td>下单人联系方式:</td>
					<td><input class="easyui-textbox" type="text"
						name="orerowercontact" data-options="disabled:true"></input></td>
				</tr>
				<tr>
					<td>下单人地址:</td>
					<td><input class="easyui-textbox" type="text"
						name="orderoweraddress" data-options="disabled:true"></input></td>
				</tr>
				<tr>
					<td>创建时间:</td>
					<td><input class="easyui-datebox" type="text"
						name="ordercreate" data-options="disabled:true"></input></td>
				</tr>
			</table>
		</form>
		
		<table id="orderdetaildg" class="easyui-datagrid"
		style="width: 100%; height: auto;" 	method="post"  fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="orderdetailid" hidden=true>orderdetailid</th>
				<th field="orderid" hidden=true>orderid</th>
				<th field="itemid" hidden=true>itemid</th>
				<th field="itemname" width="40">商品名称</th>
				<th field="itemnum" width="40">商品数量</th>
				<th field="ordercurrency" width=50>商品金额</th>
				<th field="orderweight" width=50>商品重量</th>
			</tr>
		</thead>
	</table>
	
		
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveUser()">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
	



	<script type="text/javascript">
	/*
	** randomWord 产生任意长度随机字母数字组合
	** randomFlag-是否任意长度 min-任意长度最小位[固定位数] max-任意长度最大位
	** xuanfeng 2014-08-28
	*/
	 
	function randomWord(randomFlag, min, max){
	    var str = "",
	        range = min,
	        arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
	 
	    // 随机产生
	    if(randomFlag){
	        range = Math.round(Math.random() * (max-min)) + min;
	    }
	    for(var i=0; i<range; i++){
	        pos = Math.round(Math.random() * (arr.length-1));
	        str += arr[pos];
	    }
	    return str;
	} 


	
	 function getSelectionsIds(){
	    	var itemList = $("#orderdetaildg");
	    	var sels = itemList.datagrid("getRows");
	    	var ids = [];
	    	for(var i in sels){
	    		ids.push(sels[i].orderdetailid);
	    	}
	    	ids = ids.join(",");
	    	return ids;
	    }
		var url = null;

		function editUser() {
			var row = $("#dg").datagrid("getSelected");
			if (row) {
				var param = {orderNum:row.ordernum};
				$('#orderdetaildg').datagrid({url:'order/getorderdetail',queryParams:param});
				row.ordercreate = formatDatebox(row.ordercreate);
				$("#dlg").dialog('open').dialog('setTitle', '分配车辆路线');
				$('#fm').form('load', row);
			} else {
				$.messager.alert('提示', '请选择一条记录');
			}
		}

		function saveUser() {
			$('#fm').form('submit', {
				url : 'order/applyeorder',
				onSubmit : function() {
					return $('#fm').form('validate');
				},
				success : function(result) {
					result = eval('(' + result + ')');
					if (result.status == 200) {
						$('#dlg').dialog('close');
						$('#dg').datagrid('reload');

					} else {
						$.messager.show({
							title : 'Error',
							msg : result.msg
						});
					}
				}
			})

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