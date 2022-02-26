import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	private Timer timer;
	private int delay = 8;
	private String guessedLetter = ""; //change to "" after testing
	private String displayWord = ""; //word to display on screen
	private String temp = ""; //this is the word you want to change (//change to "" after testing)
	private String word; 
	private String[] guess = new String[26]; //guessed letter
	private String[] incorrectGuess = new String[26]; //incorrect guessed letter
	private int wrongGuesses = 0;
	private int currentIndex = 0;
	private int incorrectIndex = 0;
	public Gameplay()
	{
		setUpWord();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer = new Timer(delay,this);
		timer.start();
	}
	
	public void setUpWord()
	{
		Scanner inputStream=null;
		try{
	          inputStream= new Scanner (new FileInputStream("word.txt"));
	       }
	       catch (FileNotFoundException e)
	       {
	     
	         System.out.println("no file named word.txt (it doesnt exist)");
	         System.exit(0);
	       }
		temp = inputStream.nextLine();
		word = temp.toUpperCase();
	}
	public void paint(Graphics g)
	{
		//draw hanging podium (its a noose btw)
		g.drawLine(50, 0, 50, 250);
		g.drawLine(0, 250, 100, 250);
		g.drawLine(50, 0, 155, 0);
		g.drawLine(155, 0, 155, 10);
		if(wrongGuesses>=1)
		{
			g.drawOval(100, 10, 110, 100); //head
		}
		if(wrongGuesses>=2)
		{
			g.drawLine(155, 110, 155, 180); //body
		}
		if(wrongGuesses>=3)
		{
			g.drawLine(155, 160, 115, 110); //left arm
		}
		if(wrongGuesses>=4)
		{
			g.drawLine(155, 160, 195, 110); //right arm
		}
		if(wrongGuesses>=5)
		{
			g.drawLine(155, 180, 115, 230); //left leg
		}
		if(wrongGuesses>=6)
		{
			g.drawLine(155, 180, 195, 230); //right leg
		}
		if(wrongGuesses>=7)
		{
			g.drawLine(130, 30, 130, 60);
		}
		if(wrongGuesses>=8)
		{
			g.drawLine(180, 30, 180, 60);
			g.setColor(Color.black);
			g.drawString("You didnt guess the word. The word was: " + word,50, 350);
			timer.stop();
		}
		
		for(int i=0; i<incorrectIndex; i++)
		{
			g.drawString(incorrectGuess[i], 230 + (20*i), 230);
		}
		for(int i=0; i<displayWord.length(); i++)
		{
			String letter = displayWord.substring(i,i+1);
			if(!(letter.equals("-")))
			{
				g.drawString(letter, 220 + (15*i), 200);
			}
			else
			{
				g.drawString(letter, 220 + (15*i), 210);
			}
			
		}
		g.drawRect(220, 220, 520, 20);
		
		
		
		
		if(displayWord.equals(word))
		{
			g.setColor(Color.black);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("Yay, the word was guessed",50, 350);
			timer.stop();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		setUpDisplay();
		repaint();
		if(!guessedLetter.equals(""))
		{
			if(!checkForDuplicateGuess())
			{
				checkCorrectGuess();
			}
		}
	}
	
	
	public void setUpDisplay()
	{
		if(displayWord.equals(""))
		{
			for(int i=0; i<word.length(); i++)
			{
				
				if(word.charAt(i) == ' ')
					displayWord+=" ";
				else
					displayWord+="-";
			}
		}
	}
	public void checkCorrectGuess()
	{
		boolean isCorrect = false;
		for(int i=0; i<word.length(); i++)
		{
			if(guessedLetter.equals(word.substring(i,i+1)))
			{
				String temp = word.substring(i,i+1);
				displayWord = displayWord.substring(0, i) + temp + displayWord.substring(i+1);
				isCorrect=true;
			}
		}
		if(isCorrect==false)
		{
			wrongGuesses++;
			incorrectGuess[incorrectIndex] = guessedLetter;
			incorrectIndex++;
		}
		
		guessedLetter = "";
	}
	public boolean checkForDuplicateGuess()
	{
		if(currentIndex != 0)
		{
			for(int i=0; i<guess.length; i++)
			{
				if(guessedLetter == guess[i])
				{
					guessedLetter = "";
					return true;
				}
			}
			
		}
		
		guess[currentIndex] = guessedLetter;
		currentIndex++;
		return false;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			guessedLetter = "A";
				
		}
		if(e.getKeyCode() == KeyEvent.VK_B)
		{
			guessedLetter = "B";
		}
		if(e.getKeyCode() == KeyEvent.VK_C)
		{
			guessedLetter = "C";
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			guessedLetter = "D";
		}
		if(e.getKeyCode() == KeyEvent.VK_E)
		{
			guessedLetter = "E";
		}
		if(e.getKeyCode() == KeyEvent.VK_F)
		{
			guessedLetter = "F";
		}
		if(e.getKeyCode() == KeyEvent.VK_G)
		{
			guessedLetter = "G";
		}
		if(e.getKeyCode() == KeyEvent.VK_H)
		{
			guessedLetter = "H";
		}
		if(e.getKeyCode() == KeyEvent.VK_I)
		{
			guessedLetter = "I";
		}
		if(e.getKeyCode() == KeyEvent.VK_J)
		{
			guessedLetter = "J";
		}
		if(e.getKeyCode() == KeyEvent.VK_K)
		{
			guessedLetter = "K";
		}
		if(e.getKeyCode() == KeyEvent.VK_L)
		{
			guessedLetter = "L";
		}
		if(e.getKeyCode() == KeyEvent.VK_M)
		{
			guessedLetter = "M";
		}
		if(e.getKeyCode() == KeyEvent.VK_N)
		{
			guessedLetter = "N";
		}
		if(e.getKeyCode() == KeyEvent.VK_O)
		{
			guessedLetter = "O";
		}
		if(e.getKeyCode() == KeyEvent.VK_P)
		{
			guessedLetter = "P";
		}
		if(e.getKeyCode() == KeyEvent.VK_Q)
		{
			guessedLetter = "Q";
		}
		if(e.getKeyCode() == KeyEvent.VK_R)
		{
			guessedLetter = "R";
		}
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			guessedLetter = "S";
		}
		if(e.getKeyCode() == KeyEvent.VK_T)
		{
			guessedLetter = "T";
		}
		if(e.getKeyCode() == KeyEvent.VK_U)
		{
			guessedLetter = "U";
		}
		if(e.getKeyCode() == KeyEvent.VK_V)
		{
			guessedLetter = "V";
		}
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			guessedLetter = "W";
		}
		if(e.getKeyCode() == KeyEvent.VK_X)
		{
			guessedLetter = "X";
		}
		if(e.getKeyCode() == KeyEvent.VK_Y)
		{
			guessedLetter = "Y";
		}
		if(e.getKeyCode() == KeyEvent.VK_Z)
		{
			guessedLetter = "Z";
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
