import java.util.LinkedList;

public interface IPattern {

 LinkedList<Alert> run(EventLog log, LinkedList<String> usernames);
}
