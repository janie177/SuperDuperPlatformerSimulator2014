package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;

import java.awt.*;
import java.lang.*;

public abstract class LivingObject extends Object
{
    @Override
    public abstract boolean hasCollision();

    @Override
    public abstract int getHitBoxRadius();

    @Override
    public abstract void actionOnCollision(Graphics2D g2d);

    @Override
    public abstract Location getOrigin();

    @Override
    public abstract Location getLocation();

    @Override
    public abstract void setLocation(Location l);

    @Override
    public abstract void animeer(Graphics2D g2d);

    @Override
    public abstract void setOrigin(Location l);

    public abstract int getHealth();

    public abstract int getDamage();

    public abstract void setHealth(int health);

    public abstract boolean isDead();

    public abstract void sterfAnimatie(Graphics2D g2d);
}