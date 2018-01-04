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

import com.wzdz.dto.ChubbyClickCollect;
import com.wzdz.entity.Chubby;
import com.wzdz.service.ChubbyService;
import com.wzdz.service.ClickCollectService;

/**
 * 小胖攻略
 * @author wudi
 *
 */


@Controller
@RequestMapping("/chubby")
public class chubbyController {
	
	@Autowired 
	private ChubbyService chubbyService;
	
	@Autowired
	private ClickCollectService clickCollectService;//点赞收藏
	
	//列表
		@RequestMapping(value = "/chubby", method = RequestMethod.GET)
		@ResponseBody
		public Map<String,Object> chubbyList (HttpServletRequest request,HttpServletResponse response) {
			Map<String,Object> resMap = new HashMap<String, Object>();
			String currentPage = request.getParameter("currentPage");
			String pageSize = request.getParameter("pageSize");
			if(currentPage == null||"".equals(currentPage)){
				currentPage = "0";
			}
			if(pageSize == null||"".equals(pageSize)){
				pageSize = "20";
			}
			List<Chubby> cf = chubbyService.findByAll(Integer.parseInt(currentPage)*Integer.parseInt(pageSize), Integer.parseInt(pageSize));
		
			List<ChubbyClickCollect> cc_list = new ArrayList<ChubbyClickCollect>();
			if(cf.size()>0){
				for(Chubby i:cf){
					ChubbyClickCollect  cc =new ChubbyClickCollect();
					int sClick= clickCollectService.findSumClick(i.getId(),"3");
					int sCollect= clickCollectService.findSumCollect(i.getId(),"3");
					 cc.setIcon(i.getIcon());
				     cc.setLogoPath(i.getLogoPath());
				     cc.setOwner(i.getOwner());
				     cc.setTitle(i.getTitle());
				     cc.setContent(i.getContent());
				     cc.setId(i.getId());
				     cc.setCreateDate(i.getCreateDate());
				     cc.setType("3");
				     cc.setLogo(i.getLogo());
				     cc.setClick(sClick);
				     cc.setCollect(sCollect);
				     cc_list.add(cc);
				}
				resMap.put("code","0");
				resMap.put("message", "查詢成功");
				resMap.put("data", cc_list);
				return resMap;
			}else{
				resMap.put("code", "0");
				resMap.put("data", cc_list);
				resMap.put("message","无数据！");
				return resMap;
			}
		}

		//详情
		@RequestMapping(value = "/chubbyDetail", method = RequestMethod.GET)
		@ResponseBody
		public Map<String,Object> detail (HttpServletRequest request,HttpServletResponse response) {
			Map<String,Object> resMap = new HashMap<String, Object>();
			String id = request.getParameter("id");
			String type = request.getParameter("type");//点赞收藏类型
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
			Chubby  cf = chubbyService.findById(Long.parseLong(id));
			ChubbyClickCollect  cc =new ChubbyClickCollect();
			if(cf!=null || !"".equals(cf)){
				int sClick= clickCollectService.findSumClick(Long.parseLong(id),type);
				int sCollect= clickCollectService.findSumCollect(Long.parseLong(id),type);
				 cc.setLogo(cf.getLogo());
			     cc.setIcon(cf.getIcon());
			     cc.setLogoPath(cf.getLogoPath());
			     cc.setOwner(cf.getOwner());
			     cc.setTitle(cf.getTitle());
			     cc.setContent(cf.getContent());
			     cc.setId(Long.parseLong(id));
			     cc.setCreateDate(cf.getCreateDate());
			     cc.setType(type);
			     cc.setClick(sClick);
			     cc.setCollect(sCollect);
				resMap.put("code","0");
				resMap.put("message", "查詢成功");
				resMap.put("data", cc);
				return resMap;
			}else{
				resMap.put("code", "0");
				resMap.put("data", cc);
				resMap.put("message","无数据！");
				return resMap;
			}
		}
	

}
