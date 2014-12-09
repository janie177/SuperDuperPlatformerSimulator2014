package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.util.Vector;
import com.minegusta.janie177.wezens.collision.CollisionAction;

import java.awt.*;

public class StalkingCreature extends LivingObject
{
    private Object target;
    private double speed;

    public StalkingCreature(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, int hitBoxRadius, Location origin, int damage, int health, boolean showName, String name, int speed, CollisionAction action, double bounceSpeed, Object target) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, hitBoxRadius, origin, damage, showName, name, action, bounceSpeed, health);
        this.speed = speed;
        this.target = target;
    }

    public void animeer(Graphics2D g2d) {
        Vector direction = new Vector(getLocation(), target.getLocation(), speed);
        setLocation(direction.move(getLocation()));

        boolean backwards = target.getLocation().getX() < getLocation().getX();

        super.animate(g2d, backwards);
    }
}
