package advantureGame.locations;

import advantureGame.Player;

import java.util.Scanner;

public abstract class Locations {
    private String locName;
    private Player player;
    protected Scanner input=new Scanner(System.in);

    public Locations(String locName, Player player) {
        this.locName = locName;
        this.player = player;
    }

    public Locations(Player player, String name) {
    }

    public abstract boolean onLocation();

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
