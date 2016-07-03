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
@Entity(dataSet="T_NODE")
public class TestNode extends HistoriableEntity {
    
    @Property(dataItem="C_NAME", type=DataItemType.VARCHAR, length=300)
    private String name;
    
    @Property(dataItem="C_DESC", type=DataItemType.VARCHAR, length=420)
    private String desc;
    
    @Property(dataItem="C_STATE", type=DataItemType.VARCHAR, length=2)
    private String state;
    
    @Property(dataItem="C_TYPE", type=DataItemType.VARCHAR, length=2)
    private String type;

    @Property(dataItem="C_OWNER_ID", type=DataItemType.VARCHAR, length=32)
    private String ownerId;
    
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
     * @return the state
     */
    public String getState() {
        return state;
    }
    
    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * @return the ownerId
     */
    public String getOwnerId() {
        return ownerId;
    }
    
    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    
}
