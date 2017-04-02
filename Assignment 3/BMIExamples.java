import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;

public class BMIExamples {

    BMI1 B1 = new BMI1();
    LinkedList<PHR> PHR1 = new LinkedList<PHR>();

    BMI1 B2 = new BMI1();
    LinkedList<PHR> PHR2 = new LinkedList<>();

    public BMIExamples(){

        // Adds 4 new people to the list PHR2 (Instructor Examples)

        PHR1.add(new PHR("Eugene", 2, 60, 77));
        PHR1.add(new PHR("Marty", 1.55, 58.17, 56));
        PHR1.add(new PHR("Rai", 1.8, 55, 84));
        PHR1.add(new PHR("Nicky", 1.5, 100, 64));

        // Adds 4 new people to the list PHR2 (Student Examples)

        PHR2.add(new PHR("Jack", 1.6, 80, 70));    // BMI = 31.25  <-- Obese
        PHR2.add(new PHR("Haiau", 1.5, 55, 55));   // BMI = 24.44  <-- healthy
        PHR2.add(new PHR("Alex", 2.0, 50, 90));    // BMI = 12.50  <-- under
        PHR2.add(new PHR("Chase", 1.9, 101, 60));  // BMI = 27.98  <-- over

    }

    @Test
    public void instructorTestBMI() {
        assertEquals(new BMISummary(new LinkedList<String>(Arrays.asList("Eugene", "Rai")),
                        new LinkedList<String>(Arrays.asList("Marty")),
                        new LinkedList<String>(),
                        new LinkedList<String>(Arrays.asList("Nicky"))),
                B1.bmiReport(PHR1));
    }

    // Tests the list of PHR2 against BMI1 (Students Test)

    @Test
    public void studentTestBMI() {
        assertEquals(new BMISummary (new LinkedList<String>(Arrays.asList("Alex")),
                        new LinkedList<String>(Arrays.asList("Haiau")),
                        new LinkedList<String>(Arrays.asList("Chase")),
                        new LinkedList<String>(Arrays.asList("Jack"))),
                B2.bmiReport(PHR2));
    }
}
