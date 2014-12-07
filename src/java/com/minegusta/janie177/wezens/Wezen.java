package com.minegusta.janie177.wezens;


import com.minegusta.janie177.util.Location;

public enum Wezen
{
    JOOST(20, "/sprites/wezens/joost3.png", true, 80, 1, 1, 62, 7, true, "Joost"),
    GROTE_JOOST(20, "/sprites/wezens/joost3.png", true, 80, 1, 4, 62, 4, true, "Big Joost"),
    BAL_ELLENDE(10, "/sprites/speler/springlinks.png", true, 400, 4, 8, 32, 18, false, "Bal Der Ellende");

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

    private Wezen(int health, String imagePath, boolean lopend, int radius, int frames, int scale, int distanceBetweenFrames, int speed, boolean showName, String name)
    {
        this.health = health;
        this.imagePath = imagePath;
        this.lopend = lopend;
        this.radius = radius;
        this.frames = frames;
        this.scale = scale;
        this.distanceBetweenFrames = distanceBetweenFrames;
        this.speed = speed;
        this. showName = showName;
        this.name = name;
    }

    public LevendWezen build(int x, int y)
    {
        return new LevendWezen(health, new Location(x,y), imagePath, lopend, radius, frames, scale, distanceBetweenFrames, speed, showName, name);
    }
}
