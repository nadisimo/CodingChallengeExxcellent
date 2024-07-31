package de.exxcellent.challenge.Application;

public interface FootballDataAccessInterface {
    /**
     * determines the team with the smallest difference between goals and allowed goals.
     * @return
     * @throws Exception
     */
    String teamSmallestDifference() throws Exception;
}
