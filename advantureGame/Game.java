package advantureGame;

import advantureGame.locations.Locations;
import advantureGame.locations.SaveHouse;
import advantureGame.locations.ToolStore;
import advantureGame.locations.battleLocations.Cave;
import advantureGame.locations.battleLocations.Forest;
import advantureGame.locations.battleLocations.Mine;
import advantureGame.locations.battleLocations.River;

import java.util.Scanner;

public class Game {
    private Scanner input =new Scanner(System.in);
    public void start(){
        System.out.println("Welcome to Adventure Game");
        System.out.println("Please enter your name: ");
        String playerName=input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Welcome to Adventure Game");
        System.out.println("Select Your Hero");
        player.selectChar();
        Locations locations=null;

        while(true){
            System.out.println("+++++++++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println("Locations");
            System.out.println();
            System.out.println("1-Save House");
            System.out.println("2-Tool Store");
            System.out.println("3-Cave");
            System.out.println("4-Forest");
            System.out.println("5-River");
            System.out.println("6-Mine");
            System.out.println("0-Exit Game");
            System.out.println("Select Your Location :");
            int selectedLoc=input.nextInt();
            switch (selectedLoc) {
                case 0:
                    locations=null;
                    break;
                case 1:
                    locations = new SaveHouse(player);
                    break;
                case 2:
                    locations = new ToolStore(player);
                    break;
                case 3:
                    if(Cave.isCleared()){
                        System.out.println();
                        System.out.println("^^^^^^^^^^Bolge Temizlendi^^^^^^^^^^");
                        System.out.println("Buraya Tekrar Giris Yapamazsiniz");
                        System.out.println();
                        break;
                    }
                    locations=new Cave(player);
                    break;
                case 4:
                    if(Forest.isCleared()){
                        System.out.println();
                        System.out.println("^^^^^^^^^^Bolge Temizlendi^^^^^^^^^^");
                        System.out.println("Buraya Tekrar Giris Yapamazsiniz");
                        System.out.println();
                        break;
                    }
                    locations=new Forest(player);
                    break;
                case 5:
                    if(River.isCleared()){
                        System.out.println();
                        System.out.println("^^^^^^^^^^Bolge Temizlendi^^^^^^^^^^");
                        System.out.println("Buraya Tekrar Giris Yapamazsiniz");
                        System.out.println();
                        break;
                    }
                    locations=new River(player);
                    break;
                case 6:
                    locations=new Mine(player);
                    break;
                default:
                    locations = new SaveHouse(player);
            }
            System.out.println("+++++++++++++++++++++++++++++++++++++");
            if(locations==null){
                System.out.println("Good Bye Loser");
                break;
            }
            if(!locations.onLocation()){
                System.out.println("============================");
                System.out.println("GAME OVER");
                System.out.println("============================");
                break;
            }
        }
    }
}
