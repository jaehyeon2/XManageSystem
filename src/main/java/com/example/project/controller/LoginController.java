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

import com.example.project.beans.model.common.UserModel;
import com.example.project.beans.param.LoginParam;
import com.example.project.service.LoginService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private int MAX_INTERVAL;
	
	@RequestMapping(value={"/", "", "/index"})
	public String loginIndex(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		if (session.getAttribute("userNm")!=null){
			logger.info("LoginController::loginIndex::userNm: " + session.getAttribute("userNm"));
			return "redirect:/";
		}
		
		
		return "login/index";
	}

	@RequestMapping(value={"/auth"})
	public String loginAuth(@Valid LoginParam loginParam, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.removeAttribute("userNm");
		
		UserModel userModel = loginService.validateLoginUser(loginParam);
		
		if (userModel==null){
			logger.info("LoginController::loginAuth::Info: Login Failed");
			//additional error code
			return "login/index";
		}
		
		session.invalidate();
		
		session = request.getSession(true);
		logger.info("LoginController::loginAuth::NewSessionID: "+session.getId());
		session.setAttribute("userId", userModel.getUserId());
		session.setAttribute("userNm", userModel.getUserNm());
		session.setAttribute("userAuth", userModel.getUserAuth());
		session.setMaxInactiveInterval(MAX_INTERVAL);
		
		return "redirect:/";
	}
	
	@RequestMapping(value={"/logout"})
	public String logout(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.removeAttribute("userNm");
		session.removeAttribute("userAuth");
		session.invalidate();
		
		return "redirect:/";
	}
	
	
}
