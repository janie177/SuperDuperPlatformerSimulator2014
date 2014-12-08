package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.animation.AnimatedSprite;
import com.minegusta.janie177.animation.Render;
import com.minegusta.janie177.util.Location;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MovingCreature extends LivingObject
{
    private int health;
    private Location location;
    private BufferedImage image;
    private int radius;
    private Location origin;
    private int damage;
    private int frames;
    private int hitBoxRadius;
    private boolean hasCollision;
    private int frame = 1;
    private int scale;
    private int speed;
    private boolean showName;
    private String name;
    boolean forward = false;
    private int distanceBetweenFrames;

    public MovingCreature(int health, Location origin, String imagePath, int radius, int frames, int scale, int distanceBetweenFrames, int speed, boolean showName, String name, int damage, boolean hasCollision, int hitBoxRadius)
    {
        this.health = health;
        this.origin = origin;
        this.radius = radius;
        this.name = name;
        this.showName = showName;
        this.scale = scale;
        this.speed = speed;
        this.damage = damage;
        this.hasCollision = hasCollision;
        this.hitBoxRadius = hitBoxRadius;
        this.frames = frames;
        this.distanceBetweenFrames = distanceBetweenFrames;
        this.location = origin;

        //probeer de image te laden
        try{
            image = ImageIO.read(MovingCreature.class.getResourceAsStream(imagePath));
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public int getHealth()
    {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;

    }

    @Override
    public boolean isDead() {
        return getHealth() <= 0;
    }

    @Override
    public void sterfAnimatie(Graphics2D g2d) {

        //Sterf hier
    }

    public Location getLocation()
    {
        return location;
    }

    @Override
    public boolean hasCollision() {
        return hasCollision;
    }

    @Override
    public int getHitBoxRadius() {
        return hitBoxRadius;
    }

    @Override
    public void actionOnCollision(Graphics2D g2d) {
        //Doe hier iets bij het botsen
    }

    @Override
    public Location getOrigin() {
        return origin;
    }

    @Override
    public void setOrigin(Location l)
    {
        origin = l;
        location = l;
    }

    @Override
    public void setLocation(Location l) {
        location = l;
    }

    @Override
    public void animeer(Graphics2D g2d)
    {
        if (Math.abs(origin.getX() - location.getX()) >= radius) forward = !forward;
        if (forward)
        {
            location = new Location(location.getX() + speed, location.getY());
        } else
        {
            location = new Location(location.getX() - speed, location.getY());
        }

        AnimatedSprite animation = new AnimatedSprite(image, distanceBetweenFrames);

        if(frame > frames)frame = 1;

        BufferedImage img = animation.getFrame(frame);

        Render.renderInWorld(g2d, img, location.getX(), location.getRenderedY(), scale, forward, name, showName);

        frame++;
    }
}
