package advantureGame.monsters;

import advantureGame.Player;
import advantureGame.tools.Armor;
import advantureGame.tools.Inventory;
import advantureGame.tools.Weapon;

import java.util.Random;

public class Snake extends Monsters{



    public Snake() {
        super(4,"Snake",Snake.randomDamage(),12,0);
    }

    public static int randomDamage(){
        Random r=new Random();
        return r.nextInt(3,6)+1;
    }

    public int randomItems(){
        Random r=new Random();
        return r.nextInt(100)+1;
    }

    public void rewardSelector(Player player){
        int random1=randomItems();
        int random2=randomItems();
        if(random1<16){
            if(random2<51){
                System.out.println("You Won Shotgun");
                player.getInventory().setWeapon(Weapon.getWeaponByID(1));
            }else if(random2>50 && random2<81){
                System.out.println("You Won Sword");
                player.getInventory().setWeapon(Weapon.getWeaponByID(2));
            }else{
                System.out.println("You Won Rifle");
                player.getInventory().setWeapon(Weapon.getWeaponByID(3));
            }
        }else if(random1>15 && random1<31){
            if(random2<51){
                System.out.println("You Won Light-Armor");
                player.getInventory().setArmor(Armor.getArmorByID(1));
            }else if(random2>50 && random2<81){
                System.out.println("You Won Middle-Armor");
                player.getInventory().setArmor(Armor.getArmorByID(2));
            }else{
                System.out.println("You Won High-Armor");
                player.getInventory().setArmor(Armor.getArmorByID(3));
            }
        }else if(random1>30 && random1<56){
            if(random2<51){
                this.setAward(1);
                System.out.println("You Won "+this.getAward()+" Money");
            }else if(random2>50 && random2<81){
                this.setAward(5);
                System.out.println("You Won "+this.getAward()+" Money");
            }else{
                this.setAward(10);
                System.out.println("You Won "+this.getAward()+" Money");
            }
        }else{
            System.out.println("You Won Nothing, Try Again");
            this.setAward(0);
        }
    }

}
