import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        drawFrame();
    }


    public static void drawFrame() {
        DrawSetup myFrame = new DrawSetup();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);

    }
}
