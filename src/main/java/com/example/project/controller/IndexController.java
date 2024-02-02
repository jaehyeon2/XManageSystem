package com.example.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping({"/", "", "/index"})
	public String index(HttpServletRequest request, ModelMap model) throws Exception{
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userNm")!=null){
			model.addAttribute("userNm", session.getAttribute("userNm").toString());
			logger.info("IndexController::index::userNm: " + session.getAttribute("userNm"));
			logger.info("IndexController::index::groupId: " + session.getAttribute("groupId"));
			
		}
		
		return "index";
	}
	
	@RequestMapping({"board"})
	public String board(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		return "board/index";
	}
	
	
}