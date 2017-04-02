// Jack Palmstrom          ccc username: jnpalmstrom
// Haiau Duong             ccc username: hkduong

import java.util.LinkedList;

// Problem 2 Version 1

public class DataSmooth1 {
    DataSmooth1(){}

    // Class TripleNum takes in 3 ints contains method average
    // to find average of 3 ints && converts average to a double

    public class TripleNum {
        int num1;
        int num2;
        int num3;

        TripleNum(int num1, int num2, int num3) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
        }


        public double average() {
            return ((num1 + num2 + num3) / 3.0);
        }

    }

    //Takes list of PHR
    //Outputs List of Triples
    public LinkedList<TripleNum> lot (LinkedList<PHR> phrs) {
        LinkedList<TripleNum> trips = new LinkedList<TripleNum>();

        for (int i = 0; i < phrs.size(); i++) {
            if (i == 0) {
                trips.add(new TripleNum(phrs.get(i).heartRate,
                        phrs.get(i).heartRate, phrs.get(i).heartRate));
            } else if (i == phrs.size() - 1) {
                trips.add(new TripleNum(phrs.get(i).heartRate,
                        phrs.get(i).heartRate, phrs.get(i).heartRate));
            } else {
                trips.add(new TripleNum(phrs.get(i - 1).heartRate,
                        phrs.get(i).heartRate, phrs.get(i + 1).heartRate));
            }
            return new LinkedList<TripleNum>();
        }
        return new LinkedList<TripleNum>();
    }


    // dataSmooth runs through the list and averages the datum
    public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {

        LinkedList<TripleNum> trips = new LinkedList<TripleNum>();
        LinkedList<Double> average = new LinkedList<>();


        for (TripleNum t : trips) {
            average.add(t.average());
        }
        return average;
    }
}

