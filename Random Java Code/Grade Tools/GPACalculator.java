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

public class GPACalculator extends JFrame implements  ActionListener{
	private JLabel courseNameLabel, gradeLabel, creditLabel, gpaLabel;
    private JTextField courseNameField, creditField, gpaField;
    private JButton save, summary, clearTextFile, switchModes;
    private final String[] grades = { "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
    private JComboBox gpaVals;

    private String outputGPA;

    private double GPA;

    private double totalGradePoints;
    private int totalCredits;

    GridBagConstraints layoutConst=null;

    public GPACalculator()
    {
    	setTitle("GPA Calculator");

        courseNameLabel = new JLabel ("Course Name: ");
        gradeLabel = new JLabel ("Grade: ");
        creditLabel = new JLabel ("Credits: ");
        gpaLabel = new JLabel ("Current GPA: ");

        courseNameField = new JTextField(10);
        courseNameField.setEditable(true);
        courseNameField.setText("");

        creditField = new JTextField(10);
        creditField.setEditable(true);
        creditField.setText("");

        gpaField = new JTextField(10);
        gpaField.setEditable(false);
        gpaField.setText("" + GPA);

        gpaVals = new JComboBox(grades);
        gpaVals.setSelectedIndex(0);

        gpaVals.addActionListener(this);

        save = new JButton("Save to File");
        save.addActionListener(this);

        summary = new JButton("Generate Summary");
        summary.addActionListener(this);

        clearTextFile = new JButton("Clear Text File");
        clearTextFile.addActionListener(this);

        switchModes = new JButton("Switch Modes");
        switchModes.addActionListener(this);


        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();

        layoutConst.gridx=0;
        layoutConst.gridy=0;
        add(courseNameLabel, layoutConst);

        layoutConst.gridx=2;
        layoutConst.gridy=0;
        add(courseNameField, layoutConst);


        layoutConst.gridx=0;
        layoutConst.gridy=1;
        add(gradeLabel, layoutConst);

        layoutConst.gridx=2;
        layoutConst.gridy=1;
        add(gpaVals, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=2;
        add(creditLabel, layoutConst);

        layoutConst.gridx=2;
        layoutConst.gridy=2;
        add(creditField, layoutConst);


        layoutConst.gridx=0;
        layoutConst.gridy=3;
        add(gpaLabel, layoutConst);

        layoutConst.gridx=2;
        layoutConst.gridy=3;
        add(gpaField, layoutConst);


        layoutConst.gridx=0;
        layoutConst.gridy=5;
        add(save, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=5;
        add(summary, layoutConst);

        layoutConst.gridx=2;
        layoutConst.gridy=5;
        add(clearTextFile, layoutConst);

        layoutConst.gridx=3;
        layoutConst.gridy=5;
        add(switchModes, layoutConst);

    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == save)
        {
            PrintWriter outputStream=null;


            try{
                outputStream = new PrintWriter( new FileOutputStream("courseNames.txt", true));
            }
            catch (FileNotFoundException f) {
                System.out.println("File does not exist");
                System.exit(0);
            }

            String courseName = courseNameField.getText().trim();
            outputStream.println(courseName);
            outputStream.close();

            try{
                outputStream = new PrintWriter( new FileOutputStream("gpa.txt", true));
            }
            catch (FileNotFoundException f) {
                System.out.println("File does not exist");
                System.exit(0);
            }

            double gpaValue = getGPAValue(); //get GPA Value
            int credits = Integer.parseInt(creditField.getText().trim());


            totalGradePoints += gpaValue * credits;
            totalCredits += credits;

            GPA = totalGradePoints / totalCredits;
            outputStream.println(outputGPA);
            outputStream.println(credits);

            courseNameField.setText("");
            creditField.setText("");
            DecimalFormat f = new DecimalFormat("##.00");
            gpaField.setText(""+ f.format(GPA));

            outputStream.close();
        }

        if(e.getSource() == summary)
        {
            generateSummary();
        }

        if(e.getSource() == clearTextFile)
        {
            PrintWriter outputStream=null;

            //clear courseName file
            try{
                outputStream = new PrintWriter( new FileOutputStream("courseNames.txt"));
            }
            catch (FileNotFoundException f) {
                System.out.println("File does not exist");
                System.exit(0);
            }

            outputStream.close();


            //clear main GPA file
            try{
                outputStream = new PrintWriter( new FileOutputStream("gpa.txt"));
            }
            catch (FileNotFoundException f) {
                System.out.println("File does not exist");
                System.exit(0);
            }


            totalGradePoints = 0;
            totalCredits = 0;
            GPA = 0;

            courseNameField.setText("");
            creditField.setText("");
            DecimalFormat f = new DecimalFormat("##.00");
            gpaField.setText(""+ GPA);

            outputStream.close();
        }

        if(e.getSource() == switchModes)
        {
            Main.gpaMode = !Main.gpaMode;
            setVisible(false);
            Main.drawFrame();
        }

 }

       public double getGPAValue()
       {
            int index = gpaVals.getSelectedIndex();
            String grade = grades[index];
            outputGPA = grade;

            if(grade.equals("A"))
                return 4.0;
            if(grade.equals("A-"))
                return 3.7;
            if(grade.equals("B+"))
                return 3.3;
            if(grade.equals("B"))
                return 3.0;
            if(grade.equals("B-"))
                return 2.7;
            if(grade.equals("C+"))
                return 2.3;
            if(grade.equals("C"))
                return 2.0;
            if(grade.equals("C-"))
                return 1.7;
            if(grade.equals("D+"))
                return 1.3;
            if(grade.equals("D"))
                return 1.0;
            if(grade.equals("F"))
                return 0.0;
            else
                return -1;
       }


       public void loadFromTextFile()
       {

           double gpaValue = 0;
           int credits = 0;

           Scanner inputStream = null;

		       try{
		          inputStream= new Scanner (new FileInputStream("gpa.txt"));
		       }
		       catch (FileNotFoundException e)
		       {
		         createMissingFiles();
		         System.exit(0);
		       }

		       while(inputStream.hasNextLine())
               {
                   String val = inputStream.nextLine();

                   if(val.equals("A"))
                       gpaValue = 4.0;
                   if(val.equals("A-"))
                       gpaValue = 3.7;
                   if(val.equals("B+"))
                       gpaValue = 3.3;
                   if(val.equals("B"))
                       gpaValue = 3.0;
                   if(val.equals("B-"))
                       gpaValue = 2.7;
                   if(val.equals("C+"))
                       gpaValue = 2.3;
                   if(val.equals("C"))
                       gpaValue = 2.0;
                   if(val.equals("C-"))
                       gpaValue = 1.7;
                   if(val.equals("D+"))
                       gpaValue = 1.3;
                   if(val.equals("D"))
                       gpaValue = 1.0;
                   if(val.equals("F"))
                       gpaValue = 0.0;

                   String cr = inputStream.nextLine();
                   credits = Integer.parseInt(cr);


                   totalGradePoints += gpaValue * credits;
                   totalCredits += credits;

                   GPA = totalGradePoints / totalCredits;

                   DecimalFormat f = new DecimalFormat("##.00");
                   gpaField.setText(""+ f.format(GPA));
               }

		       inputStream.close();
       }

       public void generateSummary()
       {

           Scanner inputStream = null;

           ArrayList<String> names = new ArrayList<String>();
           ArrayList<String> letters = new ArrayList<String>();
           ArrayList<Integer> credits = new ArrayList<Integer>();

           //grab data from names file
           try{
               inputStream= new Scanner (new FileInputStream("courseNames.txt"));
           }
           catch (FileNotFoundException e)
           {
               createMissingFiles();
               System.exit(0);
           }

           while(inputStream.hasNextLine())
           {
               names.add(inputStream.nextLine());
           }
           inputStream.close();


           //grab data from gpa file
           try{
               inputStream= new Scanner (new FileInputStream("gpa.txt"));
           }
           catch (FileNotFoundException e)
           {
               createMissingFiles();
               System.exit(0);
           }

           while(inputStream.hasNextLine())
           {
               letters.add(inputStream.nextLine());
               String val = inputStream.nextLine();
               credits.add(Integer.parseInt(val));

           }
           inputStream.close();


           PrintWriter outputStream=null;

           //generate summary file
           try{
               outputStream = new PrintWriter( new FileOutputStream("summary.txt"));
           }
           catch (FileNotFoundException f) {
               System.out.println("File does not exist");
               System.exit(0);
           }

           for(int i=0; i<names.size(); i++)
           {
                outputStream.println(names.get(i) + " with a grade of " + letters.get(i) + " and it is a " + credits.get(i) + " credit class");
           }

           DecimalFormat f = new DecimalFormat("##.00");
           outputStream.println("In sum your GPA is a: " + f.format(GPA));

           outputStream.close();
       }



       public void createMissingFiles()
       {

           PrintWriter outputStream=null;

           //create courseName file
           try{
               outputStream = new PrintWriter( new FileOutputStream("courseNames.txt"));
           }
           catch (FileNotFoundException f) {
               System.out.println("File does not exist");
               System.exit(0);
           }

           outputStream.close();


           //create main GPA file
           try{
               outputStream = new PrintWriter( new FileOutputStream("gpa.txt"));
           }
           catch (FileNotFoundException f) {
               System.out.println("File does not exist");
               System.exit(0);
           }


           outputStream.close();
       }

}


