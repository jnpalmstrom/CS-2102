// Jack Palmstrom       ccc username: jnpalmstrom

//--------------------------------------- Problem 1 ------------------------------------------------------------------//

public class Alert implements Comparable {

    String username;
    int severityRating;  // (an integer from 1 - 10)
    int eventType;       // (an integer from 1 - 6)

    int comparison = 0;

    public Alert (String username, int severityRating, int eventType) {
        this.username = username;
        this.severityRating = severityRating;
        this.eventType = eventType;
    }

    public int compareTo(Object otherObj) {
        Alert other = (Alert) otherObj;

        if (other.severityRating == this.severityRating) {
            comparison = 0;
        } else if (other.severityRating < this.severityRating) {
            comparison = -1;
        } else if (other.severityRating > this.severityRating) {
            comparison = 1;
        }
        return comparison;
    }

    public boolean equals (Object otherObject) {
        return this == otherObject;
    }

}
