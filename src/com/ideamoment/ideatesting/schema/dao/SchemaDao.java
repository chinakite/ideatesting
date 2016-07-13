/**
 * 
 */
package com.ideamoment.ideatesting.schema.dao;

import org.springframework.stereotype.Component;

import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.model.RunSchema;

/**
 * @author Chinakite
 *
 */
@Component
public class SchemaDao {

    public Page<RunSchema> pageQuerySchemasByProjectId(int curPage,
                                                       int pageSize,
                                                       String projectId)
    {
        String sql = "SELECT * FROM T_SCHEMA WHERE c_PROJECT_ID = :projectId";
        return IdeaJdbc.query(sql)
                        .setParameter("projectId", projectId)
                        .pageTo(RunSchema.class, curPage, pageSize);
    }

}
