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
        boolean killGameLoop = false;


       //Here are my thoughts here before I implement the background methods for the individual player methods and algos

       //The game should start with the dealer dealing cards to all the available players, including themselves
       //The Dealer then reveals one of their cards
       // We then cycle through the arrayList and each player plays their turn
       //   While we are going through the turns each player should have the ability to see their own deck and should be able to hit or stay
       // The dealer reveals their second card
       // Given the dealers card total the dealer would either have to hit or stay, then depending on the value of the deck the corresponding players either bust or win the round

       //There should also be a leaderboard of the sorts
       while(killGameLoop){

           dealer.dealCards();
           System.out.println("Dealer's Cards");
           dealer.displayDealerFirstCard();

           for (Player p : playerList){
               System.out.println(p.getName() + "'s Turn: ");
               p.playerHand.displayPlayerHand();
               System.out.println("Current Hand Value: " + p.playerHand.checkHand());
                if (p.playerHand.isBlackJack()){
                    System.out.println(p.getName() + " has won this round with a blackjack!");
                    // Send player Cards Back To Shoe
                    killGameLoop = true;
                } else if (p.playerHand.checkBust()) {
                    System.out.println(p.getName() + " has went over 21! " +  p.getName() + " is now out for the remainder of the round");
                    // Send player Cards Back To Shoe
                }
                else {
                    System.out.println();
                }
           }

       }





   }


    public void setComputerPlayers(){

        System.out.println("How many computer players would you like to add to the table");
        int numberOfPlayers = scanner.nextInt();
        for (int i = numberOfPlayers; i > 0; i--){
            playerList.add(new Computer(generateComputerName()));
        }

    }






// Here we are grabbing a random name from a text list to assign to each computer player
    // Heres how I would improve this...
    // I would first make the nameList array and instance member of the class instead of a local variable within the method
    //  I would then have another method that would then build the arraylist from the text file so that we dont keep building the array from scratch over and over losing performance
    public String generateComputerName(){
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

// This is just a case test to see if the specific names in our computer playerList work.
    public void testComputerNames(){
        for (Player p : playerList){
            System.out.println(p.getName());
        }
    }


}
