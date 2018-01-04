$(function(){
	
	//获取主机地址之后的目录
	var pathName=window.document.location.pathname;
	 //获取带"/"的项目名
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
	
	var userName = localStorage.getItem("userName");
	var userPicture = localStorage.getItem("userPicture");
	$(".rt_phoName").html(userName);
	$(".rt_photo").html(userPicture);
	
	$(".rt_phoLo").click(function(){
		localStorage.clear();
		window.location.href=projectName+"/login.jsp"
	})
	
	$("#xxManager").attr("href",projectName+"/trafficCon/findAll");
	$("#sxlb").attr("href",projectName+"/bsznType/findAllType");
	$("#sxList").attr("href",projectName+"/bszn/findAll?currentPage=1&&pageSize=10");
	

})
