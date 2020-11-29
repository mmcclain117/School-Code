
import java.io.FileWriter;

/**
 *
 * @author Master
 */
public class Writing {

    public static void main(String[] args) {

    }

    public static void Write01() throws Exception {
        FileWriter fw = new FileWriter("Prob01.txt");
        fw.write("1\n"
                + "3\n"
                + "7\n"
                + "5\n"
                + "9\n"
                + "10\n"
                + "11\n"
                + "21\n"
                + "42\n"
                + "52");
        fw.flush();
        fw.close();
    }

    public static void Write02() throws Exception {
        FileWriter fw = new FileWriter("Prob02.txt");
        fw.write("9H JS AC 3H 10S 9C 5H 7C 4S QS 2D 2S 8H 9D 3D 7H 7S AS 10H\n"
                + "AS JC 7H 8D KH JC 5C 9H 10D 2S 7S 6H\n"
                + "JH KD 10D 10H 2H AH 8D 7H 5H 4D 9H 3D KH");
        fw.flush();
        fw.close();
    }

    public static void Write03() throws Exception {
        FileWriter fw = new FileWriter("Prob03.txt");
        fw.write("5 4 3 2 1\n"
                + "1 2 3 4 5 6 7 8 9 10");
        fw.flush();
        fw.close();
    }

    public static void Write04() throws Exception {
        FileWriter fw = new FileWriter("Prob04.txt");
        fw.write("pig latin rules\n"
                + "code quest is the best\n"
                + "java rules");
        fw.flush();
        fw.close();
    }

    public static void Write05() throws Exception {
        FileWriter fw = new FileWriter("Prob05.txt");
        fw.write("978-0-306-40615-7\n"
                + "9788175257665\n"
                + "1234567890123");
        fw.flush();
        fw.close();
    }

    public static void Write06() throws Exception {
        FileWriter fw = new FileWriter("Prob06.txt");
        fw.write("08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n"
                + "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n"
                + "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n"
                + "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n"
                + "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n"
                + "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n"
                + "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n"
                + "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n"
                + "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n"
                + "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n"
                + "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n"
                + "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n"
                + "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n"
                + "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n"
                + "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n"
                + "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n"
                + "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n"
                + "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n"
                + "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n"
                + "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48");
        fw.flush();
        fw.close();
    }

    public static void Write07() throws Exception {
        FileWriter fw = new FileWriter("Prob07.txt");
        fw.write("It is I\n"
                + "Code Quest\n"
                + "END OF TRANSMISSION\n"
                + "===_=_===_=___===_===_===___===_=_=___=_______===_===_=_===___=_=_===_\n"
                + "__=___=_=_=___===_______=_===_=___=_=_===___=_===_=_=___=___=_=_=\n"
                + "=_=_______=_=_=_=___===_===_===___=_===_===_=___=_______===_=_===_===_\n"
                + "__===_===_===___=_=_===_______===_===_=___=_=_===___===_=_===_===___=_\n"
                + "=_=_______=_===_=_=___=_=___===_=_===___=_______=_===_===_=___=_=___==\n"
                + "=_===_=_=___===_===_=_=___=_===\n"
                + "END OF TRANSMISSION");
        fw.flush();
        fw.close();
    }

    public static void Write08() throws Exception {
        FileWriter fw = new FileWriter("Prob08.txt");
        fw.write("20,20\n"
                + "0,10 10,20\n"
                + "20,9 10,20\n"
                + "0,0 20,9\n"
                + "4,13 6,15\n"
                + "14,15 16,13\n"
                + "3,6 4,8\n"
                + "4,5 5,7\n"
                + "5,4 6,6\n"
                + "6,4 7,5\n"
                + "6,4 14,3\n"
                + "13,4 15,5\n"
                + "14,5 16,6\n"
                + "15,6 17,7\n"
                + "17,8 16,7\n"
                + "0,9 10,10\n"
                + "0,20, 20,0\n"
                + "0,0 20,1\n"
                + "0,19, 20,20\n"
                + "0,1 1,19\n"
                + "19,1 20,19");
        fw.flush();
        fw.close();
    }

    public static void Write09() throws Exception {
        FileWriter fw = new FileWriter("Prob09.txt");
        fw.write("143\n"
                + "2.34\n"
                + "1.01\n"
                + "1234.56");
        fw.flush();
        fw.close();
    }

    public static void Write10() throws Exception {
        FileWriter fw = new FileWriter("Prob10.txt");
        fw.write("AAA========================================================GGG\n"
                + "   -|-----|------|--------|-----------|--------------------\n"
                + "BBB=======================================HHH\n"
                + "   --------|----------------|-----------|----------\n"
                + "CCC================================================III\n"
                + "   -----|--------------|--------------------|-----------------\n"
                + "DDD===========================================================JJJ\n"
                + "   -------|-------------|-------------------------------------\n"
                + "EEE============================KKK\n"
                + "   ------|----------------|---------------\n"
                + "FFF=======================================LLL");
        fw.flush();
        fw.close();
    }

