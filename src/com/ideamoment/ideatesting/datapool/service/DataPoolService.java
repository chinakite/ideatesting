package com.ideamoment.ideatesting.datapool.service;

import com.ideamoment.ideadp.appcontext.IdeaApplicationContext;
import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.datapool.DataPoolException;
import com.ideamoment.ideatesting.datapool.DataPoolExceptionCode;
import com.ideamoment.ideatesting.datapool.dao.DataPoolDao;
import com.ideamoment.ideatesting.model.Param;
import com.ideamoment.ideatesting.model.ParamTableValue;
import com.ideamoment.ideatesting.model.dict.ParamFileTypeDict;
import com.ideamoment.ideatesting.model.dict.ParamTypeDict;
import com.ideamoment.ideatesting.util.ExcelUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * Created by zhangzhonghua on 2016/8/29.
 */
@Service
public class DataPoolService {

    @Autowired
    private DataPoolDao dataPoolDao;

    @IdeaJdbcTx
    public Page<Param> pageProjectParams(int curPage, int pageSize, String projectId) {
        return dataPoolDao.pageQueryParamsByProjectId(curPage, pageSize, projectId);
    }

    @IdeaJdbcTx
    public void saveParam(String projectId, 
    					String name, 
    					String desc, 
    					String varName, 
    					String type, 
    					String value,
    					String fileType,
    					String fileUrl,
    					int sheetNo) {
        Date curTime = new Date();
        String curUserId = "1";

        Param param = new Param();
        param.setName(name);
        param.setDesc(desc);
        param.setProjectId(projectId);
        param.setType(type);
        param.setVarName(varName);
        param.setCreateTime(curTime);
        param.setCreatorId(curUserId);
        param.setModifyTime(curTime);
        param.setModifierId(curUserId);
        
        if(ParamTypeDict.VALUE.equals(type)) {
            param.setValue(value);
        }
        
        IdeaJdbc.save(param);
        
        if(ParamTypeDict.TABLE.equals(type)){
        	TableData tableData = parseTableDataFile(fileUrl, fileType);
        	saveTableData(tableData, sheetNo, param.getId(), curTime);
        }else if(ParamTypeDict.LIST.equals(type)){
        	parseListDataFile(fileUrl, type);
        }
        
    }

    @IdeaJdbcTx
    public TableData parseListDataFile(String fileUrl, String type) {
        if(ParamFileTypeDict.XLSX.equals(type) || ParamFileTypeDict.XLS.equals(type)) {
            String webRoot = IdeaApplicationContext.getInstance().getWebRoot();
            fileUrl = webRoot + fileUrl;

            try {
                TableData excelData = new TableData();

                Workbook wb = ExcelUtils.getExcelWorkbook(fileUrl);
                int sheetCount = wb.getNumberOfSheets();

                for(int i=0; i<sheetCount; i++) {
                    Sheet sheet = wb.getSheetAt(i);
                    String sheetName = sheet.getSheetName();

                    DataSheet excelSheet = new DataSheet();
                    excelSheet.setName(sheetName);
                    excelSheet.setSheetIndex(i);

                    int rowCount = sheet.getLastRowNum() + 1;
                    boolean isFirstRow = true;
                    for(int j=0; j<rowCount; j++) {
                        Row row = sheet.getRow(j);
                        DataRow excelRow = new DataRow();
                        excelRow.setRowNo(j);
                        
                        if(row != null) {
                            if(isFirstRow) {
                                excelRow.setHeader(true);
                            }

                            int cellCount = row.getLastCellNum();
                            boolean isFirstCell = true;
                            for(int k=0; k<cellCount; k++) {
                                Cell cell = row.getCell(k);
                                DataCell excelCell = new DataCell();
                                excelCell.setColumn(k);
                                
                                if(cell != null) {
                                    Object value = null;

                                    if(isFirstCell && !isFirstRow) {
                                        excelCell.setIdentify(true);
                                    }
                                    isFirstCell = false;

                                    int cellType = cell.getCellType();
                                    //TODO: 日期类型需要处理
                                    switch(cellType) {
                                        case Cell.CELL_TYPE_NUMERIC :
                                            double doubleVal = cell.getNumericCellValue();
                                            long longVal = Math.round(doubleVal);
                                            if(Double.parseDouble(longVal + ".0") == doubleVal){
                                                value = longVal;
                                            }else{
                                                value = doubleVal;
                                            }
                                            value = String.valueOf(value);
                                            break;
                                        case Cell.CELL_TYPE_BOOLEAN :
                                            boolean boolVal = cell.getBooleanCellValue();
                                            value = String.valueOf(boolVal);
                                            break;
                                        case Cell.CELL_TYPE_STRING :
                                            value = cell.getStringCellValue();
                                            break;
                                        case Cell.CELL_TYPE_BLANK :
                                            value = "";
                                            break;
                                        case Cell.CELL_TYPE_FORMULA :
                                            cell.setCellType(Cell.CELL_TYPE_STRING);
                                            value = cell.getStringCellValue();
                                            break;
                                        default :
                                            value = cell.getStringCellValue();
                                            break;
                                    }
                                    excelCell.setValue(value);
                                }
                                excelRow.addDataCell(excelCell);
                            }
                            isFirstRow = false;
                        }
                        excelSheet.addDataRow(excelRow);
                    }
                    excelData.addExcelSheet(excelSheet);
                }

                return excelData;
            } catch (IOException e) {
                e.printStackTrace();
                throw new DataPoolException(DataPoolExceptionCode.DATAFILE_ERROR, "Parse xlsx error.", e);
            }
        }
        return null;
    }
    
