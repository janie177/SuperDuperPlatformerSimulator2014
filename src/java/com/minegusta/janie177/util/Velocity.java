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
            x = lessen(x);
        }
        if(y != 0)
        {
            if(Math.abs(y) < 3) y = 0;
            y = lessen(y);
        }
    }

    private int lessen(int i)
    {
        return i - i / 3;
    }
}
