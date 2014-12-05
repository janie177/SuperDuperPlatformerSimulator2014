package com.minegusta.janie177.Levels;

import java.awt.*;
import java.util.logging.Level;

import com.minegusta.janie177.GamePanel;
import com.minegusta.janie177.background.BackGround;

public class Level1 implements LevelModel
{
    private static BackGround bg = new BackGround("/bg/a.gif");

    public void updateBackground(Graphics2D g2d)
    {
        bg.update(g2d);
    }

    public void draw(Graphics2D g2d)
	{
		g2d.setColor(Color.RED);
        g2d.setFont(new Font("Dracula", Font.BOLD, 20));
        g2d.drawString("Super Duper Platformer Simulator 2014", 250, GamePanel.height / 4);
	}
}
