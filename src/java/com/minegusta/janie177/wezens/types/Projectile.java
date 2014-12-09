package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.util.Vector;
import com.minegusta.janie177.wezens.collision.CollisionAction;

import java.awt.*;

public class Projectile extends Object
{
    private Vector direction;

    public Projectile(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, int hitBoxRadius, Location origin, int damage, boolean showName, String name, CollisionAction action, double bounceSpeed, Vector direction) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, hitBoxRadius, origin, damage, showName, name, action, bounceSpeed);
        this.direction = direction;
    }

    public void animeer(Graphics2D g2d)
    {
        setLocation(direction.move(getLocation()));
        super.animate(g2d, false);
    }
}
