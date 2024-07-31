package de.exxcellent.challenge.FileAbstraction;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface for readers that read data from a given file.
 */
public interface ReaderInterface {
    /**
     * get the labels or fields of the data.
     *
     * @return labels of data
     */
    ArrayList<String> getLabels();

    /**
     * get all values of a specific label. Can be a "column" of a table.
     *
     * @param label
     * @return values of the label
     */
    ArrayList<String> getValues(String label);

    /**
     * Is only applicable for data structured in tables and returns a specific "row".
     *
     * @param index
     * @return
     */
    HashMap<String, String> getRow(int index);

    /**
     * get the value of a specific element of the data
     * @param index
     * @param label
     * @return
     */
    String getElement(int index, String label);
}
