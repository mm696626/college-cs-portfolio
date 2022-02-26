import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{

	private Timer timer;
	private final int FPS = 60; 
	private final int delay = 1000/FPS;
	private Board b = new Board();


	
	private int cursorX = 1;
	private int cursorY = 1;

	private boolean startUpGame = true; //intialize the game
	
	private int playerNumTurn = 1; //whose turn it is

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
		//blue background
		g.setColor(Color.green);
		g.fillRect(0, 0, 800, 900);

		for(int i=0; i<8; i++)
		{
			//draw vertical lines
			g.setColor(Color.black);
			g.drawLine((i+1)*88, 0 , (i+1)*88,700);

			//draw vertical lines
			g.setColor(Color.black);
			g.drawLine(0, (i+1)*88 , 700,(i+1)*88);



		}

		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				if(b.getPiece(i,j) == 2)
				{
					g.setColor(Color.black);
					g.fillOval((i)*88,(j)*88, 80,80);
				}

				if(b.getPiece(i,j) == 3)
				{
					g.setColor(Color.white);
					g.fillOval((i)*88,(j)*88, 80,80);
				}
			}
		}

		g.setColor(Color.red);
		g.drawRect(cursorX*88, cursorY*88, 88,88);

		
		

		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		repaint();
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(cursorX<7)
				cursorX++;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(cursorX>0)
				cursorX--;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			if(cursorY>0)
				cursorY--;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if(cursorY<7)
				cursorY++;
		}

		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			b.placePiece(cursorX,cursorY);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
