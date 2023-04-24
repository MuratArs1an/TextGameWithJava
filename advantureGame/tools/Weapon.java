package advantureGame.tools;

public class Weapon {
    private String name;
    private int id;
    private int damage;
    private int value;

    public Weapon(String name, int id, int damage, int value) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.value = value;
    }

    public static Weapon[] weapons(){
        Weapon[] weapons={new Weapon("Fist",0,0,0),
                new Weapon("Shot gun",1,2,25),
                new Weapon("Sword",2, 3,35),
                new Weapon("Rifle", 3,7,45)};
        return  weapons;
    }

    public static Weapon getWeaponByID (int id){
        for(Weapon w:Weapon.weapons()){
            if(w.getId()==id){
                return w;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
