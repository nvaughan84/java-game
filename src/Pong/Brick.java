package Pong;

import java.awt.*;


public class Brick extends GameItem {
	

	
	public Brick(int x, int y, int width, int height)
	{
		super(x, y, width, height);
	}
	
	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GREEN);
		g2d.fillRect(this.x, this.y, this.width, this.height);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(this.x, this.y, this.width, this.height);
	}
}
