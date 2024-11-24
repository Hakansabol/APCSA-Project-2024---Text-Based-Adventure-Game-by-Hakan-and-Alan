// hakan and alan

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//#region RUNTIME
class runtime {
    static runtime r;
    static boolean fastType = false;
    static Scanner keyboard = new Scanner(System.in);
    static ArrayList<Room> rooms = new ArrayList<>(); 
    static ArrayList<String> items = new ArrayList<>();
    public boolean hasKey() { return items.contains("KEY"); }
    public Room findRoom(String name) {
        for (Room iterRoom : rooms) {
            if (iterRoom.Name().equals(name)) return iterRoom;
        }
        return rooms.get(0);
    }
    @SuppressWarnings("ConvertToStringSwitch")
    public void run() throws InterruptedException {
        slowType("\nType \"help\" for information on how to play the game.\n");
        r = this;
        
        rooms.add(new Room());
        rooms.add(new PrisonCell());
        rooms.add(new Hallway());
        rooms.add(new Common());
        rooms.add(new Cafeteria());
        rooms.add(new TrapdoorRoom());
        rooms.add(new WardensRoom());
        
        Room currentRoom = rooms.get(1);

        System.out.print("\nYou are in: ");
        System.out.println(currentRoom.Name());
        slowType(currentRoom.Description());
        { // PRINT ITEMS TEXT
        String droppedItemsString = "";
        if ( !currentRoom.droppedItems.isEmpty()) {
            droppedItemsString += ("\nOn the ground you see a ");
            int ic = 0;
            for (String a : currentRoom.droppedItems) {
                droppedItemsString += (a);
                if (currentRoom.droppedItems.size() > ic && currentRoom.droppedItems.size() > 2 && currentRoom.droppedItems.size() != ic + 1) {
                    droppedItemsString += (",");
                }
                if (currentRoom.droppedItems.size() == ic + 2 && currentRoom.droppedItems.size() > 1) {
                    droppedItemsString += (" and a ");
                }
                else if (currentRoom.droppedItems.size() > 1 && currentRoom.droppedItems.size() != ic + 1)
                droppedItemsString += (" a ");
                
                ic ++;
            }
            droppedItemsString += (".");
        }
        slowType(droppedItemsString);
        System.out.println();
        }
        while (true) {
            // Print newline input line
            System.out.print("\n> ");
            // Get the first two words of the next input
            String cmd = "";
            String s = keyboard.nextLine().trim();
            if (s.equals("skip")) {
                fastType = !fastType;
                slowType("Fast text " + (fastType ? "enabled!\n" : "disabled!\n"));
                continue;
            }
            if (s.equals("help")) slowType(draft.HELP);
            for (char a : s.toCharArray()) {
                if(a == ' ') break; 
                cmd = cmd + a;
            }
            String obj = "";
            if (s.indexOf(' ') >= 0) obj = s.substring(s.indexOf(' ') + 1);
            cmd = cmd.toLowerCase();
            obj = obj.toLowerCase();
            // First word of an input is the command
            cmd = inputs.inputManagement(cmd);
            if (cmd.equals( "GO" )) {
                // Find the requested room by the rooms arraylist
                // Takes the input and checks it against the hashmap of room connections in every room.
                Room nextRoom = findRoom(currentRoom.roomLinks.getOrDefault(obj, draft.genfail));
                if (nextRoom.isLocked) {
                    slowType("You can't go there.");
                }
                else if (nextRoom != rooms.get(0)){
                    currentRoom = (nextRoom);
                    System.out.print("\nYou are in: ");
                    System.out.println(currentRoom.Name());
                    slowType(currentRoom.Description());

                    { // PRINT ITEMS TEXT
                        String droppedItemsString = "";
                        if ( !currentRoom.droppedItems.isEmpty()) {
                            droppedItemsString += ("\nOn the ground you see a ");
                            int ic = 0;
                            for (String a : currentRoom.droppedItems) {
                                droppedItemsString += (a);
                                if (currentRoom.droppedItems.size() > ic && currentRoom.droppedItems.size() > 2 && currentRoom.droppedItems.size() != ic + 1) {
                                    droppedItemsString += (",");
                                }
                                if (currentRoom.droppedItems.size() == ic + 2 && currentRoom.droppedItems.size() > 1) {
                                    droppedItemsString += (" and a ");
                                }
                                else if (currentRoom.droppedItems.size() > 1 && currentRoom.droppedItems.size() != ic + 1)
                                droppedItemsString += (" a ");
                                
                                ic ++;
                            }
                            droppedItemsString += (".");
                        }
                        slowType(droppedItemsString);
                    }
                }
            }
            else if (cmd.equals( "PICKUP") ){
                int item = currentRoom.droppedItems.indexOf(inputs.itemManagement(obj));
                if (item == -1) {
                    String tryGetItem = currentRoom.Grab(inputs.itemManagement(obj));
                    if (tryGetItem.equals("")) {
                    }
                    else if (tryGetItem.equals(draft.genfail))
                    slowType("You weren't able to grab any of those.");
                    else {
                    slowType(tryGetItem);
                        items.add(inputs.itemManagement(obj));
                    }
                }
                else {
                    items.add(currentRoom.droppedItems.get(item));
                    currentRoom.droppedItems.remove(item);
                    slowType("You picked up the " + inputs.itemManagement(obj) + "!", typeSpeedSlow);
                }
            }
            else if (cmd.equals("DROP")) {
                int item = items.indexOf(inputs.itemManagement(obj));
                if (item == -1) {
                    slowType("You're not carrying that...");
                }
                else {
                    currentRoom.droppedItems.add(items.get(item));
                    items.remove(item);
                    slowType("You placed the " + inputs.itemManagement(obj) + " back on the ground.", typeSpeedSlow);
                }
            }
            else if (cmd.equals("LOOK")) {
                String tryGetItem = currentRoom.Inspect(inputs.itemManagement(obj));
                if (obj.equals("")) {
                    System.out.print("\nYou are in: ");
                    System.out.println(currentRoom.Name());
                    slowType(currentRoom.Description());
                }
                else {
                    String nex = currentRoom.Inspect(obj);
                    if (nex.equals(draft.genfail)) slowType("You don't see anything of interest.");
                    else slowType(nex);
                }
            }
            else if (cmd.equals("INVENTORY")) {
                { // PRINT ITEMS TEXT
                    String inventoryStr = "";
                    if ( !items.isEmpty()) {
                        inventoryStr += ("\nYou have a ");
                        int ic = 0;
                        for (String a : items) {
                            inventoryStr += (a);
                            if (items.size() > ic && items.size() > 2 && items.size() != ic + 1) {
                                inventoryStr += (",");
                            }
                            if (items.size() == ic + 2 && items.size() > 1) {
                                inventoryStr += (" and a ");
                            }
                            else if (items.size() > 1 && items.size() != ic + 1)
                            inventoryStr += (" a ");
                            
                            ic ++;
                        }
                        inventoryStr += (".");
                    }
                    else {
                        inventoryStr = "You aren't carrying anything.";
                    }
                    slowType(inventoryStr);
                }
            }
            else if (cmd.equals("USE")) {
                String itemToUse = inputs.itemManagement(obj);
                if (items.contains(itemToUse)) {
                    String outputText = currentRoom.Use(itemToUse);
                    if (outputText.equals(draft.genfail)) 
                    slowType("Despite your best efforts, nothing happens.");
                    else if (!outputText.isEmpty())
                    slowType(outputText);
                }
                else {
                    slowType("You don't have that item.");
                }
            }
            else {
                String tryGetItem = currentRoom.Inspect(inputs.itemManagement(cmd));
                if (!tryGetItem.equals(draft.genfail)) {
                    if (!tryGetItem.isEmpty()) {
                        slowType(tryGetItem);
                    }
                    System.out.println();
                    continue;
                }
                Room nextRoom = findRoom(currentRoom.roomLinks.getOrDefault(cmd, draft.genfail));
                if (nextRoom != rooms.get(0)) {
                    currentRoom = nextRoom;
                    System.out.print("\nYou are in: ");
                    System.out.println(currentRoom.Name());
                    slowType(currentRoom.Description());

                    { // PRINT ITEMS TEXT
                        String droppedItemsString = "";
                        if ( !currentRoom.droppedItems.isEmpty() ) {
                            droppedItemsString += ("\nOn the ground you see a ");
                            int ic = 0;
                            for (String a : currentRoom.droppedItems) {
                                droppedItemsString += (a);
                                if (currentRoom.droppedItems.size() > ic && currentRoom.droppedItems.size() > 2 && currentRoom.droppedItems.size() != ic + 1) {
                                    droppedItemsString += (",");
                                }
                                if (currentRoom.droppedItems.size() == ic + 2 && currentRoom.droppedItems.size() > 1) {
                                    droppedItemsString += (" and a ");
                                }
                                else if (currentRoom.droppedItems.size() > 1 && currentRoom.droppedItems.size() != ic + 1)
                                droppedItemsString += (" a ");
                                
                                ic ++;
                            }
                            droppedItemsString += (".");
                        }
                        slowType(droppedItemsString);
                    }
                    System.out.println();
                    continue;
                }
                slowType("I don't understand what you're trying to say");
            }
            System.out.println();
        }     
    }
    //#endregion
    
    
//#region HELPERS
    public static int typeSpeedSlow = 15;
    public static void slowType(String text, int sleepTime) throws InterruptedException {
        if (text == null)return;
        if (text.isEmpty()) return;
        for (char a : text.toCharArray()) {
            System.out.print(a);
            if (!fastType)
                Thread.sleep(sleepTime);
        }
    }
    public static void slowType(String text) throws InterruptedException {
        slowType(text, 7);
    }
    public static void pause(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }
//#endregion
}

