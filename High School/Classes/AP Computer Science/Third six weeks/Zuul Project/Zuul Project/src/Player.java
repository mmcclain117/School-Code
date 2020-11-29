
import java.util.ArrayList;
import java.util.Arrays;

// Need To include
//talk, move between rooms, hold/give/receive items, fight)
public class Player {

    ArrayList<Item> ar;

    public Player() {
        Room r = new Room("This is the room");
        ar = new ArrayList();
//        ar = (ArrayList<Item>) r.item.keySet();
//        ar = item.keySet();
    }

    public String getItem() {
        return Arrays.toString(ar.toArray());
    }

    public void grabItem(Item item) {
        ar.add(item);
    }
}
