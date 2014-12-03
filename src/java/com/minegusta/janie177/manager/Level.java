package com.minegusta.janie177.manager;

import com.minegusta.janie177.Levels.Level1;

public enum Level
{
    L1(new Level1());

    private LevelManager level;

    private Level(LevelManager level)
    {
        this.level = level;
    }

    public LevelManager getLevel()
    {
        return level;
    }
}
