import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CollageMaker extends JFrame implements ActionListener {


    //paths of images
    private String imagePath = "";
    private String[] imagePaths;

    //current position in the image
    private int xPos = 0;
    private int yPos = 0;

    //width and height of final collage
    private int width=0;
    private int height=0;

    //number of images
    private int numImages = 0;

    //width and height for each section of image
    private int sectionWidth = 0;
    private int sectionHeight = 0;

    private boolean repeatImages = false;

    //possible choices
    private ArrayList<Integer> possibleHorizontal = new ArrayList<Integer>();
    private ArrayList<Integer> possibleVertical = new ArrayList<Integer>();

    //to find section length
    private ArrayList<Integer> horizontalScale = new ArrayList<Integer>();
    private ArrayList<Integer> verticalScale = new ArrayList<Integer>();

    private JLabel widthLabel, heightLabel, numImagesLabel, choiceLabel, repeatLabel;
    private JTextField widthField, heightField, numImagesField, choiceField;
    private JTextArea choices;
    private JButton toOptions, generate, back;
    private JComboBox repeat;

    private final String[] repeatSettings = {"Use Different Images", "Repeat Same Image"};


    GridBagConstraints layoutConst=null;

    public CollageMaker()
    {
        setTitle("Collage Maker");


        widthLabel = new JLabel ("Width of Collage ");
        heightLabel = new JLabel ("Height of Collage ");
        numImagesLabel = new JLabel ("Number of Images ");


        widthField = new JTextField(10);
        widthField.setEditable(true);
        widthField.setText("1920");

        heightField = new JTextField(10);
        heightField.setEditable(true);
        heightField.setText("1080");

        numImagesField = new JTextField(10);
        numImagesField.setEditable(true);
        numImagesField.setText("2");


        toOptions = new JButton("To Collage Options");
        toOptions.addActionListener(this);


        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();

        layoutConst.gridx=0;
        layoutConst.gridy=0;
        add(widthLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=0;
        add(widthField, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=1;
        add(heightLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=1;
        add(heightField, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=2;
        add(numImagesLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=2;
        add(numImagesField, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=4;
        add(toOptions, layoutConst);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == toOptions)
        {
            try
            {
                width = Integer.parseInt(widthField.getText().trim());
                height = Integer.parseInt(heightField.getText().trim());
                numImages = Integer.parseInt(numImagesField.getText().trim());
            }
            catch(Exception ex)
            {
                return;
            }

            //prevent errors
            if(!(width <= 0 || height <= 0 || numImages <= 0))
            {
                drawCollageOptions();
            }
        }
        if(e.getSource() == generate)
        {
            chooseAndGenerate();
        }

        if(e.getSource() == back)
        {
            setVisible(false);
            CollageMaker frame = new CollageMaker();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }



    private void drawCollageOptions()
    {
        setVisible(false);

        //remove all the previous frame things

        remove(toOptions); //remove options button

        remove(widthLabel);
        remove(widthField);

        remove(heightLabel);
        remove(heightField);

        remove(numImagesLabel);
        remove(numImagesField);

        choices = new JTextArea();
        choices.setEditable(false);
        choices.setText("");


        choiceLabel = new JLabel ("Enter Choice ");

        choiceField = new JTextField(10);
        choiceField.setEditable(true);
        choiceField.setText("0");

        repeatLabel = new JLabel ("Repeat Images Setting ");

        repeat = new JComboBox(repeatSettings);
        repeat.setSelectedIndex(0);
        repeat.addActionListener(this);


        generate = new JButton("Create Collage");
        generate.addActionListener(this);

        back = new JButton("Go Back");
        back.addActionListener(this);

        layoutConst.gridx=0;
        layoutConst.gridy=0;
        add(choices, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=1;
        add(choiceLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=1;
        add(choiceField, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=2;
        add(repeatLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=2;
        add(repeat, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=3;
        add(generate, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=4;
        add(back, layoutConst);

        getPossibleChoices();

        pack();
        setVisible(true);
    }



    private void getPossibleChoices()
    {
        for(int i=1; i<=width; i++)
        {
            if(width%i == 0)
                possibleHorizontal.add(i);
        }

        for(int i=1; i<=height; i++)
        {
            if(height%i == 0)
                possibleVertical.add(i);
        }

        //now do final calculations (copy to an array, for comparison as arrays autofill with 0 for differing sizes)
        int sizeOfArray;


        if(possibleHorizontal.size() < possibleVertical.size())
            sizeOfArray=possibleVertical.size(); //smaller

        else
            sizeOfArray=possibleHorizontal.size(); //equal or larger

        //copy to arrays
        int[] horizontal = new int[sizeOfArray];
        int[] vertical = new int[sizeOfArray];

        for(int i=0; i<possibleHorizontal.size(); i++)
        {
            horizontal[i] = width/possibleHorizontal.get(i);
        }

        for(int i=0; i<possibleVertical.size(); i++)
        {
            vertical[i] = height/possibleVertical.get(i);
        }


        for(int i=0; i<sizeOfArray; i++)
        {
            for(int j=0; j<sizeOfArray; j++)
            {
                if(horizontal[i] * vertical[j] == numImages)
                {
                    horizontalScale.add(possibleHorizontal.get(i));
                    verticalScale.add(possibleVertical.get(j));
                }
            }

        }

        if(horizontalScale.size() == 0 || verticalScale.size() == 0)
        {
            choices.setText("No Options Exist! Try Again!");

            //remove frame stuff if no options exist to prevent errors with image creation
            remove(generate);
            remove(choiceLabel);
            remove(choiceField);
        }

        else
        {
            String textToDisplay = "";
            textToDisplay += "What image size do you want for the new image" + "\n";

            for(int i=0; i<horizontalScale.size(); i++)
            {
                textToDisplay += (i + " - " + horizontalScale.get(i) + "x" + verticalScale.get(i) + " which would be " + width/horizontalScale.get(i) + "x" + height/verticalScale.get(i) + "\n");
            }

            choices.setText(textToDisplay);
        }
    }

    private void chooseAndGenerate()
    {
        int choice;

        try
        {
            choice = Integer.parseInt(choiceField.getText().trim());
        }
        catch(Exception e)
        {
            return;
        }

        if(choice < 0 || choice >= horizontalScale.size()) //check if valid
        {
            return;
        }

        sectionWidth = horizontalScale.get(choice);
        sectionHeight = verticalScale.get(choice);

        //whether to repeat images or not
        if(repeat.getSelectedIndex() == 0)
            repeatImages = false;
        else
            repeatImages = true;


        //reset position in the image
        xPos = 0;
        yPos = 0;

        BufferedImage collage;
        collage = createCollage(width, height);

        if(collage == null)
            return;

        File imageFile = new File("collage.png");

        try
        {
            ImageIO.write(collage, "png", imageFile); //this is where the image is saved to
        }
        catch(Exception e)
        {
            return;
        }

        JOptionPane.showMessageDialog(this, "Your collage has been successfully saved to: " + imageFile.getAbsolutePath());

    }

    private BufferedImage createCollage(int w, int h)
    {

        //set up paths array
        if(repeatImages == false)
            imagePaths = new String[numImages];

        BufferedImage current = null; //current image

        BufferedImage newImage = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB); //new image

        Graphics2D g2d = newImage.createGraphics();
        g2d.setPaint(Color.white);
        g2d.fillRect(0, 0, w, h);

        if(repeatImages == true)
        {
            JFileChooser imageChooser = new JFileChooser();
            int response = imageChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION)
            {
                imagePath = imageChooser.getSelectedFile().getAbsolutePath();
            }

            try{
                current = ImageIO.read(new File(imagePath));
            }
            catch(Exception e)
            {
                //already handled it below
            }
        }

        for(int i=0; i<numImages; i++)
        {

            if(repeatImages == false)
            {
                current = null; //reset image data
                JFileChooser imageChooser = new JFileChooser();
                int response = imageChooser.showOpenDialog(null);
                if(response == JFileChooser.APPROVE_OPTION)
                {
                    imagePaths[i] = imageChooser.getSelectedFile().getAbsolutePath();
                }

                try{
                    current = ImageIO.read(new File(imagePaths[i]));
                }
                catch(Exception e)
                {
                    //already handled it below
                }
            }

            if(current == null)
                return null;

            if(current.getWidth() != sectionWidth || current.getHeight() != current.getHeight()) //if size doesn't match specified
            {
                current = resize(current, sectionWidth, sectionHeight); //resize to correct size
            }

            g2d = newImage.createGraphics();
            g2d.drawImage(current, xPos, yPos, null); //draw section of image


            xPos+=sectionWidth; //move xPos

            //check if at end of row
            if(xPos >= w) //if at end of image, move down to next row
            {
                xPos=0;
                yPos+=sectionHeight; //move yPos to next row
            }
        }

        return newImage;
    }


    private static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_DEFAULT);
        BufferedImage resized = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return resized;
    }


}
