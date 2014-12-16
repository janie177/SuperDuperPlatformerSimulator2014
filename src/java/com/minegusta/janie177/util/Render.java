package com.minegusta.janie177.util;

import com.minegusta.janie177.manager.ScreenLocation;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Render
{
    //Door altijd overal 400 aan toe te voegen zal de speler altijd in het midden van het scherm staan. Alles lijkt dus 400 pixels verder te zijn dan het werkelijk is.
    //Als alle objecten dus via deze class gaan zal dit niets uitmaken. Als objecten via een andere class worden toegevoegt zullen ze op een andere locatie lijken ze zijn.
    private static int added = 400;

    /**
     * Render een object in de wereld.
     * @param g2d Het Graphics2D scherm waarop het gerenderd wordt.
     * @param img Het plaatje om te renderen.
     * @param x De x coordinaat.
     * @param y De y coordinaat.
     * @param scale De schaal waarmee het plaatje wordt vergroot
     */
    public static void renderInWorld(Graphics2D g2d, BufferedImage img, int x, int y, int scale)
    {
        int xCentered = (x - ScreenLocation.getCenter()) + added - (img.getWidth()*scale / 2);
        int yCentered = y - (img.getHeight()*scale / 2);
        g2d.drawImage(img, xCentered, yCentered, img.getWidth() * scale, img.getHeight() * scale, null);
    }


    /**
     * Render an object in de wereld.
     * @param g2d Het scherm waar je op tekent.
     * @param img De image.
     * @param x De x coordinaat.
     * @param y De y ciirdinaat.
     * @param width De hoogte.
     * @param height De breedte.
     */
    public static void renderInWorld(Graphics2D g2d, BufferedImage img, int x, int y, int width, int height)
    {
        int xCentered = (x - ScreenLocation.getCenter()) + added - (width / 2);
        int yCentered = y - (height / 2);
        g2d.drawImage(img, xCentered, yCentered, width, height, null);
    }

    /**
     * Render een object in de wereld.
     * @param g2d Het Graphics2D scherm waarop het gerenderd wordt.
     * @param img Het plaatje om te renderen.
     * @param x De x coordinaat.
     * @param y De y coordinaat.
     * @param scale De schaal waarmee het plaatje wordt vergroot
     * @param name De naam van het object.
     * @param showName Of de naam weergeven moet worden.
     */
    public static void renderInWorld(Graphics2D g2d, BufferedImage img, int x, int y, int scale, boolean showName, String name)
    {
        int xCentered = (x - ScreenLocation.getCenter()) + added - (img.getWidth()*scale / 2);
        int yCentered = y - (img.getHeight()*scale / 2);
        g2d.drawImage(img, xCentered, yCentered, img.getWidth() * scale, img.getHeight() * scale, null);
        if(showName)
        {
            g2d.setColor(Color.YELLOW);
            g2d.setFont(new Font("Arial", Font.BOLD, 34));
            g2d.drawString(name, xCentered, yCentered - img.getWidth() * scale / 2);
        }
    }

    /**
     * Render een object in de wereld.
     * @param g2d Het Graphics2D scherm waarop het gerenderd wordt.
     * @param img Het plaatje om te renderen.
     * @param x De x coordinaat.
     * @param y De y coordinaat.
     * @param scale De schaal waarmee het plaatje wordt vergroot
     * @param flip Of het plaatje achterstevoren gerenderd moet worden.
     * @param name De naam van het object.
     * @param showName Of de naam weergeven moet worden.
     */
    public static void renderInWorld(Graphics2D g2d, BufferedImage img, int x, int y, int scale, boolean flip, String name, boolean showName)
    {
        int xCentered = (x - ScreenLocation.getCenter()) + added - (img.getWidth()*scale / 2);
        int yCentered = y - (img.getHeight()*scale / 2);

        int width = img.getWidth() * scale;

        if(showName)
        {
            g2d.setColor(Color.YELLOW);
            g2d.setFont(new Font("Arial", Font.BOLD, 34));
            g2d.drawString(name, xCentered, yCentered - img.getWidth() * scale / 2);
        }

        if(flip)
        {
            xCentered = (x - ScreenLocation.getCenter()) + added + (img.getWidth()*scale / 2);
            yCentered = y - (img.getHeight()*scale / 2);
            width = -width;
        }
        g2d.drawImage(img, xCentered, yCentered, width, img.getHeight() * scale, null);
    }

    public static int getAdded()
    {
        return added;
    }
}
