package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.wezens.collision.CollisionAction;

import java.awt.*;

public class MovingCreature extends LivingObject
{

    private boolean forward = false;
    private int radius;
    private int speed;

    public MovingCreature(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, int hitBoxRadius, Location origin, int damage, int health, boolean showName, String name, int speed, int radius, CollisionAction action, double bounceSpeed) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, hitBoxRadius, origin, damage, showName, name, action, bounceSpeed, health);
        this.speed = speed;
        this. radius = radius;
    }

    public void animate(Graphics2D g2d)
    {
        if (Math.abs(getOrigin().getX() - getLocation().getX()) >= radius) forward = !forward;
        if (forward)
        {
            setLocation(new Location(getLocation().getX() + speed, getLocation().getY()));
        } else
        {
            setLocation(new Location(getLocation().getX() - speed, getLocation().getY()));
        }

        super.animate(g2d, forward);
    }
}
