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
   public String getName() {
   return computerName;
   }


}
