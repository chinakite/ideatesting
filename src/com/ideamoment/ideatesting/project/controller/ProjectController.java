package com.ideamoment.ideatesting.project.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideamoment.ideatesting.model.Project;
import com.ideamoment.ideatesting.project.service.ProjectService;

/**
 * Created by zhangzhonghua on 2016/7/1.
 */
@Controller
@RequestMapping(value="/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    
    /**
     * 首页
     * 
     * @return
     */
    @RequestMapping(value="/{id}/dashboard", method=RequestMethod.GET)
    public ModelAndView dashboard(@PathVariable String id) {
        Project project = projectService.findProject(id);
        
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("project", project);
        
        return new ModelAndView("/WEB-INF/jsp/project/project_dashboard.jsp", model);
    }
    
}
