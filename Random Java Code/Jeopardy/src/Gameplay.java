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
	private Random rng = new Random();
	
	private int cursorX = 1;
	private int cursorY = 1;
	
	private int answerCursor = 1;
	
	private boolean isDailyDouble = false; //whether or not its a daily double
	
	private int dailyDoubleX = 1;
	private int dailyDoubleY = 1;
	
	
	private int winningTeam = 1; //the team who won
	private boolean winnerFound = false;
	
	private int questionX = 1;
	private int questionY = 1;
	
	private String currentQuestion = "";
	private String currentAnswer = "";

	private int playerCount = 3; //number of players/teams
	private int[] playerScores = new int[playerCount];
	
	
	
	private boolean startUpGame = true; //intialize the game
	
	private int playerNumTurn = 1; //whose turn it is
	
	private boolean[][] answered = new boolean[6][5]; //represents which questions have been answered
	private String[] categoryNames = new String[6]; //category names
	private String[][] questions = new String[6][5]; //category names
	private String[][] answers = new String[6][5]; //category names
	private int[][] pointValues = new int[6][5]; //point values
	
	private boolean answeringQuestion = false; //if player is answering question
	private boolean showAnswer = false; //show the answer
	
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
		
		
		if(answeringQuestion==false && showAnswer==false && winnerFound == false)
		{
			
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("It's team " + playerNumTurn + "'s turn", 250, 30);
			g.drawString("Press enter to pick the question", 200, 570);
			
			//draw category names
			for(int i=0; i<categoryNames.length; i++)
			{
				g.setColor(Color.white);
				g.setFont(new Font("serif",Font.BOLD,10));
				g.drawString(categoryNames[i], (i+1)*100, 60);
			}
			
			for(int i=0; i<pointValues.length; i++)
			{
				g.setColor(Color.white);
				g.setFont(new Font("serif",Font.BOLD,15));
				for(int j=0; j<pointValues[0].length; j++)
				{
					if(answered[i][j] == false)
						g.drawString("" + pointValues[i][j], (i+1)*100, 30+((j+1)*80));

				}
			}
			
			for(int i=0; i<playerScores.length; i++)
			{
				g.drawString("Team " + (i+1) + ": " + playerScores[i] + " points", (i)*150, 500);
			}
			
			
			g.setColor(Color.red);
			g.drawRect((cursorX*100)-10, cursorY*80, 50, 50);
		}
		if(answeringQuestion==true)
		{
			
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,20));
			
			if(isDailyDouble)
				g.drawString("DAILY DOUBLE", 20, 50);
			
			g.drawString(currentQuestion, 20, 100);
			g.drawString("Press Space to continue", 200, 550);
			
			
		}
		if(showAnswer==true)
		{
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,20));
			g.drawString(currentAnswer, 20, 100);
			
			
			g.drawString("Did you get the answer correct", 100, 450);
			g.drawString("Yes", 100, 500);
			g.drawString("No", 200, 500);
			
			g.drawRect((answerCursor*100)-10, 460, 50, 50);
			g.drawString("Press Space to confirm", 200, 550);
		}
		
		if(winnerFound == true)
		{
			//blue background
			g.setColor(Color.blue);
			g.fillRect(0, 0, 800, 700);
			
			g.setColor(Color.black);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("The winner is: " + "Team " + winningTeam, 200, 100);
			
			for(int i=0; i<playerScores.length; i++)
			{
				g.drawString("Team " + (i+1) + " with " + playerScores[i] + " points", 200, (i+2)*100);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		if(startUpGame==true)
		{
			startGame();
			startUpGame=false;
		}
		
		if(checkBoardClear() == true && showAnswer == false)
		{
			int maxScore = playerScores[0];
			for(int i=1; i<playerScores.length; i++)
			{
				if(playerScores[i]>maxScore)
				{
					maxScore = playerScores[i];
					winningTeam = (i+1);
				}
			}
			winnerFound = true;
			repaint();
			timer.stop();
		}
		
		repaint();
	}

	
	public void startGame()
	{
		
		//get categories
		Scanner inputStream=null;
		try{
	          inputStream= new Scanner (new FileInputStream("categories.txt"));
	       }
	    catch (FileNotFoundException e)
	       {
	     
	          System.out.println("no file named categories.txt (it doesnt exist)");
	          System.exit(0);
	       }
		
		for(int i=0; i<categoryNames.length; i++)
		{
			if(inputStream.hasNextLine())
				categoryNames[i] = inputStream.nextLine();
		}
		
		
		inputStream.close();

		
		
		//get questions
		try{
	          inputStream= new Scanner (new FileInputStream("questions.txt"));
	       }
	    catch (FileNotFoundException e)
	       {
	     
	          System.out.println("no file named questions.txt (it doesnt exist)");
	          System.exit(0);
	       }
		
		for(int i=0; i<questions.length; i++)
		{
			for(int j=0; j<questions[0].length; j++)
			{
				if(inputStream.hasNextLine())
					questions[i][j] = inputStream.nextLine();
			}
		}
		
		//get answers
				try{
			          inputStream= new Scanner (new FileInputStream("answers.txt"));
			       }
			    catch (FileNotFoundException e)
			       {
			     
			          System.out.println("no file named answers.txt (it doesnt exist)");
			          System.exit(0);
			       }
				
				for(int i=0; i<answers.length; i++)
				{
					for(int j=0; j<answers[0].length; j++)
					{
						if(inputStream.hasNextLine())
							answers[i][j] = inputStream.nextLine();
					}
				}
		inputStream.close();
		
		for(int i=0; i<answered.length; i++)
		{
			for(int j=0; j<answered[0].length; j++)
			{
				answered[i][j] = false;
			}
		}
		
		for(int i=0; i<pointValues.length; i++)
		{
			for(int j=0; j<pointValues[0].length; j++)
			{
				pointValues[i][j] = ((j+1)*200);
			}
		}
		
		for(int i=0; i<playerScores.length; i++)
		{
			playerScores[i] = 0;
		}
		
		dailyDoubleX = rng.nextInt(6);
		dailyDoubleY = rng.nextInt(5);		
	}
	public void getQuestion()
	{
		currentQuestion = questions[questionX][questionY];
	}
	
	public void getAnswer()
	{
		currentAnswer = answers[questionX][questionY];
	}
	
	
	
	public boolean checkBoardClear()
	{
		for(int i=0; i<answered.length; i++)
		{
			for(int j=0; j<answered[0].length; j++)
			{
				if(answered[i][j] == false)
					return false;
			}
		}
		return true;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(cursorX<6)
				cursorX++;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(cursorX>1)
				cursorX--;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			if(cursorY>1)
				cursorY--;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if(cursorY<5)
				cursorY++;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && answeringQuestion==false && showAnswer==false)
		{
			questionX = cursorX-1;
			questionY = cursorY-1;
			
			if(answered[questionX][questionY] == false)
			{
				if(questionX == dailyDoubleX && questionY == dailyDoubleY)
					isDailyDouble = true;
				
				answeringQuestion=true;
				getQuestion();
			}
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && showAnswer==true)
		{
			answerCursor=2;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT  && showAnswer==true)
		{
			answerCursor=1;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE && showAnswer==true)
		{
			
			showAnswer=false;
			
			

			if(isDailyDouble == true)
			{
				if(answerCursor==1)
					playerScores[playerNumTurn-1] += pointValues[questionX][questionY] * 2;
				else
					playerScores[playerNumTurn-1] -= pointValues[questionX][questionY] * 2;
			}
			else
			{
				if(answerCursor==1)
					playerScores[playerNumTurn-1] += pointValues[questionX][questionY];
				else
					playerScores[playerNumTurn-1] -= pointValues[questionX][questionY];
			}
			
			if(playerNumTurn<playerCount)
				playerNumTurn++;
			else 
			{
				playerNumTurn=1;
			}
			
			isDailyDouble=false;
			
		}
		
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE && answeringQuestion==true)
		{
			getAnswer();
			answered[questionX][questionY] = true;
			showAnswer=true;
			answeringQuestion=false;
			
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
