public class draft {
static String HELP = "WELCOME TO THE GAME GAME GAME GAME GOOD NAME GAME\n\nBasic commands:\nGO <location> - goes to a place.\nGRAB <item> - picks up an item.\nDROP <item> - drops the .\nLOOK <where> - looks more closely at an object in the room. If you do not provide the name of something in the room, you will instead look at the entire room again.\nUSE <item> - uses the item if applicable.\nINVENTORY - type 'i' - Shows what items you are carrying.\nNOTE: Only the prison cell is playable. Once you complete the puzzle by reaching the hallway, you have completed the beta.\nYou can access ";
	
static String genfail = "fail";
	
static String DESC_PrisonCell = "You're in your cell, held in by a massive key-and-combination padlock, but if you could get through that, you might be able to escape! On the wall hangs the old tattered poster you brought in with you. Your toilet is a sad metal box scarred by scrapes and scratches. To the left sits your 'bed', a wire-thin frame of metal poles. Atop it is your mattress, a pitiful reminder of the cruelty of the guards. The prison is luckily nice enough to provide a small sink." ;

static String DESC_PrisonCell_Unlocked = "Ah, the prison cell they kept you in. You're awash with relief every time you see the open padlock, and feel drawn to this room just to relish in your half-freedom. It feels a lot more homely now, and you can't wait to buy a new poster for your own room back home. To remember the place.\n\nThe toilet, chipped and scratched as ever, seems cleaner now than when you were still trapped in the small room. Your bed still sits in the corner, a reminder of the horrors you endured here. You indulge in your freedom for a moment before getting back to business." ;

static String DESC_PrisonCell_First = "You wake up in your prison cell after a better-than-usual rest. That's odd. You can't remember the last time the guards let you sleep in.\n\nAs you come to your senses, you notice the guards at your door are missing - It seems the only thing between you and escape is the key-and-combination lock on your cell door! If you could get through that, you might be able to escape right out the front door.\n\nSomething else feels off, too. You had better take a closer look at everything around your cell. On the wall hangs the old tattered poster you brought in with you. Your toilet is the same sad metal box scarred by scrapes and scratches. To the left sits your 'bed', a wire-thin frame of metal poles. Atop it is your mattress, a pitiful reminder of the cruelty of the guards. And of course, the small sink that the prison was nice enough to provide, but the guards were very adamant that you don't use too much water. But then,"; // note: Intentional grammar, do not change!

static String DESC_PrisonCell_KeyAddum = " When you look down, you can't believe your eyes - is that the padlock key?";

static String Grab_Key = "You pick the key up off of the floor. Clearly someone has decided to help you escape. You make a mental note to find them later, once you successfully get out of here.";

static String I_Key = "It's the key to the lock on your cell. You should probably grab it.";

static String Use_Key = "You insert the key into the rusty padlock. After sizable effort, the key turns and the lock makes an audible click. The four cylinders on the combination lock instantly jump to the 0 position. On the lock is etched a nearly unreadable number: '47'. The cylinder lock awaits your input (Enter your combination as a four-digit number)\n> " ;

static String Use_Key_Success = "With a click, the combination lock pops open. You quietly swing the door open and look up and down the hallway. For the first time, you're out of your cell, unsupervised. Time to get to work. You can now step out into the hallway.";

static String Use_Key_Failure = "You finish inputting the combination into the lock, and nothing happens. You pull the key back out.";

static String Use_Key_Invalid = "That's not a valid combination. Your combination should be four numbers expressed as a four-digit number with digits ranging from one to nine.\n> ";

static String I_Bedframe = "On closer inspection, the metal frame of your bed has clearly been weakened with time. Each metal pole is only barely held in place, with many of the bolts lying on the floor. Your body weight was supported by this? A pole sticking towards you catches your eye; It looks weak enough to pull away." ;

static String Grab_Bedframe = "That's too heavy to pickup, but you could try grabbing the pole sticking towards you." ;

static String I_Bedframe_TakenPole = "After taking a pole away from the bedframe, you don't think it's a good idea to sleep on it anymore." ;

static String Grab_Bedframe_TakenPole = "That's too heavy to pickup." ;

static String Grab_Pole = "With a bit of effort, the exposed metal pole of the bedframe comes clean. You hold onto it for later.";

static String Grab_Pole_Fail = "You already took the weak pole from the bedframe, and the rest of them are too precarious to safely remove another one.";

static String Grab_Bolts = "You collect some of the remains of your bedframe off of the ground for later.";

static String Grab_Bolts_Fail = "You already grabbed all of the bolts off the ground.";

static String I_Matress = "The mattress of your bed is a thin layer of fabric, and some of the stuffing is falling out through numerous cuts and lacerations. So sad." ;

static String I_PrisonLock= "The padlock needs a key before the grimy 4-number combination lock will rotate. While inspecting the lock you notice a number etched on its surface: '47'." ;

static String I_Poster = "It's your favorite image in the whole entire world. The bottom right corner has been peeled off.";

static String I_Sink = "Your sink is controlled by a small knob. Behind it is a horribly scraped area that looks like someone tried to write the number 29. You decide against turning on the sink right now. You'd rather not bother the guards.";

static String I_Toilet = "Ah, your toilet. Honestly not the worst part of room, other than the poster this is the highest quality thing you have. Underneath its bowl the number 31 is engraved.";

static String DESC_Common = "Stepping into the prison's common room, you are surprised by its expansiveness. Maybe sometime long ago, this room could have held over a hundred inmates at once. Unfortunately, you'll never know. But what is nice is a large circular table in the center of the room, with a massive compass rose \n\nTo the north, you see an archway leading to what looks like a cafeteria, and a strong metal door with a trapdoor behind it blocks you to the south. To the east, there is a series of two doors that seems to lead... outside?";

static String DESC_Cafeteria = "As you enter the cafeteria, you are overwhelmed by the smell of decaying flesh and rotting food. You suppose the robotic guards lack a sense of smell, but you wonder how they managed to not poison you to death yet. You do see a refrigerator, and gain a bit of hope for finding edible food.\n\nYou also see a door leading into a small cupboard.";

static String theascii =    ":--------------===*%@@@@%@%#=-----------------\r\n" + //
                            ":-::::-::------++*#%%@@@@@%%#-----------------\r\n" + //
                            ":-::::::::-----=##*#*++++++%%=----------------\r\n" + //
                            "::::::::::::---*%#*#**+++++*#-----------------\r\n" + //
                            "::::.:::::----=***###%**#*+**---------:-------\r\n" + //
                            ":::::::::----=#*=***##*+**++------------------\r\n" + //
                            ":::-:::-------*#+*#####*++++------------------\r\n" + //
                            "::::-------::---***#%##*+++-:-:----------::::-\r\n" + //
                            ".:::------:::::-+**###*++=:---::---------:::::\r\n" + //
                            "::::------:-----**##**+++=----------------::::\r\n" + //
                            "---------------=*####*+++*%=------------------\r\n" + //
                            ":::-----:::-===+***##***+*@@@##*+=---------:::\r\n" + //
                            "::------=+#%@*=+****###=-#@@@@@@@@@%%#*-------\r\n" + //
                            "::---=+#@@@@@#=+##*##+=-+@@@@@@@@@@@@@@%=-----\r\n" + //
                            "::--*@@@@@@@@%=++==+==-*@@@@@@@@@@@@@@@@+-----\r\n" + //
                            ":---#@@@@@@@@@@@+-*#***#@@@@@@@%%@@@@@@@+-----\r\n" + //
                            ":---%@@@@@@@@@@%+=*#%%%%@@@@@@@%#%@@@@@#------\r\n" + //
                            "----#@@@@@@@@@@@+=+**#%@@@@@@@@@##%*+*@#------\r\n" + //
                            "----*@@@@@@@@@@@%###***#@@@@@@@@###+#@@=------\r\n" + //
                            "----*@@@@@@@@@@@%#%%%%#%@@@@@@@@#****@@@*----|\r\n" + //
                            "----*@@@@@@@@@@@###%%%%@@@@@@@@##*+*#@@@@*---|\r\n" + //
                            "----+@@@@@@@@@@@%##*##%@@@@@@@@@%***#@@@@@=-/|\r\n" + //
                            "----=@@@@@@@@@@@%%%%###%%@@@@@@@@@@@@@@@@@%/ |\r\n" + //
                            "----=@@@@@@@@@@@%%%%%@%%%@@@@@@@@@@@@@@@@/   |\r\n" + //
                            "----+@@@@@@@@@@@%%###%%%%%@@@@@@@@@@@@//  15/ ";

