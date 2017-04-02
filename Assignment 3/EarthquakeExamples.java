import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
    Earthquake1 E1 = new Earthquake1();
    LinkedList<Double> noData = new LinkedList<Double>();
    LinkedList<Double> threeDates = new LinkedList<Double>();
    LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();

    // Creates Example list and E2 (Student Examples)
    Earthquake2 E2 = new Earthquake2();
    LinkedList<Double> emptyData = new LinkedList<Double>();
    LinkedList<Double> afewDates = new LinkedList<Double>();
    LinkedList<MaxHzReport> newReports = new LinkedList<MaxHzReport>();


    public EarthquakeExamples() {
        threeDates.add(20151013.0);
        threeDates.add(10.0);
        threeDates.add(5.0);
        threeDates.add(20151020.0);
        threeDates.add(40.0);
        threeDates.add(50.0);
        threeDates.add(45.0);
        threeDates.add(20151101.0);
        threeDates.add(6.0);
        NovReports.add(new MaxHzReport(20151101.0,6.0));

        afewDates.add(20151119.0);
        afewDates.add(12.0);
        afewDates.add(15.0);
        afewDates.add(20151120.0);
        afewDates.add(20.0);
        afewDates.add(30.0);
        afewDates.add(45.0);
        afewDates.add(20150901.0);
        afewDates.add(10.0);
        newReports.add(new MaxHzReport(20150901.0,10.0));

    }

    @Test
    public void instructorTestEQ() {
        assertEquals(NovReports,
                E1.dailyMaxForMonth(threeDates, 11));
    }

    @Test
    public void studentTestEQ() {
        assertEquals(newReports,
                E2.dailyMaxForMonth(afewDates, 9));
    }

}
