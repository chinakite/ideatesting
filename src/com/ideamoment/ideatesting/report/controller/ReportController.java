/**
 * 
 */
package com.ideamoment.ideatesting.report.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideamoment.ideadp.restful.json.JsonData;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.BaseController;
import com.ideamoment.ideatesting.model.CaseResult;
import com.ideamoment.ideatesting.model.CommandResult;
import com.ideamoment.ideatesting.model.Project;
import com.ideamoment.ideatesting.model.RunSchema;
import com.ideamoment.ideatesting.model.SchemaExecution;
import com.ideamoment.ideatesting.project.service.ProjectService;
import com.ideamoment.ideatesting.report.service.ReportService;
import com.ideamoment.ideatesting.schema.service.SchemaService;
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
    
    @Autowired
    private SchemaService schemaService;
    
    @RequestMapping(value="/reportPage", method=RequestMethod.GET)
    public ModelAndView reportPage(@PathVariable String projectId) {
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

    @RequestMapping(value="/schemaExecution/{schemaExecutionId}/caseReportPage", method=RequestMethod.GET)
    public ModelAndView caseReportPage(@PathVariable String projectId, @PathVariable String schemaExecutionId) {
        Project project = projectService.findProject(projectId);

        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("project", project);

        SchemaExecution schemaExecution = schemaService.findSchemaExecution(schemaExecutionId);
        model.put("schemaExecution", schemaExecution);
        
        RunSchema schema = schemaService.findSchema(schemaExecution.getSchemaId());
        model.put("schema", schema);
        
        return new ModelAndView("/WEB-INF/jsp/report/case_report.jsp", model);
    }
    
    @RequestMapping(value="/schemaExecution/{schemaExecutionId}/caseReports", method=RequestMethod.GET)
    public JsonData caseReports(@PathVariable String schemaExecutionId) {
        List<CaseResult> caseResultList = reportService.listCaseReports(schemaExecutionId);
        return JsonData.success(caseResultList);
    }
    
    @RequestMapping(value="/schemaExecution/{schemaExecutionId}/caseResult/{caseResultId}/commandReports", method=RequestMethod.GET)
    public JsonData commandReports(@PathVariable String caseResultId) {
        List<CommandResult> commandResultList = reportService.listCommandReports(caseResultId);
        return JsonData.success(commandResultList);
    }
}
