import java.util.Scanner;
import java.util.ArrayList;
public class Hangman
{
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
      String word = "";
      ArrayList<String> letters = new ArrayList<String>(); //all guesses
      ArrayList<String> cletters = new ArrayList<String>(); //correct guesses
      ArrayList<String> iletters = new ArrayList<String>(); //incorrect guesses
      int option=0;
      int triesleft = 8;
      String letter="";
      boolean guessed=false;
      System.out.println("Enter a word, the other player shouldn't look");
      word = reader.nextLine();
      word = word.toLowerCase();
      System.out.println("Hiding word");
      for(int x=0; x<10; x++) //adjust the 10 if console window is large
           System.out.println();
      cletters.add(" "); // adds space to correct guesses so they will show up in the word when it is shown to the player so it isn't a *
      while(triesleft>0 && guessed==false)
      {
         int counter = 0;
         letter="";
         System.out.print("The word : ");
         for(int x=0; x<word.length(); x++)
         {
            boolean printstar = true;
            for(String y : cletters)
            {
               if(y.equalsIgnoreCase(word.substring(x,x+1)))
               {
                  System.out.print(y);
                  counter++;
                  printstar=false;
               }
                
            }
            if(printstar==true)
               System.out.print("*");
            if(counter==word.length())
            {
               System.out.println();
               System.out.println("You guessed the word");
               guessed=true;
            }
         }
         if(guessed==true) //break out of loop early if word is guessed
            break;
         System.out.println();
         System.out.println("Would you like to guess a letter - type 1");
         System.out.println("View Guesses - type 2");
         System.out.println("Guess the word - type 3");
         option = reader.nextInt();
         if(option==1)
         {
            while(letter.length()!=1)
            {
               System.out.println("Guess a letter");
               letter = reader.next();
            }
            letter = letter.toLowerCase();
            letters.add(letter);
            if(word.contains(letter)) 
            {
               boolean add = true;
               for(int x=0; x<cletters.size(); x++)
               {
                  if(cletters.get(x).equals(letter))
                  {
                     add = false;
                     System.out.println("You already guessed that!");
                  }
                     
               }
               if(add==true)
               {
                  cletters.add(letter);
                  System.out.println("Your letter is in the word");
               }
                  
            }
            else
            {
               triesleft--;
               boolean add = true;
               for(int x=0; x<iletters.size(); x++)
               {
                  if(iletters.get(x).equals(letter))
                  {
                     add = false;
                     System.out.println("You already guessed that!");
                  }
                      
                     
               
               }
               if(add==true)
                  iletters.add(letter);
               if(triesleft>0)
                  System.out.println("Try again, you have " + triesleft + " tries left");
               else
                  System.out.println("Too bad. The word was " + word);
            }
         }
         else if(option==2)
         {
               if(letters.size()>0)
            {
               System.out.println("Your correct guesses:");
               for(String x: cletters)
                  System.out.print(" " + x + " " );
               System.out.println();
               System.out.println("Your incorrect guesses:");
               System.out.println(" ");
               for(String x: iletters)
                  System.out.print(" " + x + " " );
            }

         
         }
         else if(option==3)
         {
        	  String dummy = reader.nextLine();
              System.out.println("Guess the word!");
              String guess = reader.nextLine();
              if(guess.equalsIgnoreCase(word))
              {
            	  System.out.println("You guessed the word");
            	  guessed=true;
              }
              else
              {
            	  triesleft--;
            	  if(triesleft>0)
            	  System.out.println("Try again, you have " + triesleft + " tries left");
          
            	  
              }

         
         }
      }
   }

}