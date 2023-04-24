package advantureGame.locations.battleLocations;

import advantureGame.Player;
import advantureGame.monsters.Bear;

public class River extends BattleLoc{
    private static boolean isCleared=false;
    public River(Player player) {
        super( "River",player,new Bear(),"Water",3);
    }
    public static boolean isCleared() {
        return isCleared;
    }


    public static void setCleared(boolean cleared) {
        isCleared = cleared;
    }
}
