package com.paytondev.BlackJack;

import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    PlayerCards playerDeck = new PlayerCards();
    private final int TWENTY_ONE = 21;
    int handCount = 0;
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


    public void playerChoice() {

        while(checkHand() <= TWENTY_ONE)  {
            checkWin();
            if (checkWin() == TWENTY_ONE){
                // implement win conditions
            }
            else{
                System.out.println("Your current hand has a value of: " + checkHand());
                System.out.println(" Hit Or Stand");
                System.out.println(" Enter 'H' or 'S' ");
                String userInput = scanner.nextLine();

            }
        }


    }
/* This method returns an integer purely because it can be used when displaying a players
     hand during their turn or when other players need to see the other hands
*/
    public int checkHand() {
        for (Card c : playerDeck.getPlayerHand()) {
            handCount += c.getFACE();
        }

        if (handCount > TWENTY_ONE) {
            for (Card c : playerDeck.getPlayerHand()) {
                if (c.getFACE() == 11) {
                    c.setFace(1);
                }
            }
        }
        checkBust();
        checkWin();
        return handCount;

    }


    public String getHandToString(){
        return handCount + "";
    }

    public void checkBust(){
        if (handCount > TWENTY_ONE){
            playerDeck.getPlayerHand().clear();
        }
        handCount = 0;
    }

    public void checkWin(){
        if (handCount == TWENTY_ONE){
            playerWin = true;
        }
    }

    public boolean returnWin(){
        return playerWin;
    }


}


