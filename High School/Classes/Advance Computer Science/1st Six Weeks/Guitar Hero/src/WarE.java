
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 180869
 */
public class WarE {
//    Look at taking out the breaking statements

    public static void main(String[] args) throws IOException {
        File x = File.createTempFile("a.txt", null);
        FileWriter fw = new FileWriter(x);
        fw.write("8d 8c 9c 7c 5d 4c Js Qc 5s Ts Jc Ad 7d Kh Tc 3s 8s 2d 2s 5h 6d Ac 5c 9h 3d 9d\n"
                + "4d Ks As 4h Jh 6h Jd Qs Qh 6s 6c 2c Kc 4s Ah 3h Qd 2h 7s 9s 3c 8h Kd 7h Th Td\n"
                + "9h Qd Qs 9s Ac 8h Td Jc 7s 2d 6s As 4h Ts 6h 2c Kh Th 7h 5s 9c 5d Ad 3h 8s 3c\n"
                + "6d 9d 8c 4s Kc 7c 4d Tc Kd 3s 5h 2h Ks 5c 2s Qh 8d 7d 3d Ah Js Jd 4c Jh 6c Qc\n"
                + "Ah As 4c 3s 7d Jc 5h 8s Qc Kh Td 3h 5c 9h 8c Qs 3d Ks 4d Kd 6c 6s 7h Qh 3c Jd\n"
                + "2h 8h 7s 2c 5d 7c 2d Tc Jh Ac 9s 9c 5s Qd 4s Js 6d Kc 2s Th 8d 9d 4h Ad 6h Ts");
        fw.flush();
        fw.close();
        Scanner scan = new Scanner(x);
        while (scan.hasNext()) {
            String p1 = scan.nextLine();
            String p2 = scan.nextLine();
            RingBuffer pa = new RingBuffer(54);
            RingBuffer pb = new RingBuffer(54);
            String y[] = p1.split("\\s+");
            String z[] = p2.split("\\s+");
            for (String o : y) {
                String d = o.substring(0, 1);
                if (d.equals("J")) {
                    pa.enqueue(11);
                } else if (d.equals("Q")) {
                    pa.enqueue(12);
                } else if (d.equals("K")) {
                    pa.enqueue(13);
                } else if (d.equals("A")) {
                    pa.enqueue(14);
                } else if (d.equals("T")) {
                    pa.enqueue(10);
                } else {
                    pa.enqueue(Double.parseDouble(o.substring(0, 1)));
                }
            }
            for (String o : z) {
                String d = o.substring(0, 1);
                if (d.equals("J")) {
                    pb.enqueue(11);
                } else if (d.equals("Q")) {
                    pb.enqueue(12);
                } else if (d.equals("K")) {
                    pb.enqueue(13);
                } else if (d.equals("A")) {
                    pb.enqueue(14);
                } else if (d.equals("T")) {
                    pb.enqueue(10);
                } else {
                    pb.enqueue(Integer.parseInt(o.substring(0, 1)));
                }
            }
            pa.dequeue();
            pb.dequeue();
            int con = 0;
            int tie = 0;
            int paW = 0;
            while ((pa.size() > 0 && pb.size() >= 0)) {
                if (con < 100000) {
                    tie++;
                    ArrayList<Double> ix = new ArrayList();
                    RingBuffer rb = new RingBuffer(53);
                    double x1 = pa.dequeue();
                    double x2 = pb.dequeue();
                    if (x1 > x2) {
                        con++;
                        pa.enqueue(x1);
                        pa.enqueue(x2);
                    } else if (x2 > x1) {
                        con++;
                        pb.enqueue(x1);
                        pb.enqueue(x2);
                    } else {
                        boolean war = true;
                        rb.enqueue(x1);
                        rb.enqueue(x2);
//                        ix.add(x1);
//                        ix.add(x2);
                        while (war) {
                            con++;
                            double d1 = pa.dequeue();
//                            ix.add(d1);
                            rb.enqueue(d1);
                            double d2 = pb.dequeue();
//                            ix.add(d2);
                            rb.enqueue(d2);
                            d1 = pa.dequeue();
                            d2 = pb.dequeue();
//                            ix.add(d1);
//                            ix.add(d2);
                            rb.enqueue(d1);
                            rb.enqueue(d2);
                            if (d1 > d2) {
//                                for (int i = ix.size() - 1; i >= 0; i--) {
//                                    pa.enqueue(ix.get(i));
//                                    ix.remove(i);
//                                }
                                while (rb.size() > 0) {
//                                    out.println(pb.peek());
                                    if (rb.peek() == 0.0) {
                                        double w = rb.dequeue();
                                    } else {
                                        pa.enqueue(rb.dequeue());
                                    }
                                }
                                war = false;
//                                break;
                            } else if (d1 < d2) {
//                                for (int i = ix.size() - 1; i >= 0; i--) {
//                                    pb.enqueue(ix.get(i));
//                                    ix.remove(i);
//                                }
                                while (rb.size() > 0) {
//                                    out.println(pb.peek());
                                    if (rb.peek() == 0.0) {
                                        double w = rb.dequeue();
                                    } else {
                                        pb.enqueue(rb.dequeue());
                                    }
                                }
//                                out.println(Arrays.toString(pb.buffer));
                                war = false;
//                                break;
                            }
                        }
//                        out.println(pa.size() + " " + pb.size());
                    }
                    con++;
                } else {
                    break;
                }
            }
//            out.println(con);
            if (con >= 100000) {
                out.println("Tied game stopped at 100000 plays.");
            } else if (pa.size() > pb.size()) {
                out.println("Player 1 Wins!");
            } else if (pb.size() > pa.size()) {
                out.println("Player 2 Wins!");
            }
        }
    }
}
