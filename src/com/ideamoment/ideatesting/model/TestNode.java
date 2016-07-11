/**
 * 
 */
package com.ideamoment.ideatesting.model;

import com.ideamoment.ideadata.annotation.DataItemType;
import com.ideamoment.ideadata.annotation.Entity;
import com.ideamoment.ideadata.annotation.Property;
import com.ideamoment.ideatesting.model.dict.TestNodeTypeDict;

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
    
    @Property(dataItem="C_ADDRESS", type=DataItemType.VARCHAR, length=30)
    private String address;
    
    @Property(dataItem="C_PORT", type=DataItemType.VARCHAR, length=10)
    private String port;
    
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
    
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }
    
    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    public String getTypeText() {
        if(TestNodeTypeDict.HUB.equals(this.type)) {
            return TestNodeTypeDict.HUB_TEXT;
        }else{
            return TestNodeTypeDict.NODE_TEXT;
        }
    }
}
