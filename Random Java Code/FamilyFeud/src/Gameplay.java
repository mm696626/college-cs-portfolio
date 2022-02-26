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
	private final int FPS = 60; 
	private final int delay = 1000/FPS;
	
	private boolean newRoundStart = true;
	private int round = 0;
	private int strikes = 0;
	private boolean buzzer = true; //whether or not to buzz in
	private boolean displayQuestions = false; //display board
	
	private int[] familyScores = new int[2];
	private int winningTeam = 1;
	
	private int activeTeam = -1;
	
	private int scoreMultiplier = 1;
	
	private String question = "";
	private String answer = "";
	
	private boolean winnerFound = false;
	
	private String[] answers;
	private int[] answerPointValues;
	private boolean[] gotAnswers;
	
	private int currentPoints = 0; //current points team has accumulated
	
	
	
	
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
		
		if(buzzer==true)
		{
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("The question is: " + question, 50, 150);
			g.drawString("Buzz in to start", 200, 200);
			g.drawString("Press A for team 1, L for team 2", 50, 250);
		}
		if(displayQuestions == true)
		{
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("Team " + activeTeam + "'s Turn", 50, 30);
			g.drawString("Press Escape to take half of your points without risk", 50, 60);
			g.drawString("Current Points: " + currentPoints, 50, 90);
			g.drawString("Question: " + question, 50, 470);
			g.drawString("Your answer: " + answer, 200, 500);
			g.drawString("Strikes: " + strikes, 50, 500);
			g.drawString("Team 1 Score: " + familyScores[0], 50, 530);
			g.drawString("Team 2 Score: " + familyScores[1], 350, 530);
			
			for(int i=0; i<gotAnswers.length; i++)
			{
				if(gotAnswers[i] == true)
				{
					g.setFont(new Font("serif",Font.BOLD,15));
					g.drawString(answers[i] + " " + answerPointValues[i], 50, (i+4)*30);
				}
				else
				{
					g.setFont(new Font("serif",Font.BOLD,10));
					g.drawString("" + (i+1), 50, (i+4)*30);
				}
			}
		}
		
		if(winnerFound == true)
		{
			//blue background
			g.setColor(Color.blue);
			g.fillRect(0, 0, 800, 700);
			
			g.setColor(Color.black);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("The winner is: " + "Team " + winningTeam, 200, 100);
			
			for(int i=0; i<familyScores.length; i++)
			{
				g.drawString("Team " + (i+1) + " with " + familyScores[i] + " points", 200, (i+2)*100);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		if(round>4)
		{
			int maxScore = familyScores[0];
			for(int i=1; i<familyScores.length; i++)
			{
				if(familyScores[i]>maxScore)
				{
					maxScore = familyScores[i];
					winningTeam = (i+1);
				}
			}
			winnerFound = true;
			repaint();
			timer.stop();
		}
		
		if(newRoundStart==true)
		{
			round++;
			if(round<=4)
				setUpRound();
			strikes = 0;
			newRoundStart=false;
		}
		if(checkAllAnswered() == true)
		{
			familyScores[activeTeam-1] += currentPoints;
			buzzer = true;
			newRoundStart=true;
			displayQuestions=false;
			currentPoints=0;
			repaint();
		}
		
		if(strikes == 3)
		{
			buzzer = true;
			newRoundStart=true;
			displayQuestions=false;
			if(activeTeam==1)
				familyScores[1] +=currentPoints/2;
			if(activeTeam==2)
				familyScores[0] +=currentPoints/2;
			currentPoints=0;
			repaint();
		}
		if(round == 3)
		{
			scoreMultiplier=2;
		}
		if(round == 4)
		{
			scoreMultiplier=3;
		}
		
		repaint();
		
	}

	public boolean checkAllAnswered()
	{
		for(int i=0; i<gotAnswers.length; i++)
		{
			if(gotAnswers[i] == false)
				return false;
		}
		return true;
	}
	
	public void setUpRound()
	{
		
		//get question
		Scanner inputStream=null;
		try{
		      inputStream= new Scanner (new FileInputStream("questions.txt"));
		   }
		catch (FileNotFoundException e)
		      {
		     
		          System.out.println("no file named questions.txt (it doesnt exist)");
		          System.exit(0);
		      }
			
		for(int i=0; i<round; i++)
		{
			if(inputStream.hasNextLine())
				question = inputStream.nextLine();
		}
		
		
		inputStream.close();

			
			
			//get number of answers
			try{
		          inputStream= new Scanner (new FileInputStream("round" + round + ".txt"));
		       }
		    catch (FileNotFoundException e)
		       {
		     
		          System.out.println("no file named round" + round + ".txt (it doesnt exist)");
		          System.exit(0);
		       }
			int lineCounter = 0;
			while(inputStream.hasNextLine())
			{
				lineCounter++;
				inputStream.nextLine();
			}
			
			inputStream.close();
			
			

			//get answers
			try{
		          inputStream= new Scanner (new FileInputStream("round" + round + ".txt"));
		       }
		    catch (FileNotFoundException e)
		       {
		     
		          System.out.println("no file named round" + round + ".txt (it doesnt exist)");
		          System.exit(0);
		       }
			
		
			
			answers = new String[lineCounter];
			
			for(int i=0; i<answers.length; i++)
			{
				if(inputStream.hasNextLine())
					answers[i] = inputStream.nextLine();
			}
			
			
			inputStream.close();
			
			//get answer point values
			try{
		          inputStream= new Scanner (new FileInputStream("round" + round + "points.txt"));
		       }
		    catch (FileNotFoundException e)
		       {
		     
		          System.out.println("no file named round" + round + "points.txt (it doesnt exist)");
		          System.exit(0);
		       }
			
			answerPointValues = new int[lineCounter];
			
			for(int i=0; i<answerPointValues.length; i++)
			{
				if(inputStream.hasNextLine())
					answerPointValues[i] = inputStream.nextInt();
			}	
			
			inputStream.close();
			
			gotAnswers = new boolean[lineCounter];
			for(int i=0; i<gotAnswers.length; i++)
			{
				gotAnswers[i] = false;
			}
			
	}
	
	
	public void submitAnswer()
	{
		boolean gotValidAnswer = false;
		for(int i=0; i<answers.length; i++)
		{
			if(answer.equalsIgnoreCase(answers[i]) && gotAnswers[i] == false)
			{
				currentPoints+=answerPointValues[i] * scoreMultiplier;
				gotAnswers[i] = true;
				gotValidAnswer=true;
			}
		}
		if(gotValidAnswer==false)
		{
			strikes++;
		}
		answer="";
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(displayQuestions == true)
		{
			if(e.getKeyCode() == KeyEvent.VK_A)
			{
				answer += "A";
					
			}
			if(e.getKeyCode() == KeyEvent.VK_B)
			{
				answer += "B";
			}
			if(e.getKeyCode() == KeyEvent.VK_C)
			{
				answer += "C";
			}
			if(e.getKeyCode() == KeyEvent.VK_D)
			{
				answer += "D";
			}
			if(e.getKeyCode() == KeyEvent.VK_E)
			{
				answer += "E";
			}
			if(e.getKeyCode() == KeyEvent.VK_F)
			{
				answer += "F";
			}
			if(e.getKeyCode() == KeyEvent.VK_G)
			{
				answer += "G";
			}
			if(e.getKeyCode() == KeyEvent.VK_H)
			{
				answer += "H";
			}
			if(e.getKeyCode() == KeyEvent.VK_I)
			{
				answer += "I";
			}
			if(e.getKeyCode() == KeyEvent.VK_J)
			{
				answer += "J";
			}
			if(e.getKeyCode() == KeyEvent.VK_K)
			{
				answer += "K";
			}
			if(e.getKeyCode() == KeyEvent.VK_L)
			{
				answer += "L";
			}
			if(e.getKeyCode() == KeyEvent.VK_M)
			{
				answer += "M";
			}
			if(e.getKeyCode() == KeyEvent.VK_N)
			{
				answer += "N";
			}
			if(e.getKeyCode() == KeyEvent.VK_O)
			{
				answer += "O";
			}
			if(e.getKeyCode() == KeyEvent.VK_P)
			{
				answer += "P";
			}
			if(e.getKeyCode() == KeyEvent.VK_Q)
			{
				answer += "Q";
			}
			if(e.getKeyCode() == KeyEvent.VK_R)
			{
				answer += "R";
			}
			if(e.getKeyCode() == KeyEvent.VK_S)
			{
				answer += "S";
			}
			if(e.getKeyCode() == KeyEvent.VK_T)
			{
				answer += "T";
			}
			if(e.getKeyCode() == KeyEvent.VK_U)
			{
				answer += "U";
			}
			if(e.getKeyCode() == KeyEvent.VK_V)
			{
				answer += "V";
			}
			if(e.getKeyCode() == KeyEvent.VK_W)
			{
				answer += "W";
			}
			if(e.getKeyCode() == KeyEvent.VK_X)
			{
				answer += "X";
			}
			if(e.getKeyCode() == KeyEvent.VK_Y)
			{
				answer += "Y";
			}
			if(e.getKeyCode() == KeyEvent.VK_Z)
			{
				answer += "Z";
			}
			if(e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				answer += " ";
			}
			if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
			{
				if(answer.length()>0)
					answer = answer.substring(0, answer.length()-1);
			}
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				submitAnswer();
			}
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				familyScores[activeTeam-1] +=currentPoints/2;
				currentPoints=0;
				buzzer = true;
				newRoundStart=true;
				displayQuestions=false;
				repaint();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_A && buzzer == true)
		{
			buzzer=false;
			activeTeam=1;
			displayQuestions=true;
		}
		if(e.getKeyCode() == KeyEvent.VK_L && buzzer == true)
		{
			buzzer=false;
			activeTeam=2;
			displayQuestions=true;
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
