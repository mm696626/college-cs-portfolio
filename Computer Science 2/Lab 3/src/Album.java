/**
 * This class is a class that defines an album (by name and the songs in the album)
 * @author Matthew McCullough
 * @date 1/31/2019
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Album 
{
	Scanner reader= new Scanner(System.in);
	private String name; /**name of the album*/
	private ArrayList<Song> album = new ArrayList<Song>(); /**all the songs in the album*/
	/**default constructor*/
	public Album()
	{
		System.out.println("What is the name of the album?");
		name = reader.nextLine();
		System.out.println("How many songs do you want in the album?");
		int size = reader.nextInt();
		for(int i=0; i<size; i++)
		{
			album.add(new Song());
		}
	}
	/**
	 * Prints out general information about the Album
	 * @return returns the information about the singer
	 */
	public String toString()
	{
		String output = "Album Name: " + name + "\n";
		for(int i=0; i<album.size(); i++)
		{
			output+= album.get(i).toString();
		}
		return output;
		
	}
}
