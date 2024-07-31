package de.exxcellent.challenge.FileAbstraction;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class to read csv files.
 */
public class CsvReader implements ReaderInterface {
    List<String> headerNames;
    File file;
    List<CSVRecord> csvRecords;

    public CsvReader(String csvFilePath) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(csvFilePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            this.csvRecords = csvParser.getRecords();
            this.headerNames = csvParser.getHeaderNames();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets all labels of the csv file.
     *
     * @return labels
     */
    @Override
    public ArrayList<String> getLabels() {
        return new ArrayList<>(headerNames);
    }

    /**
     * Gets all values of the given label (column).
     *
     * @param label
     * @return values of column
     */
    @Override
    public ArrayList<String> getValues(String label) {
        ArrayList<String> values = new ArrayList<>();
        try {
            for (CSVRecord record : csvRecords) {
                String value = record.get(label);
                values.add(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return values;
    }

    /**
     * Returns values of the required row as Map. The corresponding labels are they keys.
     * @param index
     * @return values of row
     */
    @Override
    public HashMap<String, String> getRow(int index) {
        HashMap<String, String> values = new HashMap<>();
        CSVRecord record = csvRecords.get(index);
        for (String label : headerNames)
            values.put(label, record.get(label));
        return values;
    }

    /**
     * Gets the element of the given row and label.
     * @param row
     * @param label
     * @return value
     */
    @Override
    public String getElement(int row, String label) {
        CSVRecord record = csvRecords.get(row);
        return record.get(label);
    }
}
