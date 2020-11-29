
import java.io.File;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Outline {
// String ba

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        out.println("Program: Compare, Compression, Converter, OCR, Encryption, Combination, Moving");
        String opt = scan.nextLine();
        if (opt.equalsIgnoreCase("compare")) {
            out.println("Compare: Files, Folder, Drive");
            String e = scan.nextLine();
            if (e.equalsIgnoreCase("Files")) {
                out.println("Compare||Files: Enter the file paths and break to stop");
                String s = scan.nextLine();
                ArrayList<String> t = new ArrayList<>(); // Files to compare
                while (!s.equalsIgnoreCase("break")) {
                    t.add(s);
                    s = scan.nextLine();
                }
                CompareOpt(t);
//                Create a file that is like a Hashmap with the different words and number of apperences
            } else if (e.equalsIgnoreCase("Folder")) {
                out.println("Compare||Folder: Enter in the folder path");
                String r = scan.nextLine();
                CompareOpt(r);
            } else if (e.equalsIgnoreCase("Drive")) {
                out.println("Compare||Drive: Enter the drive path, or Full to scan the whole computer");
                String q = scan.nextLine();
                if (q.equalsIgnoreCase("full")) {
                    ArrayList<String> v = new ArrayList();
                    File w[] = File.listRoots();
                    for (File x : w) {
                        v.add(Arrays.toString(w));
                    }
                    CompareOpt(v);
                } else if (!(q.equals(null))) {
                    CompareOpt(q);
                } else {
                    out.println("That doesn't work");
                }
            } else {
                out.println("That is not one of the choices");
            }
        } else if (opt.equalsIgnoreCase("Compression")) {
            out.println("Compression: Compress, Decompress");
            String f = scan.nextLine();
            if (f.equalsIgnoreCase("Compress")) {
                out.println("Compression||Compress: Single, Multiple Files");
                String p = scan.nextLine();
                if (p.equalsIgnoreCase("Single")) {
                    out.println("Compression||Compress||Single: Enter the File path");
                    String y = scan.nextLine();
                } else if (p.equalsIgnoreCase("Multiple Files")) {
                    out.println("Compression||Compress||Multiple Files: Enter File path and break when done");
                    String z = scan.nextLine();
                    ArrayList<String> aa = new ArrayList();
                    while (!z.equalsIgnoreCase("break")) {
                        aa.add(z);
                        z = scan.nextLine();
                    }
                } else {
                    out.println("That is not one of the options");
                }
            } else if (f.equalsIgnoreCase("Decompress")) {
                out.println("Compression||Decompress: Single, Multiple Files");
                String o = scan.nextLine();
                if (o.equalsIgnoreCase("Single")) {
                    out.println("Compression||Decompress||Single: Enter the File path");
                    String ab = scan.nextLine();
                    Comp(ab);
                } else if (o.equalsIgnoreCase("Multiple Files")) {
                    out.println("Compression||Decompress||Multiple Files: Enter the file paths and break when done");
                    String ac = scan.nextLine();
                    ArrayList<String> al = new ArrayList();
                    while (ac.equalsIgnoreCase("break")) {
                        al.add(ac);
                        ac = scan.nextLine();
                    }
                    out.println("Compression||Decompress||Multiple Files: Export to seperate folders, Same Folder");
                    if (ac.toLowerCase().contains("seperate")) {
                        out.println("Compression||Decompress|| Multiple Files||Seperate: Enter the Extracted file path");
//                        Seperate the folders from specified files
                        String ad = scan.nextLine();
                        Decomp(ad);
                    } else if (ac.toLowerCase().contains("same")) {
                        out.println("Compression||Decompress||Multiple Files||Same: Enter the file paths and break to stop, defaut to do file name");
                        String ae = scan.nextLine();
                        if (ae.equalsIgnoreCase("default")) {
//                            go Thorugh and pick out the directories
//                            Then decompress  Decomp();
                        } else {
                            ArrayList<String> af = new ArrayList();
                            while (!ae.equalsIgnoreCase("break")) {
                                af.add(ae);
                                ae = scan.nextLine();
                            }
                            Decomp(af);
                        }
                    } else {
                        out.println("That is not an option");
                    }
                } else {
                    out.println("That is not one of the options");
                }
            } else {
                out.println("That is not one of the choices");
            }
        } else if (opt.equalsIgnoreCase("Converter")) {
            out.println("Converter: Single, Multiple Files, Folder");
            String h = scan.nextLine();
            if (h.equalsIgnoreCase("Single")) {
                out.println("Converter||Single: Enter the file path");
                String ag = scan.nextLine();
                out.println("Converter||Single: Enter the converter type");
                String ah = scan.nextLine();
                if (CheckFormat(ah)) {
                    Convert(ah);
                } else {
                    out.println("Can not convert to that format yet");
                }
            } else if (h.equalsIgnoreCase("Multiple Files")) {
                out.println("Converter||Multiple Files: Enter the File paths and break to stop");
                String ai = scan.nextLine();
                ArrayList<String> ak = new ArrayList();
                while (ai.equalsIgnoreCase("break")) {
                    ak.add(ai);
                    ai = scan.nextLine();
                }
                Convert(ak);
            } else if (h.equalsIgnoreCase("Folder")) {
                out.println("Converter||Folder: Enter the File path");
                String aj = scan.nextLine();
                File am[] = new File(aj).listFiles();
                ArrayList<String> ao = new ArrayList();
                for (File an : am) {
                    ao.add(an.toString());
                }
                Convert(ao);
            } else {
                out.println("That is not one of the options ");
            }
        } else if (opt.equalsIgnoreCase("OCR")) {
            out.println("OCR: Batch or Single");
            String a = scan.nextLine();
            if (a.equalsIgnoreCase("batch")) {
                out.println("OCR||Batch: Folder, Multiple Files");
                String b = scan.nextLine();
                if (b.equalsIgnoreCase("Folder")) {
                    out.println("OCR||Batch||Folder: Enter the folder path"); // Need to finish
                    String n = scan.nextLine();
                } else if (b.toLowerCase().contains("multiple") || b.toLowerCase().contains("files")) {
                    out.println("OCR||Batch||Multiple Files: Enter the file paths and break to stop"); // Need to finish
                    String m = scan.nextLine();
                    ArrayList<String> az = new ArrayList();
                    while (!m.equalsIgnoreCase("break")) {
                        az.add(m);
                        m = scan.nextLine();
                    }
                } else {
                    out.println("That is not one of the choices");
                }
            } else if (a.equalsIgnoreCase("Single")) {
                out.println("OCR||Single: Enter the file path");
                String c = scan.nextLine();
                File d = new File(c);
                out.println("OCR||Single: Enter the format of file output");
                String g = scan.nextLine(); // Need to finish all the format opertunities
            } else {
                out.println("That is not one of the choices");
            }

        } else if (opt.equalsIgnoreCase("Encryption")) {
            out.println("Encryption: Single, Multiple, Folder, Drive");
            String i = scan.nextLine();
            if (i.equalsIgnoreCase("Single")) {
                out.println("Encryption||Single: Enter the file path");
                String aq = scan.nextLine();
                Encrypt(aq);
            } else if (i.equalsIgnoreCase("Multiple")) {
                out.println("Encryption||Multiple: Enter the files and break to stop");
                String ar = scan.nextLine();
                ArrayList<String> as = new ArrayList();
                while (!ar.equalsIgnoreCase("break")) {
                    as.add(ar);
                    ar = scan.nextLine();
                }
                Encrypt(as);
            } else if (i.equalsIgnoreCase("Folder")) {
                out.println("Encryption||Folder: Enter the folder Path");
                String at = scan.nextLine();
                ArrayList<String> au = new ArrayList();
                au.add(at);
                Encrypt(au);
            } else if (i.equalsIgnoreCase("Drive")) {
                out.println("Encryption||Drive: Enter the drive path or full to do full computer");
                String av = scan.nextLine();
                if (av.equalsIgnoreCase("full")) {
                    ArrayList<String> aw = new ArrayList();
                    File ax[] = File.listRoots();
                    for (File ay : ax) {
                        aw.add(ay.toString());
                    }
                    Encrypt(aw);
                } else if (!av.equals(null)) {
                    Encrypt(av);
                } else {
                    out.println("That is not one of the options");
                }
            } else {
                out.println("That is not an option right now");
            }
        } else if (opt.equalsIgnoreCase("Combination")) {
            out.println("Combination: Enter the thing you want to do seperated by space"); // Need to finish
            String j = scan.nextLine();
            String ap[] = j.split("\\s+");
//            When in methods can call each method by the file name
        } else if (opt.equalsIgnoreCase("Move")) {
            out.println("Move: File, Multiple Files, Folder, Multiple Folders"); // Need to finish
            String k = scan.nextLine();
        } else {
            out.println("That is not a choice");
            String l = scan.nextLine();
        }
    }

    private static void CompareOpt(String r) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void CompareOpt(ArrayList t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void Comp(String ab) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void Decomp(String ad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void Decomp(ArrayList<String> af) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void Convert(String ah) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static boolean CheckFormat(String ah) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void Convert(ArrayList<String> ak) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void Encrypt(String aq) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void Encrypt(ArrayList<String> as) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
