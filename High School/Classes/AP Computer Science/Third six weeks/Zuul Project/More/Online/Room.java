
package Online;

import java.util.*;

/**
 *  This is the Zuul-Starter file used for the Homework.  Please add the 
 *  appropriate class comments below
 *  
 *  @author: Carolyn Leithner
 *  @version: Feb 10,2011 
 */
public class Room {

    public String description;
    private HashMap<String, Room> exits;
    /*
     private Room northExit;
     private Room southExit;
     private Room eastExit;
     private Room westExit;
     */
    // exercise 7.20
    private ArrayList<Item> items;
    //private HashMap<String, Item> items;
    private String item;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
        //addItem(items);
        //items = new ArrayList<String, Room>();
    }

    // starter file

    /**
     * Define an exit from this room.
     *
     * @param direction The direction of the exit.
     * @param neighbor The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
        /*
         if(direction.equals("north")) {
         return northExit;
         }
         if(direction.equals("east")) {
         return eastExit;
         }
         if(direction.equals("south")) {
         return southExit;
         }
         if(direction.equals("west")) {
         return westExit;
         }
         return null;
         */
    }

    /**
     * Return a string describing the room's exits, for example "Exits: north
     * west".
     *
     * @return Details of the room's exits.
     */
    public String getExitString() {
        /*
         String exitString = "Exits: ";
         if(northExit != null)
         exitString += "north ";
         if(eastExit != null)
         exitString += "east ";
         if(southExit != null)
         exitString += "south ";
         if(westExit != null)
         exitString += "west ";
         return exitString;
         */
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    //exercise 7.11

    /**
     * Return a long description of this room, of the form: You are in the
     * kitchen Exits: north west
     *
     * @return A description of the room, including exits.
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString() + ".\n";
        // + "Items in Room" + getItemString();
    }

    //     // exercise 7.20

    /**
     * add an item to the room when it is created
     */
    public void addItem(Item item) {
        addItem(item);
    }
}

