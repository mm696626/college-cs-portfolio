/**
 * 
 * @author Matthew McCullough
 * This class defines a new object, a Student in which their 
 * age, name, gpa, and graduation status are being accounted for
 */
public class Student
{
   private String name;
   private boolean isGraduated; 
   private int age;
   private double gpa;
   /**
    * This is a full constructor
    * @param n is for the name of the student
    * @param gr is if the student has graduated
    * @param a is the age of the student
    * @param g is the students gpa
    */

   public Student(String n, boolean gr, int a, double g)
   {
      name = n;
      isGraduated = gr;
      age = a;
      gpa = g;  
   }
   /**This is a default constructor*/
   public Student()
   {
      name = "Bob";
      isGraduated = false;
      age = 18;
      gpa = 0.0;
   }
   /**This is a copy constructor that creates a copy of the object passed by the parameter other*/
   public Student(Student other)
   {
      name = other.name;
      isGraduated = other.isGraduated;
      age = other.age;
      gpa = other.gpa;
   }
   /**
    * This method gets the name of the calling object
    * @return returns the name of the Student object.
    */

   public String getName()
   {
      return name;
   }
   /**
    * This method gets the Graduation Status of the calling object
    * @return returns the graduation status of the Student object.
    */
   public boolean getisGraduated()
   {
      return isGraduated;
   }
   /**
    * This method gets the age of the calling object
    * @return returns the age of the Student object.
    */
   public int getAge()
   {
      return age;
   }
   /**
    * This method gets the GPA of the calling object
    * @return returns the GPA of the Student object.
    */
   public double getGPA()
   {
      return gpa;
   }
   /**
    * This method sets the name of the calling object
    * @param n is the parameter (String) in which the objects name is set to
    */
   public void setName(String n)
   {
      name = n;
   }
   /**
    * This method sets the graduation status of the calling object
    * @param gr is the parameter (boolean) in which the objects graduation status is set to
    */
   public void setisGraduated(boolean gr)
   {
      isGraduated = gr;
   }
   /**
    * This method sets the age of the calling object
    * @param a is the parameter (int) in which the objects age is set to
    */
   public void setAge(int a)
   {
      age = a;
   }
   /**
    * This method sets the GPA of the calling object
    * @param g is the parameter (double) in which the objects GPA is set to
    */
   public void setGPA(double g)
   {
      gpa = g;
   }
   /**
    * @return returns a String of the objects(the student) attributes 
    */
   public String toString()
   {
      return("Student's name: " + name + " Is the Student a Graduate : " + isGraduated + " Age : " + age + " years old " + " GPA : " + gpa);
   }
   /**
    * @param other is another Student object in which the calling object is compared to 
    * @return returns true if equal, false if not 
    */
   public boolean equals(Student other)
   {
      if((name.equals(other.name)) && (isGraduated==other.isGraduated) && (age==other.age) && (gpa==other.gpa))
         return true;
      else
         return false;
   }
}