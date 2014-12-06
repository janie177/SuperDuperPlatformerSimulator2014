package com.minegusta.janie177.wezens;

import com.minegusta.janie177.animation.AnimatedSprite;
import com.minegusta.janie177.util.Location;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class LevendWezen
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
    boolean forward = false;

    public LevendWezen(int health, Location origin, String imagePath, boolean lopend, int radius, int frames, int scale)
    {
        this.health = health;
        this.origin = origin;
        this.radius = radius;
        this.scale = scale;
        this.lopend = lopend;
        this.frames = frames;
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

    public boolean isDood()
    {
        return health > 0;
    }

    public void animeer(Graphics2D g2d)
    {
        if(lopend) {
            if (Math.abs(origin.getX() - location.getX()) >= radius) forward = !forward;
            if (forward) {
                location = new Location(location.getX() + 1, location.getY());
            } else
            {
                location = new Location(location.getX() - 1, location.getY());
            }
        }
        AnimatedSprite animation = new AnimatedSprite(image, frames);

        if(frame > frames)frame = 1;

        BufferedImage img = animation.getFrame(frame);

        g2d.drawImage(img, 300, getLocation().getY(), img.getWidth() * scale, img.getHeight() * scale, null);
        frame++;
    }
}
