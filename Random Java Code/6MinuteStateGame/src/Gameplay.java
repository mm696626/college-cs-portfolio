import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{

	private Timer timer;
	private final int FPS = 60;
	private final int delay = 1000/FPS;
	private int timeUntilLose = 21600; //time is seconds * 60 (360 seconds (6 minutes)by default, 21600 frames)
	private String basedOn = "This is based on Chandler's Dumb State Game from Friends";
	
	private String[] correctStates = {"Alabama","Alaska","Arizona","Arkansas", "California", "Colorado", "Connecticut", "Delaware",
			  "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
			  "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
			  "Nevada", "New Hampshire","New Jersey","New Mexico","New York","North Carolina", "North Dakota", "Ohio",
			  "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah",
			  "Vermont","Virginia","Washington","West Virginia", "Wisconsin", "Wyoming"};
	private String[] guessedCorrect = new String[50];
	private String guessedState = "";
	private int correctCounter = 0;
	private int currentIndex = 0;
	
	private ImageIcon logo;
	
	private String display = "";
	private String display2 = "";
	private String display3 = "";
	private String display4 = "";
	private String display5 = "";
	private String display6 = "";
	private String display7 = "";
	private String display8 = "";
	private String display9 = "";
	private String display10 = "";
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
		g.setColor(Color.black);
		g.fillRect(0, 0, 700, 700);
		logo = new ImageIcon("textures/logo.png");
		logo.paintIcon(this, g, 0, 0);
		
		g.setColor(Color.white);
		
		g.drawString("Info", 520, 20);
		g.drawString(""+timeUntilLose/3600 + ":"+(timeUntilLose/60 - ((timeUntilLose/3600) * 60)), 520, 40);
		g.drawString("States you Guessed: " , 0, 100);
		g.drawString("You are guessing: ", 0, 80);
		g.drawString(guessedState, 105, 80);
		g.drawString(correctCounter+"/50",520,60);
		g.drawString(basedOn, 0, 320);
		
		g.drawString(display, 0,120);
		g.drawString(display2, 0, 140);
		g.drawString(display3, 0, 160);
		g.drawString(display4, 0, 180);
		g.drawString(display5, 0, 200);
		g.drawString(display6, 0, 220);
		g.drawString(display7, 0, 240);
		g.drawString(display8, 0, 260);
		g.drawString(display9, 0, 280);
		g.drawString(display10, 0, 300);
	}
	
	public boolean checkCorrect()
	{
		for(int i=0; i<correctStates.length; i++)
		{
			if(guessedState.equalsIgnoreCase(correctStates[i]))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean checkForDuplicates()
	{
		for(int i=0; i<guessedCorrect.length; i++)
		{
			if(guessedCorrect[i] == null)
				return false;
			else
			{
				if(guessedCorrect[i].equalsIgnoreCase(guessedState))
					return true;
			}
		}
		return false;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		timeUntilLose--;
		repaint();
		
		if(checkCorrect())
		{
			if(!checkForDuplicates())
			{
				correctCounter++;
				guessedCorrect[currentIndex] = guessedState;
				if(currentIndex<5)
					display+=guessedState + " ";
				else if(currentIndex<10)
					display2+=guessedState + " ";
				else if(currentIndex<15)
					display3+=guessedState + " ";
				else if(currentIndex<20)
					display4+=guessedState + " ";
				else if(currentIndex<25)
					display5+=guessedState + " ";
				else if(currentIndex<30)
					display6+=guessedState + " ";
				else if(currentIndex<35)
					display7+=guessedState + " ";
				else if(currentIndex<40)
					display8+=guessedState + " ";
				else if(currentIndex<45)
					display9+=guessedState + " ";
				else if(currentIndex<50)
					display10+=guessedState + " ";
				guessedState = "";
				currentIndex++;
				
			}
				
		}
		if(correctCounter==50)
		{
			timer.stop();
		}
		if(timeUntilLose<=0)
		{
			timer.stop();
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			guessedState += "A";
				
		}
		if(e.getKeyCode() == KeyEvent.VK_B)
		{
			guessedState += "B";
		}
		if(e.getKeyCode() == KeyEvent.VK_C)
		{
			guessedState += "C";
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			guessedState += "D";
		}
		if(e.getKeyCode() == KeyEvent.VK_E)
		{
			guessedState += "E";
		}
		if(e.getKeyCode() == KeyEvent.VK_F)
		{
			guessedState += "F";
		}
		if(e.getKeyCode() == KeyEvent.VK_G)
		{
			guessedState += "G";
		}
		if(e.getKeyCode() == KeyEvent.VK_H)
		{
			guessedState += "H";
		}
		if(e.getKeyCode() == KeyEvent.VK_I)
		{
			guessedState += "I";
		}
		if(e.getKeyCode() == KeyEvent.VK_J)
		{
			guessedState += "J";
		}
		if(e.getKeyCode() == KeyEvent.VK_K)
		{
			guessedState += "K";
		}
		if(e.getKeyCode() == KeyEvent.VK_L)
		{
			guessedState += "L";
		}
		if(e.getKeyCode() == KeyEvent.VK_M)
		{
			guessedState += "M";
		}
		if(e.getKeyCode() == KeyEvent.VK_N)
		{
			guessedState += "N";
		}
		if(e.getKeyCode() == KeyEvent.VK_O)
		{
			guessedState += "O";
		}
		if(e.getKeyCode() == KeyEvent.VK_P)
		{
			guessedState += "P";
		}
		if(e.getKeyCode() == KeyEvent.VK_Q)
		{
			guessedState += "Q";
		}
		if(e.getKeyCode() == KeyEvent.VK_R)
		{
			guessedState += "R";
		}
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			guessedState += "S";
		}
		if(e.getKeyCode() == KeyEvent.VK_T)
		{
			guessedState += "T";
		}
		if(e.getKeyCode() == KeyEvent.VK_U)
		{
			guessedState += "U";
		}
		if(e.getKeyCode() == KeyEvent.VK_V)
		{
			guessedState += "V";
		}
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			guessedState += "W";
		}
		if(e.getKeyCode() == KeyEvent.VK_X)
		{
			guessedState += "X";
		}
		if(e.getKeyCode() == KeyEvent.VK_Y)
		{
			guessedState += "Y";
		}
		if(e.getKeyCode() == KeyEvent.VK_Z)
		{
			guessedState += "Z";
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			guessedState += " ";
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
		{
			if(guessedState.length()>0)
				guessedState = guessedState.substring(0, guessedState.length()-1);
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