    @IdeaJdbcTx
    public TableData parseTableDataFile(String fileUrl, String type) {
        if(ParamFileTypeDict.XLSX.equals(type) || ParamFileTypeDict.XLS.equals(type)) {
            String webRoot = IdeaApplicationContext.getInstance().getWebRoot();
            fileUrl = webRoot + fileUrl;

            try {
                TableData excelData = new TableData();

                Workbook wb = ExcelUtils.getExcelWorkbook(fileUrl);
                int sheetCount = wb.getNumberOfSheets();

                for(int i=0; i<sheetCount; i++) {
                    Sheet sheet = wb.getSheetAt(i);
                    String sheetName = sheet.getSheetName();

                    DataSheet dataSheet = new DataSheet();
                    dataSheet.setName(sheetName);
                    dataSheet.setSheetIndex(i);

                    int rowCount = sheet.getLastRowNum() + 1;

                    //处理Header
                    Row firstRow = sheet.getRow(0);
                    DataRow headerRow = new DataRow();
                    headerRow.setHeader(true);
                    parseDataCells(firstRow, headerRow);
                    dataSheet.setHeaderRow(headerRow);

                    for(int j=1; j<rowCount; j++) {
                        Row row = sheet.getRow(j);
                        DataRow dataRow = new DataRow();
                        dataRow.setRowNo(j);
                        
                        if(row != null) {
                            parseDataCells(row, dataRow);
                        }
                        dataSheet.addDataRow(dataRow);
                    }
                    excelData.addExcelSheet(dataSheet);
                }

                return excelData;
            } catch (IOException e) {
                e.printStackTrace();
                throw new DataPoolException(DataPoolExceptionCode.DATAFILE_ERROR, "Parse xlsx error.", e);
            }
        }
        return null;
    }

	/**
	 * @param row
	 * @param dataRow
	 */
	private void parseDataCells(Row row, DataRow dataRow) {
		int cellCount = row.getLastCellNum();
		for(int k=0; k<cellCount; k++) {
			DataCell dataCell = new DataCell();
		    Cell cell = row.getCell(k);
		    dataCell.setColumn(k);
		    if(cell != null) {
		        Object value = null;

		        //TODO: 此处应替换为唯一索引接口
		        if(k == 0 && !dataRow.isHeader()) {
		        	dataCell.setIdentify(true);
		        }
		        
		        int cellType = cell.getCellType();
		        //TODO: 日期类型需要处理
		        switch(cellType) {
		            case Cell.CELL_TYPE_NUMERIC :
		                double doubleVal = cell.getNumericCellValue();
		                long longVal = Math.round(doubleVal);
		                if(Double.parseDouble(longVal + ".0") == doubleVal){
		                    value = longVal;
		                }else{
		                    value = doubleVal;
		                }
		                value = String.valueOf(value);
		                dataCell.setDataType(DataCellDataType.NUMBER);
		                break;
		            case Cell.CELL_TYPE_BOOLEAN :
		                boolean boolVal = cell.getBooleanCellValue();
		                value = String.valueOf(boolVal);
		                dataCell.setDataType(DataCellDataType.BOOLEAN);
		                break;
		            case Cell.CELL_TYPE_STRING :
		                value = cell.getStringCellValue();
		                dataCell.setDataType(DataCellDataType.STRING);
		                break;
		            case Cell.CELL_TYPE_BLANK :
		                value = "";
		                dataCell.setDataType(DataCellDataType.STRING);
		                break;
		            case Cell.CELL_TYPE_FORMULA :
		                cell.setCellType(Cell.CELL_TYPE_STRING);
		                value = cell.getStringCellValue();
		                dataCell.setDataType(DataCellDataType.STRING);
		                break;
		            default :
		                value = cell.getStringCellValue();
		                dataCell.setDataType(DataCellDataType.STRING);
		                break;
		        }
		        dataCell.setValue(value);
		    }
		    dataRow.addDataCell(dataCell);
		}
	}

