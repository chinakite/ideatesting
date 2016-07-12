/**
 * 
 */
package com.ideamoment.ideatesting.schema.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideamoment.ideatesting.model.Project;
import com.ideamoment.ideatesting.project.service.ProjectService;
import com.ideamoment.ideatesting.schema.service.SchemaService;

/**
 * @author Chinakite
 *
 */
@Controller
@RequestMapping(value="/project/{projectId}")
public class SchemaController {
    @Autowired
    private SchemaService schemaService;
    
    @Autowired
    private ProjectService projectService;
    
    @RequestMapping(value="/schemaPage", method=RequestMethod.GET)
    public ModelAndView schemaPage(@PathVariable String projectId) {
        Project project = projectService.findProject(projectId);
        
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("project", project);
        
        return new ModelAndView("/WEB-INF/jsp/schema/schema_list.jsp", model);
    }
    
}
