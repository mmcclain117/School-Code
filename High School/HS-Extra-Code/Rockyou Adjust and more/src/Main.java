
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        shorten();
//        combo8();
    }

    public static void shorten() throws Exception {
        File f = new File("rockyou.txt");
        String fin = "";
        Scanner scan = new Scanner(f);
        FileWriter fw = new FileWriter(new File("rock.txt"));
        int x = 0;
        int y = 0;
        while (scan.hasNext()) {
            String temp = scan.nextLine();
            if (temp.length() >= 8) {
                fin += temp + "\r\n";
                x++;
            }
            y++;
            if (x % 200 == 0) {
                fw.append(fin);
                fin = "";
                System.out.println(x);
            }
        }
        System.out.println(y);
        System.out.println(x);
        fw.write(fin);
        fw.flush();
        fw.close();
    }

    private static void combo8() throws Exception {
        File f = new File("combo.txt");
        FileWriter fw = new FileWriter(f);
        ArrayList<String> ar = new ArrayList<>();
        int u = 0;
        for (int a = 0; a < 26; a++) {
            StringBuffer sb = new StringBuffer();
            sb.append((char) (a + 'a'));
            for (int b = 0; b < 26; b++) {
                sb.append((char) (b + 'a'));
                for (int c = 0; c < 26; c++) {
                    sb.append((char) (c + 'a'));
                    for (int d = 0; d < 26; d++) {
                        sb.append((char) (d + 'a'));
                        System.out.println(u++);
                        if (u == 8272) {
                            break;
                        }
                        ar.add(sb.toString());
                        sb.deleteCharAt(sb.length() - 1);
                        sb.trimToSize();
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.trimToSize();
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        for (String xx : ar) {
            System.out.println(xx);
        }
    }
}
