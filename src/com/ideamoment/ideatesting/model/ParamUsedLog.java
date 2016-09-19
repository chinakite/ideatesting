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
@Entity(dataSet="T_PARAM_USED_LOG")
public class ParamUsedLog extends HistoriableEntity {
	@Property(dataItem="C_PARAM_ID", type=DataItemType.VARCHAR, length=32)
	private String paramId;
	
	@Property(dataItem="C_SCHEMA_EXECUTION_ID", type=DataItemType.VARCHAR, length=32)
	private String schemaExecutionId;

	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	public String getSchemaExecutionId() {
		return schemaExecutionId;
	}

	public void setSchemaExecutionId(String schemaExecutionId) {
		this.schemaExecutionId = schemaExecutionId;
	}
	
	
}
