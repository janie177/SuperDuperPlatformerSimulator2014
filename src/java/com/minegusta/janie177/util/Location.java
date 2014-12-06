package com.minegusta.janie177.util;

import com.minegusta.janie177.GamePanel;

public class Location
{
    private int x;
    private int y;

    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Location setX(int x)
    {
        this.x = x;
        return this;
    }

    public Location setY(int y)
    {
        this.y = y;
        return this;
    }

    public int getRenderedY()
    {
        return GamePanel.height - y;
    }
}
