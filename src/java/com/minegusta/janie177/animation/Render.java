package com.minegusta.janie177.animation;

import com.minegusta.janie177.manager.ScreenLocation;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Render
{
    private static int added = 400;
    public static void renderInWorld(Graphics2D g2d, BufferedImage img, int x, int y, int scale)
    {
        int xCentered = (x - ScreenLocation.getCenter()) + added - (img.getWidth()*scale / 2);
        int yCentered = y - (img.getHeight()*scale / 2);
        g2d.drawImage(img, xCentered, yCentered, img.getWidth() * scale, img.getHeight() * scale, null);

        g2d.setColor(Color.magenta);
        g2d.drawRect(x - ScreenLocation.getCenter() + added, y, 2, 2);
        g2d.setColor(Color.RED);
        g2d.drawRect(xCentered, yCentered, 2, 2);
    }

    public static void renderInWorld(Graphics2D g2d, BufferedImage img, int x, int y, int scale, boolean flip)
    {
        int xCentered = (x - ScreenLocation.getCenter()) + added - (img.getWidth()*scale / 2);
        int yCentered = y - (img.getHeight()*scale / 2);

        int width = img.getWidth() * scale;

        if(flip)
        {
            xCentered = (x - ScreenLocation.getCenter()) + added + (img.getWidth()*scale / 2);
            yCentered = y - (img.getHeight()*scale / 2);
            width = -width;
        }
        g2d.drawImage(img, xCentered, yCentered, width, img.getHeight() * scale, null);

        g2d.setColor(Color.MAGENTA);
        g2d.drawRect(x - ScreenLocation.getCenter() + added, y, 2, 2);
        g2d.setColor(Color.RED);
        g2d.drawRect(xCentered, yCentered, 2, 2);
    }
}
