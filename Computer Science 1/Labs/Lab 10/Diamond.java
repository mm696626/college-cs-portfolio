public class Diamond
{
   public static void main(String[] args)
   {
      int diamondsize = 11; //in this lab, it is 11
      int spaceCount = diamondsize/2;
      int starCount = 1;
      String output="";
      for (int x = 0; x <= diamondsize/2; x++) 
      {
        for (int y = 0; y < spaceCount; y++) 
        {
            output+=(" ");
        }
        for (int z = 0; z < starCount; z++) 
        {
            output+=("*");
        }
        System.out.println(output);
        output="";
        starCount += 2;
        spaceCount--;
      }
      
      spaceCount+=2;
      starCount-=4;
      
      for (int x = diamondsize/2; x > 0; x--) 
      {
        for (int y = 0; y < spaceCount; y++) 
        {
            output+=(" ");
        }
        for (int z = 0; z < starCount; z++) 
        {
            output+=("*");
        }
        System.out.println(output);
        output="";
        starCount -= 2;
        spaceCount++;
      }
      
   
   }

}