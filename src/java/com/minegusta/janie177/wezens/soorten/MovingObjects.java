package com.minegusta.janie177.wezens.soorten;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.wezens.collision.CollisionAction;
import com.minegusta.janie177.wezens.types.MovingObject;

public enum MovingObjects
{
    PLATFORM("/sprites/tiles/platform.png", 50, 1, 5, 62, 3, false, "Platform", 1, true, CollisionAction.NOTHING, 4);

    private String imagePath;
    private int radius;
    private int frames;
    private int scale;
    private int distanceBetweenFrames;
    private int speed;
    private boolean showName;
    private String name;
    private boolean hasColission;
    private int damage;
    private CollisionAction action;
    private double bounceSpeed;

    private MovingObjects(String imagePath, int radius, int frames, int scale, int distanceBetweenFrames, int speed, boolean showName, String name, int damage, boolean hasColission, CollisionAction action, double bounceSpeed)
    {
        this.imagePath = imagePath;
        this.radius = radius;
        this.frames = frames;
        this.scale = scale;
        this.distanceBetweenFrames = distanceBetweenFrames;
        this.speed = speed;
        this. showName = showName;
        this.name = name;
        this.damage = damage;
        this.hasColission = hasColission;
        this.action = action;
        this.bounceSpeed = bounceSpeed;
    }

    public MovingObject build(int x, int y)
    {
        Location origin = new Location(x, y);
        return new MovingObject(imagePath, frames, distanceBetweenFrames, scale, hasColission,origin, damage, showName, name, action, bounceSpeed, speed, radius);
    }
}
