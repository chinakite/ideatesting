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
@Entity(dataSet="T_CASE_DEPEND")
public class RunCaseDependency extends BaseEntity {
    @Property(dataItem="C_CASE_ID", type=DataItemType.VARCHAR, length=32)
    private String caseId;
    
    @Property(dataItem="C_DEPENDENCY_ID", type=DataItemType.VARCHAR, length=32)
    private String dependencyId;

    
    /**
     * @return the caseId
     */
    public String getCaseId() {
        return caseId;
    }
    
    /**
     * @param caseId the caseId to set
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    /**
     * @return the dependencyId
     */
    public String getDependencyId() {
        return dependencyId;
    }
    
    /**
     * @param dependencyId the dependencyId to set
     */
    public void setDependencyId(String dependencyId) {
        this.dependencyId = dependencyId;
    }
    
}
