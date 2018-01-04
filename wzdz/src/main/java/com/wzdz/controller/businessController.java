package com.wzdz.controller;

import java.util.ArrayList;
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

import com.wzdz.dto.BusinessDto;
import com.wzdz.entity.Business;
import com.wzdz.service.BusinessService;
import com.wzdz.service.GywmService;
/*
 * 
 * */
@Controller
@RequestMapping("/business")
public class businessController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private @Autowired BusinessService bussinessService;
	@RequestMapping(value = "/findBussinessByType", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findBusinessByType(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
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
			map.put("code", "1");
			map.put("message", "参数不能为空");
			return map;
		}
		List<Business> list = bussinessService.findBussinessByType(type,Integer.parseInt(currentPage)*Integer.parseInt(pageSize), Integer.parseInt(pageSize));
		
		List<BusinessDto> list_bus = new ArrayList<BusinessDto>();
		for(Business i :list){
			BusinessDto bd = new BusinessDto();
			bd.id = i.getId();
			bd.address = i.getAddress();
			bd.content = i.getContent();
			bd.createDate = i.getCreateDate();
			bd.updateDate = i.getUpdateDate();
			bd.logo = i.getLogo();
			bd.name = i.getName();
			bd.tel = i.getTel();
			bd.type = i.getType();
			bd.url = i.getUrl();
			bd.logoPath = i.getLogoPath();
			String[] j = i.getLogoPath().split(";");
			bd.logo_path = j;
			list_bus.add(bd);
		}
		map.put("code", "0");
		map.put("message", "查询成功");
		map.put("data", list_bus);
		return map;
	}
	@RequestMapping(value = "/findBussinessByRecom", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findBussinessByRecom(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		if(currentPage == null||"".equals(currentPage)){
			currentPage = "0";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "20";
		}
		List<Business> list = bussinessService.findBussinessByRecom(Integer.parseInt(currentPage)*Integer.parseInt(pageSize), Integer.parseInt(pageSize));
		if(list.size() > 0){
			map.put("code", "0");
			map.put("message", "查询成功");
			map.put("data", list);
			return map;
		}else{
			map.put("code", "0");
			map.put("message", "未有推荐商家");
			map.put("data", list);
			return map;
		}
		
	}
}
