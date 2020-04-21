package com.am.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.am.util.StaticKey;

@Controller
public class PageController {
	
	
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showIndex(@PathVariable String page){
		return page;
	}
	
	@RequestMapping("/show_form")
	public String showForm(int index,ModelMap model){
		model.put("index",index);
		return "show_form";
	}
	
	@RequestMapping("/quit")
	public ModelAndView  quit(HttpSession httpSession){
		try {
			httpSession.setAttribute(StaticKey.LOGIN_USER,null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return new ModelAndView("redirect:/login");
	}

}
