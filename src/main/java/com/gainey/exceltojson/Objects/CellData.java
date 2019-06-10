package com.gainey.exceltojson.Objects;

import org.apache.poi.ss.usermodel.Cell;

public class CellData {
    public static Object valueIn(Cell cell){
        if(null == cell){
            return  "";
        }
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return cell.getRichStringCellValue().getString();
            case NUMERIC:
                return cell.getNumericCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            default:
                //TODO
                return "";
        }
    }
}
