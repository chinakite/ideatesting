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
@Entity(dataSet="T_SCRIPT")
public class CaseScript extends HistoriableEntity {
    @Property(dataItem="C_PROJECT_ID", type=DataItemType.VARCHAR, length=32)
    private String projectId;
    
    @Property(dataItem="C_FILE_URL", type=DataItemType.VARCHAR, length=2000)
    private String fileUrl;
    
    @Property(dataItem="C_VERSION", type=DataItemType.VARCHAR, length=10)
    private String version;
    
    @Property(dataItem="C_FILE_NAME", type=DataItemType.VARCHAR, length=300)
    private String fileName;

    
    /**
     * @return the fileUrl
     */
    public String getFileUrl() {
        return fileUrl;
    }
    
    /**
     * @param fileUrl the fileUrl to set
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }
    
    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }
    
    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
}
