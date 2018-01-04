package com.wzdz.controller;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

import com.wzdz.dto.BusinessAndType;
import com.wzdz.dto.IndexView;
import com.wzdz.entity.Adver;
import com.wzdz.entity.Business;
import com.wzdz.entity.BusinessType;
import com.wzdz.entity.Information;
import com.wzdz.service.AdverService;
import com.wzdz.service.BusinessService;
import com.wzdz.service.BusinessTypeService;
import com.wzdz.service.InformationService;

/**
 * 广告管理
 * @author wudi
 *
 */


@Controller
@RequestMapping("/adver")
public class adverController {
	
	@Autowired 
	private AdverService adverService;//广告
	
	@Autowired 
	private InformationService informationService;//资讯管理
	
	@Autowired 
	private BusinessService bussinessService;//商家
	
	@Autowired 
	private BusinessTypeService businessTypeService;//商家类型
	
	//列表
			@RequestMapping(value = "/adver", method = RequestMethod.GET)
			@ResponseBody
			public Map<String,Object> adverList (HttpServletRequest request,HttpServletResponse response) {
				Map<String,Object> resMap = new HashMap<String, Object>();
				List<Adver> cf = adverService.findByAll();
				IndexView index= new IndexView();
				List<Information> info = informationService.findByAll();
				List<BusinessType> businessType = businessTypeService.findAll();
				List<BusinessAndType> bu = new ArrayList<BusinessAndType>();
				for(BusinessType i:businessType){
					BusinessAndType businessAndType = new BusinessAndType();
					List<Business> business = bussinessService.findByType(i.getId());
					businessAndType.id=i.getId();
					businessAndType.name=i.getName();
					businessAndType.business=business;
					bu.add(businessAndType);
				}
//				Comparator<Object> cmp = Collator.getInstance(java.util.Locale.CHINA);
//			    Collections.sort(bu, cmp);
				if(cf!=null || !"".equals(cf)){
					resMap.put("code","0");
					resMap.put("data", cf);
					resMap.put("message", "查詢成功");
				}else{
					resMap.put("code", "0");
					resMap.put("data", cf);
					resMap.put("message","无数据！");
				}
				
				if(info!=null || !"".equals(info)){
					resMap.put("code","0");
					resMap.put("data", info);
					resMap.put("message", "查詢成功");
				}else{
					resMap.put("code", "0");
					resMap.put("message","无数据！");
				}
				
				index.adver=cf;
				index.information=info;
				index.business=bu;
				resMap.put("message", "查询成功");
				resMap.put("data", index);
				resMap.put("code", "0");
				return resMap;
			}

	
	
	
	

}
