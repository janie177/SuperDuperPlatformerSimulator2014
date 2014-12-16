package com.minegusta.janie177.floor;

import com.minegusta.janie177.manager.ScreenLocation;

public class Tile
{
    private static int width = 30;
    private static int height = 20;

    public static int getWidth()
    {
        return width;
    }

    public static int getHeight()
    {
        return height;
    }

    public static int getTile(int tileNumber)
    {
        return tileNumber * width;
    }

    public static int getFirstTile()
    {
        return ScreenLocation.getX1() - ScreenLocation.getX1() % width;
    }

    public static int getLastTile()
    {
        return ScreenLocation.getX2() % width + 1;
    }
}
