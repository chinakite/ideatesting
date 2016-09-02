package com.ideamoment.ideatesting.datapool.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzhonghua on 2016/8/31.
 */
public class ExcelSheet {
	
	private String name;

	private int sheetIndex;
	
	private int maxRowNo = 0;

    private List<ExcelRow> rows = new ArrayList<ExcelRow>();

    public void addExcelRow(ExcelRow row) {
    	 if (row != null) {
             if (row.getRowNo() > maxRowNo) {
            	 maxRowNo = row.getRowNo();
             }
         }
        this.rows.add(row);
    }

    public void addExcelRows(List<ExcelRow> rowList) {

        if (rowList != null) {
            for (ExcelRow row : rowList) {
            	addExcelRow(row);
            }
        }
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

	public List<ExcelRow> getRows() {
		return rows;
	}

	public void setRows(List<ExcelRow> rows) {
		this.rows = rows;
	}

}
