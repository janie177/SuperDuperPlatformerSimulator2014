package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;

import java.awt.*;

public class MovingObject extends Object
{
    private boolean flipped = false;
    private int frame = 1;
    private int speed;
    private int radius;

    public MovingObject(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, int hitBoxRadius, Location origin, int damage, boolean showName, String name, int speed, int radius) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, hitBoxRadius, origin, damage, showName, name);
        this.speed = speed;
        this.radius = radius;
    }

    public void animeer(Graphics2D g2d) {
        if (Math.abs(getOrigin().getX() - getLocation().getX()) >= radius) flipped = !flipped;
        if (flipped)
        {
            setLocation(new Location(getLocation().getX() + speed, getLocation().getY()));
        } else
        {
            setLocation(new Location(getLocation().getX() - speed, getLocation().getY()));
        }

        super.animeer(g2d, flipped);
    }

    @Override
    public void actionOnCollision(Graphics2D g2d) {

    }
}
