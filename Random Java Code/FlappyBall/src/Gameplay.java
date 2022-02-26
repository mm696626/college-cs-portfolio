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
	
	Random rng = new Random();
	private Timer timer;
	private int delay = 8;
	
	private boolean flapReady = true;
	private int ballX = 100;
	private int ballY = 100;
	private int pipeSpeed = 3;
	private int pipeX = 0;
	
	private int pipe1Length;
	private int pipe2Length;
	
	private int pipe1Y=0;
	private int pipe2Y=300;
	private int newPipe2Y = 300;
	
	private int score = -1;
	
	
	
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
		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 695, 592);
		
		
		g.setColor(Color.red);
		g.fillOval(ballX, ballY, 20, 20);
		
		
		g.setColor(Color.green);
		g.fillRect(pipeX, pipe1Y, 20, pipe1Length);
		
		
		g.fillRect(pipeX, newPipe2Y, 20, pipe2Length);
		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString(""+score, 300, 30);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		ballY+=2;
		pipeX-=pipeSpeed;
		
		
		
		if(ballY>=550)
		{
			timer.stop();
		}
		if(new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(pipeX,pipe1Y,20,pipe1Length)))
		{
			timer.stop();
		}
		if(new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(pipeX,newPipe2Y,20,pipe2Length)))
		{
			
			timer.stop();
		}
		if(pipeX<=0)
		{
			pipeX=500;
			score++;
			if(score%10==0 && score !=0)
			{
				pipeSpeed++;
			}
			newPipe2Y = pipe2Y + rng.nextInt(50)+1;
			pipe1Length=rng.nextInt(135)+150;
			pipe2Length=530-newPipe2Y + rng.nextInt(30);
			while(pipe1Length+pipe2Length > 470)
			{
				newPipe2Y = pipe2Y + rng.nextInt(50)+1;
				pipe1Length=rng.nextInt(135)+150;
				pipe2Length=530-newPipe2Y + rng.nextInt(30);
			}
		}
		
		if(ballY<=0)
		{
			ballY = 0;
		}
		repaint();
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE && flapReady == true)
		{
			ballY-=65;
			flapReady = false;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			flapReady = true;
		}
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
