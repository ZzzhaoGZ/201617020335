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
			url="order/getorders" method="post" toolbar="#toolbar" 
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
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="destroyUser()">删除</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 500px; height: 400px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons" shadow=true modal=true>
		<form id="fm" method="post">
			<table cellpadding="5" style="margin: auto;">
				<tr style="display: none;">
					<td>ID:</td>
					<td><input class="easyui-textbox" type="hidden" name="orderid"></input>
					</td>
				</tr>
				<tr>
					<td>订单编号:</td>
					<td><input class="easyui-textbox" type="text"
						name="ordernum" data-options="readonly:true" id="editordernum"></input></td>
				</tr>
				<tr>
					<td>下单人:</td>
					<td><input class="easyui-textbox" type="text"
						name="orderower" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>下单人联系方式:</td>
					<td><input class="easyui-textbox" type="text"
						name="orerowercontact" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>下单人地址:</td>
					<td><input class="easyui-textbox" type="text"
						name="orderoweraddress" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>创建时间:</td>
					<td><input class="easyui-datebox" type="text"
						name="ordercreate" data-options="required:true"></input></td>
				</tr>
			</table>
		</form>
		
		<table id="orderdetaildg" class="easyui-datagrid"
		style="width: 100%; height: auto;" 	method="post" toolbar="#detailtoolbar" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="orderdetailid" hidden=true>orderdetailid</th>
				<th field="orderid" hidden=true>orderid</th>
				<th field="itemid" hidden=true>itemid</th>
				<th field="itemname" width="40">货物名称</th>
				<th field="itemnum" width="40">货物数量</th>
				<th field="ordercurrency" width=50>货物金额</th>
				<th field="orderweight" width=50>货物重量</th>
			</tr>
		</thead>
	</table>
	<div id="detailtoolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newDetail()">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editDetail()">修改</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="destroyDetail()">删除</a>
	</div>
		
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveUser()">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
	
	<div id="addorderdetail" class="easyui-dialog"
		style="width: 460px; height: 200px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons2" shadow=true modal=true>
		<form id="addorderdetailfm" method="post">
			<table cellpadding="5" style="margin: auto;">
				<tr style="display: none;">
					<td>ID:</td>
					<td><input class="easyui-textbox" type="hidden" name="orderdetailid"></input>
					</td>
				</tr>
				<tr>
					<td>货物:</td>
					<td>
						<input class="easyui-combobox" 	data-options="required:true,valueField: 'id',textField: 'text',    
        				url: 'item/getitemcheckboxdata'" name="itemid" ></input>
					</td>
				</tr>
				<tr>
					<td>数量:</td>
					<td><input class="easyui-textbox" type="text"
						name="itemnum" data-options="required:true,validType:'digits'"></input></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons2">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveOrderDetail()">保存</a> <a href="#" class="easyui-linkbutton"
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
		function newUser() {
			$("#dlg").dialog('open').dialog('setTitle', '新增订单');
			$("#fm").form('clear');
			var orderNum =   randomWord(false, 15);
			var param = {orderNum:orderNum};
			$('#orderdetaildg').datagrid({url:'order/getorderdetail',queryParams:param});
			$("#fm").form('load',{ordernum:orderNum});
			url = 'order/addorder';
		}

		function editUser() {
			var row = $("#dg").datagrid("getSelected");
			if (row) {
				var param = {orderNum:row.ordernum};
				$('#orderdetaildg').datagrid({url:'order/getorderdetail',queryParams:param});
				row.ordercreate = formatDatebox(row.ordercreate);
				$("#dlg").dialog('open').dialog('setTitle', '修改订单');
				$('#fm').form('load', row);
				url = 'order/updateorder';
			} else {
				$.messager.alert('提示', '请选择一条记录');
			}
		}

		function saveUser() {
			$('#fm').form('submit', {
				url : url,
				onSubmit : function(param) {
					var data=$('#orderdetaildg').datagrid('getData');
					if(data.rows.length ==undefined ||data.rows.length ==0){
						$.messager.alert('提示', '请添加货物记录');
						return false;
					}
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

		function destroyUser() {
			var row = $("#dg").datagrid("getSelected");
			if (row) {
				$.messager.confirm('确认对话框', '确认删除用户！！！', function(r) {
					if (r) {
						$.post('order/deleteorder', {
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
		
		var orderdetailurl = null;
		function newDetail(){
			$("#addorderdetail").dialog('open').dialog('setTitle', '新增记录');
			$("#addorderdetailfm").form('clear');
			orderdetailurl = 'order/addorderdetail';
		}
		
		function editDetail(){
			var row = $("#orderdetaildg").datagrid("getSelected");
			if (row) {
				$("#addorderdetail").dialog('open').dialog('setTitle', '修改记录');
				$('#addorderdetailfm').form('load', row);
				orderdetailurl = 'order/updateorderdetail';
			} else {
				$.messager.alert('提示', '请选择一条记录');
			}
		}
		
		function saveOrderDetail(){
			$('#addorderdetailfm').form('submit', {
				url : orderdetailurl,
				onSubmit : function(param) {
					param.ordernum = $('#editordernum').val();
					return $('#addorderdetailfm').form('validate');
				},
				success : function(result) {
					result = eval('(' + result + ')');
					if (result.status == 200) {
						$('#addorderdetail').dialog('close');
						$('#orderdetaildg').datagrid('reload');

					} else {
						$.messager.show({
							title : 'Error',
							msg : result.msg
						});
					}
				}
			})
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