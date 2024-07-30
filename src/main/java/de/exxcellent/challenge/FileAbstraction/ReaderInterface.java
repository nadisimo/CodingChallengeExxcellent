package de.exxcellent.challenge.FileAbstraction;

import java.util.Set;

/**
 * Interface for readers that read data from a given file.
 */
public interface ReaderInterface {
    /**
     * get the labels or fields of the data.
     *
     * @return labels of data
     */
    Set<String> getLabels();

    /**
     * get all values of a specific label. Can be a "column" of a table.
     * @param label
     * @return values of the label
     */
    String[] getValues(String label);

    /**
     * Is only applicable for data structured in tables and returns a specific "row".
     * @param index
     * @return
     */
    String[] getRow(int index);

    /**
     * get the value of a specific element of the data
     * @param index
     * @param label
     * @return
     */
    String getElement(int index, String label);
}
