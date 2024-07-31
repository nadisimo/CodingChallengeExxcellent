package de.exxcellent.challenge.Application;

public class WeatherDataAccess extends DataAccess implements WeatherDataAccessInterface {

    public WeatherDataAccess(String filePath) throws Exception {
        super(filePath);
    }

    /**
     * determines the day with the smallest temperature spread of the month.
     * @return
     * @throws Exception
     */
    @Override
    public String getDaySmallestTempSpread() throws Exception {
        int rowSmallestDifference = rowSmallestDifference("MxT", "MnT");
        return reader.getElement(rowSmallestDifference, "Day");
    }
}
