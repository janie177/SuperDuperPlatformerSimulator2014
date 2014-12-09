package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;

import java.awt.*;

public class IdleCreature extends LivingObject {
    public IdleCreature(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, int hitBoxRadius, Location origin, int damage, Location location, int health, boolean showName, String name) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, hitBoxRadius, origin, damage, location, health, showName, name);
    }

    @Override
    public void sterfAnimatie(Graphics2D g2d) {

    }

    @Override
    public void animeer(Graphics2D g2d) {

    }

    @Override
    public void actionOnCollision(Graphics2D g2d) {

    }
}
