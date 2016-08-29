package com.ideamoment.ideatesting.datapool.controller;

import com.ideamoment.ideatesting.datapool.service.DataPoolService;
import com.ideamoment.ideatesting.model.Project;
import com.ideamoment.ideatesting.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * Created by zhangzhonghua on 2016/8/29.
 */
@Controller
@RequestMapping(value="/project/{projectId}")
public class DataPoolController {
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
}
