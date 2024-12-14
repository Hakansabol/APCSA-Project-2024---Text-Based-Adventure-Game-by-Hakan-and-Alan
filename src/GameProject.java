// hakan and alan

// Hints:
// The cell door combination requires the second digit of each number found in the prison
// You need to drop 4 items in the pressure plate room to unlock the control room.
// You can find three items in the cell and one item in the common room. There were supposed to be items in the maze, but I'm too tired and annoyed to implement them.
// In order to survive the control room interaction, you need to be very precise in your movement.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//#region RUNTIME
class runtime {
    static runtime r;
    static boolean fastType = true;
    static Scanner keyboard = new Scanner(System.in);
    static ArrayList<Room> rooms = new ArrayList<>(); 
    static ArrayList<String> items = new ArrayList<>();
    public int bombImminent = -1;
    public boolean hasKey() { return items.contains("KEY"); }
    public Room findRoom(String name) {
        for (Room iterRoom : rooms) {
            if (iterRoom.Name().equals(name)) return iterRoom;
        }
        return rooms.get(0);
    }
    public int getItemsDroppedInPressureRoom() {
        return findRoom("PRESSURE PLATE ROOM").droppedItems.size();
    }
    @SuppressWarnings("ConvertToStringSwitch")
    public void run() throws InterruptedException {
        slowType("\nType \"help\" for information on how to play the game.\n");
        r = this;
        
        rooms.add(new Room());
        rooms.add(new PrisonCell());
        rooms.add(new Hallway());
        rooms.add(new Common());
        rooms.add(new ControlRoom());
        rooms.add(new PressureRoom());
        rooms.add(new OuterBanks());
        rooms.add(new MazeRoom1());
        rooms.add(new MazeRoom2());
        rooms.add(new MazeRoom3());
        rooms.add(new MazeRoom4());
        rooms.add(new MazeRoom5());
        rooms.add(new MazeRoom6());
        rooms.add(new MazeRoom7());
        rooms.add(new MazeRoom8());
        rooms.add(new MazeRoom9());
        rooms.add(new MazeRoom10());
        

        
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
                else {
                    slowType("I don't know where that is.");
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
                    if (currentRoom == findRoom("PRESSURE PLATE ROOM")) {
                        if (getItemsDroppedInPressureRoom() == 2) { 
                            System.out.println();
                            runtime.slowType( draft.Drop_Two );
                            findRoom("Outer Banks").isLocked = false;
                        }
                        if (getItemsDroppedInPressureRoom() == 4) {
                            System.out.println();
                            runtime.slowType( draft.Drop_Five );
                            findRoom("CONTROL ROOM").isLocked = false;
                        }
                    }
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
                    if (bombImminent > 0) {
                        bombImminent --;
                        slowType("\nThe sirens continue behind you...\n");
                        if (bombImminent == 0) {
                            slowType("The sirens suddenly stop. Then, you start to hear explosions behind you. You're too late. You have only a moment for regrets before your body is disintegrated by the explosions.", 15);
                            System.exit(1);
                        }
                    }
                    continue;
                }
                Room nextRoom = findRoom(currentRoom.roomLinks.getOrDefault(cmd, draft.genfail));
                if (nextRoom.isLocked) {
                    slowType("");
                }
                else if (nextRoom != rooms.get(0)) {
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
                    if (bombImminent > 0) {
                        bombImminent --;
                        slowType("\nThe sirens continue behind you...\n");
                        if (bombImminent == 0) {
                            slowType("The sirens suddenly stop. Then, you start to hear explosions behind you. You're too late. You have only a moment for regrets before your body is disintegrated by the explosions.", 15);
                            System.exit(1);
                        }
                    }
                    continue;
                }
                slowType("I'm not sure what you're trying to say");
            }
            if (bombImminent > 0) {
                bombImminent --;
                slowType("\nThe sirens continue behind you...\n");
                if (bombImminent == 0) {
                    slowType("The sirens suddenly stop. Then, you start to hear explosions behind you. You're too late. You have only a moment for regrets before your body is disintegrated by the explosions.", 15);
                    System.exit(1);
                }
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
class Room {
    boolean isFirst = true;
    String Name() {
        return "ROOM MISSING";
    }
    String Description() throws InterruptedException {
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
            runtime.r.findRoom("HALLWAY").isLocked = false;
            return draft.Use_Key_Success ;
        }
        else 
        return draft.Use_Key_Failure;
    }
    
    boolean doorUnlocked;
    
    public PrisonCell() {
        roomLinks.put("hallway", "HALLWAY");
        roomLinks.put("hw", "HALLWAY");
        roomLinks.put("h", "HALLWAY");
        roomLinks.put("north", "HALLWAY");
        roomLinks.put("n", "HALLWAY");
        roomLinks.put("forward", "HALLWAY");
        roomLinks.put("out", "HALLWAY");
        roomLinks.put("exit", "HALLWAY");
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
        isFirst = false;
        return isFirst ? draft.DESC_Hallway_First : draft.DESC_Hallway;
    }

    public Hallway() {
        roomLinks.put("prison cell", "PRISON CELL");
        roomLinks.put("cell", "PRISON CELL");
        roomLinks.put("prison", "PRISON CELL");
        roomLinks.put("south", "PRISON CELL");
        roomLinks.put("s", "PRISON CELL");
        roomLinks.put("common", "COMMON");
        roomLinks.put("forward", "COMMON");
        roomLinks.put("out", "COMMON");
        roomLinks.put("exit", "COMMON");
        roomLinks.put("west", "COMMON");
        roomLinks.put("w", "COMMON");
        roomLinks.put("left", "COMMON");
        roomLinks.put("east", "Outer Banks");
        roomLinks.put("e", "Outer Banks");
        roomLinks.put("right", "Outer Banks");
        roomLinks.put("leave", "Outer Banks");
        isLocked = true;
    }
}
class Common extends Room {
    @Override
    String Name() {
        return "COMMON";
    }
    @Override
    String Description() {
        isFirst = false;
        return draft.DESC_Common(runtime.r.getItemsDroppedInPressureRoom(), objects.contains("CHAIR"));
    }
    @Override
    String Grab(String targetItem) {
        if (targetItem.equals("CHAIR")) {
            return objects.remove("CHAIR") ? draft.GRAB_Chair : "";
        }
        return draft.genfail;
    }

