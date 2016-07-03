/**
 * 
 */
package com.ideamoment.ideatesting.resource.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideamoment.ideatesting.model.Project;
import com.ideamoment.ideatesting.resource.service.ResourceService;

/**
 * @author Chinakite
 *
 */
@Controller
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    
    @RequestMapping(value="/resourcePage", method=RequestMethod.GET)
    public ModelAndView scriptPage() {
        return new ModelAndView("/WEB-INF/jsp/resource/resource_list.jsp");
    }
}
