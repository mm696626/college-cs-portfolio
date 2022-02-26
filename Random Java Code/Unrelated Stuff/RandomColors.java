import javax.swing.JApplet;
import java.awt.*;
import java.util.Random;
public class RandomColors extends JApplet {

   public void paint(Graphics page){
       
        Random rng = new Random();
       
       
        for(int i=0; i<10000; i++)
        {
        	
        	Color random=new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256));
            page.setColor(random);
            //setBackground(random);
            page.drawRect(i, i,i+1,i+1);
   
        }
        
    
        		
        }
        	
       }
        

        