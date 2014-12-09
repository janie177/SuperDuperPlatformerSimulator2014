package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.animation.AnimatedSprite;
import com.minegusta.janie177.animation.Render;
import com.minegusta.janie177.util.Location;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Object
{
    private boolean hasCollision;
    private int hitBoxRadius;
    private Location origin;
    private int damage;
    private Location location;
    private BufferedImage image;
    private String name;
    private boolean showName;
    private  int scale;
    private int frames;
    private int distanceBetweenFrames;
    private int frame = 1;

    public Object(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, int hitBoxRadius, Location origin, int damage, boolean showName, String name)
    {
        this.hasCollision = hasCollision;
        this. hitBoxRadius = hitBoxRadius;
        this.origin = origin;
        this.damage = damage;
        this.scale = scale;
        this.location = origin;
        this.name = name;
        this.showName = showName;
        this.frames = frames;
        this.distanceBetweenFrames = distanceBetweenFrames;

        //probeer de image te laden
        try{
            image = ImageIO.read(MovingCreature.class.getResourceAsStream(imagePath));
        } catch (Exception e) {e.printStackTrace();}
    }

    public void animeer(Graphics2D g2d, boolean flipped)
    {
        AnimatedSprite animation = new AnimatedSprite(getImage(), getDistanceBetweenFrames());

        if(frame > getFrames())frame = 1;

        BufferedImage img = animation.getFrame(frame);

        Render.renderInWorld(g2d, img, getLocation().getX(), getLocation().getRenderedY(), getScale(), flipped, getName(), getShowName());

        frame++;
    }

    public abstract void actionOnCollision(Graphics2D g2d);

    public BufferedImage getImage()
    {
        return image;
    }

    public void setLocation(Location l)
    {
        this.location = l;
    }

    public Location getLocation()
    {
        return location;
    }

    public String getName()
    {
        return name;
    }

    public boolean getShowName()
    {
        return showName;
    }

    public int getDamage()
    {
        return damage;
    }

    public boolean hasCollision()
    {
        return hasCollision;
    }

    public int getHitBoxRadius()
    {
        return hitBoxRadius;
    }

    public void setOrigin(Location l)
    {
        this.origin = l;
    }

    public Location getOrigin()
    {
        return origin;
    }

    public int getFrames()
    {
        return frames;
    }

    public  int getScale()
    {
        return scale;
    }

    public int getDistanceBetweenFrames()
    {
        return distanceBetweenFrames;
    }
}
