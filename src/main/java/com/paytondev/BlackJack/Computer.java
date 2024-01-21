package com.paytondev.BlackJack;

public class Computer {

   int computerChips;
\
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
