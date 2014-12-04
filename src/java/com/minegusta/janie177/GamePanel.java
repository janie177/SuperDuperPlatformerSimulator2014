package com.minegusta.janie177;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

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

        //Add key listener.
        addKeyListener(this);
		setPreferredSize(new Dimension(width, height));

        setFocusable(true);
        requestFocus();
        requestFocusInWindow();

		makeThread();
		

	}
	
	//laad de thread en register de listeners
	private void makeThread()
	{
        //Register het bij het "parent" object.
        super.addNotify();

		if(thread == null)
		{
            //Maak een nieuwe thread al deze nog niet bestaat.
			thread = new Thread(this);
		}
		thread.start();
	}
	
	@Override
	public void run() 
	{
        System.out.println("Width is " + width);
        System.out.println("height is" + height);
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g2d = (Graphics2D) image.getGraphics();

        BackGround bg = new BackGround()

        //drawing stuff
		draw();
		updateScreen();

        //TODO REMOVE
        g2d.setBackground(Color.RED);


		
		//Laat de thread slapen om de gewenste FPS te krijgen.
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
