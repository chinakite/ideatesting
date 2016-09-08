package com.ideamoment.ideatesting.datapool.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzhonghua on 2016/8/31.
 */
public class TableData {
	
    private List<DataSheet> sheets = new ArrayList<DataSheet>();

    public int getSheetCount() {
    	return sheets.size();
    }
    
    public void addExcelSheet(DataSheet sheet) {
        this.sheets.add(sheet);
    }
    
    public List<DataSheet> getSheets() {
    	return this.sheets;
    }

    public DataSheet getSheet(int sheetNo) {
    	if(sheetNo >= this.sheets.size()) {
    		throw new IllegalArgumentException();
    	}
    	
    	return this.sheets.get(sheetNo);
    }
}