    public Common() {
        roomLinks.put("hallway", "HALLWAY");
        roomLinks.put("hw", "HALLWAY");
        roomLinks.put("e", "HALLWAY");
        roomLinks.put("east", "HALLWAY");
        roomLinks.put("back", "HALLWAY");
        roomLinks.put("return", "HALLWAY");
        roomLinks.put("north", "PRESSURE PLATE ROOM");
        roomLinks.put("n", "PRESSURE PLATE ROOM");
        roomLinks.put("up", "PRESSURE PLATE ROOM");
        roomLinks.put("left", "PRESSURE PLATE ROOM");
        roomLinks.put("pressure", "PRESSURE PLATE ROOM");
        roomLinks.put("plate", "PRESSURE PLATE ROOM");
        roomLinks.put("weight", "PRESSURE PLATE ROOM");
        roomLinks.put("depress", "PRESSURE PLATE ROOM");
        roomLinks.put("control", "CONTROL ROOM");
        roomLinks.put("right", "CONTROL ROOM");
        roomLinks.put("south", "CONTROL ROOM");
        roomLinks.put("control room", "CONTROL ROOM");
        roomLinks.put("s", "CONTROL ROOM");
        roomLinks.put("d", "CONTROL ROOM");
        objects.add("CHAIR");
    }
}
class PressureRoom extends Room {
    @Override
    String Name() {
        return "PRESSURE PLATE ROOM";
    }
    @Override
    String Description() {
        isFirst = false;
        return draft.DESC_Cellar;
    }
    

