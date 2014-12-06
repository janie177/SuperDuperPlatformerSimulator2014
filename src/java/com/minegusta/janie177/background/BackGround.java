package com.minegusta.janie177.background;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.minegusta.janie177.GamePanel;
import com.minegusta.janie177.speler.PlayerLocation;

public class BackGround 
{
    private static int width = GamePanel.width;
	private BufferedImage layer1;
    private BufferedImage layer2;
    private BufferedImage layer3;
    private Graphics2D g;
    private int playerLocation;
	
	public BackGround(String path, String path2, String path3)
	{
		try{
			this.layer1 = ImageIO.read(getClass().getResourceAsStream(path));
		} catch(Exception e)
		{
			e.printStackTrace();
		}
        try{
            this.layer2 = ImageIO.read(getClass().getResourceAsStream(path2));
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        try{
            this.layer3 = ImageIO.read(getClass().getResourceAsStream(path3));
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        this.playerLocation = PlayerLocation.getX();
	}
	
	public void update(Graphics2D g2d)
	{
        this.g = g2d;

        //Alle laged op volgorde van achteren naar voren.
        BufferedImage[] layers = {layer3, layer2, layer1};
        int speed = 0;

        for(BufferedImage img : layers)
        {
            double scale =  GamePanel.height / img.getHeight();
            Image scaled = img.getScaledInstance((int)(scale * img.getWidth()), (int) scale * img.getHeight(), Image.SCALE_DEFAULT);
            width = (int) scale * img.getWidth();

            int x1 = 0 - (playerLocation / (3 - speed) % width);
            int x2 = x1 + width;
            int x3 = x2 + width;
            draw(scaled, x1, width);
            draw(scaled, x2, width);
            draw(scaled, x3, width);
            speed++;
        }
    }

    private void draw(Image layer, int start, int width)
    {
        g.drawImage(layer, start, 0, width, GamePanel.height, null);
    }
}
