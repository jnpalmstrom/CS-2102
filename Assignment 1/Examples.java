// Problem 9

import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    public Examples(){}
    //Athlete Objects examples for test cases
    Athlete athlete1 = new Athlete(new BiathlonResult (new BiathlonRound(5, 5), new BiathlonRound(5, 5), new BiathlonRound(5, 5)), new CyclingResult(56, 1));

    Athlete athlete2 = new Athlete(new BiathlonResult (new BiathlonRound(4, 10), new BiathlonRound(4, 11), new BiathlonRound(3, 12)), new CyclingResult(57, 2));

    Athlete athlete3 = new Athlete(new BiathlonResult (new BiathlonRound(3, 15), new BiathlonRound(2, 16), new BiathlonRound(4, 17)), new CyclingResult(58, 3));

    Athlete athlete4 = new Athlete(new BiathlonResult (new BiathlonRound(2, 20), new BiathlonRound(1, 25), new BiathlonRound(1, 30)), new CyclingResult(59, 4));

    Athlete athlete5 = new Athlete(new BiathlonResult (new BiathlonRound(1, 25), new BiathlonRound(2, 20), new BiathlonRound(1, 30)), new CyclingResult(60, 5));

    BiathlonRound fastRound = new BiathlonRound(5, 20);
    BiathlonResult newResult = new BiathlonResult(new BiathlonRound(2, 30), fastRound, new BiathlonRound(3, 20));


    // Tests hasBeatenEquals()

        @Test
        public void testHasBeatenEquals() {
            assertTrue(athlete1.hasBeaten(athlete2));
        }

    // Tests totalScore()

        @Test
        public void testTotalScore() {
            assertEquals(athlete1.totalScore(), 61, .01);
        }

    // Tests bestRound()

        @Test
        public void testBestRound() {
            assertEquals(fastRound, newResult.bestRound());
        }

    // Tests betterCyclist1()

        @Test
        public void testBetterCyclist1() {
            assertEquals(athlete1.betterCyclist1(athlete4), athlete1);
        }

    // Tests betterCyclist2()

        @Test
        public void testBetterCyclist2() {
        assertEquals(athlete3.betterCyclist2(athlete5), athlete3);
    }
}

