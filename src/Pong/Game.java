package Pong;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game extends JPanel implements KeyListener{
	
	Ball ball;
	Ball ball2;
	Paddle paddle;
	Brick brick;
	ArrayList<Brick> bricks;
	
	public Game()
	{
		addKeyListener(this);
		this.setFocusable(true);
		createBricks();
		
		//Initialize components
		this.ball = new Ball(1,1,20,20, 1, 1, this);
		this.paddle = new Paddle(0,200,50,5, 1, 0, this);
		
		
		//create game screen and loop
		createUI();		
		gameLoop();
	}
	
	public void createBricks()
	{
		bricks = new ArrayList<Brick>();
		for(int i = 0; i<20; i++)
		{
			bricks.add(new Brick(20*i, 20, 20, 5));
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		System.out.println(keyCode);
		if(keyCode==KeyEvent.VK_RIGHT) //right
		{
			paddle.move(20,0);
		}
		if(keyCode==KeyEvent.VK_LEFT)//left
		{
			paddle.move(-20,0);
		}
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		System.out.println(e);
	}
	
	public void keyTyped(KeyEvent e)
	{
		System.out.println(e);
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
			
					
			if(ball.intersected(paddle))
			{
				ball.setDirectionY(-1);
			}
			for(Brick b : bricks)
			{
				if(ball.intersected(b))
				{
					System.out.println(b.getX());
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
