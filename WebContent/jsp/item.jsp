<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>仓库管理</title>
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
		货物名称： <input class="easyui-textbox" type="text" name="title" id="searchtitle" /> 
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">查询</a>
	</div>
	<table id="dg" class="easyui-datagrid"  style="width: 100%; height: auto;" 
			url="item/list" method="post" toolbar="#toolbar" fitColumns="true" singleSelect="true" pageSize="30" pagination ="true">
		<thead>
			 <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60" hidden =true>货物ID</th>
        	<th data-options="field:'cid',width:60" hidden =true>货物分类ID</th>
            <th data-options="field:'title',width:200">货物名称</th>
            <th data-options="field:'speciesname',width:100">分类</th>
            <th data-options="field:'price',width:70,align:'right'">价格</th>
            <th data-options="field:'num',width:70,align:'right'">库存数量</th>
            <th data-options="field:'weight',width:70,align:'right'">单位重量(kg)</th>
            <th data-options="field:'status',width:60,align:'center'" formatter ="formatStatus">状态</th>
            <th data-options="field:'created',width:130,align:'center'" formatter="formatDatebox">创建日期</th>
            <th data-options="field:'updated',width:130,align:'center'" formatter="formatDatebox">更新日期</th>
        </tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="destroyUser()">删除</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 480px; height: 400px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons" shadow=true modal=true>
		<form id="fm" method="post">
			<table cellpadding="5" style="margin: auto;">
				<tr style="display: none;">
					<td>ID:</td>
					<td>
						<input class="easyui-textbox" type="hidden" name="id"></input>
						<input class="easyui-textbox" type="hidden" name="userid"></input>
					</td>
				</tr>
				<tr>
					<td>货物名称:</td>
					<td><input class="easyui-textbox" type="text"
						name="title" data-options="required:true,width:200" ></input></td>
				</tr>
				<tr>
					<td>类型:</td>
					<td>
						<select  class="easyui-combotree" style="width:170px;" 
						 data-options="url:'species/getSpeciesData',editable:true,required:true" name ="cid">
						</select>	
					</td>
				</tr>
				<tr>
					<td>价格:</td>
					<td><input class="easyui-textbox" type="text"
						name="price" data-options="required:true,validType:'currency'"></input></td>
				</tr>
				<tr>
					<td>库存数量:</td>
					<td><input class="easyui-textbox" type="text"
						name="num" data-options="required:true,validType:'digits'"></input></td>
				</tr>
				<tr>
					<td>单位重量(kg):</td>
					<td><input class="easyui-textbox" type="text"
						name="weight" data-options="required:true,validType:'onlypdigs'"></input></td>
				</tr>
				<tr>
					<td>状态:</td>
					<td>
						<select  class="easyui-combobox" name="status" style="width:120px;" data-options="required:true" id="statusid">   
    						<option value="1">正常</option>  
    						<option value="2">下架</option>  
    						<option value="3">删除</option>  
						</select>
					</td>
				</tr>
				<tr>
					<td>创建时间:</td>
					<td><input class="easyui-datebox" type="text" name="created" data-options="required:true"></input></td>
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
			$("#dlg").dialog('open').dialog('setTitle', '新增货物');
			$("#fm").form('clear');
			$('#statusid').combobox('setValue', '1').combobox({readonly:true});
			url = 'item/additem';
		}

		function editUser() {
			var row = $("#dg").datagrid("getSelected");
			if (row) {
				$('#statusid').combobox({readonly:false});
				row.created = formatDatebox(row.created);
				$("#dlg").dialog('open').dialog('setTitle', '修改货物');
				$('#fm').form('load', row);
				url = 'item/updateitem';
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
				$.messager.confirm('确认对话框', '确认删除该记录吗?', function(r) {
					if (r) {
						$.post('item/deleteitem', {
							id : row.id
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
				title :$('#searchtitle').val()
			};
			$('#dg').datagrid('load', param);
		}
		
		function formatStatus(value){
			if(value ==undefined ||value ==""){
				return "";
			}
			if(value =="1"){
				return "正常";
			}
			if(value =="2"){
				return "下架";
			}
			if(value =="3"){
				return "删除";
			}
		}
		
	</script>
</body>
</html>