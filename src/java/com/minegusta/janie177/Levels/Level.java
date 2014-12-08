package com.minegusta.janie177.levels;

public enum Level
{
    L1(new Level1());

    private LevelModel level;

    private Level(LevelModel level)
    {
        this.level = level;
    }

    public LevelModel getLevel()
    {
        return level;
    }
}
