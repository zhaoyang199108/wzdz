package com.wzdz.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wzdz.entity.TrafficCon;
import com.wzdz.service.TrafficConService;
import com.wzdz.util.ReadFile;

@Controller
@RequestMapping("/trafficCon")
public class trafficConController {
	
	@Autowired 
	private TrafficConService trafficConService;
	
	@ResponseBody
	@RequestMapping(value="trafficCon",method = RequestMethod.GET)
	public Map<String,Object> trafficCon(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String city = new String(request.getParameter("city").getBytes("ISO-8859-1"),"utf-8");
		String cityPinYin="";
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		//取数据库数据
		TrafficCon trafficCon = trafficConService.findAll();
		//将城市名改为拼音
		for(int i=0;i<city.length();i++){
			 char word = city.charAt(i);
			 String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			 if(pinyinArray!=null){
				 cityPinYin+= pinyinArray[0].substring(0,pinyinArray[0].length()-1);
			 }
		}
		//根据城市取天气情况
		Map<String,Object> wheatherMap = wheather(city,cityPinYin, request);
		//取限行信息
		Map<String,Object> trafficMap = traffic();
		
		String code="";
		String message ="";
		Map<String,Object> dataMap = new HashMap<String, Object>();
		
		String wheatherCode = (String) wheatherMap.get("code");
		String trafficCode = (String) wheatherMap.get("code");
		if(wheatherCode.equals("0") && trafficCode.equals("0")){
			code="0";
			message="查询成功";
			wheatherMap.remove("code");
			wheatherMap.remove("message");
			
			dataMap.put("wheather", wheatherMap);
			dataMap.put("restrictAccessList", trafficMap.get("restrictAccessList"));
			dataMap.put("restrictNumber", trafficMap.get("restrictNumber"));
			dataMap.put("restrictAccessTime", trafficCon.getLimitTime());
			dataMap.put("restrictAccessArea", trafficCon.getLimitScope());
			dataMap.put("restrictAccessRule", trafficCon.getLimitRule());
			dataMap.put("restrictAccessOther", trafficCon.getOther());
			
		}else {
			code="1";
			message="信息读取失败";
		}

		resMap.put("code", code);
		resMap.put("message", message);
		resMap.put("data", dataMap);
		return resMap;
	}
	
	
	
