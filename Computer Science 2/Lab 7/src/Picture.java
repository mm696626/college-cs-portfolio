/**
 * @author Matthew McCullough
 * @date 3/21/2019
 * This program draws a simple picture using JApplet
 */
import javax.swing.JApplet;
import javax.swing.Box.Filler;
import java.awt.*;
import java.util.Random;
public class Picture extends JApplet {
	/**
	 * paints the picture
	 */
   public void paint(Graphics page){
	    Random rng = new Random();
	    Color pink = new Color(255,102,255);
        Color aqua = new Color(0,204,255);
        Color sunset=new Color(230,100,100);
        setBackground(pink);
        page.setColor(aqua);
        page.fillRect(0,175,300,50);
        page.setColor(sunset);
        page.fillRect(0,0,300,175);
        Color fire = new Color(204,0,0);
        page.setColor(new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256)));
        page.fillOval(-40,-40,80,80);
        page.setColor(fire);
        page.fillRect(80,80,20,40);
        page.setColor(aqua);
        page.setColor(Color.YELLOW);
        page.fillOval(83, 85, 5, 5);
        page.fillOval(93, 85, 5, 5);
        page.drawArc(85, 100, 8, 8, 180, 200);
        
        final int bottom=150;
        final int right=150;
        page.setColor(pink);
        page.fillOval(right, bottom, 20, 10);
        page.drawLine(right+10, bottom, right+30, bottom-5);
        page.drawLine(right+10, bottom+10, right+30, bottom+15);
        page.drawLine(right+30, bottom-5, right+30, bottom+15);
        page.setColor(fire);
        page.fillOval(152, 152, 2, 2);
        
        for(int i=0; i<20; i++)
        {
        	 Color random=new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256));
             page.setColor(random);
             page.drawOval(10+i, 50+i,10+i,20+i);
             page.drawOval(10+i, 70+i,10+i,70+i);
        }
        page.setColor(Color.BLACK);
        Font f = new Font("SERIF", Font.BOLD, 15);
        page.setFont(f);
        page.drawString("Hello There and gaze at my \"masterpiece\" :)", 5, 200);
        int[] xcoords = {100,110,120,115,112};
        int[] ycoords = {30,40,50,60,70};
        page.fillPolygon(xcoords, ycoords, 5);
        page.setColor(new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256)));
        page.fillRect(230, 125, 50, 50);
        int[] xcoords2 = {230,255,280};
        int[] ycoords2 = {125,100,125};
        page.setColor(new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256)));
        page.fillPolygon(xcoords2, ycoords2, 3);
        
     
        }
        
        }

        