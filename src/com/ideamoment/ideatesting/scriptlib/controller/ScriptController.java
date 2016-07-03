/**
 * 
 */
package com.ideamoment.ideatesting.scriptlib.controller;

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
import com.ideamoment.ideatesting.model.CaseScript;
import com.ideamoment.ideatesting.model.Project;
import com.ideamoment.ideatesting.project.service.ProjectService;
import com.ideamoment.ideatesting.scriptlib.service.ScriptService;
import com.ideamoment.ideatesting.util.DataTableSource;

/**
 * @author Chinakite
 *
 */
@Controller
@RequestMapping(value="/project/{projectId}")
public class ScriptController extends BaseController {
    @Autowired
    private ScriptService scriptService;
    
    @Autowired
    private ProjectService projectService;
    
    @RequestMapping(value="/scriptPage", method=RequestMethod.GET)
    public ModelAndView scriptPage(@PathVariable String projectId) {
        Project project = projectService.findProject(projectId);
        
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("project", project);
        
        return new ModelAndView("/WEB-INF/jsp/scriptlib/script_list.jsp", model);
    }
    
    @RequestMapping(value="/scripts", method=RequestMethod.GET)
    public JsonData listScripts(@PathVariable String projectId) {
        List<CaseScript> projects = scriptService.listProjectScripts(projectId);
        return JsonData.success(projects);
    }
    
    @RequestMapping(value="/dtPageScripts", method=RequestMethod.GET)
    public JsonData dtPageScripts(@PathVariable String projectId,
                                  int draw, 
                                  int start, 
                                  int length) {
        int curPage = start/length + 1;
        int pageSize = length;
        
        Page<CaseScript> scripts = scriptService.pageProjectScripts(curPage, pageSize, projectId);
        DataTableSource dts = convertToDataTableSource(draw, scripts);
        return new JsonData(dts);
    }

    
}
