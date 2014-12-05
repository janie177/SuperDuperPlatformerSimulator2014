package com.minegusta.janie177.Levels;

import java.awt.*;

import com.minegusta.janie177.background.BackGround;

public class Level1 implements LevelModel
{
    public void updateBackground(Graphics2D g2d)
    {
        BackGround bg = new BackGround("/bg/1.png", "/bg/2.png", "/bg/3.png");
        bg.update(g2d);
    }

    public void draw(Graphics2D g2d)
	{



	}
}
