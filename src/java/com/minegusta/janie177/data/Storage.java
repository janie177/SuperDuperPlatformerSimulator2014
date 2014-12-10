package com.minegusta.janie177.data;

import com.minegusta.janie177.wezens.soorten.MovingCreatures;
import com.minegusta.janie177.wezens.types.*;
import com.minegusta.janie177.wezens.types.Object;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Storage
{
    public static ConcurrentMap<Integer, LivingObject> creatureMap = new ConcurrentHashMap<Integer, LivingObject>();
    public static ConcurrentMap<Integer, Projectile> projectileMap = new ConcurrentHashMap<Integer, Projectile>();
    public static ConcurrentMap<Integer, Object> objectMap = new ConcurrentHashMap<Integer, Object>();


    public static ConcurrentMap<Integer, LivingObject> getCreatureMap()
    {
        return creatureMap;
    }
    public static ConcurrentMap<Integer, Projectile> getProjectileMap()
    {
        return projectileMap;
    }
    public static ConcurrentMap<Integer, Object> getObjectMap()
    {
        return objectMap;
    }
}
