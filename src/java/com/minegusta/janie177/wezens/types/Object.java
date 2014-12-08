package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;

import java.awt.*;

public abstract class Object
{
    public abstract boolean hasCollision();

    public abstract int getHitBoxRadius();

    public abstract Location getOrigin();

    public abstract void actionOnCollision(Graphics2D g2d);

    public abstract void setLocation(Location l);

    public abstract Location getLocation();

    public abstract void animeer(Graphics2D g2d);

    public abstract void setOrigin(Location l);
}
