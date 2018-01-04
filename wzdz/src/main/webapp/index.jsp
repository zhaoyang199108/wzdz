<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<html>
<head>
<link
	href="<c:url value="/resources/jquery-ui/themes/base/style.css" />"
	rel="stylesheet" type="text/css" />
<title>登录</title>

<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/jquery-easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/css/login.css">		
<script type="text/javascript" src="<%=basePath%>/resources/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/jquery-MD5Encode/jquery.MD5.js" ></script>
<script type="text/javascript">
	
	function submitForm(){
		console.log("sss");
		$('#loginform').form('submit',{
			
			url:'${pageContext.request.contextPath}/user/userLogin',
			success:function(data){
				$(this).form('clear');
				
				$('#numberInfo').css('display','none');
				$('#pwdInfo').css('display','none');
				$('#userNotFindInfo').css('display','none');
				
				if(data=="true"){
					window.location.href="<%=basePath%>/";
				}
				else{
					window.location.href="<%=basePath%>/login";
				} 
					
			}
			});
	}
	$(function(){
		document.onkeydown = function(e){
		    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
		    	submitForm();
		     }
		};
		$("#btn_login").mouseover(function () {
			$(this).css("background", "url(<%=basePath%>/resources/css/imgs/btn_login_focus.png)");
	    }).mouseout(function () {
			$(this).css("background", "url(<%=basePath%>/resources/css/imgs/btn_login.png)");
	    });
		$('#number'). focus(function(){
			$('#numberInfo').css('display','none');
			$('#pwdInfo').css('display','none');
			$('#userNotFindInfo').css('display','none');
		});
		$('#password_NotEncrypted'). focus(function(){
			$('#numberInfo').css('display','none');
			$('#pwdInfo').css('display','none');
			$('#userNotFindInfo').css('display','none');
		});
	});
	</script>
	
</head>
<body>		
          <form id="loginform" method="post" >
	         <div id="login_box">				
	                <div style="position:absolute; left:35; top:90;">
						<!-- <input type="text" id="number" name="number"/>  -->
						<input type="text" id="number" name="number"  autocomplete='off' placeholder=" 用户名"/>
					</div>
					<div style="position:absolute; left:35; top:140;">
						<input type="hidden" id="password" name="password" />
						<input type="password" id="password_NotEncrypted" name="password_NotEncrypted" placeholder=" 密码"/> 
					</div>
					<div style="position:absolute; left:35; top:190;">
					 <font id="numberInfo" color="red" face="宋体" size="2" style="display:none">用户名不能为空！</font>
					 <font id="pwdInfo" color="red" face="宋体" size="2" style="display:none">密码不能为空！</font>
					 <font id="userNotFindInfo" color="red" face="宋体" size="2" style="display:none">用户名或密码错误！</font>
					</div>
					<div style="position:absolute; left:35; top:220;">
						<input type="button" value="" id="btn_login" onclick="submitForm()"/> 
					</div>
	         </div>
         </form>					
</body>
</html>
