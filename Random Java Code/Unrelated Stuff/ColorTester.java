import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ColorTester extends JFrame{

	private JSlider rslider;
	private JSlider gslider;
	private JSlider bslider;
	private JTextField rgbvalue;
	private JTextField colorfield;
	private JLabel info;
	private JLabel info2;
	private JLabel info3;
	
	Font bigFont = new Font("SERIF", Font.PLAIN, 25); 
	GridBagConstraints layoutConst=null;
	public ColorTester()
	{
		setTitle("Color Tester");
		rslider = new JSlider(0,255,0);
		gslider = new JSlider(0,255,0);
		bslider = new JSlider(0,255,0);
		
		
		colorfield = new JTextField(10);
        colorfield.setEditable(false);
        colorfield.setText("");
        colorfield.setFont(bigFont);
        
        rgbvalue = new JTextField(10);
        rgbvalue.setEditable(false);
        rgbvalue.setText("");
        
        info = new JLabel("Red");
        info.setForeground(Color.RED);
        info2 = new JLabel("Green");
        info2.setForeground(Color.GREEN);
        info3 = new JLabel("Blue");
        info3.setForeground(Color.BLUE);
        
		rslider.setMajorTickSpacing(255);
		rslider.setPaintTicks(true);
		rslider.setPaintLabels(true);
		rslider.addChangeListener(e ->  changeColor());
		
		gslider.setMajorTickSpacing(255);
		gslider.setPaintTicks(true);
		gslider.setPaintLabels(true);
		gslider.addChangeListener(e ->  changeColor());
		
		bslider.setMajorTickSpacing(255);
		bslider.setPaintTicks(true);
		bslider.setPaintLabels(true);
		bslider.addChangeListener(e ->  changeColor());
	    
		setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
        
		layoutConst.gridx=0;
        layoutConst.gridy=0;
        add(rslider, layoutConst);
       
        layoutConst.gridx=0;
        layoutConst.gridy=1;
        add(gslider, layoutConst);
        
        layoutConst.gridx=0;
        layoutConst.gridy=2;
        add(bslider, layoutConst);
        
        layoutConst.gridx=1;
        layoutConst.gridy=0;
        add(info, layoutConst);
       
        layoutConst.gridx=1;
        layoutConst.gridy=1;
        add(info2, layoutConst);
        
        layoutConst.gridx=1;
        layoutConst.gridy=2;
        add(info3, layoutConst);
        
        layoutConst.gridx=0;
        layoutConst.gridy=3;
        add(colorfield, layoutConst);
        
        layoutConst.gridx=0;
        layoutConst.gridy=4;
        add(rgbvalue, layoutConst);
        	
	}
	
	
	public static void main(String[] args)
	{
		 ColorTester myFrame = new ColorTester();
		 myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     myFrame.pack();
	     myFrame.changeColor();
	     myFrame.setVisible(true);
	}
	public void changeColor()
	{
		Color color = new Color(rslider.getValue(), gslider.getValue(), bslider.getValue());
		colorfield.setBackground(color);
		rgbvalue.setText("("+ rslider.getValue() + "," + gslider.getValue() +"," + bslider.getValue() + ")");
	}
	

}
