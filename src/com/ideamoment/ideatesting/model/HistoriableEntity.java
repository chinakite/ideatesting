/**
 * 
 */
package com.ideamoment.ideatesting.model;

import java.util.Date;

import com.ideamoment.ideadata.annotation.DataItemType;
import com.ideamoment.ideadata.annotation.Property;

/**
 * @author Chinakite
 *
 */
public class HistoriableEntity extends BaseEntity {
    @Property(dataItem="C_CREATOR_ID", type=DataItemType.VARCHAR, length=32)
    protected String creatorId;
    
    @Property(dataItem="C_CREATETIME", type=DataItemType.DATETIME)
    protected Date createTime;
    
    @Property(dataItem="C_MODIFIER_ID", type=DataItemType.VARCHAR, length=32)
    protected String modifierId;
    
    @Property(dataItem="C_MODIFYTIME", type=DataItemType.DATETIME)
    protected Date modifyTime;
    
    /**
     * @return the creator
     */
    public String getCreatorId() {
        return creatorId;
    }
    
    /**
     * @param creator the creator to set
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }
    
    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }
    
    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the modifier
     */
    public String getModifierId() {
        return modifierId;
    }

    
    /**
     * @param modifier the modifier to set
     */
    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }
    
    /**
     * @return the modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }
    
    /**
     * @param modifyTime the modifyTime to set
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
