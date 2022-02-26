import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.GapContent;

public class GPACalculator extends JFrame implements  ActionListener{

	private JLabel gpaLabel, gpaWriteLabel, valueLabel;
    private JTextField gpaField, gpaWrite, instructions, gpaValues;
    private JButton writeToTextFile, getGPA, reset;
   
    GridBagConstraints layoutConst=null;
    
    public GPACalculator()
    {
    	 setTitle("GPA Calculator");
    		
    	    gpaLabel = new JLabel ("GPA: ");
    	    gpaWriteLabel = new JLabel("Write New GPA Here: ");
    	    valueLabel = new JLabel("GPA Values: ");


    	    gpaField = new JTextField(10);
    	    gpaField.setEditable(false);
    	    gpaField.setText("");
    	      
    	    gpaWrite = new JTextField(10);
    	    gpaWrite.setEditable(true);
    	    gpaWrite.setText("");
    	    
    	    
    	    instructions = new JTextField(30);
    	    instructions.setEditable(false);
    	    instructions.setText("Put information as follows, Grade points (GPA Value) Credits");
    	    
    	    
    	    gpaValues = new JTextField(42);
    	    gpaValues.setEditable(false);
    	    gpaValues.setText("A 4.0, A- 3.7, B+ 3.3, B 3.0, B-  2.7, C+ 2.3, C 2.0, C- 1.7, D+ 1.3, D 1.0, D- 0.7, F 0.0");
    	    
    	    
    	     
    	    writeToTextFile = new JButton("Write to Text File");
    	    writeToTextFile.addActionListener(this);
    	    
    	    getGPA = new JButton("Get GPA");
    	    getGPA.addActionListener(this);
    	    
    	    reset = new JButton("Create New/Reset Text File");
    	    reset.addActionListener(this);
    	    
    	    
    	    setLayout(new GridBagLayout());
    	    layoutConst = new GridBagConstraints();

    	    layoutConst.gridx=0;
    	    layoutConst.gridy=0;
    	    add(gpaLabel, layoutConst);
    	   
    	    
    	    layoutConst.gridx=1;
    	    layoutConst.gridy=0;
    	    add(gpaField, layoutConst);
    	    
    	    layoutConst.gridx=1;
    	    layoutConst.gridy=10;
    	    add(instructions, layoutConst);
    	    
    	    
    	    layoutConst.gridx=0;
    	    layoutConst.gridy=11;
    	    add(valueLabel, layoutConst);
    	    
    	    layoutConst.gridx=1;
    	    layoutConst.gridy=11;
    	    add(gpaValues, layoutConst);
    	    
    	    layoutConst.gridx=0;
            layoutConst.gridy=1;
            add(gpaWriteLabel, layoutConst);
            
            layoutConst.gridx=1;
            layoutConst.gridy=1;
            add(gpaWrite, layoutConst);
            
            layoutConst.gridx=10;
            layoutConst.gridy=0;
            add(writeToTextFile, layoutConst);
            
            
           
           layoutConst.gridx=10;
           layoutConst.gridy=1;
           add(getGPA, layoutConst);
           
           layoutConst.gridx=10;
           layoutConst.gridy=2;
           add(reset, layoutConst);
    }
   
    
    
    @Override
	public void actionPerformed(ActionEvent e) {
		
    	if(e.getSource() == writeToTextFile)
    	{
    		PrintWriter outputStream=null;
			  
		       try{
		          outputStream = new PrintWriter( new FileOutputStream("gpa.txt",true)); //gpa.txt is file being written to, true is to say to write to end of file
		       }
		       catch (FileNotFoundException f) {
		         System.out.println("Problem opening files");
		          System.exit(0);
		       }
			 outputStream.println(gpaWrite.getText().trim());
			 outputStream.close();
			 gpaWrite.setText("");
    	}
		if(e.getSource() == getGPA)
		{
			 Scanner inputStream=null;
			 
		       try{
		          inputStream= new Scanner (new FileInputStream("gpa.txt"));
		       }
		       catch (FileNotFoundException ex)
		       {
		     
		         System.out.println("GPA data not found");
		         System.out.println("Put Data like this: GPA value credits of class");
		         System.out.println("Do this in a text file called gpa.txt. Make a new line for more classes");
		         System.exit(0);
		       }
		       
		       double finalGPA = 0;
		       
		       double gpaValue = 0;
		       double creditValue = 0;
		       
		       double totalCredits = 0;
		       double totalGPAValue = 0;
		       while(inputStream.hasNextDouble())
		       {
		    	   gpaValue = inputStream.nextDouble();
		    	   creditValue = inputStream.nextDouble();
		    	   totalGPAValue+=gpaValue * creditValue;
		    	   totalCredits+=creditValue;
		       }
		       finalGPA = totalGPAValue/totalCredits;
		       DecimalFormat df = new DecimalFormat("#.00");
		       finalGPA = Double.parseDouble(df.format(finalGPA));
		       gpaField.setText("Your GPA is a: " + finalGPA);
		}      
		       
		       
		
		if(e.getSource() == reset)
		{
			 PrintWriter outputStream=null;
			  
		       try{
		          outputStream = new PrintWriter( new FileOutputStream("gpa.txt"));
		       }
		       catch (FileNotFoundException f) {
		         System.out.println("Problem opening files");
		          System.exit(0);
		       }
		     
			
			 outputStream.close();
		}
	}
    
    public static void main(String[] args)
	{
		  GPACalculator myFrame = new GPACalculator();
		  myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  myFrame.pack();
		  myFrame.setVisible(true);
	}





	
}
