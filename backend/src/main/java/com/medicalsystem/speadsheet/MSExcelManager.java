package com.medicalsystem.speadsheet;

public class MSExcelManager implements SpeadsheetManager {

    private MSExcelImporter importer;

    @Override
    public void importToDB(String speadsheetFilePath) {
        importer.importToDB(speadsheetFilePath);
    }

    @Override
    public void exportFromDB(String spreadsheetFilePath) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
