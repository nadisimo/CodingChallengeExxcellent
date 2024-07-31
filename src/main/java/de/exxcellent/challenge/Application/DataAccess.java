package de.exxcellent.challenge.Application;

import de.exxcellent.challenge.FileAbstraction.CsvReader;
import de.exxcellent.challenge.FileAbstraction.ReaderInterface;

import java.util.ArrayList;

public abstract class DataAccess {
    ReaderInterface reader;

    public DataAccess(String filePath) throws Exception {
        try {
            setReader(filePath);
        } catch (Exception e){
            throw new Exception("reading of file failed.", e);
        }
    }

    /**
     * compares to columns with each other and returns the row of the smallest difference.
     * @param label1
     * @param label2
     * @return smallestDifference
     * @throws Exception
     */
    public int rowSmallestDifference(String label1, String label2) throws Exception {
        ArrayList<String> column1 = reader.getValues(label1);
        ArrayList<String> column2 = reader.getValues(label2);
        Integer min = absoluteDifference(column1.get(0), column2.get(0));
        Integer rowMin = 0;
        Integer currentMin = 0;

        for(int row = 1; row < column1.size(); row++){
            String value1 = column1.get(row);
            String value2 = column2.get(row);

            currentMin = absoluteDifference(value1, value2);
            if(currentMin < min) {
                min = currentMin;
                rowMin = row;
            }
        }

        return rowMin;
    }

    Integer absoluteDifference(String value1, String value2) throws Exception {
        try {
            return Math.abs(Integer.parseInt(value1) - Integer.parseInt(value2));
        } catch (Exception e) {
            throw new Exception("unsupported data type, needs to be Integer.");
        }
    }

    void setReader(String filepath) throws Exception {
        if (filepath.endsWith(".csv"))
            reader = new CsvReader(filepath);
        else
            throw new Exception("Unsupported file format");
    }
}
