package com.minegusta.janie177.manager;

import com.minegusta.janie177.GamePanel;
import com.minegusta.janie177.speler.PlayerLocation;

public class ScreenLocation
{
    /**
     * Deze class geeft aan waar het beeld zich begeeft. Dit wordt gebruikt om de locatie van objecten relatief aan het scherm te bepalen.
     */

    public static int getX1()
    {
        return PlayerLocation.getX() - GamePanel.width / 2;
    }

    public static int getCenter()
    {
        return PlayerLocation.getX();
    }

    public static int getX2()
    {
        return PlayerLocation.getX() + GamePanel.width / 2;
    }
}
