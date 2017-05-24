package com.medicalsystem.speadsheet;

public interface SpeadsheetManager {

    void importToDB(String speadsheetFilePath);

    void exportFromDB(String spreadsheetFilePath);

}
