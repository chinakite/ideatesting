/**
 * 
 */
package com.ideamoment.ideatesting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Chinakite
 *
 */
@Controller
public class IndexController {
    /**
     * 首页
     * 
     * @return
     */
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView dashboard() {
        return new ModelAndView("/WEB-INF/jsp/project/noproject.jsp");
    }
}