    public PressureRoom() {
        roomLinks.put("common", "COMMON");
        roomLinks.put("back", "COMMON");
        roomLinks.put("c", "COMMON");
        roomLinks.put("south", "COMMON");
        roomLinks.put("s", "COMMON");
        roomLinks.put("down", "COMMON");
        roomLinks.put("out", "COMMON");
        roomLinks.put("exit", "COMMON");
        roomLinks.put("leave", "COMMON");
    }
}
class ControlRoom extends Room {
    @Override
    String Name() {
        return "CONTROL ROOM";
    }
    @Override
    String Description(){
        isFirst = false;
        return draft.DESC_ControlRoom;
    }
    @Override
    String Grab(String itemUsed) throws InterruptedException {
        if (itemUsed == "lever" || itemUsed == "pull" || itemUsed == "LEVER") {
            runtime.r.bombImminent = 10; // gives one input of leeway
            return draft.USE_Lever;
        }
        return draft.genfail;
    }
    @Override
    String Use(String itemUsed) throws InterruptedException {
        if (itemUsed.equals("LEVER") || itemUsed.equals("lever")) {
            runtime.r.bombImminent = 10;
            return draft.USE_Lever;
        }
        return draft.genfail;
    }
    

    public ControlRoom() {
        roomLinks.put("common", "COMMON");
        roomLinks.put("back", "COMMON");
        roomLinks.put("c", "COMMON");
        roomLinks.put("north", "COMMON");
        roomLinks.put("n", "COMMON");
        roomLinks.put("out", "COMMON");
        roomLinks.put("exit", "COMMON");
        roomLinks.put("leave", "COMMON");
        objects.add("Lever");
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
          return mazeText.OuterBanks_Desc;
    }
    

    public OuterBanks() {
        roomLinks.put("hallway", "HALLWAY");
        roomLinks.put("back", "HALLWAY");
        roomLinks.put("left", "HALLWAY");
        roomLinks.put("west", "HALLWAY");
        roomLinks.put("w", "HALLWAY");
        roomLinks.put("out", "HALLWAY");
        roomLinks.put("down", "Maze Room 1");
        roomLinks.put("south", "Maze Room 1");
        roomLinks.put("s", "Maze Room 1");
        roomLinks.put("right", "Maze Room 2");
        roomLinks.put("east", "Maze Room 2");
        roomLinks.put("e", "Maze Room 2");
        roomLinks.put("north", "Maze Room 3");
        roomLinks.put("up", "Maze Room 3");
        roomLinks.put("n", "Maze Room 3");
        
        isLocked = true;
    }
}

    //#region MAZE
    class MazeRoom1 extends Room {
        @Override
        String Name() {
            return "Maze Room 1";
        }
        @Override
        String Description(){
                return mazeText.MazeRoom1_Desc;
        }

        public MazeRoom1() {
            roomLinks.put("Outer Banks", "Outer Banks");
            roomLinks.put("back", "Outer Banks");
            roomLinks.put("out", "Outer Banks");
            roomLinks.put("exit", "Outer Banks");
            roomLinks.put("n", "Outer Banks");
            roomLinks.put("north", "Outer Banks");
        }
    }
    class MazeRoom2 extends Room {
        @Override
        String Name() {
            return "Maze Room 2";
        }
        @Override
        String Description(){
            return mazeText.MazeRoom2_Desc;
        }
        

