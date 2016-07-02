package com.ideamoment.ideatesting.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ideamoment.ideadp.exception.IdeaDataException;
import com.ideamoment.ideadp.exception.IdeaDataExceptionCode;
import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.model.Project;

/**
 * Created by zhangzhonghua on 2016/7/1.
 */
@Service
public class ProjectService {
    
    @IdeaJdbcTx
    public Project findProject(String id) {
        Project project = IdeaJdbc.find(Project.class, id);
        
        if(project == null) {
            throw new IdeaDataException(IdeaDataExceptionCode.DATA_NOU_FOUND, String.format("Project [{0}] is not found.", new String[]{id}));
        }else{
            return project;
        }
    }
}
