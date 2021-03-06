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
		路线名： <input class="easyui-textbox" type="text" name="routename"
			id="routename" /> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">查询</a>
	</div>
	<table id="dg" class="easyui-datagrid"
		style="width: 100%; height: auto;" url="route/getroutes"
		method="post" toolbar="#toolbar" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="routeid" hidden=true>routeid</th>
				<th field="routename" width="40">路线名称</th>
				<th field="routedesc" width=180>路线描述</th>
				<th field="routecreate" width="50" formatter="formatDatebox">创建时间</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="destroyUser()">删除</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 460px; height: 400px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons" shadow=true modal=true>
		<form id="fm" method="post">
			<table cellpadding="5" style="margin: auto;">
				<tr style="display: none;">
					<td>ID:</td>
					<td><input class="easyui-textbox" type="hidden" name="routeid"></input>
					</td>
				</tr>
				<tr>
					<td>路线名称:</td>
					<td><input class="easyui-textbox" type="text"
						name="routename" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>路线描述:</td>
					<td><input class="easyui-textbox" type="text"
						name="routedesc" data-options="required:true,multiline:true"></input></td>
				</tr>
				<tr>
					<td>创建时间:</td>
					<td><input class="easyui-datebox" type="text"
						name="routecreate" data-options="required:true"></input></td>
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
			$("#dlg").dialog('open').dialog('setTitle', '新增路线');
			$("#fm").form('clear');
			url = 'route/addroute';
		}

		function editUser() {
			var row = $("#dg").datagrid("getSelected");
			if (row) {
				row.routecreate = formatDatebox(row.routecreate);
				$("#dlg").dialog('open').dialog('setTitle', '修改路线');
				$('#fm').form('load', row);
				url = 'route/updateroute';
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
				$.messager.confirm('确认对话框', '确认删除用户！！！', function(r) {
					if (r) {
						$.post('route/deleteroute', {
							routeid : row.routeid
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
				routename : $('#routename').val()
			};
			$('#dg').datagrid('load', param);
		}
	</script>
</body>
</html>