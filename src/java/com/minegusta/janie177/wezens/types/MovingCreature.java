package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;

import java.awt.*;

public class MovingCreature extends LivingObject
{

    private boolean forward = false;
    private int radius;
    private int speed;

    public MovingCreature(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, int hitBoxRadius, Location origin, int damage, int health, boolean showName, String name, int speed, int radius) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, hitBoxRadius, origin, damage, health, showName, name);
        this.speed = speed;
        this. radius = radius;
    }


    @Override
    public void sterfAnimatie(Graphics2D g2d) {

        //Sterf hier
    }

    @Override
    public void actionOnCollision(Graphics2D g2d) {
        //Doe hier iets bij het botsen
    }

    public void animeer(Graphics2D g2d)
    {
        if (Math.abs(getOrigin().getX() - getLocation().getX()) >= radius) forward = !forward;
        if (forward)
        {
            setLocation(new Location(getLocation().getX() + speed, getLocation().getY()));
        } else
        {
            setLocation(new Location(getLocation().getX() - speed, getLocation().getY()));
        }

        super.animeer(g2d, forward);
    }
}
