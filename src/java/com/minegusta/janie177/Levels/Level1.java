package com.minegusta.janie177.Levels;

import java.awt.*;

import com.minegusta.janie177.background.BackGround;
import com.minegusta.janie177.data.Storage;
import com.minegusta.janie177.speler.RenderSpeler;
import com.minegusta.janie177.util.RenderUtil;
import com.minegusta.janie177.wezens.LevendWezen;
import com.minegusta.janie177.wezens.Wezen;

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
        Storage.creatureMap.clear();

        LevendWezen[] wezens = {Wezen.GROTE_JOOST.build(600,200),Wezen.JOOST.build(400,200), Wezen.JOOST.build(200, 180)};

        for(LevendWezen w : wezens)
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

        //Teken de speler voor de objecten zodat deze altijd zichtbaar is.
        RenderSpeler r = new RenderSpeler();
        r.render(g2d);
	}
}
