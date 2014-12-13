package com.minegusta.janie177;

import com.minegusta.janie177.data.Storage;
import com.minegusta.janie177.levels.LevelUp;
import com.minegusta.janie177.manager.LevelManager;
import com.minegusta.janie177.speler.PlayerStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

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
	private Graphics2D g2d;
	private int fps = 120;
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

    private static int loadInterval = -1;

	@Override
	public void run() 
	{
        while(aan)
        {
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            g2d = (Graphics2D) image.getGraphics();

            //Deze methoden moeten altijd eerst updaten

            //Update de spelers locatie en snelheid
            PlayerStatus.update();


            //Update alle objecten

            if(loadInterval < 0) {
                loadInterval = 30;
                Storage.updateLoadedObjects();
            }
            loadInterval--;
            //Teken methode voor de wereld, speler en entities. Wordt doorgegeven aan de level class.
            draw();

            //Teken alles op het scherm zelf
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

    //Level up als een
    public void levelUp()
    {
        //Zet de level manager hier omhoog naar het volgende level.
        level = LevelUp.up(level);
        manager = new LevelManager(level);
    }


	private void updateScreen()
    {
        //Check hier of het scherm geen null meer is. Soms is dit het geval bij het opstarten.
        if(getGraphics() == null) return;
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
                PlayerStatus.setLeft(true);
            }
                break;
            case KeyEvent.VK_S:
            {
                PlayerStatus.setDown(true);
            }
                break;
            case KeyEvent.VK_D:
            {
                PlayerStatus.setRight(true);
            }
                break;
            case KeyEvent.VK_W:
            {
                PlayerStatus.jump();
            }
                break;
            case KeyEvent.VK_SPACE:
            {
                PlayerStatus.jump();
            }
                break;
            case KeyEvent.VK_SHIFT:
            {
                PlayerStatus.setSprint(true);
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
                PlayerStatus.setLeft(false);
            }
            break;
            case KeyEvent.VK_S:
            {
                PlayerStatus.setDown(false);
            }
            break;
            case KeyEvent.VK_D:
            {
                PlayerStatus.setRight(false);
            }
            break;
            case KeyEvent.VK_SHIFT:
            {
                PlayerStatus.setSprint(false);
            }
            break;
        }
    }
}
