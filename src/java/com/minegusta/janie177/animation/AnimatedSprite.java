package com.minegusta.janie177.animation;

import java.awt.image.BufferedImage;

public class AnimatedSprite
{
    private BufferedImage img;
    private int distanceBetweenFrames;

    public AnimatedSprite(BufferedImage img, int distanceBetweenFrames)
    {
        this.img = img;
        this.distanceBetweenFrames = distanceBetweenFrames;
    }

    public BufferedImage getFrame(int index)
    {
        return img.getSubimage((index - 1) * distanceBetweenFrames, 0, distanceBetweenFrames, img.getHeight());
    }
}
