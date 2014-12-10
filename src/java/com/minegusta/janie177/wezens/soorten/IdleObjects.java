package com.minegusta.janie177.wezens.soorten;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.wezens.collision.CollisionAction;
import com.minegusta.janie177.wezens.types.IdleObject;

public enum IdleObjects
{
    BLOK("/sprites/tiles/Block.png", 2, 2, 10, false, "Block", 4, true, CollisionAction.DAMAGE, 0);

    private String imagePath;
    private int frames;
    private int scale;
    private int distanceBetweenFrames;
    private boolean showName;
    private String name;
    private int hitBoxRadius;
    private boolean hasColission;
    private int damage;
    private CollisionAction action;
    private double bounceSpeed;

    private IdleObjects(String imagePath, int frames, int scale, int distanceBetweenFrames, boolean showName, String name, int damage, boolean hasColission, int hitBoxRadius, CollisionAction action, double bounceSpeed)
    {
        this.imagePath = imagePath;
        this.frames = frames;
        this.scale = scale;
        this.distanceBetweenFrames = distanceBetweenFrames;
        this. showName = showName;
        this.name = name;
        this.damage = damage;
        this.hitBoxRadius = hitBoxRadius;
        this.hasColission = hasColission;
        this.action = action;
        this.bounceSpeed = bounceSpeed;

    }

    private IdleObjects(String imagePath, int frames, int scale, int distanceBetweenFrames, boolean showName, String name, int damage, boolean hasColission, CollisionAction action, double bounceSpeed)
    {
        this.imagePath = imagePath;
        this.frames = frames;
        this.scale = scale;
        this.distanceBetweenFrames = distanceBetweenFrames;
        this. showName = showName;
        this.name = name;
        this.damage = damage;
        this.hitBoxRadius = (distanceBetweenFrames / 2) * scale;
        this.hasColission = hasColission;
        this.action = action;
        this.bounceSpeed = bounceSpeed;
    }

    public IdleObject build(int x, int y)
    {
        Location origin = new Location(x, y);
        return new IdleObject(imagePath, frames, distanceBetweenFrames, scale, hasColission, hitBoxRadius, origin, damage, showName, name, action, bounceSpeed);
    }
}
