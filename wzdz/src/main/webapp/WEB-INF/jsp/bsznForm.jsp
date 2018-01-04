<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
					事项列表-${not empty bszn.id?'修改':'添加'}
				</div>
				<div class="wr_box_fgx"></div>
				<div class="csmp_xg_form">
				<form:form id="form" modelAttribute="bszn" action="${pageContext.request.contextPath}/bszn/update" method="post">
					<form:hidden path="id"/>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							所属类别
						</div>
						<form:select path="type" >
							<option disabled>事项分类</option>
							<c:forEach items="${bsznType }" var="bsznType">
							<c:if test="${bsznType.parentId ==1 }">
								<c:choose>
									<c:when test="${bsznType.id == bszn.type}">
										<option value="${bsznType.id }" selected>${bsznType.name }</option>
									</c:when>
									<c:otherwise>
										<option value="${bsznType.id }">${bsznType.name }</option>
									</c:otherwise>
								</c:choose>
								</c:if>
							</c:forEach>
							<option disabled>部门分类</option>
							<c:forEach items="${bsznType }" var="bsznType2">
							<c:if test="${bsznType2.parentId ==2 }">
								<c:choose>
									<c:when test="${bsznType2.id == bszn.type}">
										<option value="${bsznType2.id }" selected>${bsznType2.name }</option>
									</c:when>
									<c:otherwise>
										<option value="${bsznType2.id }">${bsznType2.name }</option>
									</c:otherwise>
								</c:choose>
								</c:if>
							</c:forEach>
						</form:select>
					</div>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							事项编码
						</div>
						<form:input path="sxbm" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							事项分类
						</div>
						<form:input path="sxfl" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							事项名称
						</div>
						<form:input path="sxmc" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							事项性质
						</div>
						<form:input path="sxxz" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							实施层级
						</div>
						<form:input path="sscj" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b2">
						<div class="csmp_xg_bname">
							行使依据
						</div>
						<form:textarea path="xsyj" class="csmp_xg_ta1"/>
					</div>
					<div class="csmp_xg_b5">
						<div class="csmp_xg_bname">
							办理主体（部门名称）
						</div>
						<form:input path="blzt" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b2">
						<div class="csmp_xg_bname">
							受理条件
						</div>
						<form:textarea path="sltj" class="csmp_xg_ta1"/>
					</div>
					<div class="csmp_xg_b5">
						<div class="csmp_xg_bname">
							收费依据和标准
						</div>
						<form:input path="sfyj" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							法定期限
						</div>
						<form:input path="fdqx" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							承诺期限
						</div>
						<form:input path="cnqx" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							办理地址
						</div>
						<form:input path="bldz" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							联系电话
						</div>
						<form:input path="lxdh" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							服务表格
						</div>
						<form:input path="fwbg"   class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b1">
						<div class="csmp_xg_bname">
							监督电话
						</div>
						<form:input path="jddh" class="csmp_xg_input1"/>
					</div>
					<div class="csmp_xg_b5">
						<div class="csmp_xg_bname">
							在线办理链接
						</div>
						<form:input path="zxbl" class="csmp_xg_input1"/>
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