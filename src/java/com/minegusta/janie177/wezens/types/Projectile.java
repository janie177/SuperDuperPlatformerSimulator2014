package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.util.Vector;

import java.awt.*;

public class Projectile extends Object
{
    private Vector direction;

    public Projectile(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, int hitBoxRadius, Location origin, int damage, boolean showName, String name, Vector direction) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, hitBoxRadius, origin, damage, showName, name);
        this.direction = direction;
    }

    public void animeer(Graphics2D g2d)
    {
        getLocation().setX(1).setY(1);
        super.animeer(g2d, false);
    }

    @Override
    public void actionOnCollision(Graphics2D g2d) {

    }
}
