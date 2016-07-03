/**
 * 
 */
package com.ideamoment.ideatesting;

import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.util.DataTableSource;

/**
 * @author Chinakite
 *
 */
public class BaseController {
    
    protected DataTableSource convertToDataTableSource(int draw, Page pager){
        DataTableSource dts = new DataTableSource();
        
        dts.setDraw(draw);
        dts.setRecordsTotal(pager.getTotalRecord());
        dts.setRecordsFiltered(pager.getTotalRecord());
        dts.setData(pager.getData());
        
        return dts;
    }
}
