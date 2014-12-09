package com.minegusta.janie177.util;

public class Vector
{
    private double speed;
    private double a;

    public Vector(double x, double y, double speed)
    {
        this.a = y/x;
        this.speed = speed;
    }

    public Vector(double a, double speed)
    {
        this.a = a;
        this.speed = speed;
    }

    public Vector(Location origin, Location goal, double speed)
    {
        this.a = ((goal.getRenderedY() - origin.getY()) / (goal.getX() - origin.getX()));
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
        return l.setY((int) getDirection() * (int) speed).setX((int) speed);
    }
}
