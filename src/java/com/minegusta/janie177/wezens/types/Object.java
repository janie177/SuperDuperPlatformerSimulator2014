package com.minegusta.janie177.wezens.types;

import com.minegusta.janie177.GamePanel;
import com.minegusta.janie177.Main;
import com.minegusta.janie177.animation.AnimatedSprite;
import com.minegusta.janie177.speler.PlayerStatus;
import com.minegusta.janie177.util.Render;
import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.wezens.collision.CollisionAction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Object
{
    private boolean hasCollision;
    private Location origin;
    private int damage;
    private Location location;
    private BufferedImage image;
    private String name;
    private boolean showName;
    private  int scale;
    private int frames;
    private CollisionAction action;
    private double bounceSpeed;
    private int distanceBetweenFrames;
    private int frame = 1;

    public Object(String imagePath, int frames, int distanceBetweenFrames, int scale, boolean hasCollision, Location origin, int damage, boolean showName, String name, CollisionAction action, double bounceSpeed)
    {
        this.hasCollision = hasCollision;
        this.origin = origin;
        this.damage = damage;
        this.scale = scale;
        this.location = origin;
        this.name = name;
        this.showName = showName;
        this.frames = frames;
        this.distanceBetweenFrames = distanceBetweenFrames;
        this.action = action;
        this.bounceSpeed = bounceSpeed;

        //probeer de image te laden
        try{
            image = ImageIO.read(MovingCreature.class.getResourceAsStream(imagePath));
        } catch (Exception e) {e.printStackTrace();}
    }

    public void animate(Graphics2D g2d, boolean flipped)
    {
        AnimatedSprite animation = new AnimatedSprite(getImage(), getDistanceBetweenFrames());

        if(frame > getFrames())frame = 1;

        BufferedImage img = animation.getFrame(frame);

        Render.renderInWorld(g2d, img, getLocation().getX(), getLocation().getRenderedY(), getScale(), flipped, getName(), getShowName());

        frame++;
    }

    public void actionOnCollision()
    {
        switch (action)
        {
            case NOTHING:
            {
                //Doe hier helemaal niets :D
            }
                break;
            case DAMAGE:
            {
                //Damage de speler hier
                PlayerStatus.damage(damage);
            }
                break;
            case BOUNCE:
            {
                //Lanceer de speler hier
                PlayerStatus.getVelocity().setY((int)bounceSpeed);
            }
                break;
            case LEVELUP:
            {
                //Level omhoog :D
                Main.getGamePanel().levelUp();
            }
                break;
            default:
                break;
        }

    }

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

    public Rectangle getHitBox()
    {
        return new Rectangle(location.getX() - distanceBetweenFrames / 2, location.getY() - image.getHeight() / 2, distanceBetweenFrames * scale, image.getHeight() * scale);
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