public class GameProject {
    public static void main(String[] args) throws InterruptedException {
        runtime r = new runtime();
        r.run();
    }
}

//#region ROOMS
/*
* ROOMS (CLASSES)
*/
class Room {
    boolean isFirst = true;
    String Name() {
        return "ROOM MISSING";
    }
    String Description() {
        return "default room";
    }
    boolean isLocked = false;

    String Use(String itemUsed) throws InterruptedException {
        return draft.genfail;
    }
    String Grab(String itemToGrab) throws InterruptedException {
        return draft.genfail;
    }
    String Inspect(String toInspect) throws InterruptedException {
        return draft.genfail;
    }

    ArrayList<String> droppedItems = new ArrayList<>();
    ArrayList<String> objects = new ArrayList<>();

    HashMap<String, String> roomLinks = new HashMap<>();
    
}

class PrisonCell extends Room {
    @Override
    String Name() {
        return "PRISON CELL";
    }
    @Override
    String Description() {
        if (isFirst) {
            isFirst = false;
            return draft.DESC_PrisonCell_First + (objects.contains("KEY") ? draft.DESC_PrisonCell_KeyAddum : "");
        }
        return doorUnlocked ? draft.DESC_PrisonCell_Unlocked : draft.DESC_PrisonCell + (objects.contains("KEY") ? draft.DESC_PrisonCell_KeyAddum : "");
    }
    @Override
    String Grab(String targetItem) throws  InterruptedException {
        if (targetItem.equals("KEY")) {
            return objects.remove("KEY") ? draft.Grab_Key : "";
        }
        if (targetItem.equals("bed") || targetItem.equals("bedframe") || targetItem.equals("pole") || targetItem.equals("metal frame"))
            return (objects.contains("POLE")) ? draft.Grab_Bedframe : draft.Grab_Bedframe_TakenPole;

        if (targetItem.equals("POLE")) {
            if( objects.remove("POLE") )
                return draft.Grab_Pole;
            else {
                runtime.slowType(draft.Grab_Pole_Fail);
                return "";
            }
        }
        if (targetItem.equals("BOLTS")) {
            if( objects.remove("BOLTS") )
                return draft.Grab_Bolts;
            else {
                runtime.slowType( draft.Grab_Bolts_Fail );
                return "";
            }
        }
        return draft.genfail;
    }
    @Override
    String Inspect(String targetItem) throws InterruptedException{
        if (targetItem.isEmpty()) return "";
        if (targetItem.equals("poster"))
            return draft.I_Poster + '\n' + draft.theascii;
        if (targetItem.equals("sink"))
            return draft.I_Sink;
        if (targetItem.equals("bed") || targetItem.equals("bedframe") || targetItem.equals("pole") || targetItem.equals("metal frame"))
            return (objects.contains("POLE")) ? draft.I_Bedframe : draft.I_Bedframe_TakenPole;
        if (targetItem.equals("matress") || targetItem.equals("mattress"))
            return draft.I_Matress;
        if (targetItem.equals("toilet") || targetItem.equals("loo") || targetItem.equals("metal box"))
            return draft.I_Toilet;
        if (targetItem.equals("key") || targetItem.equals("KEY") && objects.contains("KEY"))
            return draft.I_Key;
        if (targetItem.equals("lock") || targetItem.equals("KEY") || targetItem.equals("padlock")) {
            return combinationLock();
        }
        return draft.genfail;
    }
    @Override
    String Use(String targetItem) throws InterruptedException{
        if (targetItem.equals("KEY") || targetItem.equals("lock") || targetItem.equals("padlock")) {
            return combinationLock();
        }
        return draft.genfail;
    }

