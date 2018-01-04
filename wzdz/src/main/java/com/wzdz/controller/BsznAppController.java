package com.wzdz.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wzdz.entity.Bszn;
import com.wzdz.entity.BsznType;
import com.wzdz.service.BsznService;
import com.wzdz.service.BsznTypeService;

/**
 * 办事指南
 * 给app端提供的接口
 * @author wangman
 *
 */
@Controller
@RequestMapping("/bsznApp")
public class BsznAppController {
	
	@Autowired 
	private BsznService bsznService;
	@Autowired
	private BsznTypeService bsznTypeService;
	
	@ResponseBody
	@RequestMapping(value="/findById" ,method=RequestMethod.GET)
	public Map<String,Object> findById(HttpServletRequest request){
		Map<String,Object> resMap = new HashMap<String, Object>();
		String code = null;
		String message = null;
		String id = request.getParameter("id");
		if(id == null || "".equals(id)){
			code = "1";
			message="ID不能为空";
		}else{
			Bszn bszn = bsznService.findById(id);
			if(bszn!=null && !"".equals(bszn)){
				code ="0";
				message = "查询成功";
				Map<String,Object> dataMap = new HashMap<String, Object>();
				ArrayList<Object> dataList = new ArrayList<Object>();
				
				final String titleMenu = "办理主体(部门名称),事项编码,事项分类,事项性质,实施层级,行使依据,受理条件,收费依据和标准,"
						+ "法定期限,承诺期限,办理地址,服务表格,在线办理链接,联系电话,监督电话";
				final String dataMenu = bszn.getBlzt()+","+bszn.getSxbm()+","+bszn.getSxfl()+","+bszn.getSxxz()+","+bszn.getSscj()
						+","+bszn.getXsyj()+","+bszn.getSltj()+","+bszn.getSfyj()+","+bszn.getFdqx()+","+bszn.getCnqx()
						+","+bszn.getBldz()+","+bszn.getFwbg()+","+bszn.getZxbl()+","+bszn.getLxdh()+","+bszn.getJddh();
				
				String[] titleArray = titleMenu.split(",");
				String[] dataArray = dataMenu.split(",");
				if(titleArray.length == dataArray.length){
					for(int i =0;i<titleArray.length;i++){
						Map<String,Object> map = new HashMap<String, Object>();
						map.put("title", titleArray[i]);
						map.put("content", dataArray[i]);
						dataList.add(map);
					}
				}
				dataMap.put("title", bszn.getSxmc());
				dataMap.put("list", dataList);
				dataMap.put("typeName", bszn.getTypeName());
				resMap.put("data", dataMap);
			}else{
				code = "1";
				message = "查询失败";
			}
			
		}
		resMap.put("code", code);
		resMap.put("message", message);
		
		return resMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findByType",method = RequestMethod.GET)
	public Map<String,Object> findByType(Bszn bszn,HttpServletRequest request) throws UnsupportedEncodingException{
		String typeId = request.getParameter("type");
		String keyword  = request.getParameter("keyword");
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		
		Map<String,Object> resMap = new HashMap<String, Object>();
		String code = null;
		String message = null;
		
		if(pageNum == null||"".equals(pageNum)){
			pageNum = "1";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "10";
		}
		
		if(keyword != null && !"".equals(keyword)){
			keyword = new String(keyword.getBytes("ISO-8859-1"),"utf-8");
		}
		
		List<Bszn> bsznList= bsznService.findByType(typeId,keyword,(Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize),Integer.valueOf(pageSize));
		if(bsznList.size()>0){
			code = "0";
			message = "查询成功";
			resMap.put("data", bsznList);
		}else{
			code = "0";
			message = "暂无数据";
		}
		
		resMap.put("code", code);
		resMap.put("message", message);
		return resMap;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/findType",method = RequestMethod.GET)
	public Map<String,Object> findType(HttpServletRequest request){
		String parentId = request.getParameter("parentId");
		
		Map<String,Object> resMap = new HashMap<String, Object>();
		String code = null;
		String message = null;
		if(parentId == null || "".equals(parentId)){
			code = "1";
			message = "parentId不能为空";
		}else{
			List<BsznType> bsznTypeList = bsznTypeService.findByParentId(parentId);
			if(bsznTypeList.size()>0){
				code = "0";
				message = "查询成功";
				resMap.put("data", bsznTypeList);
			}else{
				code = "0";
				message = "暂无数据";
			}
		}
		resMap.put("code", code);
		resMap.put("message", message);
		
		return resMap;
	}
}
