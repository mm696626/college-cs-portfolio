/**
 * @author Matthew McCullough
 * @date 4/23/2019
 * This uses the Movie class to create a small Netflix-like environment
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Netflix extends JFrame implements ActionListener 
{
	static ArrayList <Movie> shows = new ArrayList<Movie>();
	private JLabel titleLabel, directorLabel, yearLabel;
    private JTextField titletext, directorText, yearText, infoBox;
    private JButton addButton, removeButton, sortButton, clearButton;
    GridBagConstraints layoutConst=null;
    public Netflix()
    {
    	setTitle("Netflix");
    	
        titleLabel = new JLabel ("Title");
        directorLabel = new JLabel("Director");
        yearLabel = new JLabel("Year");
        
   
        titletext = new JTextField(10);
        titletext.setEditable(true);
        titletext.setText("");
          
        directorText = new JTextField(10);
        directorText.setEditable(true);
        directorText.setText("");
        
        yearText = new JTextField(10);
        yearText.setEditable(true);
        yearText.setText("");
        
        infoBox = new JTextField(30);
        infoBox.setEditable(false);
        infoBox.setText("");
        
       
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        
        removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        
        sortButton = new JButton("Sort");
        sortButton.addActionListener(this);
        
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        
        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
  
        layoutConst.gridx=0;
        layoutConst.gridy=0;
        add(titleLabel, layoutConst);
       
        layoutConst.gridx=1;
        layoutConst.gridy=0;
        add(titletext, layoutConst);
        
        layoutConst.gridx=0;
        layoutConst.gridy=1;
        add(directorLabel, layoutConst);
        
        layoutConst.gridx=1;
        layoutConst.gridy=1;
        add(directorText, layoutConst);
       
       layoutConst.gridx=0;
       layoutConst.gridy=2;
       add(yearLabel, layoutConst);
       
       layoutConst.gridx=1;
       layoutConst.gridy=2;
       add(yearText, layoutConst);
       
       layoutConst.gridx=0;
       layoutConst.gridy=3;
       add(addButton, layoutConst);
       
       layoutConst.gridx=1;
       layoutConst.gridy=3;
       add(removeButton, layoutConst);
       
       layoutConst.gridx=0;
       layoutConst.gridy=4;
       add(sortButton, layoutConst);
       
       layoutConst.gridx=1;
       layoutConst.gridy=4;
       add(clearButton, layoutConst);
       
       layoutConst.gridx=0;
       layoutConst.gridy=5;
       add(infoBox, layoutConst);
       
       
       
    }
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addButton)
		{
			String title = titletext.getText().trim();
			String directorLastName = directorText.getText().trim();
			String yearString = yearText.getText().trim();
			int year;
			try
			{
				year = Integer.parseInt(yearString);
			}
			catch(NumberFormatException n) 
			{
				year=0;
			}
			if(!title.equals("") && !directorLastName.equals(""))
			{
				Movie m1 = new Movie(title, directorLastName, year);
				addMovie(m1);
				infoBox.setText("Movie added. The number of movies is now " + Movie.movieCount);
			}
			
	    }
	    else if(e.getSource()==removeButton)
	    {
	    	String title = titletext.getText().trim();
			String directorLastName = directorText.getText().trim();
			String yearString = yearText.getText().trim();
			int year;
			try
			{
				year = Integer.parseInt(yearString);
			}
			catch(NumberFormatException n) 
			{
				year=0;
			}
				
			if(!title.equals("") && !directorLastName.equals(""))
			{
		    	removeMovie(new Movie(title, directorLastName, year));
		    	Movie.movieCount--;  /** Decrement counter of movies as to not include the test object used */
		    	infoBox.setText("Movie removed. The number of movies is now " + Movie.movieCount);
			}
	    }
	    else if(e.getSource()==sortButton)
	    {
	    	sortMovie();
	    	for(int i=0; i<shows.size(); i++)
	    	{
	    		System.out.println(shows.get(i));
	    		System.out.println();
	    	}
	    }
	    else if(e.getSource()== clearButton)
	    {
	    	 titletext.setText("");
	    	 directorText.setText("");
	    	 yearText.setText("");
	    	 infoBox.setText("");
	    }

		
	}

	public static void main(String[] args)
	{
		Netflix myFrame = new Netflix();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    myFrame.pack();
	    myFrame.setVisible(true);
	    shows.add(new Movie("Wizard of Oz", "Vidor", 1939));
	    shows.add(new Movie( "The Third Man","Reed",1949));
	    shows.add(new Movie("The Godfather","Coppola",1972));
	    shows.add(new Movie("Brooklyn","Crowley", 2015));
	    shows.add(new Movie("The Martian","Scott", 2015));
	    shows.add(new Movie("Snow White and Seven Dwarfs","Hand",1937));
	    shows.add(new Movie("Toy Story 2","Brannon",1999));
	    shows.add(new Movie("Roman Holiday","Wyler",1953));
	    shows.add(new Movie("Zootopia","Howard",2016));

	}
	/**
	 * Adds movie to shows
	 * @param m Movie object to add to shows (an ArrayList of movies the class uses)
	 */
	public static void addMovie(Movie m){
		shows.add(m);
	}
	/**
	 * Removes the first instance of a movie in shows (if there are multiple it will just remove the first one)
	 * @param m Movie object for testing if in shows
	 */
	public static void removeMovie(Movie m){
		String test = "";
		for(int i=0; i<shows.size(); i++)
		{
			test = shows.get(i).getTitle();
			if(m.getTitle().equals(test))
			{
				shows.remove(i);
				Movie.movieCount--; /** decrament counter of movies as we removed one */
				break;
			}
				
		}
	}
	/**
	 * sorts movies with the compareTo method in the Movie class
	 */
	 public static void sortMovie(){
		 Collections.sort(shows);
	 }
}
