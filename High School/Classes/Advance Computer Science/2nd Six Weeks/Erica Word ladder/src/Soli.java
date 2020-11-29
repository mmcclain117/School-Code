
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Soli {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("squeezebox.dat"));
        String a = scan.nextLine(); // First line
        String b = "";
        LinkedList<LinkedList> deck = new LinkedList(); // LinkedList of the LinkedList(stacks) of cards
        while (!(a.equals("#"))) {
            b = scan.nextLine(); // Second Line
            String aa[] = a.split("[ ]+"); // Array of 1st line Cards 
            String bb[] = b.split("[ ]+"); // Array of 2nd line cards
            for (int i = 0; i < aa.length; i++) { // Adds all of the first line to the linked list
                LinkedList p = new LinkedList(); // Make a new Stack
                p.add(aa[i]); // Adds to Stack
                deck.add(p); // Adds to linkedList
            }
            for (int i = 0; i < bb.length; i++) { // Adds all of the 2nd line to the linkedList
                LinkedList p = new LinkedList(); // Make a new Stack
                p.add(bb[i]);// Add to Stack
                deck.add(p); // Add Stack to LinkedList
            }
            int con = 0; // inside iterator
            int outside = 0;// Outside Iterator
            while (outside < deck.size()) {
                con = outside;
                do {
                    String current = deck.get(con).getLast().toString();
                    char[] currentChar = current.toCharArray();
                    if (con > 2 && con <= deck.size()) {
                        String three = deck.get(con - 3).getLast().toString();
                        if (current.charAt(0) == three.charAt(0) || current.charAt(1) == three.charAt(1)) {
                            deck.get(con - 3).addLast(deck.get(con).getLast());
                            deck.get(con).removeLast();
                            if (deck.get(con).size() == 0) {
                                deck.remove(con);
                                outside--;
                                con--;
                            }
                            outside -= 2;
                            con -= 2;
                        }
                    }
                    if (con > 0 && outside > 0) {
                        String one = deck.get(con - 1).getLast().toString();
                        current = deck.get(con).getLast().toString();
                        currentChar = current.toCharArray();
                        char[] oneChar = one.toCharArray();
                        if (currentChar[0] == oneChar[0] || current.charAt(1) == one.charAt(1)) {
                            deck.get(con - 1).addLast(deck.get(con).getLast());
                            deck.get(con).removeLast();
                            if (deck.get(con).size() == 0) {
                                deck.remove(con);
//                                outside--;
                                con--;
                            }
                            outside--;
                            outside--;
//                            con--;
                        }
                    }
                    con--;
                } while (outside > 0 && con > 0);
                outside++;

            }
            System.out.print(deck.size() + " piles remaining :");
            for (int i = 0; i < deck.size(); i++) {
                System.out.print(deck.get(i).size() + " ");
            }
            System.out.println();
            deck.clear();
//            Iterator is another word for pointer

//            Make the outside iterator go till it hits the end of the deck
//            Get the current outside card to the card three to the left and compare them
//            Then compare the one next to it
//            Change anything if needed and decrease inside iterator
//            Hits bottom add to outside iterator
//            Finalizing
//            Based on size if it is a pile or piles
//            Output the size of the each dck
            a = scan.nextLine();
        }
    }
}
