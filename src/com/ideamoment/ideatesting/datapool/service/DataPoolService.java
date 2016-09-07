package com.ideamoment.ideatesting.datapool.service;

import com.ideamoment.ideadp.appcontext.IdeaApplicationContext;
import com.ideamoment.ideadp.restful.json.JsonData;
import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.datapool.DataPoolException;
import com.ideamoment.ideatesting.datapool.DataPoolExceptionCode;
import com.ideamoment.ideatesting.datapool.dao.DataPoolDao;
import com.ideamoment.ideatesting.model.Param;
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
import java.util.Date;

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
    public void saveParam(String projectId, String name, String desc, String varName, String type, String value) {
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
    }

    @IdeaJdbcTx
    public ExcelData parseDataFile(String fileUrl, String type) {
        if(ParamFileTypeDict.XLSX.equals(type) || ParamFileTypeDict.XLS.equals(type)) {
            String webRoot = IdeaApplicationContext.getInstance().getWebRoot();
            fileUrl = webRoot + fileUrl;

            try {
                ExcelData excelData = new ExcelData();

                Workbook wb = ExcelUtils.getExcelWorkbook(fileUrl);
                int sheetCount = wb.getNumberOfSheets();

                for(int i=0; i<sheetCount; i++) {
                    Sheet sheet = wb.getSheetAt(i);
                    String sheetName = sheet.getSheetName();

                    ExcelSheet excelSheet = new ExcelSheet();
                    excelSheet.setName(sheetName);
                    excelSheet.setSheetIndex(i);

                    int rowCount = sheet.getLastRowNum() + 1;
                    boolean isFirstRow = true;
                    for(int j=0; j<rowCount; j++) {
                        Row row = sheet.getRow(j);
                        ExcelRow excelRow = new ExcelRow();
                        excelRow.setRowNo(j);
                        
                        if(row != null) {
                            if(isFirstRow) {
                                excelRow.setHeader(true);
                            }

                            int cellCount = row.getLastCellNum();
                            boolean isFirstCell = true;
                            for(int k=0; k<cellCount; k++) {
                                Cell cell = row.getCell(k);
                                ExcelCell excelCell = new ExcelCell();
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
                                excelRow.addExcelCell(excelCell);
                            }
                            isFirstRow = false;
                        }
                        excelSheet.addExcelRow(excelRow);
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

    public static void main(String[] args) {
        DataPoolService dps = new DataPoolService();
        ExcelData data = dps.parseDataFile("D:\\testImport.xlsx", "0");
        System.out.println(data);
    }
}
