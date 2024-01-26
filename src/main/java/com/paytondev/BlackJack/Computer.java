package com.paytondev.BlackJack;

public class Computer extends Player {

   int computerChips;

   public Computer(){
      computerChips = 500;
   }

   public void setComputerChips(int chipAmount){
      computerChips = chipAmount;
   }

   public void changeComputerChips(int chipAmount){
      computerChips += chipAmount;
   }
   @Override
   public void recieveCard(Card card) {
      playerHand.receiveCard(card);
   }


}
