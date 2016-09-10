package com.ideamoment.ideatesting.datapool.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzhonghua on 2016/8/31.
 */
public class DataRow {
	
	private int             maxColumnNo = 0;
	
	private int             rowNo;
    
    /**
     * 单元格列表
     */
    private List<DataCell> cells = new ArrayList<DataCell>();
    
    /**
     * 是否表头
     */
    private boolean header = false;
    
    public List<DataCell> getCells() {
        return this.cells;
    }
    
    public DataCell getCell(int i) {
        if(cells == null || cells.size() == 0) {
            return null;
        }else{
            return cells.get(i);
        }
    }
    
    public int getCellCount() {
        if(cells == null) {
            return 0;
        }else{
            return cells.size();
        }
    }
    
    public void addDataCell(DataCell cell) {

        if (cell != null) {
            if (cell.getColumn() > maxColumnNo) {
                maxColumnNo = cell.getColumn();
            }
        }
        this.cells.add(cell);
    }

    public void addDataCells(List<DataCell> cellList) {

        if (cellList != null) {
            for (DataCell cell : cellList) {
                addDataCell(cell);
            }
        }
    }

    /**
     * @return the header
     */
    public boolean isHeader() {
        return header;
    }
    
    /**
     * @param header the header to set
     */
    public void setHeader(boolean header) {
        this.header = header;
    }

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNum) {
		this.rowNo = rowNum;
	}

}
