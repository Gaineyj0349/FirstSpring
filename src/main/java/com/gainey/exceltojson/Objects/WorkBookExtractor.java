package com.gainey.exceltojson.Objects;

import com.gainey.exceltojson.DataStructures.SheetInformation;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class WorkBookExtractor {

    private ArrayList<SheetInformation> sheets;
    private SheetDataExtractor sheetDataExtractor;

    public WorkBookExtractor(Workbook workbook) {

        sheets = new ArrayList<>();
        sheetDataExtractor = new SheetDataExtractor();

        bookExtract(workbook);
    }

    private void bookExtract(Workbook workbook) {
        int sheetCount = workbook.getNumberOfSheets();
        if(sheetCount == 0){
            return;
        }
        for(int i = 0; i< sheetCount; i++){
            sheets.add(sheetExtract(workbook.getSheetAt(i)));
        }
    }


    private SheetInformation sheetExtract(Sheet sheet) {
        SheetInformation tempSheetInformation = new SheetInformation();
        tempSheetInformation.setSheetName(sheet.getSheetName());
        tempSheetInformation.setColumnTitles(assignColumnTitles(sheet.getRow(0)));
        tempSheetInformation.setNumberOfTitledColumns(tempSheetInformation.getColumnTitles().length);
        tempSheetInformation.setNumberOfRows(sheet.getPhysicalNumberOfRows());
        tempSheetInformation.setRowEntities(sheetDataExtractor.extract(tempSheetInformation.getColumnTitles(),sheet));
        return tempSheetInformation;
    }

    private String[] assignColumnTitles(Row row) {
        String[] titles = new String[row.getLastCellNum()];
        for(int i = 0; i<titles.length; i++){
            titles[i] = String.valueOf(CellData.valueIn(row.getCell(i)));
        }
        return titles;
    }


    public String JSONresult(){
        String finalJsonString = convertListToJSON(sheets,SheetInformation.class);
      return finalJsonString;
    }

    private <T> String convertListToJSON(ArrayList listIn, Class<T> genericOfList){
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        String jsonReturnString = "";
        Type typeToken = new TypeToken<ArrayList<T>>(){}.getType();
        jsonReturnString = gson.toJson(listIn, typeToken);
        return jsonReturnString;
    }


}
