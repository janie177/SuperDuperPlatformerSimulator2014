package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.util.Location;

import java.awt.*;

public class IdleCreature extends LivingObject {

    @Override
    public boolean hasCollision() {
        return false;
    }

    @Override
    public int getHitBoxRadius() {
        return 0;
    }

    @Override
    public void actionOnCollision(Graphics2D g2d) {

    }

    @Override
    public Location getOrigin() {
        return null;
    }

    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public void setLocation(Location l) {

    }

    @Override
    public void animeer(Graphics2D g2d) {

    }

    @Override
    public void setOrigin(Location l) {

    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public void setHealth(int health) {

    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void sterfAnimatie(Graphics2D g2d) {

    }
}
