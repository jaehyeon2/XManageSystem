package com.example.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.project.beans.param.SearchParam;
import com.example.project.service.AdminService;
import com.example.project.service.GroupService;
import com.example.project.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
	@RequestMapping(value={"/index", "/dashboard", "", "/"}, method=RequestMethod.GET)
	public String adminIndex(HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception{
		
		return "admin/index";
	}
	
	@RequestMapping(value={"/manageUser"}, method=RequestMethod.GET)
	public String manageUser(@Valid SearchParam searchParam, HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception{
		
		map.put("userList", userService.searchUserList(searchParam));
		
		return "admin/manageUser";
	}

}
