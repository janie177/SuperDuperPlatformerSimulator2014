package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;

import java.awt.*;

public class Projectile extends Object
{

    @Override
    public boolean hasCollision() {
        return false;
    }

    @Override
    public int getHitBoxRadius() {
        return 0;
    }

    @Override
    public Location getOrigin() {
        return null;
    }

    @Override
    public void actionOnCollision(Graphics2D g2d) {

    }

    @Override
    public void setLocation(Location l) {

    }

    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public void animeer(Graphics2D g2d) {

    }

    @Override
    public void setOrigin(Location l) {

    }
}
