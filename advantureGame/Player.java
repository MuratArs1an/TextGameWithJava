package advantureGame;

import advantureGame.heroes.Archer;
import advantureGame.heroes.Hero;
import advantureGame.heroes.Knight;
import advantureGame.heroes.Samurai;
import advantureGame.locations.Locations;
import advantureGame.locations.SaveHouse;
import advantureGame.locations.ToolStore;
import advantureGame.tools.Inventory;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int money;
    private String name;
    private String charType;

    private Inventory inventory;
    private int defHealth;
    private Scanner input=new Scanner(System.in);

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }

    public void selectChar(){
        Hero[] heroList={new Samurai(),new Archer(),new Knight()};
        System.out.println("--------------------------------------------------");
        System.out.println("Characters");
        for(Hero hero : heroList){
            System.out.println("Id "+hero.getId()
                    +"\t"+ hero.getHeroName()
                    +"\t Damage: "+hero.getDamage()
                    +"\t Health: "+hero.getHealth()
                    +"\t Money: "+hero.getMoney());
        }
        System.out.println("Your Choise : ");
        int selected=input.nextInt();
        switch (selected){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println(this.getCharType()+" is choisen... Good Luck");

    }

    public void selectLoc(){

    };

    public void initPlayer(Hero hero){
        this.setDamage(hero.getDamage());
        this.setHealth(hero.getHealth());
        this.setMoney(hero.getMoney());
        this.setCharType(hero.getHeroName());
        this.setDefHealth(hero.getHealth());
    }

    public void playerInfo(){
        System.out.println("Weapon: "+this.inventory.getWeapon().getName()
                +"\t Armor: "+this.inventory.getArmor().getName()
                +"\t Damage: "+this.getDamage()
                +"\t Health: "+this.getHealth()
                +"\t Block: "+this.inventory.getArmor().getBlock()
                +"\t Money: "+this.getMoney()
                +"\t Items: "
                +"\t Food: "+this.inventory.getItems().isFood()
                +"\t Water: "+this.inventory.getItems().isWater()
                +"\t Firewood: "+this.inventory.getItems().isFirewood());
    }
    public int getDamage() {
        return damage+this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharType() {
        return charType;
    }

    public void setCharType(String charType) {
        this.charType = charType;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
}
