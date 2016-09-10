package com.ideamoment.ideatesting.datapool.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzhonghua on 2016/8/31.
 */
public class DataSheet {
	
	private String name;

	private int sheetIndex;
	
	private int maxRowNo = 0;

    private List<DataRow> rows = new ArrayList<DataRow>();

    public void addDataRow(DataRow row) {
    	 if (row != null) {
             if (row.getRowNo() > maxRowNo) {
            	 maxRowNo = row.getRowNo();
             }
         }
        this.rows.add(row);
    }

    public void addDataRows(List<DataRow> rowList) {

        if (rowList != null) {
            for (DataRow row : rowList) {
            	addDataRow(row);
            }
        }
    }

	public DataRow getRow(int rowIndex) {
		if(rowIndex >= this.rows.size()) {
			throw new IllegalArgumentException();
		}
		return this.rows.get(rowIndex);
	}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSheetIndex() {
		return sheetIndex;
	}

	public void setSheetIndex(int sheetIndex) {
		this.sheetIndex = sheetIndex;
	}

	public int getRowCount() {
		return rows.size();
	}

	public List<DataRow> getRows() {
		return rows;
	}

	public void setRows(List<DataRow> rows) {
		this.rows = rows;
	}

}
