import java.util.LinkedList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {
  // customize here, or create multiple monitors with different parameter lists
  SecurityMonitor SM = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
  SecurityMonitor SM2 = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
  SecurityMonitor SM3 = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
  SecurityMonitor SM4 = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
  SecurityMonitor SM5 = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
  SecurityMonitor SM6 = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
  SecurityMonitor SM7 = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
  SecurityMonitor SM8 = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
  SecurityMonitor SM9 = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
  SecurityMonitor SM10 = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
  // use this fixed set of usernames -- it is what we have in all the logs
  LinkedList<String> usernames = new LinkedList<String>(Arrays.asList("root","kathi", "simmon", "jordan"));

  Alert alert1 = new Alert("Jack", 2, 4);
  Alert alert2 = new Alert("Alex", 1, 1);
  Alert alert3 = new Alert("Nick", 2, 2);
  Alert alert4 = new Alert("Steve", 2, 2);
  Alert alert5 = new Alert("Ben", 10, 6);
  Alert alert6 = new Alert("George", 3, 3);

  public Examples() {
    // reset the queue between test cases
    SM.clearQueue();
    // populate the queue based on a specific log
    SM.runLogFile("webrequestlog.txt", usernames);
    // populate the queue based on a specific log
    SM.clearQueue();
    SM.runLogFile("saveLog.txt", usernames);
    SM2.runLogFile("saveLog.txt", usernames);

    SM3.clearQueue();
    SM3.runLogFile("saveLog2.txt", usernames);

    SM4.clearQueue();
    SM4.runLogFile("loginLog.txt", usernames);

    SM5.clearQueue();
    SM5.runLogFile("loginLog2.txt", usernames);

    SM6.clearQueue();
    SM6.runLogFile("webrequestlog.txt", usernames);

    SM7.clearQueue();
    SM7.runLogFile("largeLog1.txt", usernames);

    SM8.clearQueue();
    SM8.runLogFile("eventlog1.txt", usernames);

    SM9.clearQueue();
    SM9.runLogFile("eventlog2.txt", usernames);

    SM10.clearQueue();
    SM10.runLogFile("largestLog.txt", usernames);
  }
  
  // check whether the webrequest sample yields a single alert (as it should)
  @Test
  public void checkWebRequestAlerts() {
    assertEquals(1, SM.numAlerts());
  }

  @Test
  public void checkSaveLog() {
    assertEquals(1, SM.numAlerts());
  }

  @Test
  public void checkSaveLog2() {
    assertEquals(2, SM.numAlerts());
  }

  @Test
  public void checkloginLog() {
    assertEquals(1, SM.numAlerts());
  }

  @Test
  public void checkloginLog2() {
    assertEquals(0, SM.numAlerts());
  }

  @Test
  public void checkwebrequestlog() {
    assertEquals(1, SM.numAlerts());
  }

  @Test
  public void checklargestlog1webrequestlog() {
    assertEquals(3, SM.numAlerts());
  }

  @Test
  public void checkeventlog1webrequestlog() {
    assertEquals(4, SM.numAlerts());
  }

  @Test
  public void checkEventlog2() {
    assertEquals(4, SM.numAlerts());
  }

  @Test
  public void checklargestLog() {
    assertEquals(3, SM.numAlerts());
  }


//----------------------------------------- Tests on compareTo Method ------------------------------------------------//
  @Test
  public void firstTestCompareTo() {
    assertTrue(alert1.compareTo(alert2) == -1);    // Tests -1 output of compareTo
  }

  @Test
  public void secondTestCompareTo() {
    assertTrue(alert4.compareTo(alert5) == 1);     // Tests 1 output of compareTo
  }

  @Test
  public void thirdTestCompareTo() {
    assertTrue(alert1.compareTo(alert1) == 0);     // Tests 0 output of compareTo
  }

//------------------------------------------ Tests on equals Method --------------------------------------------------//
  @Test
  public void trueTestEquals() {
    assertTrue(alert1.equals(alert1));             // Tests True output for equals method
  }

  @Test
  public void falseTestEquals() {
    assertFalse(alert1.equals(alert4));            // Tests False output for equals method
  }

}