    String combinationLock() throws InterruptedException {
        if ( ! runtime.r.hasKey() ) return "You don't have the key required to open the first half of the lock.";
        runtime.slowType(draft.Use_Key);
        String inputCombination = "";
        while (inputCombination.length() == 0) {
            inputCombination = runtime.keyboard.nextLine();
            if (inputCombination.length() != 4) runtime.slowType(draft.Use_Key_Invalid);
        }
        if( inputCombination.equals("5917") ) {
            roomLinks.put("hallway", "HALLWAY");
            roomLinks.put("hw", "HALLWAY");
            roomLinks.put("h", "HALLWAY");
            roomLinks.put("forward", "HALLWAY");
            roomLinks.put("out", "HALLWAY");
            roomLinks.put("exit", "HALLWAY");
            return draft.Use_Key_Success ;
        }
        else 
            return draft.Use_Key_Failure;
    }

    boolean doorUnlocked;

    public PrisonCell() {
        objects.add("Bed");
        objects.add("POLE");
        objects.add("Toilet");
        objects.add("Poster");
        objects.add("Sink");
        objects.add("Lock");
        objects.add("BOLTS");
        objects.add("KEY");


        doorUnlocked = false;
    }
}
class Hallway extends Room {
    @Override
    String Name() {
        return "HALLWAY";
    }
    @Override
    String Description() {
        return "some cells left and right or smth ";
    }

