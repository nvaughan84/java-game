package Pong;
import java.awt.*;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Game extends JPanel implements KeyListener{
	
	Ball ball;
	Paddle paddle;
	Brick brick;
	Fire bullet;
	ArrayList<Fire> bullets;
	ArrayList<Brick> bricks;
	boolean paddleLeft;
	boolean paddleRight;
	
	public Game()
	{
		addKeyListener(this);
		this.setFocusable(true);		
		
		this.setDoubleBuffered(true);
		
		createUI();	
		
		//Initialize components
		bullets = new ArrayList<Fire>();
		this.ball = new Ball(1,150,20,20, 1, 1, this);
		this.paddle = new Paddle(0,200,50,5, 1, 0, this);
		createBricks(30, 20);
		
		//create game screen and loop
			
		gameLoop();
	}
	
	public void createBricks(int brickWidth, int border)
	{
		bricks = new ArrayList<Brick>();
		int frameWidth = this.getWidth();
		//calculate the number of bricks based on the frame width, border size and brick width
		int noOfBricks = (int)Math.floor((frameWidth-2*border)/brickWidth);
		
		//top level
		for(int i = 0; i<noOfBricks; i++)
		{
			bricks.add(new Brick(border+(i*brickWidth), 20, brickWidth, 10, 1));
		}
		
		//second level
		for(int i = 0; i<noOfBricks; i++)
		{
			bricks.add(new Brick(border+(i*brickWidth), 60, brickWidth, 10, 2));
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();		
		if(keyCode==KeyEvent.VK_RIGHT) //right
		{
			paddleRight = true;
					}
		if(keyCode==KeyEvent.VK_LEFT)//left
		{
			paddleLeft = true;
		}
		if(keyCode==KeyEvent.VK_SPACE)//left
		{
			bullets.add(new Fire(paddle));
		}
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		int keyCode = e.getKeyCode();		
		if(keyCode==KeyEvent.VK_RIGHT) //right
		{
			paddleRight = false;
		}
		if(keyCode==KeyEvent.VK_LEFT)//left
		{
			paddleLeft = false;
		}
	}
	
	public void keyTyped(KeyEvent e)
	{
		
	}
	   
	public void createUI()
	{
		JFrame frame = new JFrame("Mini Tennis");
		frame.add(this);
		frame.setSize(600, 300);
		frame.setVisible(true);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void gameLoop()
	{
		while(true)
		{
			ball.move(2,2);
			
			//check if paddle should be moving left/right and update accordingly
			if(paddleRight)	paddle.setX(paddle.getX()+5);	//need to set move speed (for powerups etc)		
			if(paddleLeft) paddle.setX(paddle.getX()-5);			
			
			//if ball hits paddle, reverse direction. Need to determine which side of paddle was hit
			if(ball.intersected(paddle))
			{
				ball.setDirectionY(-1);
			}
			
			//iterate over the Bricks array list, check if collision occurred and remove the brick involved
			for (Iterator<Brick> iter = bricks.iterator(); iter.hasNext();) {
			      Brick s = iter.next();
			      if (ball.intersected(s)) {
			    	  s.reduceStrength(1); //if hit, reduce the strength of the block
			    	  if(s.getStrength()==0) iter.remove(); //if block strength is 0, remove
			    	  ball.setDirectionY(-1*ball.getDirectionY());
			    	  break;
			      }			      
			    }
			
			for (Iterator<Fire> iter = bullets.iterator(); iter.hasNext();) {
			      Fire b = iter.next();
			      if (ball.intersected(b)) {
			    	 if(b.offScreen()) bullets.remove(b);
			      }			      
			    }

			for(Fire f : bullets)
			{
				f.move(5);
			}
			
			
			this.setBackground(Color.BLACK);
			this.repaint();
			try{
			    Thread.sleep(10);
			}catch(InterruptedException e){
			    System.out.println("got interrupted!");
			}
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		ball.render(g);
		paddle.render(g);
		for(Brick b : bricks)
		{
			b.render(g);
		}
		
		for(Fire f : bullets)
		{
			f.render(g);
		}
	}

	public static void main(String[] args) {
		
		new Game(); //initialize game
	}

}
