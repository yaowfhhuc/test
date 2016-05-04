package me.tend.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import me.tend.test.model.User;

public class SessionInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		User user= (User)request.getSession().getAttribute("loginUser");
		
		if(user==null){
			logger.info("no user loggon ,redirect to login page!!!");
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}

}
