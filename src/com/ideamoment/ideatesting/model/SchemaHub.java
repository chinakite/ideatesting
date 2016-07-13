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
@Entity(dataSet="T_SCHEMA_HUB")
public class SchemaHub extends HistoriableEntity {
    @Property(dataItem="C_SCHEMA_ID", type=DataItemType.VARCHAR, length=32)
    private String schemaId;
    
    @Property(dataItem="C_NODE_ID", type=DataItemType.VARCHAR, length=32)
    private String nodeId;

    
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
     * @return the nodeId
     */
    public String getNodeId() {
        return nodeId;
    }

    
    /**
     * @param nodeId the nodeId to set
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }
    
    
}
