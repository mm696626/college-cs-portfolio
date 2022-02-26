/**
 * @author Matthew McCullough
 * @date 4/23/2019
 * This creates a Movie class which represents a movie 
 */
 public class Movie implements Comparable<Movie>{
	 public static int movieCount=0; /** number of movie objects created */
	 private String title; /** title of the movie */
	 private String directorLastName; /** last name of the director */
	 private int year; /** year movie was released */
	 /**
	  * Default constructor
	  */
	 public Movie(){
		 title="";
         directorLastName="";
         year=0;
         movieCount++;
	 }
	 /**
	  * Full parameter constructor
	  * @param t title
	  * @param d director last name
	  * @param y year released
	  */
	 public Movie(String t, String d, int y){
		 title=t;
         directorLastName=d;
         year=y;
         movieCount++;
	 }
	 /**
	  * Copy constructor
	  * @param m Movie object to make a copy of
	  */
	 public Movie(Movie m){
		 title=m.title;
         directorLastName=m.directorLastName;
         year=m.year;
         movieCount++;
	 }
	 /**
	  * gets the title of movie
	  * @return returns title of the movie
	  */
	 public String getTitle()
	 {
		 return title;
	 }
	 /**
	  * gets the director's last name of movie
	  * @return returns director's last name of the movie
	  */
	 public String getDirectorLastName()
	 {
		 return directorLastName;
	 }
	 /**
	  * gets the year of movie
	  * @return returns the year released of the movie
	  */
	 public int getYear()
	 {
		 return year;
	 }
	 /**
	  * sets the title of the movie to the parameter
	  * @param t what to set the title to
	  */
	 public void setTitle(String t)
	 {
		 title = t;
	 }
	 /**
	  * sets the director's last name of the movie to the parameter
	  * @param d what to set the director's last name to
	  */
	 public void setDirectorLastName(String d)
	 {
		 directorLastName = d;
	 }
	 /**
	  * sets the year of the movie to the parameter
	  * @param y what to set the year to
	  */
	 public void setYear(int y)
	 {
		 year = y;
	 }
	 /**
	  * Returns a general description of the movie
	  */
	 public String toString()
	 {
		 return("Movie: " + title + "\n" + "Director: " + directorLastName + "\n" + "Year: " + year);
	 }
	/**
	 * compares two movie objects by title to sort the objects
	 */
	public int compareTo(Movie other) {
		return this.title.compareTo(other.title);
	}
	/**
	 * Compares two Movie objects to test if they are the same (by title and year)
	 * @param other movie object to be compared
	 * @return if equal or not
	 */
	public boolean equals(Movie other)
	{
		return title.equals(other.title) && year == other.year;
	}


}
