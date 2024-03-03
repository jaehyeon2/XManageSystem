package com.example.project.controller.common;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.example.project.beans.model.common.UserModel;

@Controller
public class BasicController {
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	protected UserModel getUser(HttpSession session){
		
		UserModel user = null;
		
		user = (UserModel) session.getAttribute("user");
		
		if (user==null){
			logger.info("BasicController::getUser:info: user session is not exists!");
			return null;
		}
		
		return user;
		
	}
	
}
