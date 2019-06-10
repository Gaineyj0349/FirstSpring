package com.gainey.exceltojson.Objects;

import com.gainey.exceltojson.DataStructures.BasicRow;
import com.gainey.exceltojson.DataStructures.BasicRow;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class SheetDataExtractor {

    public ArrayList<BasicRow> extract(String[] columnNames, Sheet sheet){
        ArrayList<BasicRow> rowEntities = new ArrayList<>();
        BasicRow basicRow;
        for(int i = 1; i<sheet.getPhysicalNumberOfRows(); i++){
            basicRow = new BasicRow();
            for(int j = 0; j<columnNames.length; j++){
                basicRow.getEntity().put(columnNames[j],CellData.valueIn(sheet.getRow(i).getCell(j)));
            }
            rowEntities.add(basicRow);
        }
        return rowEntities;
    }
}
