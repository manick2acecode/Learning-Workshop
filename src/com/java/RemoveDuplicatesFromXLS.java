package com.java;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicatesFromXLS {

    public static void main(String[] args) {
        String inputFile = "/Users/mmahalingam/Work/Learning-Workshop/AuditReport/Auditing_Report_2024-01-14 00.05.00.067.xls";
        String outputFile = "/Users/mmahalingam/Work/Learning-Workshop/AuditReport_New/Auditing_Report_2024-01-14 00.05.00.067-1.xls";
        int columnIndex = 9;
        int sheetIndex = 0;

        try {
            FileInputStream fis = new FileInputStream(inputFile);
            Workbook workbook = new HSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // Assuming you're working with the first sheet

            // Create a map to store unique values from the specified column
            Map<String, Integer> uniqueValues = new LinkedHashMap<>();

            // Iterate over each row and add unique values to the map
            for (Row row : sheet) {
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    String cellValue = cell.getStringCellValue();
                    if(("SPARK").equals(row.getCell(10).getStringCellValue()) || ("PAUSE").equals(row.getCell(7).getStringCellValue())) {
                        if (!uniqueValues.containsKey(cellValue)) {
                            uniqueValues.put(cellValue, row.getRowNum());
                        }
                    } else {
                        uniqueValues.put(cellValue, row.getRowNum());
                    }
                }
            }
            System.out.println("uniqueValues"+uniqueValues.toString());

            // Remove all rows from the sheet
            sheet.removeRow(sheet.getRow(0));
            // Write back the unique rows to the sheet
            int rowNum = 0;
            for (Integer rowIndex : uniqueValues.values()) {
                Row sourceRow = sheet.getRow(rowIndex);
                Row destinationRow = sheet.createRow(rowNum++);
                for (int colIndex = 0; colIndex < sourceRow.getLastCellNum(); colIndex++) {
                    Cell sourceCell = sourceRow.getCell(colIndex);
                    Cell destinationCell = destinationRow.createCell(colIndex);
                    if (sourceCell != null) {
                        destinationCell.setCellValue(sourceCell.getStringCellValue());
                    }
                }
            }

            // Write the modified data to a new Excel file
            FileOutputStream fos = new FileOutputStream(outputFile);
            workbook.write(fos);
            fos.close();
            //workbook.close();

            System.out.println("Duplicate rows removed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
