package com.minegusta.janie177;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main
{
    public static void main(String[] args)
	{
        JFrame.setDefaultLookAndFeelDecorated(true);

		//Maak de JFrame, en zet de contentPane
		JFrame frame = new JFrame("Super Duper Platformer Simulator 2014");

        //Het icoontje

        Image icon = null;
        try{
            icon = ImageIO.read(Main.class.getResourceAsStream("/sprites/icon/icon2.png"));
        } catch (Exception e){e.printStackTrace();}

        if(icon != null) frame.setIconImage(icon);

        //De rest van het bouwen van het frame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new GamePanel());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
	}
}
