package com.minegusta.janie177.manager;

import com.minegusta.janie177.GamePanel;
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


    //Het bewegen van de speler dat voor elk level het zelfde is. Het heeft wel een aparte manager class maar ik doe het toch maar via de LevelManager zodat het overzichtelijker is.
	
	public void moveUp()
	{
        PlayerLocation.moveUp();
	}
	public void moveDown()
	{
        PlayerLocation.moveDown();
	}
	public void moveLeft()
	{
        PlayerLocation.moveLeft();
	}
	public void moveRight()
	{
        PlayerLocation.moveRight();
	}

}
