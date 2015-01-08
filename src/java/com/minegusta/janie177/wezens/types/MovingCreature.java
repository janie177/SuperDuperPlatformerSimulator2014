package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.util.Velocity;
import com.minegusta.janie177.wezens.collision.CollisionAction;

import java.awt.*;

public class MovingCreature extends LivingObject
{

    private boolean forward = false;
    private int radius;
    private int speed;

    public MovingCreature(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, Location origin, int damage, int health, boolean showName, String name, int speed, int radius, CollisionAction action, double bounceSpeed) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, origin, damage, showName, name, action, bounceSpeed, health);
        this.speed = speed;
        this. radius = radius;
    }

    public void animate(Graphics2D g2d)
    {
        if (Math.abs(getOrigin().getX() - getLocation().getX()) >= radius) forward = !forward;
        if (forward)
        {
            setLocation(new Location(getLocation().getX() + speed, getLocation().getY()));
            setVelocity(new Velocity(speed, 0));
        } else
        {
            setLocation(new Location(getLocation().getX() - speed, getLocation().getY()));
            setVelocity(new Velocity(-speed, 0));
        }

        super.animate(g2d, forward);
    }
}
