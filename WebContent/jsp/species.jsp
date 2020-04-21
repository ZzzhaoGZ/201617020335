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
	<div style="margin:20px 20px;">
		货物类别管理<span style="color: red">(请在类别上右键菜单)</span>:<ul id="tt"></ul>   
	</div>
<div id="mm" class="easyui-menu" style="width:120px;">
	<div onclick="append()" data-options="iconCls:'icon-add'">新增</div>
	<div onclick="update()" data-options="iconCls:'icon-remove'">修改</div>
	<div onclick="destroyNode()" data-options="iconCls:'icon-remove'">移除</div>
</div>


<div id="dlg" class="easyui-dialog" style="width:400px;height:150px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" shadow=true modal=true>
	<form id="fm" method="post">
		<table cellpadding="5" style="margin: auto;">
	    		<tr>
	    			<td>商品类别:</td>
	    			<td><input class="easyui-textbox" type="text" name="speciesname" data-options="required:true"></input></td>
	    		</tr>
	    </table>		
	</form>
</div>
<div id="dlg-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveSpecies()">保存</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
<script type="text/javascript">
	var url =null;
	var isAdd= true;
	function append(){
		//子节点不允许新增节点
		/*  var node = $("#tt").tree('getSelected');
		 var parent = $("#tt").tree('getParent',node.target);
		if(parent!= null&&$("#tt").tree("isLeaf",node.target)){
			$.messager.alert('提示','请选择宠物大类添加');
			return;
		} */
		$("#fm").form('clear');
		$('#dlg').dialog('open').dialog('setTitle','添加商品类别');
		url ='species/addSpecies';
		isAdd =true;
	}
	
	function update(){
		var node = $("#tt").tree('getSelected');
		$('#fm').form('load',{
			speciesname:node.text
		});
		url ='species/updateSpecies';
		$('#dlg').dialog('open').dialog('setTitle','修改商品类别');
		isAdd = false;
	}
	
	
	
	function saveSpecies(){
		var node = $("#tt").tree('getSelected');
		$('#fm').form('submit',{
			url:url,
			onSubmit: function(param){
				if(isAdd){
					param.speciesparentid = node.id;
				}else{
					param.speciesid =node.id;
				}
			},
			success:function(result){
				result=eval("("+result+")");
				if(result.status ==200){
					$('#dlg').dialog('close');
					if(isAdd){
						$('#tt').tree('append', {
							parent: node.target,
							data:[{
								id:result.data.speciesid,
								text:result.data.speciesname
							}]
						});
					}else{
						$('#tt').tree('update',{
							target: node.target,
							text: result.data.speciesname
						})
					}
					
				}else{
					$.messager.show({
						title:'Error',
						msg: result.msg
					});
				}
				$('#tt').tree('reload');
			}
		})
		
	}
	
	function destroyNode(){
		var node = $("#tt").tree('getSelected');
		if(node){
			$.messager.confirm('确认对话框', '确认删除该记录吗?', function(r){
				if (r){
					$.post('species/deleteSpecies',{speciesId:node.id},function(result){
						if (result.status==200){
							$("#tt").tree("remove",node.target);
						} else {
							$.messager.show({	// show error message
								title: 'Error',
								msg: result.msg
							});
						}
					},'json');
				}
			});
		}else{
			$.messager.alert('提示','请选择一条记录');  
		}
	}

	$('#tt').tree({    
	    url:'species/getSpeciesData',
	    onContextMenu:function(e, node){
			e.preventDefault();
			// 查找节点
			$('#tt').tree('select', node.target);
			// 显示快捷菜单
			$('#mm').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		}

	});  
	
</script>
</body>
</html>