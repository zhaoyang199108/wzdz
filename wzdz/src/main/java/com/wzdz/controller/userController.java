package com.wzdz.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wzdz.dto.NoticeDto;
import com.wzdz.entity.Gywm;
import com.wzdz.entity.Notice;
import com.wzdz.entity.NoticeUser;
import com.wzdz.entity.User;
import com.wzdz.service.GywmService;
import com.wzdz.service.NoticeService;
import com.wzdz.service.UserService;
import com.wzdz.util.MD5Util;
import com.wzdz.util.SendMessageUtil;


@Controller
@RequestMapping("/user")
public class userController {
	private @Autowired UserService userService;
	private @Autowired NoticeService noticeService;
	private @Autowired GywmService gywmService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//	private final String path = "E:\\apache-tomcat-7.0.57\\wtpwebapps\\wzdz\\picture\\headpicture\\";
//	private final String fkPath = "E:\\apache-tomcat-7.0.57\\wtpwebapps\\wzdz\\picture\\yjfk\\";
	private final String path = "/usr/soft/apache-tomcat-7.0.65/webapps/wzdz/picture/headpicture/";
	private final String fkPath = "/usr/soft/apache-tomcat-7.0.65/webapps/wzdz/picture/yjfk/";
	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> currentUser(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> resMap = new HashMap<String, Object>();
		String loginId = request.getParameter("loginId");
		String psw = request.getParameter("psw");
		String newPwdMd5 = MD5Util.getStringMD5(psw);
		User user = userService.findUserByUserName(loginId);
		if(user == null){
			resMap.put("code", 1);
			resMap.put("message", "登陆用户名不存在");
			resMap.put("data", null);
			return resMap;
		}
		System.out.println(psw);
		System.out.print(newPwdMd5);
		if(user.getPassword().equals(newPwdMd5)){
			resMap.put("code", "0");
			resMap.put("message", "登陆成功");
			resMap.put("data", user);
			return resMap;
		}else{
			resMap.put("code", "1");
			resMap.put("message", "密码不正确");
			resMap.put("data", null);
			return resMap;
		}
	}
	@RequestMapping(value = "/obtainMessage", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object>  obtainMessage(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		String mobile = request.getParameter("mobile");
		if(mobile == null || "".equals(mobile)){
			map.put("code", 1);//0成功1失败
			map.put("message", "手机号为空");
			return map;
		}
		SendMessageUtil smu = new SendMessageUtil();
		String reback = smu.sendMessage(mobile);
		if(reback.contains("200")){
			map.put("code", 0);//0成功1失败
			map.put("message", "短信发送成功");
			return map;
		}else{
			map.put("code",1);//0成功1失败
			map.put("message", "短信发送失败");
			return map;
		}
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> register(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		
		String mobile = request.getParameter("mobile");
		String code = request.getParameter("code");
		String psw = request.getParameter("psw");
		String newPwdMd5 = MD5Util.getStringMD5(psw);
		SendMessageUtil smu = new SendMessageUtil();
		String reback = smu.volidateMessage(mobile, code);
		if(reback.contains("200")){
			User user = new User();
			user.setPhoneNo(mobile);
			user.setPassword(newPwdMd5);
			user.setCreateDate(new Date());
			user.setUpdateDate(new Date());
			User user_find = userService.findUserByUserName(mobile);
			if(user_find != null){
				map.put("code", "1");
				map.put("message", "该用户已注册");
				return map;
			}
			int count = userService.insertUser(user);
			if(count > 0){
				map.put("code", "0");
				map.put("message", "注册成功");
				return map;
			}else{
				map.put("code", "1");
				map.put("message", "注册失败");
				return map;
			}
		}else{
			map.put("code", 1);
			map.put("message", "验证码错误");
			return map;
		}
	}
	@RequestMapping(value = "/findUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findUser(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		
		String mobile = request.getParameter("mobile");
		if(mobile == null || "".equals(mobile)){
			map.put("code", 1);//0成功1失败
			map.put("message", "手机号为空");
			return map;
		}
		User user_find = userService.findUserByUserName(mobile);
		if(user_find == null){
			map.put("code", 0);//0成功1失败
			map.put("message", "不存在该用户信息");
			return map;
		}
		map.put("code", "0");
		map.put("message", "查询成功");
		map.put("data", user_find);
		return map;
	}
	@RequestMapping(value = "/uploadHeadPicture", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> uploadHeadPicture(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
		Map<String,Object> resMap = new HashMap<String, Object>();
		//  获得第1张图片（根据前台的name名称得到上传的文件）   
        MultipartFile file  =  multipartRequest.getFile("file");//音乐
        String mobile = request.getParameter("mobile");
        System.out.println(mobile);
        String postfix = file.getContentType().substring(6);
        System.out.println(postfix);
    	byte[] b = new byte[1024*1024];
    	SimpleDateFormat myFmt2=new SimpleDateFormat("yyyyMMddHHmmss");
    	Date date = new Date();
    	String imageName = myFmt2.format(date);
        try {
			InputStream is = file.getInputStream();
			 File fileDir = new File(path);
			  //判断文件夹是否存在,如果不存在则创建文件夹
			  if (!fileDir.exists()) {
				  fileDir.mkdir();
			  }
			FileOutputStream fos = new FileOutputStream(path + imageName +"."+postfix );

			while((is.read(b)) != -1){
			fos.write(b);
			}
			is.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        String picturePath = "http://123.56.190.160:8811/wzdz/picture/headpicture/" + imageName +"."+postfix;
        int count = userService.updateUserSetUserPicture(picturePath,mobile);
        if(count > 0){
	        map.put("code","0");
			map.put("message", "上传成功");
			map.put("url", "http://123.56.190.160:8811/wzdz/picture/headpicture/"+imageName+"."+postfix);
			return map;
        }else{
        	map.put("code","1");
			map.put("message", "上传失败");
			return map;
        }
        
	}
	@RequestMapping(value = "/modifyPassword", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> modifyPassword(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object>  map = new HashMap<String, Object>();
		String mobile = request.getParameter("mobile");
		String oPsw = request.getParameter("oPsw");
		String nPsw = request.getParameter("nPsw");
		String oPwdMd5 = MD5Util.getStringMD5(oPsw);
		String nPwdMd5 = MD5Util.getStringMD5(nPsw);
		User user_find = userService.findUserByUserName(mobile);
		if(user_find == null || "".equals(user_find)){
			map.put("code","0");
			map.put("message", "未查询到该用户");
			return map;
		}
		String user_opsw = user_find.getPassword();
		if(user_opsw.equals(oPwdMd5)){
			int count = userService.modifyPassword(mobile,nPwdMd5);
			if(count > 0){
				map.put("code","0");
				map.put("message", "修改成功");
				return map;
			}else{
				map.put("code","1");
				map.put("message", "修改失败");
				return map;
			}
		}else{
			map.put("code","1");
			map.put("message", "原密码输入错误");
			return map;
		}
	}
	@RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> modifyUser(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		String nickname = request.getParameter("nickname");
		String name  = request.getParameter("name");
		String sex  = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
	
		if(nickname == null){
			map.put("code","1");
			map.put("message", "昵称不能为null");
			return map;
		}
		if(name == null){
			map.put("code","1");
			map.put("message", "姓名不能为null");
			return map;
		}
		if(sex == null){
			map.put("code","1");
			map.put("message", "性别不能为null");
			return map;
		}
		if(birth == null){
			map.put("code","1");
			map.put("message", "出生日期不能为null");
			return map;
		}
		if(address == null){
			map.put("code","1");
			map.put("message", "地址不能为null");
			return map;
		}
		if(mobile == null && "".equals(mobile)){
			map.put("code","1");
			map.put("message", "手机不能为空");
			return map;
		}
		try {
			nickname = new String(nickname.getBytes("iso-8859-1"),"utf-8");
			name = new String(name.getBytes("iso-8859-1"),"utf-8");
			address = new String(address.getBytes("iso-8859-1"),"utf-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user_find = userService.findUserByUserName(mobile);
		if(user_find == null || "".equals(user_find)){
			map.put("code","0");
			map.put("message", "未查询到用户");
			return map;
		}
		User user = new User();
		user.setBirthday(birth);
		user.setGender(sex);
		user.setNickname(nickname);
		user.setLocation(address);
		user.setUserName(name);
		user.setPhoneNo(mobile);
		int count = userService.updateUser(user);
		if(count > 0){
			map.put("code","0");
			map.put("message", "修改成功");
			return map;
		}else{
			map.put("code","1");
			map.put("message", "修改失败");
			return map;
		}
	}
	@RequestMapping(value = "/modifyMobile", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> modifyMobile(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		String mobile = request.getParameter("mobile");
		String code = request.getParameter("code");
		String oMobile = request.getParameter("oMobile");
		SendMessageUtil smu = new SendMessageUtil();
		String reback = smu.volidateMessage(mobile, code);
		if(reback.contains("200")){
			User user_find = userService.findUserByUserName(mobile);
			if(user_find != null){
				map.put("code", "2");
				map.put("message", "该手机已经注册过");
				return map;
			}
			int count = userService.modifyMobile(mobile,oMobile);
			if(count > 0){
				map.put("code", "0");
				map.put("message", "修改成功");
				return map;
			}else{
				map.put("code", "1");
				map.put("message", "修改失败");
				return map;
			}
		}else{
			map.put("code", 1);
			map.put("message", "验证码错误");
			return map;
		}
	}
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> forgetPassword(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		String mobile = request.getParameter("mobile");
		String code = request.getParameter("code");
		String nPsw = request.getParameter("nPsw");
		User user_find = userService.findUserByUserName(mobile);
		if(user_find == null || "".equals(user_find)){
			map.put("code","0");
			map.put("message", "未查询到该用户");
			return map;
		}
		if(mobile == null || "".equals(mobile)){
			map.put("code","1");
			map.put("message", "手机号不能为空");
			return map;
		}
		if(code == null || "".equals(code)){
			map.put("code","1");
			map.put("message", "code不能为空");
			return map;
		}
		if(nPsw == null || "".equals(nPsw)){
			map.put("code","1");
			map.put("message", "新密码不能为空");
			return map;
		}
		String nPwdMd5 = MD5Util.getStringMD5(nPsw);
		SendMessageUtil smu = new SendMessageUtil();
		String reback = smu.volidateMessage(mobile, code);
		if(reback.contains("200")){

			int count = userService.forgetPassword(mobile,nPwdMd5);
			if(count > 0){
				map.put("code", "0");
				map.put("message", "修改成功");
				return map;
			}else{
				map.put("code", "1");
				map.put("message", "修改失败");
				return map;
			}
		}else{
			map.put("code", 1);
			map.put("message", "验证码错误");
			return map;
		}
	}
	@RequestMapping(value = "/getNotice", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getNotice(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		String mobile = request.getParameter("mobile");
		String type = request.getParameter("type");
		if(type == null || "".equals(type)){
			map.put("code", "1");
			map.put("message", "类型不能为空");
			return map;
		}
		if(mobile == null || "".equals(mobile)){
			map.put("code", "1");
			map.put("message", "手机号不能为空");
			return map;
		}
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		if(currentPage == null||"".equals(currentPage)){
			currentPage = "0";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "20";
		}
		List<NoticeDto> notice_list = noticeService.findNoticeByType(type,Integer.parseInt(currentPage)*Integer.parseInt(pageSize),Integer.parseInt(pageSize),mobile);
		for(NoticeDto i: notice_list){
			NoticeUser noticeUser = noticeService.findNoticeByMobile(mobile, i.getId());
			if(noticeUser == null){
				i.setIsread("0");
			}else{
				i.setIsread(noticeUser.getIsread());
			}
			String icon = i.getLogoPath();
			String[] iconList = icon.split(";");
			i.setIcon(iconList);
		}
		if(notice_list.size()>0){
			map.put("code", "0");
			map.put("message", "查询成功");
			map.put("data", notice_list);
			return map;
		}else{
			map.put("code", "0");
			map.put("message", "未查询到数据");
			map.put("data", notice_list);
			return map;
		}
	}
	@RequestMapping(value = "/readNoticeByIdAndMobile", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> readNoticeByIdAndMobile(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		//String type = request.getParameter("type");
		String mobile = request.getParameter("mobile");
		String id = request.getParameter("id");
//		if(type == null || "".equals(type)){
//			map.put("code", "1");
//			map.put("message", "类型不能为空");
//			return map;
//		}
		if(mobile == null || "".equals(mobile)){
			map.put("code", "1");
			map.put("message", "手机不能为空");
			return map;
		}
		if(id == null || "".equals(id)){
			map.put("code", "1");
			map.put("message", "消息id不能为空");
			return map;
		}
		NoticeUser noticeUser = noticeService.findNoticeByMobile(mobile,Long.parseLong(id));
		if(noticeUser != null){
			map.put("code", "0");
			map.put("message", "已查看");
			return map;
		}
		int count = noticeService.readNoticeByIdAndMobile(mobile,Long.parseLong(id));
		if(count > 0){
			map.put("code", "0");
			map.put("message", "标记成功");
			return map;
		}else{
			map.put("code", "0");
			map.put("message", "未标记");
			return map;
		}
	}
	@RequestMapping(value = "/findGywm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findGywm(HttpServletRequest request,HttpServletResponse response) {
		 Map<String,Object>  map = new HashMap<String, Object>();
		 Gywm gywm = gywmService.findGywm();
		 if(gywm == null){
			 map.put("code", "0");
			 map.put("message", "未查询到数据");
			 return map;
		 }
		 map.put("code", "0");
		 map.put("message", "查询成功");
		 map.put("data", gywm);
		 return map;
	}
}
