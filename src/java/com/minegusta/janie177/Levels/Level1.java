package com.minegusta.janie177.levels;

import com.minegusta.janie177.background.BackGround;
import com.minegusta.janie177.data.Storage;
import com.minegusta.janie177.speler.PlayerStatus;
import com.minegusta.janie177.speler.RenderSpeler;
import com.minegusta.janie177.wezens.soorten.MovingCreatures;

import java.awt.*;

public class Level1 implements LevelModel
{
    private BackGround bg;
    public Level1()
    {
        this.bg = new BackGround("/sprites/bg/bos.png", "/sprites/bg/bos.png", "/sprites/bg/Lake.png");
        addObjects();
    }

    @Override
    public void addObjects()
    {
        //maak de map eerst leeg.
        Storage.clearData();

        //Laad alle objecten in de map.
        com.minegusta.janie177.wezens.types.Object[] objects = {
                MovingCreatures.JOOST.build(500, 300)
        };

        for(com.minegusta.janie177.wezens.types.Object o : objects)
        {
            Storage.add(o);
        }

    }

    public void updateBackground(Graphics2D g2d)
    {
        bg.update(g2d);
    }

    public void draw(Graphics2D g2d)
	{
        //Teken alle objecten
        Storage.drawObjects(g2d);

        //Teken de speler voor de objecten zodat deze altijd zichtbaar is.
        RenderSpeler r = new RenderSpeler();
        r.render(g2d);
	}
}
