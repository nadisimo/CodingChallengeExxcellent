package de.exxcellent.challenge.Application;

public interface WeatherDataAccessInterface {
    /**
     * determines the day with the smallest temperature spread of the month.
     * @return
     * @throws Exception
     */
    String getDaySmallestTempSpread() throws Exception;
}
