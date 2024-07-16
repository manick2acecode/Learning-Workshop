package com.java;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDuplicatesRemoveXLS {
    public static void main(String[] args) {

        List<String> fileNames = getFileNamesLst();

        try {

            for(String fileName : fileNames){

                String inputFilePath = "/Users/mmahalingam/Work/Learning-Workshop/AuditReport/"+fileName;
                String outputFilePath = "/Users/mmahalingam/Work/Learning-Workshop/AuditReport_New/"+fileName;
                String columnToCheck = "J";

                FileInputStream file = new FileInputStream(inputFilePath);
                Workbook workbook = WorkbookFactory.create(file);

                System.out.println("fileName "+fileName+" NumberOfSheets() "+workbook.getNumberOfSheets());

                FileOutputStream outputStream = new FileOutputStream(outputFilePath);
                Workbook newWorkbook = new HSSFWorkbook();

                for(int sheetIndex=0; sheetIndex<workbook.getNumberOfSheets(); sheetIndex++){
                    Sheet sheet = workbook.getSheetAt(sheetIndex);
                    CellValueMap uniqueValues = new CellValueMap();

                    Iterator<Row> rowIterator = sheet.iterator();
                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        Cell messageCell = row.getCell(getColumnIndex(columnToCheck));
                        Cell remoteIp = row.getCell(getColumnIndex("K"));
                        Cell action = row.getCell(getColumnIndex("H"));
                        if(remoteIp.getStringCellValue().equals("SPARK") || action.getStringCellValue().equals("PAUSE")) {
                            String cellValue = messageCell.getStringCellValue();
                            //System.out.println("cellValue "+cellValue);
                            if (!uniqueValues.containsKey(cellValue)) {
                                uniqueValues.put(cellValue, row);
                            }
                        } else {
                            uniqueValues.put(messageCell.getStringCellValue(), row);
                        }
                    }

                    Sheet newSheet = newWorkbook.createSheet();

                    int rowIndex = 0;
                    for (Row row : uniqueValues.values()) {
                        Row newRow = newSheet.createRow(rowIndex++);
                        for (int j = 0; j < row.getLastCellNum(); j++) {
                            Cell oldCell = row.getCell(j);
                            Cell newCell = newRow.createCell(j);
                            if (oldCell != null) {
                                CellType cellType = oldCell.getCellType();
                                newCell.setCellType(cellType);
                                switch (cellType) {
                                    case STRING:
                                        newCell.setCellValue(oldCell.getStringCellValue());
                                        break;
                                    case NUMERIC:
                                        newCell.setCellValue(oldCell.getNumericCellValue());
                                        break;
                                    // Handle other cell types as needed
                                }
                                newCell.setCellValue(oldCell.getStringCellValue());
//                            CellStyle styleSource = oldCell.getCellStyle();
//                            CellStyle styleDestination = newCell.getCellStyle();
//                            styleDestination.cloneStyleFrom(styleSource);
//                            newCell.setCellStyle(styleDestination);
                            }
                        }
                    }
                    newWorkbook.write(outputStream);
                    System.out.println("Duplicates removed successfully from sheet " + sheetIndex);
                }
                outputStream.close();
                workbook.close();
                newWorkbook.close();
                file.close();
            }
        } catch (IOException | EncryptedDocumentException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    // Helper method to get column index from column letter (A, B, C, etc.)
    private static int getColumnIndex(String columnLetter) {
        return columnLetter.toUpperCase().charAt(0) - 'A';
    }

    static class CellValueMap extends java.util.LinkedHashMap<String, Row> {
        @Override
        public Row put(String key, Row value) {
            if (!containsKey(key)) {
                return super.put(key, value);
            }
            return null;
        }
    }

    private static List<String> getFileNamesLst(){
        List<String> list = new ArrayList();
        //list.add("Auditing_Report_2024-01-17 16.25.51.288.xls");
        //list.add("Auditing_Report_2024-01-17 16.24.03.367.xls");
        list.add("Auditing_Report_2024-01-17 16.05.32.025.xls"); //3
        list.add("Auditing_Report_2024-01-17 00.05.00.061.xls"); //3
        list.add("Auditing_Report_2024-01-16 00.05.00.052.xls"); //3
        list.add("Auditing_Report_2024-01-15 00.05.00.055.xls"); //2
        //list.add("Auditing_Report_2024-01-14 00.05.00.067.xls");
        //list.add("Auditing_Report_2024-01-13 00.05.00.069.xls");
        list.add("Auditing_Report_2024-01-19 12.20.45.205.xls"); //3
        //list.add("Auditing_Report_2024-01-19 12.17.11.108.xls");
        //list.add("Auditing_Report_2024-01-19 12.16.04.142.xls");
        //list.add("Auditing_Report_2024-01-19 11.35.00.073.xls");
        //list.add("Auditing_Report_2024-01-28 12.56.00.050.xls");
        //list.add("Auditing_Report_2024-01-28 12.42.00.048.xls");
        //list.add("Auditing_Report_2024-01-28 12.37.00.052.xls");
        //list.add("Auditing_Report_2024-01-28 12.22.00.045.xls");
        //list.add("Auditing_Report_2024-01-28 11.56.00.059.xls");
        //list.add("Auditing_Report_2024-01-28 11.42.00.059.xls");
        //list.add("Auditing_Report_2024-01-28 11.22.00.045.xls");
        //list.add("Auditing_Report_2024-01-28 11.08.15.150.xls");
        list.add("Auditing_Report_2024-01-28 10.52.22.108.xls"); // 2
        return list;
    }
}
