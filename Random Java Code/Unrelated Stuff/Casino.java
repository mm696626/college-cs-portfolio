import java.util.*;
public class Casino
{
   public static void main(String args[])
   {
      Scanner reader = new Scanner(System.in);
      Random rng = new Random();
      boolean cheatsMode = false; //variable to allow the entering of cheats
      int coins=0;
      System.out.println("Do you want a random amount of coins or a predetermined amount of 10 coins 0 - random, 1 - 10 coins, anything else - cheat mode");
      int choice = reader.nextInt();
      if(choice==0)
      {
         coins = rng.nextInt(15)+1;
         System.out.println("You got " + coins + " coins");
      }
      else if(choice==1)
      {
         coins=10;
         System.out.println("You got 10 coins");
      }
      else
      {
         cheatsMode=true;
         System.out.println("Entering of cheats is enabled");
         System.out.println("Enter a cheat. Enter done to finish");
      }
         
      int bet = 0; 
      int slotTotal=0; //for "the luck factor"
      int coinWinnings=0; //determines grade
      int grade = 1; //1 is F, 2 is C, 3 is B, 4 is A, 5 is S (S tells the player about what the cheats are)
      boolean alwaysJackpot = false;
      boolean doubleMoney = false;
      boolean cheatsEntered=false;
      boolean leave = false;
      String cheatEntry = "";
      
      while(cheatsEntered==false && cheatsMode==true)
      {
         cheatEntry = reader.nextLine();          
         if(cheatEntry.equalsIgnoreCase("cashmoney"))
         {
            coins=1000000;
            System.out.println("You will now start with 1000000 coins");
         }
         if(cheatEntry.equalsIgnoreCase("doublemoney"))
         {
            doubleMoney = true;
            System.out.println("You will get double the earnings");
         }
         if(cheatEntry.equalsIgnoreCase("jackpot"))
         {
            alwaysJackpot = true;
            System.out.println("You will always get the jackpot");
         }
         if(cheatEntry.equalsIgnoreCase("done"))
         {
            cheatsEntered=true;       
         }

       }
      if(coins==0) //failsafe for using cheat mode
      {
         coins=1;
         System.out.println("I will give you 1 coin because I forgot to give you money");
      }
      while(coins>0)
      {
         bet=0;
         slotTotal=0;
         while(bet<=0 || bet>coins)
         {
            System.out.println("How many coins do you want to bet? To bet everything, enter -1, or Enter something out of range to leave");
            if(coins!=1)
               System.out.println("You currently have " + coins + " coins");
            else
               System.out.println("You currently have " + coins + " coin");
            bet = reader.nextInt();
           
            if(bet<=0 || bet>coins)
            {
            	if(bet==-1)
            	{
            		bet = coins;
            	}
            	else
            	{
            		System.out.println("You wanna leave the casino?. Enter true (yes) or false (no)");
                    leave = reader.nextBoolean();
                    if(leave==true)
                    {
                       coins = 0;
                       break;
                    }
            	}
               
            }
         }
         for(int x=0; x<5; x++)
         {
            int random = rng.nextInt(10)+1;
            slotTotal+=random;
         }
         if(alwaysJackpot==true)
         {
            slotTotal=50;
         }
         if(slotTotal==50 && leave!=true)
         {
            System.out.println("You got the jackpot");
            if(doubleMoney== true)
            {
            	coins+=(bet*20);
            	System.out.println("You earned " + (bet*20) + " coins");
                coinWinnings+=(bet*20);
            }
            else
            {
            	coins+=(bet*10);
            	System.out.println("You earned " + (bet*10) + " coins");
                coinWinnings+=(bet*10);
            }
            
            
         }
         else if(slotTotal>=40 && leave!=true)
         {
            System.out.println("You got second prize");
            if(doubleMoney== true)
            {
            	coins+=(bet*10);
            	System.out.println("You earned " + (bet*10) + " coins");
                coinWinnings+=(bet*10);
            }
            else
            {
            	coins+=(bet*5);
            	System.out.println("You earned " + (bet*5) + " coins");
                coinWinnings+=(bet*5);
            }
         
         }
         else if(slotTotal>=20 && leave!=true)
         {
        	 System.out.println("You got third prize");
        	 if(doubleMoney== true)
             {
             	coins+=(bet*4);
             	System.out.println("You earned " + (bet*4) + " coins");
                 coinWinnings+=(bet*4);
             }
             else
             {
             	coins+=(bet*2);
             	System.out.println("You earned " + (bet*2) + " coins");
                 coinWinnings+=(bet*2);
             }
        
            
     
         }
         else if(slotTotal<20 && leave!=true)
         {
            System.out.println("You won nothing and lost the coins you bet");
            coins-=bet;
         }


         if(coinWinnings>=1000000 && grade!=5) //prevents overflows making you lose S rank and giving you an F
            grade=5;
                  
      
      
      }
         if(coinWinnings>=1000000 || grade==5)
         {
            grade=5;
            System.out.println("Grade:S");
         }
         else if(coinWinnings>=500000)
         {
            grade=4;
            System.out.println("Grade:A");
         }
         else if(coinWinnings>=100000)
         {
            grade=3;
            System.out.println("Grade:B");
         }
         else if(coinWinnings>=50000)
         {
            grade=2;
            System.out.println("Grade:C");
         }
         else         
         {
            grade=1;
            System.out.println("Grade:F");
         }
         if(grade>=5)
         {
            System.out.println("Pssst, try these cheats: cashmoney, doublemoney, jackpot.");
         }
         if(leave!=true)
            System.out.println("You won " + coinWinnings + " coins before losing all your money");
         else
            System.out.println("You won " + coinWinnings + " coins before leaving the casino");
   }  
}
