package com.epam.javacore2019.steve.dbservice.data;

import com.epam.javacore2019.steve.dbservice.misc.DataHandler;
import com.epam.javacore2019.steve.dbservice.misc.Utils;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<TableRow> rows;
    private TableMetaData metaData;

    public Table(TableMetaData metaData) {
        this.metaData = metaData;
        rows = new ArrayList<>();
    }


    public void load() {
        Utils.readFileLineByLine(metaData.getPathToData(), new DataHandler() {
            @Override
            public void handleString(String line) {
                TableRow row = new TableRow();
                row.setValues(line);
                addRow(row);
            }
        });
//        System.out.println(this);
    }

    public void save() {

    }

    public void addRow(TableRow row) {
        rows.add(row);
    }


    public List<TableRow> getRows() {
        return rows;
    }

    public void setRows(List<TableRow> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        String result = "\n" + metaData.getTableName();
        result += "\nStructure file: " + metaData.getPathToStructure();
        result += "\nData file: " + metaData.getPathToStructure();
        result += "\n" + metaData.getColumns();
        result += "\nnumber of rows: " + rows.size();
        return result;
    }
}
