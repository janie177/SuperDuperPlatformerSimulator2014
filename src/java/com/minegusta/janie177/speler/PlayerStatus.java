package com.minegusta.janie177.speler;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.util.Velocity;

import java.awt.*;

public class PlayerStatus
{
    //-- Alle basis info --//
    private static Location location = new Location(50, 100);
    private static Location oldLocation = location;
    private static Velocity velocity = new Velocity(0, 0);
    private static int health = 5;
    private static int damage = 1;
    private static int speed = 9;
    private static int jumpSpeed = 40;

    //-- Alle locatie veranderende info --//
    private static boolean left = false;
    private static boolean right = false;
    private static boolean down = false;
    private static boolean sprint = false;
    private static boolean canJump = true;
    private static boolean cancel = false;

    //-- Alle methodes die hier bij horen --//

    public static void update()
    {
        if(sprint)
        {
            speed = 14;
            jumpSpeed = 28;
        }
        else
        {
            speed = 9;
            jumpSpeed = 22;
        }
        if(left)
        {
            velocity.setX(-speed);
        }
        if(right)
        {
            velocity.setX(speed);
        }
        if(down)
        {
            velocity.setY(-jumpSpeed);
        }

        if(!cancel)
        {
            //Het verplaatsen van de speler
            setLocation(getLocation().setX(getX() + velocity.getX()).setY(getY() + velocity.getY()));
            //X mag niet onder 0 komen.
            if(getX() < 0) setLocation(getLocation().setX(0));

            velocity.setY(velocity.getY() - 2);
            if(velocity.getY() < -15)velocity.setY(-15);

            velocity.update();

            int oldX = getLocation().getX() - 3*getVelocity().getX();
            int oldY = getLocation().getY();
            oldLocation = new Location(oldX, oldY);
        }
        else{
            setLocation(oldLocation);
        }
        cancel = false;



    }

    public static Rectangle getHitBox()
    {
        return new Rectangle(getLocation().getX(), getLocation().getY(), 32*7, 32*7);
    }

    public static Velocity getVelocity()
    {
        return velocity;
    }

    public static void setVelocity(Velocity v)
    {
        velocity = v;
    }

    public static void damage(int damage)
    {
        health = health - damage;
    }

    public static boolean isDead()
    {
        return health <= 0;
    }

    public static Location getLocation()
    {
        return location;
    }

    public static int getX()
    {
        return location.getX();
    }

    public static void setLocation(Location l)
    {
        location = l;
    }

    public static int getY()
    {
        return location.getY();
    }

    public static int getJumpSpeed()
    {
        return jumpSpeed;
    }

    public static int getSpeed()
    {
        return speed;
    }

    public static boolean isCancelled()
    {
        return cancel;
    }

    public static void setCancelled(boolean cancelled)
    {
        cancel = cancelled;
    }

    public static boolean getRunning()
    {
        return sprint;
    }

    public static int getRenderedY()
    {
        return location.getRenderedY();
    }

    public static int getHealth()
    {
        return health;
    }

    public static int getDamage()
    {
        return damage;
    }

    //-- Methods om te bewegen --//

    public static void setLeft(boolean b)
    {
        left = b;
    }

    public static void setRight(boolean b)
    {
        right = b;
    }

    public static void setDown(boolean b)
    {
        down = b;
    }

    public static void setSprint(boolean b)
    {
        sprint = b;
    }

    public static void setCanJump(boolean b)
    {
        canJump = b;
    }

    public static void jump()
    {
        if(canJump)velocity.setY(jumpSpeed);
        canJump = false;
    }




    //Dit systeem werkt voor nu, maar voor springen enzo hebben we velocity nodig. Spelers moeten een snelheid hebben die afneemt zodat we ook zwaartekracht kunnen hebben.
    /**
    public PlayerStatus()
    {
        if(links)
        {
            moveLeft();
        }
        if(rechts)
        {
            moveRight();
        }
        if(jumping)
        {
            moveUp();
        }
        if(down)
        {
            moveDown();
        }
    }

    private static Location location = new Location(15, 100);


    //-- Bewegen --//
    private static boolean links = false;
    private static boolean rechts = false;
    private static boolean jumping = false;
    private static boolean down = false;
    private static boolean sprint = false;
    private static int speed = 9;
    private static int jumpSpeed = 18;

    private static void moveUp()
    {
        location.setY(location.getY() + jumpSpeed);
        if(location.getY() > 800)location.setY(800);
    }

    private static void moveDown()
    {
        location.setY(location.getY() - jumpSpeed);
        if(location.getY() < 100) location.setY(100);
    }
    private static void moveLeft()
    {
        location.setX(location.getX() - speed);
        if(location.getX() < 15) location.setX(15);
    }
    private static void moveRight()
    {
        location.setX(location.getX() + speed);
    }

    //-- Het krijgen van de locatie --//
    public static int getX(){ return location.getX(); }

    public static int getY()
    {
        return location.getY();
    }

    public static Location getLocation()
    {
        return location;
    }

    public static int getRenderedY()
    {
        return location.getRenderedY();
    }

    public static void setLinks(boolean b)
    {
        links = b;
    }

    public static void setRechts(boolean b)
    {
        rechts = b;
    }

    public static void setUp(boolean b)
    {
        jumping = b;
    }

    public static void setDown(boolean b)
    {
        down = b;
    }
     **/
}