        public MazeRoom2() {
            roomLinks.put("back", "Outer Banks");
            roomLinks.put("left", "Outer Banks");
            roomLinks.put("west", "Outer Banks");
            roomLinks.put("w", "Outer Banks");
            roomLinks.put("straight", "Maze Room 5");
            roomLinks.put("east", "Maze Room 5");
            roomLinks.put("e", "Maze Room 5");
            roomLinks.put("out", "Outer Banks");
            roomLinks.put("up", "Maze Room 4");
            roomLinks.put("north", "Maze Room 4");
            roomLinks.put("n", "Maze Room 4");
            roomLinks.put("exit", "Outer Banks");
            roomLinks.put("down", "Maze Room 6");
            roomLinks.put("south", "Maze Room 6");
            roomLinks.put("s", "Maze Room 6");
        }
    }
    class MazeRoom3 extends Room {
        @Override
        String Name() {
            return "Maze Room 3";
        }
        @Override
        String Description(){
            if(objects.contains("HAMMER")){
                return mazeText.MazeRoom3_Desc + mazeText.RustyHammer_Desc;
            }
            else{
                return mazeText.MazeRoom3_Desc;
            }
        }
        @Override
        String Grab(String targetItem) throws  InterruptedException {
            if (targetItem.equals("HAMMER")) {
                return objects.remove("HAMMER") ? mazeText.Grab_Hammer : "";
            }
            return draft.genfail;
        }

        public MazeRoom3() {
            roomLinks.put("outer banks", "Outer Banks");
            roomLinks.put("back", "Outer Banks");
            roomLinks.put("out", "Outer Banks");
            roomLinks.put("exit", "Outer Banks");
            roomLinks.put("s", "Outer Banks");
            roomLinks.put("south", "Outer Banks");
            roomLinks.put("return", "Outer Banks");
        }
    }
    class MazeRoom4 extends Room {
        @Override
        String Name() {
            return "Maze Room 4";
        }
        @Override
        String Description(){
            return mazeText.MazeRoom4_Desc;
        }
        

        public MazeRoom4() {
            roomLinks.put("back", "Maze Room 2");
            roomLinks.put("out", "Maze Room 2");
            roomLinks.put("exit", "Maze Room 2");
            roomLinks.put("down", "Maze Room 2");
            roomLinks.put("south", "Maze Room 2");
            roomLinks.put("s", "Maze Room 2");
        }
    }
    class MazeRoom5 extends Room {
        @Override
        String Name() {
            return "Maze Room 5";
        }
        @Override
        String Description(){
            if(objects.contains("TSHIRT")){
                return mazeText.MazeRoom5_Desc + mazeText.MuddyTshirt_Desc;
            }
            else{
                return mazeText.MazeRoom5_Desc;
            }
        }
        String Grab(String targetItem) throws  InterruptedException {
            if (targetItem.equals("TSHIRT")) {
                return objects.remove("TSHIRT") ? mazeText.Grab_TShirt : "";
            }
            return draft.genfail;
        }

        

        public MazeRoom5() {
            roomLinks.put("back", "Maze Room 2");
            roomLinks.put("out", "Maze Room 2");
            roomLinks.put("exit", "Maze Room 2");
            roomLinks.put("left", "Maze Room 2");
            roomLinks.put("west", "Maze Room 2"); 
            roomLinks.put("w", "Maze Room 2"); 
        }
    }
    class MazeRoom6 extends Room {
        @Override
        String Name() {
            return "Maze Room 6";
        }
        @Override
        String Description(){
            return  mazeText.PathSix_Desc + mazeText.MazeRoom6_Desc;
        }
        

        public MazeRoom6() {
            roomLinks.put("back", "Maze Room 2");
            roomLinks.put("Maze Room 2", "Maze Room 2");
            roomLinks.put("straight", "Maze Room 7");
            roomLinks.put("out", "Maze Room 2");
            roomLinks.put("up", "Maze Room 2");
            roomLinks.put("north", "Maze Room 2");
            roomLinks.put("n", "Maze Room 2");
            roomLinks.put("exit", "Maze Room 2");
            roomLinks.put("right", "Maze Room 8");
            roomLinks.put("left", "Maze Room 7");
            roomLinks.put("east", "Maze Room 8");
            roomLinks.put("e", "Maze Room 8");
            roomLinks.put("west", "Maze Room 7");
            roomLinks.put("w", "Maze Room 7");
        }
    }
    class MazeRoom7 extends Room {
        @Override
        String Name() {
            return "Maze Room 7";
        }
        @Override
        String Description(){
            return mazeText.MazeRoom7_Desc;
        }
        

