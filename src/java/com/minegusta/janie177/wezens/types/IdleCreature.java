package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.wezens.collision.CollisionAction;

import java.awt.*;

public class IdleCreature extends LivingObject {

    public IdleCreature(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, Location origin, int damage, int health, boolean showName, String name, CollisionAction action, double bounceSpeed) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, origin, damage, showName, name, action, bounceSpeed, health);
    }

    public void animate(Graphics2D g2d) {
        super.animate(g2d, false);
    }
}
