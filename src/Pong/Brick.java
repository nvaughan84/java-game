package Pong;

import java.awt.*;


public class Brick extends GameItem {
	
	int strength = 1;
	
	public Brick(int x, int y, int width, int height, int strength)
	{
		super(x, y, width, height);
		this.strength = strength;
	}
	
	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GREEN);
		g2d.fillRect(this.x, this.y, this.width, this.height);
	}
	
	public void reduceStrength(int amount)
	{
		this.strength = this.strength - amount;
		if(this.strength<0) this.strength = 0;
	}
	
	public int getStrength()
	{
		return this.strength;
	}
	
}