    static String DESC_Hallway_First = "You take steps north and into the hallway. You look up and down the hallway to see a multitude of prison cells. But that isn't important now. To your left is an unlocked door that should lead to the common room. At the east end of the hallway, you see a locked door labeled by the word \"Exit\" and the number two. More good luck?!";

    static String DESC_Hallway = "You find yourself in the hallway again. To the east is your escape, emblazoned with the number 2 and the word EXIT, and to the west, the prison's common room.";
    static String DESC_Hallway_Open = "You find yourself in the hallway again. The exit door to the east is open! But the common room still invites you to go west... You can't tell why.";

    static String DESC_Common(int cellarItemsCount, boolean chairGrabbed) { return "You're in the prison's common room. It's honestly pretty nice here, but you can't delay. " + (!chairGrabbed ? "" : "There's a single chair in the room. ") + "To your east is the hallway with the escape door. To the north is a small cellar with a red number " + cellarItemsCount + " above its strong frame. The door is slightly ajar, you should be able to get in. To the south is a metal door with the number 5 written in a massive numeral above it." + (cellarItemsCount >= 5 ? " It's open and seems to be inviting you in." : ""); }
    static String GRAB_Chair = "You pick up the chair and hold it over your head. It's pretty heavy, but you never know when your legs will get tired. It's important.";

    static String DESC_Cellar = "You wiggle your way into the cellar. There's a massive pressure plate on the ground. It seems like if you drop some of your precious belongings, something helpful might happen. To the south lies the common room.";
    static String Drop_Two = "You drop your second item onto the trapdoor, and a loud door sound rings through the hallway.";
    static String Drop_Five = "You drop your fourth item onto the trapdoor, and a loud door sound sounds in the common.";

    static String DESC_ControlRoom = "You walk into room you opened by placing four items on the pressure plate. Once inside, you see a large lever almost begging to be pulled. Above it is bright red and yellow text written in a language you can't read. The common room is to your north.";

    static String USE_Lever = "The lever is extremely difficult to pull, like it hasn't been used in centuries. However, after great effort, you pull it down. Immediately, loud sirens begin to blare. You'd better get out of here. You're pretty sure you remember the route...";

    static String DESC_WardensRoom = "The warden is luckily nowhere to be found. In fact, you can't ever remember seeing a warden before. No matter, there has to be some useful stuff here. Maybe the computer on the warden's desk, or the papers strewn about?";

}