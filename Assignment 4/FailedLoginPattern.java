import java.util.LinkedList;

// Jack Palmstrom     ccc username: jnpalmstrom

//----------------------------------------- Problem 2.2 --------------------------------------------------------------//

/* When users create very large files, it can indicate that they are trying
 * to save a lot of data that they shouldn’t have access to. Our monitor
 * therefore wants to track creation of files larger than 1GB.
 */

public class FailedLoginPattern implements IPattern {

    FailedLoginPattern(){}

    public LinkedList<Alert> run(EventLog log, LinkedList<String> usernames) {

        LinkedList<String> failedLoginNames = new LinkedList<String>();
        LinkedList<Alert> failedLoginAlerts = new LinkedList<Alert>();

        for (String uname : usernames) {

            int countFail = 0;

            for (int x = 0; x < log.getLog().size(); x++) {

                AbsEvent event = log.getLog().get(x) ;
                AbsEvent oldEvent = log.getLog().get(x - 1);

                if ((event.getType() == AbsEvent.LOGIN) && (!((Login)event).wasSuccessful())) {

                    WebRequest wr = (WebRequest) event;
                    String regIP = wr.getIP() + ":" + wr.getPort();
                    long diff = event.getTimestamp().getTime() - oldEvent.getTimestamp().getTime();

                    if ((failedLoginNames.contains(regIP)) && (diff / 60000.0 > 5.0)) {
                        countFail = countFail + 1;
                    }
                }
            }
            if (countFail > 3) {
                int severity = Math.min(10, (countFail / 1));
                Alert a = new Alert(uname, severity, AbsEvent.WEB_REQUEST);
                failedLoginAlerts.add(a);
                System.out.println("Number of failed login attempts:" + failedLoginAlerts);
            }
        }
        return failedLoginAlerts;
    }
}
