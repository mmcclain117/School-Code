
import java.io.Console;

/**
 *
 * @author Master
 */
public class Main {
// Hides the thing being entered in console

    public static void main(String[] args) {
//        Console c = new Console();
        Console cnsl = null;
        String alpha = null;
        try {
//            out.println("a");

            // creates a console object
            cnsl = System.console();

            // if console is not null
            if (cnsl != null) {

                // read line from the user input
                alpha = cnsl.readLine("Name: ");

                // prints
                System.out.println("Name is: " + alpha);

                // read password into the char array
                char[] pwd = cnsl.readPassword("Password: ");

                // prints
                System.out.println("Password is: " + pwd);
            }
        } catch (Exception ex) {

            // if any error occurs
            ex.printStackTrace();
        }
    }
}
/*
 Console con = System.console();
 //        char ch[] = con.readPassword();
 char ch[] = con.readLine().toCharArray();
 out.println(Arrays.toString(ch));
 try(Scanner in = new Scanner(System.in)) {
 String pass = in.nextLine();
 out.println(pass);
 } 
 }

 }
 */
