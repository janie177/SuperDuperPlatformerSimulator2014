package com.minegusta.janie177.wezens;

import com.minegusta.janie177.util.Location;

import java.awt.*;

public abstract class LevendObject extends Object
{

    @Override
    public abstract Location getOrigin();

    @Override
    public abstract void setLocation(Location l);

    @Override
    public abstract void animeer(Graphics2D g2d);

    @Override
    public abstract void setOrigin(Location l);

    public abstract int getHealth();

    public abstract void setHealth(int health);

    public abstract boolean isDead();

    public abstract void sterfAnimatie(Graphics2D g2d);
}