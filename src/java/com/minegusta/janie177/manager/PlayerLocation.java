package com.minegusta.janie177.manager;

public class PlayerLocation
{
    private static int locY = 0;
    //X locatie, minimaal 3 zodat de achtergrond het blijft doen.
    private static int locX = 15;

    public static void moveUp()
    {
        locY = locY + 3;
    }

    public static void moveDown()
    {
        locY = locY - 3;
        if(locY < 0)locY = 0;
    }
    public static void moveLeft()
    {
        locX = locX - 3;
        if(locX < 15)locX = 15;
    }
    public static void moveRight()
    {
        locX = locX + 3;
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
}
