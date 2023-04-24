package advantureGame.tools;

public class Armor {
    private int id;
    private String name;
    private int block;
    private int value;

    public Armor(int id, String name, int block, int value) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.value = value;
    }
    public static Armor[] armors(){
        Armor[] armors={
                new Armor(0,"Cloth",0,0),
                new Armor(1,"Light Armor",1,15),
                new Armor(2,"Middle Armor", 3,25),
                new Armor(3, "High Armor",5,40)};
        return  armors;
    }

    public static Armor getArmorByID (int id){
        for(Armor a:Armor.armors()){
            if(a.getId()==id){
                return a;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
