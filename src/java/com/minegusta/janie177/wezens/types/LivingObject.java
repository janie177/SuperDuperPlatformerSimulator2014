package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;

import java.awt.*;

public abstract class LivingObject extends Object
{
    private int health;

    public LivingObject(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, int hitBoxRadius, Location origin, int damage, Location location, int health, boolean showName, String name) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, hitBoxRadius, origin, damage, location, showName, name);
        this.health = health;
    }

    public abstract void sterfAnimatie(Graphics2D g2d);

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