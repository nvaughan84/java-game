package Pong;

import java.awt.*;

public class GameItem {
	
	int width;
	int height;
	int x;
	int y;
;
	
	public GameItem(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;		
	}
	
	public void render(Graphics g)
	{
		
	}
	
	
	
	public Rectangle getBounds()
	{
		return new Rectangle(this.x, this.y, this.width, this.height);
	}
	
	
	public boolean intersected(GameItem item)
	{
		if(this.getBounds().intersects(item.getBounds()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void getY(int y)
	{
		this.y = y;
	}

}
