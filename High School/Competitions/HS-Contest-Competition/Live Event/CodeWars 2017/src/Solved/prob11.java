package Solved;

import java.util.*;
import java.io.*;

public class prob11 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob11.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        int t = scan.nextInt();
        int v = scan.nextInt(); // Number
        int o[] = new int[v];
        for (int i = 0; i < v; i++) {
            o[i] = scan.nextInt();
        }
        HashMap<String, Integer> hm = new HashMap();
        String numb = "";
        String rem = "";
        for (int i = 0; i < n * m; i++) {
            String temp = scan.next();
            numb += temp + " ";
            if (hm.containsKey(temp)) {
                hm.put(temp, hm.get(temp) + 1);
//		System.out.println(hm.get(temp));
                if ((int) hm.get(temp) >= t - 1) {
                    rem += temp;
                }
            } else {
                hm.put(temp, 0);
            }
        }
//	System.out.println(rem);
        numb = numb.replaceAll(rem, " ");
        char ch[] = rem.toCharArray();
        for (char c : ch) {
            numb = numb.replaceAll(c + "", " ");
        }
//	System.out.println(numb);
        numb = numb.replaceAll("[ ]+", " ");
//	System.out.println(numb);
        int cur = 0;
        int p = 0;
        int con = 0;
        String x[] = numb.split(" ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[cur]);
            if (p > o[con] - 1) {
                p = 0;
                con++;
                System.out.print(" ");
            }
            p++;
//	    p++;
            cur++;
//	    System.out.print(" ");
        }
        System.out.println();
//	Collection<Integer> values = hm.values();
//	Iterator it = values.iterator();
//	Set<String> keySet = hm.keySet();
//	Iterator ks = keySet.iterator();
//	while (ks.hasNext()) {
////	    System.out.println((Integer)it.next());
////	    System.out.println((String) ks.next());
//	    if (hm.get(ks.next()) > t) {
//		numb = numb.replaceAll((String) ks.next(), " ");
////	    } else {
////		ks.next();
//	    }
//	}
//	System.out.println(numb);
    }

}
