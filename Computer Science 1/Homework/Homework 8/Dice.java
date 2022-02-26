import java.util.Random;
public class Dice
{
   private int diceValue;
   
   public Dice()
   {
      diceValue=0;
   }
   public Dice(int dv)
   {
      diceValue = dv;
   }
   public Dice(Dice d)
   {
      diceValue = d.diceValue;
   }
   public int getDiceValue()
   {
      return diceValue;
   }
   public void setDiceValue(int dv)
   {
      diceValue = dv;
   }
   public String toString()
   {
      return("Dice Value is: " + diceValue);
   }
   public void roll()
   {
      Random rng = new Random();
      int roll = rng.nextInt(6)+1;
      this.setDiceValue(roll);
   }

}