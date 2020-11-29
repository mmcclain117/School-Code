
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Chapter_2_Exercise {

    public static void main(String[] args) throws Exception { // Extra
        Write();
        Scanner sit = new Scanner(System.in);
        out.println("Enter the name of the file and include .txt");
        String a = sit.next();
        a = "Ch2Ex.txt";
        Scanner scan = new Scanner(new File(a));
        Scanner in = new Scanner(new File("Ex2Answer.txt"));
        int sco[] = new int[12];
        String answers[] = new String[12];
        String ans[] = new String[12];
        int sum = 0;
        int cons = 0;
        //Question 1
        answers[cons] = in.nextLine();
        String p[] = answers[cons].split("[ ]+");
        ans[cons] = scan.nextLine().toLowerCase();
        if (ans[cons].contains(p[0])) {
            sum += 33;
        }
        if (ans[cons].contains(p[1])) {
            sum += 33;
        }
        if (ans[cons].contains(p[2])) {
            sum += 33;
        }
        sco[cons] = sum;
        cons++;
        // Question 2
        ans[cons] = scan.nextLine().toLowerCase();
        answers[cons] = in.nextLine();
        sco[cons] = ans[cons].compareToIgnoreCase(answers[cons]);
        cons++;
        //Question 3
        answers[cons] = in.nextLine();
        ans[cons] = scan.nextLine();
        sco[cons] = ans[cons].compareToIgnoreCase(answers[cons]);
        cons++;
        //Question 4
        answers[cons] = in.nextLine();
        ans[cons] = scan.nextLine();
        sco[cons] = ans[cons].compareToIgnoreCase(answers[cons]);
        cons++;
        //Question 5

        //Question 6
        //Question 7
        //Question 8
        answers[cons] = in.nextLine();
        ans[cons] = scan.nextLine();
        sco[cons] = ans[cons].compareToIgnoreCase(answers[cons]);
        cons++;
        //Question 9
        answers[cons] = in.nextLine();
        ans[cons] = scan.nextLine();
        sco[cons] = ans[cons].compareToIgnoreCase(answers[cons]);
        cons++;
        //Question 10

        //Question 11
        //Question 12
        //Score();
    }

    private static void Write() throws Exception {
        FileWriter fw = new FileWriter("Ex2Answer.txt");
        String myName = "my Name";
        fw.write("string int double\n"
                + "string\n"
                + "double\n"
                + "int\n"
                + "double p = " + 1.921 * Math.pow(10, -16) + "\n"
                + "int i = 307\n"
                + "String my_Name = " + myName + "\n"
                + "int count;\n"
                + "bankBalance = 306.05\n"
                + "scooter doubled\n"
                + "\n"
                + "\n");
        fw.flush();
        fw.close();
    }

    private static int Score(int a[]) {
        int tot = 0;
        ArrayList wrong = new ArrayList();
        int numRight = 0;
        int totNum = a.length;
        int i = 0;
        if (a[i] == 99) {
            numRight++;
            tot += 100;
        } else {
            wrong.add(i);
        }
        i++;
        if (a[i] == 0) {
            numRight++;
            tot += 100;
        } else {
            wrong.add(i);
        }
        i++;
        return tot;
    }
}
