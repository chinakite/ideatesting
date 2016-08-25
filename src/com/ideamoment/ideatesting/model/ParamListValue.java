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
@Entity(dataSet="T_PARAM_LIST")
public class ParamListValue extends HistoriableEntity {
	@Property(dataItem="C_PARAM_ID", type=DataItemType.VARCHAR, length=32)
	private String paramId;
	
	@Property(dataItem="C_VALUE", type=DataItemType.VARCHAR, length=1000)
	private String value;

	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
