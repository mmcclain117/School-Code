
import java.util.Timer;

/**
 *
 * @author Master
 */
public class Main {

    public static void main(String[] args) {
//        Scheduling to run a task every few seconds
        Timer t = new Timer();
        MyTask mTask = new MyTask();
        // This task is scheduled to run every 10 seconds

        t.scheduleAtFixedRate(mTask, 0, 10000);
    }

}
