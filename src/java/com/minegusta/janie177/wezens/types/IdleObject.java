package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.wezens.collision.CollisionAction;

import java.awt.*;

public class IdleObject extends Object {

    public IdleObject(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, int hitBoxRadius, Location origin, int damage, boolean showName, String name, CollisionAction action, double bounceSpeed) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, hitBoxRadius, origin, damage, showName, name, action, bounceSpeed);
    }

    public void animeer(Graphics2D g2d) {
        super.animate(g2d, false);
    }

    @Override
    public void actionOnCollision(Graphics2D g2d) {

    }
}