    public static void Write11() throws Exception {
        FileWriter fw = new FileWriter("Prob11.txt");
        fw.write("You should\n"
                + "turn this\n"
                + "text into\n"
                + " a spiral.");
        fw.flush();
        fw.close();
    }

    public static void Write12() throws Exception {
        FileWriter fw = new FileWriter("Prob12.txt");
        fw.write("JouyWOjkg\n"
                + "rkgjIacuyzrgxguk\n"
                + "oszoXxeejyreZ\n"
                + "yXJZokzrh\n"
                + "ngX");
        fw.flush();
        fw.close();
    }

    public static void Write13() throws Exception {
        FileWriter fw = new FileWriter("Prob13.txt");
        fw.write("1 2 3\n"
                + "2 1 1 1 1 1 1 1 1\n"
                + "0 2 1 1 2 1 2 1 2\n"
                + "1 3 1");
        fw.flush();
        fw.close();
    }

    public static void Write14() throws Exception {
        FileWriter fw = new FileWriter("Prob14.txt");
        fw.write("10 23 36 49 67\n"
                + "13 26 34 50 70\n"
                + "14 20 42 59 71\n"
                + "6 25 35 47 72\n"
                + "7 27 31 57 61\n"
                + "9 24 36 48 65\n"
                + "11 16 41 47 71\n"
                + "1 19 43 56 64\n"
                + "2 17 44 53 62\n"
                + "3 18 42 51 66\n"
                + "12 20 39 59 69\n"
                + "4 22 41 55 61\n"
                + "6 29 33 53 72\n"
                + "14 17 37 58 65\n"
                + "11 16 44 47 66\n"
                + "7 26 31 57 73\n"
                + "1 21 40 55 61\n"
                + "8 29 43 47 62\n"
                + "11 27 35 46 66\n"
                + "6 16 36 52 67\n"
                + "5 16 33 47 62\n"
                + "7 27 35 52 66\n"
                + "11 22 44 51 70\n"
                + "12 19 36 49 72\n"
                + "13 21 41 59 73\n"
                + "PLAY\n"
                + "I28\n"
                + "G46\n"
                + "I16\n"
                + "N43\n"
                + "B3\n"
                + "O67\n"
                + "O62\n"
                + "O64\n"
                + "G49\n"
                + "G54\n"
                + "B7\n"
                + "N44\n"
                + "O63\n"
                + "B5\n"
                + "G57\n"
                + "B6\n"
                + "I27\n"
                + "N38\n"
                + "G55\n"
                + "B8\n"
                + "B11\n"
                + "O73");
        fw.flush();
        fw.close();
    }

    public static void Write15() throws Exception {
        FileWriter fw = new FileWriter("Prob15.txt");
        fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?><   RootElement  >\n"
                + "            <Element1    AtTrIbUTe1 = \" This  whitespace   should     \n"
                + "appear as is.\"    >  This     text\n"
                + "        should all          be\n"
                + "    on one line!\n"
                + "</Element1 ><    Element2      name=\"VALUE\"   name2=\"VAlue2\"/>< \n"
                + "Element3   attr\n"
                + "=\n"
                + "\"Element1\"   />\n"
                + "            <Element1    AtTrIbUTe1 = \" This  whitespace   should     \n"
                + "appear as is.\"    >  This     text\n"
                + "        should all          be\n"
                + "    on one line\n"
                + "    too!  Watch out for \"quoted\" content.\n"
                + "</Element1 ><    Element2      name=\"VALUE\"   name2=\"VAlue2\">  Nested \n"
                + "content< Element3   attr\n"
                + "=\n"
                + "\"Element1\"   />\n"
                + "anyone?\n"
                + "</   Element2>\n"
                + "        <operation name=\"process\">\n"
                + "            <soap:operation soapAction=\"\" style=\"document\"/>\n"
                + "            <input>\n"
                + "                <soap:body use=\"literal\"/>\n"
                + "            </input>\n"
                + "            <output>\n"
                + "                <soap:body use=\"literal\"/>\n"
                + "            </output>\n"
                + "        </operation>\n"
                + "</  RootElement   >");
        fw.flush();
        fw.close();
    }

    public static void Write16() throws Exception {
        FileWriter fw = new FileWriter("Prob16.txt");
        fw.write("----------------------\n"
                + "|xxxxt   x  xxxxxxxxx|\n"
                + "|xxx     x xxx   Txxx|\n"
                + "|xx  xx     x    xxxx|\n"
                + "|xx   xx xx    xxxxxx|\n"
                + "|xxx  xxxxxxxxxxxxxxx|\n"
                + "|xxx  xxx    t  xxxxx|\n"
                + "|xxx xxxx x xxx  xxxx|\n"
                + "|xxt        xxxx  xxx|\n"
                + "|x  xxxxxxxxxt   xxxx|\n"
                + "|xxxxxt    xxxx  xxxx|\n"
                + "|xxx  xx  xxx   xxxxx|\n"
                + "|xxxxx        xxxxxxx|\n"
                + "|H      xxxxxxxxxxxxx|\n"
                + "----------------------");
        fw.flush();
        fw.close();
    }
}
