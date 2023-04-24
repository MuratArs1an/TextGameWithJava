package advantureGame.heroes;

public abstract class Hero {
    private int id;
    private int damage;
    private int health;
    private int money;
    private String heroName;
    public Hero(int id,String heroName,int damage, int health, int money){
        this.damage=damage;
        this.health=health;
        this.money=money;
        this.heroName=heroName;
        this.id=id;
    }

    public int getDamage() {
        return damage;
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
    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
