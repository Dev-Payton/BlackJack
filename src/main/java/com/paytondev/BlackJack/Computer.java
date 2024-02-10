package com.paytondev.BlackJack;

public class Computer extends Player {


   String computerName;

   int computerChips;

   public Computer(String name){
      this.computerName = name;
      computerChips = 500;
   }

   public void setComputerChips(int chipAmount){
      computerChips = chipAmount;
   }

   public void changeComputerChips(int chipAmount){
      computerChips += chipAmount;
   }
   @Override
   public void receiveCard(Card card) {
      playerHand.receiveCard(card);
   }

   @Override
   public void playTurn() {
      if (playerHand.checkHand() <= 17){
         int random =(int) (Math.random() * 100 + 1);
         if (random <= 25 ){
            // Implement a method that tells the dealer to give us another card, we will then recheck this cards face value within
            // the GameEngine's methods.
         }
      }
   }



   @Override
   public String getName() {
   return computerName;
   }


}
