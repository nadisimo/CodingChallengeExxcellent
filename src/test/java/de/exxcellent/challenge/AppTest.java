package de.exxcellent.challenge;

import de.exxcellent.challenge.Application.FootballDataAccess;
import de.exxcellent.challenge.Application.WeatherDataAccess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {


    @BeforeEach
    void setUp() {

    }

    @Test
    void testFootballDataAccess() throws Exception {
        // Preparation
        FootballDataAccess footballDataAccess = new FootballDataAccess("de/exxcellent/challenge/football.csv");

        // Execution
        String team = footballDataAccess.teamSmallestDifference();

        // Assertation
        assertEquals("Aston_Villa", team);
    }

    @Test
    void testWeatherDataAccess() throws Exception {
        // Preparation
        WeatherDataAccess weatherDataAccess = new WeatherDataAccess("de/exxcellent/challenge/weather.csv");

        // Execution
        String day = weatherDataAccess.getDaySmallestTempSpread();

        // Assertation
        assertEquals("14", day);
    }

}