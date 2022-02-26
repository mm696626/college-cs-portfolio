import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.Random;
public class Simon extends JFrame implements  ActionListener{

	int score = 0;
	int highscore = 0;
	String instructionString = "";
	String playerString = "";
	private JLabel scoreLabel, highScoreLabel, instructionLabel;
    private JTextField scoreField, highScoreField, instruction, gameRules;
    private JButton buttonR, buttonG, buttonB, buttonY;
    GridBagConstraints layoutConst=null;
	
	public Simon()
	{
		setTitle("Simon");
    	
        scoreLabel = new JLabel ("Score: ");
        highScoreLabel = new JLabel("High Score: ");
        instructionLabel = new JLabel("Instruction: ");
   
        scoreField = new JTextField(10);
        scoreField.setEditable(false);
        scoreField.setText("" + score);
          
        highScoreField = new JTextField(10);
        highScoreField.setEditable(false);
        highScoreField.setText("" + highscore);
        
        instruction = new JTextField(20);
        instruction.setEditable(false);
        instruction.setText("");
        
        gameRules = new JTextField(60);
        gameRules.setEditable(false);
        gameRules.setText("The classic game of Simon, click the buttons in the correct order by memory. The sequence builds as your score goes up");
        
        
        buttonR = new JButton("Red");
        buttonR.addActionListener(this);
        
        buttonG = new JButton("Green");
        buttonG.addActionListener(this);
        
        buttonB = new JButton("Blue");
        buttonB.addActionListener(this);
        
        buttonY = new JButton("Yellow");
        buttonY.addActionListener(this);
        
     
        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
  
        layoutConst.gridx=0;
        layoutConst.gridy=0;
        add(scoreLabel, layoutConst);
       
        layoutConst.gridx=0;
        layoutConst.gridy=1;
        add(highScoreLabel, layoutConst);
        
        layoutConst.gridx=0;
        layoutConst.gridy=2;
        add(instructionLabel, layoutConst);
        
        layoutConst.gridx=1;
        layoutConst.gridy=0;
        add(scoreField, layoutConst);
        
        layoutConst.gridx=1;
        layoutConst.gridy=1;
        add(highScoreField, layoutConst);
        
        layoutConst.gridx=0;
        layoutConst.gridy=6;
        add(gameRules, layoutConst);
        
        
        layoutConst.gridx=1;
        layoutConst.gridy=2;
        add(instruction, layoutConst);
       
       layoutConst.gridx=0;
       layoutConst.gridy=3;
       add(buttonR, layoutConst);
       
       layoutConst.gridx=2;
       layoutConst.gridy=3;
       add(buttonG, layoutConst);
       
       layoutConst.gridx=0;
       layoutConst.gridy=4;
       add(buttonB, layoutConst);
       
       layoutConst.gridx=2;
       layoutConst.gridy=4;
       add(buttonY, layoutConst);
       
       
	}
	
	
	public static void main(String[] args)
	{
		
		Simon myFrame = new Simon();
		  Scanner inputStream=null;
		  try {
		          inputStream= new Scanner (new FileInputStream("highscore.txt"));
		      }
		       catch (FileNotFoundException e)
		       {
		     
		         System.out.println("A save file will be created if this message appears. Please re run");
		         createSave();
		         System.exit(0);
		       }
		myFrame.setHighScore(inputStream.nextInt());
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    myFrame.pack();
	    myFrame.startGame();
	    myFrame.setVisible(true);
	}
	public static void saveScore(int s)
	   {
		   PrintWriter outputStream=null;
	 		  
		       try{
		          outputStream = new PrintWriter( new FileOutputStream("highscore.txt"));
		       }
		       catch (FileNotFoundException f) {
		         System.out.println("Problem opening files");
		          System.exit(0);
		       }
		       outputStream.println(s);
		       outputStream.close();
		       
	   }
	
	public void setHighScore(int h)
	{
		highscore = h;
		highScoreField.setText("" + highscore);
	}
	public void startGame()
	{
		instructionString = "";
		Random rng = new Random();
		int color = rng.nextInt(4);
		if(color == 0)
			instructionString+="r";
		if(color == 1)
			instructionString+="g";
		if(color == 2)
			instructionString+="b";
		if(color == 3)
			instructionString+="y";
		
		instruction.setText(instructionString);
	}
	public static void createSave()
	   {
		   PrintWriter outputStream=null;
	 		  
		       try{
		          outputStream = new PrintWriter( new FileOutputStream("highscore.txt"));
		       }
		       catch (FileNotFoundException f) {
		         System.out.println("Problem opening files");
		          System.exit(0);
		       }
		       outputStream.println(0);
		       outputStream.close();
		       System.exit(0);
	   }
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == buttonR)
		{
			instruction.setText("");
			playerString+="r";
		}
		if(e.getSource() == buttonG)
		{
			instruction.setText("");
			playerString+="g";
		}
		if(e.getSource() == buttonB)
		{
			instruction.setText("");
			playerString+="b";
		}
		if(e.getSource() == buttonY)
		{
			instruction.setText("");
			playerString+="y";
		}
		
		if(playerString.length() == instructionString.length())
		{
			if(playerString.equals(instructionString))
			{
				score++;
				scoreField.setText("" + score);
				playerString = "";
				Random rng = new Random();
				
			
					int color = rng.nextInt(4);
					if(color == 0)
						instructionString+="r";
					if(color == 1)
						instructionString+="g";
					if(color == 2)
						instructionString+="b";
					if(color == 3)
						instructionString+="y";
				
				instruction.setText(instructionString);
			}
				
			else
			{
				saveScore(score);
				/*
				 *  PrintWriter outputStream=null;
		 		  
			       try{
			          outputStream = new PrintWriter( new FileOutputStream("mistake.txt"));
			       }
			       catch (FileNotFoundException f) {
			         System.out.println("Problem opening files");
			          System.exit(0);
			       }
			       outputStream.println("This is what you did: " + playerString);
			       outputStream.println("Correct Sequence: " + instructionString);
			       outputStream.close();
				 */
				
			       System.exit(0);
			}
				
		}
	}
	
	
	
}