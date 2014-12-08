package com.minegusta.janie177.levels;

public class LevelUp
{
    /**
     * Geef het volgende level.
     * @param level Het oude level.
     * @return Het nieuwe level in de vorm van een string. L + level.
     */
    public static String up(String level)
    {
        int newLevel = Integer.parseInt(level.replace("L", "")) + 1;
        return "L" + Integer.toString(newLevel);
    }
}
