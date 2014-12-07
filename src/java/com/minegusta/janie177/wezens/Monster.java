package com.minegusta.janie177.wezens;

import com.minegusta.janie177.util.Location;

import java.awt.*;

public class Monster extends LevendWezen
{

    public Monster(int health, Location origin, String imagePath, boolean lopend, int radius, int frames, int scale, int distanceBetweenFrames, int speed, boolean showName, String name) {
        super(health, origin, imagePath, lopend, radius, frames, scale, distanceBetweenFrames, speed, showName, name);
    }

    @Override
    public void sterfAnimatie(Graphics2D g2d) {
        //Maak hier een sterfAnimatie die specifiek bij dit monster past.
    }
}
