package com.sunwx.springboot.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Excel文档工具类
 * */
public class ExcelUtil {

    public static String getValue(Cell hssfCell) {
        DecimalFormat df = new DecimalFormat("#");
        if (hssfCell == null)
            return "";
        switch (hssfCell.getCellType()) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                if(HSSFDateUtil.isCellDateFormatted(hssfCell)){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    return sdf.format(HSSFDateUtil.getJavaDate(hssfCell.getNumericCellValue())).toString();
                }
                return df.format(hssfCell.getNumericCellValue());
            case HSSFCell.CELL_TYPE_STRING:
                return hssfCell.getStringCellValue();
            case HSSFCell.CELL_TYPE_FORMULA:
                return hssfCell.getCellFormula();
            case HSSFCell.CELL_TYPE_BLANK:
                return "";
            case HSSFCell.CELL_TYPE_BOOLEAN:
                return hssfCell.getBooleanCellValue() + "";
            case HSSFCell.CELL_TYPE_ERROR:
                return hssfCell.getErrorCellValue() + "";
        }
        return "";
    }

}
