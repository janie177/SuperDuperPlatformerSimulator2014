package com.minegusta.janie177;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
	{
        JFrame.setDefaultLookAndFeelDecorated(true);

		//Maak de JFrame, en zet de contentPane
		JFrame frame = new JFrame("Super Duper Platformer Simulator 2014");
        frame.setIconImage(new ImageIcon("/icon/icon2.png").getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new GamePanel());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
	}
}
