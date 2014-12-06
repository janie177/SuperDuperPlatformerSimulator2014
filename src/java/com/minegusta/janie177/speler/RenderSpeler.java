package com.minegusta.janie177.speler;

import com.minegusta.janie177.animation.AnimatedSprite;

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
        boolean jump = PlayerLocation.getY() < y;

        if(PlayerLocation.getX() > x)
        {
            if(jump)springRechts();
            else rechts();
        }
        else if(PlayerLocation.getX() < x)
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
        x = PlayerLocation.getX();
        y = PlayerLocation.getY();
    }

    //De verschillende animaties

    private void springLinks()
    {
        try {
            int max = 4;
            AnimatedSprite animation = new AnimatedSprite(ImageIO.read(getClass().getResourceAsStream("/sprites/speler/springlinks.png")));
            speler = animation.getFrame(getFromMap(SpelerAcie.UP, max));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void springRechts()
    {
        try {
            int max = 4;
            AnimatedSprite animation = new AnimatedSprite(ImageIO.read(getClass().getResourceAsStream("/sprites/speler/springrechts.png")));
            speler = animation.getFrame(getFromMap(SpelerAcie.UP, max));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void links()
    {
        try {
            int max = 5;
            AnimatedSprite animation = new AnimatedSprite(ImageIO.read(getClass().getResourceAsStream("/sprites/speler/links.png")));
            speler = animation.getFrame(getFromMap(SpelerAcie.UP, max));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void rechts()
    {
        try {
            int max = 5;
            AnimatedSprite animation = new AnimatedSprite(ImageIO.read(getClass().getResourceAsStream("/sprites/speler/rechts.png")));
            speler = animation.getFrame(getFromMap(SpelerAcie.UP, max));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void stil()
    {
        try
        {
            int max = 2;
            AnimatedSprite animation = new AnimatedSprite(ImageIO.read(getClass().getResourceAsStream("/sprites/speler/rechts.png")));
            speler = animation.getFrame(getFromMap(SpelerAcie.UP, max));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    //Private methods. Deze worden hierboven alleen binnen deze klas gebruikt. Ze updaten de frames en tekenen het speler object.

    private void draw()
    {

        g2d.drawImage(speler, 300, PlayerLocation.getY(), speler.getWidth() * 5, speler.getHeight() * 5,  null);
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
            if(i + 1 > max) i = 1;
            animatieMap.put(actie, i + 1);
        }
        else
        {
            animatieMap.put(actie, 1);
        }
    }

}
