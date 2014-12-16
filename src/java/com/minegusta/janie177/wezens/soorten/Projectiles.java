package com.minegusta.janie177.wezens.soorten;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.util.Vector;
import com.minegusta.janie177.wezens.collision.CollisionAction;
import com.minegusta.janie177.wezens.types.Projectile;

public enum Projectiles
{
    KOGEL("/sprites/objecten/kogel.png", 2, 2, 10, false, "Kogel", 4, false, CollisionAction.DAMAGE, 0);

    private String imagePath;
    private int frames;
    private int scale;
    private int distanceBetweenFrames;
    private boolean showName;
    private String name;
    private boolean hasColission;
    private int damage;
    private CollisionAction action;
    private double bounceSpeed;

    private Projectiles(String imagePath, int frames, int scale, int distanceBetweenFrames, boolean showName, String name, int damage, boolean hasColission, CollisionAction action, double bounceSpeed)
    {
        this.imagePath = imagePath;
        this.frames = frames;
        this.scale = scale;
        this.distanceBetweenFrames = distanceBetweenFrames;
        this. showName = showName;
        this.name = name;
        this.damage = damage;
        this.hasColission = hasColission;
        this.action = action;
        this.bounceSpeed = bounceSpeed;
    }

    public Projectile build(int x, int y, Vector v)
    {
        Location origin = new Location(x, y);
        return new Projectile(imagePath, frames, distanceBetweenFrames, scale, hasColission, origin, damage, showName, name, action, bounceSpeed, v);
    }
}
