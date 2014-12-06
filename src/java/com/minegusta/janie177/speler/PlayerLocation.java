package com.minegusta.janie177.speler;

import com.minegusta.janie177.GamePanel;
import com.minegusta.janie177.util.Location;

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

    private static Location location = new Location(15, 30);


    //-- Bewegen --//
    private static boolean links = false;
    private static boolean rechts = false;
    private static boolean jumping = false;
    private static boolean down = false;
    private static boolean sprint = false;
    private static int speed = 9;

    private static void moveUp()
    {
        location.setY(location.getY() + speed);
    }

    private static void moveDown()
    {
        location.setY(location.getY() - speed);
        if(location.getY() < 0) location.setY(0);
    }
    private static void moveLeft()
    {
        location.setX(location.getX() - speed);
        if(location.getX() < 15) location.setX(15);
    }
    private static void moveRight()
    {
        location.setX(location.getX() + speed);
    }

    //-- Het krijgen van de locatie --//
    public static int getX(){ return location.getX(); }

    public static int getY()
    {
        return location.getY();
    }

    public static Location getLocation()
    {
        return location;
    }

    public static int getRenderedY()
    {
        return location.getRenderedY();
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
