import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{

	private Timer timer;

	private final int FPS = 30;
	private final int delay = 1000/FPS;


	private final int rows = 5;
	private final int cols = 5;
	private int[][] board = new int[rows][cols];
	private int[][] copyBoard = new int[rows][cols];
	private int[] calls = new int[75]; //75 possible numbers to call
	private int numCalled = 0;

	private boolean gotBingo = false;
	private boolean cardGenerated = false;

	private boolean viewCalls = false;
	private String displayCall = "";
	
	private int cursorX = 0;
	private int cursorY = 0;


	public Gameplay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer = new Timer(delay,this);
		timer.start();
	}
	
	public void paint(Graphics g)
	{
		//blue background
		g.setColor(Color.blue);
		g.fillRect(0, 0, 1200, 1200);

		if(viewCalls == false)
		{
			for(int i=0; i<5; i++)
			{
				//draw vertical lines
				g.setColor(Color.black);
				g.drawLine((i+1)*140, 0 , (i+1)*140,700);

				//draw horizontal lines
				g.setColor(Color.black);
				g.drawLine(0, (i+1)*140, 700,(i+1)*140);
			}


			//draw bingo card
			for(int x=0; x<rows; x++)
			{
				for(int y=0; y<cols; y++)
				{
					g.setColor(Color.white);
					g.setFont(new Font("serif",Font.BOLD,50));
					if(board[x][y]>0 && board[x][y]<76)
						g.drawString(""+board[x][y],x*140, (y+1)*140);
					else
						g.drawString("X",x*140, (y+1)*140);
				}
			}



			if(!displayCall.equals(""))
			{
				g.setColor(Color.white);
				g.setFont(new Font("serif",Font.BOLD,35));
				g.drawString(displayCall + " was called last",400, 800);
			}



			if(gotBingo == true)
			{
				g.setColor(Color.white);
				g.setFont(new Font("serif",Font.BOLD,35));
				g.drawString("You got BINGO",0, 750);
			}

			g.setColor(Color.red);
			g.drawRect(cursorX*140, cursorY*140, 140,140);
		}

		else
		{
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,30));
			int elementsDrawn = 0;
			int yToDraw = 0;
			for(int i=0; i<calls.length; i++)
			{
				if(calls[i]>0 && calls[i]<76)
				{
					String letterToAdd = "";
					if(calls[i]>=1 && calls[i]<16)
					{
						letterToAdd = "B";
					}
					if(calls[i]>=16 && calls[i]<31)
					{
						letterToAdd = "I";
					}
					if(calls[i]>=31 && calls[i]<46)
					{
						letterToAdd = "N";
					}
					if(calls[i]>=46 && calls[i]<61)
					{
						letterToAdd = "G";
					}
					if(calls[i]>=61 && calls[i]<76)
					{
						letterToAdd = "O";
					}

					g.drawString(letterToAdd+calls[i]+" ",(i%5) * 140, yToDraw+30);
					elementsDrawn++;


				}
				if(elementsDrawn % 5 == 0)
				{
					yToDraw+=50;
				}

			}

		}
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD,30));
		g.drawString("Controls", 0, 800);
		g.drawString("Arrow keys: Select space", 0, 850);
		g.drawString("Enter: Mark off space", 400, 850);
		g.drawString("Space: Call new number", 0, 900);
		g.drawString("R: Reset game", 400, 900);
		g.drawString("T: Toggle view", 0, 950);
		g.drawString("Backspace: Undo", 400, 950);







	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		if(cardGenerated==false)
		{
			generateCard();
			cardGenerated=true;
		}
		repaint();
	}


	public void generateCard()
	{
		Random rng = new Random();
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				int numToAdd = (i*15) + rng.nextInt(15)+1;
				while(checkDuplicate(numToAdd) == true)
				{
					numToAdd = (i*15) + rng.nextInt(15)+1;
				}
				board[i][j] = numToAdd;
				copyBoard[i][j] = numToAdd;
			}
		}

	}

	public boolean checkBINGO()
	{
		//check rows
		int rowCount=0;
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				if(board[i][j] == 0)
				{
					rowCount++;
				}
				else
					rowCount=0;
			}
			if(rowCount==5)
				return true;
			else
				rowCount=0;
		}
		int colCount = 0;
		for(int i=0; i<cols; i++)
		{
			for(int j=0; j<rows; j++)
			{
				if(board[j][i] == 0)
				{
					colCount++;
				}
				else
					colCount=0;
			}
			if(colCount==5)
				return true;
			else
				colCount=0;
		}

		if(board[0][0] == 0 && board[1][1] == 0 && board[2][2] == 0 && board[3][3] == 0 && board[4][4] == 0)
		{
			return true;
		}
		if(board[4][0] == 0 && board[3][1] == 0 && board[2][2] == 0 && board[1][3] == 0 && board[0][4] == 0)
		{
			return true;
		}

		return false;

	}

	public boolean checkIfCalled(int n)
	{
		for(int i=0; i<calls.length; i++)
		{
			if(calls[i] == n)
				return true;
		}

		return false;
	}
	public boolean callNumber()
	{
		Random rng = new Random();
		int num = rng.nextInt(75)+1;

		//check for duplicate call
		for(int i=0; i<calls.length; i++)
		{
			if(num == calls[i])
				return false;
		}


		if(num>=1 && num<16)
		{
			displayCall = "B" + num;
		}
		if(num>=16 && num<31)
		{
			displayCall = "I" + num;
		}
		if(num>=31 && num<46)
		{
			displayCall = "N" + num;
		}
		if(num>=46 && num<61)
		{
			displayCall = "G" + num;
		}
		if(num>=61 && num<76)
		{
			displayCall = "O" + num;
		}


		calls[numCalled] = num;

		return true;
	}
	public void copyBoardContents()
	{
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				board[i][j] = copyBoard[i][j];
			}
		}
	}

	public boolean checkDuplicate(int num)
	{
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				if(board[i][j] == num)
				{
					return true;
				}
			}
		}

		return false;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(cursorX<4)
				cursorX++;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(cursorX>0)
				cursorX--;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			if(cursorY>0)
				cursorY--;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if(cursorY<4)
				cursorY++;
		}

		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{

			if(checkIfCalled(board[cursorX][cursorY]) == true)
			{
				board[cursorX][cursorY] = 0;
			}

			if(checkBINGO() == true)
			{
				gotBingo = true;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			boolean called = false;
			if(numCalled<75)
			{
				while(called == false)
				{
					if(callNumber() == true)
					{
						numCalled++;
						called = true;
					}
				}
			}

		}
		if(e.getKeyCode() == KeyEvent.VK_R)
		{
			generateCard();
			gotBingo=false;
			numCalled=0;
			calls = new int[75];
			displayCall="";
		}
		if(e.getKeyCode() == KeyEvent.VK_T)
		{
			if(viewCalls == false)
				viewCalls = true;
			else
				viewCalls = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
		{
			copyBoardContents();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
