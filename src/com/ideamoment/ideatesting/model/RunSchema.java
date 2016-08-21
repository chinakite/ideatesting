/**
 * 
 */
package com.ideamoment.ideatesting.model;

import com.ideamoment.ideadata.annotation.DataItemType;
import com.ideamoment.ideadata.annotation.Entity;
import com.ideamoment.ideadata.annotation.Property;
import com.ideamoment.ideatesting.model.dict.SchemaRunTypeDict;

/**
 * @author Chinakite
 *
 */
@Entity(dataSet="T_SCHEMA")
public class RunSchema extends HistoriableEntity {
    @Property(dataItem="C_NAME", type=DataItemType.VARCHAR, length=300)
    private String name;
    
    @Property(dataItem="C_PROJECT_ID", type=DataItemType.VARCHAR, length=32)
    private String projectId;
    
    @Property(dataItem="C_DESC", type=DataItemType.VARCHAR, length=420)
    private String desc;
    
    @Property(dataItem="C_RUN_TYPE", type=DataItemType.VARCHAR, length=2)
    private String runType;

    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
    
    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }
    
    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    /**
     * @return the runType
     */
    public String getRunType() {
        return runType;
    }
    
    /**
     * @param runType the runType to set
     */
    public void setRunType(String runType) {
        this.runType = runType;
    }
    
    public String getRunTypeText() {
    	if(SchemaRunTypeDict.AUTO.equals(this.runType)) {
    		return SchemaRunTypeDict.AUTO_TEXT;
    	}else{
    		return SchemaRunTypeDict.MANUAL_TEXT;
    	}
    }
}
