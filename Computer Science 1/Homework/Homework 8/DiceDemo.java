public class DiceDemo
{
   public static void main(String[] args)
   {
      Dice d1 = new Dice(); //default
      Dice d2 = new Dice(6); //parametered
      Dice d3 = new Dice(d2); //copy
      d2.setDiceValue(2);
      System.out.println("Value of d2 set to " + d2.getDiceValue());
      
   
   }

}