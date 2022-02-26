/**
 * @author Matthew McCullough
 * @date 4/18/2019
 * This program experiments with comboBoxes and uses .gif files to change pictures on the screen with a drop-down menu
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

/**
 * ComboBoxDemo.java uses these additional files:
 *   images/Blue Shell.gif
 *   images/Dance.gif
 *   images/Imagination.gif
 *   images/Money.gif
 *   images/Pikachu.gif
 *   images/Taken Care Of.gif
 */
public class ComboBoxDemo1 extends JPanel implements ActionListener {
    JLabel picture;
    JComboBox List;
    JTextField info;
    JButton getComment, mystery;
    String lastImage;
    public ComboBoxDemo1() {
        super(new BorderLayout());

        String[] Strings = { "Blue Shell", "Dance", "Imagination", "Pikachu", "Taken Care Of"};

        /**Create the combo box, select the item at index 4.*/
        /**Indices start at 0, so 4 specifies the fifth item.*/
        List = new JComboBox(Strings);
        List.setSelectedIndex(0);
        List.addActionListener(this);

        Font bigFont = new Font("SERIF", Font.PLAIN, 50);
        //Set up the picture.
        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);
        updateLabel(Strings[List.getSelectedIndex()]);
        picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        
        
        info = new JTextField(30);
        info.setFont(bigFont);
        info.setEditable(false);
        info.setText("");
        
        getComment = new JButton("Get a Comment");
        getComment.addActionListener(this);
        
        mystery = new JButton("Mystery Button");
        mystery.addActionListener(this);
        
        

        /**
         * //The preferred size is hard-coded to be the width of the
        	widest image and the height of the tallest image + the border.
         * A real program would compute this.
        */
        picture.setPreferredSize(new Dimension(700, 800));

        //Lay out the demo.
        add(List, BorderLayout.PAGE_START);
        add(picture, BorderLayout.CENTER);
        add(getComment, BorderLayout.WEST);
        add(mystery, BorderLayout.EAST);
        add(info, BorderLayout.PAGE_END); 
      
        
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    /** Listens to the combo box. */
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == getComment)
        {
    		updateLabel(lastImage);
    		updateComment();
        }
    	else if(e.getSource() == mystery)
    	{
    		mystery();
    	}
    	else
    	{
    		JComboBox cb = (JComboBox)e.getSource();
            String pictureName = (String)cb.getSelectedItem();
            updateLabel(pictureName);
    	}
        
        
    }

    protected void updateLabel(String name) {
        ImageIcon icon = createImageIcon( name + ".gif");
        picture.setIcon(icon);
        picture.setToolTipText("A drawing of a " + name.toLowerCase());
        if (icon != null) 
        {
            picture.setText(null);
            if(!name.equalsIgnoreCase("money"))
            	lastImage = name;
        } 
        else 
        {
            picture.setText("Image not found");
        }
    }
    protected void updateComment() {
    	Random rng = new Random();
    	int comment = rng.nextInt(10)+1;
        if(comment==1)
        	info.setText("This is great!");
        else if(comment==2)
        	info.setText("I'm dying of laughter");
        else if(comment==3)
        	info.setText("This stinks");
        else if(comment==4)
        	info.setText("What part of the planet did you come from?");
        else if(comment==5)
        	info.setText("LOL XD");
        else if(comment==6)
        	info.setText("What is this and I need more of it");
        else if(comment==7)
        	info.setText("Take my money!");
        else if(comment==8)
        	info.setText("TROLOLOLOLOL");
        else if(comment==9)
        	info.setText(":)");
        else
        {
        	info.setText("<3");
        }
        
        
        
    }
    protected void mystery()
    {
    	Random rng = new Random();
    	int special = rng.nextInt(100)+1;
    	if(special<=15)
    	{
    		info.setText("You found the secret and you win a million dollars!");
    		updateLabel("Money");
    		
    	}
    	else
    	{
    		info.setText("The button did nothing, try again!");
    		updateLabel(lastImage);
    	}
    		
    }
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ComboBoxDemo1.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        /**Create and set up the window.*/
        JFrame frame = new JFrame("ComboBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**Create and set up the content pane.*/
        JComponent newContentPane = new ComboBoxDemo1();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        /**Display the window.*/
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    			
                createAndShowGUI();
            }
       
    
}