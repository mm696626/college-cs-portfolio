import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

	
	private Random rng = new Random();
	private Timer timer;
	private boolean play = false;
	private boolean CPUMode = false;
	
	private int delay = 8;
	private int player1X = 75;
	private int player2X = 610;
	
	private int player1Y = 315;
	private int player2Y = 315;
	
	private int player1score = 0;
	private int player2score = 0;
	
	private boolean player1win = false;
	private boolean player2win = false;
	
	
	private int ballposX = 335;
	private int ballposY = 350;
	private int ballXdir = -3;
	private int ballYdir = -2;
	
	
	public Gameplay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer = new Timer(delay,this);
		timer.start();
	}

	
	public void paint(Graphics g)
	{
		
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, 695, 592);
		
		if(!play)
		{
			
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("Press 1 for CPU, and 2 for Human", 150, 100);
			
		}
		
		//the paddles
		g.setColor(Color.white);
		g.fillRect(player1X, player1Y, 8, 70);
		g.fillRect(player2X, player2Y, 8, 70);
		
		//the ball
		g.setColor(Color.white);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		//the scores
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString(""+player1score,200, 30);
		g.drawString(""+player2score,500, 30);
		
		//winning messages
		if(player1win)
		{
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("Player 1 won",250, 200);
		}
		if(player2win)
		{
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("Player 2 won",250, 200);
		}
		
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play)
		{
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(player1X,player1Y,8,70)))
			{
				ballXdir = -ballXdir;
				
			}
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(player2X,player2Y,8,70)))
			{
				ballXdir = -ballXdir;
				
			}
			
			if(CPUMode == true)
			{
				if(ballposY > player2Y)
				{
					if(player2Y >560)
					{
						player2Y = 560;
					}
					else
					{
						player2Y+=2;
					}
				}
				
				if(ballposY < player2Y)
				{
					if(player2Y <=0)
					{
						player2Y = 0;
						
					}
					else
					{
						player2Y -=2;
					}
				}
				
			}
			ballposX+=ballXdir;
			ballposY+=ballYdir;
			if(ballposX < 0)
			{
				player2score++;
				ballposX = 335;
				ballposY = 350;
				setBallSpeed();
				
			}
			if(ballposX > 670)
			{
				player1score++;
				ballposX = 335;
				ballposY = 350;
				setBallSpeed();
				
			}
			if(ballposY < 0)
			{
				ballYdir = -ballYdir;
			}
			if(ballposY>560)
			{
				ballYdir = -ballYdir;
			}
			
			if(player1score >= 11)
			{
				player1win = true;
				play = false;
				
				player1score = 0;
				player2score = 0;
				ballposX = 335;
				ballposY = 350;
				setBallSpeed();

			}
			if(player2score >= 11)
			{
				player2win = true;
				play = false;
				
				player1score = 0;
				player2score = 0;
				ballposX = 335;
				ballposY = 350;
				
				
			}
			repaint();
		}
		
		
	}

	public void setBallSpeed()
	{
		int Xdir = rng.nextInt(2);
		int Ydir = rng.nextInt(2);
		
		if(Xdir==0)
			ballXdir = 3;
		if(Xdir==1)
			ballXdir = -3;
		
		if(Ydir==0)
			ballYdir = 2;
		if(Ydir==1)
			ballYdir = -2;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_1)
		{
			CPUMode = true;
			if(!play)
			{
				play = true;
				player1win = false;
				player2win = false;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_2)
		{
			if(!play)
			{
				play = true;
				player1win = false;
				player2win = false;
			}
			CPUMode = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			
			if(player1Y <=0)
			{
				player1Y = 0;
				
			}
			else
			{
				player1Y -=40;
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			
			if(player1Y >560)
			{
				player1Y = 560;
				
			}
			else
			{
				player1Y+=40;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP && CPUMode == false) {
			if(player2Y <=0)
			{
				player2Y = 0;
				
			}
			else
			{
				player2Y -=40;
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN && CPUMode == false) {
			if(player2Y >560)
			{
				player2Y = 560;
			}
			else
			{
				player2Y+=40;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
