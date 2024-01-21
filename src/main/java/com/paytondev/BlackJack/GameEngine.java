package com.paytondev.BlackJack;

import java.util.ArrayList;
import java.util.Scanner;


public class GameEngine {
    ArrayList<Computer> computerPlayers = new ArrayList<>();
    Dealer dealer;
    Player player = new Player();
    Scanner scanner = new Scanner(System.in);

    public GameEngine(){
        player.setPlayerName();
        setPlayers();
    }


    // The actual flow of the game starts here, initializing the dealer and the player passing them as parameters so that the dealer can manage the players and computers respectively
   public void startGame() {


   }


    public void setPlayers(){
        System.out.println("BlackJack\n\t Version 1.0");
        System.out.println("How many computer players would you like to add to the table");
        int numberOfPlayers = scanner.nextInt();
        for (int i = numberOfPlayers; i > 0; i--){
            computerPlayers.add(new Computer());
        }
    }




}
