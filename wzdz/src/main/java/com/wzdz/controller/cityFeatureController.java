package com.wzdz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wzdz.dto.CityFeatureV;
import com.wzdz.dto.LogoPath;
import com.wzdz.entity.CityFeature;
import com.wzdz.service.CityFeatureService;

/**
 * 城市特色
 * @author wudi
 *
 */

@Controller
@RequestMapping("/cityFeature")
public class cityFeatureController {
	
	@Autowired 
	private CityFeatureService cityFeatureService;
	
	
	//列表
	@RequestMapping(value = "/cityFeature", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> cityFeature (HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> resMap = new HashMap<String, Object>();
		String type = request.getParameter("type");
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		if(currentPage == null||"".equals(currentPage)){
			currentPage = "0";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "20";
		}

		if(type == null || "".equals(type)){
			resMap.put("code", "1");
			resMap.put("message","传入type为空！");
			return resMap;
		}
		CityFeature cityFeature = new CityFeature();
		cityFeature.setType(type);
		List<CityFeature> cf = cityFeatureService.findByIdAndType(type, Integer.parseInt(currentPage)*Integer.parseInt(pageSize),Integer.parseInt(pageSize) );
		if(cf!=null || !"".equals(cf)){
			resMap.put("code","0");
			resMap.put("message", "查詢成功");
			resMap.put("data", cf);
			return resMap;
		}else{
			resMap.put("code", "0");
			resMap.put("data", cf);
			resMap.put("message","无数据！");
			return resMap;
		}
	}
	
	//详情
	@RequestMapping(value = "/cityFeatureDetail", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> detail (HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> resMap = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		if(id == null || "".equals(id)){
			resMap.put("code", "1");
			resMap.put("message","传入id为空！");
			return resMap;
		}
		if(type == null || "".equals(type)){
			resMap.put("code", "1");
			resMap.put("message","传入type为空！");
			return resMap;
		}
		CityFeature  cf = cityFeatureService.findById(Long.parseLong(id),type);
		List<LogoPath> pList = new  ArrayList<LogoPath>();
		LogoPath ccv = new LogoPath();
		CityFeatureV ScenicSpot = new CityFeatureV();
		if(cf!=null || !"".equals(cf)){
			String p =cf.getLogoPath();
//			
//			if(p.contains(";")){
//				String[]  pplist = p.split(";");
//				for(String i : pplist){
//					ccv.logoPath=i;
//					pList.add(ccv);
//				}
//			}else{
//				ccv.logoPath=p;
//				pList.add(ccv);
//			}
			String[] logo_path = p.split(";");
			for(String i : logo_path){
				LogoPath lp = new LogoPath();
				lp.logoPath = i;
				pList.add(lp);
			}
			ScenicSpot.content=cf.getContent();
			ScenicSpot.title=cf.getTitle();
			ScenicSpot.logoPath=pList;
			ScenicSpot.introduction = cf.getIntroduction();
			resMap.put("code","0");
			resMap.put("message", "查詢成功");
			resMap.put("data", ScenicSpot);
			return resMap;
		}else{
			resMap.put("code", "0");
			resMap.put("data", ScenicSpot);
			resMap.put("message","无数据！");
			return resMap;
		}
	}


}
