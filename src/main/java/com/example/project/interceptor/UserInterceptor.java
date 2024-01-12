package com.example.project.interceptor;

import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;


public class UserInterceptor{

	final Logger logger = LoggerFactory.getLogger(UserInterceptor.class);

	String DEFAULT_TAG = "lang";
	String LANG = "en-US";
	String LANG_SET = "en";

	private void printParameters(HttpServletRequest request) {
		Enumeration<String> en = request.getParameterNames();
		while ( en.hasMoreElements() ){
			String name = (String) en.nextElement();
			String[] values = request.getParameterValues(name);		
			for (String value : values) {
				logger.info("name=" + name + ",value=" + value);
			}
		}
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView modelAndView) throws Exception {

		// Set the language tag for displaying it.
		Locale locale = RequestContextUtils.getLocale(request);
		logger.debug("LanguageTag in postHandle = " + locale.toLanguageTag());

		// Set locale language into Session
		HttpSession session = request.getSession();
		session.setAttribute(DEFAULT_TAG, locale.toLanguageTag());
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {

		String pathInfo = request.getPathInfo();
		logger.info("getServletPath >>> " + request.getServletPath());
		logger.info("pathInfo >>> " + pathInfo);

		// Print paramters
		this.printParameters(request);
		
		// True to create new session
//		HttpSession session = request.getSession(true);

//		try {
//			if(response == null || request == null) {
//				logger.warn("Administrator session is expired.");
//				throw new AuthenticationException();
//			}
//			logger.info("sessionId = " + session.getId());
//
//		} catch (AuthenticationException | NullPointerException e) {
//			// Clear cookie
//			this.clearCookie(request, response);
//			// Clear session
//			session.invalidate();
//			logger.warn("LoginException:session is clear.");
//
//			ModelAndView mv = new ModelAndView("redirect:/admin/login");
//			ModelAndViewDefiningException mvde = new ModelAndViewDefiningException(mv);
//			throw mvde;
//		}

		return true;
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}