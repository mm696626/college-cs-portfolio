//This collage maker program was made by Matt McCullough


import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        drawFrame();
    }


    public static void drawFrame() {

        CollageMaker myFrame = new CollageMaker();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}
