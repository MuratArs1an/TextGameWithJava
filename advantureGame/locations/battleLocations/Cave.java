package advantureGame.locations.battleLocations;

import advantureGame.Player;
import advantureGame.monsters.Zombie;

public class Cave extends BattleLoc{
    private static boolean isCleared=false;
    public Cave(Player player) {
        super( "Cave",player, new Zombie(), "Food",3);
    }


    public static boolean isCleared() {
        return isCleared;
    }


    public static void setCleared(boolean cleared) {
        isCleared = cleared;
    }
}
