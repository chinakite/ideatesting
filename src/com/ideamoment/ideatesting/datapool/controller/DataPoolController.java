package com.ideamoment.ideatesting.datapool.controller;

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
import com.ideamoment.ideatesting.datapool.service.DataCell;
import com.ideamoment.ideatesting.datapool.service.DataPoolService;
import com.ideamoment.ideatesting.datapool.service.TableData;
import com.ideamoment.ideatesting.model.Param;
import com.ideamoment.ideatesting.model.Project;
import com.ideamoment.ideatesting.model.dict.ParamTypeDict;
import com.ideamoment.ideatesting.project.service.ProjectService;
import com.ideamoment.ideatesting.util.DataTableSource;

/**
 * Created by zhangzhonghua on 2016/8/29.
 */
@Controller
@RequestMapping(value="/project/{projectId}")
public class DataPoolController extends BaseController{
    @Autowired
    private DataPoolService dataPoolService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value="/dataPoolPage", method= RequestMethod.GET)
    public ModelAndView dataPoolPage(@PathVariable String projectId) {
        Project project = projectService.findProject(projectId);

        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("project", project);

        return new ModelAndView("/WEB-INF/jsp/datapool/data_list.jsp", model);
    }

    @RequestMapping(value="/dtPageParams", method=RequestMethod.GET)
    public JsonData dtPageParams(@PathVariable String projectId,
                                  int draw,
                                  int start,
                                  int length) {
        int curPage = start/length + 1;
        int pageSize = length;

        Page<Param> params = dataPoolService.pageProjectParams(curPage, pageSize, projectId);
        DataTableSource dts = convertToDataTableSource(draw, params);
        return new JsonData(dts);
    }

    @RequestMapping(value="/param", method=RequestMethod.POST)
    public JsonData saveParam(
            @PathVariable String projectId,
            String name,
            String desc,
            String varName,
            String type,
            String value,
            String fileType,
            String fileUrl,
            int sheetNo) {
        dataPoolService.saveParam(projectId, name, desc, varName, type, value, fileType, fileUrl, sheetNo);
        return JsonData.SUCCESS;
    }

    @RequestMapping(value="/previewFile", method=RequestMethod.POST)
    public JsonData previewFile(String type, String fileUrl, String fileType) {
    	if(ParamTypeDict.TABLE.equals(type)) {
    		TableData excelData = dataPoolService.parseTableDataFile(fileUrl, fileType);
            return JsonData.success(excelData);
    	}
        return JsonData.SUCCESS;
    }
    
    @RequestMapping(value="/dataDetailPage", method= RequestMethod.GET)
    public ModelAndView dataDetailPage(@PathVariable String projectId, String paramId) {
        Project project = projectService.findProject(projectId);

        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("project", project);

        return new ModelAndView("/WEB-INF/jsp/datapool/data_detail.jsp", model);
    }
    
    @RequestMapping(value="/param/{paramId}", method=RequestMethod.GET)
    public JsonData param(@PathVariable String paramId) {
    	Param param = dataPoolService.findParam(paramId);
    	return JsonData.success(param);
    }
    
    @RequestMapping(value="/paramTableHeader", method=RequestMethod.GET)
    public JsonData paramTableHeader(String paramId) {
    	List<DataCell> headers = dataPoolService.listParamTableHeader(paramId);
    	return JsonData.success(headers);
    }
    
    @RequestMapping(value="/paramTableValues", method=RequestMethod.GET)
    public JsonData paramTableValues(String paramId) {
    	List<DataCell> values = dataPoolService.listParamTableValues(paramId);
    	return JsonData.success(values);
    }
    
    @RequestMapping(value="/dtPageParamTableValues", method=RequestMethod.GET)
    public JsonData dtPageParamTableValues(String paramId,
			                                  int draw,
			                                  int start,
			                                  int length) {
        int curPage = start/length + 1;
        int pageSize = length;

        Page<DataCell> cells = dataPoolService.pageParamTableValues(curPage, pageSize, paramId);
        DataTableSource dts = convertToDataTableSource(draw, cells);
        return new JsonData(dts);
    }
}
