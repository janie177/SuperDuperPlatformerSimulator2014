
package com.minegusta.janie177.collision;

import com.minegusta.janie177.GamePanel;
import com.minegusta.janie177.Main;
import com.minegusta.janie177.data.Storage;
import com.minegusta.janie177.floor.Tile;
import com.minegusta.janie177.speler.PlayerStatus;
import com.minegusta.janie177.util.Velocity;
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

    public static void update()
    {
        for(Object o : Storage.getLoadedObjects())
        {
            if(!collides(PlayerStatus.getHitBox(), o.getHitBox()))continue;
            if(o.hasCollision())
            {
               PlayerStatus.setLocation(PlayerStatus.getOldLocation());
            }
            o.actionOnCollision();
        }
    }

    public static void floorCheck()
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
