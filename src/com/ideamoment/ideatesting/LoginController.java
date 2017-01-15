/**
 * 
 */
package com.ideamoment.ideatesting;

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
public class LoginController {
	/**
     * 首页
     * 
     * @return
     */
    @RequestMapping(value="/loginPage", method=RequestMethod.GET)
    public ModelAndView index() {
    	HashMap<String, Object> model = new HashMap<String, Object>();
    	return new ModelAndView("/login.jsp", model);
    }
    
    
}