        public MazeRoom7() {
            roomLinks.put("back", "Maze Room 6");
            roomLinks.put("Maze Room 6", "Maze Room 6");
            roomLinks.put("out", "Maze Room 6");
            roomLinks.put("exit", "Maze Room 6");
            roomLinks.put("down", "Maze Room 10");
            roomLinks.put("south", "Maze Room 10");
            roomLinks.put("s", "Maze Room 10");
            roomLinks.put("left", "Maze Room 6");
            roomLinks.put("west", "Maze Room 6");
            roomLinks.put("w", "Maze Room 6");
        }
    }
    class MazeRoom8 extends Room {
        @Override
        String Name() { 
            return "Maze Room 8";
        }
        @Override
        String Description(){
            if(objects.contains("PHONE")){
                return mazeText.MazeRoom8_Desc + mazeText.Phone_Desc;
            }
            else {
            return mazeText.MazeRoom8_Desc;
            }
        }
        String Grab(String targetItem) throws  InterruptedException {
            if (targetItem.equals("PHONE")) {
                return objects.remove("PHONE") ? mazeText.Grab_Phone : "";
            }
            return draft.genfail;
        }

        

        public MazeRoom8() {
            roomLinks.put("back", "Maze Room 6");
            roomLinks.put("Maze Room 6", "Maze Room 6");
            roomLinks.put("out", "Maze Room 6");
            roomLinks.put("exit", "Maze Room 6");
            roomLinks.put("w", "Maze Room 6");
            roomLinks.put("west", "Maze Room 6");
            roomLinks.put("down", "Maze Room 9");
            roomLinks.put("south", "Maze Room 9");
            roomLinks.put("s", "Maze Room 9");
        }
    }
    class MazeRoom9 extends Room {
        @Override
        String Name() {
            return "Maze Room 9";
        }
        @Override
        String Description() throws InterruptedException {
            runtime.slowType(mazeText.MazeRoom9_Desc);
            runtime.slowType(" Leave the prison? (y/n)\n");
            String n = "";
            while (!n.equals("y") && !n.equals("n")) {
                System.out.print("> ");
                n = runtime.keyboard.nextLine();
            }
            if (n.equals( "y") ) {
                runtime.slowType("You've escaped. At long last, your freedom is once again your own.\n");
                if (runtime.r.bombImminent >= 0) {
                    runtime.slowType("And just in time. As the explosions ring out behind you, you can't help but feel a sense of accomplishment.", 20);
                }

                System.exit(1);
                return "";
                
            }
            return "";
        }
        

        public MazeRoom9() {
            roomLinks.put("back", "Maze Room 8");
            roomLinks.put("Maze Room 8", "Maze Room 8");
            roomLinks.put("out", "Maze Room 8");
            roomLinks.put("exit", "Maze Room 8");
            roomLinks.put("up", "Maze Room 8");
            roomLinks.put("north", "Maze Room 8");
            roomLinks.put("n", "Maze Room 8");
            roomLinks.put("return", "Maze Room 8");
        }
    }
    class MazeRoom10 extends Room {
        @Override
        String Name() {
            return "Maze Room 10";
        }
        @Override
        String Description(){
            return mazeText.MazeRoom10_Desc;
        }
        

        public MazeRoom10() {
            roomLinks.put("back", "Maze Room 7");
            roomLinks.put("Maze Room 7", "Maze Room 7");
            roomLinks.put("out", "Maze Room 7");
            roomLinks.put("exit", "Maze Room 7");
            roomLinks.put("up", "Maze Room 7");
            roomLinks.put("north", "Maze Room 7");
            roomLinks.put("n", "Maze Room 7");
            roomLinks.put("return", "Maze Room 7");
        }
    }
    //#endregion
//#endregion