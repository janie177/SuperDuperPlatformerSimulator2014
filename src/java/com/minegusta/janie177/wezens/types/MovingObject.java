package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;

import java.awt.*;

public class MovingObject extends Object
{
    public MovingObject(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, int hitBoxRadius, Location origin, int damage, boolean showName, String name) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, hitBoxRadius, origin, damage, showName, name);
    }

    @Override
    public void animeer(Graphics2D g2d) {

    }

    @Override
    public void actionOnCollision(Graphics2D g2d) {

    }
}
