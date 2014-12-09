package com.minegusta.janie177.levels;

import com.minegusta.janie177.background.BackGround;
import com.minegusta.janie177.data.Storage;
import com.minegusta.janie177.speler.PlayerStatus;
import com.minegusta.janie177.speler.RenderSpeler;
import com.minegusta.janie177.util.RenderUtil;
import com.minegusta.janie177.wezens.soorten.MovingCreatures;
import com.minegusta.janie177.wezens.types.MovingCreature;

import java.awt.*;

public class Level1 implements LevelModel
{
    private BackGround bg;
    public Level1()
    {
        this.bg = new BackGround("/sprites/bg/bos.png", "/sprites/bg/bos.png", "/sprites/bg/3.png");
        addCreatures();
    }

    @Override
    public void addCreatures()
    {
        //maak de map eerst leeg.
        Storage.objectMap.clear();

        MovingCreature[] wezens = {MovingCreatures.JOOST.build(200, 180)};

        for(MovingCreature w : wezens)
        {
            Storage.add(w.getLocation().getX(), w);
        }
    }

    public void updateBackground(Graphics2D g2d)
    {
        bg.update(g2d);
    }

    public void draw(Graphics2D g2d)
	{
        RenderUtil.renderCreatures(g2d, Storage.getCreatures());

        PlayerStatus.update();

        //Teken de speler voor de objecten zodat deze altijd zichtbaar is.
        RenderSpeler r = new RenderSpeler();
        r.render(g2d);
	}
}
