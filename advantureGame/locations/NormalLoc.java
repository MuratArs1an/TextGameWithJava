package advantureGame.locations;

import advantureGame.Player;

public abstract class NormalLoc extends Locations{
    public NormalLoc(String locName, Player player) {
        super(locName, player);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
