/**
 * 
 */
package com.ideamoment.ideatesting.model;

import com.ideamoment.ideadata.annotation.DataItemType;
import com.ideamoment.ideadata.annotation.Entity;
import com.ideamoment.ideadata.annotation.Property;
import com.ideamoment.ideatesting.model.dict.ParamTypeDict;

/**
 * @author Chinakite
 *
 */
@Entity(dataSet="T_PARAM")
public class Param extends HistoriableEntity {
	
	@Property(dataItem="C_NAME", type=DataItemType.VARCHAR, length=300)
    private String name;

	@Property(dataItem="C_VAR_NAME", type=DataItemType.VARCHAR, length=300)
	private String varName;
    
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

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
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

	public String getTypeText() {
		if(this.type.equals(ParamTypeDict.LIST)) {
			return ParamTypeDict.LIST_TEXT;
		}else if(this.type.equals(ParamTypeDict.TABLE)) {
			return ParamTypeDict.TABLE_TEXT;
		}else if(this.type.equals(ParamTypeDict.VALUE)) {
			return ParamTypeDict.VALUE_TEXT;
		}
		return "";
	}
}
