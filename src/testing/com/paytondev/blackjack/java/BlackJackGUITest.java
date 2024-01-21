package com.paytondev.blackjack.java;

import com.paytondev.BlackJack.BlackJackGUI;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

 public class BlackJackGUITest {
  private  JFrame frame ;
    private JPanel panel;
    private JButton startGameButton ;


    public BlackJackGUITest(){
        initializeUI();
    }

public void initializeUI(){
        frame = new JFrame("BlackJack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        panel = new JPanel();
        frame.add(panel);

        setupComponents();

}

     private void setupComponents() {
        startGameButton = new JButton("Start Game");
        panel.add(startGameButton);
     }


 }