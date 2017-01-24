/**
 * 
 */
package com.ideamoment.ideatesting.user.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Chinakite
 *
 */
@Controller
public class UserController {
	/**
     * 首页
     * 
     * @return
     */
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView toLoginPage() {
    	HashMap<String, Object> model = new HashMap<String, Object>();
    	return new ModelAndView("/login.jsp", model);
    }
    
    /**
     * 首页
     * 
     * @return
     */
    @RequestMapping(value="/register", method=RequestMethod.GET)
    public ModelAndView toRegisterPage() {
    	HashMap<String, Object> model = new HashMap<String, Object>();
    	return new ModelAndView("/register.jsp", model);
    }
}
