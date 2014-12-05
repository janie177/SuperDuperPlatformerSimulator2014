package com.minegusta.janie177.background;

import java.awt.Graphics2D;
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

        int x1 = 0 - ((playerLocation / 3) % width);
        int x2 = x1 + width;
        int x3 = x2 + width;

        //Langzame achtergrond laag
        draw(layer3, x1);
        draw(layer3, x2);
        draw(layer3, x3);

        x1 = 0 - ((playerLocation / 2) % width);
        x2 = x1 + width;
        x3 = x2 + width;

        //Middelste langzamere laag.
        draw(layer2, x1);
        draw(layer2, x2);
        draw(layer2, x3);

        x1 = 0 - (playerLocation % width);
        x2 = x1 + width;
        x3 = x2 + width;

        //Snelle voorste laag
        draw(layer1, x1);
        draw(layer1, x2);
        draw(layer1, x3);
    }

    private void draw(BufferedImage layer, int x)
    {
        g.drawImage(layer, x, 0, GamePanel.width, GamePanel.height, null);
    }
}
