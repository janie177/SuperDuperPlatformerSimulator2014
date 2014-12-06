package com.minegusta.janie177.manager;

import com.minegusta.janie177.Levels.Level;
import com.minegusta.janie177.Levels.LevelModel;

import java.awt.Graphics2D;

public class LevelManager
{
	private String level = "L1";
    private LevelModel lm;

    //De constructor waarmee het level wordt bepaald.

    public LevelManager(String level)
    {
        this.level = level;
        this.lm = Level.valueOf(level).getLevel();
    }
	
	//De level class die van toepassing is op deze instance


    //Teken de obstakels en monsters die per level weer verschillen.
	public void draw(Graphics2D g2d)
	{
        lm.updateBackground(g2d);
        lm.draw(g2d);
	}
}
