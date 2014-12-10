package com.minegusta.janie177.util;

public class Velocity
{
    private int x;
    private int y;

    public Velocity(int x, int y)
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

    public void set(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void add(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

    public void update()
    {
        if(x != 0)
        {
            if(Math.abs(x) < 3)x = 0;
            else x = lessenX(x);
        }
        if(y != 0)
        {
            if(Math.abs(y) < 2) y = 0;
            else y = lessenY(y);
        }
    }

    private int lessenX(int i)
    {
        return i - i/3;
    }

    private int lessenY(int i)
    {
        if (i > 0)return i - 1;
        return i + 1;
    }
}
