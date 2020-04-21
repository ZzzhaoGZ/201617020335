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
		车牌号： <input class="easyui-textbox" type="text" name="vehiclenum"
			id="vehiclenum" /> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">查询</a>
	</div>
	<table id="dg" class="easyui-datagrid"
		style="width: 100%; height: auto;" url="vehicle/getvehicle"
		method="post" toolbar="#toolbar" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th data-options="field:'vehicleid',width:60" hidden =true>vehicleid</th>
				<th data-options="field:'vehicletypeid',width:60" hidden =true>vehicletypeid</th>
				 <th data-options="field:'vehicleowername',width:60">车主姓名</th>
				 <th data-options="field:'vehicletypename',width:60">车辆型号</th>
				 <th data-options="field:'vehiclestatus',width:60" formatter="formatStatus">车辆状态</th>
				 <th data-options="field:'vehiclenum',width:60">车牌号</th>
				 <th data-options="field:'vehicleowercontact',width:60">车主联系方式</th>
				 <th data-options="field:'vehicleowerid',width:60">车主证件号</th>
				 <th data-options="field:'vehicledrivername',width:60">司机姓名</th>
				 <th data-options="field:'vehicledriverid',width:60">司机证件号</th>
				 <th data-options="field:'vehicleload',width:60">载重</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="destroyUser()">删除</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 560px; height: 450px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons" shadow=true modal=true>
		<form id="fm" method="post">
			<table cellpadding="5" style="margin: auto;">
				<tr style="display: none;">
					<td>ID:</td>
					<td><input class="easyui-textbox" type="hidden" name="vehicleid"></input>
					</td>
				</tr>
				<tr>
					<td>车辆类型:</td>
					<td>
						 <input class="easyui-combobox" 	data-options="required:true,valueField: 'id',textField: 'text',    
        				url: 'vehicletype/getvehicletypecheckboxdata'" name="vehicletypeid" ></input>
					</td>
				</tr>
				<tr>
					<td>车主姓名:</td>
					<td><input class="easyui-textbox" type="text"
						name="vehicleowername" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>车牌号:</td>
					<td><input class="easyui-textbox" type="text"
						name="vehiclenum" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>车主联系方式:</td>
					<td><input class="easyui-textbox" type="text"
						name="vehicleowercontact" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>车主证件号:</td>
					<td><input class="easyui-textbox" type="text"
						name="vehicleowerid" data-options="required:true,width:200"></input></td>
				</tr>
				<tr>
					<td>司机姓名:</td>
					<td><input class="easyui-textbox" type="text"
						name="vehicledrivername" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>司机证件号:</td>
					<td><input class="easyui-textbox" type="text"
						name="vehicledriverid" data-options="required:true,width:200"></input></td>
				</tr>
				<tr>
					<td>载重:</td>
					<td><input class="easyui-textbox" type="text"
						name="vehicleload" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>状态:</td>
					<td>
						<select class="easyui-combobox" name="vehiclestatus"  data-options="required:true,width:120">
							<option value="1">正常</option>
							<option value="2">维修</option>
						</select>
					</td>
				</tr>
				
				
				
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveUser()">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
	



	<script type="text/javascript">
		var url = null;
		function newUser() {
			$("#dlg").dialog('open').dialog('setTitle', '新增车辆');
			$("#fm").form('clear');
			url = 'vehicle/addvehicle';
		}

		function editUser() {
			var row = $("#dg").datagrid("getSelected");
			if (row) {
				$("#dlg").dialog('open').dialog('setTitle', '修改车辆');
				$('#fm').form('load', row);
				url = 'vehicle/updatevehicle';
			} else {
				$.messager.alert('提示', '请选择一条记录');
			}
		}

		function saveUser() {
			$('#fm').form('submit', {
				url : url,
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

		function destroyUser() {
			var row = $("#dg").datagrid("getSelected");
			if (row) {
				$.messager.confirm('确认对话框', '确认删除记录！！！', function(r) {
					if (r) {
						$.post('vehicle/deletevehicle', {
							vehicleid : row.vehicleid
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

		
		
		function formatStatus(value){
			if(value==undefined || value ==""){
				return "";
			}
			if(value=="1"){
				return "正常";
			}else if(value=="2"){
				return "维修";
			}
		}
		
		function submitForm() {
			var param = {
				vehiclenum : $('#vehiclenum').val()
			};
			$('#dg').datagrid('load', param);
		}
		
	</script>
</body>
</html>