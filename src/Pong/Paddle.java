package Pong;

import java.awt.*;

public class Paddle extends GameItem{
	
	int directionX;
	int directionY;
	Game game;
	
	public Paddle(int x, int y, int width, int height, int directionX, int directionY, Game game)
	{
		
		super(x, y, width, height);
		this.directionX = directionX;
		this.directionY = directionY;
		this.game = game;
	}
	
	
	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.fillRect(this.x, this.y, this.width, this.height);
	}
	
	public void move(int x, int y)
	{
//		this.directionX = this.directionX*directionX;
//		this.directionY = this.directionY*directionY;
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
