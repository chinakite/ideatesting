package com.ideamoment.ideatesting.datapool.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzhonghua on 2016/8/31.
 */
public class ExcelData {
	
    private List<ExcelSheet> sheets = new ArrayList<ExcelSheet>();

    public int getSheetCount() {
    	return sheets.size();
    }
    
    public void addExcelSheet(ExcelSheet sheet) {
        this.sheets.add(sheet);
    }
    
    public List<ExcelSheet> getSheets() {
    	return this.sheets;
    }

}
