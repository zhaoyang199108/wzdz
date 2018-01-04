<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>后台登陆</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/view/css/style.css">
		<script type="text/javascript" src="<%=basePath%>/view/js/jquery-1.9.1.js"></script>
		<style>
			.errorMsg{
				float: left;
				font-size: 16px;
				color: #EB0303;
				line-height: 25px;
				margin: 15px 50px 0 0;
				display:none;
			}
		</style>
		<script type="text/javascript">
		$(function(){
			$(".login_btn").click(function(){
				console.log("dfdf");
				$.ajax({
					url:'${pageContext.request.contextPath}/user/userLogin?loginId='+$('#loginId').val()+'&&psw='+$("#psw").val(),
					type:'get',
					dataType: "json",
					success:function(data){
						console.log(data)
						if(data.code==1){
							$(".errorMsg").html(data.message);
							$(".errorMsg").show();
						}else if(data.code==0){
							localStorage.setItem("userName",data.data.userName);
							localStorage.setItem("userPicture",data.data.userPicture);
							window.location.href="${pageContext.request.contextPath}/trafficCon/findAll"
						}
					}
				})
			})
			//按下enter执行事件
			$(document).keydown(function(event){
				if(event.keyCode==13){
				$(".login_btn").click();
				}
				}); 
		})
			
		</script>
	</head>
	<body>
		<div class="login_wrap">
			<div class="login__bg1"></div>
			<div class="login__bg2"></div>
			<div class="login_box">
				<img class="login_logo" src="view/images/login_logo.png" />
				<form id="loginform" action="/user/userLogin">
					<div class="login_blank">
						<div class="login_blanki">
							<div class="login_blanki_1">
								<label>管理员：</label>
								<input type="text" value="" id="loginId" name="loginId" />
							</div>
							<div class="login_blanki_1">
								<label>密码：</label>
								<input type="password" value="" id="psw" name="psw" />
							</div>
						</div>
						<input class="login_btn" type="button" value="" />
					</div>
					<span class="errorMsg"></span>
					<span class="login_wj">忘记密码请联系管理员>></span>
				</form>
			</div>
		</div>
	</body>
</html>
