package com.wzdz.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wzdz.entity.Bszn;
import com.wzdz.entity.BsznType;
import com.wzdz.service.BsznService;
import com.wzdz.service.BsznTypeService;
import com.wzdz.util.PageUtil;

/**
 * 办事指南
 * 给后台提供的方法
 * @author wangman
 *
 */
@Controller
@RequestMapping("/bszn")
public class BsznController {

	@Autowired 
	private BsznService bsznService;
	@Autowired
	private BsznTypeService bsznTypeService;
	
	@ModelAttribute("bszn")
	public Bszn get(@RequestParam(required = false) String id) {
		Bszn bszn= null;
		 if(id!=null&&!id.equals("")){
			 bszn = bsznService.findById(id);
		 }
		 if(bszn == null){
			 bszn = new Bszn();
		 }
		 return bszn;
	}
	
	@RequestMapping(value="/findAll",method = RequestMethod.GET)
	public String findAll(Model model,HttpServletRequest request){
		
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		if(currentPage == null||"".equals(currentPage)){
			currentPage = "1";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "10";
		}
		List<Bszn> list = bsznService.findAll((Integer.valueOf(currentPage)-1)*Integer.valueOf(pageSize),Integer.valueOf(pageSize));
		PageUtil page = new PageUtil();
		page.setList(list);
		int count = bsznService.findCount(null);
		int maxPage = (int)Math.ceil(count*1.0/Integer.valueOf(pageSize));
		page.setMaxPage(maxPage);
		page.setThisPage(Integer.valueOf(currentPage));
		
		if(list.size()>0){
			model.addAttribute("bszn", page);
		}else{
			model.addAttribute("bszn", null);
			model.addAttribute("msg", "没有数据");
		}
		
		return "bsznList";
	}
	@RequestMapping(value="/toUpdate",method = RequestMethod.GET)
	public String findById(HttpServletRequest request,Model model){
		String id = request.getParameter("id");
		Bszn bszn = bsznService.findById(id);
		List<BsznType> typeList= bsznTypeService.findAll();
		if(typeList.size()>0){
			model.addAttribute("bsznType", typeList);
		}
		if(bszn!=null){
			model.addAttribute("bszn", bszn);
		}
		return "bsznForm";
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String update(Bszn bszn,Model model){
		String id = bszn.getId();
		if(id==null || id.equals("") ){
			//新增
			String uuid = UUID.randomUUID().toString();
			uuid = uuid.toString().replaceAll("\\-", "");
			bszn.setId(uuid);
			int numd= bsznService.insert(bszn);
			if(numd>0){
//				model.addAttribute("msg","添加成功");
				return "redirect:/bszn/findAll";
			}else{
//				model.addAttribute("msg", "操作失败");
				return "redirect:/bszn/findAll";
			}
		}else{
//			//修改
			int num = bsznService.update(bszn);
			if(num>0){
				return "redirect:/bszn/findAll";
			}
		}
		return null;
	}
	
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public String delete(String id){
		if(id!=null &&!id.equals("")){
			bsznService.delete(id);
		}
		return "redirect:/bszn/findAll";
	}
	
	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd(Model model){
//		List<BsznType> bsznTypeList = bsznTypeService.findAll();
//		model.addAttribute("bsznTypeList", bsznTypeList);
		List<BsznType> typeList= bsznTypeService.findAll();
		if(typeList.size()>0){
			model.addAttribute("bsznType", typeList);
		}
		return "bsznForm";
	}
	
	
}
