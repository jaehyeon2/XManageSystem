package com.example.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.beans.model.common.UserModel;
import com.example.project.controller.common.BasicController;

@Controller
@RequestMapping("/")
public class IndexController extends BasicController{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping({"/", "", "/index"})
	public String index(HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		
		UserModel user = this.getUser(session);
		
		if (user!=null){
			model.addAttribute("user", user);
		}
		
		return "index";
	}
	
	@RequestMapping({"board"})
	public String board(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		return "board/index";
	}
	
	
}