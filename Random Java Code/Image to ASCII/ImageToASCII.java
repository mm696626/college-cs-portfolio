import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ImageToASCII extends JFrame implements ActionListener {


    //where to grab image from
    private String imagePath = "";

    private ArrayList<Color> colors = new ArrayList<Color>();
    Color lastPixel = null; //color of last pixel
    Color currentPixel = null; //color of current pixel

    private boolean pickSymbolEveryPixel; //pick a character for every pixel
    private boolean luminosity; //use the luminosity method for more accurate light and dark colors
    private boolean useAverageLightColor; //uses the average color as a basis for light vs dark colors
    private boolean removeTransparentBackground; //uses the average color as a basis for light vs dark colors


    //chars to use for shades (sorted by how many dark pixels the character has highest-lowest or darkest-lightest)
    //light colors use spaces
    private final char[] darkChars = {'@','M','W','%','#','B','R','N','$','D','E','H','Q','S','&','G','6','8','9','A','O','P','Z','0','K','U','5','4','C','X','F','V','2','3','T','L','J','Y','7','=','?','1','|','I','^','*','+','<','>','/','!',';','-',',',':','.'};
    private int lightColorThreshold = 128; //what RGB is considered to be a "light" color

    private char[] charsToUse; //chars to use from the sets above if not picking pixel by pixel

    private int colorMargin; //if RGB value is within this many, then use the same symbol to cut down on number of symbols
    private double scale; //image scale (1920x1080 with .5 scale would be 960x540)
    private int rotationAngle; //angle to rotate image at

    private JLabel colorMarginLabel, scaleLabel, drawLabel, lightLabel, luminosityLabel, averageLightLabel, removeTransparentLabel, rotationLabel;
    private JTextField colorMarginField, scaleField, lightField;
    private JButton convertToASCII, convertToImage, resetSettings;


    private JComboBox drawMode, luminosityMode, averageLightMode, removeTransparentMode, rotationMode;
    private final String[] drawChoice = {"New Symbols per Pixel", "Repeat for Similar Colors"};
    private final String[] yesNoChoice = {"Yes", "No"};
    private final String[] rotationChoice = {"No Rotation", "90 Degrees", "180 Degrees", "270 Degrees"};


    GridBagConstraints layoutConst=null;

    public ImageToASCII()
    {
        setTitle("Image to ASCII");

        colorMarginLabel = new JLabel ("RGB Difference to use Same Symbols (20-255)");

        colorMarginField = new JTextField(10);
        colorMarginField.setEditable(true);
        colorMarginField.setText("30");

        scaleLabel = new JLabel ("Scale of Image (1 is the entire image)");

        scaleField = new JTextField(10);
        scaleField.setEditable(true);
        scaleField.setText(".5");

        convertToASCII = new JButton("Convert Image to ASCII");
        convertToASCII.addActionListener(this);

        resetSettings = new JButton("Reset Settings");
        resetSettings.addActionListener(this);

        convertToImage = new JButton("Convert ASCII to Image");
        convertToImage.addActionListener(this);

        lightLabel = new JLabel ("Light Color RGB (0-255) (light colors are drawn as spaces)");


        lightField = new JTextField(10);
        lightField.setEditable(true);
        lightField.setText("200");



        drawLabel = new JLabel ("Symbol Draw Mode");


        drawMode = new JComboBox(drawChoice);
        drawMode.setSelectedIndex(1);
        drawMode.addActionListener(this);

        luminosityLabel = new JLabel ("Use Luminosity Method for Light/Dark colors");


        luminosityMode = new JComboBox(yesNoChoice);
        luminosityMode.setSelectedIndex(0);
        luminosityMode.addActionListener(this);


        averageLightLabel = new JLabel ("Use Average RGB of Image for Light/Dark colors (Overrides Light RGB)");


        averageLightMode = new JComboBox(yesNoChoice);
        averageLightMode.setSelectedIndex(1);
        averageLightMode.addActionListener(this);


        removeTransparentLabel = new JLabel ("Remove Transparent Background (for transparent images)");


        removeTransparentMode = new JComboBox(yesNoChoice);
        removeTransparentMode.setSelectedIndex(1);
        removeTransparentMode.addActionListener(this);

        rotationLabel = new JLabel ("Image Rotation");


        rotationMode = new JComboBox(rotationChoice);
        rotationMode.setSelectedIndex(0);
        rotationMode.addActionListener(this);


        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();


        layoutConst.gridx=0;
        layoutConst.gridy=0;
        add(colorMarginLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=0;
        add(colorMarginField, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=1;
        add(scaleLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=1;
        add(scaleField, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=2;
        add(lightLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=2;
        add(lightField, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=3;
        add(drawLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=3;
        add(drawMode, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=4;
        add(luminosityLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=4;
        add(luminosityMode, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=5;
        add(averageLightLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=5;
        add(averageLightMode, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=6;
        add(removeTransparentLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=6;
        add(removeTransparentMode, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=7;
        add(rotationLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=7;
        add(rotationMode, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=8;
        add(convertToASCII, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=9;
        add(convertToImage, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=9;
        add(resetSettings, layoutConst);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == convertToASCII)
        {
            convertImage();
        }

        if(e.getSource() == convertToImage)
        {
            convertASCII();
        }

        if(e.getSource() == resetSettings)
        {
            setVisible(false);
            ImageToASCII frame = new ImageToASCII();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }

    private void convertASCII()
    {

        Scanner inputStream = null;

        //get width and height of image from ASCII

        try
        {
            inputStream = new Scanner(new File("asciiArt.txt"));
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Please create ASCII art first! There is no ASCII art here to convert!");
            return;
        }

        int width = 0;
        int height = 0;

        while(inputStream.hasNextLine())
        {
            int lineLength = inputStream.nextLine().length();
            height++;
            if(lineLength > width)
                width = lineLength;
        }

        inputStream.close(); //reset position by closing and opening again


        try
        {
            inputStream = new Scanner(new File("asciiArt.txt"));
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Please create ASCII art first! There is no ASCII art here to convert!");
            return;
        }


        //create image

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        File asciiImage = new File("asciiImage.png");

        String line = inputStream.nextLine();

        //draw pixels to image
        for(int i=0; i<height; i++)
        {
            for(int j=0; j<width; j++)
            {
                Color pixel = getASCIIColor(line.charAt(j)); //get color of pixel
                image.setRGB(j, i, pixel.getRGB());
            }

            if(inputStream.hasNextLine()) //if the file has another line get it
                line = inputStream.nextLine();
        }


        try
        {
            ImageIO.write(image, "png", asciiImage);
        }
        catch(Exception e)
        {
            return;
        }

        inputStream.close();
        JOptionPane.showMessageDialog(this, "Your image from your ASCII art has been successfully saved to: " + asciiImage.getAbsolutePath());
    }

    private Color getASCIIColor(char c)
    {

        for(int i=0; i<darkChars.length; i++)
        {
            if(c == darkChars[i])
            {
                double fractionOfData = (double)i/darkChars.length; //this can never be 1 since white is spaces which is covered below
                int rgb = (int)(fractionOfData * 255); //get rgb
                return new Color(rgb, rgb, rgb);
            }
        }

        return new Color(255, 255, 255); //assume white if space or invalid character not in array
    }

    private void convertImage()
    {

        try
        {
            colorMargin = Integer.parseInt(colorMarginField.getText().trim()); //get RGB margin
            scale = Double.parseDouble(scaleField.getText().trim());  //get scale
            lightColorThreshold = Integer.parseInt(lightField.getText().trim()); //get threshold for light colors
        }
        catch(Exception e)
        {
            return;
        }


        if(colorMargin < 20 || colorMargin > 255 || scale <= 0 || scale > 1 || lightColorThreshold < 0 || lightColorThreshold > 255)
        {
            return;
        }

        JFileChooser imageChooser = new JFileChooser();
        imageChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int response = imageChooser.showOpenDialog(null);
        if(response == JFileChooser.APPROVE_OPTION)
        {
            imagePath = imageChooser.getSelectedFile().getAbsolutePath();
        }
        else
        {
            return;
        }


        BufferedImage imageToDraw = null; //new image

        try{
            imageToDraw = ImageIO.read(new File(imagePath));
        }
        catch(Exception e)
        {
            return;
        }

        if(imageToDraw == null)
        {
            return;
        }

        //get angle of rotation
        if(rotationMode.getSelectedIndex() == 0)
            rotationAngle = 0;
        else if(rotationMode.getSelectedIndex() == 1)
            rotationAngle = 90;
        else if(rotationMode.getSelectedIndex() == 2)
            rotationAngle = 180;
        else
            rotationAngle = 270;


        imageToDraw = resize(imageToDraw,(int)(imageToDraw.getWidth() * scale),(int)(imageToDraw.getHeight() * scale));


        if(drawMode.getSelectedIndex() == 0)
            pickSymbolEveryPixel = true;
        else
            pickSymbolEveryPixel = false;


        if(luminosityMode.getSelectedIndex() == 0)
            luminosity = true;
        else
            luminosity = false;

        if(averageLightMode.getSelectedIndex() == 0)
            useAverageLightColor = true;
        else
            useAverageLightColor = false;

        if(removeTransparentMode.getSelectedIndex() == 0)
            removeTransparentBackground = true;
        else
            removeTransparentBackground = false;


        if(removeTransparentBackground == true) //do this first so average isn't off
        {
            //removes the transparent background on some images
            imageToDraw = removeTransparentBackground(imageToDraw);
        }

        if(useAverageLightColor == true)
        {
            //this also takes the transparency, luminosity setting and resized image into the average since both are set before this
            lightColorThreshold = calcAverage(imageToDraw); //calculate average color of image and set it to the threshold
            lightField.setText(lightColorThreshold + "");
        }

        File asciiArt = new File("asciiArt.txt");

        PrintWriter outputStream = null;

        try{
            outputStream = new PrintWriter( new FileOutputStream(asciiArt));
        }
        catch (FileNotFoundException f) {
            return;
        }

        //I put 90 as the else statement since it was easier for me to read

        //once image is resized based on line width (then do things based on options selected)
        if(pickSymbolEveryPixel == false) //don't pick a unique symbol every pixel
        {

            //only approximate the color
            for(int i=0; i<imageToDraw.getWidth(); i++)
            {
                for(int j=0; j<imageToDraw.getHeight(); j++)
                {
                    if(i != 0 && j != 0) //if not first pixel of image
                    {
                        currentPixel = new Color(imageToDraw.getRGB(i,j)); //new pixel

                        if(!(Math.abs(lastPixel.getRed() - currentPixel.getRed()) <= colorMargin && Math.abs(lastPixel.getGreen() - currentPixel.getGreen()) <= colorMargin && Math.abs(lastPixel.getBlue() - currentPixel.getBlue()) <= colorMargin))
                        {
                            //if not similar in rgb value to last pixel then add color
                            if(checkIfColorExists() == false) //if the color doesn't exist yet, then add it
                                colors.add(currentPixel);
                        }
                    }
                    lastPixel = new Color(imageToDraw.getRGB(i,j)); //last pixel that's updated after the check
                }
            }


            pickChars(); //pick chars to add to the array of chars


            //draw image as ASCII

            if(rotationAngle == 0)
            {
                for(int i=0; i<imageToDraw.getHeight(); i++)
                {
                    for(int j=0; j<imageToDraw.getWidth(); j++)
                    {
                        //compare the colors to image if similar then draw that character
                        int index = checkColorToDraw(imageToDraw, j,i);
                        outputStream.print(charsToUse[index]);
                    }
                    outputStream.println();
                }
            }
            else if(rotationAngle == 180)
            {
                for(int i=imageToDraw.getHeight()-1; i>=0; i--)
                {
                    for(int j=imageToDraw.getWidth()-1; j>=0; j--)
                    {
                        //compare the colors to image if similar then draw that character
                        int index = checkColorToDraw(imageToDraw, j,i);
                        outputStream.print(charsToUse[index]);
                    }
                    outputStream.println();
                }
            }
            else if(rotationAngle == 270)
            {
                for(int i=imageToDraw.getWidth()-1; i>=0; i--)
                {
                    for(int j=0; j<imageToDraw.getHeight(); j++)
                    {
                        //compare the colors to image if similar then draw that character
                        int index = checkColorToDraw(imageToDraw, i,j);
                        outputStream.print(charsToUse[index]);
                    }
                    outputStream.println();
                }
            }
            else
            {
                for(int i=0; i<imageToDraw.getWidth(); i++)
                {
                    for(int j=imageToDraw.getHeight()-1; j>=0; j--)
                    {
                        //compare the colors to image if similar then draw that character
                        int index = checkColorToDraw(imageToDraw, i,j);
                        outputStream.print(charsToUse[index]);
                    }
                    outputStream.println();
                }
            }
        }

        else
        {
            if(rotationAngle == 0)
            {
                for(int i=0; i<imageToDraw.getHeight(); i++)
                {
                    for(int j=0; j<imageToDraw.getWidth(); j++)
                    {
                        Color pixelColor = new Color(imageToDraw.getRGB(j,i)); //get exact RGB value of pixel
                        int lightNum = getLightColorThreshold(pixelColor);
                        if(lightNum >= lightColorThreshold) //if the R, G, and B values are at least the light color threshold, then light color
                        {
                            outputStream.print(' ');
                        }
                        else
                        {
                            int charToPick = pickDarkChar(lightNum); //picks a dark char for the current pixel
                            outputStream.print(darkChars[charToPick]);
                        }

                    }
                    outputStream.println();
                }
            }
            else if(rotationAngle == 180)
            {
                for(int i=imageToDraw.getHeight()-1; i>=0; i--)
                {
                    for(int j=imageToDraw.getWidth()-1; j>=0; j--)
                    {
                        Color pixelColor = new Color(imageToDraw.getRGB(j,i)); //get exact RGB value of pixel
                        int lightNum = getLightColorThreshold(pixelColor);
                        if(lightNum >= lightColorThreshold) //if the R, G, and B values are at least the light color threshold, then light color
                        {
                            outputStream.print(' ');
                        }
                        else
                        {
                            int charToPick = pickDarkChar(lightNum); //picks a dark char for the current pixel
                            outputStream.print(darkChars[charToPick]);
                        }

                    }
                    outputStream.println();
                }
            }
            else if(rotationAngle == 270)
            {
                for(int i=imageToDraw.getWidth()-1; i>=0; i--)
                {
                    for(int j=0; j<imageToDraw.getHeight(); j++)
                    {
                        Color pixelColor = new Color(imageToDraw.getRGB(i,j)); //get exact RGB value of pixel
                        int lightNum = getLightColorThreshold(pixelColor);
                        if(lightNum >= lightColorThreshold) //if the R, G, and B values are at least the light color threshold, then light color
                        {
                            outputStream.print(' ');
                        }
                        else
                        {
                            int charToPick = pickDarkChar(lightNum); //picks a dark char for the current pixel
                            outputStream.print(darkChars[charToPick]);
                        }

                    }
                    outputStream.println();
                }
            }
            else
            {
                for(int i=0; i<imageToDraw.getWidth(); i++)
                {
                    for(int j=imageToDraw.getHeight()-1; j>=0; j--)
                    {
                        Color pixelColor = new Color(imageToDraw.getRGB(i,j)); //get exact RGB value of pixel
                        int lightNum = getLightColorThreshold(pixelColor);
                        if(lightNum >= lightColorThreshold) //if the R, G, and B values are at least the light color threshold, then light color
                        {
                            outputStream.print(' ');
                        }
                        else
                        {
                            int charToPick = pickDarkChar(lightNum); //picks a dark char for the current pixel
                            outputStream.print(darkChars[charToPick]);
                        }

                    }
                    outputStream.println();
                }
            }

        }

        outputStream.close();
        JOptionPane.showMessageDialog(this, "Your ASCII art has been successfully saved to: " + asciiArt.getAbsolutePath());
    }

    private BufferedImage removeTransparentBackground(BufferedImage image)
    {
        BufferedImage newImage = new BufferedImage(image.getWidth(),image.getHeight(), BufferedImage.TYPE_INT_ARGB); //new image
        Graphics2D g2d = newImage.createGraphics();
        g2d.setPaint(Color.white);
        g2d.fillRect(0, 0, newImage.getWidth(), newImage.getHeight());
        g2d.drawImage(image, 0, 0, null);
        return newImage;
    }


    private int calcAverage(BufferedImage image)
    {
        int red = 0;
        int green = 0;
        int blue = 0;


        for(int i=0; i<image.getWidth(); i++)
        {
            for(int j=0; j<image.getHeight(); j++)
            {
                Color pixel = new Color(image.getRGB(i,j));
                red += pixel.getRed();
                green += pixel.getGreen();
                blue += pixel.getBlue();
            }
        }

        red = red/(image.getWidth() * image.getHeight());
        green = green/(image.getWidth() * image.getHeight());
        blue = blue/(image.getWidth() * image.getHeight());

        Color averageColor = new Color(red,green,blue);

        int average = getLightColorThreshold(averageColor);

        return average;
    }


    private int getLightColorThreshold(Color c)
    {
        if(luminosity == true) //uses luminosity method (0.299R + 0.587G + 0.114B)
            return (int)((.299*c.getRed()) + (.587*c.getGreen()) + (.114*c.getBlue()));
        else //takes average of RGB values
            return (int)((c.getRed()+c.getGreen()+c.getBlue())/3.0);
    }

    private int pickDarkChar(int lightNum)
    {
        double fractionOfData = (double)lightNum/lightColorThreshold; //how close a color is to the threshold
        double result = fractionOfData * darkChars.length; //since darker chars are first in the array do multiply by length, so if it is .1 (RGB was 10/100 threshold), it would go 10% of the characters since darkest to lighest
        int charToPick = (int)result;

        if(charToPick >= darkChars.length)
            charToPick = darkChars.length - 1; //if this just so happens to be the length of the array subtract 1 so it's in bounds

        return charToPick;
    }

    private int checkColorToDraw(BufferedImage image, int x, int y)
    {
        Color pixelColor = new Color(image.getRGB(x,y)); //pixel of image


        for(int i=0; i<colors.size(); i++)
        {
            if((Math.abs(pixelColor.getRed() - colors.get(i).getRed()) <= colorMargin+20 && Math.abs(pixelColor.getGreen() - colors.get(i).getGreen()) <= colorMargin+20 && Math.abs(pixelColor.getBlue() - colors.get(i).getBlue()) <= colorMargin+20))
            {
                return i; //if similar in rgb value to a color in the arraylist to the current pixel
            }
        }

        return 0; //this is here as a failsafe in case of color variation, and it's 0 to prevent any potential errors
    }

    private boolean checkIfColorExists()
    {
        for(int i=0; i<colors.size(); i++) //check array for similar colors before adding
        {
            if((Math.abs(colors.get(i).getRed() - currentPixel.getRed()) <= colorMargin && Math.abs(colors.get(i).getGreen() - currentPixel.getGreen()) <= colorMargin && Math.abs(colors.get(i).getBlue() - currentPixel.getBlue()) <= colorMargin))
            {
                //if similar color already exists, don't add it
                return true;
            }
        }
        return false;
    }

    private void pickChars()
    {
        charsToUse = new char[colors.size()];

        char newChar;

        for(int i=0; i<colors.size(); i++)
        {
            Color currentColor = colors.get(i);
            int lightNum = getLightColorThreshold(currentColor);

            if(lightNum >= lightColorThreshold) //if the sum of the R, G, and B values are at least the light color threshold * 3, then light color
            {
                newChar = ' ';
            }
            else
            {
                int charToPick = pickDarkChar(lightNum); //picks a dark char for the current color
                newChar = darkChars[charToPick];
            }

            charsToUse[i] = newChar;
        }
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
