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
@Entity(dataSet="T_SCHEMA_CASE_GROUP")
public class SchemaCaseGroup extends HistoriableEntity {
    @Property(dataItem="C_SCHEMA_ID", type=DataItemType.VARCHAR, length=32)
    private String schemaId;
    
    @Property(dataItem="C_CASE_GROUP_NAME", type=DataItemType.VARCHAR, length=300)
    private String caseGroupName;
    
    /**
     * @return the schemaId
     */
    public String getSchemaId() {
        return schemaId;
    }
    
    /**
     * @param schemaId the schemaId to set
     */
    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }
    
    /**
     * @return the caseGroupName
     */
    public String getCaseGroupName() {
        return caseGroupName;
    }
    
    /**
     * @param caseGroupName the caseGroupName to set
     */
    public void setCaseGroupName(String caseGroupName) {
        this.caseGroupName = caseGroupName;
    }
    
}
