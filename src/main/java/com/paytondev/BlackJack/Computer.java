package com.paytondev.BlackJack;

public class Computer extends Player {


    String computerName;

    int computerChips;

    public Computer(String name) {
        this.computerName = name;
        computerChips = 500;
    }

    public void setComputerChips(int chipAmount) {
        computerChips = chipAmount;
    }

    public void changeComputerChips(int chipAmount) {
        computerChips += chipAmount;
    }

    @Override
    public void receiveCard(Card card) {
        playerHand.receiveCard(card);
    }

    @Override
    public String playTurn() {
        if (playerHand.isBlackJack()){
            return "blackjack";
        }
        else if (returnIsBusted()){
            return "Busted";
        }
        else if (playerHand.checkHand() <= 17) {
            int random = (int) (Math.random() * 100 + 1);
            if (random <= 25) {
                return "Hit";
            } else return "Stay";
        } else {
            return "Stay";
        }
    }


    @Override
    public String getName() {
        return computerName;
    }


}
