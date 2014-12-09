package com.minegusta.janie177.util;

public class Vector
{
    private double speed;
    private double a;

    public Vector(double x, double y, double speed)
    {
        if(x == 0)
        {
            a = y;
        }
        if(y == 0)
        {
            a = x;
        }
        else this.a = y/x;
        this.speed = speed;
    }

    public Vector(double a, double speed)
    {
        this.a = a;
        this.speed = speed;
    }

    public Vector(Location origin, Location goal, double speed)
    {
        int x = goal.getX() - origin.getX();
        int y = goal.getY() - origin.getX();

        if(x == 0)
        {
            a = y;
        }
        if(y == 0)
        {
            a = x;
        }
        else this.a = (x / y);
        this.speed = speed;
    }

    public double getDirection()
    {
        return a;
    }

    public double getSpeed()
    {
        return speed;
    }

    public Location move(Location l)
    {
        return l.setY(l.getY() + (int) getDirection() * (int) speed).setX(l.getX() + (int) speed);
    }
}
