package com.minegusta.janie177;

import javax.swing.*;

public class Main {
	
	public static void main(String[] args)
	{
		//Maak de JFrame, en zet de contentPane
		
		JFrame frame = new JFrame("Super Duper Platformer Simulator 2014");
        frame.setContentPane(new GamePanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
	}
}
