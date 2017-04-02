// Jack Palmstrom          ccc username: jnpalmstrom
// Haiau Duong             ccc username: hkduong

import java.awt.geom.Arc2D;
import java.util.LinkedList;

// Problem 3 Version 1

public class Earthquake1 {
    Earthquake1() {}

    LinkedList<MaxHzReport> newList = new LinkedList<>();

    // checks whether a datum is a date
    boolean isDate(double anum) {
        return (int) anum > 10000000;
    }

    // extracts the month from an 8-digit date
    int extractMonth(double dateNum) {
        return ((int) dateNum % 10000) / 100;
    }

    // dailyMaxForMonth returns a list of MaxHzReport(s) which contain the date and the maxHZ for that day of the inputted month.

    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {

        // Initial Variables

        LinkedList<Double> listOfDailyMax = new LinkedList<>();
        LinkedList<Double> listOfDates = new LinkedList<>();
        double maxHZ = 0;
        int count = 0;

        // Goes through each piece of datum and tests whether it is a date and if it is then if it also matched the date inputted

        for (int x = 0; x < data.size(); x++) {

            if (isDate(data.get(x))) {

                if (month == extractMonth(data.get(x))) {

                    listOfDates.add(data.get(x));         // Adds the date to a new list of dates for the inpuuted month
                    count = count + 1;

                    // Goes through the datum after a date to find the maxHZ for the date
                    for (int r = x; 10000000 < data.get(r); r++)

                        if (data.get(r) > maxHZ) {

                            maxHZ = data.get(r); // Sets the maxHZ for a given date
                        }
                    }
                    listOfDailyMax.add(maxHZ); // Adds the maxHZ to a list of all the maxHZ(s) for the inputted month
                }
            }

        // Goes through listOfDates && listOfDailyMax and adds them to a list of MaxHzReport

        for (int i = 0; i < listOfDates.size(); i++) {
            newList.add(new MaxHzReport(listOfDates.get(i), listOfDailyMax.get(i)));
        }
        return newList;
    }
}
