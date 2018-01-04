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

import com.wzdz.dto.InformationView;
import com.wzdz.entity.Information;
import com.wzdz.service.InformationService;

/**
 * 资讯管理
 * @author wudi 
 *
 */

@Controller
@RequestMapping("/information")
public class informationController {
	
	@Autowired 
	private InformationService informationService;
	
	//列表
		@RequestMapping(value = "/information", method = RequestMethod.GET)
		@ResponseBody
		public Map<String,Object> informationList (HttpServletRequest request,HttpServletResponse response) {
			Map<String,Object> resMap = new HashMap<String, Object>();
			String type = request.getParameter("type");//资讯类型：1-旅游咨询 2-城市要闻 3-城市热点 4-最新活动
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
			Information Information = new Information();
			Information.setType(type);;
			List<Information> cf = informationService.findByType(type, Integer.parseInt(currentPage)*Integer.parseInt(pageSize), Integer.parseInt(pageSize));
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

	
	
		//详情
				@RequestMapping(value = "/informationDetail", method = RequestMethod.GET)
				@ResponseBody
				public Map<String,Object> informationDetail (HttpServletRequest request,HttpServletResponse response) {
					Map<String,Object> resMap = new HashMap<String, Object>();
					String id = request.getParameter("id");
					if(id == null || "".equals(id)){
						resMap.put("code", "1");
						resMap.put("message","传入id为空！");
						return resMap;
					}
					Information cf = informationService.findById(Long.parseLong(id));
					InformationView i= new InformationView();	
					String path =cf.getLogoPath();
					String[] s= path.split(";");
					if(cf!=null || !"".equals(cf)){
						if(path.contains(";")){
							i.setS(s);
						}else{
							i.setS(s);
						}
						i.content=cf.getContent();
						i.createDate=cf.getCreateDate();
						i.title=cf.getTitle();
						resMap.put("code","0");
						resMap.put("message", "查詢成功");
						resMap.put("data", i);
						return resMap;
					}else{
						resMap.put("code", "0");
						resMap.put("data", i);
						resMap.put("message","无数据！");
						return resMap;
					}
					
				}
	

}
