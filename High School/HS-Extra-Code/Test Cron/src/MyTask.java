
import java.util.TimerTask;

/**
 *
 * @author Master
 */
class MyTask extends TimerTask {

    public MyTask() {
        //Some stuffs
    }

    @Override
    public void run() {
        System.out.println("Hi see you after 10 seconds");
    }

}
