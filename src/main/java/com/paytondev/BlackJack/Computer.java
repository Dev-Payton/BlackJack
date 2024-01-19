package com.paytondev.BlackJack;

public class Computer {

   int computerChips;
   private PlayerCards computerDeck = new PlayerCards();

   public Computer(){
      computerChips = 500;
   }

   public void setComputerChips(int chipAmount){
      computerChips = chipAmount;
   }

   public void changeComputerChips(int chipAmount){
      computerChips += chipAmount;
   }

}
