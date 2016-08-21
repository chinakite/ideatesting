package com.ideamoment.ideatesting.model;

import com.ideamoment.ideadata.annotation.DataItemType;
import com.ideamoment.ideadata.annotation.Entity;
import com.ideamoment.ideadata.annotation.Property;
import com.ideamoment.ideatesting.model.dict.RunStateDict;

import java.util.Date;

/**
 * Created by zhangzhonghua on 2016/8/19.
 */
@Entity(dataSet="T_SCHEMA_EXECUTION")
public class SchemaExecution extends HistoriableEntity {
    @Property(dataItem="C_SCHEMA_ID", type= DataItemType.VARCHAR, length=32)
    private String schemaId;

    @Property(dataItem="C_START_TIME", type= DataItemType.DATETIME)
    private Date startTime;

    @Property(dataItem="C_END_TIME", type= DataItemType.DATETIME)
    private Date endTime;
    
    @Property(dataItem="C_STATE", type= DataItemType.VARCHAR, length=2)
    private String state = RunStateDict.RUNNING;

	public String getSchemaId() {
		return schemaId;
	}

	public void setSchemaId(String schemaId) {
		this.schemaId = schemaId;
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
	
}
