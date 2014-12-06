package com.minegusta.janie177.animation;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Render
{
    private static int added = 400;
    public static void renderInWorld(Graphics2D g2d, BufferedImage img, int x, int y, int scale)
    {
        g2d.drawImage(img, x + added, y, img.getWidth() * scale, img.getHeight() * scale, null);
    }
}
