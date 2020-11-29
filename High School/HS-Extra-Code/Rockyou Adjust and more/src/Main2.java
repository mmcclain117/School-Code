// Removes extranious characters

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) throws Exception {
        shorten();
        Listout();
    }

    private static void shorten() throws Exception {
        File f = new File("New.txt");
        String fin = "";
        FileReader scan = new FileReader(f);
        FileWriter fw = new FileWriter(new File("rocks.txt"));
        int x = 0;
        int y = 0;
        while (scan.ready()) {
            char temp = (char) scan.read();
            String valid = "`1234567890-=qwertyuiop[]\\asdfghjkl;\'zxcvbnm,./ 123456789/*-+:<>?{}|_+!@#$~%^&*()";
            if (valid.contains(temp + "")) {
                if (temp == 'h') {
                    char te = (char) scan.read();
                    if (te == 't') {
                        char tf = (char) scan.read();
                        if (tf == 't') {
                            char tg = (char) scan.read();
                            if (tg == 'p') {
                                fin += "\r\n" + (temp + "") + (te + "") + (tf + "") + (tg + "");
                            } else {
                                fin += (temp + "") + (te + "") + (tf + "") + (tg + "");
                            }
                        } else {
                            fin += (temp + "") + (te + "") + (tf + "");
                        }
                    } else {
                        fin += (temp + "") + (te + "");
                    }
                } else {
                    fin += temp + "";
                    x++;
                }
            }
            y++;
            if (x % 200 == 0) {
                fw.append(fin);
                fin = "";
            }
        }
        System.out.println(y);
        System.out.println(x);
        fw.write(fin);
        fw.flush();
        fw.close();
    }

    private static void Listout() throws Exception {
        HashMap<String, Integer> hm = new HashMap();
        Scanner scan = new Scanner(new File("rocks.txt"));
        String goo = "https://www.google.com";
        String ama = "https://www.amazon.com";
// Adds default for no nullpointer
        hm.put(goo, 0);
        hm.put(ama, 0);
        hm.put("None", 0);
        while (scan.hasNext()) {
            String x = scan.nextLine();
            if (x.contains(" ")) {
                x = x.substring(0, x.indexOf(" "));
            }
            if (x.contains("www.google.com")) {
                hm.put(goo, hm.get(goo) + 1);
            } else if (x.contains("www.amazon.com")) {
                hm.put(ama, hm.get(ama) + 1);
            } else if (!x.contains("www")) {
                hm.put("None", hm.get("None") + 1);
            } else if (hm.containsKey(x)) {
                hm.put(x, hm.get(x) + 1);
            } else {
                hm.put(x, 1);
            }
        }
        Set<String> s = hm.keySet();
        Object b[] = s.toArray();
        for (int i = 0; i < hm.size(); i++) {
//            System.out.println(b[i].toString() + " " + hm.get(b[i]));
            System.out.println(hm.get(b[i]) + " " + b[i].toString());
        }
    }
}
