package com.example.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.SearchUserParam;
import com.example.project.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/", "", "/index"})
	public String userIndex(@Valid SearchUserParam searchUserParam, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		HttpSession session = request.getSession();
		if (session.getAttribute("groupId")==null){
			logger.info("UserController::UserviceImpl::groupId: " + session.getAttribute("groupId"));
			return "redirect:/";
		}
		
		searchUserParam.setGroupId(session.getAttribute("groupId").toString());
		
		List<UserModel> userList= userService.sltUserList(searchUserParam);
		
		model.addAttribute("userList", userList);
		
		
		return "user/index";
	}

}
