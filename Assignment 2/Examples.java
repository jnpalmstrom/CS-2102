import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class Examples {

    // Example lists of BiathlonRounds and list of Athletes created

    LinkedList<BiathlonRound> athlete1Round = new LinkedList<>();
    LinkedList<BiathlonRound> athlete2Round = new LinkedList<>();
    LinkedList<BiathlonRound> athlete3Round = new LinkedList<>();
    LinkedList<BiathlonRound> athlete4Round = new LinkedList<>();
    LinkedList<BiathlonRound> athlete5Round = new LinkedList<>();
    LinkedList<Athlete> athleteList = new LinkedList<>();

    public Examples() {

        // Adds 3 rounds to athlete1Round

        athlete1Round.add(new BiathlonRound(5, 5));
        athlete1Round.add(new BiathlonRound(5, 5));
        athlete1Round.add(new BiathlonRound(5, 5));

        // Adds 1 rounds to athlete2Round

        athlete2Round.add(new BiathlonRound(4, 10));
        athlete2Round.add(new BiathlonRound(4, 11));
        athlete2Round.add(new BiathlonRound(3, 12));

        // Adds 3 rounds to athlete3Round

        athlete3Round.add(new BiathlonRound(3, 15));
        athlete3Round.add(new BiathlonRound(2, 16));
        athlete3Round.add(new BiathlonRound(4, 17));

        // Adds 3 rounds to athlete4Round

        athlete4Round.add(new BiathlonRound(2, 20));
        athlete4Round.add(new BiathlonRound(1, 25));
        athlete4Round.add(new BiathlonRound(1, 30));

        // Adds 3 rounds to athlete5Round

        athlete5Round.add(new BiathlonRound(1, 25));
        athlete5Round.add(new BiathlonRound(2, 20));
        athlete5Round.add(new BiathlonRound(1, 30));

        // Adds 5 athletes to athleteList

        athleteList.add(athlete1);
        athleteList.add(athlete2);
        athleteList.add(athlete3);
        athleteList.add(athlete4);
        athleteList.add(athlete5);
    }

    // Creates example objects for 5 BiathlonResults
    BiathlonResult round1 = new BiathlonResult(athlete1Round);
    BiathlonResult round2 = new BiathlonResult(athlete2Round);
    BiathlonResult round3 = new BiathlonResult(athlete3Round);
    BiathlonResult round4 = new BiathlonResult(athlete4Round);
    BiathlonResult round5 = new BiathlonResult(athlete5Round);


    // Creates example objects for 5 athletes

    Athlete athlete1 = new Athlete("Joe", round1, new CyclingResult(56, 1));
    Athlete athlete2 = new Athlete("Alex", round2, new CyclingResult(57, 2));
    Athlete athlete3 = new Athlete("Jack", round3, new CyclingResult(58, 3));
    Athlete athlete4 = new Athlete("Haiau", round4, new CyclingResult(59, 4));
    Athlete athlete5 = new Athlete("Nick", round5, new CyclingResult(60, 5));

    // Creates an example object for a Competition

    Competition realComp = new Competition(athleteList, 4);

// --------------------------------- Test Cases ------------------------------------------------------------------------

    // Tests pointsEarned() in BiathlonResult   ------Error on this test case-------
    @Test
    public void testPointsEarned() {
        assertEquals(round1.pointsEarned(), 15, .01);
    }

    // Tests bestRound() in the BiathlonResult  ------Error on this test case-------
    @Test
    public void testBestRound() {
        assertEquals(round5.bestRound(), athlete5Round.get(1));
    }

    // Tests BiathlonDNF() in Competition
    @Test
    public void testBiathlonDNF() {
        assertEquals(realComp.BiathlonDNF(), athleteList);
    }

    // Tests scoreForAthletes() in Competition
    @Test
    public void testScoreForAthlete() {
        assertEquals(realComp.scoreForAthlete("Joe"), 61, .01);
    }

    // Tests countCyclingImproved() in Competition
    @Test
    public void testCountCyclingImproved() {
        assertTrue(realComp.countCyclingImproved(realComp) == 0);
    }
}



