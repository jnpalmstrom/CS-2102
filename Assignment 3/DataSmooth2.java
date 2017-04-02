// Jack Palmstrom          ccc username: jnpalmstrom
// Haiau Duong             ccc username: hkduong

import java.lang.ref.PhantomReference;
import java.util.LinkedList;

// Problem 2 Version 2

public class DataSmooth2 {
    DataSmooth2(){}

    // Creates 3 new Lists

    LinkedList<Double> simpleHelper = new LinkedList<>();
    LinkedList<Double> smoothedList = new LinkedList<>();
    LinkedList<Double> dataSmooth2List = new LinkedList<>();

    // Class TripleNum takes in 3 ints contains method average
    // to find average of 3 ints && converts average to a double

    public class TripleNum2 {
        int num1;
        int num2;
        int num3;

        TripleNum2(int num1, int num2, int num3) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
        }

        public double average2() {
            return ((num1 + num2 + num3) / 3.0);

        }
    }

//------------------------------------------------------------------------------------------------------------------------------------------------------//
// Creates method simpleHelper which takes in the first and last heartBeats from the given list

    public LinkedList<Integer> simpleHelper (LinkedList<PHR> listOfPHR) {

        LinkedList<Integer> simpleList = new LinkedList<>();

        for (int r = 0; r < listOfPHR.size(); r++) {

            if ((r == 0) || (r == listOfPHR.size())) {
                simpleList.add(listOfPHR.get(r).heartRate);

            }
        }
        return simpleList;
    }

//------------------------------------------------------------------------------------------------------------------------------------------------------//
/* Creates method smoothHelper which adds the middle of the given list to smoothedList
 * after it has been averaged
 */
    public LinkedList<Double> smoothHelper (LinkedList<PHR> listOfPHR) {

        LinkedList<Double>  smoothedList = new LinkedList<>();

        for (int r = 0; r <= listOfPHR.size(); r++) {

            if ((0 < r) && (r < listOfPHR.size())) {

                TripleNum2 smoothedNums = new TripleNum2(listOfPHR.get(r-1).heartRate, listOfPHR.get(r).heartRate, listOfPHR.get(r + 1).heartRate);
                smoothedList.add(smoothedNums.average2());

                }
            }
        return smoothedList;
    }

//------------------------------------------------------------------------------------------------------------------------------------------------------//
/* Creates method dataSmooth2 which adds simpleList and smoothedList to output the list
 * dataSmooth2List which is a list of the smoothedData
 */
    public LinkedList<Double> dataSmooth2 (LinkedList<PHR> phrs) {

        LinkedList<Double> dataSmooth2List = new LinkedList<>();

        for (int x = 0; x <= phrs.size(); x++) {

            if (x == 0) {
                dataSmooth2List.add(simpleHelper.get(0));
            } else if ((0 < x) && (x < phrs.size())) {
                dataSmooth2List.add(smoothedList.get(x));
            } else if (x == phrs.size()) {
                dataSmooth2List.add(simpleHelper.get(phrs.size()));
            }
        }
        return dataSmooth2List;
    }
}
