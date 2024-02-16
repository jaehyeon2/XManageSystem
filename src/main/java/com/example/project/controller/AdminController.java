package com.example.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.project.beans.model.common.GroupModel;
import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.AuthParam;
import com.example.project.beans.param.SearchUserParam;
import com.example.project.beans.param.common.GroupParam;
import com.example.project.beans.param.common.UserParam;
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
	public String manageUser(@Valid SearchUserParam searchUserParam, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		List<UserModel> userList= userService.sltUserList(searchUserParam);
		
		model.addAttribute("userList", userList);
		
		return "admin/manageUser";
	}
	
	@RequestMapping(value={"/manageGroup"}, method=RequestMethod.GET)
	public String manageGroup(@Valid GroupParam groupParam, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		HttpSession session = request.getSession();
		groupParam.setGroupId(session.getAttribute("groupId").toString());
		
		List<GroupModel> groupList = groupService.searchGroupList(groupParam);
		
//		JSONObject 
//		model.addAttribute("groupList", groupList);
		
		return "admin/manageGroup";
	}
	
	@RequestMapping(value={"/addUser"}, method=RequestMethod.GET)
	public String addUserGET(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		return "admin/addUser";
	}
	
	@RequestMapping(value={"/addGroup"}, method=RequestMethod.GET)
	public String addGroupGET(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		return "admin/addGroup";
	}
	
	@RequestMapping(value={"/addUser"}, method=RequestMethod.POST)
	public String addUserPOST(@Valid AuthParam authParam, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		HttpSession session = request.getSession();
		
		authParam.setGroupId(session.getAttribute("groupId").toString());
//		authParam.setGroupId(session.getAttribute("groupNm").toString());
		
		adminService.saveUser(authParam);
		
		return "redirect:/admin/manageGroup";
	}
	
	@RequestMapping(value={"/addGroup"}, method=RequestMethod.POST)
	public String addGroupPOST(@Valid GroupParam groupParam, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		adminService.saveGroup(groupParam);
		
		return "admin/manageGroup";
	}
}
