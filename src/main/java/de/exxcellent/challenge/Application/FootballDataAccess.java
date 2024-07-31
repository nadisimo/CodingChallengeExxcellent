package de.exxcellent.challenge.Application;

public class FootballDataAccess extends DataAccess implements FootballDataAccessInterface{
    public FootballDataAccess(String filePath) throws Exception{
        super(filePath);
    }

    /**
     * determines the team with the smallest difference between goals and allowed goals.
     * @return
     * @throws Exception
     */
    @Override
    public String teamSmallestDifference() throws Exception {
        int rowSmallestDifference = rowSmallestDifference("Goals", "Goals Allowed");
        return reader.getElement(rowSmallestDifference, "Team");
    }
}
