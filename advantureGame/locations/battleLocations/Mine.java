package advantureGame.locations.battleLocations;

import advantureGame.Player;
import advantureGame.monsters.Snake;


public class Mine extends BattleLoc{
    public Mine(Player player) {
        super( "Mine",player, new Snake(), "None",5);
    }

}
