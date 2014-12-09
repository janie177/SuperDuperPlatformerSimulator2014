package com.minegusta.janie177.speler;

import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.util.Velocity;

public class PlayerStatus
{
    //-- Alle basis info --//
    private static Location location = new Location(50, 100);
    private static Velocity velocity = new Velocity(0, 0);
    private static int health = 5;
    private static int damage = 1;
    private static int speed = 9;
    private static int jumpSpeed = 18;

    //-- Alle locatie veranderende info --//
    private static boolean left = false;
    private static boolean right = false;
    private static boolean down = false;
    private static boolean sprint = false;

    //-- Alle methodes die hier bij horen --//

    public static void update()
    {
        if(sprint)
        {
            speed = 14;
            jumpSpeed = 26;
        }
        else
        {
            speed = 9;
            jumpSpeed = 18;
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

        //Het verplaatsen van de speler
        setLocation(getLocation().setX(getX() + velocity.getX()).setY(getY() + velocity.getY()));
        //X mag niet onder 0 komen.
        if(getX() < 0) setLocation(getLocation().setX(0));

        velocity.update();

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

    public static void jump()
    {
        velocity.setY(jumpSpeed);
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
