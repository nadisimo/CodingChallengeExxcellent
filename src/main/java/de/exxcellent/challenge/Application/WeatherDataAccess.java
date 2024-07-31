package de.exxcellent.challenge.Application;

public class WeatherDataAccess extends DataAccess implements WeatherDataAccessInterface {

    public WeatherDataAccess(String filePath) throws Exception {
        super(filePath);
    }

    @Override
    public String getDaySmallestTempSpread() throws Exception {
        int rowSmallestDifference = rowSmallestDifference("MxT", "MnT");
        return reader.getElement(rowSmallestDifference, "Day");
    }
}
