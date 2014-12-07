package com.minegusta.janie177.wezens;

import com.minegusta.janie177.animation.AnimatedSprite;
import com.minegusta.janie177.animation.Render;
import com.minegusta.janie177.manager.ScreenLocation;
import com.minegusta.janie177.util.Location;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LevendWezen
{
    private int health;
    private Location location;
    private BufferedImage image;
    private int radius;
    private Location origin;
    private int frames;
    private boolean lopend;
    private int frame = 1;
    private int scale;
    private int speed;
    private boolean showName;
    private String name;
    boolean forward = false;
    private int distanceBetweenFrames;

    public LevendWezen(int health, Location origin, String imagePath, boolean lopend, int radius, int frames, int scale, int distanceBetweenFrames, int speed, boolean showName, String name)
    {
        this.health = health;
        this.origin = origin;
        this.radius = radius;
        this.name = name;
        this.showName = showName;
        this.scale = scale;
        this.lopend = lopend;
        this.speed = speed;
        this.frames = frames;
        this.distanceBetweenFrames = distanceBetweenFrames;
        this.location = origin;

        //probeer de image te laden
        try{
            image = ImageIO.read(LevendWezen.class.getResourceAsStream(imagePath));
        } catch (Exception e) {e.printStackTrace();}
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getHealth()
    {
        return health;
    }

    public Location getLocation()
    {
        return location;
    }

    public LevendWezen setLocation(Location l)
    {
        origin = l;
        location = l;
        return this;
    }

    public boolean isDood()
    {
        return health <= 0;
    }

    public void sterfAnimatie(Graphics2D g2d)
    {
        //TODO Een sterg animatie maken
    }

    public void animeer(Graphics2D g2d)
    {
        if(lopend) {
            if (Math.abs(origin.getX() - location.getX()) >= radius) forward = !forward;
            if (forward) {
                location = new Location(location.getX() + speed, location.getY());
            } else
            {
                location = new Location(location.getX() - speed, location.getY());
            }
        }
        AnimatedSprite animation = new AnimatedSprite(image, distanceBetweenFrames);

        if(frame > frames)frame = 1;

        BufferedImage img = animation.getFrame(frame);

        Render.renderInWorld(g2d, img, location.getX(), location.getRenderedY(), scale, forward, name, showName);

        frame++;
    }
}
