public class EmployeeDemo
{
   public static void main(String[] args)
   {
      Employee joe = new Employee("Joe",1); //parameter
      Employee matt = new Employee(); //default 
      Employee joe2 = new Employee(joe); //copy
      System.out.println("Testing setName method");
      matt.setName("John");
      System.out.println("Name set to " + matt.getName());
      System.out.println("Getting Employee Joe's Name");
      System.out.println(joe.getName());
      System.out.println("Testing equals method");
      if(joe.equals(joe2))
         System.out.println("The 2 Employees are indentical");
      else
         System.out.println("They are not");
      System.out.println("Testing toString");
      System.out.println(matt);  
   }


}