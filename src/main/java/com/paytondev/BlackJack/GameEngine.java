package com.paytondev.BlackJack;

import java.util.ArrayList;
import java.util.Scanner;


public class GameEngine {
    ArrayList<Computer> computerPlayers = new ArrayList<>();
    Player player = new Player();

    Scanner scanner = new Scanner(System.in);

    public GameEngine(){


    }

   public void startGame() {
        for (Computer c : computerPlayers){

   }

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
