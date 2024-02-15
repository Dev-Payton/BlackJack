package com.paytondev.BlackJack;

public class HumanPlayer extends Player{


    @Override
    public void receiveCard(Card card) {
        playerHand.receiveCard(card);
    }

    @Override
    public String playTurn() {
        boolean killLoop = false;
        while(!killLoop){
            System.out.println("Would you like to hit or stay?");
            String userInput = scanner.nextLine();
            if (userInput.isEmpty()){
                System.out.println("Invalid Input: Please try again");
            }
            else if (userInput.equalsIgnoreCase("Hit")){
                killLoop = true;
                return "Hit";
            }
            else if (userInput.equalsIgnoreCase("Stay")){
                killLoop = true;
                return "Stay";
            }
        }
        return null;    }
}
