package com.wzdz.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wzdz.entity.Yjfk;
import com.wzdz.service.YjfkService;

@Controller
@RequestMapping("/yjfk")
public class yjfkController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private @Autowired YjfkService yjfkService;
	//private final String path = "E:\\apache-tomcat-7.0.57\\wtpwebapps\\wzdz\\picture\\yjfk\\";
	
	private final String path = "/usr/soft/apache-tomcat-7.0.65/webapps/wzdz/picture/yjfk/";
	@RequestMapping(value = "/yjfk", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> yjfk(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
		Map<String,Object> resMap = new HashMap<String, Object>();
		//  获得第1张图片（根据前台的name名称得到上传的文件）   
        MultipartFile file  =  multipartRequest.getFile("file");//音乐
        String logoName = file.getOriginalFilename();
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String phone = request.getParameter("phone");
//		try {
//			name = new String(name.getBytes("iso-8859-1"),"utf-8");
//			content = new String(content.getBytes("iso-8859-1"),"utf-8");
//			
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        String postfix = file.getContentType().substring(6);
//        System.out.println(postfix);
    
    	byte[] b = new byte[1024*1024];
    	SimpleDateFormat myFmt2=new SimpleDateFormat("yyyyMMddHHmmss");
    	Date date = new Date();
    	String imageName = myFmt2.format(date);
        String logoPath =  imageName +"."+postfix ;
		 try {
				InputStream is = file.getInputStream();
//				byteContent = readStream(is);
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
		 
		 
		Yjfk yjfk = new Yjfk();
		yjfk.setContent(content);
		yjfk.setLogo("http://123.56.190.160:8811/wzdz/picture/yjfk/"+logoPath);
//		yjfk.setLogo(file);
		yjfk.setName(name);
		yjfk.setPhone(phone);
		int count = yjfkService.insertIntoYjfk(yjfk);
		
        if(count > 0){
	        map.put("code","0");
			map.put("message", "留言成功");
			return map;
        }else{
        	map.put("code","1");
			map.put("message", "留言失败");
			return map;
        }
	}
}
