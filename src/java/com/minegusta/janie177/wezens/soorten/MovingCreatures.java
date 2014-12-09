package com.minegusta.janie177.wezens.soorten;


import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.wezens.types.MovingCreature;

public enum MovingCreatures
{
    JOOST(10, "/sprites/wezens/joost3.png", 50, 1, 5, 62, 3, true, "NoobDutch", 1, true);

    private int health;
    private String imagePath;
    private int radius;
    private int frames;
    private int scale;
    private int distanceBetweenFrames;
    private int speed;
    private boolean showName;
    private String name;
    private int hitBoxRadius;
    private boolean hasColission;
    private int damage;

    private MovingCreatures(int health, String imagePath, int radius, int frames, int scale, int distanceBetweenFrames, int speed, boolean showName, String name, int damage, boolean hasColission, int hitBoxRadius)
    {
        this.health = health;
        this.imagePath = imagePath;
        this.radius = radius;
        this.frames = frames;
        this.scale = scale;
        this.distanceBetweenFrames = distanceBetweenFrames;
        this.speed = speed;
        this. showName = showName;
        this.name = name;
        this.damage = damage;
        this.hitBoxRadius = hitBoxRadius;
        this.hasColission = hasColission;

    }

    private MovingCreatures(int health, String imagePath, int radius, int frames, int scale, int distanceBetweenFrames, int speed, boolean showName, String name, int damage, boolean hasColission)
    {
        this.health = health;
        this.imagePath = imagePath;
        this.radius = radius;
        this.frames = frames;
        this.scale = scale;
        this.distanceBetweenFrames = distanceBetweenFrames;
        this.speed = speed;
        this. showName = showName;
        this.name = name;
        this.damage = damage;
        this.hitBoxRadius = (distanceBetweenFrames / 2) * scale;
        this.hasColission = hasColission;
    }

    public MovingCreature build(int x, int y)
    {
        Location origin = new Location(x, y);
        return new MovingCreature(imagePath, frames, distanceBetweenFrames, scale, hasColission, hitBoxRadius, origin, damage, health, showName, name, speed, radius);
    }
}
