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
public class ButtonBasher extends JFrame implements  ActionListener{
	int bashCount=0;
	int bashesperclick=1;
	int fistcost=10, footcost=100, chompcost=1000, swordcost=10000, hammercost=100000, guillotinecost=1000000, hadoukencost=10000000, shoryukencost=100000000;
	private JLabel bashLabel, bpsLabel, upgrades, cost;
    private JTextField bashes, bps, fistcostlabel, footcostlabel, chompcostlabel, swordcostlabel, hammercostlabel, guillotinecostlabel, hadoukencostlabel, shoryukencostlabel;
    private JButton button, save, resetSave;
    private JButton hammer,fist,foot, guillotine,chomp, sword, hadouken,shoryuken;
    GridBagConstraints layoutConst=null;
    
    public ButtonBasher()
    {
    	setTitle("Button Basher");
    	
        bashLabel = new JLabel ("Bashes ");
        bpsLabel = new JLabel("Bashes per Click");
        upgrades = new JLabel("Upgrades");
        cost = new JLabel("Cost");
   
        bashes = new JTextField(10);
        bashes.setEditable(false);
        bashes.setText("" + bashCount);
          
        bps = new JTextField(10);
        bps.setEditable(false);
        bps.setText("" + bashesperclick);
        
        bps = new JTextField(10);
        bps.setEditable(false);
        bps.setText("" + bashesperclick);
        
        fistcostlabel = new JTextField(10);
        fistcostlabel.setEditable(false);
        fistcostlabel.setText("" + fistcost);
        
        footcostlabel = new JTextField(10);
        footcostlabel.setEditable(false);
        footcostlabel.setText("" + footcost);
   
        chompcostlabel = new JTextField(10);
        chompcostlabel.setEditable(false);
        chompcostlabel.setText("" + chompcost);
        
        swordcostlabel = new JTextField(10);
        swordcostlabel.setEditable(false);
        swordcostlabel.setText("" + swordcost);
        
        hammercostlabel = new JTextField(10);
        hammercostlabel.setEditable(false);
        hammercostlabel.setText("" + hammercost);
        
        guillotinecostlabel = new JTextField(10);
        guillotinecostlabel.setEditable(false);
        guillotinecostlabel.setText("" + guillotinecost);
        
        hadoukencostlabel = new JTextField(10);
        hadoukencostlabel.setEditable(false);
        hadoukencostlabel.setText("" + hadoukencost);
        
        shoryukencostlabel = new JTextField(10);
        shoryukencostlabel.setEditable(false);
        shoryukencostlabel.setText("" + shoryukencost);
        
        button = new JButton("Button");
        button.addActionListener(this);
        
        save = new JButton("Save and Quit");
        save.addActionListener(this);
        
        resetSave = new JButton("Reset Save");
        resetSave.addActionListener(this);
        
        fist = new JButton("Fist");
        fist.addActionListener(this);
        
        foot = new JButton("Foot");
        foot.addActionListener(this);
        
        chomp = new JButton("Chomp");
        chomp.addActionListener(this);
        
        sword = new JButton("Sword");
        sword.addActionListener(this);
        
        hammer = new JButton("Hammer");
        hammer .addActionListener(this);
        
        guillotine = new JButton("Guillotine");
        guillotine.addActionListener(this);
        
        
        hadouken = new JButton("Hadouken");
        hadouken.addActionListener(this);
        
        shoryuken = new JButton("Shoryuken");
        shoryuken.addActionListener(this);
        
        
        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
  
        layoutConst.gridx=0;
        layoutConst.gridy=0;
        add(bashLabel, layoutConst);
       
        layoutConst.gridx=1;
        layoutConst.gridy=0;
        add(bpsLabel, layoutConst);
        
        layoutConst.gridx=9;
        layoutConst.gridy=0;
        add(upgrades, layoutConst);
        
        layoutConst.gridx=10;
        layoutConst.gridy=0;
        add(cost, layoutConst);
       
       layoutConst.gridx=0;
       layoutConst.gridy=2;
       add(bashes, layoutConst);
       
       layoutConst.gridx=1;
       layoutConst.gridy=2;
       add(bps, layoutConst);
       
       layoutConst.gridx=0;
       layoutConst.gridy=5;
       add(button, layoutConst);
       
       layoutConst.gridx=0;
       layoutConst.gridy=12;
       add(save, layoutConst);
       
       layoutConst.gridx=0;
       layoutConst.gridy=13;
       add(resetSave, layoutConst);
       
       
       layoutConst.gridx=9;
       layoutConst.gridy=1;
       add(fist, layoutConst);
       
       layoutConst.gridx=9;
       layoutConst.gridy=2;
       add(foot, layoutConst);
       
       layoutConst.gridx=9;
       layoutConst.gridy=3;
       add(chomp, layoutConst);
       
       layoutConst.gridx=9;
       layoutConst.gridy=4;
       add(sword, layoutConst);
       
       
       layoutConst.gridx=9;
       layoutConst.gridy=5;
       add(hammer, layoutConst);
       
       
       layoutConst.gridx=9;
       layoutConst.gridy=6;
       add(guillotine, layoutConst);
       
       
       layoutConst.gridx=9;
       layoutConst.gridy=7;
       add(hadouken, layoutConst);
       
       
       layoutConst.gridx=9;
       layoutConst.gridy=8;
       add(shoryuken, layoutConst);
       
       
       layoutConst.gridx=10;
       layoutConst.gridy=1;
       add(fistcostlabel, layoutConst);
       
       layoutConst.gridx=10;
       layoutConst.gridy=2;
       add(footcostlabel, layoutConst);
       
       layoutConst.gridx=10;
       layoutConst.gridy=3;
       add(chompcostlabel, layoutConst);
       
       layoutConst.gridx=10;
       layoutConst.gridy=4;
       add(swordcostlabel, layoutConst);
       
       layoutConst.gridx=10;
       layoutConst.gridy=5;
       add(hammercostlabel, layoutConst);
       
       layoutConst.gridx=10;
       layoutConst.gridy=6;
       add(guillotinecostlabel, layoutConst);
       
       layoutConst.gridx=10;
       layoutConst.gridy=7;
       add(hadoukencostlabel, layoutConst);
       
       layoutConst.gridx=10;
       layoutConst.gridy=8;
       add(shoryukencostlabel, layoutConst);
       
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button)
        {
            bashCount+=bashesperclick;
            bps.setText("" + bashesperclick);
            bashes.setText(""+bashCount);
            
        }   
        if(e.getSource() == fist)
        {
        	if(bashCount>=fistcost)
        	{
        		bashCount-=fistcost;
            	bashesperclick+=1;
            	fistcost+=10;
        	}
        	bps.setText("" + bashesperclick);
            bashes.setText(""+bashCount);
            fistcostlabel.setText(""+fistcost);
        }
        if(e.getSource() == foot)
        {
        	if(bashCount>=footcost)
        	{
        		bashCount-=footcost;
            	bashesperclick+=5;
            	footcost+=100;
        	}
        	bps.setText("" + bashesperclick);
            bashes.setText(""+bashCount);
            footcostlabel.setText(""+footcost);
        }
        if(e.getSource() == chomp)
        {
        	if(bashCount>=chompcost)
        	{
        		bashCount-=chompcost;
            	bashesperclick+=10;
            	chompcost+=1000;
            	
        	}
        	bps.setText("" + bashesperclick);
            bashes.setText(""+bashCount);
            chompcostlabel.setText(""+chompcost);
        }
        if(e.getSource() == sword)
        {
        	if(bashCount>=swordcost)
        	{
        		bashCount-=swordcost;
            	bashesperclick+=50;
            	swordcost+=10000;
            	
        	}
        	bps.setText("" + bashesperclick);
            bashes.setText(""+bashCount);
            swordcostlabel.setText(""+swordcost);
        }
        if(e.getSource() == hammer)
        {
        	if(bashCount>=hammercost)
        	{
        		bashCount-=hammercost;
            	bashesperclick+=500;
            	hammercost+=100000;
        	}
        	bps.setText("" + bashesperclick);
            bashes.setText(""+bashCount);
            hammercostlabel.setText(""+hammercost);
        }
        if(e.getSource() == guillotine)
        {
        	if(bashCount>=guillotinecost)
        	{
        		bashCount-=guillotinecost;
            	bashesperclick+=5000;
            	guillotinecost+=1000000;
            	
        	}
        	bps.setText("" + bashesperclick);
            bashes.setText(""+bashCount);
            guillotinecostlabel.setText(""+guillotinecost);
        }
        if(e.getSource() == hadouken)
        {
        	if(bashCount>=hadoukencost)
        	{
        		bashCount-=10000000;
            	bashesperclick+=10000;
            	hadoukencost+=10000000;
            	
        	}
        	bps.setText("" + bashesperclick);
            bashes.setText(""+bashCount);
            hadoukencostlabel.setText(""+hadoukencost);
        }
        if(e.getSource() == shoryuken)
        {
        	if(bashCount>=shoryukencost)
        	{
        		bashCount-=shoryukencost;
            	bashesperclick+=100000;
            	shoryukencost+=100000000;
            	
        	}
        	bps.setText("" + bashesperclick);
            bashes.setText(""+bashCount);
            shoryukencostlabel.setText(""+shoryukencost);
        }
        if(e.getSource() == save)
        {
 			 PrintWriter outputStream=null;
 		  
 		       try{
 		          outputStream = new PrintWriter( new FileOutputStream("savefile.txt"));
 		       }
 		       catch (FileNotFoundException f) {
 		         System.out.println("Problem opening files");
 		          System.exit(0);
 		       }
 		       outputStream.println(bashCount + " " + bashesperclick + " " + fistcost + " " + footcost + " " + chompcost + " " + swordcost + " " + hammercost + " " + guillotinecost + " " + hadoukencost + " " + shoryukencost);
 		       outputStream.close();
 		       System.exit(0);
        }
        if(e.getSource() == resetSave)
        {
 			 PrintWriter outputStream=null;
 		  
 		       try{
 		          outputStream = new PrintWriter( new FileOutputStream("savefile.txt"));
 		       }
 		       catch (FileNotFoundException f) {
 		         System.out.println("Problem opening files");
 		          System.exit(0);
 		       }
 		       outputStream.println(0 + " " + 1 + " " + 10 + " " + 100 + " " + 1000 + " " + 10000 + " " + 100000 + " " + 1000000 + " " + 10000000 + " " + 100000000);
 		       outputStream.close();
 		       System.exit(0);
        }
        
 }

	   public static void main(String[] args) {
		   
		   Scanner inputStream=null;
		   ButtonBasher myFrame = new ButtonBasher();
		       try{
		          inputStream= new Scanner (new FileInputStream("savefile.txt"));
		       }
		       catch (FileNotFoundException e)
		       {
		     
		         System.out.println("A save file will be created if this message appears. Please re run");
		         createSave();
		         System.exit(0);
		          
		       }
		       
		       
		      myFrame.setBashCount(inputStream.nextInt());
		      myFrame.setBPS(inputStream.nextInt());
		      myFrame.setFistCost(inputStream.nextInt());
		      myFrame.setFootCost(inputStream.nextInt());
		      myFrame.setChompCost(inputStream.nextInt());
		      myFrame.setSwordCost(inputStream.nextInt());
		      myFrame.setHammerCost(inputStream.nextInt());
		      myFrame.setGuillotineCost(inputStream.nextInt());
		      myFrame.setHadoukenCost(inputStream.nextInt());
		      myFrame.setShoryukenCost(inputStream.nextInt());
		      
		      myFrame.initalizeText();
		      inputStream.close();
		      
	      
	     
	      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      myFrame.pack();
	      myFrame.setVisible(true);
	   }
	   public void setBashCount(int b)
	   {
		   bashCount = b;
	   }
	   public void setBPS(int b)
	   {
		   bashesperclick = b;
	   }
	   public void setFistCost(int f)
	   {
		   fistcost=f;
	   }
	   public void setFootCost(int f)
	   {
		   footcost=f;
	   }
	   public void setChompCost(int c)
	   {
		   chompcost=c;
	   }
	   public void setSwordCost(int s)
	   {
		   swordcost=s;
	   }
	   public void setHammerCost(int h)
	   {
		   hammercost=h;
	   }
	   public void setGuillotineCost(int g)
	   {
		   guillotinecost=g;
	   }
	   public void setHadoukenCost(int h)
	   {
		   hadoukencost=h;
	   }
	   public void setShoryukenCost(int s)
	   {
		   shoryukencost=s;
	   }
	   public static void createSave()
	   {
		   PrintWriter outputStream=null;
	 		  
		       try{
		          outputStream = new PrintWriter( new FileOutputStream("savefile.txt"));
		       }
		       catch (FileNotFoundException f) {
		         System.out.println("Problem opening files");
		          System.exit(0);
		       }
 		       outputStream.println(0 + " " + 1 + " " + 10 + " " + 100 + " " + 1000 + " " + 10000 + " " + 100000 + " " + 1000000 + " " + 10000000 + " " + 100000000);
		       outputStream.close();
		       System.exit(0);
	   }
	   public void initalizeText()
	   {
		   bashes.setText("" + bashCount);
		   bps.setText("" + bashesperclick);
		   fistcostlabel.setText("" + fistcost);
		   footcostlabel.setText("" + footcost);
		   chompcostlabel.setText("" + chompcost);
		   swordcostlabel.setText("" + swordcost);
		   hammercostlabel.setText("" + hammercost);
		   guillotinecostlabel.setText("" + guillotinecost);
		   hadoukencostlabel.setText("" + hadoukencost);
		   shoryukencostlabel.setText("" + shoryukencost);
	   }
}


