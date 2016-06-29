/**
 * 
 */
package com.ideamoment.ideatest.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Chinakite
 *
 */
@Controller
public class DashBoardController {
    /**
     * 首页
     * 
     * @return
     */
    @RequestMapping(value="/dashboard", method=RequestMethod.GET)
    public ModelAndView dashboard() {
        return new ModelAndView("/WEB-INF/jsp/dashboard/dashboard.jsp");
    }
}
