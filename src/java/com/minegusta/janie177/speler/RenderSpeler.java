package com.minegusta.janie177.speler;

import com.minegusta.janie177.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RenderSpeler
{
    private Graphics2D g2d;
    private static int x = 0;
    private static int y = 0;
    private BufferedImage speler;

    public void render(Graphics2D g2d)
    {
        this.g2d = g2d;
        boolean jump = PlayerLocation.getY() > y;

        if(PlayerLocation.getX() > x)
        {
            if(jump)springRechts();
            else rechts();
        }
        else if(PlayerLocation.getX() < x)
        {
            if(jump)springLinks();
            else links();
        }
        else if(jump)
        {
            springRechts();
        }
        else
        {
            //Stilstaan
            stil();
        }

        draw();

        //update x en y
        x = PlayerLocation.getX();
        y = PlayerLocation.getY();
    }

    //De verschillende animaties

    private void springLinks()
    {
        try {
            speler = ImageIO.read(getClass().getResourceAsStream("/speler/springlinks.png"));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void springRechts()
    {
        try {
            speler = ImageIO.read(getClass().getResourceAsStream("/speler/springrechts.png"));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void links()
    {
        try {
            speler = ImageIO.read(getClass().getResourceAsStream("/speler/links.png"));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void rechts()
    {
        try {
            speler = ImageIO.read(getClass().getResourceAsStream("/speler/rechts.png"));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void stil()
    {
        try {
            speler = ImageIO.read(getClass().getResourceAsStream("/speler/rechts.png"));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void draw()
    {
        g2d.drawImage(speler, GamePanel.width / 2, GamePanel.height - PlayerLocation.getY() + 50, null);
    }
}
