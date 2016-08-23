package com.ideamoment.ideatesting.model;

import java.util.Date;

import com.ideamoment.ideadata.annotation.DataItemType;
import com.ideamoment.ideadata.annotation.Entity;
import com.ideamoment.ideadata.annotation.Property;
import com.ideamoment.ideadata.annotation.Ref;
import com.ideamoment.ideatesting.model.dict.RunStateDict;

/**
 * Created by zhangzhonghua on 2016/8/19.
 */
@Entity(dataSet="T_SCHEMA_EXECUTION")
public class SchemaExecution extends HistoriableEntity {
    @Property(dataItem="C_SCHEMA_ID", type= DataItemType.VARCHAR, length=32)
    private String schemaId;
    
    @Property(dataItem="C_PROJECT_ID", type= DataItemType.VARCHAR, length=32)
    private String projectId;

    @Property(dataItem="C_START_TIME", type= DataItemType.DATETIME)
    private Date startTime;

    @Property(dataItem="C_END_TIME", type= DataItemType.DATETIME)
    private Date endTime;
    
    @Property(dataItem="C_STATE", type= DataItemType.VARCHAR, length=2)
    private String state = RunStateDict.RUNNING;

    @Ref
    private RunSchema schema;
    
    
	public String getSchemaId() {
		return schemaId;
	}

	public void setSchemaId(String schemaId) {
		this.schemaId = schemaId;
	}
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getStateText() {
		if(RunStateDict.SUCCESS.equals(this.state)) {
			return RunStateDict.SUCCESS_TEXT;
		}else if(RunStateDict.FAILED.equals(this.state)) {
			return RunStateDict.FAILED_TEXT;
		}else if(RunStateDict.RUNNING.equals(this.state)) {
			return RunStateDict.RUNNING_TEXT;
		}else{
			return "";
		}
	}

	public RunSchema getSchema() {
		return schema;
	}

	public void setSchema(RunSchema schema) {
		this.schema = schema;
	}
	
	
	
}
