package com.minegusta.janie177.background;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.minegusta.janie177.GamePanel;

public class BackGround 
{
	
	//Call this class when making a new screen. the BG should always stay the same
	//since it's a gif.
	
	private BufferedImage backGround;
	
	public BackGround(String path)
	{
		try{
			this.backGround = ImageIO.read(getClass().getResourceAsStream(path));
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void create(Graphics2D g2d)
	{
		g2d.setColor(Color.RED);
		g2d.drawString(Integer.toString(GamePanel.WIDTH), 50, 50);
		g2d.drawString(Integer.toString(GamePanel.HEIGHT), 80, 50);
		g2d.drawImage(backGround, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
	}	
}
