package com.paytondev.BlackJack;

import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);
    PlayerHand handList = new PlayerHand();
    private String playerName;


    public int playerChips;
    boolean playerWin = false;

    public Player() {
        playerChips = 500;
        this.playerWin = false;
    }

    public void setPlayerChips(int chipAmount) {
        playerChips = chipAmount;
    }

    public void changePlayerChips(int chipAmount) {
        playerChips += chipAmount;
    }

public void setPlayerName() {
    System.out.println("Please enter your name. Please note this will be your name for the rest of the game.");
    String userInput = scanner.nextLine();
}

public String getPlayerName(){
        return playerName;
}

/* This method returns an integer purely because it can be used when displaying a players
     hand during their turn or when other players need to see the other hands
*/






    public boolean returnWin(){
        return playerWin;
    }


}


