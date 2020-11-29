
import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public class Item {

    public ArrayList<Item> backpack;
    public String descript;
    public int weigh;

    public Item(String description) {
        backpack = new ArrayList();
    }

    public Item setItem(String description) {
        return new Item(description);
    }

    public void drop(Item i) {
        int a = backpack.indexOf(i);
        backpack.remove(a);
    }
}
