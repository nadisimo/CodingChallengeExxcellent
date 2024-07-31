package de.exxcellent.challenge.Application;

public class FootballDataAccess extends DataAccess implements FootballDataAccessInterface{
    public FootballDataAccess(String filePath) throws Exception{
        super(filePath);
    }

    @Override
    public String teamSmallestDifference() throws Exception {
        int rowSmallestDifference = rowSmallestDifference("Goals", "Goals Allowed");
        return reader.getElement(rowSmallestDifference, "Team");
    }
}
