import java.util.LinkedList;

// Jack Palmstrom       ccc username: jnpalmstrom

// Problem 2.2 (Pattern 1)

//---------------------------------------- Problem 2.2  --------------------------------------------------------------//

/* When users create very large files, it can indicate that they are trying
 * to save a lot of data that they shouldn’t have access to. Our monitor
 * therefore wants to track creation of files larger than 1GB.
 */


public class LargeFilePattern implements IPattern {


    public LinkedList<Alert> run(EventLog log, LinkedList<String> usernames) {

        LinkedList<String> largeFileNames = new LinkedList<String>();
        LinkedList<Alert> largeFileAlerts = new LinkedList<Alert>();

        for (String uname : usernames) {
            // Track the number of requests made by user to blacklisted addresses
            int countUser = 0;

        for (AbsEvent event : log.getLog()) {

            if ((event.getType() == AbsEvent.FILE_SAVED) && (((FileSaved) event).getSize() > 1000000)) {

                WebRequest wr = (WebRequest) event;
                String regIP = wr.getIP() + ":" + wr.getPort();

                if (largeFileNames.contains(regIP)) {
                    countUser = countUser + 1;
                }
            }
        }

            if (countUser > 0) {
                int severity = Math.min(10, (countUser / 1));
                Alert a = new Alert(uname, severity, AbsEvent.WEB_REQUEST);
                largeFileAlerts.add(a);
            }
        }
        System.out.print("Alerts for large file:" + largeFileAlerts);
        return largeFileAlerts;
    }
}

