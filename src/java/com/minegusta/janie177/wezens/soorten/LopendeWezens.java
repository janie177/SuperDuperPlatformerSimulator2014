package com.minegusta.janie177.wezens.soorten;


import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.wezens.types.MovingCreature;

public enum LopendeWezens
{
    JOOST(20, "/sprites/wezens/joost3.png", 80, 1, 1, 62, 7, true, "Joost", 1, false),
    GROTE_JOOST(20, "/sprites/wezens/joost3.png", 80, 1, 4, 62, 4, true, "Big Joost", 1, false),
    CAGE(20, "/sprites/wezens/cage.png", 80, 1, 1, 256, 6, true, "CAGE", 1, false),
    BAL_ELLENDE(10, "/sprites/speler/springlinks.png", 400, 4, 8, 32, 18, false, "Bal Der Ellende", 1, false);

    private int health;
    private String imagePath;
    private boolean lopend;
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

    private LopendeWezens(int health, String imagePath, int radius, int frames, int scale, int distanceBetweenFrames, int speed, boolean showName, String name, int damage, boolean hasColission, int hitBoxRadius)
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

    private LopendeWezens(int health, String imagePath, int radius, int frames, int scale, int distanceBetweenFrames, int speed, boolean showName, String name, int damage, boolean hasColission)
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
        return new MovingCreature(health, new Location(x,y), imagePath, radius, frames, scale, distanceBetweenFrames, speed, showName, name, damage, hasColission, hitBoxRadius);
    }
}
