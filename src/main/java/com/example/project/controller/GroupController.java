package com.example.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/group")
public class GroupController {

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value={"/", "", "index"}, method=RequestMethod.GET)
	public String groupIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		
		
		return null;
	}
	
}
