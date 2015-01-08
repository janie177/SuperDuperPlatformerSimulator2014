
package com.minegusta.janie177.collision;

import com.minegusta.janie177.Main;
import com.minegusta.janie177.data.Storage;
import com.minegusta.janie177.floor.Tile;
import com.minegusta.janie177.speler.PlayerStatus;
import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.wezens.types.Object;

import java.awt.*;
import java.awt.geom.Rectangle2D;

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
    public static CollisionFace getCollisionFace(Object bumping, Object object)
    {
        Rectangle left,right,up,down;
        Rectangle bumper = bumping.getHitBox();

        Rectangle hitbox = object.getHitBox();
        int width = (int) hitbox.getWidth();
        int height = (int) hitbox.getHeight();

        //Maak een berg rechthoeken. De zijden zijn minder gevoelig voor botsen.
        left = new Rectangle((int) hitbox.getMinX(), (int) hitbox.getMinY() + 2, 1, height - 4);
        right = new Rectangle((int) hitbox.getMaxX(), (int) hitbox.getMinY() + 2, 1, height - 4);
        up = new Rectangle((int) hitbox.getMinX(), (int) hitbox.getMinY(), width, 1);
        down = new Rectangle((int) hitbox.getMinX(), (int) hitbox.getMaxY(), width, 1);

        //Dit lijkt verkeerd om, maar het klopt omdat het ten opzichte van het botsende object is.
        if(bumper.intersects(left))return CollisionFace.RIGHT;
        if(bumper.intersects(right))return CollisionFace.LEFT;
        if(bumper.intersects(up))return CollisionFace.DOWN;
        if(bumper.intersects(down))return CollisionFace.UP;
        return CollisionFace.DOWN;
    }

    public static void update()
    {
        for(Object o : Storage.getLoadedObjects())
        {
            if(!collides(PlayerStatus.getHitBox(), o.getHitBox()))continue;
            if(o.hasCollision())
            {
                PlayerStatus.setCancelled(true);

                //Dit stopt objecten, maar dat is minder realistisch en alles loopt dat vast.
                //o.setCancelled(true);
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
