/**
 * 
 */
package com.ideamoment.ideatesting.tool;

import com.ideamoment.ideajdbc.configuration.IdeaJdbcConfiguration;
import com.ideamoment.ideajdbc.tool.mysql.entity2ddl.MySqlEntity2Ddl;
import com.ideamoment.ideatesting.model.Project;
import com.ideamoment.ideatesting.model.TestNode;
import com.ideamoment.ideatesting.model.User;
import com.ideamoment.ideatesting.model.UserLoginInfo;
import com.ideamoment.ideatesting.model.UserProject;

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
                    User.class,
                    Project.class,
                    TestNode.class,
                    UserProject.class,
                    UserLoginInfo.class
                };
        
        for(Class clz : cls) {
            tool.syncTable("ideatest", "ideatest", null, clz, true);
        }
        
    }

}
