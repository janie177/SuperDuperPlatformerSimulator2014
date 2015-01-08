package com.minegusta.janie177.wezens.soorten;


import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.wezens.collision.CollisionAction;
import com.minegusta.janie177.wezens.types.MovingCreature;

public enum MovingCreatures
{
    KITTEH(10, "/sprites/wezens/Flyingkittenofdeath.png", 50, 1, 1, 400, 4, true, "Kitteh", 1, false, CollisionAction.NOTHING, 4),
    JOOST(10, "/sprites/wezens/joost3.png", 50, 1, 5, 62, 3, true, "Jooooost", 1, false, CollisionAction.NOTHING, 4);
    private int health;
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


    private MovingCreatures(int health, String imagePath, int radius, int frames, int scale, int distanceBetweenFrames, int speed, boolean showName, String name, int damage, boolean hasColission, CollisionAction action, double bounceSpeed)
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
        this.hasColission = hasColission;
        this.action = action;
        this.bounceSpeed = bounceSpeed;
    }

    public MovingCreature build(int x, int y)
    {
        Location origin = new Location(x, y);
        return new MovingCreature(imagePath, frames, distanceBetweenFrames, scale, hasColission, origin, damage, health, showName, name, speed, radius, action, bounceSpeed);
    }
}
