package com.minegusta.janie177.speler;

import com.minegusta.janie177.animation.AnimatedSprite;
import com.minegusta.janie177.util.Render;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RenderSpeler
{
    //Map waarin de status van de speler bewaard is
    private static ConcurrentMap<SpelerAcie, Integer> animatieMap = new ConcurrentHashMap<SpelerAcie, Integer>();

    private Graphics2D g2d;
    private static int x = 0;
    private static int y = 0;
    private BufferedImage speler;

    public void render(Graphics2D g2d)
    {
        this.g2d = g2d;
        boolean jump = PlayerStatus.getY() > y;

        if(PlayerStatus.getX() > x)
        {
            if(jump)springRechts();
            else rechts();
        }
        else if(PlayerStatus.getX() < x)
        {
            if(jump)springLinks();
            else links();
        }
        else if(jump)
        {
            springRechts();
        }
        else
        {
            //Stilstaan
            stil();
        }

        draw();

        //update x en y
        x = PlayerStatus.getX();
        y = PlayerStatus.getY();
    }

    //De verschillende animaties

    private void springLinks()
    {
        try {
            int max = 4;
            AnimatedSprite animation = new AnimatedSprite(ImageIO.read(getClass().getResourceAsStream("/sprites/speler/springlinks.png")), 32);
            speler = animation.getFrame(getFromMap(SpelerAcie.JUMPLEFT, max));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void springRechts()
    {
        try {
            int max = 4;
            AnimatedSprite animation = new AnimatedSprite(ImageIO.read(getClass().getResourceAsStream("/sprites/speler/springrechts.png")), 32);
            speler = animation.getFrame(getFromMap(SpelerAcie.JUMPRIGHT, max));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void links()
    {
        try {
            int max = 5;
            AnimatedSprite animation = new AnimatedSprite(ImageIO.read(getClass().getResourceAsStream("/sprites/speler/links.png")), 32);
            speler = animation.getFrame(getFromMap(SpelerAcie.LEFT, max));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void rechts()
    {
        try {
            int max = 5;
            AnimatedSprite animation = new AnimatedSprite(ImageIO.read(getClass().getResourceAsStream("/sprites/speler/rechts.png")), 32);
            speler = animation.getFrame(getFromMap(SpelerAcie.RIGHT, max));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void stil()
    {
        try
        {
            int max = 1;
            AnimatedSprite animation = new AnimatedSprite(ImageIO.read(getClass().getResourceAsStream("/sprites/speler/rechts.png")), 32);
            speler = animation.getFrame(getFromMap(SpelerAcie.IDLE, max));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    //Private methods. Deze worden hierboven alleen binnen deze class gebruikt. Ze updaten de frames en tekenen het speler object.

    private void draw()
    {
        Render.renderInWorld(g2d, speler, PlayerStatus.getX(), PlayerStatus.getRenderedY(), 7);
    }

    private int getFromMap(SpelerAcie actie, int max)
    {
        if(animatieMap.containsKey(actie))
        {
            int animatie = animatieMap.get(actie);
            if(animatie > max) animatie = max;
            updateMap(actie, max);
            return animatie;
        }
        updateMap(actie, max);
        return 1;
    }

    private void updateMap(SpelerAcie actie, int max)
    {
        if(animatieMap.containsKey(actie))
        {
            int i = animatieMap.get(actie);
            if(i + 1 > max) i = 0;
            animatieMap.put(actie, i + 1);
        }
        else
        {
            animatieMap.put(actie, 1);
        }
    }

}
