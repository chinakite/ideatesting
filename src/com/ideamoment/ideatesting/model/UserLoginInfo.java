/**
 * 
 */
package com.ideamoment.ideatesting.model;

import java.util.Date;

import com.ideamoment.ideadata.annotation.DataItemType;
import com.ideamoment.ideadata.annotation.Entity;
import com.ideamoment.ideadata.annotation.Property;

/**
 * @author Chinakite
 *
 */
@Entity(dataSet="T_USER_LOGININFO")
public class UserLoginInfo extends BaseEntity {
    @Property(dataItem="C_USER_ID", type=DataItemType.VARCHAR, length=32)
    private String userId;
    
    @Property(dataItem="C_FIRST_LOGIN_TIME", type=DataItemType.DATETIME)
    private Date firstLoginTime;
    
    @Property(dataItem="C_FIRST_LOGIN_IP", type=DataItemType.VARCHAR, length=32)
    private String firstLoginIp;
    
    @Property(dataItem="C_LAST_LOGIN_TIME", type=DataItemType.DATETIME)
    private Date lastLoginTime;
    
    @Property(dataItem="C_LAST_LOGIN_IP", type=DataItemType.VARCHAR, length=32)
    private String lastLoginIp;

    
    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    /**
     * @return the firstLoginTime
     */
    public Date getFirstLoginTime() {
        return firstLoginTime;
    }

    
    /**
     * @param firstLoginTime the firstLoginTime to set
     */
    public void setFirstLoginTime(Date firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    
    /**
     * @return the firstLoginIp
     */
    public String getFirstLoginIp() {
        return firstLoginIp;
    }

    
    /**
     * @param firstLoginIp the firstLoginIp to set
     */
    public void setFirstLoginIp(String firstLoginIp) {
        this.firstLoginIp = firstLoginIp;
    }

    
    /**
     * @return the lastLoginTime
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    
    /**
     * @param lastLoginTime the lastLoginTime to set
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    
    /**
     * @return the lastLoginIp
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    
    /**
     * @param lastLoginIp the lastLoginIp to set
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
    
    
}