    @IdeaJdbcTx
    public void saveTableData(TableData tableData, int sheetNo, String paramId, Date curTime) {
    	String curUserId = "1";
    	
    	DataSheet sheet = tableData.getSheet(sheetNo);
    	DataRow header = sheet.getHeaderRow();
    	for(int j=0; j<header.getCellCount(); j++) {
    		DataCell cell = header.getCell(j);
            ParamTableValue tableValue = new ParamTableValue();
            tableValue.setRowNo(-1);
            tableValue.setCellNo(j);
            tableValue.setValue(cell.getValue().toString());
            tableValue.setParamId(paramId);
            tableValue.setColumn(cell.getValue().toString());
            tableValue.setCreateTime(curTime);
            tableValue.setCreatorId(curUserId);
            tableValue.setModifierId(curUserId);
            tableValue.setModifyTime(curTime);
            IdeaJdbc.save(tableValue);
    	}
    	
    	for(int i=0; i<sheet.getRowCount(); i++) {
            DataRow row = sheet.getRow(i);
            for(int j=0; j<row.getCellCount(); j++) {
                DataCell cell = row.getCell(j);
                ParamTableValue tableValue = new ParamTableValue();
                tableValue.setRowNo(i);
                tableValue.setCellNo(j);
                tableValue.setValue(cell.getValue().toString());
                tableValue.setParamId(paramId);
                tableValue.setColumn(header.getCell(j).getValue().toString());
                tableValue.setCreateTime(curTime);
                tableValue.setCreatorId(curUserId);
                tableValue.setModifierId(curUserId);
                tableValue.setModifyTime(curTime);
                IdeaJdbc.save(tableValue);
            }
        }
    }
    
    public static void main(String[] args) {
        DataPoolService dps = new DataPoolService();
        TableData data = dps.parseTableDataFile("D:\\testImport.xlsx", "0");
        System.out.println(data);
    }

    @IdeaJdbcTx
	public Param findParam(String paramId) {
		return IdeaJdbc.find(Param.class, paramId);
	}

    @IdeaJdbcTx
	public List<ParamTableValue> listParamTableHeader(String paramId) {
		List<ParamTableValue> cells = dataPoolDao.listParamTableHeader(paramId);
		return cells;
	}

    @IdeaJdbcTx
	public List<ParamTableValue> listParamTableValues(String paramId) {
    	List<ParamTableValue> cells = dataPoolDao.listParamTableValues(paramId);
		return cells;
	}

    @IdeaJdbcTx
	public Page pageParamTableValues(int curPage, int pageSize, String paramId) {
		List<ParamTableValue> cells = dataPoolDao.listParamTableValues(paramId, curPage-1, pageSize);

        Map<Integer, List<ParamTableValue>> tempResult = new HashMap<Integer, List<ParamTableValue>>();

        for(int i=0; i<cells.size(); i++) {
            ParamTableValue tableValue = cells.get(i);
            int rowNo = tableValue.getRowNo();
            List<ParamTableValue> row = tempResult.get(rowNo);
            if(row == null) {
                row = new ArrayList<ParamTableValue>();
                tempResult.put(rowNo, row);
            }
            row.add(tableValue);
        }

        List<List<ParamTableValue>> result = new ArrayList<List<ParamTableValue>>();
        for(Integer key : tempResult.keySet()) {
            result.add(tempResult.get(key));
        }

        Page page = new Page();
        page.setCurrentPage(curPage);
        page.setData(result);
        page.setPageSize(pageSize);
        int rowCount = dataPoolDao.countParamTableRow(paramId);
        page.setTotalRecord(rowCount);
		return page;
	}
}
