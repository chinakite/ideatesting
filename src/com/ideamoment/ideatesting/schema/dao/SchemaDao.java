/**
 * 
 */
package com.ideamoment.ideatesting.schema.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.model.RunCase;
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

    public List<RunCase> queryCasesBySchema(String id) {
        String sql = "SELECT "
                   + "c.C_ID, "
                   + "c.C_NAME, "
                   + "c.C_SCRIPT_ID "
                   + " FROM T_SCHEMA_CASE sc, T_CASE c "
                   + " WHERE sc.C_SCHEMA_ID = :schemaId "
                   + " AND   sc.C_CASE_NAME = c.C_NAME ";

        return IdeaJdbc.query(sql)
                        .setParameter("schemaId", id)
                        .listTo(RunCase.class);
    }

}
