
import static java.lang.System.out;
import java.util.*;

public class Room {

    private HashMap<String, Room> exits;
    private String description;
    public HashMap<Item, Room> item;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
//        item = loadI();
    }

    /**
     * Define the exits of this room. Every direction either leads to another
     * room or is null (no exit there).
     *
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west) {
        if (north != null) {
            northExit = north;
        }
        if (east != null) {
            eastExit = east;
        }
        if (south != null) {
            southExit = south;
        }
        if (west != null) {
            westExit = west;
        }
        if (north != null) {
            exits.put("North", north);
        }
        if (east != null) {
            exits.put("East", east);
        }
        if (south != null) {
            exits.put("South", south);
        }
        if (west != null) {
            exits.put("West", west);
        }

    }

    public void getExit() {
        if (northExit != null) {
            System.out.print("north ");
        }
        if (eastExit != null) {
            System.out.print("east ");
        }
        if (southExit != null) {
            System.out.print("south ");
        }
        if (westExit != null) {
            System.out.print("west ");
        }
//        return exits.get(direction);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    public void addItem(Item item) {
        Class<Game> g = Game.class;
        Main.g.p.grabItem(item);
    }

    public String getExitString() {
        String returns = "Exits: ";
        Set<String> keys = exits.keySet();
        for (String exits : keys) {
            returns += " " + exits;
        }
//        returns = keys.stream().map((_item) -> " " + exits).reduce(returns, String::concat);
//        out.println(keys.toString());
        return returns;
    }

    public String getLongDescription() {
        out.println(getDescription());
        return Main.g.look();
    }
    /*
     private static HashMap<Item, Room> loadI() {
     HashMap<Item, Room> a = new HashMap();
     Item r = new Item("Rover", 120);
     Item p = new Item("Pool", 300);
     Item h = new Item("Hose", 6);
     Item w = new Item("Wood", 10);
     Item s = new Item("Screws", 5);
     Game g = Main.g;
     ArrayList<Room> ar = g.all;
     a.put(r, ar.get(2));
     a.put(p, ar.get(4));
     a.put(h, ar.get(4));
     a.put(w, ar.get(4));
     a.put(s, ar.get(4));
     //        a.put(null, null);
     //        a.put(null, null);
     //        a.put(null, null);
     //        a.put(null, null);
     //        a.put(null, null);
     return a;
     }
     */
}
