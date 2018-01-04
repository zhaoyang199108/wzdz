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

import com.mysql.fabric.xmlrpc.base.Array;
import com.wzdz.entity.Chubby;
import com.wzdz.entity.ClickCollect;
import com.wzdz.entity.ScenicSpot;
import com.wzdz.service.ChubbyService;
import com.wzdz.service.ClickCollectService;
import com.wzdz.service.ScenicSpotService;

/**
 * 点赞收藏
 * @author wudi
 *
 */
@Controller
@RequestMapping("/clickCollect")
public class ClickCollectController {
	
	@Autowired
	private ClickCollectService clickCollectService;
	@Autowired
	private ScenicSpotService scenicSpotService;
	@Autowired 
	private ChubbyService chubbyService;
	
	   //点赞列表
			@RequestMapping(value = "/click", method = RequestMethod.GET)
			@ResponseBody
			public Map<String,Object> clickList (HttpServletRequest request,HttpServletResponse response) {
				Map<String,Object> resMap = new HashMap<String, Object>();
				String loginId = request.getParameter("loginId");
				String typeId = request.getParameter("typeId");
				String type = request.getParameter("type");//点赞类型：1.1.城市景点 2.周边景点 3.旅游攻略（小胖攻略）
			
				if(loginId == null || "".equals(loginId)){
					resMap.put("code", "1");
					resMap.put("message","传入loginId为空！");
					return resMap;
				}
				if(typeId == null || "".equals(typeId)){
					resMap.put("code", "1");
					resMap.put("message","传入id为空！");
					return resMap;
				}
				if(type == null || "".equals(type)){
					resMap.put("code", "1");
					resMap.put("message","传入type为空！");
					return resMap;
				}
				ClickCollect cc =	clickCollectService.findClick(loginId,Long.parseLong(typeId),type);
				if(cc ==null){
					ClickCollect c = new ClickCollect();
					c.setLoginId(loginId);
					c.setType(type);
					c.setTypeId(typeId);
					int count =  clickCollectService.insertIntoClick(c);
					if(count>0){
						resMap.put("code", "0");
						resMap.put("message", "点赞成功!");
						return resMap;
					}else{
						resMap.put("code", "1");
						resMap.put("message", "操作失败！");
						return resMap;
					}
				}else{
					resMap.put("code","1");
			    	resMap.put("message", "已点赞!");
			    	return resMap;
			     }
			}

