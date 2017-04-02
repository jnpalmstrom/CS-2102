// Jack Palmstrom           ccc username: jnpalmstrom
// Haiau Duong              ccc username: hkduong

// Problem 1

//Creates an Athlete class with two fields

public class Athlete {

    BiathlonResult Biathlon;
    CyclingResult Cycling;

    Athlete(BiathlonResult Biathlon, CyclingResult Cycling) {
        this.Biathlon = Biathlon;
        this.Cycling = Cycling;
    }

    // Problem 6
    // Returns the total score for an Athlete adding the Cycling score and the Biathlon score

    public double totalScore() {
        return Cycling.pointsEarned() + Biathlon.pointsEarned();
    }

    // Problem 7
    // Takes an Athlete as input and returns a boolean indicating
    // whether the Athlete has a lower total score than the given Athlete

    public boolean hasBeaten(Athlete otherAthlete) {
        return this.totalScore() < otherAthlete.totalScore();
    }


    // Problem 8 ------------------------------------Version 1-------------------------------------------------

    // Takes another Athlete as input, and return whichever of the two athletes
    // has the lower score on the cycling event alone.

    public Athlete betterCyclist1 (Athlete participant) {
        if (Cycling.position < participant.Cycling.position) {
            return this;
        } else
            return participant;
    }

    // Problem 8 ------------------------------------Version 2-------------------------------------------------

    // Takes another Athlete as input, and return whichever of the two athletes
    // has the lower score on the cycling event alone.

    public Athlete betterCyclist2 (Athlete participant) {
        if (this.helper(participant) == true) {
            return this;
        } else
            return participant;
    }

    // Creates a helper function with an Athlete as an input and returns a boolean
    // evaluating whether the given cycler's position is greater than the other cycler's position.

    public boolean helper (Athlete participant) {
        return (Cycling.position < participant.Cycling.position);
    }
}

    // Problem 2
    // Creates a CyclingResult class that stores the time (in seconds)
    // at which the athlete crossed the finish line and the athlete's finishing order

    class CyclingResult implements IEvent {
        double time;
        int position;

        CyclingResult(double time, int position) {
            this.time = time;
            this.position = position;
        }

        // Calculates the pointsEarned for each Athlete in the cycling event

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

    //Problem 3

    // Creates BiathlonResult that stores three BiathlonRound objects

    class BiathlonResult implements IEvent {

        BiathlonRound round1;
        BiathlonRound round2;
        BiathlonRound round3;

        public BiathlonResult(BiathlonRound round1, BiathlonRound round2, BiathlonRound round3) {
            this.round1 = round1;
            this.round2 = round2;
            this.round3 = round3;
        }

        // Calculates the pointsEarned for each athlete in the Biathlon

        public double pointsEarned() {
            return this.round1.roundPoints() + this.round2.roundPoints() + this.round3.roundPoints();
        }

        // Problem 5

        // Finds the athlete's best round and returns it

        public BiathlonRound bestRound() {
            if ((this.round1.roundPoints() <= this.round2.roundPoints()) && (this.round1.roundPoints() <= this.round3.roundPoints())) {
                return this.round1;
            } else if ((this.round2.roundPoints() <= this.round1.roundPoints()) && (this.round2.roundPoints() <= this.round3.roundPoints())) {
                return this.round2;
            } else
                return this.round3;
        }
    }

// Creates a BiathlonRound that stores the targets hit and the time finished (in seconds)

class BiathlonRound {
    int targetsHit;
    double time;

    BiathlonRound(int targetsHit, double time) {
        this.targetsHit = targetsHit;
        this.time = time;
    }
// Calculates the points earned by an athlete in a single round in the Biathlon event

    public double roundPoints() {
        return this.time + 60 * (5 - this.targetsHit);
    }
}




