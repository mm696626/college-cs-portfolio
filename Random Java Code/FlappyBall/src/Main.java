import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		Gameplay gameplay = new Gameplay();
		frame.setBounds(10, 10, 700, 550);
		frame.setTitle("Flappy Ball");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gameplay);

	}

}
