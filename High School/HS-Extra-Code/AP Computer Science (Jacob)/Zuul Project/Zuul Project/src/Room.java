
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via exits. The exits are labelled north, east, south, west.
 * For each direction, the room stores a reference to the neighboring room, or
 * null if there is no exit in that direction.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room {

    private HashMap<String, Room> exits;
    private String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
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
//        if (north != null) {
//            exits.put("North", north);
//        }
//        if (east != null) {
//            exits.put("East", east);
//        }
//        if (south != null) {
//            exits.put("South", south);
//        }
//        if (west != null) {
//            exits.put("West", west);
//        }
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
        addItem(item);
    }

    public String getExitString() {
        return null;
    }
}