    public Hallway() {
        roomLinks.put("prison cell", "PRISON CELL");
        roomLinks.put("cell", "PRISON CELL");
        roomLinks.put("common", "COMMON");
        roomLinks.put("forward", "COMMON");
        roomLinks.put("out", "COMMON");
        roomLinks.put("exit", "COMMON");
    }
}

class Common extends Room {
    @Override
    String Name() {
        return "COMMON";
    }
    @Override
    String Description() {
        return draft.DESC_Common;
    }

    public Common() {
        roomLinks.put("hallway", "HALLWAY");
        roomLinks.put("hw", "HALLWAY");
        roomLinks.put("kitchen", "CAFETERIA");
        roomLinks.put("cafeteria", "CAFETERIA");
        roomLinks.put("cafe", "CAFETERIA");
        roomLinks.put("upward", "CAFETERIA");
        roomLinks.put("north", "CAFETERIA");
        roomLinks.put("trapdoor", "TRAPDOOR ROOM");
        roomLinks.put("right", "TRAPDOOR ROOM");
        roomLinks.put("east", "TRAPDOOR ROOM");
    }
}
class Cafeteria extends Room {
    @Override
    String Name() {
        return "CAFETERIA";
    }
    @Override
    String Description() {
        return draft.DESC_Cafeteria;
    }

    public Cafeteria() {
        roomLinks.put("back", "COMMON");
        roomLinks.put("south", "COMMON");
        roomLinks.put("downward", "COMMON");
        roomLinks.put("down", "COMMON");
        roomLinks.put("common", "COMMON");

    }
}
class TrapdoorRoom extends Room {
    @Override
    String Name() {
        return "TRAPDOOR ROOM";
    }
    @Override
    String Description(){
          return "You're in a small, dark cellr made entirely of rough stone. The only light in thhe";
    }
    

    public TrapdoorRoom() {
        roomLinks.put("common", "COMMON");
        roomLinks.put("back", "COMMON");
        roomLinks.put("left", "COMMON");
        roomLinks.put("west", "COMMON");
        roomLinks.put("out", "COMMON");
        roomLinks.put("exit", "COMMON");
        isLocked = true;
    }
}
class OuterBanks extends Room {
    @Override
    String Name() {
        return "Outer Banks";
    }
    @Override
    String Description(){
          return "You're now outside, behind the prison where there's a small forest ";
    }
    

