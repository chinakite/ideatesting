package com.ideamoment.ideatesting.datapool.controller;

/**
 * Created by zhangzhonghua on 2016/8/31.
 */
public class ExcelCell {
	
	private Integer column = null;
    
    private Object value = null;
    
    private Integer dataType = ExcelCellDataType.STRING;
    
    private String prompt = null;
    
    private String[] combo = null;

    private boolean identify = false;
    
    /**
     * @return the column
     */
    public Integer getColumn() {
    
        return column;
    }

    
    /**
     * @param column the column to set
     */
    public void setColumn(Integer column) {
    
        this.column = column;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * @return the prompt
     */
    public String getPrompt() {
        return prompt;
    }
    
    /**
     * @param prompt the prompt to set
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    
    /**
     * @return the combo
     */
    public String[] getCombo() {
        return combo;
    }
    
    /**
     * @param combo the combo to set
     */
    public void setCombo(String[] combo) {
        this.combo = combo;
    }

    public Integer getDataType() {

        return dataType;
    }

    public void setDataType(Integer dataType) {

        this.dataType = dataType;
    }


	public boolean isIdentify() {
		return identify;
	}


	public void setIdentify(boolean identify) {
		this.identify = identify;
	}


}
