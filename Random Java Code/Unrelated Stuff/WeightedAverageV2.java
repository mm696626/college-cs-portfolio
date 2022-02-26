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

public class WeightedAverageV2  extends JFrame implements  ActionListener{
	private JLabel gradeLabel, gradeWriteLabel;
    private JTextField gradeField, gradeWrite, instructions;
    private JButton writeToTextFile, getGrade, reset;
    GridBagConstraints layoutConst=null;
    
    public WeightedAverageV2()
    {
    	setTitle("Weighted Average Calculator");
    	
        gradeLabel = new JLabel ("Grade: ");
        gradeWriteLabel = new JLabel("Write New Grade Here: ");
   
        gradeField = new JTextField(10);
        gradeField.setEditable(false);
        gradeField.setText("");
          
        gradeWrite = new JTextField(10);
        gradeWrite.setEditable(true);
        gradeWrite.setText("");
        
        
        instructions = new JTextField(30);
        instructions.setEditable(false);
        instructions.setText("Put information as follows, points earned total points weight");
        
        
         
        writeToTextFile = new JButton("Write to Text File");
        writeToTextFile.addActionListener(this);
        
        getGrade = new JButton("Get Grade");
        getGrade.addActionListener(this);
        
        reset = new JButton("Create New/Reset Text File");
        reset.addActionListener(this);
        
        
        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
  
        layoutConst.gridx=0;
        layoutConst.gridy=0;
        add(gradeLabel, layoutConst);
       
        
        layoutConst.gridx=1;
        layoutConst.gridy=0;
        add(gradeField, layoutConst);
        
        layoutConst.gridx=1;
        layoutConst.gridy=10;
        add(instructions, layoutConst);
        
        
        layoutConst.gridx=0;
        layoutConst.gridy=1;
        add(gradeWriteLabel, layoutConst);
        
        layoutConst.gridx=1;
        layoutConst.gridy=1;
        add(gradeWrite, layoutConst);
        
        layoutConst.gridx=10;
        layoutConst.gridy=0;
        add(writeToTextFile, layoutConst);
        
        
       
       layoutConst.gridx=10;
       layoutConst.gridy=1;
       add(getGrade, layoutConst);
       
       layoutConst.gridx=10;
       layoutConst.gridy=2;
       add(reset, layoutConst);
     
    }
    
    
    
	
	public void actionPerformed(ActionEvent e) {

		
	      
		if(e.getSource() == writeToTextFile)
		{
			 PrintWriter outputStream=null;
			  
		       try{
		          outputStream = new PrintWriter( new FileOutputStream("grades.txt",true)); //grades.txt is file being written to, true is to say to write to end of file
		       }
		       catch (FileNotFoundException f) {
		         System.out.println("Problem opening files");
		          System.exit(0);
		       }
			 outputStream.println(gradeWrite.getText().trim());
			 outputStream.close();
			 gradeWrite.setText("");
			 
		       
		}
		if(e.getSource() == getGrade)
		{

			 Scanner inputStream=null;
			 
			       try{
			          inputStream= new Scanner (new FileInputStream("grades.txt"));
			       }
			       catch (FileNotFoundException ex)
			       {
			     
			         System.out.println("Grade data not found");
			         System.out.println("Put Data like this: Points earned, Total points, weight of category");
			         System.out.println("Do this in a text file called grades.txt. Make a new line for more categories");
			         System.exit(0);
			       }
			       
			       double points = 0;
			       double totalpoints=0;
			       double weight=0;
				   double totalweight=0;
				   double tempGrade = 0; // used to calculate grade for a weight category
				  
				   double grade = 0;
				   double top = 0;
				   while(inputStream.hasNextDouble())
				   {
					   points = inputStream.nextDouble();
					   totalpoints = inputStream.nextDouble();
					   weight = inputStream.nextDouble();
					   tempGrade = (points/totalpoints) * weight;
					   totalweight+=weight;
					   top+=tempGrade;
				   }
				   
				   DecimalFormat df = new DecimalFormat("#.00");
				  
				   grade = (top/totalweight) * 100;
				   grade = Double.parseDouble(df.format(grade));
				   gradeField.setText(grade + "%");
			
		}
		
		
		if(e.getSource() == reset)
		{
			 PrintWriter outputStream=null;
			  
		       try{
		          outputStream = new PrintWriter( new FileOutputStream("grades.txt"));
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
		  WeightedAverageV2 myFrame = new WeightedAverageV2();
		  myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  myFrame.pack();
		  myFrame.setVisible(true);
	}
}
