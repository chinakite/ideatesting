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
@Entity(dataSet="T_CASE_GROUP_MAP")
public class RunCaseGroupMap extends HistoriableEntity {
    @Property(dataItem="C_GROUP_NAME", type=DataItemType.VARCHAR, length=300)
    private String groupName;
    
    @Property(dataItem="C_CASE_NAME", type=DataItemType.VARCHAR, length=300)
    private String caseName;
    
    @Property(dataItem="C_PROJECT_ID", type=DataItemType.VARCHAR, length=32)
    private String projectId;

    
    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }
    
    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    /**
     * @return the caseName
     */
    public String getCaseName() {
        return caseName;
    }

    /**
     * @param caseName the caseName to set
     */
    public void setCaseName(String caseName) {
        this.caseName = caseName;
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
