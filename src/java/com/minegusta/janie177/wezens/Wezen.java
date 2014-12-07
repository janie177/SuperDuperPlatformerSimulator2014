package com.minegusta.janie177.wezens;


import com.minegusta.janie177.util.Location;

public enum Wezen
{
    JOOST(20, "/sprites/wezens/joost3.png", true, 80, 1, 1, 62, 7, true, "Joost"),
    GROTE_JOOST(20, "/sprites/wezens/joost3.png", true, 80, 1, 4, 62, 4, true, "Big Joost"),
    BAL_ELLENDE(10, "/sprites/speler/springlinks.png", true, 400, 4, 8, 32, 18, false, "Bal Der Ellende");

    private Monster monster;

    private Wezen(int health, String imagePath, boolean lopend, int radius, int frames, int scale, int distanceBetweenFrames, int speed, boolean showName, String name)
    {
        monster = new Monster(health, new Location(10,10), imagePath, lopend, radius, frames, scale, distanceBetweenFrames, speed, showName, name);
    }

    public Monster build(int x, int y)
    {
        monster.setLocation(new Location(x, y));
        return monster;
    }
}
