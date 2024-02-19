package com.example.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.project.beans.param.common.GroupParam;
import com.example.project.service.GroupService;

@Controller
@RequestMapping("/group")
public class GroupController {

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GroupService groupService;
	
	@RequestMapping(value={"/", "", "index"}, method=RequestMethod.GET)
	public String groupIndex(HttpSession session, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		GroupParam groupParam = new GroupParam();
		groupParam.setGroupId(session.getAttribute("groupId").toString());
		groupService.searchGroupList(groupParam);
		
		
		return null;
	}
	
}
