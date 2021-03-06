package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.collision.Face;
import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.util.Velocity;
import com.minegusta.janie177.wezens.collision.CollisionAction;

import java.awt.*;

public class MovingObject extends Object
{
    private boolean flipped = false;
    private int speed;
    private int radius;

    public MovingObject(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, Location origin, int damage, boolean showName, String name, CollisionAction action, double bounceSpeed, int speed, int radius) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, origin, damage, showName, name, action, bounceSpeed);
        this.speed = speed;
        this.radius = radius;
    }

    public void animate(Graphics2D g2d) {
        if (Math.abs(getOrigin().getX() - getLocation().getX()) >= radius) flipped = !flipped;
        if (flipped)
        {
            setLocation(new Location(getLocation().getX() + speed, getLocation().getY()));
            setVelocity(new Velocity(speed, 0));
        } else
        {
            setLocation(new Location(getLocation().getX() - speed, getLocation().getY()));
            setVelocity(new Velocity(-speed, 0));
        }

        super.animate(g2d, flipped);
    }

    public Face getDirection()
    {
        if(flipped)return Face.RIGHT;
        else return Face.LEFT;
    }
}
