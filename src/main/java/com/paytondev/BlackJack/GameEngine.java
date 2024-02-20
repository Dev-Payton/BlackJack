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

    public GameEngine() {
        setComputerPlayers();
    }


    // The actual flow of the game starts here, initializing the dealer and the player passing them as parameters so that the dealer can manage the players and computers respectively
    public void startGame() {
        System.out.println();
        playerList.add(humanPlayer);
        dealer = new Dealer(playerList);
        dealer.shuffleShoeDeck();
        boolean killGameLoop = false;



        while (!killGameLoop) {


            dealer.dealCards();
            System.out.println("Dealer's Cards");
            System.out.println("• " + dealer.displayDealerFirstCard());
            System.out.println("• [HIDDEN CARD]");

            for (Player p : playerList) {

                System.out.println(" \nPress enter to continue the game");
                scanner.nextLine();


                System.out.println(p.getName().toUpperCase() + "'s TURN: ");
                p.playerHand.displayPlayerHand();
                System.out.println("Current Hand Value: " + p.playerHand.checkHand());
                if (p.playerHand.isBlackJack()) {
                    System.out.println(p.getName() + " has won this round with a blackjack!");

                    for (int i = 0; i < playerList.size(); i++) {
                        if (playerList.get(i).equals(p)) {
                            dealer.returnCardsToShoe(i);
                            playerList.get(i).playerHand.resetHand();
                        }
                    }

                    break;
                } else if (p.playerHand.checkBust()) {
                    p.setBusted(true);
                    System.out.println(p.getName() + " has went over 21! " + p.getName() + " is now out for the remainder of the round");
                    for (int i = 0; i < playerList.size(); i++) {
                        if (playerList.get(i).equals(p)) {
                            dealer.returnCardsToShoe(i);
                            playerList.get(i).playerHand.resetHand();
                        }
                    }
                } else {
                    boolean killLocalLoop = false;
                    // Here lays the actual content of the game
                    // Here we will implement the players turn
                    // However as it iterates through the Player list the method playTurn(); will behave differently depending on the state of the individual Player child objects

                    while (!killLocalLoop) {
                        if (p.playerHand.checkHand() > 21){
                            System.out.println(p.getName() + " has went over 21! " + p.getName() + " is now out for the remainder of the round");
                            p.setBusted(true);
                            break;
                        }
                        String result = p.playTurn();

                        if (result.equalsIgnoreCase("Blackjack")){
                            System.out.println(p.getName() + " has a BlackJack ! ");
                            System.out.println(p.getName() + " has won the round!");
                            killLocalLoop = true;
                            break;
                        }
                        else if (result.equalsIgnoreCase("Busted")){
                            System.out.println(p.getName() + " has went over 21! " + p.getName() + " is now out for the remainder of the round");
                        }
                        else if (result.equalsIgnoreCase("Hit")) {
                            System.out.println(p.getName() + ": Has chosen to hit!");
                            System.out.println("Dealing another card!");
                            p.playerHand.receiveCard(dealer.dealSingleCard());
                            System.out.println(p.getName() + ": has a new hand value of: " + p.playerHand.checkHand());
                        } else {
                            System.out.println(p.getName() + ": Has chosen to stay!");
                            System.out.println("Rotating to the next player ");
                            killLocalLoop = true;
                            break;

                        }

                    }


                }
                System.out.println();
            }
            System.out.println("Displaying All Player Hand Values");
            dealer.displayAllPlayerHands();
            System.out.println("Displaying dealer's Cards:");
            dealer.displayDealerDeck();
            if (dealer.returnDealerHand().checkHand() == 17) {
                for (Card c : dealer.returnDealerHand().returnPlayerHand()) {
                    if (c.toString().equalsIgnoreCase("ACE")) {
                        System.out.println("Dealer has Soft 17");
                        System.out.println("Dealer is forced to hit");
                        dealer.returnDealerHand().receiveCard(dealer.dealSingleCard());
                    } else {
                        System.out.println("Dealer Is Staying");
                    }
                }

            } else if (dealer.returnDealerHand().checkHand() > 17) {
                System.out.println("Dealer is Staying");
            } else if (dealer.returnDealerHand().checkHand() < 16) {
                boolean equalOrOver = false;
                while (!equalOrOver) {
                    if (dealer.returnDealerHand().checkHand() < 16) {
                        System.out.println("Dealer Has a Hand Value Under 16...Hitting");
                        dealer.returnDealerHand().receiveCard(dealer.dealSingleCard());
                    } else if (dealer.returnDealerHand().checkHand() >= 16) {
                        equalOrOver = true;
                    }
                }
            }


            //Implement dealer bust

            if (dealer.returnIsBusted()) {
                System.out.println("Dealer has busted!");


            } else if (!dealer.returnIsBusted()) {
                String topPlayer = "";
                int topPlayerHand = 0;

                for (Player p : playerList) {
                    if (!p.returnIsBusted() && p.playerHand.checkHand() > topPlayerHand) {
                        topPlayerHand = p.playerHand.checkHand();
                        topPlayer = p.name;
                    }
                }
                if (dealer.returnDealerHand().checkHand() > topPlayerHand) {
                    System.out.println("Dealer has won the round!");
                } else {
                    System.out.println(topPlayer + " has won the round!");
                }
            }

            killGameLoop = true;


        }

    }


    public void setComputerPlayers() {

        System.out.println("How many computer players would you like to add to the table");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();
        for (int i = numberOfPlayers; i > 0; i--) {
            playerList.add(new Computer(generateComputerName()));
        }

    }


    // Here we are grabbing a random name from a text list to assign to each computer player
    // Heres how I would improve this...
    // I would first make the nameList array and instance member of the class instead of a local variable within the method
    //  I would then have another method that would then build the arraylist from the text file so that we dont keep building the array from scratch over and over losing performance
    public String generateComputerName() {
        ArrayList<String> nameList = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\payto\\IdeaProjects\\BlackJackv1\\src\\main\\java\\com\\paytondev\\BlackJack\\first-names.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String temp;
            int random = (int) (Math.random() * 4945 + 1);
            while ((temp = reader.readLine()) != null) {
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
    public void testComputerNames() {
        for (Player p : playerList) {
            System.out.println(p.getName());
        }
    }


}
