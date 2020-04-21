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
		用户名称： <input class="easyui-textbox" type="text" name="userloginid"
			id="userloginid" /> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">查询</a>
	</div>
	<table id="dg" class="easyui-datagrid"
		style="width: 100%; height: auto;" url="user/getusers"
		method="post" toolbar="#toolbar" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="userid" hidden=true>userid</th>
				<th field="userloginid">用户名称</th>
				<th field="userloginpasswd">登录密码</th>
				<th field="usercontact" width="50">联系方式</th>
				<th field="useremail" width="50">邮箱</th>
				<th field="createtime" width="50" formatter="formatDatebox">创建时间</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="destroyUser()">删除</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addfunction()">分配角色</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 460px; height: 400px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons" shadow=true modal=true>
		<form id="fm" method="post">
			<table cellpadding="5" style="margin: auto;">
				<tr style="display: none;">
					<td>ID:</td>
					<td><input class="easyui-textbox" type="hidden" name="userid"></input>
					</td>
				</tr>
				<tr>
					<td>快递员名称:</td>
					<td><input class="easyui-textbox" type="text"
						name="userloginid" data-options="required:true"
						id="edituserloginid"></input></td>
				</tr>
				<tr>
					<td>登录密码:</td>
					<td><input class="easyui-textbox" type="password"
						name="userloginpasswd" data-options="required:true" id="pd"></input></td>
				</tr>
				<tr>
					<td>联系方式:</td>
					<td><input class="easyui-textbox" type="text"
						name="usercontact" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td><input class="easyui-textbox" type="text" name="useremail"
						data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>创建时间:</td>
					<td><input class="easyui-datebox" type="text"
						name="createtime" data-options="required:true"></input></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveUser()">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
	
	<div id="dlg2" class="easyui-dialog"
		style="width: 460px; height: 200px; padding: 10px 20px" closed="true"
		buttons="#dlg2-buttons" shadow=true modal=true>
		<form id="fm2" method="post">
			<table cellpadding="5" style="margin: auto;">
				<tr style="display: none;">
					<td>ID:</td>
					<td><input class="easyui-textbox" type="hidden" name="userid"></input>
					</td>
				</tr>
				<tr>
					<td>用户名:</td>
					<td><input class="easyui-textbox" type="text"
						name="userloginid" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>角色:</td>
					<td><input class="easyui-combobox" 	data-options="valueField: 'id',textField: 'text',    
        				url: 'function/getRoleData'" name="roleid"  id="rolecombo"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg2-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveFunction()">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg2').dialog('close')">取消</a>
	</div>



	<script type="text/javascript">
		var url = null;
		function newUser() {
			$("#dlg").dialog('open').dialog('setTitle', '新增用户');
			$("#fm").form('clear');
			$('#headImg').attr('src', '');
			$('#fileid').textbox('clear');
			$('#edituserloginid').textbox('textbox').attr('readonly', false);
			url = 'user/adduser';
		}

		function editUser() {
			var row = $("#dg").datagrid("getSelected");
			if (row) {
				$('#edituserloginid').textbox('textbox').attr('readonly', true);
				row.createtime = formatDatebox(row.createtime);
				$("#dlg").dialog('open').dialog('setTitle', '修改用户');
				$('#fm').form('load', row);
				url = 'user/updateuser';
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
						$.post('user/deleteuser', {
							userid : row.userid
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
				userloginid : $('#userloginid').val()
			};
			$('#dg').datagrid('load', param);
		}
		
		function addfunction(){
			$('#fm2').form('clear');
			var row = $("#dg").datagrid("getSelected");
			if (row) {
				$.post('function/getRoleByUserId',{userid:row.userid},function(result){
					//result = eval('(' + result + ')');
					if(result.status==200){
						$('#rolecombo').combobox('setValue',result.data.roleid);
					}
					$('#fm2').form('load',{userid:row.userid,userloginid:row.userloginid});
					$("#dlg2").dialog('open').dialog('setTitle', '分配角色');
				});
			}	
		}
		
		function saveFunction(){
			 $('#fm2').form('submit', {
				url : 'function/adduserrole',
				onSubmit : function() {
					return $('#fm2').form('validate');
				},
				success : function(result) {
					result = eval('(' + result + ')');
					if (result.status == 200) {
						$('#dlg2').dialog('close');
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
	</script>
</body>
</html>