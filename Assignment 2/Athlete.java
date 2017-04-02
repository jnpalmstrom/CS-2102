// Jack Palmstrom           ccc username: jnpalmstrom
// Haiau Duong              ccc username: hkduong

import java.util.LinkedList;

class Athlete {

    // Problem 2
    // Added a name field with type String to the Athlete class
    String name;
    BiathlonResult Biathlon;
    CyclingResult Cycling;

    Athlete(String name, BiathlonResult Biathlon, CyclingResult Cycling) {
        this.name = name;
        this.Biathlon = Biathlon;
        this.Cycling = Cycling;
    }

    public double totalScore() {
        return Cycling.pointsEarned() + Biathlon.pointsEarned();
    }

    public boolean hasBeaten(Athlete otherAthlete) {
        return this.totalScore() < otherAthlete.totalScore();
    }

    public Athlete betterCyclist1(Athlete participant) {
        if (Cycling.position < participant.Cycling.position) {
            return this;
        } else
            return participant;
    }

    public Athlete betterCyclist2(Athlete participant) {
        if (this.helper(participant) == true) {
            return this;
        } else
            return participant;
    }

    public boolean helper(Athlete participant) {
        return (Cycling.position < participant.Cycling.position);
    }
}
// Problem 3
// Creates a class Competition, which contains a list of athletes and an integer representing the number of BiathlonRounds

class Competition {
    LinkedList<Athlete> aloa = new LinkedList<Athlete>();
    int numRounds;

    Competition(LinkedList<Athlete> aloa, int numRounds) {

        this.aloa = aloa;
        this.numRounds = numRounds;
    }

    // Problem 7
    // Method BiathlonDNF produces a LinkedList of all Athletes in the competition
    // whose list of BiathlonRounds is less than the number of rounds stored in Competition

    public LinkedList<Athlete> BiathlonDNF() {

        LinkedList<Athlete> dnfAthletes = new LinkedList<Athlete>();

        for (Athlete r : aloa) {
            if (r.Biathlon.alor.size() < this.numRounds) {
                dnfAthletes.add(r);
            }
        }
        return dnfAthletes;
    }

    // Problem 8
    // Method scoreForAthlete, takes name of athlete and returns the total score of the athlete.

    public double scoreForAthlete(String athleteName) {

        double newScore = 0;

        for (Athlete r : aloa) {
            if (athleteName == r.name) {
                newScore = r.totalScore();
            }
        }
        return newScore;
    }


    // Problem 9
    // countCyclingImproved takes Competition as input and returns the number of athletes
    // whose pointsEarned in cycling was less than the given competition.

    public int countCyclingImproved(Competition newComp) {

        int countCyclist = 0;

        for (Athlete ath1 : aloa) {

            for (Athlete ath2 : newComp.aloa) {

                if ((ath1.name == ath2.name) && (ath1.Cycling.pointsEarned() < ath2.Cycling.pointsEarned())) {
                    countCyclist = countCyclist + 1;
                }
            }
        }
        return countCyclist;
    }

    // Problem 10

        /* In hindsight, a helper method that evaluated the current name of an athlete
         * in a list versus the inputted athlete could have been shared over the two
         * problems.Because we would be able to use the helpr function for both problems,
        * this would condense the code and increase the readability of the code.
        */
}


class CyclingResult implements IEvent {
    double time;
    int position;

    CyclingResult(double time, int position) {
        this.time = time;
        this.position = position;
    }

    public double pointsEarned() {
        if (this.position == 1) {                   //First Place
            return this.time - 10;
        } else if (this.position == 2) {            //Second Place
            return this.time - 7;
        } else if (this.position == 3) {            //Third Place
            return this.time - 3;
        } else
            return this.time;                       //Fourth Place to Nth Place
    }
}

// Problem 3
// Creates BiathlonResult that stores three BiathlonRound objects

class BiathlonResult implements IEvent {

    LinkedList<BiathlonRound> alor = new LinkedList<BiathlonRound>();

    BiathlonResult(LinkedList<BiathlonRound> alor) {
        this.alor = alor;
    }

    // Problem 5
    // Calculates the pointsEarned for each athlete in the Biathlon

    public double pointsEarned() {
        double count = 0;

        for (BiathlonRound r : alor) {
            count = count + r.roundPoints();
        }
        return count;
    }

    // Problem 6
    // Returns the best round in the list

    public BiathlonRound bestRound() {

        BiathlonRound bestRoundSoFar = alor.get(0);

        for (BiathlonRound r : alor) {
            if (r.roundPoints() <= bestRoundSoFar.roundPoints()) {
                bestRoundSoFar = r;
            }
        }
        return bestRoundSoFar;
    }

}

class BiathlonRound {
    int targetsHit;
    double time;

    BiathlonRound(int targetsHit, double time) {
        this.targetsHit = targetsHit;
        this.time = time;
    }

    public double roundPoints() {
        return this.time + 60 * (5 - this.targetsHit);
    }
}

// Problem 1
// Creates class Marathon result which has a finishing time and position

class MarathonResult implements IEvent {
    double time;
    int position;

    MarathonResult(double time, int position) {
        this.time = time;
        this.position = position;
    }

    // Calculates the points earned by an athlete in a marathon

    public double pointsEarned() {
        return this.time;
    }
}