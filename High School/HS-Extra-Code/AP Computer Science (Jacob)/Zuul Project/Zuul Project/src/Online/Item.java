package Online;

import java.util.ArrayList;

public class Item {

    // instance variables - replace the example below with your own
    private String description;
    private int weight;
    //private HashMap items;
    // a constant array that holds all items
    // exercise 7.20
    private ArrayList<Item> items;

    /**
     * Constructor for objects of class Item Create an item described
     * "description", and Weight
     */
    public Item(String description, int weight) {
        // initialise instance variables
        description = description;
        weight = weight;
        this.items = new ArrayList<Item>();
    }

    /**
     * Return the description of the item
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Return the weight of the item
     */
    public int weight() {
        return weight;
    }

    /**
     * Return a long description of the item that includes the description and
     * weight.
     */
    public String getLongDescription() {
        return "Item " + description + " Weight " + weight;
    }

    // exercise 7.20
    //     /**
    //      * add an item to the room when it is created
    //      */
    //     public void addItem(String description,int weight)
    //     {
    //         items.put(new Item (description, weight));
    //     }
    /**
     * create a variety of items
     */
    public void add(Item aItem) {
        items.add(aItem);
    }

    /**
     * get the item
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     *
     */
    public String getItemString() {
        String returnString = "Item:";
        {
            returnString += " " + items;
        }
        return returnString;
    }
}
