
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Chores {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        out.println("Enter the number of weeks");
        int weekcount = in.nextInt();
        Random rnd = new Random();
        String weekend1 = "Laundry";
        String weekend2 = "Kitchen";
        String weekend3 = "Bathrooms";
        String weekend4 = "Free";
        String weekday1 = "Dishwasher";
        String weekday2 = "Kitchen";
        String weekday3 = "Cats";
        String weekday4 = "Free";
        out.println("Enter the number of people");
        int peoplenum = 4; // in.nextInt();
        ArrayList<String> people = new ArrayList<>();
        ArrayList<String> weekday = new ArrayList<>();
        ArrayList<String> weekend = new ArrayList<>();
        ArrayList<String> curday = new ArrayList<>();
        ArrayList<String> curend = new ArrayList<>();
        ArrayList<String> lasday = new ArrayList<>();
        ArrayList<String> lasend = new ArrayList<>();
        weekday.add(weekday1);
        weekday.add(weekday2);
        weekday.add(weekday3);
        weekday.add(weekday4);
        weekend.add(weekend1);
        weekend.add(weekend2);
        weekend.add(weekend3);
        weekend.add(weekend4);
        Collections.shuffle(weekday, rnd);
        Collections.shuffle(weekend, rnd);
        Collections.shuffle(weekday, rnd);
        Collections.shuffle(weekend, rnd);
        lasday.addAll(weekday);
        lasend.addAll(weekend);
        curend.addAll(weekend);
        curday.addAll(weekday);
        people.add("Person1");
        people.add("Person2");
        people.add("Person3");
        people.add("Person4");
        people.add("Person5");
        int weekcounting = 1;
        while ((weekcount - weekcounting) + 1 != 0) {
            out.println("Week " + weekcounting);
            if (weekcounting == 1) {
                for (int i = 0; i < 4; i++) {
                    out.println(people.get(i) + " : " + lasday.get(i) + " , " + lasend.get(i));
                }
            } else {
                boolean xs = true;
                boolean rightday = false;
                boolean rightend = false;
                while (!rightday) {
                    int iter = 0;
                    xs = true;
                    while (iter < 4) {
                        if (lasday.get(iter).equals(curday.get(iter))) {
                            xs = false;
                        }
                        iter++;
                    }
                    if (xs) {
                        rightday = true;
                    } else {
                        Collections.shuffle(curday);
                    }
                }
                while (!rightend) {
                    int iter = 0;
                    while (iter < 4) {
                        if (lasend.get(iter).equals(curend.get(iter))) {
                            xs = false;
                        }
                        iter++;
                    }
                    if (xs) {
                        rightend = true;
                    } else {
                        Collections.shuffle(curend);
                        xs = true;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    out.println(people.get(i) + " : " + curday.get(i) + " , " + curend.get(i));
                }
            }
            for (int i = 0; i < 10; i++) {
                Collections.shuffle(weekday, rnd);
                Collections.shuffle(weekend, rnd);
            }
            lasend.removeAll(lasend);
            lasday.removeAll(lasday);
            lasend.addAll(curend);
            lasday.addAll(curday);
            weekcounting++;
        }
    }
}
