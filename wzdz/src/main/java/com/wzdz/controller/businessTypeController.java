package com.wzdz.controller;

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

import com.wzdz.entity.BusinessType;
import com.wzdz.service.BusinessTypeService;

/**
 * 商家类型
 * @author wudi
 *
 */

@Controller
@RequestMapping("/businessType")
public class businessTypeController {
	
	@Autowired 
	private BusinessTypeService businessTypeService;
	
	    //列表
		@RequestMapping(value = "/businessType", method = RequestMethod.GET)
		@ResponseBody
		public Map<String,Object> businessTypeList (HttpServletRequest request,HttpServletResponse response) {
			Map<String,Object> resMap = new HashMap<String, Object>();
			List<BusinessType> cf = businessTypeService.findAll();
			if(cf!=null || !"".equals(cf)){
				resMap.put("code","0");
				resMap.put("message", "查詢成功");
				resMap.put("data", cf);
				return resMap;
			}else{
				resMap.put("code", "0");
				resMap.put("message","无数据！");
				resMap.put("data", cf);
				return resMap;
			}
		}
}