			 //收藏列表
			@RequestMapping(value = "/Collect", method = RequestMethod.GET)
			@ResponseBody
			public Map<String,Object> CollectList (HttpServletRequest request,HttpServletResponse response) {
				Map<String,Object> resMap = new HashMap<String, Object>();
				String loginId = request.getParameter("loginId");
				String typeId = request.getParameter("typeId");
				String type = request.getParameter("type");//点赞类型：1.1.城市景点 2.周边景点 3.旅游攻略（小胖攻略）
				
				if(loginId == null || "".equals(loginId)){
					resMap.put("code", "1");
					resMap.put("message","传入loginId为空！");
					return resMap;
				}
				if(typeId == null || "".equals(typeId)){
					resMap.put("code", "1");
					resMap.put("message","传入id为空！");
					return resMap;
				}
				if(type == null || "".equals(type)){
					resMap.put("code", "1");
					resMap.put("message","传入type为空！");
					return resMap;
				}
				ClickCollect cc =	clickCollectService.findCollect(loginId,Long.parseLong(typeId),type);
				if(cc ==null){
					ClickCollect c = new ClickCollect();
					c.setLoginId(loginId);
					c.setType(type);
					c.setTypeId(typeId);
					int count =  clickCollectService.insertIntoCollect(c);
					if(count>0){
						resMap.put("code", "0");
						resMap.put("message", "收藏成功!");
						return resMap;
					}else{
						resMap.put("code", "1");
						resMap.put("message", "操作失败！");
						return resMap;
					}
				}else{
					resMap.put("code","1");
			    	resMap.put("message", "已收藏!");
			    	return resMap;
			     }
			}
			//收藏列表
			@RequestMapping(value = "/collectList", method = RequestMethod.GET)
			@ResponseBody
			public Map<String,Object> collectList (HttpServletRequest request,HttpServletResponse response) {
				Map<String,Object> map = new HashMap<String, Object>();
				String type = request.getParameter("type");
				String mobile = request.getParameter("mobile");
				String currentPage = request.getParameter ("currentPage");
				String pageSize = request.getParameter("pageSize");
				if(type == null || "".equals(type)){
					map.put("code", "1");
					map.put("message", "类别不能为空");
					return map;
				}
				if(currentPage == null||"".equals(currentPage)){
					currentPage = "0";
				}
				if(pageSize == null||"".equals(pageSize)){
					pageSize = "20";
				}
				if(type.equals("1")){
					List<ClickCollect> clickCollectList1 = clickCollectService.findCollectList(mobile, "1",Integer.parseInt(currentPage)*Integer.parseInt(pageSize),Integer.parseInt(pageSize));
//					List<ClickCollect> clickCollectList2 = clickCollectService.findCollectList(mobile, "2");
//					for(ClickCollect i : clickCollectList2){
//						clickCollectList1.add(i);
//					}
					List<ScenicSpot> listSceneicSpot = new ArrayList<ScenicSpot>();
					if(clickCollectList1.size()>0){
						for(ClickCollect i : clickCollectList1){
							String collectId = i.getTypeId();
							ScenicSpot scenicSpot = scenicSpotService.findById(Long.parseLong(collectId));
							if(scenicSpot != null){
							listSceneicSpot.add(scenicSpot);}
						}
					}else{
						map.put("code", "0");
						map.put("message", "没有收藏的列表");
						return map;
					}
					if(listSceneicSpot.size() > 0){
						map.put("code", "0");
						map.put("message", "查询成功");
						map.put("data", listSceneicSpot);
						return map;
					}else{
						map.put("code", "0");
						map.put("message", "没有收藏的列表");
						return map;
					}
				}
				if(type.equals("2")){
					List<ClickCollect> clickCollectList1 = clickCollectService.findChubbyCollectList(mobile, "3",Integer.parseInt(currentPage)*Integer.parseInt(pageSize),Integer.parseInt(pageSize));
					List<Chubby> listChubby = new ArrayList<Chubby>();
					if(clickCollectList1.size() > 0){
						for(ClickCollect i : clickCollectList1){
						String id = i.getTypeId();
						Chubby  chubby=chubbyService.findById(Integer.parseInt(id));
						listChubby.add(chubby);
						}
						if(listChubby.size() > 0){
							map.put("code","0");
							map.put("message", "查询成功");
							map.put("data", listChubby);
							return map;
						}
					}else{
						map.put("code", "0");
						map.put("message", "未查到此类型文章");
						return map;
					}
					
				}
				map.put("code", "1");
				map.put("message", "参数错误");
				return map;
			}
			@RequestMapping(value = "/cancelCollect", method = RequestMethod.GET)
			@ResponseBody
			public Map<String,Object> cancelCollect (HttpServletRequest request,HttpServletResponse response) {
				Map<String,Object> map = new HashMap<String, Object>();
				String type = request.getParameter("type");
				String mobile = request.getParameter("mobile");
				String id = request.getParameter("id");
				if(type == null || "".equals(type)){
					map.put("code", "1");
					map.put("message", "type不能为空");
					return map;
				}
				if(mobile == null || "".equals(mobile)){
					map.put("code", "1");
					map.put("message", "mobile不能为空");
					return map;
				}
				if(id == null || "".equals(id)){
					map.put("code", "1");
					map.put("message", "id不能为空");
					return map;
				}
				if(type.equals("1")){
					int count = clickCollectService.cancelCollect(mobile,id);
					if(count > 0){
						map.put("code", "0");
						map.put("message", "取消成功");
						return map;
					}else{
						map.put("code", "1");
						map.put("message", "取消失败");
						return map;
					}
				}
				if(type.equals("2")){
					int count = clickCollectService.cancelChubbyCollect(mobile,id);
					if(count > 0){
						map.put("code", "0");
						map.put("message", "取消成功");
						return map;
					}else{
						map.put("code", "1");
						map.put("message", "取消失败");
						return map;
					}
				}
				map.put("code", "1");
				map.put("message", "参数错误");
				return map;
			}
			
}
