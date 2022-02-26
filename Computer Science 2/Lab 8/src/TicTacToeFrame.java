/**
 * @author Matthew McCullough
 * @date 3/22/2019
 * This is a Tic Tac Toe game using JFrame and even incorporates a computer player
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TicTacToeFrame extends JFrame implements  ActionListener {
	      
     private JTextField x00;
     private JTextField x01; 
     private JTextField x02; 
     private JTextField x10; 
     private JTextField x11; 
     private JTextField x12; 
     private JTextField x20; 
     private JTextField x21; 
     private JTextField x22;
     private JTextField winner;
     public static String[][] matrix = new String[3][3]; //matrix representing tictactoe board
     public static String winLetter = null; //character to display when someone wins
     private JButton playButton;   // Triggers game 
     private JButton clearButton; // Triggers clearing the field so you can play again
     private JButton cpuButton; // when pressed, CPU will make a move
     Font bigFont = new Font("SERIF", Font.PLAIN, 100); //makes boxes bigger
     Font winFont = new Font("SERIF", Font.PLAIN, 50); //font for winner box (to increase size)
     /**
      * main constructor where all elements are placed in frame and set up
      */
     public TicTacToeFrame()
     {
    	 GridBagConstraints layoutConst=null;
    	 setSize(500,500);
         setTitle("Tic Tac Toe");
    	 for(int i=0; i<matrix.length; i++) //initialize array
    	 {
    		 for(int j=0; j<matrix[0].length; j++)
    		 {
    			 matrix[i][j]=Integer.toString(((j+1)*(i+1)));
    		 }
    	 }
    	 
    	 //create buttons
    	 x00 = new JTextField(1);
    	 x00.setFont(bigFont);
         x00.setEditable(true);
         x00.setText(" ");

         x01 = new JTextField(1);
         x01.setFont(bigFont);
         x01.setEditable(true);
         x01.setText(" ");

         x02 = new JTextField(1);
         x02.setFont(bigFont);
         x02.setEditable(true);
         x02.setText(" ");

         x10 = new JTextField(1);
         x10.setFont(bigFont);
         x10.setEditable(true);
         x10.setText(" ");

         x11 = new JTextField(1);
         x11.setFont(bigFont);
         x11.setEditable(true);
         x11.setText(" ");

         x12 = new JTextField(1);
         x12.setFont(bigFont);
         x12.setEditable(true);
         x12.setText(" ");

         x20 = new JTextField(1);
         x20.setFont(bigFont);
         x20.setEditable(true);
         x20.setText(" ");

         x21 = new JTextField(1);
         x21.setFont(bigFont);
         x21.setEditable(true);
         x21.setText(" ");

         x22 = new JTextField(1);
         x22.setFont(bigFont);
         x22.setEditable(true);
         x22.setText(" ");
         
         winner = new JTextField(40);
         winner.setFont(winFont);
         winner.setEditable(false);
         winner.setText("Press the Play button to move or when no moves are left (CPU Only)");

         playButton = new JButton("Play");
         playButton.addActionListener(this);
         
         cpuButton = new JButton("CPU Move");
         cpuButton.addActionListener(this);
         
         clearButton = new JButton("Clear");
         clearButton.addActionListener(this);
         
         //add buttons to layout
         setLayout(new GridBagLayout());
         layoutConst = new GridBagConstraints();
         // 30 pixels of padding around component
         layoutConst.insets = new Insets(30, 30, 30, 30);
         
         layoutConst.gridx = 0;
         layoutConst.gridy = 0;
         add(x00, layoutConst);
         
         layoutConst.gridx = 0;
         layoutConst.gridy = 1;
         add(x01, layoutConst);
         
         layoutConst.gridx = 0;
         layoutConst.gridy = 2;
         add(x02, layoutConst);
         
         layoutConst.gridx = 1;
         layoutConst.gridy = 0;
         add(x10, layoutConst);
         
         layoutConst.gridx = 1;
         layoutConst.gridy = 1;
         add(x11, layoutConst);
         
         layoutConst.gridx = 1;
         layoutConst.gridy = 2;
         add(x12, layoutConst);
         
         layoutConst.gridx = 2;
         layoutConst.gridy = 0;
         add(x20, layoutConst);
         
         layoutConst.gridx = 2;
         layoutConst.gridy = 1;
         add(x21, layoutConst);
         
         layoutConst.gridx = 2;
         layoutConst.gridy = 2;
         add(x22, layoutConst);
         
         layoutConst.gridx = 0;
         layoutConst.gridy = 3;
         add(playButton, layoutConst);
         
         layoutConst.gridx = 1;
         layoutConst.gridy = 3;
         add(cpuButton, layoutConst);
         
         layoutConst.gridx = 2;
         layoutConst.gridy = 3;
         add(clearButton, layoutConst);
         
         layoutConst.gridx = 1;
         layoutConst.gridy = 4;
         add(winner, layoutConst);
         
     }
     /**
      * This is where the code for pressing the JButtons is found
      */
     public void actionPerformed(ActionEvent e) {
         if(e.getSource() == playButton)
         {
        	 String field=x00.getText().trim();
        	 
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[0][0] = field;
            	 x00.setEditable(false);
             }
             
             field=x01.getText().trim();
        	 if(field.equals("x")||field.equals("o"))
        	 {
        		 matrix[0][1] = field;
        		 x01.setEditable(false);
        	 }
        	 
        	 field=x02.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[0][2] = field;
            	 x02.setEditable(false);
             }
             
             field=x10.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[1][0] = field;
            	 x10.setEditable(false);
             }
             
             field=x11.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[1][1] = field;
            	 x11.setEditable(false);
             }
             
             field=x12.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[1][2] = field;
            	 x12.setEditable(false);
             }
             
             field=x20.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[2][0] = field;
            	 x20.setEditable(false);
             }
             
             field=x21.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[2][1] = field;
            	 x21.setEditable(false);
             }
             
             field=x22.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[2][2] = field;
            	 x22.setEditable(false);
             }

             boolean ans= checkTTT(matrix);
             if(ans)
                 winner.setText("The Winner is " + winLetter.toUpperCase());
         }     
         else if(e.getSource() == cpuButton)
         {
        	//checks for winner before cpu moves
        	 boolean ans= checkTTT(matrix);
        	 if(ans)
        		 winner.setText("The Winner is " + winLetter.toUpperCase());
        	 
        	 //updates array before cpu moves
        	 String field=x00.getText().trim();
        	 
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[0][0] = field;
            	 x00.setEditable(false);
             }
             
             field=x01.getText().trim();
        	 if(field.equals("x")||field.equals("o"))
        	 {
        		 matrix[0][1] = field;
        		 x01.setEditable(false);
        	 }
        	 
        	 field=x02.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[0][2] = field;
            	 x02.setEditable(false);
             }
             
             field=x10.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[1][0] = field;
            	 x10.setEditable(false);
             }
             
             field=x11.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[1][1] = field;
            	 x11.setEditable(false);
             }
             
             field=x12.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[1][2] = field;
            	 x12.setEditable(false);
             }
             
             field=x20.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[2][0] = field;
            	 x20.setEditable(false);
             }
             
             field=x21.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[2][1] = field;
            	 x21.setEditable(false);
             }
             
             field=x22.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[2][2] = field;
            	 x22.setEditable(false);
             } 
             
        	 int move=0;
        	 while(move==0)
        		 move = cpuMove(matrix);
        	 
        	 if(move==0)
        		 winner.setText("Tell me if you see this"); //this is if an invalid move is picked (this is a debug statement if such ever occurs which should never happen)
        	 if(move==1)
        	 {
        		 x00.setText("o");
        		 x00.setEditable(false);
        	 }
        	 if(move==2)
        	 {
        		 x01.setText("o");
        		 x01.setEditable(false);
        	 }
        	 if(move==3)
        	 {
        		 x02.setText("o");
        		 x02.setEditable(false);
        	 }
        	 if(move==4)
        	 {
        		 x10.setText("o");
        		 x10.setEditable(false);
        	 }
        	 if(move==5)
        	 {
        		 x11.setText("o");
        		 x11.setEditable(false);
        	 }
        	 if(move==6)
        	 {
        		 x12.setText("o");
        		 x12.setEditable(false);
        	 }
        	 if(move==7)
        	 {
        		 x20.setText("o");
        		 x20.setEditable(false);
        	 }
        	 if(move==8)
        	 {
        		 x21.setText("o");
        		 x21.setEditable(false);
        	 }
        	 if(move==9)
        	 {
        		 x22.setText("o");
        		 x22.setEditable(false);
        	 }
        	 
        	//updates array after cpu moves
        	 field=x00.getText().trim();
        	 
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[0][0] = field;
            	 x00.setEditable(false);
             }
             
             field=x01.getText().trim();
        	 if(field.equals("x")||field.equals("o"))
        	 {
        		 matrix[0][1] = field;
        		 x01.setEditable(false);
        	 }
        	 
        	 field=x02.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[0][2] = field;
            	 x02.setEditable(false);
             }
             
             field=x10.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[1][0] = field;
            	 x10.setEditable(false);
             }
             
             field=x11.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[1][1] = field;
            	 x11.setEditable(false);
             }
             
             field=x12.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[1][2] = field;
            	 x12.setEditable(false);
             }
             
             field=x20.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[2][0] = field;
            	 x20.setEditable(false);
             }
             
             field=x21.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[2][1] = field;
            	 x21.setEditable(false);
             }
             
             field=x22.getText().trim();
             if(field.equals("x")||field.equals("o"))
             {
            	 matrix[2][2] = field;
            	 x22.setEditable(false);
             } 
        	 //checks for winner after cpu moves
        	 ans= checkTTT(matrix);
             if(ans)
                 winner.setText("The Winner is " + winLetter.toUpperCase());
         }
         else if(e.getSource() == clearButton)
         {
        	 x00.setText("");
        	 x01.setText("");
        	 x02.setText("");
        	 x10.setText("");
        	 x11.setText("");
        	 x12.setText("");
        	 x20.setText("");
        	 x21.setText("");
        	 x22.setText("");
        	 x00.setEditable(true);
        	 x01.setEditable(true);
        	 x02.setEditable(true);
        	 x10.setEditable(true);
        	 x11.setEditable(true);
        	 x12.setEditable(true);
        	 x20.setEditable(true);
        	 x21.setEditable(true);
        	 x22.setEditable(true);
        	 winner.setText("Press the Play button to move or when no moves are left (CPU Only)");
        	 for(int i=0; i<matrix.length; i++) //initialize array
        	 {
        		 for(int j=0; j<matrix[0].length; j++)
        		 {
        			 matrix[i][j]=Integer.toString(((j+1)*(i+1)));
        		 }
        	 }
         	
         }
        
          
     }
     public static void main(String[] args) {
    	 TicTacToeFrame myFrame = new TicTacToeFrame();
         myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         myFrame.pack();
         myFrame.setVisible(true);
      }
     /**
      * 
      * @param matrix takes in the matrix representing the board and checks where a CPU can move
      * @return returns a move for the CPU (1-9) 0 if invalid corresponding to a spot on the board
      */
     public static int cpuMove(String[][] matrix)
     {
    	 Random rng = new Random();
    	 int move = rng.nextInt(9)+1;
    	 boolean validMove=false;
    	 int counter=0; //if an invalid move isn't made
    	 while(validMove==false)
    	 {
    		 counter++;
    		 move = rng.nextInt(9)+1;
    		 if(move==1 && !(matrix[0][0].equals("x") || matrix[0][0].equals("o")))
    		 {
    			 validMove=true;
    		 }
    		 else if(move==2 && !(matrix[0][1].equals("x") || matrix[0][1].equals("o")))
    		 {
    			 validMove=true;
    		 }
    		 else if(move==3 && !(matrix[0][2].equals("x") || matrix[0][2].equals("o")))
    		 {
    			 validMove=true;
    		 }
    		 else if(move==4 && !(matrix[1][0].equals("x") || matrix[1][0].equals("o")))
    		 {
    			 validMove=true;
    		 }
    		 else if(move==5 && !(matrix[1][1].equals("x") || matrix[1][1].equals("o")))
    		 {
    			 validMove=true;
    		 }
    		 else if(move==6 && !(matrix[1][2].equals("x") || matrix[1][2].equals("o")))
    		 {
    			 validMove=true;
    		 }
    		 else if(move==7 && !(matrix[2][0].equals("x") || matrix[2][0].equals("o")))
    		 {
    			 validMove=true;
    		 }
    		 else if(move==8 && !(matrix[2][1].equals("x") || matrix[2][1].equals("o")))
    		 {
    			 validMove=true;
    		 }
    		 else if(move==9 && !(matrix[2][2].equals("x") || matrix[2][2].equals("o")))
    		 {
    			 validMove=true;
    		 }
    		 if(counter==1000) //gives the "CPU" 1000 tries to pick a valid move before giving up
    		 {
    			 move=0;
    			 break;
    		 }
    			
    			 
    	 }
    	 return move;
     }
     /**
      * 
      * @param matrix takes in the matrix representing the board and checks if someone got tic tac toe
      * @return returns true if someone did, false if not
      */
     public static boolean checkTTT(String[][] matrix)
     {
    	
    	 if(matrix[0][0].equals(matrix[0][1]) && matrix[0][1].equals(matrix[0][2]))
    	 {
    		 winLetter = matrix[0][0];
    		 return true;
    	 }
    	 
    	 else if(matrix[1][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[1][2]))
    	 {
    		 winLetter = matrix[1][0];
    		 return true;
    	 }
    	 
    	 else if(matrix[2][0].equals(matrix[2][1]) && matrix[2][1].equals(matrix[2][2]))
    	 {
    		 winLetter = matrix[2][0];
    		 return true;
    	 }
    	 
    	 else if(matrix[0][0].equals(matrix[1][0]) && matrix[1][0].equals(matrix[2][0]))
	     {
	    	 winLetter = matrix[0][0];
	    	 return true;
	     }
    	 
    	 else if(matrix[0][1].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][1]))
	     {
	    	 winLetter = matrix[0][1];
	    	 return true;
	     }
    	 
    	 else if(matrix[0][2].equals(matrix[1][2]) && matrix[1][2].equals(matrix[2][2]))
	     {
	    	 winLetter = matrix[0][2];
	    	 return true;
	     }
    	 
    	 else if(matrix[0][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][2]))
	     {
	    	 winLetter = matrix[0][0];
	    	 return true;
	     }
    	 
    	 else if(matrix[0][2].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][0]))
	     {
	    	 winLetter = matrix[0][2];
	    	 return true;
	     }
    	 
	     else
			 return false;
     }
     
}