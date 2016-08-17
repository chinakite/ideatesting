/**
 * 
 */
package com.ideamoment.ideatesting.tool;

import com.ideamoment.ideajdbc.configuration.IdeaJdbcConfiguration;
import com.ideamoment.ideajdbc.tool.mysql.entity2ddl.MySqlEntity2Ddl;
import com.ideamoment.ideatesting.model.RunCaseGroupMap;
import com.ideamoment.ideatesting.model.SchemaCase;
import com.ideamoment.ideatesting.model.SchemaCaseGroup;
import com.ideamoment.ideatesting.model.SchemaScript;

/**
 * @author Chinakite
 *
 */
public class GenerateDb {

    /**
     * @param args
     */
    public static void main(String[] args) {
        IdeaJdbcConfiguration.initConfig("ideajdbc.properties");

        MySqlEntity2Ddl tool = new MySqlEntity2Ddl();
        Class[] cls = new Class[]{
//                    User.class,
//                    Project.class,
//                    RunNode.class,
//                    UserProject.class,
//                    UserLoginInfo.class,
//                    CaseScript.class,
//                    RunSchema.class,
//                      SchemaHub.class,
//                      SchemaNode.class,
//                      RunCase.class,
//                      RunCaseDependency.class,
//                      RunCaseGroup.class,
//                      RunCaseGroupMap.class,
//                      SchemaCase.class,
//                      SchemaCaseGroup.class,
                    SchemaScript.class
                };

        for(Class clz : cls) {
            tool.syncTable("ideatest", "ideatest", null, clz, true);
        }
    }

}
