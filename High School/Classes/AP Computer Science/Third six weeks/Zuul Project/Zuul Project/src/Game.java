
import static java.lang.System.out;
import java.util.*;

public class Game {

    public ArrayList<Room> all;
    private Parser parser;
    private Room currentRoom;
    private Room lastRoom;
    public Player p;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        all = new ArrayList<>();
        createRooms();
        parser = new Parser();
        p = new Player();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room main, foodCourt, Mars, highs, backyard, moon, shed, space, planetX, friendsHouse;
        all = new ArrayList();
// create the rooms 
        main = new Room("outside the main entrance of the university");
        foodCourt = new Room("getting hungry you are at the foudcourt");
        Mars = new Room("now teleported to mars");
        highs = new Room("at the place you have been for five days a week 7 hours a day");
        backyard = new Room("moving to the more equiped room of the backyard");
        shed = new Room("this is the storage of wepons I think.");
        moon = new Room("now on the moon and it can be dangerous if here to long");
        space = new Room("this is the room of uselessness");
        planetX = new Room("we are now in the future and on planet X and the game is almost won");
        friendsHouse = new Room("when it comes to life you can almost always rely on your friend for some help in life");
        all.add(foodCourt); // 0
        all.add(Mars); // 1
        all.add(highs); // 2
        all.add(backyard); // 3
        all.add(moon); // 4
        all.add(shed);// 5
        all.add(space); // 6
        all.add(planetX); // 7  
        all.add(friendsHouse);// 8
        // initialise room exits
        // North , east , south , west
        main.setExits(foodCourt, highs, backyard, null);
        foodCourt.setExits(null, Mars, main, null);
        Mars.setExits(null, null, highs, foodCourt);
        highs.setExits(Mars, null, null, main);
        backyard.setExits(main, null, shed, moon);
        shed.setExits(backyard, friendsHouse, null, null);
        moon.setExits(null, backyard, null, space);
        space.setExits(planetX, moon, null, null);
        planetX.setExits(null, null, space, null);
        friendsHouse.setExits(null, null, null, shed);

        currentRoom = main;  // start game outside
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
        System.out.println();
    }

    private void printLocationInfo() {
        System.out.println("You are " + currentRoom.getDescription());
        out.println(currentRoom.getExitString());
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        } else if (commandWord.equals("look")) {
            look();
        } else if (commandWord.equals("take")) {
            p.getItem();
        } else if (commandWord.equals("get")) {
            p.getItem();
        } else if (commandWord.equals("drop")) {
        } else if (commandWord.equals("")) {
        } else if (currentRoom.equals(all.get(1))) {
            return true;
        }
        return wantToQuit;
    }

    // implementations of user commands:
    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    public void printHelp() {
        System.out.println("You are lost. You are alone. You wander , and there is no win to this game , and Items may not work");
        System.out.println("around at the university, Room:" + currentRoom);
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("go quit help, quit , look , take , get ,drop");
    }

    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
//           return;
        } else {
            String direction = command.getSecondWord();

            // Try to leave current room.
            Room nextRoom = null;
            if (direction.equals("north")) {
                nextRoom = currentRoom.northExit;
            }
            if (direction.equals("east")) {
                nextRoom = currentRoom.eastExit;
            }
            if (direction.equals("south")) {
                nextRoom = currentRoom.southExit;
            }
            if (direction.equals("west")) {
                nextRoom = currentRoom.westExit;
            }

            if (nextRoom == null) {
                System.out.println("There is no door!");
            } else {
                lastRoom = currentRoom;
                currentRoom = nextRoom;
//                System.out.println("You are " + currentRoom.getDescription());
//                System.out.print("Exits: ");
                printLocationInfo();
                /*
                 if (currentRoom.northExit != null) {
                 System.out.print("north ");
                 }
                 if (currentRoom.eastExit != null) {
                 System.out.print("east ");
                 }
                 if (currentRoom.southExit != null) {
                 System.out.print("south ");
                 }
                 if (currentRoom.westExit != null) {
                 System.out.print("west ");
                 }
                 System.out.println();
                 */
            }
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

    public String look() {
        out.println("In the room there is ");
        out.println(Arrays.toString(p.ar.toArray()));
        return p.getItem();
    }
}
