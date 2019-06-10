package com.gainey.exceltojson.DataStructures;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SheetInformation {

    @SerializedName("Sheet Name")
    String sheetName;

    @SerializedName("Number of Rows (including column titles)")
    int numberOfRows;

    @SerializedName("Number of Columns with Titles")
    int numberOfTitledColumns;

    @SerializedName("Column Titles")
    String columnTitles[];

    @SerializedName("Sheet Data")
    ArrayList<BasicRow> rowEntities;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public int getNumberOfTitledColumns() {
        return numberOfTitledColumns;
    }

    public void setNumberOfTitledColumns(int numberOfTitledColumns) {
        this.numberOfTitledColumns = numberOfTitledColumns;
    }

    public String[] getColumnTitles() {
        return columnTitles;
    }

    public void setColumnTitles(String[] columnTitles) {
        this.columnTitles = columnTitles;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public ArrayList<BasicRow> getRowEntities() {
        return rowEntities;
    }

    public void setRowEntities(ArrayList<BasicRow> rowEntities) {
        this.rowEntities = rowEntities;
    }
}
