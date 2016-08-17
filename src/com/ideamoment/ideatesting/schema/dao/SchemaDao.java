/**
 * 
 */
package com.ideamoment.ideatesting.schema.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.model.CaseScript;
import com.ideamoment.ideatesting.model.RunCase;
import com.ideamoment.ideatesting.model.RunNode;
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
    
    public List<CaseScript> queryScriptsBySchema(String id) {
        String sql = "SELECT "
                   + "s.C_ID, "
                   + "s.C_FILE_NAME, "
                   + "s.C_FILE_URL "
                   + " FROM T_SCHEMA_SCRIPT ss, T_SCRIPT s "
                   + " WHERE ss.C_SCHEMA_ID = :schemaId "
                   + " AND ss.C_SCRIPT_ID = s.C_ID ";

        return IdeaJdbc.query(sql)
                        .setParameter("schemaId", id)
                        .listTo(CaseScript.class);
    }

    public RunNode queryHubBySchema(String id) {
        String sql = "SELECT "
                    + "n.C_ID, "
                    + "n.C_NAME, "
                    + "n.C_ADDRESS, "
                    + "n.C_PORT "
                    + " FROM T_SCHEMA_HUB sc, T_NODE n "
                    + " WHERE sc.C_SCHEMA_ID = :schemaId "
                    + " AND   sc.C_NODE_ID = n.C_ID "
                    + " AND   n.C_TYPE = '1'";

        return (RunNode)IdeaJdbc.query(sql)
                                 .setParameter("schemaId", id)
                                 .uniqueTo(RunNode.class);
    }

}
