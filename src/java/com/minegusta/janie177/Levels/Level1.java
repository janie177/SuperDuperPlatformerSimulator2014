package com.minegusta.janie177.Levels;

import java.awt.*;
import java.util.logging.Level;

import com.minegusta.janie177.background.BackGround;
import com.minegusta.janie177.manager.LevelManager;

public class Level1 implements LevelModel
{
    private BackGround bg = new BackGround("/bg/a.gif");

    public void updateBackground(Graphics2D g2d)
    {
        bg.create(g2d);
    }

    public void draw(Graphics2D g2d)
	{
		g2d.setColor(Color.RED);
        g2d.drawString("Lololol", 20, 40);
	}
}
