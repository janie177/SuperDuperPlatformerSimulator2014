package com.minegusta.janie177.animation;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimatedSprite
{
    private BufferedImage img;
    private static int distanceBetweenFrames = 32;
    private static int height = 32;

    public AnimatedSprite(BufferedImage img)
    {
        this.img = img;
    }

    public BufferedImage getFrame(int index)
    {
        return img.getSubimage((index - 1) * distanceBetweenFrames, 0, distanceBetweenFrames, height);
    }






}