    public OuterBanks() {
        roomLinks.put("common", "COMMON");
        roomLinks.put("back", "COMMON");
        roomLinks.put("left", "COMMON");
        roomLinks.put("west", "COMMON");
        roomLinks.put("out", "COMMON");
        roomLinks.put("down", "MazeRoom1");
        roomLinks.put("south", "MazeRoom1");
        roomLinks.put("right", "MazeRoom2");
        roomLinks.put("east", "MazeRoom2");
        roomLinks.put("up", "MazeRoom3");
        
        isLocked = true;
    }
}
class WardensRoom extends Room {
    @Override
    String Name() {
        return "Warden's Office";
    }
    @Override
    String Description(){
          return "You're now outside, behind the prison where there's a small forest ";
    }
    

    public WardensRoom () {
        roomLinks.put("hallway", "HALLWAY");
        roomLinks.put("hw", "HALLWAY");
        roomLinks.put("back", "HALLWAY");
        roomLinks.put("exit", "HALLWAY");
        roomLinks.put("leave", "HALLWAY");
        roomLinks.put("east", "HALLWAY");
        roomLinks.put("e", "HALLWAY");
        roomLinks.put("out", "HALLWAY");
        roomLinks.put("away", "HALLWAY");
        roomLinks.put("cell", "HALLWAY");
        
        isLocked = true;
    }
}

class MazeRoom1 extends Room {
    @Override
    String Name() {
        return "Maze Room 1";
    }
    @Override
    String Description(){
          return "You have hit a dead end, travel another way to reach the exit";
    }
    

    public MazeRoom1() {
        roomLinks.put("outerbanks", "OuterBanks");
        roomLinks.put("back", "OuterBanks");
        roomLinks.put("out", "OuterBanks");
        roomLinks.put("exit", "OuterBanks");
        isLocked = true;
    }
}
class MazeRoom2 extends Room {
    @Override
    String Name() {
        return "Maze Room 2";
    }
    @Override
    String Description(){
          return "There is a fork in the road pick which way to proceed";
    }
    

    public MazeRoom2() {
        roomLinks.put("back", "OuterBanks");
        roomLinks.put("left", "OuterBanks");
        roomLinks.put("west", "OuterBanks");
        roomLinks.put("straight", "MazeRoom5");
        roomLinks.put("east", "MazeRoom5");
        roomLinks.put("out", "OuterBanks");
        roomLinks.put("up", "MazeRoom4");
        roomLinks.put("north", "MazeRoom4");
        roomLinks.put("exit", "OuterBanks");
        roomLinks.put("down", "MazeRoom6");
        roomLinks.put("south", "MazeRoom6");
        isLocked = true;
    }
}
class MazeRoom3 extends Room {
    @Override
    String Name() {
        return "Maze Room 3";
    }
    @Override
    String Description(){
          return "You have hit a dead end travel another way to reach the exit";
    }
    

    public MazeRoom3() {
        roomLinks.put("outerbanks", "OuterBanks");
        roomLinks.put("back", "OuterB");
        roomLinks.put("out", "OuterBanks");
        roomLinks.put("exit", "OuterBanks");
        roomLinks.put("up", "OuterBanks");
        roomLinks.put("north", "OuterBanks");
        isLocked = true;
    }
}
class MazeRoom6 extends Room {
    @Override
    String Name() {
        return "Maze Room 6";
    }
    @Override
    String Description(){
          return "There is a fork in the road pick which way to proceed";
    }
    

    public MazeRoom6() {
        roomLinks.put("back", "MazeRoom2");
        roomLinks.put("MazeRoom2", "MazeRoom2");
        roomLinks.put("straight", "MazeRoom5");
        roomLinks.put("east", "MazeRoom5");
        roomLinks.put("out", "OuterBanks");
        roomLinks.put("up", "MazeRoom4");
        roomLinks.put("north", "MazeRoom4");
        roomLinks.put("exit", "OuterBanks");
        roomLinks.put("down", "MazeRoom6");
        roomLinks.put("south", "MazeRoom6");
        isLocked = true;
    }
}

//#endregion