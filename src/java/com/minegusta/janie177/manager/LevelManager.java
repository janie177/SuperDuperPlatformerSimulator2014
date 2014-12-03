package com.minegusta.janie177.manager;

import java.awt.Graphics2D;

public abstract class LevelManager
{
	private String level;

    //Lege constructor zodat de abstracte classes geen input nodig hebben.
    public LevelManager(){}

	public LevelManager(String level)
	{
		this.level = level;
	}
	
	
	//methods

    //Teken de obstakels en monsters die per level weer verschillen.
	public void draw(Graphics2D g2d)
	{
        Level.valueOf(level).getLevel().draw(g2d);
	}

    //Het bewegen van de speler dat voor elk level het zelfde is. Dit gebeurt dus gewoon hier.
	
	public void moveUp(Graphics2D g2d)
	{

	}
	public void moveDown(Graphics2D g2d)
	{

	}
	public void moveLeft(Graphics2D g2d)
	{

	}
	public void moveRight(Graphics2D g2d)
	{

	}

}
