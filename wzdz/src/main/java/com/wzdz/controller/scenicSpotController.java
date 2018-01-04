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
import com.wzdz.dto.LogoPath;
import com.wzdz.dto.ScenicSpotView;
import com.wzdz.entity.ScenicPic;
import com.wzdz.entity.ScenicSpot;
import com.wzdz.service.ClickCollectService;
import com.wzdz.service.ScenicSpotService;

/**
 * 景区管理
 * @author wudi
 *
 */


@Controller
@RequestMapping("/scenicSpot")
public class scenicSpotController {
	
	@Autowired 
	private ScenicSpotService scenicSpotService;
	

	@Autowired
	private ClickCollectService clickCollectService;//点赞收藏
	
	
	//列表
		@RequestMapping(value = "/scenicSpot", method = RequestMethod.GET)
		@ResponseBody
		public Map<String,Object> scenicSpotList (HttpServletRequest request,HttpServletResponse response) {
			Map<String,Object> resMap = new HashMap<String, Object>();
			String stauts = request.getParameter("stauts");//状态：区分城市和周边景区：1.城市 2.周边
			String currentPage = request.getParameter("currentPage");
			String pageSize = request.getParameter("pageSize");
			if(currentPage == null||"".equals(currentPage)){
				currentPage = "0";
			}
			if(pageSize == null||"".equals(pageSize)){
				pageSize = "20";
			}

			if(stauts == null || "".equals(stauts)){
				resMap.put("code", "1");
				resMap.put("message","传入stauts为空！");
				return resMap;
			}
			ScenicSpot scenicSpot = new ScenicSpot();
			scenicSpot.setStauts(stauts);
			List<ScenicSpot> cf = scenicSpotService.findByType(stauts, Integer.parseInt(currentPage)*Integer.parseInt(pageSize), Integer.parseInt(pageSize));
			if(cf!=null || !"".equals(cf)){
				resMap.put("code","0");
				resMap.put("message", "查詢成功");
				resMap.put("data", cf);
				return resMap;
			}else{
				resMap.put("code", "0");
				resMap.put("message","无数据！");
				return resMap;
			}
		}

		
		
		//详情
				@RequestMapping(value = "/scenicSpotDetail", method = RequestMethod.GET)
				@ResponseBody
				public Map<String,Object> detail (HttpServletRequest request,HttpServletResponse response) {
					Map<String,Object> resMap = new HashMap<String, Object>();
					String id = request.getParameter("id");
					String stauts = request.getParameter("stauts");
					String type = request.getParameter("type");//点赞收藏类型
					if(id == null || "".equals(id)){
						resMap.put("code", "1");
						resMap.put("message","传入id为空！");
						return resMap;
					}
					if(stauts == null || "".equals(stauts)){
						resMap.put("code", "1");
						resMap.put("message","传入stauts为空！");
						return resMap;
					}
					if(type == null || "".equals(type)){
						resMap.put("code", "1");
						resMap.put("message","传入type为空！");
						return resMap;
					}
					ScenicSpot  cf = scenicSpotService.findByIdAndType(Long.parseLong(id),stauts);
					
					List<String> pList = new  ArrayList<String>();
					List<LogoPath> list_logo = new ArrayList<LogoPath>();
					
					ScenicSpotView ScenicSpot = new ScenicSpotView();
					if(cf!=null || !"".equals(cf)){
//						String p =cf.getLogoPath();
//						if(p.contains("p")){
//							String[]  pplist = p.split(";");
//							for(String i : pplist){
//								ccv.logoPath=pplist[0];
//								pList.add(ccv);
//							}
//						}else{
//							ccv.logoPath=p;
//							pList.add(ccv);
//						}
						List<ScenicPic> SList = scenicSpotService.findPicBySSId(Long.parseLong(id));
						for(ScenicPic i : SList){
							pList.add(i.getFileDir());
						}
						for(String i : pList){
							LogoPath ccv = new LogoPath();
							
							ccv.setLogoPath(i);
							list_logo.add(ccv);
						}
						ScenicSpot.content=cf.getContent();
						ScenicSpot.jqAddres=cf.getJqAddres();
						ScenicSpot.jqMoney=cf.getJqMoney();
						ScenicSpot.jqName=cf.getJqName();
						ScenicSpot.jqTel=cf.getJqTel();
						ScenicSpot.logoPath=list_logo;
						ScenicSpot.introduction = cf.getIntroduction();
						int sClick= clickCollectService.findSumClick(Long.parseLong(id),type);
						int sCollect= clickCollectService.findSumCollect(Long.parseLong(id),type);
						ScenicSpot.type=type;
						ScenicSpot.click=sClick;
						ScenicSpot.collect=sCollect;
						resMap.put("code","0");
						resMap.put("message", "查詢成功");
						resMap.put("data", ScenicSpot);
						return resMap;
					}else{
						resMap.put("code", "0");
						resMap.put("message","无数据！");
						return resMap;
					}
				}
		
		
}
