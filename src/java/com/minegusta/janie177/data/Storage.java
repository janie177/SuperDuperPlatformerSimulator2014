package com.minegusta.janie177.data;

import com.minegusta.janie177.wezens.LopendWezen;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Storage
{
    public static ConcurrentMap<Integer, LopendWezen> creatureMap = new ConcurrentHashMap<Integer, LopendWezen>();

    public static ConcurrentMap<Integer, LopendWezen> getCreatures()
    {
        return creatureMap;
    }

    public static void add(int location, LopendWezen wezen)
    {
        creatureMap.put(location, wezen);
    }
}
