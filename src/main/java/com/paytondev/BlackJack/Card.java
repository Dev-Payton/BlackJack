package com.paytondev.BlackJack;

public class Card {

    private int FACE;
    private  int SUIT;

    public Card() {
        FACE = (int) (Math.random() * 13 + 1);
        SUIT = (int) (Math.random() * 4 + 1);

    }

    public Card(int setFace, int setSuit) {
        this.FACE = setFace;
        this.SUIT = setSuit;
    }


    private enum Suit {

        HEARTS(1),
        DIAMONDS(2),
        CLUBS(3),
        SPADES(4);


        final int suitNumber;

        Suit(int setSuitNumber) {
            this.suitNumber = setSuitNumber;
        }


    }

    private enum Face {
        ACE(11),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10);


        final int faceNumber;

        Face(int setFaceNumber) {
            this.faceNumber = setFaceNumber;
        }

    }


    public int getFACE() {
        return FACE;
    }


    public void setFace(int setValue){
        this.FACE = setValue;
    }


    public int getSuit() {
        return SUIT;
    }

    public String getFaceString() {
        return "" + FACE;
    }

    public String getSuitString() {
        return "" + SUIT;
    }

    public void displayCard(){
        for(Suit s : Suit.values()){
            for (Face f : Face.values()){
                if (s.suitNumber == SUIT && f.faceNumber == FACE){
                    System.out.println(f.name() + " of " + s.name());
                }
            }
        }
    }

}
