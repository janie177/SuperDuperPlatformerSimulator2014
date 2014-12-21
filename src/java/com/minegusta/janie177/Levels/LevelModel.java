package com.minegusta.janie177.levels;

import java.awt.*;

public interface LevelModel
{

    public void addObjects();

    public int getFloorHeight();

    public void update(Graphics2D g2d);

    public void draw(Graphics2D g2d);

    public java.util.List<Integer> getHoles();
}