	public Map<String,Object> wheather(String city,String cityPinYin,HttpServletRequest request) throws IOException{
		Map<String,Object> dataMap = new HashMap<String, Object>();
		String code="";
		String message="";
		
		//读取配置文件的信息
		ReadFile readFile = new ReadFile();
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		Map<String,Object> map = readFile.readFile(path+"trafficCon.properties");
		String url = (String) map.get("weatherUrl");
//		String address = (String) map.get("weatherAddress");
		String key = (String) map.get("weatherkey");

		
		String questUrl = url+"?city="+cityPinYin+"&&key="+key;
		//发出http请求，获得数据
		JSONObject wheather = getHtmlJsonByUrl(questUrl);
		if(wheather!=null){
			//处理数据
			JSONArray wh= (JSONArray) wheather.get("HeWeather5");
			List list= wh;
			
			JSONObject json=(JSONObject) list.get(0);
				String status = json.getString("status");
	//			System.out.println(status+"====");
				if(status.equals("ok")){
	//				String basic= json.getString("basic");
	//				JSONObject basicObj = JSONObject.parseObject(basic);
	//				String cityName= basicObj.getString("city");
					
					String aqi= json.getString("aqi");
					JSONObject aqiObj= JSONObject.parseObject(aqi);
					String citys=aqiObj.getString("city");
					JSONObject cityObj=JSONObject.parseObject(citys);
					String pm25=cityObj.getString("pm25");
					String qlty = cityObj.getString("qlty");
					String weatherPM = "pm2.5 "+pm25+" "+qlty;
					
				String daily_forecast=json.getString("daily_forecast");
					JSONArray dfArray=JSONArray.parseArray(daily_forecast);
					List afList= dfArray;
					JSONObject afObj=(JSONObject) afList.get(0);
					String cond = afObj.getString("cond");
						JSONObject condObj=JSONObject.parseObject(cond);
						String wheather_code=condObj.getString("code_d");
						String wheather_txt = condObj.getString("txt_d");
						
						HttpSession session = request.getSession();
						String imgPath = session.getServletContext().getContextPath()+"/picture/wheatherImg/"+wheather_code+".png";
						String weatherIcon  = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+imgPath;
	//					System.out.println("..."+head+imgPath);
					String tmp = afObj.getString("tmp");
						JSONObject tmpObj=JSONObject.parseObject(tmp);
						String tmp_max=tmpObj.getString("max");
						String tmp_min= tmpObj.getString("min");
						String weatherTemperature = tmp_min+"~"+tmp_max;
					String wind=afObj.getString("wind");
						JSONObject windObj = JSONObject.parseObject(wind);
						String wind_dir=windObj.getString("dir");
						String wind_sc=windObj.getString("sc");
						String weatherWind = wind_dir+" "+wind_sc;
					
					dataMap.put("weatherState", wheather_txt);
					dataMap.put("weatherIcon", weatherIcon );
					dataMap.put("weatherTemperature", weatherTemperature);
					dataMap.put("weatherWind", weatherWind);
					dataMap.put("weatherPM", weatherPM);
					dataMap.put("cityName", city);
					code="0";
					message="查询成功";
	//				
				}else if(status.equals("unknown city")){
					code="2";
					message="未知或错误城市";
				}else if(status.equals("invalid key")){
					code="1";
					message="错误的key";
				}else if(status.equals("param invalid")){
					code="3";
					message="参数错误";
				}else if(status.equals("no more requests")){
					code="4";
					message="超过访问次数";
				}
				else if(status.equals("anr")){
					code="5";
					message="无响应或超时";
				}
				
		}else{
			code="6";
			message="查询失败";
		}
		dataMap.put("code",code);
		dataMap.put("message", message);
		return dataMap;
	}
	
	public Map<String,Object> traffic() throws IOException{
		Map<String,Object> mapData = new HashMap<String, Object>();
		String code="";
		String message="";
		
		//读取配置文件的信息
		ReadFile readFile = new ReadFile();
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		Map<String,Object> map = readFile.readFile(path+"trafficCon.properties");
		String limitUrl = (String) map.get("limitUrl");
		String limitAddressCode = (String) map.get("limitAddressCode");
		String limitKey = (String) map.get("limitKey");
		String questUrl = limitUrl+"?city="+limitAddressCode+"&&apikey="+limitKey;
		//发出http请求，获得数据
		JSONObject limit = getHtmlJsonByUrl(questUrl);
		if(limit!=null){
			String rspcode= limit.getString("rspcode");
//			System.out.println(rspcode+"===");
			if(rspcode.equals("20000")){
				String localCar = limit.getString("localcar");
				JSONArray lcObj = JSONArray.parseArray(localCar);
				List lcList = lcObj;
				JSONObject localCarObj = (JSONObject) lcList.get(0);
//				String date = localCarObj.getString("date");
//				date = date.substring(5, date.length());
//				String week = localCarObj.getString("week");
				String number = localCarObj.getString("number");
				number = number.replace(",", "/");
				
				//将限行号码按照星期重新排序
				List<Map<String, Object>> restrictAccessList = getTrafficData(number);
				//当天限行车号
				String restrictNumber=number.split(";")[0];
				
				mapData.put("restrictNumber", restrictNumber);
				mapData.put("restrictAccessList", restrictAccessList);
				
				code = "0";
				message = "查询成功";
			}else if(rspcode.equals("10001")){
				code="1";
				message="参数中apikey不存在";
			}else if(rspcode.equals("10002")){
				code="2";
				message="apikey没有申请";
			}else if(rspcode.equals("10003")){
				code="3";
				message="apikey对应的不是该接口";
			}else if(rspcode.equals("10004")){
				code="4";
				message="apikey已到达使用次数上线";
			}else if(rspcode.equals("10201")){
				code="5";
				message="city参数错误";
			}else if(rspcode.equals("10202")){
				code="6";
				message="city不存在";
			}else if(rspcode.equals("10203")){
				code="7";
				message="date参数错误";
			}else if(rspcode.equals("21000")){
				code="8";
				message="正常 无信息";
			}
		}else{
			code="10";
			message="查询失败";
		}
		
		mapData.put("code", code);
		mapData.put("message", message);
		return mapData;
	}
	
	
	//发出http请求
	 public static JSONObject getHtmlJsonByUrl(String urlTemp){
	        URL url = null;
	        InputStreamReader input = null; 
	        HttpURLConnection conn;
	        JSONObject jsonObj = null;
	        try {
	           url = new URL(urlTemp);
	           conn = (HttpURLConnection) url.openConnection();
	           input = new InputStreamReader(conn.getInputStream(),"utf-8");
	           Scanner inputStream = new Scanner(input);   
	           StringBuffer sb = new StringBuffer();
	           while (inputStream.hasNext()) {    
	                 sb.append(inputStream.nextLine());
	           }
	           jsonObj =  JSONObject.parseObject(sb.toString());
	       } catch (Exception e) {  
	            System.out.println(e.getMessage());
	      }
	         return jsonObj;
	 }
	 
