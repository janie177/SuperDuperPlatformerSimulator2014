package com.minegusta.janie177.data;

import com.minegusta.janie177.wezens.types.MovingCreature;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Storage
{
    public static ConcurrentMap<Integer, MovingCreature> objectMap = new ConcurrentHashMap<Integer, MovingCreature>();

    public static ConcurrentMap<Integer, MovingCreature> getCreatures()
    {
        return objectMap;
    }

    public static void add(int location, MovingCreature wezen)
    {
        objectMap.put(location, wezen);
    }
}
