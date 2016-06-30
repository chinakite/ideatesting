/**
 * 
 */
package com.ideamoment.ideatesting.model;

import com.ideamoment.ideadata.annotation.DataItemType;
import com.ideamoment.ideadata.annotation.Entity;
import com.ideamoment.ideadata.annotation.Property;

/**
 * @author Chinakite
 *
 */
@Entity(dataSet="T_USER_PROJECT")
public class UserProject extends HistoriableEntity {
    @Property(dataItem="C_USER_ID", type=DataItemType.VARCHAR, length=32)
    private String userId;
    
    @Property(dataItem="C_PROJECT_ID", type=DataItemType.VARCHAR, length=32)
    private String projectId;

    
    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    /**
     * @return the projectId
     */
    public String getProjectId() {
        return projectId;
    }

    
    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    
    
}
