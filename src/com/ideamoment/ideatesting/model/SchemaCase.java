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
@Entity(dataSet="T_SCHEMA_CASE")
public class SchemaCase extends HistoriableEntity {
    @Property(dataItem="C_SCHEMA_ID", type=DataItemType.VARCHAR, length=32)
    private String schemaId;
    
    @Property(dataItem="C_CASE_NAME", type=DataItemType.VARCHAR, length=300)
    private String caseName;
    
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
    
}
