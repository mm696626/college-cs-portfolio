/**
 * This class is a class that defines a song (by title, singer, and length)
 * @author Matthew McCullough
 * @date 1/31/2019
 */
import java.util.Scanner;
public class Song 
{
	Scanner reader = new Scanner(System.in);
	private String title; /**represents the title of the song*/
	private Singer singer; /**represents the singer of the song*/
	private double length; /**represents the length of the song*/
	/**default constructor*/
	public Song()
	{
		System.out.println("What is the song called");
		title = reader.nextLine();
		singer = new Singer();
		System.out.println("How long is the song (in minutes)");
		length = reader.nextDouble();
		
	}
	/**constructor with parameters
	 * @param t (represents a String to be the title)
	 * @param s (represents a Singer to be the singer of the song, uses the Singer class)
	 * @param l (represents a double to be the length of the song in minutes)
	 */
	public Song(String t, Singer s, double l)
	{
		title = t;
		singer = new Singer(s);
		length = l;
	}
	/**copy constructor
	 * @param s (represents the Song to be copied)
	 *
	 */
	public Song(Song s)
	{
		title = s.title;
		singer = new Singer(s.singer);
		length = s.length;
	}
	/**
	 * gets the title of the song
	 * @return returns the title of the song
	 */
	public String getTitle()
	{
		return title;
	}
	/**
	 * gets the singer of the song
	 * @return returns the singer of the song
	 */
	public Singer getSinger()
	{
		return new Singer(singer);
	}
	/**
	 * gets the length of the song
	 * @return returns the length of the song
	 */
	public double getLength()
	{
		return length;
	}
	/**
	 * sets the title of the song
	 * @param String t is what the title will be set to
	 */
	public void setTitle(String t)
	{
		title = t;
	}
	/**
	 * sets the singer of the song
	 * @param Singer s is what the singer will be set to
	 */
	public void setSinger(Singer s)
	{
		singer = new Singer(s);
	}
	/**
	 * sets the length of the song
	 * @param double l is what the length will be set to
	 */
	public void setLength(double l)
	{
		length = l;
	}
	/**
	 * Prints out general information about the song
	 * @return returns the information about the song
	 */
	public String toString()
	{
		return("Title is " + title + "\n" + singer.toString() + "\n" + "Length is: " + length + "\n");
	}
	/**
	 * Checks if two songs are the same
	 * @param Song other is the other song to be checked
	 * @return returns true if equal, false if not
	 */
	public boolean equals(Song other)
	{
		if(title.equals(other.title) && singer.equals(other.singer) && length == other.length)
			return true;
		else
			return false;
	}
	
}
