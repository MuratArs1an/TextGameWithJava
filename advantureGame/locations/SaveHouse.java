package advantureGame.locations;

import advantureGame.Player;

public class SaveHouse extends NormalLoc{
    public SaveHouse(Player player) {
        super("Save House", player);
    }

    @Override
    public boolean onLocation() {
        System.out.println("You Are in SaveHouse");
        System.out.println("Your Health full now");
        System.out.println();
        if(!isWin()){
          return false;
        };

        this.getPlayer().setHealth(this.getPlayer().getDefHealth());
        this.getPlayer().playerInfo();
        return true;
    }
    public boolean isWin(){
        if(getPlayer().getInventory().getItems().isFirewood()&&
                getPlayer().getInventory().getItems().isFood()&&
                getPlayer().getInventory().getItems().isWater()){
            System.out.println();
            System.out.println("----------------------------------");
            System.out.println("+++++++++++++YOU WIN++++++++++++++");
            System.out.println("----------------------------------");
            System.out.println();
            return false;
        }
        return true;
    }
}
