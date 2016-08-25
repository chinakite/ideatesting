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
@Entity(dataSet="T_PARAM")
public class Param extends HistoriableEntity {
	
	@Property(dataItem="C_NAME", type=DataItemType.VARCHAR, length=300)
    private String name;
    
    @Property(dataItem="C_PROJECT_ID", type=DataItemType.VARCHAR, length=32)
    private String projectId;
    
    @Property(dataItem="C_DESC", type=DataItemType.VARCHAR, length=420)
    private String desc;
    
    @Property(dataItem="C_VALUE", type=DataItemType.VARCHAR, length=1000)
    private String value;
    
    @Property(dataItem="C_TYPE", type=DataItemType.VARCHAR, length=2)
    private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
