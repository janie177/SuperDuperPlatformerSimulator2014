package com.minegusta.janie177.util;


import com.minegusta.janie177.GamePanel;
import com.minegusta.janie177.manager.ScreenLocation;
import com.minegusta.janie177.wezens.LevendWezen;

import java.awt.*;
import java.util.concurrent.ConcurrentMap;

public class RenderUtil
{

    /**
     * Render alle levende wezens die in dit leven zitten die nog leven.
     * @param g2d Het scherm waarop alles getekend wordt.
     * @param map De map die alle wezens bevat.
     */
    public static void renderCreatures(Graphics2D g2d, ConcurrentMap<Integer, LevendWezen> map)
    {
        for(int xCoordinaat : map.keySet())
        {
            if(isRender(xCoordinaat))
            {
                if (!map.get(xCoordinaat).isDood())
                {
                    map.get(xCoordinaat).animeer(g2d);
                } else {
                    map.get(xCoordinaat).sterfAnimatie(g2d);
                    map.remove(xCoordinaat);
                }
            }
        }
    }


    /**
     * Scroll door de map met wezend en kijk of ze gerenderd moeten worden.
     * @param x De coordinaat die gechecked wordt.
     * @return Of een wezen gerendered moet worden.
     */
    public static boolean isRender(int x)
    {
        return Math.abs(ScreenLocation.getCenter() - x) <= GamePanel.width + 15;
    }
}
