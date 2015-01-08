package com.minegusta.janie177.data;

import com.minegusta.janie177.GamePanel;
import com.minegusta.janie177.speler.PlayerStatus;
import com.minegusta.janie177.wezens.types.*;
import com.minegusta.janie177.wezens.types.Object;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Storage
{
    public static Set<Object> objects = new HashSet<Object>();
    public static Set<Object> loadedObjects = new HashSet<Object>();



    public static Set<Object> getObjects()
    {
        return objects;
    }

    public static Set<Object> getLoadedObjects()
    {
        return loadedObjects;
    }

    public static void add(Object object)
    {
        objects.add(object);
    }

    public static void clearData()
    {
        objects.clear();
        loadedObjects.clear();
    }

    public static void updateLoadedObjects()
    {
        int playerLocation = PlayerStatus.getX();

        //Haal alle oude objecten weg.
        if(!loadedObjects.isEmpty())
        {
            for (Object o : loadedObjects) {
                if (Math.abs(o.getLocation().getX() - playerLocation) > GamePanel.width) {
                    if (loadedObjects.contains(o)) loadedObjects.remove(o);

                    //Kijk of het object leeft, en dan of het dood is.
                    if (o instanceof LivingObject) {
                        if (((LivingObject) o).isDead()) {
                            if (objects.contains(o)) objects.remove(o);
                        }
                    }
                }
            }
        }

        //Laad alle objecten die bij de speler in de buurt zijn.
        for (Object o : objects) {
            if (Math.abs(o.getLocation().getX() - playerLocation) < GamePanel.width) {
                loadedObjects.add(o);
            }
        }
    }

    public static void drawObjects(Graphics2D g2d)
    {
        for(Object o : loadedObjects)
        {
            if(o instanceof Projectile)
            {
                ((Projectile)o).animate(g2d);
            }
            else if(o instanceof IdleObject)
            {
                ((IdleObject)o).animate(g2d);
            }
            else if(o instanceof MovingObject)
            {
                ((MovingObject)o).animate(g2d);
            }
            else if(o instanceof MovingCreature)
            {
                ((MovingCreature)o).animate(g2d);
            }
            else if(o instanceof IdleCreature)
            {
                ((IdleCreature)o).animate(g2d);
            }
        }
    }
}
