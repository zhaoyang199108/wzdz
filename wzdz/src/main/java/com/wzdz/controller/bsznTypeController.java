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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wzdz.entity.Bszn;
import com.wzdz.entity.BsznType;
import com.wzdz.service.BsznService;
import com.wzdz.service.BsznTypeService;

/**
 * 办事类型
 * @author wangman
 *
 */

@Controller
@RequestMapping("/bsznType")
public class bsznTypeController {
	
	@Autowired
	private BsznTypeService bsznTypeService;
	@Autowired
	private BsznService bsznServe;
	
	@ModelAttribute("bsznType")
	public BsznType get(@RequestParam(required = false) String id) {
		BsznType bsznType= null;
		 if(id!=null&&!id.equals("")){
			 bsznType = bsznTypeService.findById(id);
		 }
		 if(bsznType == null){
			 bsznType = new BsznType();
		 }
		 return bsznType;
	}
	
	@RequestMapping(value="/findAllType",method = RequestMethod.GET)
	public String findAll(Model model){
		List<BsznType> list =bsznTypeService.findAll();
		if(list.size()>0){
			model.addAttribute("list", list);
		}else{
			model.addAttribute("msg", "没有数据");
		}
		return "bsznTypeList";
	}
	
	
	@RequestMapping(value="/toAdd",method = RequestMethod.GET)
	public String toAdd(Model model){
		return "bsznTypeForm";
	}
	
	@RequestMapping(value="/addType",method = RequestMethod.GET)
	public String addType(BsznType bsznType,Model model){
		if(bsznType!=null){
			int num = bsznTypeService.insert(bsznType);
			if(num>0){
				return "redirect:/bsznType/findAllType";
			}
		}
		return "redirect:/bsznType/findAllType";
	}
	
	@RequestMapping(value="/toUpdate",method = RequestMethod.GET)
	public String toUpdate(HttpServletRequest request,Model model){
		String id = request.getParameter("id");
		BsznType bsznType = bsznTypeService.findById(id);
		if(bsznType!=null){
			model.addAttribute("bsznType", bsznType);
		}
		return "bsznTypeForm";
	}
	
	@RequestMapping(value="/updateType",method = RequestMethod.POST)
	public String updateType(BsznType bsznType,Model model){
		String id = bsznType.getId();
		if(id==null || id.equals("")){
			//新增
			String uuid = UUID.randomUUID().toString();
			uuid = uuid.toString().replaceAll("\\-", "");
			bsznType.setId(uuid);
			int num = bsznTypeService.insert(bsznType);
			if(num>0){
				return  "redirect:/bsznType/findAllType";
			}
		}else{
			//修改
			int num = bsznTypeService.update(bsznType);
			if(num>0){
				return "redirect:/bsznType/findAllType";
			}
		}
		return null;
	}
	
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public String delete(HttpServletRequest request,Model model,RedirectAttributes redirectAttributes){
		String typeId = request.getParameter("id");
		if(typeId!=null &&!typeId.equals("")){
			List<Bszn> bsznList = bsznServe.findByType(typeId, null, 0, 0);
			if(bsznList.size()>0){
				redirectAttributes.addFlashAttribute("msg", "删除失败，请先删除该类型下的数据");
				return "redirect:/bsznType/findAllType";
			}else{
				bsznTypeService.delete(typeId);
				return "redirect:/bsznType/findAllType";
			}
		}
		return null;
	}
}