	 // 根据日期获得所在周的日期 
	 public static List<Date> dateToWeek(Date mdate) {
			int b = mdate.getDay();
			Date fdate;
			List<Date> list = new ArrayList<Date>();
			Long fTime = mdate.getTime() - b * 24 * 3600000;
			for (int a = 1; a <= 7; a++) {
				fdate = new Date();
				fdate.setTime(fTime + (a * 24 * 3600000));
				list.add(a-1, fdate);
			}
			return list;
		}
	 
	 //得到日期对应的限号
	 public List<Map<String, Object>> getTrafficData(String number){
		 	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			Date currentDate = new Date();
			List<Map<String, Object>> list= new ArrayList<Map<String, Object>>();
			
			List<Date> days = dateToWeek(currentDate);
			List<String> dateList = new ArrayList<String>();
			for (Date date : days) {
				dateList.add(sdf.format(date));
			}
			//将数字重新排序
			int num = number.lastIndexOf("不限行");
			String newNum = null;
			if(num+3 == number.length()){
				//周日
				if(number.indexOf("不限行") == 0){
					String pre = number.substring(4,num);
					String suf = "不限行;不限行";
					newNum = pre+suf;
				}else{
					//周一
					newNum = number;
				}
			}else{
				//周二-周六
				String pre=number.substring(num+4);
				String suf =  number.substring(0,num+3);
				newNum = pre+";"+suf;
			}
			String[] newNumArray = newNum.split(";");
//			System.out.println(newNum+newNumArray.length+dateList.size());
			
			for(int i=0;i<newNumArray.length;i++){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("num", newNumArray[i]);
				map.put("date", dateList.get(i));
//				System.out.println(map+","+i);
				list.add(map);
			}
//			System.out.println(list);
		return list;
		 
	 }
	 
	 @RequestMapping(value = "/findAll", method = RequestMethod.GET)
	 public String findAll(Model model){
		 TrafficCon trafficon = trafficConService.findAll();
		 if(trafficon != null){
			 model.addAttribute("trafficon",trafficon);
		 }
		 return "trafficConList";
	 }
	 
	 @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
	 public String toUpdate(HttpServletRequest request,Model model){
		String id = request.getParameter("id");
		TrafficCon trafficCon = trafficConService.findById(id);
		if(trafficCon != null){
			 model.addAttribute("trafficon",trafficCon);
		 }
		return "trafficConForm";
	 }
	 
	 @RequestMapping(value = "/update", method = RequestMethod.POST)
	 public String update(@ModelAttribute("trafficCon")TrafficCon trafficCon) throws UnsupportedEncodingException{
		int num =  trafficConService.update(trafficCon);
		if(num>0){
			return "redirect:/trafficCon/findAll";
		}
		return null;
	 }
	 @ModelAttribute("trafficCon")
		public TrafficCon get(@RequestParam(required = false) String id) {
		 if(id!=null&&!id.equals("")){
			 return trafficConService.findById(id);
		 }else{
			 return new TrafficCon();
		 }
		}

}
