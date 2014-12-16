package com.minegusta.janie177.floor;


import com.minegusta.janie177.GamePanel;
import com.minegusta.janie177.util.Render;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Floor
{
    private BufferedImage image;
    private java.util.List<Integer> holes;
    private int height;

    public Floor(int height, String image, java.util.List<Integer> holes)
    {
        this.height = height;
        try
        {
            this.image = ImageIO.read(getClass().getResourceAsStream(image));
        } catch (Exception error)
        {
            error.printStackTrace();
        }
        this.holes = holes;
    }

    public void update(Graphics2D g2d)
    {
        int start = Tile.getFirstTile();
        int end = Tile.getLastTile();
        for(int i = start; i <= end; i++)
        {
            if(holes.contains(i))return;
            Render.renderInWorld(g2d, image, Tile.getTile(i), GamePanel.height - Tile.getHeight(), Tile.getWidth(), Tile.getHeight());
        }
    }
}
