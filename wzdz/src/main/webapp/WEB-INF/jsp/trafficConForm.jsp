<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>限行修改</title>
<link rel="stylesheet" href="<%=basePath%>/view/css/style.css" />
<script type="text/javascript" src="<%=basePath%>/view/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%=basePath%>/view/js/common.js"></script>
<script type="text/javascript">
$(function(){
	$(".admin_lfl").click(function(){
		$(this).addClass("admin_lfls");
	})
	
	$(".csmp_xg_b4").find(".csmp_xg_btn").first().click(function(){
		$("#form").submit();
		
	})
})
</script>
</head>
<body>
<div class="wrapper">
			<div class="wrap_left">
				<div class="wrap_ltop">MENU</div>
				<div class="wrap_leftb">
					<div class="wrap_lbox_1">系统主页</div>
					<ul class="admin_list">
						<li>
							<div class="admin_lname">限行管理</div>
							<a class="admin_lfl admin_lfls" id="xxManager" href="#">限行管理</a>
							<div class="clearboth"></div>
						</li>
						<li>
							<div class="admin_lname">办事指南</div>
							<a class="admin_lfl " id="sxList" href="#">事项列表</a>
							<a class="admin_lfl" id="sxlb" href="#">事项类别</a>
							<div class="clearboth"></div>
						</li>
					</ul>
					<div class="clearboth"></div>
				</div>
			</div>
			<div class="wrap_right">
				<div class="wrap_rtop">
					<img class="wrap_rtlogo" src="<%=basePath%>/view/images/login_logo.png" />
					<div class="wrap_rtpho">
						<div class="rt_photo">
							<img src="<%=basePath%>/view/images/gr_pho.jpg" />
						</div>
						<span class="rt_phoName"></span>
						<a class="rt_phoLo" href="javascript:;" title="">退出</a>
					</div>
				</div>
				<div class="wr_box_tit">
					限行管理
				</div>
				<div class="wr_box_fgx"></div>
				<div class="csmp_xg_form">
				<form:form id="form" modelAttribute="trafficCon" action="${pageContext.request.contextPath}/trafficCon/update" method="post">
				<form:hidden path="id"/>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							限行时间
						</div>
						<form:input path="limitTime" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b2">
						<div class="csmp_xg_bname">
							限行区域
						</div>
						<form:textarea path="limitScope" class="csmp_xg_ta1"/>
					</div>
					<div class="csmp_xg_b2">
						<div class="csmp_xg_bname">
							限行规则
						</div>
						<form:textarea path="limitRule" class="csmp_xg_ta1"/>
					</div>
					<div class="csmp_xg_b2">
						<div class="csmp_xg_bname">
							其他
						</div>
						<form:textarea path="other" class="csmp_xg_ta1"/>
					</div>
					
					<div class="csmp_xg_b4">
						<div class="csmp_xg_btn">确定</div>
						<div class="csmp_xg_btn" onclick="history.go(-1)">取消</div>
					</div>
					</form:form>
				</div>
				
				
			</div>
			<div class="clearboth"></div>
		</div>
</body>
</html>