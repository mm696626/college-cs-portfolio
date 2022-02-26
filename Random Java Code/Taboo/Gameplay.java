import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{

	private Timer timer;
	private final int FPS = 30;
	private final int delay = 1000/FPS;
	

	private int team1Score = 0;
	private int team2Score = 0;


	private int seconds = 60;

	private int timeLeft = FPS * seconds; //timeLeft on timer
	private int currentCard = 0; //index of current card

	private ArrayList<String> words = new ArrayList<String>();
	private ArrayList<String> tabooWords = new ArrayList<String>();

	private boolean startUpGame = true; //initialize the game

	private String wordToDisplay = "";

	private String tabooWord = "";
	private String tabooWord2 = "";
	private String tabooWord3 = "";
	private String tabooWord4 = "";
	private String tabooWord5 = "";


	private boolean getNewCard = true;

	private boolean team1Turn = true; //is it team 1's turn
	private int playerNumTurn = 1; //whose turn it is on the team



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
		g.setColor(Color.blue);
		g.fillRect(0, 0, 800, 700);

		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD,25));

		g.drawString("Time left: "+((timeLeft/30)+1), 400,50);
		g.drawString(wordToDisplay, 0,50);
		g.drawString(tabooWord, 0, 200);
		g.drawString(tabooWord2, 0, 250);
		g.drawString(tabooWord3, 0, 300);
		g.drawString(tabooWord4, 0, 350);
		g.drawString(tabooWord5, 0, 400);
		g.drawString("Team 1 Score: " + team1Score, 400,130);
		g.drawString("Team 2 Score: " + team2Score, 400,180);


		g.drawString("Escape if they said one of the taboo words", 0, 500);
		g.drawString("Enter if they got it", 0, 550);

		if(team1Turn == true)
		{
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("It's team 1's turn", 400,80);
		}
		else
		{
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("It's team 2's turn", 400,80);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();

		if(startUpGame == true)
		{
			startGame();
			startUpGame = false;
		}

		if(getNewCard == true)
		{
			getWord();
			getTabooWords();
			getNewCard=false;
		}

		timeLeft--;
		if(timeLeft<=0)
		{
			if(team1Turn==true)
			{
				team1Turn=false;
				timeLeft = FPS*seconds;
			}
			else
			{
				team1Turn=true;
				timeLeft = FPS*seconds;
			}
		}

		repaint();
	}

	
	public void startGame()
	{

		//get words
		Scanner inputStream=null;
		try{
	          inputStream= new Scanner (new FileInputStream("words.txt"));
	       }
	    catch (FileNotFoundException e)
	       {
	     
	          System.out.println("no file named words.txt (it doesnt exist)");
	          System.exit(0);
	       }
		
		while(inputStream.hasNextLine())
			words.add(inputStream.nextLine());


		inputStream.close();

		
		
		//get taboo words
		try{
	          inputStream= new Scanner (new FileInputStream("taboowords.txt"));
	       }
	    catch (FileNotFoundException e)
	       {
	     
	          System.out.println("no file named taboowords.txt (it doesnt exist)");
	          System.exit(0);
	       }
		
		while(inputStream.hasNextLine())
			tabooWords.add(inputStream.nextLine());

		
		inputStream.close();
	}
	public void getWord()
	{
		if(currentCard<words.size())
		{
			wordToDisplay = words.get(currentCard);
		}
		else
		{
			currentCard=0;
			wordToDisplay = words.get(currentCard);
		}


	}
	
	public void getTabooWords()
	{
		//no need to check for IndexOutOfBounds as the first call resets if such an error were to occur
		tabooWord = tabooWords.get(currentCard * 5);
		tabooWord2 = tabooWords.get((currentCard * 5) + 1);
		tabooWord3 = tabooWords.get((currentCard * 5) + 2);
		tabooWord4 = tabooWords.get((currentCard * 5) + 3);
		tabooWord5 = tabooWords.get((currentCard * 5) + 4);
	}
	
	
	

	
	@Override
	public void keyPressed(KeyEvent e) {


		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			if(team1Turn == true)
			{
				team1Score++;
			}
			else
			{
				team2Score++;
			}
			getNewCard = true;
			currentCard++;
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			if(team1Turn == true)
			{
				team2Score++;
			}
			else
			{
				team1Score++;
			}
			getNewCard = true;
			currentCard++;
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
