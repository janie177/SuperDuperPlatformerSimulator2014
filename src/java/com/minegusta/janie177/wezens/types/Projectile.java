package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.GamePanel;
import com.minegusta.janie177.data.Storage;
import com.minegusta.janie177.speler.PlayerStatus;
import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.util.Vector;
import com.minegusta.janie177.wezens.collision.CollisionAction;

import java.awt.*;

public class Projectile extends Object
{
    private Vector direction;

    public Projectile(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, Location origin, int damage, boolean showName, String name, CollisionAction action, double bounceSpeed, Vector direction) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, origin, damage, showName, name, action, bounceSpeed);
        this.direction = direction;
    }

    public void animate(Graphics2D g2d)
    {
        setLocation(direction.move(getLocation()));
        if(Math.abs(getLocation().getX() - PlayerStatus.getX()) > GamePanel.width)
        {
            if(Storage.getObjects().contains(this))Storage.getObjects().remove(this);
            if(Storage.getLoadedObjects().contains(this))Storage.getLoadedObjects().remove(this);
        }
        super.animate(g2d, false);
    }
}
