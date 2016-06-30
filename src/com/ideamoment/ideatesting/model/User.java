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
@Entity(dataSet="T_USER")
public class User extends HistoriableEntity {
    @Property(dataItem="C_NAME", type=DataItemType.VARCHAR, length=60)
    private String name;
    
    @Property(dataItem="C_ACCOUNT", type=DataItemType.VARCHAR, length=60)
    private String account;
    
    @Property(dataItem="C_EMAIL", type=DataItemType.VARCHAR, length=60)
    private String email;
    
    @Property(dataItem="C_PASSWORD", type=DataItemType.VARCHAR, length=40)
    private String password;
    
    @Property(dataItem="C_MOBILE", type=DataItemType.VARCHAR, length=20)
    private String mobile;
    
    @Property(dataItem="C_GENDER", type=DataItemType.VARCHAR, length=1)
    private String gender;
    
    /**
     * 头像
     */
    @Property(dataItem="C_LOGOURL", type=DataItemType.VARCHAR, length=500)
    private String logoUrl;
    
    /**
     * 状态:禁用\启用
     */
    @Property(dataItem="C_STATUS", type=DataItemType.VARCHAR, length=1)
    private String status;

    
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
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    
    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    
    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    
    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    
    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    
    /**
     * @return the logoUrl
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    
    /**
     * @param logoUrl the logoUrl to set
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
