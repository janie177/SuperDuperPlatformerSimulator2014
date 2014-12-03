package com.minegusta.janie177;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args)
	{
		//Maak de JFrame, en zet de contentPane
		
		JFrame frame = new JFrame("PWS");
		frame.setContentPane(new GamePanel());
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.setResizable(false);
		frame.pack();
	}
}
