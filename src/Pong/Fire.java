package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Fire extends GameItem {
	
	public Fire(Paddle paddle)
	{		
		super(paddle.getX()+(int)paddle.getWidth()/2, paddle.getY(), 10, 10);
	}
	
	public void move(int speed)
	{
		this.y = this.y-speed;
	}
	
	public boolean offScreen()
	{
		if(this.getY()+this.getHeight() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GREEN);
		g2d.fillRect(this.x, this.y, this.width, this.height);
	}

}
