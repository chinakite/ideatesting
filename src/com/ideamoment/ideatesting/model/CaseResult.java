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
@Entity(dataSet="T_CASE_RESULT")
public class CaseResult extends HistoriableEntity {
	
	@Property(dataItem="C_CASE_NAME", type=DataItemType.VARCHAR, length=300)
	private String caseName;
	
	@Property(dataItem="C_SCRIPT_ID", type=DataItemType.VARCHAR, length=32)
	private String scriptId;
	
	@Property(dataItem="C_SCHEMA_ID", type=DataItemType.VARCHAR, length=32)
	private String schemaId;

	@Property(dataItem="C_SCHEMA_EXECUTION_ID", type=DataItemType.VARCHAR, length=32)
	private String schemaExecutionId;

	@Property(dataItem="C_RESULT", type=DataItemType.VARCHAR, length=2)
	private String result;

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getScriptId() {
		return scriptId;
	}

	public void setScriptId(String scriptId) {
		this.scriptId = scriptId;
	}

	public String getSchemaId() {
		return schemaId;
	}

	public void setSchemaId(String schemaId) {
		this.schemaId = schemaId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSchemaExecutionId() {
		return schemaExecutionId;
	}

	public void setSchemaExecutionId(String schemaExecutionId) {
		this.schemaExecutionId = schemaExecutionId;
	}
}
