import javax.swing.*;

public class Main {

    public static boolean gpaMode = true; //mode the frame is in

    public static void main(String[] args) {
        drawFrame();
    }


    public static void drawFrame() {
        if (gpaMode != true) {
            WeightedGradeCalculator myFrame = new WeightedGradeCalculator();
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.pack();
            myFrame.setVisible(true);
        }
        else {
            GPACalculator myFrame = new GPACalculator();
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.pack();
            myFrame.loadFromTextFile();
            myFrame.setVisible(true);
        }
    }
}
