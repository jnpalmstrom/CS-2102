// Jack Palmstrom          ccc username: jnpalmstrom
// Haiau Duong             ccc username: hkduong

import java.util.LinkedList;

// Problem 1 Version 1

class BMI1 {

    BMI1() {
    }

    // Initializes four lists to categorize BMI levels
    LinkedList<String> under;
    LinkedList<String> healthy;
    LinkedList<String> over;
    LinkedList<String> obese;

//------------------------------------- Helper Methods ---------------------------------------------------------------//

    // returns boolean statement for if BMI is underweight
    boolean bmiUnderweight(double weight, double height) {
        return (weight / (height * height)) < 18.5;
    }

    // returns boolean statement for if BMI is healthy
    boolean bmiHealthy(double weight, double height) {
        return (weight / (height * height)) >= 18.5 && (weight / (height * height)) < 25.0;
    }

    // returns boolean statement for if BMI is overweight
    boolean bmiOverweight(double weight, double height) {
        return (weight / (height * height)) >= 25.0 && (weight / (height * height)) < 30.0;
    }

    // returns boolean statement for if BMI is obese
    boolean bmiObese(double weight, double height) {
        return (weight / (height * height)) >= 30.0;
    }

//------------------------------------- bmiReport Method -------------------------------------------------------------//

    // for loop takes in a list and returns 4 different lists that categorize the list of BMI(s)

    public BMISummary bmiReport(LinkedList<PHR> phrs) {

        for (PHR phr : phrs) {

            if (bmiUnderweight(phr.weight, phr.height)) {
                under.add(phr.name);
            }
            if (bmiHealthy(phr.weight, phr.height)) {
                over.add(phr.name);
            }
            if (bmiOverweight(phr.weight, phr.height)) {
                healthy.add(phr.name);
            }
            if (bmiObese(phr.weight, phr.height)) {
                obese.add(phr.name);
            }
        }

        return new BMISummary(under, healthy, over, obese);

    }
}



