import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		Gameplay gameplay = new Gameplay();
		frame.setBounds(10, 10, 1000, 400);
		frame.setTitle("Hangman");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gameplay);

	}

}
