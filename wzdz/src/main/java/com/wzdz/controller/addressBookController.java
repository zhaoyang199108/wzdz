package com.wzdz.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wzdz.dto.AddressBookRes;
import com.wzdz.entity.AddressBook;
import com.wzdz.service.AddressBookService;

/**
 * 号码通
 * 
 * @author wudi
 *
 */
@Controller
@RequestMapping("/addressBook")
public class addressBookController {
	
	@Autowired
	private AddressBookService addressBookService;
	
	
	@RequestMapping(value="addressBook" , method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> selectAddressBookListByPage(HttpServletRequest request,HttpServletResponse response) {
		String code="";
		String message ="";
		Map<String,Object>  map = new HashMap<String, Object>();
		List<AddressBook> ggList = addressBookService.findAll();
		List<AddressBookRes> ggResList = new ArrayList<AddressBookRes>();
		for(AddressBook i : ggList){
			map.put(getPinYinHeadChar(i.getName()).charAt(0)+"", null);
		}
		for(String t : map.keySet()){
			AddressBookRes ggtxlRes = new AddressBookRes();
				List<AddressBook> ggtList = new ArrayList<AddressBook>();
				for(AddressBook i:ggList){
					if(getPinYinHeadChar(i.getName().charAt(0)+"").equals(t)){
						ggtList.add(i);
						char str = getPinYinHeadChar(i.getName()).charAt(0);
						ggtxlRes.sname=""+str;
					}
				}
			ggtxlRes.addressBook = ggtList;
			ggResList.add(ggtxlRes);
		}
		Collections.sort(ggResList, new MySort());
		Map<String,Object> resMap = new HashMap<String, Object>();
		code = ggResList==null?"1":"0";
		message = ggResList==null?"取得失败":"取得成功";
		resMap.put("code", code);
		resMap.put("message", message);
		resMap.put("data",ggResList);
		return resMap;
	}
	
	 public static String getPinYinHeadChar(String str) {
	        String convert = "";
	        String dx="";
	        for (int j = 0; j < str.length(); j++) {
	            char word = str.charAt(j);
	            // 提取汉字的首字母
	            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
	            if (pinyinArray != null) {
	                convert += pinyinArray[0].charAt(0);
	            } else {
	                convert += word;
	            }
	        }
	        dx.toLowerCase();
	        return convert.toLowerCase();
	    }
	
	  class MySort implements Comparator {  
	        public int compare(Object object1, Object object2) {// 实现接口中的方法  
	        	AddressBookRes p1 = ((AddressBookRes) object1); // 强制转换  
	        	AddressBookRes p2 = ((AddressBookRes) object2);  
	            return p1.sname.compareTo(p2.sname);  
	        }  
	    }  
	

}
