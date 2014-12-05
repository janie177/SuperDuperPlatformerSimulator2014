package com.minegusta.janie177.background;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.minegusta.janie177.GamePanel;

public class BackGround 
{
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
	
	public void update(Graphics2D g2d)
	{
		g2d.drawImage(backGround, 0, 0, GamePanel.width, GamePanel.height, null);
	}	
}
