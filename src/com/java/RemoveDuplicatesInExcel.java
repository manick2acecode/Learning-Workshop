package com.java;

public class RemoveDuplicatesInExcel {
//    public static void main(String[] args) {
//        String inputFilePath = "input.xlsx";
//        String outputFilePath = "output.xlsx";
//        int columnToCheck = 0; // Specify the column index to check for duplicates (0-based)
//
//        try {
//            FileInputStream fileInputStream = new FileInputStream(inputFilePath);
//            Workbook workbook = new XSSFWorkbook(fileInputStream);
//            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to process the first sheet
//
//            // Create a new workbook to store unique rows
//            Workbook newWorkbook = new XSSFWorkbook();
//            Sheet newSheet = newWorkbook.createSheet();
//
//            // Create a set to store unique values from the specified column
//            CellValueMap uniqueValues = new CellValueMap();
//
//            // Iterate through rows and identify unique rows based on the specified column
//            for (Row row : sheet) {
//                Cell cell = row.getCell(columnToCheck);
//                if (cell != null) {
//                    String cellValue = cell.toString();
//                    if (!uniqueValues.containsKey(cellValue)) {
//                        uniqueValues.put(cellValue, row);
//                    }
//                }
//            }
//
//            // Write unique rows to the new sheet
//            int rowIndex = 0;
//            for (Row row : uniqueValues.values()) {
//                Row newRow = newSheet.createRow(rowIndex++);
//                for (int i = 0; i < row.getLastCellNum(); i++) {
//                    Cell oldCell = row.getCell(i);
//                    Cell newCell = newRow.createCell(i);
//                    if (oldCell != null) {
//                        CellType cellType = oldCell.getCellType();
//                        newCell.setCellType(cellType);
//                        switch (cellType) {
//                            case STRING:
//                                newCell.setCellValue(oldCell.getStringCellValue());
//                                break;
//                            case NUMERIC:
//                                newCell.setCellValue(oldCell.getNumericCellValue());
//                                break;
//                            // Handle other cell types as needed
//                        }
//                    }
//                }
//            }
//
//            // Write the new workbook to a file
//            FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath);
//            newWorkbook.write(fileOutputStream);
//
//            // Close streams and workbooks
//            fileInputStream.close();
//            fileOutputStream.close();
//            workbook.close();
//            newWorkbook.close();
//
//            System.out.println("Duplicates removed successfully and saved to output file.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Custom map to maintain insertion order and handle duplicate keys
//    static class CellValueMap extends java.util.LinkedHashMap<String, Row> {
//        @Override
//        public Row put(String key, Row value) {
//            if (!containsKey(key)) {
//                return super.put(key, value);
//            }
//            return null;
//        }
//    }
}
