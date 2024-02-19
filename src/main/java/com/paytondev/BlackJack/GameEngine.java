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
       System.out.println();
       playerList.add(humanPlayer);
       dealer = new Dealer(playerList);
       dealer.shuffleShoeDeck();
        boolean killGameLoop = false;
      // System.out.println("TEST CASE ONE");

       //Here are my thoughts here before I implement the background methods for the individual player methods and algos

       //The game should start with the dealer dealing cards to all the available players, including themselves
       //The Dealer then reveals one of their cards
       // We then cycle through the arrayList and each player plays their turn
       //   While we are going through the turns each player should have the ability to see their own deck and should be able to hit or stay
       // The dealer reveals their second card
       // Given the dealers card total the dealer would either have to hit or stay, then depending on the value of the deck the corresponding players either bust or win the round

       //There should also be a leaderboard of the sorts
       while(!killGameLoop){
         //  System.out.println("TEST CASE 2");

           dealer.dealCards();
           System.out.println("Dealer's Cards");
           dealer.displayDealerFirstCard();

           for (Player p : playerList){

               System.out.println(" \n Press enter to continue the game");
               scanner.nextLine();


              // System.out.println("test 3");
               System.out.println(p.getName().toUpperCase() + "'s TURN: ");
               p.playerHand.displayPlayerHand();
               System.out.println("Current Hand Value: " + p.playerHand.checkHand());
                if (p.playerHand.isBlackJack()){
                    System.out.println(p.getName() + " has won this round with a blackjack!");

                    for (int i = 0; i < playerList.size(); i++ ){
                        if (playerList.get(i).equals(p)){
                            dealer.returnCardsToShoe(i);
                            playerList.get(i).playerHand.resetHand();
                        }
                    }

                    killGameLoop = true;
                } else if (p.playerHand.checkBust()) {
                    System.out.println(p.getName() + " has went over 21! " +  p.getName() + " is now out for the remainder of the round");
                    for (int i = 0; i < playerList.size(); i++ ){
                        if (playerList.get(i).equals(p)){
                            dealer.returnCardsToShoe(i);
                            playerList.get(i).playerHand.resetHand();
                        }
                    }
                }
                else {
                    boolean killLocalLoop = false;
                    // Here lays the actual content of the game
                    // Here we will implement the players turn
                    // However as it iterates through the Player list the method playTurn(); will behave differently depending on the state of the individual Player child objects

                    while(!killLocalLoop){
                        String result = p.playTurn();
                        if (result.equalsIgnoreCase("Hit")){
                            System.out.println(p.getName() + ": Has chosen to hit!");
                            System.out.println("Dealing another card!");
                            p.playerHand.receiveCard(dealer.dealSingleCard());
                            System.out.println(p.getName() + ": has a new hand value of:" + p.playerHand.checkHand());
                        }
                        else {
                            System.out.println(p.getName() + ": Has chosen to stay!");
                            System.out.println("Rotating to the next player ");
                            killLocalLoop = true;
                        }

                    }


                    }
                    System.out.println();
                }
           }

       }








    public void setComputerPlayers(){

        System.out.println("How many computer players would you like to add to the table");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();
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
