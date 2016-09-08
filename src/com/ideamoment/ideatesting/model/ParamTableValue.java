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
@Entity(dataSet="T_PARAM_TABLE")
public class ParamTableValue extends HistoriableEntity {
	@Property(dataItem="C_PARAM_ID", type=DataItemType.VARCHAR, length=32)
	private String paramId;
	
	@Property(dataItem="C_COLUMN", type=DataItemType.VARCHAR, length=300)
	private String column;
	
	@Property(dataItem="C_VALUE", type=DataItemType.VARCHAR, length=1000)
	private String value;
	
	@Property(dataItem="C_ROW_NO", type=DataItemType.INT)
	private int rowNo;

	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	
}
