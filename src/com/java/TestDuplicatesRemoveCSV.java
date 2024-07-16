package com.java;

import org.apache.commons.csv.*;

import java.io.*;
import java.util.*;

public class TestDuplicatesRemoveCSV {
    public static void main(String[] args) {

        List<String> fileNames = getFileNamesLst();

        for(String fileName : fileNames){
            try {
                String inputFilePath = "/Users/mmahalingam/Work/Learning-Workshop/AuditReport/"+fileName;
                String outputFilePath = "/Users/mmahalingam/Work/Learning-Workshop/AuditReport_New/"+fileName;
                String columnToCheck = "Message";
                int linesToRead = 3;
                // Read input CSV file
                Reader reader1 = new FileReader(inputFilePath);
                CSVParser csvParser1 = new CSVParser(reader1, CSVFormat.DEFAULT);

                Reader reader = new FileReader(inputFilePath);
                BufferedReader bufferedReader = new BufferedReader(reader);
                bufferedReader.readLine();
                bufferedReader.readLine();

                CSVParser csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withHeader().withSkipHeaderRecord().withTrim());

                Set<String> uniqueValues = new HashSet<>();
                List<CSVRecord> uniqueRecords = new ArrayList<>();

                for (CSVRecord record : csvParser) {
                    String valueInColumn = record.get(columnToCheck);
                    if(record.get("RemoteIP").equals("SPARK") || record.get("Action").equals("PAUSE")){
                        if (!uniqueValues.contains(valueInColumn)) {
                            uniqueValues.add(valueInColumn);
                            uniqueRecords.add(record);
                        }
                    } else {
                        uniqueRecords.add(record);
                    }
                }

                Writer writer = new FileWriter(outputFilePath);
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
                System.out.println("uniqueRecords "+uniqueRecords.size());

                int linesRead = 0;
                for (CSVRecord record : csvParser1) {
                    if (linesRead < linesToRead) {
                        csvPrinter.printRecord(record);
                        linesRead++;
                    } else {
                        break;
                    }
                }

                for (CSVRecord record : uniqueRecords) {
                    csvPrinter.printRecord(record);
                }
                csvParser1.close();
                csvParser.close();
                csvPrinter.close();
                System.out.println("Duplicate rows removed successfully for "+fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> getFileNamesLst(){
        List list = new ArrayList();
        list.add("Auditing_Report_2024-01-17 17.29.11.373.csv");
        list.add("Auditing_Report_2024-01-20 00.00.00.143.csv");
        list.add("Auditing_Report_2024-01-19 00.00.00.124.csv");
        list.add("Auditing_Report_2024-01-22 00.00.00.143.csv");
        list.add("Auditing_Report_2024-01-21 00.00.00.211.csv");
        list.add("Auditing_Report_2024-01-28 00.00.00.119.csv");
        list.add("Auditing_Report_2024-01-27 00.00.00.132.csv");
        list.add("Auditing_Report_2024-01-26 00.00.00.172.csv");
        list.add("Auditing_Report_2024-01-25 00.00.00.118.csv");
        list.add("Auditing_Report_2024-01-24 00.00.00.125.csv");
        list.add("Auditing_Report_2024-01-23 00.00.00.134.csv");
        list.add("Auditing_Report_2024-01-18 00.00.00.124.csv");
        return list;
    }
}

