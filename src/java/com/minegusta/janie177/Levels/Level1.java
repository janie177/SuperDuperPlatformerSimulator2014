package com.minegusta.janie177.Levels;

import java.awt.*;

import com.minegusta.janie177.background.BackGround;
import com.minegusta.janie177.speler.PlayerLocation;
import com.minegusta.janie177.speler.RenderSpeler;
import com.minegusta.janie177.util.Location;
import com.minegusta.janie177.wezens.Turret;

public class Level1 implements LevelModel
{
    private BackGround bg;
    public Level1()
    {
        this.bg = new BackGround("/sprites/bg/bos.png", "/sprites/bg/bos.png", "/sprites/bg/3.png");
    }
    public void updateBackground(Graphics2D g2d)
    {
        bg.update(g2d);
    }

    private Turret turret = new Turret(10, PlayerLocation.getLocation(), "/sprites/wezens/joost2.png", false, 100, 1, 1, 100, 9);

    public void draw(Graphics2D g2d)
	{
        //Teken de speler voor de objecten zodat deze altijd zichtbaar is.

        RenderSpeler r = new RenderSpeler();
        r.render(g2d);
        turret.animeer(g2d);
	}
}
