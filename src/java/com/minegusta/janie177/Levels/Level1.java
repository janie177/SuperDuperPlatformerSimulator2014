package com.minegusta.janie177.levels;

import com.minegusta.janie177.background.BackGround;
import com.minegusta.janie177.data.Storage;
import com.minegusta.janie177.floor.Floor;
import com.minegusta.janie177.speler.RenderPlayer;
import com.minegusta.janie177.wezens.soorten.MovingCreatures;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Level1 implements LevelModel
{
    private BackGround bg;
    private Floor floor;
    private java.util.List<Integer> holes = new ArrayList<Integer>();

    public Level1()
    {
        this.bg = new BackGround("/sprites/bg/bos.png", "/sprites/bg/2.png", "/sprites/bg/3.png");
        this.floor = new Floor(40, "/sprites/icon/icon2.png", holes);
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

    @Override
    public int getFloorHeight() {
        return floor.getHeight();
    }

    public void update(Graphics2D g2d)
    {
        bg.update(g2d);
        floor.update(g2d);
    }

    public void draw(Graphics2D g2d)
	{
        //Teken alle objecten
        Storage.drawObjects(g2d);

        //Teken de speler voor de objecten zodat deze altijd zichtbaar is.
        RenderPlayer r = new RenderPlayer();
        r.render(g2d);
	}

    @Override
    public List<Integer> getHoles() {
        return holes;
    }
}
