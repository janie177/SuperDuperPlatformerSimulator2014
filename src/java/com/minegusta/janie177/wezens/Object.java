package com.minegusta.janie177.wezens;

import com.minegusta.janie177.util.Location;

import java.awt.*;

public abstract class Object
{
    public abstract Location getOrigin();

    public abstract void setLocation(Location l);

    public abstract void animeer(Graphics2D g2d);

    public abstract void setOrigin(Location l);
}
