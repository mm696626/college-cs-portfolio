public class Driver {

	public static void main(String[] args) 
	{
		Singer s1 = new Singer();
		Singer s2 = new Singer("Michael", "Jackson");
		Singer s3 = new Singer(s1);
		s1.setFirstName("Matt");
		s2.setLastName("Bay");
		System.out.println("s1's first name is: " + s1.getFirstName());
		System.out.println("s2's last name is: " + s2.getLastName());
		
		if(s1.equals(s3))
			System.out.println("s1 is equal to s3");
		else
			System.out.println("s1 is not equal to s3");
		
		System.out.println(s1.toString());
		
		System.out.println("There are " + Singer.countSinger + " singers created");
		
		Song song1 = new Song();
		Song song2 = new Song("Thriller", s2, 3.5);
		Song song3 = new Song(song1);
		
		song2.setTitle("Billie Jean");
		song1.setLength(3.7);
		song3.setSinger(s3);
		System.out.println("The name of song2 is: " + song2.getTitle());
		System.out.println("The length of song1 is: " + song1.getLength());
		System.out.println("The singer of song3 is: " + song3.getSinger());
		System.out.println(song2.toString());
		
		if(song1.equals(song2))
			System.out.println("Song1 and song2 are equal");
		else
			System.out.println("Song1 and song2 are not equal");
		
		Album a = new Album();
		System.out.println(a.toString());
		/*  Sample output:
		 *  What is the singers first name
			Matt
			What is the singers last name
			McCullough
			s1's first name is: Matt
			s2's last name is: Bay
			s1 is equal to s3
			Singer name is: Matt McCullough
			There are 3 singers created
			What is the song called
			Girls Like You
			What is the singers first name
			Maroon
			What is the singers last name
			5
			How long is the song (in minutes)
			3.4
			The name of song2 is: Billie Jean
			The length of song1 is: 3.7
			The singer of song3 is: Singer name is: Matt McCullough
			Title is Billie Jean
			Singer name is: Michael Bay
			Length is: 3.5
			
			Song1 and song2 are not equal
			What is the name of the album?
			Great Songs
			How many songs do you want in the album?
			3
			What is the song called
			Warrior
			What is the singers first name
			Demi
			What is the singers last name
			Lovato
			How long is the song (in minutes)
			3.2
			What is the song called
			Livin on a Prayer
			What is the singers first name
			Bon
			What is the singers last name
			Jovi
			How long is the song (in minutes)
			4
			What is the song called
			This Love
			What is the singers first name
			Maroon
			What is the singers last name
			5
			How long is the song (in minutes)
			4.1
			Album Name: Great Songs
			Title is Warrior
			Singer name is: Demi Lovato
			Length is: 3.2
			Title is Livin on a Prayer
			Singer name is: Bon Jovi
			Length is: 4.0
			Title is This Love
			Singer name is: Maroon 5
			Length is: 4.1
			
			
		 */
		
		
	}

}
