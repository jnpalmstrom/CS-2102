// Jack Palmstrom          ccc username: jnpalmstrom
// Haiau Duong             ccc username: hkduong

import java.util.Arrays;
import java.util.LinkedList;

class BMI2 implements IBMI{
    BMI2(){}

//------------------------------------- bmiReport Method -------------------------------------------------------------//

    public BMISummary bmiReport(LinkedList<PHR> phrs){

        double BMI; // Creates variable BMI

        // Initializes four lists to categorize BMI levels
        LinkedList<String> under = new LinkedList<String>();
        LinkedList<String> healthy = new LinkedList<String>();
        LinkedList<String> over = new LinkedList<String>();
        LinkedList<String> obese = new LinkedList<String>();

//------------------------------------- for loop to create new BMI Summary -------------------------------------------//

        for (PHR c : phrs){

            BMI = (c.weight / (c.height * c.height));                                 // BMI Calculation

            if ( BMI < 18.5){
                under = new LinkedList<String>(Arrays.asList(c.name));                // Adds name to underweight list

                return new BMISummary (under , healthy, over, obese);
            }
            else if (BMI >= 18.5 && BMI < 25){
                healthy = new LinkedList<String>(Arrays.asList(c.name));              // Adds name to healthy list

                return new BMISummary (under , healthy, over, obese);
            }
            else if (BMI >= 25 && BMI < 30){
                over = new LinkedList<String>(Arrays.asList(c.name));                 // Adds name to overweight list

                return new BMISummary (under , healthy, over, obese);
            }
            else if (BMI > 30) {
                obese = new LinkedList<String>(Arrays.asList(c.name));                // Adds name to obese list

                return new BMISummary (under , healthy, over, obese);
            }
        }

        return new BMISummary(under, healthy, over, obese);

    }
}



