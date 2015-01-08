
package com.minegusta.janie177.collision;

import com.minegusta.janie177.Main;
import com.minegusta.janie177.data.Storage;
import com.minegusta.janie177.floor.Tile;
import com.minegusta.janie177.speler.PlayerStatus;
import com.minegusta.janie177.wezens.types.MovingCreature;
import com.minegusta.janie177.wezens.types.MovingObject;
import com.minegusta.janie177.wezens.types.Object;

import java.awt.*;

public class CollisionManager
{
    public static boolean collides(Object o1, Object o2)
    {
        return o1.getHitBox().intersects(o2.getHitBox());
    }

    public static boolean collides(Rectangle r1, Rectangle r2)
    {
        return r1.intersects(r2);
    }

    /**
     * Krijg de richting van de botsing voor het BOTSENDE OBJECT.
     * @param bumping Het object waarvan je de richting van de botsing vraagt. Beneden is dus boven voor het andere object.
     * @param object Het object waarmee gebotst wordt.
     * @return De richting van de botsing ten opzichte van het object dat opgegeven is als botsende.
     */
    public static Face getCollisionFace(Rectangle bumping, Rectangle object)
    {
        Rectangle left,right,up,down;

        int width = (int) object.getWidth();
        int height = (int) object.getHeight();

        //Maak een berg rechthoeken. De zijden zijn minder gevoelig voor botsen.
        left = new Rectangle((int) object.getMinX(), (int) object.getMinY() + 2, 1, height - 4);
        right = new Rectangle((int) object.getMaxX(), (int) object.getMinY() + 2, 1, height - 4);
        up = new Rectangle((int) object.getMinX(), (int) object.getMinY(), width, 1);
        down = new Rectangle((int) object.getMinX(), (int) object.getMaxY(), width, 1);

        //Dit lijkt verkeerd om, maar het klopt omdat het ten opzichte van het botsende object is.
        if(bumping.intersects(left))return Face.RIGHT;
        if(bumping.intersects(right))return Face.LEFT;
        if(bumping.intersects(up))return Face.DOWN;
        if(bumping.intersects(down))return Face.UP;
        return Face.DOWN;
    }

    /**
     * Kijk of de speler botst. Als dat het geval is, block dan movement.
     */
    public static void update()
    {
        for(Object o : Storage.getLoadedObjects())
        {
            if(!collides(PlayerStatus.getHitBox(), o.getHitBox()))continue;
            if(o.hasCollision())
            {
                //Kaats de speler terug wanneer het object beweegt.
                if(o instanceof MovingCreature || o instanceof MovingObject)
                {
                    if(Math.abs(o.getVelocity().getX()) > Math.abs(PlayerStatus.getVelocity().getX()))
                    {
                        PlayerStatus.setVelocity(o.getVelocity());
                    }
                }

                Face collisionFace = getCollisionFace(PlayerStatus.getHitBox(), o.getHitBox());

                for(Face direction : PlayerStatus.getDirection())
                {
                    if(direction == collisionFace)
                    {
                        PlayerStatus.blockMovement(direction);

                    }
                }


            }
            o.actionOnCollision();
        }
    }

    public static void playerFloorCheck()
    {
        int height = Main.getGamePanel().getManager().getFloorHeight() + Tile.getHeight();

        if(PlayerStatus.getLocation().getY() < height)
        {
            if(Main.getGamePanel().getManager().getHoles().contains(Tile.getTileFromLocation(PlayerStatus.getLocation().getX())))
            {
                PlayerStatus.damage(3);
            }
            else
            {
                PlayerStatus.setLocation(PlayerStatus.getLocation().setY(height));
                PlayerStatus.setCanJump(true);
            }
        }
    }
}
