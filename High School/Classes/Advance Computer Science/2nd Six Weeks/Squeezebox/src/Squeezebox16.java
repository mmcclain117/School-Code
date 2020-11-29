
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Squeezebox15 {

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
            int con = 0; // Counter of inside iterator
            int outside = 0;// Counter of the outside Iterator
            while (outside < deck.size()) { // Outside Iterator Doesn't make it to the end
                con = outside; // Inside iterator reset to outside iterator point
                do {
                    String current = deck.get(con).getLast().toString(); // Current top card 
                    char currentChar[] = current.toCharArray(); // Card to char
                    if (con > 2 && con <= deck.size()) { // Check if iterator is able to move card over 3
                        String three = deck.get(con - 3).getLast().toString(); // Card over 3 spaces
                        char threeChar[] = three.toCharArray(); // Card to char
                        if (currentChar[0] == threeChar[0] || currentChar[1] == threeChar[1]) { // Check to see if they are the same suit or Number
                            deck.get(con - 3).addLast(deck.get(con).getLast()); // Removes top of last
                            deck.get(con).removeLast();
                            if (deck.get(con).size() == 0) {
                                deck.remove(con);
                                con--;
                                outside--;
                            }
                            outside--; // Decreases outside iterator
                            outside--;
                            con--;
                            con--; // Decreases inside iterator
                        }
                    }
                    if (con > 0 && outside > 0) { //If it has a card to the left
                        current = deck.get(con).getLast().toString(); // Reasign current incase it moved
                        currentChar = current.toCharArray();// Turn to char
                        String one = deck.get(con - 1).getLast().toString(); // Top card of the stack to the left
                        char oneChar[] = one.toCharArray(); // Turn of card to left
                        if (currentChar[0] == oneChar[0] || currentChar[1] == oneChar[1]) { // See if same Suit or Number
                            deck.get(con - 1).addLast(deck.get(con).getLast()); // Removes top of last
                            deck.get(con).removeLast();
                            if (deck.get(con).size() == 0) {
                                deck.remove(con);
                                con--;
                            }
                            outside--; // Decreases the outside iterator
                            outside--;
                        }
                    }
                    con--; // Decrases inside iterator
                } while (con > 0 && outside > 0); // Inside iterator is zero
                outside++; // Increases outside iterator
            }
            int size = deck.size(); // Size of LinkedList
            String pil = size == 1 ? "pile" : "piles"; // 1 pile, more piles
            out.print(size + " " + pil + " remaining: ");
            for (int f = 0; f < deck.size(); f++) { // Prints out the sizes of the piles
                out.print(deck.get(f).size() + " ");
            }
            out.println();
            for (int f = 0; f < deck.size(); f++) { // Prints out each stack 
                out.println(Arrays.toString(deck.get(f).toArray()));
            }
            out.println();
            deck.clear(); // Clears linkedList
            a = scan.nextLine(); // Scan for next card set
        }
    }
}
