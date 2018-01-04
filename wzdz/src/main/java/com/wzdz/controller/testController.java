package com.wzdz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class testController {
	@RequestMapping(value = "/scenicSpot", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> scenicSpotList (HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		return map;
		
	}
}
