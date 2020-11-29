package ND;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Not Done
 *
 * @author Master Ward
 */
public class Prob14 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob14.txt"));
        String a = scan.nextLine();
        LinkedList<String> ll = new LinkedList(); // Actor List to movie
        ArrayList<LinkedList<String>> act = new ArrayList(); // Actors List
        HashSet hs = new HashSet(); // Actor name List
        while (!"[ACTORS]".equals(a)) {
            String split[] = a.split("[ ]+");
            String m = split[0]; // Movie
            for (int i = 0; i < split.length; i++) {
                if (hs.contains(split[i])) {
                    System.out.println("NEED TO REMODIFY THIS IN FINDING WHERE THEY ARE");
                } else {
                    hs.add(split[i]);
                }
            }
            a = scan.nextLine();
        }
        System.out.println(Arrays.toString(hs.toArray()));
        while (!"[END]".equals(a)) {
            a = scan.nextLine(); // Actor
            System.out.println("FIND THE ACTOR");
        }
    }
}
