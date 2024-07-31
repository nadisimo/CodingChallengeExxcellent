package de.exxcellent.challenge.FileAbstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CsvReaderTest {
    CsvReader csvReader;

    @BeforeEach
    void setUp() throws Exception {
        csvReader = new CsvReader("de/exxcellent/challenge/football.csv");
    }

    @Test
    void getLabels() {
        // Preparation
        ArrayList<String> labelsExpected = new ArrayList<>();
        labelsExpected.add("Team");
        labelsExpected.add("Games");
        labelsExpected.add("Wins");
        labelsExpected.add("Losses");
        labelsExpected.add("Draws");
        labelsExpected.add("Goals");
        labelsExpected.add("Goals Allowed");
        labelsExpected.add("Points");

        // Execution
        ArrayList<String> labels = csvReader.getLabels();

        // Assertation
        assertEquals(labelsExpected, labels);
    }

    @Test
    void getValues() {
        // Execution
        ArrayList<String> teams = csvReader.getValues("Team");

        // Assertation
        assertEquals("Arsenal", teams.get(0));
        assertEquals("Liverpool", teams.get(1));
        assertEquals("Leicester", teams.get(19));
    }

    @Test
    void getRow() {
        // Execution
        HashMap<String, String> row = csvReader.getRow(0);

        // Assertation
        assertEquals("Arsenal", row.get("Team"));
        assertEquals("38", row.get("Games"));
        assertEquals("87", row.get("Points"));
    }

    @Test
    void getElement() {
        // Execution
        String element = csvReader.getElement(0, "Team");

        // Assertation
        assertEquals("Arsenal", element);
    }
}