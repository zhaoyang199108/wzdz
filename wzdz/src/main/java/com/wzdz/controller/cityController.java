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

import com.wzdz.dto.CityContentView;
import com.wzdz.dto.CityView;
import com.wzdz.entity.City;
import com.wzdz.service.CityService;

/**
 * 城市百科
 * @author wudi
 *
 */


@Controller
@RequestMapping("/city")
public class cityController {
	
	@Autowired 
	private CityService cityService;
	
	@RequestMapping(value = "/city", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> city (HttpServletRequest request,HttpServletResponse response) {
			Map<String,Object> resMap = new HashMap<String, Object>();
			City city_find = cityService.findAll();
			if(city_find == null ||"".equals(city_find)){
					resMap.put("code", "0");
					resMap.put("message", "没有数据");
					return resMap;
			}
			String title = city_find.getTitle();
			String information = city_find.getInformation();
			String jzyg = city_find.getJzyg();
			List<CityView> listCityView = new ArrayList<CityView>();
			List<CityContentView> zyContentView = new ArrayList<CityContentView>();
			List<CityContentView> jbxxContentView = new ArrayList<CityContentView>();
			List<CityContentView> jzygContentView = new ArrayList<CityContentView>();
			CityView zy = new CityView();
			CityView jbxx = new CityView();
			CityView jzygDto = new CityView();
			if(title.contains("*")){
				String[]  zzlist = title.split("\\*");
				for(String i : zzlist){
					CityContentView ccv = new CityContentView();
					String[] xbtlist = i.split("-");
					ccv.title=xbtlist[0];
					ccv.content = xbtlist[1];
					zyContentView.add(ccv);
				}
				zy.title="摘要";
				zy.content = "";
				zy.cityContentView = zyContentView;
			}else{
				zy.title = "摘要";
				zy.content = title;
				zy.cityContentView =zyContentView;
			}
			listCityView.add(zy);
			if(information.contains("*")){
				String[]  jbxxlist = information.split("\\*");
				for(String i : jbxxlist){
					CityContentView ccv = new CityContentView();
					String[] xbtlist = i.split("-");
					ccv.title=xbtlist[0];
					ccv.content = xbtlist[1];
					jbxxContentView.add(ccv);
				}
				jbxx.title="基本信息";
				jbxx.content = "";
				jbxx.cityContentView = jbxxContentView;
			}else{
				jbxx.title = "基本信息";
				jbxx.content = information;
				jbxx.cityContentView =jbxxContentView;
			}
			listCityView.add(jbxx);
			if(jzyg.contains("*")){
				String[]  jzyglist = jzyg.split("\\*");
				for(String i : jzyglist){
					CityContentView ccv = new CityContentView();
					String[] xbtlist = i.split("-");
					ccv.title=xbtlist[0];
					ccv.content = xbtlist[1];
					jzygContentView.add(ccv);
				}
				jzygDto.title="建制沿革";
				jzygDto.content = "";
				jzygDto.cityContentView = jzygContentView;
			}else{
				jzygDto.title = "建制沿革";
				jzygDto.content = jzyg;
				jzygDto.cityContentView =jzygContentView;
			}
			listCityView.add(jzygDto);
			resMap.put("message", "查询成功");
			resMap.put("data", listCityView);
			resMap.put("code", "0");
			return resMap;
		}
		

}
