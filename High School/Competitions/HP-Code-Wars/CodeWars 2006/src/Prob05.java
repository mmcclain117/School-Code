
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Application Overload
//        Points: 5
        Scanner scan = new Scanner(new File("prob05.txt"));
        int numApps = 0;
        String server = scan.nextLine();
        Server Server = new Server(server); // Create new Server Object

        numApps = scan.nextInt();
        scan.nextLine();
        /* Add application to server */
        for (int i = 0; i < numApps; i++) {
            String tmp = scan.nextLine();
            Server.addApp(tmp);
        }

        if (Server.overloaded) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
        System.out.printf("%.2f%s CPU\n", Server.getCPU(), "%");
        System.out.printf("%.2f%s memory\n", Server.getRAM(), "%");
        scan.close();
    }

}

class Server {

    private final int speed;
    private final int ram;
    private int cpuLoad = 0;
    private int ramLoad = 0;
    public boolean overloaded = false;

    public Server(String serverInfo) {
        // Spliting (application, CPU Speed, RAM)
        String split[] = serverInfo.split("[,]");
        String model = split[0]; // Set model name
        speed = Integer.parseInt(split[1]); // Set CPU Speed
        ram = Integer.parseInt(split[2]); // Set RAM Capacity

    }

    public void addApp(String appinfo) {
//        Spliting (application, CPU Speed, RAM)
        String split[] = appinfo.split("[,]");
        cpuLoad += Integer.parseInt(split[1]); // Add Application CPU
        if (cpuLoad > speed) {
            overloaded = true;
        }
        ramLoad += Integer.parseInt(split[2]); // Add Application RAM
        if (ramLoad > ram) {
            overloaded = true;
        }
    }

    public double getCPU() {
        return (Math.round(((double) cpuLoad / (double) speed) * 10000)) / 100.0;
    }

    public double getRAM() {
        return (Math.round(((double) ramLoad / (double) ram) * 10000)) / 100.0;
    }

}
