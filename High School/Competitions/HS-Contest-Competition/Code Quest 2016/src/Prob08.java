import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
// Wrong
public class Prob08 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob08.in.txt"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < a; i++) {
			int b = scan.nextInt();
			scan.nextLine();
			TreeMap<String, ArrayList<String>> tm = new TreeMap<>();
			for (int ii = 0; ii < b; ii++) {
				String s = scan.nextLine();
				String son = s.split(" - ")[0];
				String art = s.split(" - ")[1];
				if (tm.containsKey(art)) {
					ArrayList temp = tm.get(art);
					temp.add(son);
					Collections.sort(temp);
					tm.put(art, temp);
				} else {
					ArrayList ll = new ArrayList();
					ll.add(son);
					tm.put(art, ll);
				}
			}
			Set<String> set = tm.keySet();
			Iterator<String> it = set.iterator();
 			for(int ii =0;ii < tm.size();ii++) {
 				String temper  = it.next();
 				System.out.println(temper);
				ArrayList<String>temp = tm.get(temper);
				for(String ax:temp) {
					System.out.println(ax + " - "+ temper);
				}
 			}
//			Iterator it =tm.
		}
	}
}
