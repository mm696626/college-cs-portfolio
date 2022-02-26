/**
 * 
 * @author Matthew McCullough
 * This program is a test class for the Student class
 */
public class StudentDemo
{
   public static void main(String[] args)
   {
      Student s1 = new Student();
      Student s2 = new Student("Tim", false, 19, 3.4);
      Student s3 = new Student(s2);
      s1.setName("Matt");
      System.out.println("The name of student s2 is " + s2.getName());
      System.out.println(s2.toString());
      s3.setAge(20);
      s3.setGPA(3.2);
      s2.setisGraduated(true);
      System.out.println("The Age of s1 is : " + s1.getAge());
      System.out.println("The GPA of s3 is : " + s3.getGPA());
      System.out.println("s3 Graduated : " + s3.getisGraduated());
      if(s1.equals(s3))
         System.out.println("Students are equal");
      else
         System.out.println("Students are not equal");
         
   }
}