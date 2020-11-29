package Novice;

import java.io.File;
import java.util.Scanner;

public class G_OldTraditionsNeverDie {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("G.txt"));
        int a = scan.nextInt();
        scan.nextLine();
//        while (a != 0) {
        while (true) {
            int sums = 0;
            int sum = 0;
            for (int i = 0; i <= a; i++) {
                String b = scan.nextLine();
                switch (b) {
                    case "touchdown":
                        sum += 7;
                        sums += sum;
                        break;
                    case "field goal":
                        sum += 3;
                        sums += sum;
                        break;
                    case "safety":
                        sum += 2;
                        sums += sum;
                        break;
                }
            }
            System.out.println("Ensign Redshirt does " + sums + " pushups!");
//            out.println(scan.nextLine());
            a = scan.nextInt();
        }
    }
}
