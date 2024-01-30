package com.paytondev.BlackJack;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class GameEngine {
    ArrayList<Player> playerList = new ArrayList<>();
    Dealer dealer;
    Player player;
    HumanPlayer humanPlayer = new HumanPlayer();

    Scanner scanner = new Scanner(System.in);

    public GameEngine(){
        setComputerPlayers();
    }


    // The actual flow of the game starts here, initializing the dealer and the player passing them as parameters so that the dealer can manage the players and computers respectively
   public void startGame() {
       player = new Player();
       playerList.add(player);
       dealer = new Dealer(playerList);

       dealer.dealCards();
       dealer.displayDealerFirstCard();

   }


    public void setComputerPlayers(){

        System.out.println("How many computer players would you like to add to the table");
        int numberOfPlayers = scanner.nextInt();
        for (int i = numberOfPlayers; i > 0; i--){
            playerList.add(new Computer(assignComputerName()));
        }

    }


// Here we are grabbing a random
    public String assignComputerName(){
        ArrayList<String> nameList = new ArrayList<>();
        try {
            File file = new File("/Users/paytonkeultjes/Computer-Science-Main/BlackJackv1/src/main/java/com/paytondev/BlackJack/first-names.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String temp;
            int random = (int) (Math.random() * 4945 + 1);
            while((temp = reader.readLine()) != null ){
                nameList.add(temp);
            }
            String delayedString = nameList.get(random);
            nameList.clear();
            return delayedString;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void testComputerNames(){
        for (Player p : playerList){
            System.out.println(p.getName());
        }
    }


}
