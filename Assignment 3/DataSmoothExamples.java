import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class DataSmoothExamples {
    LinkedList<PHR> PHR1 = new LinkedList<PHR>();
    LinkedList<Double> PHR1Results = new LinkedList<Double>();
    DataSmooth1 D1 = new DataSmooth1();

    // Student Example
    LinkedList<PHR> PHR2 = new LinkedList<PHR>();
    LinkedList<Double> PHR2Results = new LinkedList<Double>();
    DataSmooth2 D2 = new DataSmooth2();

    public DataSmoothExamples() {
        // four sample PHRs
        PHR1.add(new PHR("Andy", 1.8, 55, 96));
        PHR1.add(new PHR("Jill", 2, 75, 102));
        PHR1.add(new PHR("Ming", 1.7, 60, 87));
        PHR1.add(new PHR("Sophia", 1.8, 63, 105));

        // the smoothing results on the sample PHRs
        PHR1Results.add(96.0);
        PHR1Results.add(95.0);  // average of 96, 102, 87
        PHR1Results.add(98.0);  // average of 102, 87, 105
        PHR1Results.add(105.0);

        // five sample PHRs (Student Examples)
        PHR2.add(new PHR("Nick", 1.8, 55, 100));
        PHR2.add(new PHR("Haiau", 1.5, 55, 55));
        PHR2.add(new PHR("Alex", 2.0, 50, 90));
        PHR2.add(new PHR("Chase", 1.9, 101, 60));
        PHR2.add(new PHR ("Jack", 1.6, 80, 70));

        // the smoothing results on the sample PHRs (Student Examples)
        PHR2Results.add(100.0);
        PHR2Results.add(81.67);  // average of 100, 55, 90
        PHR2Results.add(68.33);  // average of 55, 90, 60
        PHR2Results.add(73.33);  // average of 90, 60, 70
        PHR2Results.add(70.0);

    }

   // @Test
   // public void instructorTestDS() {
   //     assertEquals(PHR1Results,D1.dataSmooth(PHR1));
   // }

    @Test
    public void studentTestDS() {
        assertEquals(PHR2Results, D2.dataSmooth2(PHR2));
    }


}