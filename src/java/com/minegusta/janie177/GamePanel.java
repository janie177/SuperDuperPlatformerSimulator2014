package com.minegusta.janie177;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import com.minegusta.janie177.Levels.LevelUp;
import com.minegusta.janie177.manager.LevelManager;
import com.minegusta.janie177.speler.PlayerLocation;
import com.minegusta.janie177.speler.RenderSpeler;

public class GamePanel extends JPanel implements Runnable, KeyListener
{
    //-- Alle informatie die belangrijk is voor het scherm zelf --//

	//Schaal zodat het makkelijker is om straks de grootte van het scherm snel te veranderen.
	private static int scale = 15;
	public static int height = 60 * scale;
	public static int width = 80 * scale;
	private Thread thread = null;
	private Image image;
    private boolean aan = false;
    private long loopinterval = 0; //Cooldown op lopen in ms
	private Graphics2D g2d;
	private int fps = 30;
	//Het aantal miliseconden dat de thread moet wachten om de gewenste FPS te krijgen.
	private long wait = 1000/fps;
    //Het level waarin je zit.
    private String level = "L1";
    private LevelManager manager = new LevelManager(level);

	//De constructor
	public GamePanel()
    {
		setPreferredSize(new Dimension(width, height));

        setVisible(true);

        setFocusable(true);

        requestFocus();

        makeThread();
        setVisible(true);
	}
	
	//begin de thread.

	private void makeThread()
	{
		if(thread == null)
		{
            //Maak een nieuwe thread als deze nog niet bestaat.
			thread = new Thread(this);
		}
        //Voeg deze class toe als keylistener
        addKeyListener(this);
        aan = true;
		thread.start();
	}
	
	@Override
	public void run() 
	{
        while(aan)
        {
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            g2d = (Graphics2D) image.getGraphics();

            //Teken methode voor de wereld en entities. Wordt doorgegeven aan de level class.
            draw();

            //Check voor lopen
            loopinterval = loopinterval + wait;
            if(loopinterval >= 4)
            {
                loopinterval = 0;
                new PlayerLocation();
            }

            //Tekent het uiteindelijke resultaat op het scherm.
            updateScreen();

            //Laat de thread slapen om de gewenste FPS te krijgen.
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

    //Doe hier alles qua graphics. Speler en objecten etc etc.
	private void draw()
	{
        manager.draw(g2d);
	}

    private void levelUp()
    {
        //Zet de level manager hier omhoog naar het volgende level.
        level = LevelUp.up(level);
        manager = new LevelManager(level);
    }


	private void updateScreen()
    {
        getGraphics().drawImage(image, 0, 0, null);
        getGraphics().dispose();
    }

    //Luister naar keys die ingedrukt worden.

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    //Luister hier naar lopen en springen.
    @Override
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_A:
            {
                PlayerLocation.setLinks(true);
            }
                break;
            case KeyEvent.VK_S:
            {
                PlayerLocation.setDown(true);
            }
                break;
            case KeyEvent.VK_D:
            {
                PlayerLocation.setRechts(true);
            }
                break;
            case KeyEvent.VK_W:
            {
                PlayerLocation.setUp(true);
            }
                break;
            case KeyEvent.VK_SPACE:
            {
                PlayerLocation.setUp(true);
            }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_A:
            {
                PlayerLocation.setLinks(false);
            }
            break;
            case KeyEvent.VK_S:
            {
                PlayerLocation.setDown(false);
            }
            break;
            case KeyEvent.VK_D:
            {
                PlayerLocation.setRechts(false);
            }
            break;
            case KeyEvent.VK_W:
            {
                PlayerLocation.setUp(false);
            }
            break;
            case KeyEvent.VK_SPACE:
            {
                PlayerLocation.setUp(false);
            }
            break;
        }
    }
}
