public class Employee
{
   private String name;
   private int empNum;
   public Employee()
   {
      name = "Matt";
      empNum = 5;
   }
   public Employee(String n, int en)
   {
      name = n;
      empNum = en;
   
   }
   public Employee(Employee other)
   {
      name = other.name;
      empNum = other.empNum;
   
   }
   public String getName()
   {
      return name;
   }   
   public int getempNum()
   {
      return empNum;
   }
   public void setName(String n)
   {
      name = n;
   }
   public void setempNum(int en)
   {
      empNum = en;
   }
   public boolean equals(Employee other)
   {
      if(name.equals(other.name) && empNum == other.empNum)
         return true;
      else
         return false;
   }
   public String toString()
   {
      return("Employee Name: " + name + " Employee Number : " + empNum);
   }


}