package com.minegusta.janie177.Levels;

import java.awt.*;

import com.minegusta.janie177.GamePanel;
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
		g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Super Duper Platformer Simulator 2014", 250, GamePanel.height / 4);
	}
}
