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
@Entity(dataSet="T_CASE")
public class RunCase extends HistoriableEntity {
    @Property(dataItem="C_NAME", type=DataItemType.VARCHAR, length=300)
    private String name;
    
    @Property(dataItem="C_SCRIPT_ID", type=DataItemType.VARCHAR, length=32)
    private String scriptId;
    
    @Property(dataItem="C_START_LINE", type=DataItemType.INT)
    private int startLine;
    
    @Property(dataItem="C_END_LINE", type=DataItemType.INT)
    private int endLine;

    
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
     * @return the scriptId
     */
    public String getScriptId() {
        return scriptId;
    }
    
    /**
     * @param scriptId the scriptId to set
     */
    public void setScriptId(String scriptId) {
        this.scriptId = scriptId;
    }
    
    /**
     * @return the startLine
     */
    public int getStartLine() {
        return startLine;
    }
    
    /**
     * @param startLine the startLine to set
     */
    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }
    
    /**
     * @return the endLine
     */
    public int getEndLine() {
        return endLine;
    }
    
    /**
     * @param endLine the endLine to set
     */
    public void setEndLine(int endLine) {
        this.endLine = endLine;
    }
    
}
