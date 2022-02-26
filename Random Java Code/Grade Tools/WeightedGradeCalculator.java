import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class WeightedGradeCalculator extends JFrame implements  ActionListener{
	private JLabel gradeLabel, pointLabel, totalPointsLabel, weightLabel;

    private JTextField[] weightFields;
    private JTextField[] pointFields;
    private JTextField[] totalPointFields;

    private JTextField gradeField;
    private JTextField numWeights;

    private int newWeightNum;

    private JButton calculate, changeWeightNumber, switchModes;

    GridBagConstraints layoutConst=null;

    public WeightedGradeCalculator()
    {
    	setTitle("Weighted Grade Calculator");


        gradeLabel = new JLabel ("Grade: ");


        gradeField = new JTextField(10);
        gradeField.setEditable(false);
        gradeField.setText("");

        numWeights = new JTextField(10);
        numWeights.setEditable(true);
        numWeights.setText("");

        calculate = new JButton("Calculate Grade");
        calculate.addActionListener(this);


        changeWeightNumber = new JButton("Set Number of Weights");
        changeWeightNumber.addActionListener(this);

        switchModes = new JButton("Switch Modes");
        switchModes.addActionListener(this);




        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();




        layoutConst.gridx=0;
        layoutConst.gridy=0;
        add(numWeights, layoutConst);


        layoutConst.gridx=2;
        layoutConst.gridy=0;
        add(changeWeightNumber, layoutConst);

        layoutConst.gridx=4;
        layoutConst.gridy=0;
        add(switchModes, layoutConst);




    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == calculate)
        {
            calculateGrade();
        }
        if(e.getSource() == changeWeightNumber)
        {
            readjustFrame();
        }
        if(e.getSource() == switchModes)
        {
            Main.gpaMode = !Main.gpaMode;
            setVisible(false);
            Main.drawFrame();
        }
 }


 public void calculateGrade()
 {
     double top = 0;
     double finalGrade;
     double totalWeight=0;

     for(int i=0; i<newWeightNum; i++)
     {
         totalWeight+=Double.parseDouble(weightFields[i].getText().trim());

         top += Double.parseDouble(weightFields[i].getText().trim()) * (Double.parseDouble(pointFields[i].getText().trim())/Double.parseDouble(totalPointFields[i].getText().trim()));
     }
     finalGrade = top/totalWeight;
     finalGrade *= 100;


     for(int i=0; i<newWeightNum; i++)
     {
         pointFields[i].setText("");
         totalPointFields[i].setText("");
         weightFields[i].setText("");
     }


     DecimalFormat f = new DecimalFormat("##.00");
     gradeField.setText(f.format(finalGrade) + "%");
 }

 public void readjustFrame()
 {
     newWeightNum = Integer.parseInt(numWeights.getText().trim());
     setVisible(false);


     pointFields = new JTextField[newWeightNum];
     totalPointFields = new JTextField[newWeightNum];
     weightFields = new JTextField[newWeightNum];

     //set up the labels and fields
     for(int i=0; i<newWeightNum; i++)
     {

         pointFields[i] = new JTextField(10);
         pointFields[i].setEditable(true);
         pointFields[i].setText("");

         totalPointFields[i] = new JTextField(10);
         totalPointFields[i].setEditable(true);
         totalPointFields[i].setText("");

         weightFields[i] = new JTextField(10);
         weightFields[i].setEditable(true);
         weightFields[i].setText("");


         //add weight labels and fields to frame
         layoutConst.gridx=1;
         layoutConst.gridy=i+1;
         add(pointFields[i], layoutConst);


         layoutConst.gridx=2;
         layoutConst.gridy=i+1;
         add(totalPointFields[i], layoutConst);

         layoutConst.gridx=3;
         layoutConst.gridy=i+1;
         add(weightFields[i], layoutConst);


     }


     pointLabel = new JLabel ("Points");
     totalPointsLabel = new JLabel("Total Points");
     weightLabel = new JLabel("Weights");


     layoutConst.gridx=1;
     layoutConst.gridy=0;
     add(pointLabel, layoutConst);

     layoutConst.gridx=2;
     layoutConst.gridy=0;
     add(totalPointsLabel, layoutConst);

     layoutConst.gridx=3;
     layoutConst.gridy=0;
     add(weightLabel, layoutConst);



     layoutConst.gridx=0;
     layoutConst.gridy=newWeightNum+2;
     add(gradeLabel, layoutConst);



     layoutConst.gridx=1;
     layoutConst.gridy=newWeightNum+2;
     add(gradeField, layoutConst);


     remove(numWeights);
     remove(changeWeightNumber);


     layoutConst.gridx=3;
     layoutConst.gridy=newWeightNum+2;
     add(calculate, layoutConst);

     layoutConst.gridx=4;
     layoutConst.gridy=newWeightNum+2;
     add(switchModes, layoutConst);

     pack();
     setVisible(true);


 }


}


