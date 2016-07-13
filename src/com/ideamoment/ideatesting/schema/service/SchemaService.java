/**
 * 
 */
package com.ideamoment.ideatesting.schema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.model.RunSchema;
import com.ideamoment.ideatesting.schema.dao.SchemaDao;

/**
 * @author Chinakite
 *
 */
@Service
public class SchemaService {
    @Autowired
    private SchemaDao schemaDao;

    @IdeaJdbcTx
    public Page<RunSchema> pageProjectSchemas(int curPage,
                                               int pageSize,
                                               String projectId)
    {
        return schemaDao.pageQuerySchemasByProjectId(curPage, pageSize, projectId);
    }
}
