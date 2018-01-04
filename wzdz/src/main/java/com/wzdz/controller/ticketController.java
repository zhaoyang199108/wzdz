package com.wzdz.controller;

import java.io.UnsupportedEncodingException;
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

import com.wzdz.entity.ScenicSpot;
import com.wzdz.service.TicketService;

/**
 * 票务
 * @author wudi
 *
 */

@Controller
@RequestMapping("/ticket")
public class ticketController {
	
	@Autowired 
	private TicketService ticketService;

	       //列表
			@RequestMapping(value = "/ticket", method = RequestMethod.GET)
			@ResponseBody
			public Map<String,Object> ticketList (HttpServletRequest request,HttpServletResponse response) {
				Map<String,Object> resMap = new HashMap<String, Object>();
				String area = request.getParameter("area");
				String currentPage = request.getParameter("currentPage");
				String pageSize = request.getParameter("pageSize");
				
				if(currentPage == null||"".equals(currentPage)){
					currentPage = "0";
				}
				if(pageSize == null||"".equals(pageSize)){
					pageSize = "20";
				}
				if(area==null || "".equals(area)){//列表查询
					List<ScenicSpot> cf = ticketService.findAll( Integer.parseInt(currentPage)*Integer.parseInt(pageSize), Integer.parseInt(pageSize));
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
				}else{//按地域查询
					try {
						area = new String(area.getBytes("iso-8859-1"),"utf-8");
					} catch (UnsupportedEncodingException e2) {
						e2.printStackTrace();
					}
					if(area == null || "".equals(area)){
						resMap.put("code", "1");
						resMap.put("message","传入area为空！");
						return resMap;
					}
					List<ScenicSpot> a  = ticketService.findByArea(area,Integer.parseInt(currentPage)*Integer.parseInt(pageSize), Integer.parseInt(pageSize));
					if(a!=null || !"".equals(a)){
						resMap.put("code","0");
						resMap.put("message", "查詢成功");
						resMap.put("data", a);
						return resMap;
					}else{
						resMap.put("code", "0");
						resMap.put("data", a);
						resMap.put("message","无数据！");
						return resMap;
					}
				}
			}

	
         //地域
			@RequestMapping(value = "/area", method = RequestMethod.GET)
			@ResponseBody
			public Map<String,Object> areaList (HttpServletRequest request,HttpServletResponse response) {
				Map<String,Object> resMap = new HashMap<String, Object>();
				List<String> list = new ArrayList<String>();
				list.add("全部");
				List<String> list_find = ticketService.findList();
				for(String i : list_find){
					list.add(i);
				}
				resMap.put("code", "0");
				resMap.put("message","查询成功");
				resMap.put("data", list);
				return resMap ;
			}
}
