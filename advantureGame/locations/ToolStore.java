package advantureGame.locations;

import advantureGame.Player;
import advantureGame.tools.Armor;
import advantureGame.tools.Weapon;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super("ToolStore", player);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to ToolStore");
        boolean showMenu=true;
        while(showMenu){
            System.out.println("1-Weapons");
            System.out.println("2-Armors");
            System.out.println("3-Exit");
            System.out.println("Choise: ");
            int selected=input.nextInt();
            while(selected<1 || selected>3){
                System.out.println("Wrong Answer Try Again");
                selected=input.nextInt();
            }

            switch (selected){
                case 1:
                    weapons();
                    break;
                case 2:
                    armors();
                    break;
                case 3:
                    System.out.println("Come BAck Again");
                    showMenu=false;
                    break;
            }
        }
        return true;
    }

    public void weapons(){
        System.out.println("------Weapons-------");
        for(Weapon weapon : Weapon.weapons()){
            System.out.println(weapon.getId()+" "+weapon.getName()+
                    " <Value: "+weapon.getValue()+" >"+
                    " <Damage: "+weapon.getDamage()+" >");
        }
        System.out.println("0-Exit");
        System.out.println("Choise Your Weapon :");
        int selected=input.nextInt();
        if(selected!=0){
            checkAnswer(selected,Weapon.weapons().length);

            Weapon selectedWeapon=Weapon.getWeaponByID(selected);
            if(selectedWeapon.getValue()>this.getPlayer().getMoney()){
                System.out.println("Sorry! You Don`t Have Enough Money");
            }else{
                System.out.println("You Have  "+selectedWeapon.getName());
                int balance=this.getPlayer().getMoney()-selectedWeapon.getValue();
                this.getPlayer().setMoney(balance);
                System.out.println("Your money: "+this.getPlayer().getMoney()+ " gold now");
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }

    public void armors(){
        System.out.println("-------Armors-------");
        for(Armor armor : Armor.armors()){
            System.out.println(armor.getId()+" "+armor.getName()+
                    " <Value: "+armor.getValue()+" >"+
                    " <Block: "+ armor.getBlock()+" >");
        }
        System.out.println("0-Exit");
        System.out.println("Choise Your Weapon :");
        int selected=input.nextInt();
        if (selected!=0){
            checkAnswer(selected,Armor.armors().length);
            Armor selectedArmor=Armor.getArmorByID(selected);
            if(selectedArmor.getValue()>this.getPlayer().getMoney()){
                System.out.println("Sorry! You Don`t Have Enough Money");
            }else{
                System.out.println("You Have  "+selectedArmor.getName());
                int balance=this.getPlayer().getMoney()-selectedArmor.getValue();
                this.getPlayer().setMoney(balance);
                System.out.println("Your money: "+this.getPlayer().getMoney()+ " gold now");
                this.getPlayer().getInventory().setArmor(selectedArmor);
            }

        }
    }

    public int checkAnswer(int selected,int size){

        while(selected<0 || selected>size){
            System.out.println("Wrong Answer Try Again");
            selected=input.nextInt();
        }
        return selected;
    }
}
