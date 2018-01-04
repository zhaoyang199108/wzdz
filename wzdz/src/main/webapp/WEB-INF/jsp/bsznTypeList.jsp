<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<title>办事指南管理</title>
<link rel="stylesheet" href="<%=basePath%>/view/css/style.css" />
<script type="text/javascript" src="<%=basePath%>/view/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%=basePath%>/view/js/common.js"></script>
<script type="text/javascript">

$(function(){
	$(".admin_lfl").click(function(){
		$(this).addClass("admin_lfls");
	})
	$("#addBsznType").click(function(){
		window.location.href="${pageContext.request.contextPath}/bsznType/toAdd";
	})
})
function deleteMsg(){
	if (!confirm("确认要删除信息？")) {
		window.event.returnValue = false;
		}
	}
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
							<a class="admin_lfl" href="#" id="xxManager">限行管理</a>
							<div class="clearboth"></div>
						</li>
						<li>
							<div class="admin_lname">办事指南</div>
							<a class="admin_lfl " id="sxList" href="#">事项列表</a>
							<a class="admin_lfl admin_lfls" id="sxlb" href="#">事项类别</a>
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
					事项类别
				</div>
				<div class="wr_box_fgx"></div>
				<div class="wr_box_info">
					<span id="addBsznType">新增</span>
					<div class="msg">
						<input id="msg" name="msg" value="${msg }">
					</div>
				</div>
				<div class="wr_box_main">
					<div class="wr_csmp_lhead">
					
						<div class="bszn_lhead_box2">
							类别
						</div>
						<div class="bszn_lhead_box3">
							子类名称
						</div>
						<div class="bszn_lhead_cz1">
							操作
						</div>
						
					</div>
					<div class="bszn_list">
					
						<div class="bszn_list_boxo">
							<div class="bszn_list_boxo1">
								事项分类
							</div>
							<ul>
							<c:forEach items="${list }" var="list">
								<c:if test="${list.parentId == '1'}">
									<li>
										<div class="bszn_list_box2">${list.name }</div>
										<div class="bszn_list_cz1">
											<a class="csmp_list_czc" href="${pageContext.request.contextPath}/bsznType/toUpdate?id=${list.id }" title="">修改</a>
											<a class="csmp_list_czd" href="${pageContext.request.contextPath}/bsznType/delete?id=${list.id }"  onclick="deleteMsg()">删除</a>
										</div>
									</li>
								</c:if>
								</c:forEach>
							</ul>
						</div>
						
						<div class="bszn_list_boxo">
							<div class="bszn_list_boxo1">
								部门分类
							</div>
							<ul>
							<c:forEach items="${list }" var="list">
								<c:if test="${list.parentId == '2'}">
								<li>
									<div class="bszn_list_box2">${list.name }</div>
									<div class="bszn_list_cz1">
										<a class="csmp_list_czc" href="${pageContext.request.contextPath}/bsznType/toUpdate?id=${list.id }" title="">修改</a>
										<a class="csmp_list_czd" href="${pageContext.request.contextPath}/bsznType/delete?id=${list.id }"  onclick="deleteMsg()">删除</a>
									</div>
								</li>
								</c:if>
								</c:forEach>
							</ul>
						</div>
					</div>
					
				</div>
			</div>
			<div class="clearboth"></div>
		</div>
</body>
</html>