/**
 * 
 */
package com.ideamoment.ideatesting.runcase.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideamoment.ideadp.restful.json.JsonData;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.BaseController;
import com.ideamoment.ideatesting.model.Project;
import com.ideamoment.ideatesting.model.RunCase;
import com.ideamoment.ideatesting.model.RunCaseGroup;
import com.ideamoment.ideatesting.project.service.ProjectService;
import com.ideamoment.ideatesting.runcase.service.CaseService;
import com.ideamoment.ideatesting.util.DataTableSource;

/**
 * @author Chinakite
 *
 */
@Controller
@RequestMapping(value="/project/{projectId}")
public class CaseController extends BaseController {
    @Autowired
    private CaseService caseService;
    
    @Autowired
    private ProjectService projectService;
    
    
    @RequestMapping(value="/casePage", method=RequestMethod.GET)
    public ModelAndView casePage(@PathVariable String projectId) {
        Project project = projectService.findProject(projectId);
        
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("project", project);
        
        return new ModelAndView("/WEB-INF/jsp/runcase/case_list.jsp", model);
    }
    
    @RequestMapping(value="/dtPageCases", method=RequestMethod.GET)
    public JsonData dtPageCases(@PathVariable String projectId,
                                  int draw, 
                                  int start, 
                                  int length) {
        int curPage = start/length + 1;
        int pageSize = length;
        
        Page<RunCase> cases = caseService.pageProjectCases(curPage, pageSize, projectId);
        DataTableSource dts = convertToDataTableSource(draw, cases);
        return new JsonData(dts);
    }
    
    @RequestMapping(value="/dtPageCaseGroups", method=RequestMethod.GET)
    public JsonData dtPageCaseGroups(@PathVariable String projectId,
                                  int draw, 
                                  int start, 
                                  int length) {
        int curPage = start/length + 1;
        int pageSize = length;
        
        Page<RunCaseGroup> cases = caseService.pageProjectCaseGroups(curPage, pageSize, projectId);
        DataTableSource dts = convertToDataTableSource(draw, cases);
        return new JsonData(dts);
    }
}
