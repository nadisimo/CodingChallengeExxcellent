package de.exxcellent.challenge;

import de.exxcellent.challenge.Application.FootballDataAccess;
import de.exxcellent.challenge.Application.WeatherDataAccess;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Nadine Simon <nadine.simon@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     */
    public static void main() throws Exception {
        WeatherDataAccess weatherDataAccess = new WeatherDataAccess("de/exxcellent/challenge/weather.csv");
        FootballDataAccess footballDataAccess = new FootballDataAccess("de/exxcellent/challenge/football.csv");

        System.out.println("Day with the smallest temperature spread: " + weatherDataAccess.getDaySmallestTempSpread());
        System.out.println("Team with the smallest difference between goals and allowed goals: "
                + footballDataAccess.teamSmallestDifference());
    }
}
