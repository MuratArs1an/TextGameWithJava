package advantureGame.locations.battleLocations;

import advantureGame.Player;
import advantureGame.locations.Locations;
import advantureGame.monsters.Monsters;
import advantureGame.monsters.Snake;

import java.util.Random;

public abstract class BattleLoc extends Locations {
    private Monsters monsters;
    private String award;
    private int maxMonster;

    public BattleLoc(String locName, Player player, Monsters monsters, String award, int maxMonster) {
        super(locName, player);
        this.monsters = monsters;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation(){
        System.out.println();
        int monsterSize=randomMonsterNum();
        System.out.println("Prepare to Fight with "+monsterSize+" "+this.getMonsters().getName());
        System.out.println("<F> fight or <R> run");
        String selectCase=input.nextLine().toUpperCase();

        if(selectCase.equals("F")){
            System.out.println("===========Fight==========");
            if(combat(monsterSize)) {
                System.out.println();
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("Congratulations  You Clear :"+this.getLocName());
                if(this.getLocName().equals("Mine")){
                    Snake snake=new Snake();
                    snake.rewardSelector(this.getPlayer());
                    this.getPlayer().setMoney(this.getPlayer().getMoney()+(monsterSize* snake.getAward()));
                    return true;
                }
                this.getPlayer().setMoney(this.getPlayer().getMoney()+(monsterSize*this.getMonsters().getAward()));
                System.out.println("You won :"+(monsterSize*this.getMonsters().getAward())+" money" );
                System.out.println("Your Total Money: "+this.getPlayer().getMoney());
                rewardHandler();
                return true;
            }
        }
        if(this.getPlayer().getHealth()<=0){
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNum){
        int monsterTrueDamage=this.getMonsters().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
        if(monsterTrueDamage<0){
            monsterTrueDamage=0;
        }
        for(int i=0; i<monsterNum; i++){
            this.getMonsters().setHealth(this.getMonsters().getDefHealth());
            System.out.println("======Monster=====");
            getMonsters().monsterInfo();
            System.out.println("======Player=======");
            getPlayer().playerInfo();
            System.out.println();
            while(this.getPlayer().getHealth()>0 && this.getMonsters().getHealth()>0){
                System.out.println();
                System.out.println();
                System.out.println("*****Fight*****");
                if(randomFight()==0){
                    System.out.println("---------Player Hit--------");
                    this.getMonsters().setHealth(this.getMonsters().getHealth()-this.getPlayer().getDamage());
                    System.out.println(this.getPlayer().getCharType()+" Health:   " +this.getPlayer().getHealth());
                    System.out.println(this.getMonsters().getName()+" Health:   "+this.getMonsters().getHealth());
                    if(this.getMonsters().getHealth()>0){
                        System.out.println();
                        System.out.println("--------Monster Hit-------");
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-monsterTrueDamage);
                        System.out.println(this.getPlayer().getCharType()+" Health:   " +this.getPlayer().getHealth());
                        System.out.println(this.getMonsters().getName()+" Health:   "+this.getMonsters().getHealth());
                    }
                }else{
                    System.out.println("--------Monster Hit-------");
                    this.getPlayer().setHealth(this.getPlayer().getHealth()-monsterTrueDamage);
                    System.out.println(this.getPlayer().getCharType()+" Health:   " +this.getPlayer().getHealth());
                    System.out.println(this.getMonsters().getName()+" Health:   "+this.getMonsters().getHealth());
                    if(this.getPlayer().getHealth()>0){
                        System.out.println("---------Player Hit--------");
                        this.getMonsters().setHealth(this.getMonsters().getHealth()-this.getPlayer().getDamage());
                        System.out.println(this.getPlayer().getCharType()+" Health:   " +this.getPlayer().getHealth());
                        System.out.println(this.getMonsters().getName()+" Health:   "+this.getMonsters().getHealth());
                    }
                }

            }
            if(this.getPlayer().getHealth()<=0){
                return false;
            }

        }
        return true;
    }

    public void rewardHandler(){
        if(this.getLocName().equals("Cave")){
            this.getPlayer().getInventory().getItems().setFood(true);
            Cave.setCleared(true);
        }else if(this.getLocName().equals("Forest")){
            this.getPlayer().getInventory().getItems().setFirewood(true);
            Forest.setCleared(true);
        } else if (this.getLocName().equals("River")) {
            this.getPlayer().getInventory().getItems().setWater(true);
            River.setCleared(true);
        }
    }



    public int randomMonsterNum(){
        Random r=new Random();
        return r.nextInt(this.getMaxMonster())+1;
    }

    public int randomFight(){
        Random r=new Random();
        return r.nextInt(2);
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    public Monsters getMonsters() {
        return monsters;
    }

    public void setMonsters(Monsters monsters) {
        this.monsters = monsters;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

}
