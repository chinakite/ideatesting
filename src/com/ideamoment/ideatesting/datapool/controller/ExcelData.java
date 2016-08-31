package com.ideamoment.ideatesting.datapool.controller;

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

}
