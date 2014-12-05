package com.minegusta.janie177.speler;

import com.minegusta.janie177.GamePanel;

public class PlayerLocation
{
    public PlayerLocation()
    {
        if(links)
        {
            moveLeft();
        }
        if(rechts)
        {
            moveRight();
        }
        if(jumping)
        {
            moveUp();
        }
        if(down)
        {
            moveDown();
        }
    }
    private static int gameHeight = GamePanel.height;

    private static int locY = gameHeight - 150;
    //X locatie, minimaal 3 zodat de achtergrond het blijft doen.
    private static int locX = 15;


    //-- Bewegen --//
    private static boolean links = false;
    private static boolean rechts = false;
    private static boolean jumping = false;
    private static boolean down = false;

    private static void moveUp()
    {
        locY = locY - 6;
    }

    private static void moveDown()
    {
        locY = locY + 6;
        if(locY > gameHeight - 150)locY = gameHeight - 150;
    }
    private static void moveLeft()
    {
        locX = locX - 6;
        if(locX < 15)locX = 15;
    }
    private static void moveRight()
    {
        locX = locX + 6;
    }



    //-- Het krijgen van de locatie --//
    public static int getX()
    {
        return locX;
    }

    public static int getY()
    {
        return locY;
    }

    public static void setLinks(boolean b)
    {
        links = b;
    }

    public static void setRechts(boolean b)
    {
        rechts = b;
    }

    public static void setUp(boolean b)
    {
        jumping = b;
    }

    public static void setDown(boolean b)
    {
        down = b;
    }
}
