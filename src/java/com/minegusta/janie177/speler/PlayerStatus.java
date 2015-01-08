package com.minegusta.janie177.speler;

import com.minegusta.janie177.collision.Face;
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
    private static Face[] direction = new Face[2];

    //-- Alle locatie veranderende info --//
    private static boolean left = false;
    private static boolean right = false;
    private static boolean down = false;
    private static boolean sprint = false;
    private static boolean canJump = true;
    private static boolean cancelWalk = false;

    //-- Alle methodes die hier bij horen --//

    public static void update()
    {
        direction[0] = Face.IDLE;
        direction[1] = Face.IDLE;

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
            direction[0] = Face.LEFT;
            velocity.setX(-speed);
        }
        if(right)
        {
            direction[0] = Face.RIGHT;
            velocity.setX(speed);
        }
        if(down)
        {
            direction[1] = Face.DOWN;
            velocity.setY(-jumpSpeed);
        }
        //Check of de speler omhoog of omlaag gaat voor botsingen.
        if(velocity.getY() > 0)
        {
            direction[1] = Face.UP;
        }
        else
        {
            direction[1] = Face.DOWN;
        }
    }

    public static void updateLocation()
    {
        if(!cancelWalk)
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
        cancelWalk = false;
    }

    public static void walk()
    {
        updateLocation();
    }

    public static void blockMovement(Face face)
    {
        switch (face)
        {
            case UP: getVelocity().set(getVelocity().getY(), 0);
                break;
            case DOWN: getVelocity().set(getVelocity().getY(), 0);
                break;
            case LEFT: getVelocity().set(0, getVelocity().getX());
                break;
            case RIGHT: getVelocity().set(0, getVelocity().getX());
                break;
            default:
                break;
        }
    }

    public static Face[] getDirection()
    {
        return direction;
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

    public static boolean isWalkCancelled()
    {
        return cancelWalk;
    }

    public static void cancelWalk(boolean cancelled)
    {
        cancelWalk = cancelled;
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
