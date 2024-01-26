package com.paytondev.BlackJack;

public class Card {

    private int FACE;
    private int SUIT;

    private int realFaceValue;


    public Card(int setFace, int setSuit) {
        this.FACE = setFace;
        this.SUIT = setSuit;
        assignRealFaceValue();
    }

    private void assignRealFaceValue() {
        switch (FACE) {
            case 11, 12, 13:
                realFaceValue = 10;
                break;
            case 1:
                realFaceValue = 11;
                break;
            default:
                realFaceValue = FACE;
                break;
        }

    }

    public int getRealFaceValue() {
        return realFaceValue;
    }
    public int getSuit() {
        return SUIT;
    }


    public void setRealFace(int setValue) {
        this.FACE = setValue;
    }

    @Override
    public String toString() {
        for (Suit s : Suit.values()) {
            for (Face f : Face.values()) {
                if (s.suitNumber == SUIT && f.faceNumber == FACE) {
                    return f.name() + " of " + s.name();
                }
            }
        }
        return null;
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
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);


        final int faceNumber;

        Face(int setFaceNumber) {
            this.faceNumber = setFaceNumber;
        }

    }





}
