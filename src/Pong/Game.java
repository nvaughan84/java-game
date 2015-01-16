package Pong;
import java.awt.*;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Game extends JPanel implements KeyListener{
	
	Ball ball;
	Ball ball2;
	Paddle paddle;
	Brick brick;
	ArrayList<Brick> bricks;
	boolean paddleLeft;
	boolean paddleRight;
	
	public Game()
	{
		addKeyListener(this);
		this.setFocusable(true);
		createBricks();
		
		this.setDoubleBuffered(true);
		
		//Initialize components
		this.ball = new Ball(1,150,20,20, 1, 1, this);
		this.paddle = new Paddle(0,200,50,5, 1, 0, this);
		
		
		//create game screen and loop
		createUI();		
		gameLoop();
	}
	
	public void createBricks()
	{
		bricks = new ArrayList<Brick>();
		int border = 20;
		
		//top level
		for(int i = 0; i<14; i++)
		{
			bricks.add(new Brick(border+(i*40), 20, 40, 10));
		}
		
		//second level
		for(int i = 0; i<14; i++)
		{
			bricks.add(new Brick(border+(i*40), 60, 40, 10));
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
		//System.out.println(e);
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
			
			if(paddleRight)
			{
				paddle.setX(paddle.getX()+5);
			}
			if(paddleLeft)
			{
				paddle.setX(paddle.getX()-5);
			}
					
			if(ball.intersected(paddle))
			{
				ball.setDirectionY(-1);
			}
//			for(Brick b : bricks)
//			{
//				if(ball.intersected(b))
//				{
//					//b.remove();
//				}
//			}
			for (Iterator<Brick> iter = bricks.iterator(); iter.hasNext();) {
			      Brick s = iter.next();
			      if (ball.intersected(s)) {
			        iter.remove();
			        ball.setDirectionY(-1*ball.getDirectionY());
			        break;
			      }			      
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
	}

	public static void main(String[] args) {
		
		new Game();
	}

}
