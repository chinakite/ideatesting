/**
 * 
 */
package com.ideamoment.ideatesting.report.controller;

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
import com.ideamoment.ideatesting.model.SchemaExecution;
import com.ideamoment.ideatesting.project.service.ProjectService;
import com.ideamoment.ideatesting.report.service.ReportService;
import com.ideamoment.ideatesting.util.DataTableSource;

/**
 * @author Chinakite
 *
 */
@Controller
@RequestMapping(value="/project/{projectId}")
public class ReportController extends BaseController {
	@Autowired
    private ReportService reportService;
    
    @Autowired
    private ProjectService projectService;
    
    @RequestMapping(value="/reportPage", method=RequestMethod.GET)
    public ModelAndView schemaPage(@PathVariable String projectId) {
        Project project = projectService.findProject(projectId);
        
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("project", project);
        
        return new ModelAndView("/WEB-INF/jsp/report/report_list.jsp", model);
    }
    
    @RequestMapping(value="/dtPageReports", method=RequestMethod.GET)
    public JsonData dtPageReports(@PathVariable String projectId,
                                  int draw, 
                                  int start, 
                                  int length) {
        int curPage = start/length + 1;
        int pageSize = length;
        
        Page<SchemaExecution> scripts = reportService.pageProjectReports(curPage, pageSize, projectId);
        DataTableSource dts = convertToDataTableSource(draw, scripts);
        return new JsonData(dts);
    }
}