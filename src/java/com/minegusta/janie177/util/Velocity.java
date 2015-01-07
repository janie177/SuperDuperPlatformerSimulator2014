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
        x = lessenX();
        y = lessenY();
    }

    private int lessenX()
    {
        if(Math.abs(x) < 3)return 0;
        return x - x/3;
    }

    private int lessenY()
    {
        if(y > 0)
        {
            return y - 1;
        }
        else if(y < 0)
        {
            return y + 1;
        }
        return 0;
    }
}
