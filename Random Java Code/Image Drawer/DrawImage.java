import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;

public class DrawImage extends JFrame implements ActionListener{

	private Timer timer;
	private int delay;


	//basically lets the frame catch up with drawing before beginning to draw
	private int wait = 0;
	private boolean startDraw = false;

	private BufferedImage image;
	private BufferedImage drawnImage;

	private int drawRows;
	private int drawMode;

	private int xPos = 0;
	private int yPos = 0;

	//exclusively for both mode
	private int xPos2 = 0;
	private int yPos2 = 0;

	public DrawImage(BufferedImage b, int r, int d, int m)
	{

		drawRows = r;
		delay = d;
		image = b;
		drawMode = m;

		timer = new Timer(delay,this);
		timer.start();

		drawnImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB); //new image

	}
	
	public void paint(Graphics g)
	{
		if(startDraw == false)
		{
			g.setColor(Color.white);
			g.fillRect(0,0,image.getWidth(), image.getHeight());
		}
		else
			g.drawImage(drawnImage, 0,0,null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		wait++;
		if(wait > 0 && startDraw == false)
		{
			startDraw=true;
		}

		if(startDraw == true)
		{
			if(drawMode == 0) //horizontal
			{
				if(xPos > image.getWidth() - 1) //prevent OOB of image (pixels go from 0-width-1)
				{
					xPos=0;
					yPos+=drawRows; //adjust by num rows
				}
				for(int i=0; i<drawRows; i++)
				{
					updateImage(xPos, yPos+i);
				}
				xPos++;
			}

			if(drawMode == 1) //vertical
			{
				if(yPos > image.getHeight() - 1) //prevent OOB of image (pixels go from 0-height-1)
				{
					yPos=0;
					xPos+=drawRows; //adjust by num rows
				}
				for(int i=0; i<drawRows; i++)
				{
					updateImage(xPos+i, yPos);
				}
				yPos++;
			}

			else
			{
				//do horizontal
				if(xPos > image.getWidth() - 1) //prevent OOB of image (pixels go from 0-width-1)
				{
					xPos=0;
					yPos+=drawRows; //adjust by num rows
				}
				for(int i=0; i<drawRows; i++)
				{
					updateImage(xPos, yPos+i);
				}
				xPos++;


				//do vertical
				if(yPos2 > image.getHeight() - 1) //prevent OOB of image (pixels go from 0-height-1)
				{
					yPos2=0;
					xPos2+=drawRows; //adjust by num rows
				}
				for(int i=0; i<drawRows; i++)
				{
					updateImage(xPos2+i, yPos2);
				}
				yPos2++;
			}
			repaint();
			if(xPos > image.getWidth() || yPos > image.getHeight() || xPos2 > image.getWidth() || yPos2 > image.getHeight())
				timer.stop();
		}

	}

	private void updateImage(int x, int y)
	{
		if(x < image.getWidth() && y < image.getHeight())
		{
			int color = image.getRGB(x,y);
			drawnImage.setRGB(x,y,color);
		}
	}



}
