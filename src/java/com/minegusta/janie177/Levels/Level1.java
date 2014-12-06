package com.minegusta.janie177.Levels;

import java.awt.*;

import com.minegusta.janie177.background.BackGround;
import com.minegusta.janie177.speler.RenderSpeler;

public class Level1 implements LevelModel
{
    private static BackGround bg;
    public Level1()
    {
        this.bg = new BackGround("/sprites/bg/bomen2.png", "/sprites/bg/2.png", "/sprites/bg/test/1.jpg");
    }
    public void updateBackground(Graphics2D g2d)
    {
        bg.update(g2d);
    }

    public void draw(Graphics2D g2d)
	{
        //Teken de speler voor de objecten zodat deze altijd zichtbaar is.
        RenderSpeler r = new RenderSpeler();
        r.render(g2d);

	}
}
