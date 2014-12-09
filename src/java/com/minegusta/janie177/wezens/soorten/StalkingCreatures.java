package com.minegusta.janie177.wezens.soorten;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.wezens.types.LivingObject;

import java.awt.*;

public class StalkingCreatures extends LivingObject
{

    public StalkingCreatures(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, int hitBoxRadius, Location origin, int damage, int health, boolean showName, String name) {
        super(imagePath, frames, distanceBetweenFrames, scale, hasCollision, hitBoxRadius, origin, damage, health, showName, name);
    }

    @Override
    public void sterfAnimatie(Graphics2D g2d) {
        
    }

    @Override
    public void actionOnCollision(Graphics2D g2d) {

    }

    public void animeer(Graphics2D g2d)
    {
        super.animeer(g2d, false);
    }
}
