package com.minegusta.janie177.manager;

import com.minegusta.janie177.Levels.Level;
import com.minegusta.janie177.Levels.LevelModel;

import java.awt.Graphics2D;

public class LevelManager
{
	private String level = "L1";

    //De constructor waarmee het level wordt bepaald.

    public LevelManager(String level)
    {
        this.level = level;
    }
	
	//De level class die van toepassing is op deze instance
    private LevelModel lm = Level.valueOf(level).getLevel();

    //Teken de obstakels en monsters die per level weer verschillen.
	public void draw(Graphics2D g2d)
	{
        lm.updateBackground(g2d);
        lm.draw(g2d);
	}


    //Het bewegen van de speler dat voor elk level het zelfde is. Dit gebeurt dus gewoon hier.
	
	public void moveUp(Graphics2D g2d)
	{


	}
	public void moveDown(Graphics2D g2d)
	{

	}
	public void moveLeft(Graphics2D g2d)
	{

	}
	public void moveRight(Graphics2D g2d)
	{

	}

}
