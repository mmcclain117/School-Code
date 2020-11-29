import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Master
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("scooby.dat"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < a; i++) {
			String pa = scan.nextLine(); // The lost of paths
			String s[] = pa.split("[ ]"); // Pairs of paths
			String g = scan.nextLine(); // Goal
			ArrayList<CharNode> rooms = new ArrayList<>();
			ArrayList<Character> points = new ArrayList<>();
			for (String si : s) {
				CharNode c1 = new CharNode(si.charAt(0));
				CharNode c2 = new CharNode(si.charAt(1));
				c1.setNext(c2);
				c2.setNext(c1);
				rooms.add(c1);
				rooms.add(c2);
			}
			char stpoint = g.charAt(0); // Starting point
			char endpoint = g.charAt(1); // Ending Point
			int sti = -1; // Starting Index
			for (int j = 0; j < rooms.size(); j++) { // Search for Starting
														// room
				CharNode temp = rooms.get(j);
				if (temp.getChar() == stpoint) {
					sti = j;
					break;
				}
			}
			if (sti == -1) {
				System.out.println("No Not a room");
			} else {
				CharNode temp1 = rooms.get(sti);
				CharNode temp2 = temp1.getNext();
				System.out.println(temp1.getChar());
				if (temp2.getChar() == endpoint) {
					System.out.println("yes");
					break;
				} else {
					boolean found = false;
					CharNode mid = new CharNode(temp2.getChar());
					for (int h = 0; h < rooms.size(); h++) {
						if (found == true) {
							break;
						}
						for (int j = sti + 2; j < rooms.size(); ++j) {
							CharNode temp3 = rooms.get(j);
							CharNode temp4 = temp3.getNext();
							if (temp3.getChar() == mid.getChar()) {
								if (temp3.getChar() == endpoint || temp4.getChar() == endpoint) {
									System.out.println("yes");
									found = true;
									break;
								} else {
									mid = new CharNode(temp4.getChar());
								}
							} else if (temp4.getChar() == mid.getChar()) { // Check
																			// Backwards
								if (temp3.getChar() == endpoint || temp4.getChar() == endpoint) {
									System.out.println("yes");
									found = true;
									break;
								} else {
									mid = new CharNode(temp4.getChar());
								}
							}
							j++;
						}
					}
					if (found == false) {
						System.out.println("no Not found");
					}
				}
			}
			// System.out.print("X");
		}
	}
}

class CharNode {

	private CharNode next;
	private char character;

	public CharNode(char data) {
		character = data;
	}

	public char getChar() {
		return character;
	}

	public void setNext(CharNode n) {
		next = n;
	}

	public CharNode getNext() {
		return next;
	}
}
