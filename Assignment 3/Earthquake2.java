// Jack Palmstrom          ccc username: jnpalmstrom
// Haiau Duong             ccc username: hkduong

import java.util.LinkedList;

// Problem 3 Version 1

class Earthquake2  {
    Earthquake2(){}

    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {

//--------------------------------------------- Variables ----------------------------------------------------------------------------------------------//

        int dayInt;                // int place holder
        int monthInt;              // int place holder

        String dataHolder;         // String place holder
        String monthData;          // String place holder
        String dayData;            // String place holder

        double max = 0;            // max reading per day

        LinkedList<MaxHzReport> maxDaily = new LinkedList<MaxHzReport>(); // Linked List place holder

//--------------------------------------------- Sort Dates ----------------------------------------------------------------------------------------------//


        for (int c = 0; c < data.size(); c++)
        {
            dataHolder = Double.toString(data.get(c));           // Converts current item in list of data to a string

            if (dataHolder.length() > 6)                         // Items > 6 are months and days
            {
                monthData = dataHolder.substring(5,7);           // Finds month

                dayData = dataHolder.substring(7,9);             // Finds day

                monthInt = Integer.parseInt(monthData);          // Converts monthData to an integer

                dayInt = Integer.parseInt(dayData);              // Converts dayData to an integer


                if (monthInt == month) {                         // Compares month from data set to the given month

                    max = maxDay(data, c + 1);
                    MaxHzReport maxHz = new MaxHzReport (dayInt, max);
                    maxDaily.add(maxHz);

                    max = 0;                                     // Reset max
                    dayInt = 0;                                  // Rest dayDataInt
                }
            }
        }
        return maxDaily;
    }

//--------------------------------------------- getMaxDaily Helper Method  -------------------------------------------------------------------------------//

    public double maxDay (LinkedList<Double> data, int start){

        String stringData = "";                                     // String place holder

        double maxSoFar = Integer.MIN_VALUE;                        // maxSoFar stores greatest value for given day

        for (int x = start; x < data.size(); x++) {

            stringData = Double.toString(data.get(x));              // Converts an int to a string

            if (stringData.length() < 6) {                          // Checks if datum is a date

                if (data.get(x) > maxSoFar) {                       // Checks if current data > the current maximum daily value

                    maxSoFar = data.get(x);
                }

            }
            else break;
        }
        return maxSoFar;
    }
}


