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

public class DrawSetup extends JFrame implements ActionListener {


    //folder to grab image from and where to save final collage
    private String imagePath = "";

    private int rowsToDraw;

    private JLabel rowsLabel, pixelRateLabel, drawModeLabel;
    private JTextField rowsField, pixelRateField;
    private JButton getImage, draw;

    private JComboBox drawMode;
    private final String[] drawModes = { "Horizontal", "Vertical", "Both"};


    GridBagConstraints layoutConst=null;

    public DrawSetup()
    {
        setTitle("Image Drawer");

        rowsLabel = new JLabel ("Rows/Columns to Draw: ");

        rowsField = new JTextField(10);
        rowsField.setEditable(true);
        rowsField.setText("1");

        pixelRateLabel = new JLabel ("Pixel Draw Rate (milliseconds)");

        pixelRateField = new JTextField(10);
        pixelRateField.setEditable(true);
        pixelRateField.setText("10");

        drawModeLabel = new JLabel ("Pixel Draw Mode: ");

        drawMode = new JComboBox(drawModes);
        drawMode.setSelectedIndex(0);
        drawMode.addActionListener(this);


        getImage = new JButton("Select Image");
        getImage.addActionListener(this);

        draw = new JButton("Draw Image");
        draw.addActionListener(this);

        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();


        layoutConst.gridx=0;
        layoutConst.gridy=0;
        add(rowsLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=0;
        add(rowsField, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=1;
        add(pixelRateLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=1;
        add(pixelRateField, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=2;
        add(drawModeLabel, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=2;
        add(drawMode, layoutConst);

        layoutConst.gridx=0;
        layoutConst.gridy=3;
        add(getImage, layoutConst);

        layoutConst.gridx=1;
        layoutConst.gridy=3;
        add(draw, layoutConst);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == getImage)
        {
            JFileChooser folderChooser = new JFileChooser();
            folderChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int response = folderChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION)
            {
                imagePath = folderChooser.getSelectedFile().getAbsolutePath();
            }
        }

        if(e.getSource() == draw)
        {
            if(imagePath != "") //make sure an image is selected
                drawImage();

        }
    }

    private void drawImage()
    {
        setVisible(false);

        int rowsToDraw = Integer.parseInt(rowsField.getText().trim());
        int pixelRate = Integer.parseInt(pixelRateField.getText().trim()); //get pixel draw rate



        BufferedImage imageToDraw = null; //new image

        try{
            imageToDraw = ImageIO.read(new File(imagePath));
            //this program was designed with Windows systems in mind, but this should still work on Mac
        }
        catch(Exception e)
        {
            System.exit(0);
        }


        if(imageToDraw.getWidth() > 1920 || imageToDraw.getHeight() > 1080)
        {
            int factor = -1;
            int numToDivide = 1;

            while(factor == -1)
            {
                if(imageToDraw.getWidth()/numToDivide <= 1920 && imageToDraw.getHeight()/numToDivide <= 1080)
                    factor = numToDivide;

                numToDivide++;
            }

            imageToDraw = resize(imageToDraw,imageToDraw.getWidth()/factor,imageToDraw.getHeight()/factor); //image resize to aspect ratio
        }

        if(rowsToDraw < 1 || rowsToDraw >= imageToDraw.getHeight())
            rowsToDraw = 1;

        if(pixelRate < 10)
            pixelRate = 10;


        int mode = drawMode.getSelectedIndex();

        DrawImage myFrame = new DrawImage(imageToDraw, rowsToDraw, pixelRate, mode);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(imageToDraw.getWidth(), imageToDraw.getHeight());
        myFrame.setResizable(false);
        myFrame.setVisible(true);
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
