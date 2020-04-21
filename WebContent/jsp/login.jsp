<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>物流企業信息管理</title>
 <link href="css/default.css" rel="stylesheet" type="text/css" />
 <link rel="stylesheet" type="text/css" href="js/eazyui/themes/black/easyui.css" />
 <link rel="stylesheet" type="text/css" href="js/eazyui/themes/icon.css" />
 <script type="text/javascript" src="js/eazyui/jquery.min.js"></script>
 <script type="text/javascript" src="js/eazyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/eazyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/DateFormat.js"></script>
</head>
<body>
	<div class="easyui-window" style="width: 550px;height: 300px" title="登录" 
	data-options="
		minimizable:false,
		maximizable:false,
		closable:false,
		draggable:false">
			
			<div title="用户登录" style="padding:20px;">   
		       	  <form style="padding:10px 20px 10px 40px;" id="loginForm" method="post">
					<table cellpadding="5" style="margin: auto;">
						<tr>
			    			<td>用户名</td>
			    			<td><input class="easyui-textbox" type="text" name="userloginid" id="userloginid" data-options="required:true" style="width:130px;" value="admin"/></td>
			    			<td></td>
			    		</tr>
			    		<tr>
			    			<td>密码</td>
			    			<td><input class="easyui-textbox" type="password" name="userloginpasswd" id="userloginpasswd" data-options="required:true" style="width:130px;" value="123"/></td>
			    			<td></td>
			    		</tr>
			    		<!-- <tr>
			    			<td>验证码</td>
			    				<td>
			    					<input class="easyui-textbox" type="text" name="imagecode" id="imageCode" data-options="required:true" style="width:130px;"/>
			    				
			    				</td>
			    				<td>
			    					<img  src="user/getimage" onclick="reload()" title="点击刷新"  id="verifyCode"/>
			    				</td>
			    		</tr> -->
					</table>
				</form>
				<div style="padding:5px;text-align:center;">
					<a href="#" class="easyui-linkbutton" icon="icon-ok" id="loginButtion" onclick="login()">登录</a>
					<a href="#" class="easyui-linkbutton" icon="icon-cancel">取消</a>
					<a href="#" class="easyui-linkbutton" icon="icon-man" onclick="openDialog()">注册</a>
				</div>
   			 </div> 
			<div id="expressdlg" class="easyui-dialog"
				style="width: 480px; height: 420px; padding: 10px 20px" closed="true"
				buttons="#expressdlg-buttons" shadow=true modal=true>
				<form id="expressfm" method="post">
					<table cellpadding="5" style="margin: auto;">
						<tr>
							<td>快递单号:</td>
							<td><input class="easyui-textbox" type="text"
								name="expressno" readonly="readonly"></input></td>
						</tr>
						<tr>
							<td>收件人名称:</td>
							<td><input class="easyui-textbox" type="text"
								name="expressrecievername" data-options="required:true" ></input></td>
						</tr>
						<tr>
							<td>收件人联系方式:</td>
							<td><input class="easyui-textbox" type="text"
								name="expressrecievercontact" data-options="required:true"> </input></td>
						</tr>
						<tr>
							<td>收件人地址:</td>
							<td><input class="easyui-textbox" type="text"
								name="expressrecieveraddress" data-options="required:true" style="width:250px"></input></td>
						</tr>
					</table>
				</form>
			</div>
			<div id="expressdlg-buttons">
				<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
					onclick="updateExpress()">保存</a> <a href="#" class="easyui-linkbutton"
					iconCls="icon-cancel" onclick="javascript:$('#expressdlg').dialog('close')">取消</a>
			</div>
   			 </div> 
		
		
	
	<div id="dlg" class="easyui-dialog" style="width:400px;height:250px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" shadow=true modal=true title="注册">
	<form id="fm" method="post">
		<table cellpadding="5" style="margin: auto;">
				<tr>
	    			<td>登录名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="userloginid" data-options="required:true" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>登录密码:</td>
	    			<td><input class="easyui-textbox" type="password" name="userloginpasswd" data-options="required:true" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>联系方式:</td>
	    			<td><input class="easyui-textbox" type="text" name="usercontact" data-options="required:true,validType:'mobile'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>用户邮箱:</td>
	    			<td><input class="easyui-textbox" type="text" name="useremail" data-options="required:true,validType:'email'"></input></td>
	    		</tr>
	    </table>		
	</form>
</div>
<div id="dlg-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="register()">提交</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
	<script type="text/javascript">
		function login(){
			
			$('#loginForm').form('submit', {    
			    url:'user/userlogin',    
			    onSubmit: function(){    
			        return $("#loginForm").form('validate');    
			    },    
			    success:function(result){  
			    	result = eval("("+result+")");
			    	if(result.status == 200){
						window.location.href="index";
					}else{
						$.messager.alert('警告',result.msg);
						reload();
					}
			    }    
			}); 
		}
		
		//打开注册窗口
		function openDialog(){
			$("#dlg").dialog('open');
			$("#fm").form('clear');
		}
		
		function register(){
			$('#fm').form('submit', {    
			    url:'user/register',    
			    onSubmit: function(){    
			        return $("#fm").form('validate');    
			    },    
			    success:function(result){  
			    	result = eval("("+result+")");
			    	if(result.status == 200){
			    		$.messager.alert('提示信息',result.msg);
			    		$("#dlg").dialog('close');
					}else{
						$.messager.alert('警告',result.msg);
					}
			    }    
			}); 
		}
		
		/* js方式 */  
		function reload(){  
			$("#verifyCode").attr("src", $("#verifyCode").attr("src").toString().split("?")[0]+ "?time=" + new Date().getTime());  
		}  
		
		function getExpressInfo(){
			var $expressno =$('#expressno').val();
			if($expressno ==""){
				$.messager.alert('警告',"请输入快递单号");
			}
			$('#expressfm').form('clear');
			$.post('login/expressnologin',{expressNO: $expressno},function(result){
				//result = eval("("+result+")");
				if(result.status ==200){
					result.data.expresscreatetime =formatDatebox(result.data.expresscreatetime);
					$('#expressfm').form('load',result.data);
					$('#expressdlg').dialog('open').dialog('setTitle', '快递记录纠错');
					
				}else{
					$.messager.alert('警告',result.msg);
				}
				
			});
		}
		
		function updateExpress(){
			$('#expressfm').form('submit', {
				url : 'login/updateexpress',
				onSubmit : function() {
					return $('#expressfm').form('validate');
				},
				success : function(result) {
					result = eval('(' + result + ')');
					if (result.status == 200) {
						$('#expressdlg').dialog('close');
						$.messager.alert('提示',"提交成功");
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