package com.minegusta.janie177.background;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.minegusta.janie177.GamePanel;

public class BackGround 
{
    private static int width = GamePanel.width - 12;
	private BufferedImage layer1;
    private BufferedImage layer2;
    private BufferedImage layer3;
    private Graphics2D g;
    private int playerLocation;
	
	public BackGround(String path, String path2, String path3, int x)
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
        this.playerLocation = x;
	}
	
	public void update(Graphics2D g2d)
	{
        this.g = g2d;
        double x1 = 0 - (width % playerLocation);
        double x2 = x1 + width;
        double x3 = x2 + width;

        BufferedImage[] layers = {layer1, layer2, layer3};

        for(BufferedImage img : layers)
        {
            draw(img, (int) x1);
            draw(img, (int) x2);
            draw(img, (int) x3);
        }
    }

    private void draw(BufferedImage layer, int x)
    {
        g.drawImage(layer, x, 0, GamePanel.width, GamePanel.height, null);
    }
}
