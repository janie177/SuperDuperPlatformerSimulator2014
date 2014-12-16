package com.minegusta.janie177.manager;

import com.minegusta.janie177.GamePanel;
import com.minegusta.janie177.speler.PlayerStatus;

public class ScreenLocation
{
    /**
     * Deze class geeft aan waar het beeld zich begeeft. Dit wordt gebruikt om de locatie van objecten relatief aan het scherm te bepalen.
     */

    public static int getX1()
    {
        return PlayerStatus.getX() - GamePanel.width;
    }

    public static int getCenter()
    {
        return PlayerStatus.getX();
    }

    public static int getX2()
    {
        return PlayerStatus.getX() + GamePanel.width;
    }
}
