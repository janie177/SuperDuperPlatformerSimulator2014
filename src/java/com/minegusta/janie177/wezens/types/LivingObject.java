package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.util.Velocity;
import com.minegusta.janie177.wezens.collision.CollisionAction;

import java.awt.*;

public abstract class LivingObject extends Object
{
    private int health;


    public LivingObject(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, Location origin, int damage, boolean showName, String name, CollisionAction action, double bounceSpeed, int health) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, origin, damage, showName, name, action, bounceSpeed);
        this.health = health;
    }

    public void animate(Graphics2D g2d, boolean flip)
    {
        updateLocation();
        super.animate(g2d, flip);
    }

    public void updateLocation()
    {
        getLocation().setX(getLocation().getX() + getVelocity().getX()).setY(getLocation().getY() + getVelocity().getY());
        getVelocity().update();
    }

    public void deathAnimation(Graphics2D g2d)
    {
        //Maak hier de animatie als een entity dood gaat.
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public boolean isDead()
    {
        return health <= 0;
    }
}