package Pong;

import java.awt.*;

import Pong.GameItem;

public class Ball extends GameItem{

	int directionX;
	int directionY;
	Game game;
	
	public Ball(int x, int y, int width, int height, int directionX, int directionY, Game game)
	{
		super(x, y, width, height);
		this.directionX = directionX;
		this.directionY = directionY;
		this.game = game;
	}
	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.fillOval(this.x, this.y, 30, 30);
	}
	
	public void move(int x, int y)
	{
		//System.out.println(this.getBounds().y);
		
		//if ball hits right of frame
		if(this.getBounds().x+this.getBounds().getWidth() > this.game.getWidth())
		{
			setDirectionX(-1*this.directionX); //reverse x direction
		}
		//if ball hits left of frame
		if(this.getBounds().x < this.game.getX())
		{
			setDirectionX(-1*this.directionX); //reverse x direction
		}
		if(this.getBounds().y < this.game.getY())
		{
			setDirectionY(-1*this.directionY);
		}
		if(this.getBounds().y + this.getHeight() > this.game.getHeight())
		{
			setDirectionY(-1*this.directionY);
		}
		
		//System.out.println(this.directionY);
		
		this.x = this.x+x*this.directionX;
		this.y = this.y+y*this.directionY;
	}
	
	public int getDirectionX()
	{
		return this.directionX;
	}
	
	public int getDirectionY()
	{
		return this.directionY;
	}
	
	public void setDirectionX(int directionX)
	{
		this.directionX = directionX;
	}
	
	public void setDirectionY(int directionY)
	{
		this.directionY = directionY;
	}
	
}
