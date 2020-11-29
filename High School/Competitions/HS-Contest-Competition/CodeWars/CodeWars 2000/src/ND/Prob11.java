package ND;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob11 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob11.txt"));
        String s = scan.nextLine();
        ArrayList<Sent> id = new ArrayList();
        while (!s.equals("#")) {
            String split[] = s.split("[ ]+");
            if (s.contains("?")) { // Question
                System.out.print(s + " "); // Echo question

            } else if (s.contains("is a")) {// Statement 1 (Belong to group)
                String id1 = split[0];
                String noun1 = split[split.length - 1];
                noun1 = noun1.substring(0, noun1.length() - 1); // Cutting off period

            } else { // Statement 2 (Verb)
                String noun1 = split[0];
                String verb = split[1];
                String noun2 = split[split.length - 1];
                noun2 = noun2.substring(0, noun2.length() - 1); // Cutting off period

            }
            s = scan.nextLine();
        }
    }
}

class Sent {

    private String noun1; // Noun Group
    private String does; // What does/verb
    private String noun2; // Noun Group Does

    Sent(String n1, String n2, String n3) {
        noun1 = n1;
        does = n2;
        noun2 = n3;

    }
}
