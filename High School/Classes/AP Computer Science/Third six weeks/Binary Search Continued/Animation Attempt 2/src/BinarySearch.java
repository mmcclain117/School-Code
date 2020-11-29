
import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public int values[] = new int[100];
    private final int searchvalue = (int) (Math.random() * 100);
    private int low = 10;
    public int r = 0;
    private int high = values.length - 1;
    private int mid = (high + low) / 2;
    private Canvas c;
    public int xPos = 5;
    public int yPos = 100;
    public int size = 1;
    public int size2 = 1;

    public BinarySearch() {
        c = new Canvas();
    }

    public static void main(String args[]) throws Exception {
        boolean runs = true;
        while (runs) {
            BinarySearch binary = new BinarySearch();
            binary.fillArray();
            binary.setUp();
            binary.Search();
            binary.showRes(true);
            Thread.sleep(1000);
        }
    }

    public void fillArray() {
        Random rnd = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = rnd.nextInt(100) + 1;
        }
        Arrays.sort(values);
    }

    public void setUp() {
        c.setVisible(true);
        c.setColor(Color.gray);
        for (int i = 0; i < values.length; i++) {
            c.fillRect(i * 9 + 100, 600 - values[i] * 5, 5, values[i] * 5);
        }
        Font arial = new Font("Arial", Font.BOLD, 36);
        c.setFont(arial);
        c.setColor(Color.red);
        c.drawString("Binary Search", 450, 50);
    }

    public void Search() throws Exception {
        mid = (low + high) / 2;
        boolean ihopethisworksbecauseiamrunningoutofoptions = true;
        while (ihopethisworksbecauseiamrunningoutofoptions) {
            if (values[mid] == searchvalue) {
                showRes(true);
                ihopethisworksbecauseiamrunningoutofoptions = false;
                break;
            }
            if (high == low || high == mid || low == mid || mid != (high + low) / 2) {
                showRes(false);
                ihopethisworksbecauseiamrunningoutofoptions = false;
                break;
            }
            if (searchvalue < values[mid]) {
                while (high != mid) {
                    c.setColor(Color.BLACK);
                    c.High(high * 10, size, high * 10, 5);
                    c.fillRect(1032, 385, 150, 20);
                    high -= 1;
                    size++;
                    c.setColor(Color.RED);
                    c.High(high * 10, 650, high * 10, 5);
                    HMLS();
                    c.Low(low * 10, size2, low * 10, 5);
                    c.Mid(mid * 10);
                }
                while (mid != (high + low) / 2) {
                    c.setColor(Color.BLACK);
                    c.Mid(mid * 10);
                    c.fillRect(1030, 485, 150, 20);
                    mid -= 1;
                    c.setColor(Color.RED);
                    c.High(high * 10, size, high * 10, 5);
                    c.Low(low * 10, size2, low * 10, 5);
                    c.Mid(mid * 10);
                    HMLS();
                }
            } else if (searchvalue > values[mid]) {
                while (low != mid) {
                    c.setColor(Color.BLACK);
                    c.Low(low * 10, size2, low * 10, 5);
                    c.fillRect(1032, 585, 150, 20);
                    low += 1;
                    size2++;
                    c.setColor(Color.RED);
                    c.High(high * 10, size, high * 10, 5);
                    c.Low(low * 10, 650, low * 10, 5);
                    c.Mid(mid * 10);
                    HMLS();
                }
                while (mid != (high + low) / 2 || high == low || low == high || mid == high || mid == low) {
                    c.setColor(Color.BLACK);
                    c.Mid(mid * 10);
                    c.fillRect(1030, 485, 150, 20);
                    mid += 1;
                    c.setColor(Color.RED);
                    c.High(high * 10, size, high * 10, 5);
                    c.Low(low * 10, size2, low * 10, 5);
                    c.Mid(mid * 10);
                    HMLS();
                }
            }
        }
    }

    public void showRes(boolean x) { // Show Result
        Font arial = new Font("Arial", Font.BOLD, 36);
        c.setFont(arial);
        c.setColor(Color.black);
        c.fillRect(400, 100, 400, 100);
        String result = searchvalue + " ";
        c.setColor(Color.WHITE);
        result += x ? "was found at " + mid : " was not found";
        c.drawString(result, 500, 200);
        HMLS();
    }

    public void HMLS() { // High , Mid, low , and searching value
        Font def = new Font("Times New Roman", Font.PLAIN, 25);
        c.setFont(def);
        c.setColor(Color.black);
        c.fillRect(1000, 100, 400, 1000);
        c.setColor(Color.CYAN);
        c.drawString("High- Index: " + high + " Value: " + values[high], 1000, 200);
        c.setColor(Color.WHITE);
        c.drawString("Midpoint- Index: " + mid + " Value: " + values[mid], 1000, 250);
        c.setColor(Color.yellow);
        c.drawString("Low- Index: " + low + " Value: " + values[low], 1000, 300);
        c.setColor(Color.gray);
        c.drawString("Searching For: " + searchvalue, 1000, 350);
        c.setColor(Color.BLACK);
    }
}
