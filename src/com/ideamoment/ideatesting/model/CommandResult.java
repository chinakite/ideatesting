/**
 * 
 */
package com.ideamoment.ideatesting.model;

import com.ideamoment.ideadata.annotation.DataItemType;
import com.ideamoment.ideadata.annotation.Entity;
import com.ideamoment.ideadata.annotation.Property;
import com.ideamoment.ideatesting.model.dict.RunResultDict;

import java.util.Date;

/**
 * @author Chinakite
 *
 */
@Entity(dataSet="T_COMMAND_RESULT")
public class CommandResult extends HistoriableEntity {
	@Property(dataItem="C_CASE_RESULT_ID", type=DataItemType.VARCHAR, length=32)
	private String caseResultId;
	
	@Property(dataItem="C_RESULT", type=DataItemType.VARCHAR, length=2)
	private String result;
	
	@Property(dataItem="C_START_LINE", type=DataItemType.INT)
	private int startLine = 0;
	
	@Property(dataItem="C_END_LINE", type=DataItemType.INT)
	private int endLine = 0;
	
	@Property(dataItem="C_COMMAND_TEXT", type=DataItemType.VARCHAR, length=3000)
	private String commandText;
	
	@Property(dataItem="C_MESSAGE", type=DataItemType.VARCHAR, length=3000)
	private String message;

	@Property(dataItem="C_START_TIME", type= DataItemType.DATETIME)
	private Date startTime;

	@Property(dataItem="C_END_TIME", type= DataItemType.DATETIME)
	private Date endTime;

	public String getCaseResultId() {
		return caseResultId;
	}

	public void setCaseResultId(String caseResultId) {
		this.caseResultId = caseResultId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getStartLine() {
		return startLine;
	}

	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}

	public int getEndLine() {
		return endLine;
	}

	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	public String getCommandText() {
		return commandText;
	}

	public void setCommandText(String commandText) {
		this.commandText = commandText;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
	
	public String getResultText() {
		if(RunResultDict.SUCCESS.equals(this.result)) {
			return RunResultDict.SUCCESS_TEXT;
		}else if(RunResultDict.FAILED.equals(this.result)){
			return RunResultDict.FAILED_TEXT;
		}else{
			return "";
		}
	}
}
