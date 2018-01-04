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
	$("#addBszn").click(function(){
		location.href="${pageContext.request.contextPath}/bszn/toAdd";
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
							<a class="admin_lfl admin_lfls" id="sxList" href="#">事项列表</a>
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
					事项列表
				</div>
				<div class="wr_box_fgx"></div>
				<div class="wr_box_info">
					<span id="addBszn">新增</span>
					<input name="msg">
				</div>
				<div class="wr_box_main">
					<div class="wr_csmp_lhead">
						<div class="bszn_lhead_box4">
							序号
						</div>
						<div class="bszn_lhead_box4">
							所属类别
						</div>
						<div class="bszn_lhead_box4">
							部门名称
						</div>
						<div class="bszn_lhead_box4">
							事项编号
						</div>
						<div class="bszn_lhead_box1">
							事项名称
						</div>
						<div class="bszn_lhead_box4">
							事项性质
						</div>
						<div class="csmp_lhead_cz1">
							操作
						</div>
					</div>
					<ul class="csmp_list">
					<c:choose>
						<c:when test="${bszn!=null }">
							<c:if test="${bszn.list!=null && fn:length(bszn.list)>0}">
								<c:forEach items="${bszn.list}" var="bszn" varStatus="status">
								<li>
									<div class="bszn_list_box3">${status.index + 1}</div>
									<div class="bszn_list_box3">${bszn.typeName }</div>
									<div class="bszn_list_box3">
										<c:if test="${fn:length(bszn.blzt) > 5 }">
											${fn:substring(bszn.blzt, 0, 5) }...
										</c:if>
										<c:if test="${fn:length(bszn.blzt) <= 5 }">
											${bszn.blzt }
										</c:if>
									
									</div>
									<div class="bszn_list_box3">
										<c:if test="${fn:length(bszn.sxbm) > 5 }">
											${fn:substring(bszn.sxbm, 0, 5) }...
										</c:if>
										<c:if test="${fn:length(bszn.sxbm) <= 5 }">
											${bszn.sxbm }
										</c:if>
									</div>
									<div class="bszn_list_box1">
										<c:if test="${fn:length(bszn.sxmc) > 5 }">
											${fn:substring(bszn.sxmc, 0, 5) }...
										</c:if>
										<c:if test="${fn:length(bszn.sxmc) <= 5 }">
											${bszn.sxmc }
										</c:if>
									</div>
									<div class="bszn_list_box3">
										<c:if test="${fn:length(bszn.sxxz) > 5 }">
											${fn:substring(bszn.sxxz, 0, 5) }...
										</c:if>
										<c:if test="${fn:length(bszn.sxxz) <= 5 }">
											${bszn.sxxz }
										</c:if>
									</div>
									<div class="bszn_list_cz1">
										<a class="csmp_list_czc" href="${pageContext.request.contextPath}/bszn/toUpdate?id=${bszn.id }" title="">修改</a>
										<a class="csmp_list_czd" href="${pageContext.request.contextPath}/bszn/delete?id=${bszn.id }"  onclick="deleteMsg()">删除</a>
									</div>
								</li>
								</c:forEach>
							</c:if>
						</c:when>
						<c:otherwise>
							<div class="nullData">暂无数据</div>
						</c:otherwise>
					</c:choose>
					
					</ul>
					<c:if test="${bszn!=null }">
					<div class="wr_jqgl_pages">
						<div class="jqgl_pages">
							<c:if test="${bszn.thisPage!=1 }">
								<a class="syy" href="${pageContext.request.contextPath}/bszn/findAll?currentPage=${bszn.thisPage-1 }&&pageSize=10" title="">上一页</a>
							</c:if>
							<a class="dny" href="#" title="">第${bszn.thisPage }页</a>
							<a class="dny" href="#" title="">共${bszn.maxPage }页</a>
							<c:if test="${bszn.thisPage != bszn.maxPage }">
								<a class="xyy" href="${pageContext.request.contextPath}/bszn/findAll?currentPage=${bszn.thisPage+1 }&&pageSize=10" title="">下一页</a>
							</c:if>
						</div>
					</div>
					</c:if>
				</div>
			</div>
			<div class="clearboth"></div>
		</div>
</body>
</html>