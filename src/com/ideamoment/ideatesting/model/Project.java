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
@Entity(dataSet="T_PROJECT")
public class Project extends HistoriableEntity {
    
    @Property(dataItem="C_NAME", type=DataItemType.VARCHAR, length=300)
    private String name;
    
    @Property(dataItem="C_DESC", type=DataItemType.VARCHAR, length=420)
    private String desc;

    @Property(dataItem="C_STATE", type=DataItemType.VARCHAR, length=2)
    private String state;

    
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
     * @return the status
     */
    public String getState() {
        return state;
    }
    
    /**
     * @param status the status to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
}
