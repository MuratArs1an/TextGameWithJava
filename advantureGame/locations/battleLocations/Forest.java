package advantureGame.locations.battleLocations;

import advantureGame.Player;
import advantureGame.monsters.Monsters;
import advantureGame.monsters.Vampire;

public class Forest extends BattleLoc{
    private static boolean isCleared=false;
    public Forest(Player player) {
        super( "Forest",player, new Vampire(), "FireWood",3);
    }
    public static boolean isCleared() {
        return isCleared;
    }


    public static void setCleared(boolean cleared) {
        isCleared = cleared;
    }
}
