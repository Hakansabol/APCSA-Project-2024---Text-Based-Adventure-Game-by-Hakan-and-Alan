public class inputs {
    // Searches an array for a specific string, returns true if found.
    public static boolean findInArr(String[] arr, String other) {
        for (String a : arr) {
            if (a.equals(other)) return true;
        }
        return false;
    }
    //#region INPUTS
    public static String inputManagement(String other) {
        if (findInArr(pseud_go, other) )
            return "GO";
        if (findInArr(pseud_pickup, other) )
            return "PICKUP";
        if (findInArr(pseud_drop, other) )
            return "DROP";
        if (findInArr(pseud_look, other) )
            return "LOOK";
        if (findInArr(pseud_inventory, other) )
            return "INVENTORY";
        if (findInArr(psued_use, other) )
            return "USE";
        return other;
    }
    // Pseudonyms for all the input commands: Entering any of these options will execute the corresponding command.
    static String[] pseud_go = new String[] {
        "go",
        "walk",
        "enter",
        "travel",
        "move",
        "advance",
        "visit",
        "gog",
        "g",
        "wlak",
        "step"
    };
    static String[] pseud_pickup = new String[] {
        "grab",
        "get",
        "t",
        "take",
        "steal",
        "garb",
        "pickup",
        "rob",
        "apppropriate",
        "gain",
        "tkae",
        "snatch",
        "sntach",
        "took",
        "stole",
        "clutch",
        "attain",
        "obtain",
        "acquire",
        "grip",
        "grasp",
        "seize",
        "pull",
        "toggle"
    };
    static String[] pseud_drop = new String[] {
        "drop",
        "dorp",
        "d"
    };
    static String[] pseud_look = new String[] {
        "inspect",
        "look",
        "view",
        "stare",
        "observe",
        "l"
    };
    static String[] pseud_inventory = new String[] {
        "i",
        "inventory",
        "items",
        "item"
    };
    static String[] psued_use = new String[] {
        "u",
        "use",
        "place",
        "hit",
        "apply",
        "activate",
        "hit",
        "insert",
        "effect",
        "input",
    };
    //#endregion
    //#region ITEMS
    public static String itemManagement(String other) {
        if (findInArr(pseud_item_key, other) ) {
            return "KEY";
        }
        if (findInArr(pseud_item_lever, other) ) {
            return "LEVER";
        }
        if (findInArr(pseud_item_pole, other) ) {
            return "POLE";
        }
        if (findInArr(pseud_item_bolts, other) ) {
            return "BOLTS";
        }
        if (findInArr(pseud_obj_poster, other) ) {
            return "poster";
        }
        if (findInArr(pseud_obj_chair, other) ) {
            return "CHAIR";
        }
         if (findInArr(pseud_item_hammer, other) ) {
            return "HAMMER";
        }
         if (findInArr(pseud_item_tshirt, other) ) {
            return "TSHIRT";
        }
         if (findInArr(pseud_item_phone, other) ) {
            return "PHONE";
        }
        return other;
    }
    static String[] pseud_item_key = new String[] {
        "key",
        "ky",
        "k"
    };
    static String[] pseud_item_lever = new String[] {
        "lever",
        "switch",
        "flicky",
        "levre"
    };
    static String[] pseud_item_pole = new String[] {
        "pole",
        "pipe",
        "metal pipe",
        "metal pole",
        "weak pole",
        "bed pole"
    };
    static String[] pseud_item_bolts = new String[] {
        "bolts",
        "bolt",
        "nuts",
        "hex",
        "metal bolts",
        "blots"
    };

    static String[] pseud_obj_poster = new String[] {
        "poster",
        "rick",
        "displate",
        "favorite",
        "wall",
        "picture",
        "image",
        "photo",
        "photograph"
    };
    static String[] pseud_obj_chair = new String[] {
        "chair",
        "seat",
        "chiar",
        "seating"
    };
    static String[] pseud_item_hammer = new String[] {
        "hammer",
        "hamme",
        "ham",
        "hammre",
    };
    static String[] pseud_item_tshirt = new String[] {
        "tshirt",
        "t-shirt",
        "shirt",
        "shitr",
        "shrit",
    };
    static String[] pseud_item_phone = new String[] {
        "phone",
        "smartphone",
        "telephone",
        "iphone",
        "phon",
        "android",
        "samsung"
    };
    //#endregion
}