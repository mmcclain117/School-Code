
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Squeezebox14 {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("squeezebox.dat"));
        String a = scan.nextLine(); // First line
        String b = "";
        LinkedList<LinkedList> ll = new LinkedList(); // LinkedList of the LinkedList(stacks) of cards
        while (!(a.equals("#"))) {
            b = scan.nextLine(); // Second Line
            String aa[] = a.split("[ ]+"); // Array of 1st line Cards 
            String bb[] = b.split("[ ]+"); // Array of 2nd line cards
            for (int i = 0; i < aa.length; i++) { // Adds all of the first line to the linked list
                LinkedList p = new LinkedList(); // Make a new Stack
                p.add(aa[i]); // Adds to Stack
                ll.add(p); // Adds to linkedList
            }
            for (int i = 0; i < bb.length; i++) { // Adds all of the 2nd line to the linkedList
                LinkedList p = new LinkedList(); // Make a new Stack
                p.add(bb[i]);// Add to Stack
                ll.add(p); // Add Stack to LinkedList
            }
            int con = 0; // Counter of inside iterator
            int i = 0;// Counter of the outside Iterator
            while (i < ll.size()) { // Outside Iterator Doesn't make it to the end
                con = i; // Inside iterator reset to outside iterator point
                do {
                    String cur1 = ll.get(con).getLast().toString(); // Current top card 
                    char ch1[] = cur1.toCharArray(); // Card to char
                    if (con > 2 && con <= ll.size()) { // Check if iterator is able to move card over 3
                        String cur3 = ll.get(con - 3).getLast().toString(); // Card over 3 spaces
                        char ch3[] = cur3.toCharArray(); // Card to char
                        if (ch1[0] == ch3[0] || ch1[1] == ch3[1]) { // Check to see if they are the same suit or Number
//                            Collections.reverse(ll.get(con)); // Reverses the stack

                            ll.get(con - 3).addLast(ll.get(con).getLast()); // Removes top of last
                            ll.get(con).removeLast();
                            if (ll.get(con).size() == 0) {
                                ll.remove(con);
                                con--;
                                i--;
                            }
//                            ll.get(con - 3).addAll(ll.get(con)); // Adds them to the card over 3
//                            ll.remove(con); // Removes current stack moved
                            i--; // Decreases outside iterator
                            i--;
                            con--;
                            con--; // Decreases inside iterator
                        }
                    }
                    if (con > 0 && i > 0) { //If it has a card to the left
                        cur1 = ll.get(con).getLast().toString(); // Reasign current incase it moved
                        ch1 = cur1.toCharArray();// Turn to char
                        String cur2 = ll.get(con - 1).getLast().toString(); // Top card of the stack to the left
                        char ch2[] = cur2.toCharArray(); // Turn of card to left
                        if (ch1[0] == ch2[0] || ch1[1] == ch2[1]) { // See if same Suit or Number
//                            Collections.reverse(ll.get(con)); // Reverses the stack
                            ll.get(con - 1).addLast(ll.get(con).getLast()); // Removes top of last
                            ll.get(con).removeLast();
                            if (ll.get(con).size() == 0) {
                                ll.remove(con);
                                con--;
//                                i--;
                            }

//                            ll.get(con - 1).addAll(ll.get(con)); // Moves the current to the stack to the left
//                            ll.remove(con); // Removes the current
                            i--; // Decreases the outside iterator
                            i--;
//                            con--; // Decreases inside iterator
                        }
                    }
                    con--; // Decrases inside iterator
//                } while (con > 0 && con - 1 <= ll.size()); // Inside iterator is zero or is at the end
                } while (con > 0 && i > 0); // Inside iterator is zero
                i++; // Increases outside iterator
            }
//            }
            int size = ll.size(); // Size of LinkedList
            String pil = size == 1 ? "pile" : "piles"; // 1 pile, more piles
            out.print(size + " " + pil + " remaining: ");
            for (int f = 0; f < ll.size(); f++) { // Prints out the sizes of the piles
                out.print(ll.get(f).size() + " ");
            }
            out.println();
            for (int f = 0; f < ll.size(); f++) { // Prints out each stack 
                out.println(Arrays.toString(ll.get(f).toArray()));
            }
            out.println();
            ll.clear(); // Clears linkedList
            a = scan.nextLine(); // Scan for next card set
        }
    }
}
