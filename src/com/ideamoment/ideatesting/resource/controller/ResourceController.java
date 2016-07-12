/**
 * 
 */
package com.ideamoment.ideatesting.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideamoment.ideadp.restful.json.JsonData;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.BaseController;
import com.ideamoment.ideatesting.model.RunNode;
import com.ideamoment.ideatesting.resource.service.ResourceService;
import com.ideamoment.ideatesting.util.DataTableSource;

/**
 * @author Chinakite
 *
 */
@Controller
@RequestMapping(value="/resource")
public class ResourceController extends BaseController {
    @Autowired
    private ResourceService resourceService;
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView scriptPage() {
        return new ModelAndView("/WEB-INF/jsp/resource/resource_list.jsp");
    }
    
    @RequestMapping(value="/dtPageHubs", method=RequestMethod.GET)
    public JsonData dtPageHubs(int draw, 
                                  int start, 
                                  int length) {
        int curPage = start/length + 1;
        int pageSize = length;
        
        String ownerId = "1";
        
        Page<RunNode> scripts = resourceService.pageHubs(curPage, pageSize, ownerId);
        DataTableSource dts = convertToDataTableSource(draw, scripts);
        return new JsonData(dts);
    }
    
    @RequestMapping(value="/hub", method=RequestMethod.POST)
    public JsonData addHub(RunNode node) {
        resourceService.addHub(node);
        return JsonData.SUCCESS;
    }
    
    @RequestMapping(value="/hub", method=RequestMethod.PUT)
    public JsonData editHub(RunNode node) {
        resourceService.editHub(node);
        return JsonData.SUCCESS;
    }
    
    @RequestMapping(value="/hub/{id}", method=RequestMethod.GET)
    public JsonData findHub(@PathVariable String id) {
        RunNode node = resourceService.findHub(id);
        return JsonData.success(node);
    }
    
    @RequestMapping(value="/dtPageNodes", method=RequestMethod.GET)
    public JsonData dtPageNodes(int draw, 
                                  int start, 
                                  int length) {
        int curPage = start/length + 1;
        int pageSize = length;
        
        String ownerId = "1";
        
        Page<RunNode> scripts = resourceService.pageNodes(curPage, pageSize, ownerId);
        DataTableSource dts = convertToDataTableSource(draw, scripts);
        return new JsonData(dts);
    }
}
