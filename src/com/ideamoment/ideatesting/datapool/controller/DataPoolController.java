package com.ideamoment.ideatesting.datapool.controller;

import java.io.IOException;
import java.util.HashMap;

import com.ideamoment.ideatesting.datapool.service.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideamoment.ideadp.appcontext.IdeaApplicationContext;
import com.ideamoment.ideadp.restful.json.JsonData;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.BaseController;
import com.ideamoment.ideatesting.model.Param;
import com.ideamoment.ideatesting.model.Project;
import com.ideamoment.ideatesting.model.dict.ParamFileTypeDict;
import com.ideamoment.ideatesting.project.service.ProjectService;
import com.ideamoment.ideatesting.util.DataTableSource;
import com.ideamoment.ideatesting.util.ExcelUtils;

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

        Page<Param> scripts = dataPoolService.pageProjectParams(curPage, pageSize, projectId);
        DataTableSource dts = convertToDataTableSource(draw, scripts);
        return new JsonData(dts);
    }

    @RequestMapping(value="/param", method=RequestMethod.POST)
    public JsonData saveParam(
            @PathVariable String projectId,
            String name,
            String desc,
            String varName,
            String type,
            String value) {
        dataPoolService.saveParam(projectId, name, desc, varName, type, value);
        return JsonData.SUCCESS;
    }

    @RequestMapping(value="/previewFile", method=RequestMethod.POST)
    public JsonData previewFile(String fileUrl, String type) {
        ExcelData excelData = dataPoolService.parseDataFile(fileUrl, type);
        return JsonData.success(excelData);
    }
}
