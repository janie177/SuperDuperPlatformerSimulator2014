package com.minegusta.janie177;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.minegusta.janie177.Levels.LevelUp;
import com.minegusta.janie177.background.BackGround;
import com.minegusta.janie177.manager.LevelManager;

public class GamePanel extends JPanel implements Runnable, KeyListener
{
	//Schaal zodat het makkelijker is om straks de grootte van het scherm snel te veranderen.
	private static int scale = 15;
	
	public static int height = 40 * scale;
	public static int width = 80 * scale;
	
	private Thread thread;
	
	private Image image;

    private boolean aan = false;

	private Graphics2D g2d;
	
	private int fps = 30;
	
	//Het aantal miliseconden dat de thread moet wachten om de gewenste FPS te krijgen.
	private long wait = fps/1000;

    //Het level waarin je zit.
    private String level = "L1";

    private LevelManager manager = new LevelManager(level);
	
	//De constructor
	public GamePanel()
	{
		//Run de constructor van de super class
		super();
		setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
	}
	
	//laad de thread en register de listeners met deze standaard naam (addnotify).
	public void addNotify()
	{
        //Register het bij het "parent" object.
        super.addNotify();

		if(thread == null)
		{
            //Maak een nieuwe thread als deze nog niet bestaat.
			thread = new Thread(this);
            //Voeg deze class toe als keylistener
            addKeyListener(this);
		}
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
        Graphics g = getGraphics();
        g.drawImage(image, width, height, null);
        g.setColor(Color.RED);
        g.drawString("lolol", 30, 30);
        g.dispose();
    }

    //Luister naar keys die ingedrukt worden.

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //Luister hier naar lopen en springen.
    @Override
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyChar())
        {
            case KeyEvent.VK_A: manager.moveLeft(g2d);
                break;
            case KeyEvent.VK_S: manager.moveDown(g2d);
                break;
            case KeyEvent.VK_D: manager.moveRight(g2d);
                break;
            case KeyEvent.VK_W: manager.moveUp(g2d);
                break;
            case KeyEvent.VK_SPACE: manager.moveUp(g2d);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
