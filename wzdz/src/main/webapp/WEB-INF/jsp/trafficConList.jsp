<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>限行管理</title>
<link rel="stylesheet" href="<%=basePath%>/view/css/style.css" />
<script type="text/javascript" src="<%=basePath%>/view/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%=basePath%>/view/js/common.js"></script>
<script type="text/javascript">

$(function(){
	$(".admin_lfl").click(function(){
		$(this).addClass("admin_lfls");
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
					
				<div class="wr_box_main">
					<div class="wr_csmp_lhead">
					
						<div class="csmp_lhead_num">
							限行时间
						</div>
						<div class="xxgl_lhead_box2">
							限行区域
						</div>
						<div class="xxgl_lhead_box3">
							限行规则
						</div>
						<div class="xxgl_lhead_box4">
							其他
						</div>
						<div class="csmp_lhead_cz">
							操作
						</div>
					</div>
					<ul class="csmp_list">
					
						<li>
							<div class="csmp_list_num">${trafficon.limitTime }   </div>
							<div class="xxgl_list_box3">
								<c:if test="${fn:length(trafficon.limitScope) > 12 }">
									${fn:substring(trafficon.limitScope, 0, 12) }...
								</c:if>
								<c:if test="${fn:length(trafficon.limitScope) <= 12 }">
									${trafficon.limitScope }
								</c:if>
							</div>
							<div class="xxgl_list_box4">
								<c:if test="${fn:length(trafficon.limitRule) > 10 }">
									${fn:substring(trafficon.limitRule, 0, 10) }...
								</c:if>
								<c:if test="${fn:length(trafficon.limitRule) <= 10 }">
									${trafficon.limitRule }
								</c:if>
							</div>
							<div class="xxgl_list_box5">
								<c:if test="${fn:length(trafficon.other) > 10 }">
									${fn:substring(trafficon.other, 0, 10) }...
								</c:if>
								<c:if test="${fn:length(trafficon.other) <= 10 }">
									${trafficon.other }
								</c:if>
							</div>
							<div class="xxgl_list_cz">
								<a href="${pageContext.request.contextPath}/trafficCon/toUpdate?id=${trafficon.id }" title="">修改</a>
							</div>
						</li>
						
					</ul>
				</div>
			</div>
			<div class="clearboth"></div>
		</div>
</body>
</html>