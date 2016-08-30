package com.ideamoment.ideatesting.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by zhangzhonghua on 2016/8/30.
 */
public class ExcelUtils {
    /**
     * 获取excel的Workbook
     * @throws IOException
     */
    public static Workbook getExcelWorkbook(String filePath) throws IOException {
        Workbook book = null;
        File file  = null;
        FileInputStream fis = null;

        try {
            file = new File(filePath);
            if(!file.exists()){
                throw new RuntimeException("文件不存在");
            }else{
                fis = new FileInputStream(file);
                book = WorkbookFactory.create(fis);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if(fis != null){
                fis.close();
            }
        }
        return book;
    }

    public static void main(String[] args) {
        String filePath = "D:\\testImport.xlsx";
        try {
            Workbook wb = getExcelWorkbook(filePath);
            System.out.println("Sheet 页数：" + wb.getNumberOfSheets());
            Sheet sheet = wb.getSheetAt(0);
            String name = sheet.getSheetName();
            System.out.println("Sheet 0 名称：" + name);
            System.out.println("Sheet 0 行数：" + sheet.getPhysicalNumberOfRows());
            System.out.println("Sheet 0 第一行行号：" + sheet.getFirstRowNum());
            System.out.println("Sheet 0 最后一行行号：" + sheet.getLastRowNum());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
