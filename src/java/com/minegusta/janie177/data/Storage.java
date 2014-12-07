package com.minegusta.janie177.data;

import com.minegusta.janie177.wezens.LevendWezen;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Storage
{
    public static ConcurrentMap<Integer, LevendWezen> creatureMap = new ConcurrentHashMap<Integer, LevendWezen>();

    public static ConcurrentMap<Integer, LevendWezen> getCreatures()
    {
        return creatureMap;
    }

    public static void add(int location, LevendWezen wezen)
    {
        creatureMap.put(location, wezen);
    }
}
