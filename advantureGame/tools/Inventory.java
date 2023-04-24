package advantureGame.tools;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private Items items;


    public Inventory() {
        this.weapon =new Weapon("Fist", -1, 0,0);
        this.armor=new Armor(-1,"Cloth",0,0);
        this.items=new Items(false,false,false);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
