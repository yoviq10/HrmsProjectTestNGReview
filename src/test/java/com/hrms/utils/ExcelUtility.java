package com.hrms.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtility {

    static Workbook book;
    static Sheet sheet;

    public static void openExcel(String filePath){
        try {
            FileInputStream fis=new FileInputStream(filePath);
        book=new XSSFWorkbook(fis);   //can access workbook
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    * @param sheetName
    */
    public static void getSheet(String sheetName){  //can access any sheet you need
        book.getSheet(sheetName);
}


    public static int getRowsCount(){   //make sure you change return type to int
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColsCount(int rowNum){  //need row numbers

        return sheet.getRow(rowNum).getPhysicalNumberOfCells();
    }


    public static String getData(int row, int col){  //get single data requires row and columns
        return sheet.getRow(row).getCell(col).toString();  //getting row/column &converting to String
    }

    public static List<Map<String, String>> excelDataToList(String filePath, String sheetName){
        openExcel(filePath);
        getSheet(sheetName);

        List<Map<String, String >> dataList= new ArrayList<>();

        Map<String,String> dataMap;

        for (int r = 1; r <getRowsCount(); r++) {   //based on # of rows
            dataMap=new LinkedHashMap<>();  //linkedHashMap maintains assertion order


            for (int c = 0; c <getRowsCount(); c++) { //based on # of columns we have
                dataMap.put(getData(0,c),getData(r,c));  //specify getData row & col>> getting keys & values
            }
            dataList.add(dataMap); //adding full dataMap to dataList
        }
            return dataList;
    }


}
