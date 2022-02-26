public class EmployeeTest
{
    public static void main (String[] args)
    {
        // Test the first constructor
        Employee joe = new Employee( 99, "Joe Smith", 100000, 2, 2, 2002 );
        Employee jane = new Employee( 0, "Jane Doe", 200000, 3, 3, 2003 );
        
        // Test if the salary given is too high
        Employee ellen = new Employee( 101, "Ellen Brown", 1000000000, 4, 4, 2004 );
        
        // Test if the salary given is too low
        Employee gary = new Employee( 102, "Gary White", 5000, 5, 5, 2005 );
        
        // Test the copy constructor
        Employee mary = new Employee( jane );
        
        // The lines below make sure the constructors worked
        // properly and test the toString() method
        System.out.println( "\nHere are the employees so far: " );
        System.out.println( "Joe Smith --> " + joe );
        System.out.println( "Jane Doe --> " + jane );
        System.out.println( "Ellen Brown --> " + ellen );
        System.out.println( "Gary White --> " + gary );
        System.out.println( "Mary (same as Jane) --> " + mary );
        
        // Now testing the accessor methods
        System.out.print( "\nNow testing the getId method: " );
        System.out.println( "Gary's id is: " + gary.getId() );
        System.out.print( "\nNow testing the getName method: " );
        System.out.println( "Joe's name is: " + joe.getName() );
        System.out.println("\nNow testing the getSalary method: ");
        System.out.println( "Jane's salary is: " + joe.getSalary() );
        System.out.println("Joes name is: " + joe.getName());

        
        // Continue and check each method of the class in this manner
        System.out.println("\nNow testing the setName method: ");
        joe.setName("Matt");
        System.out.println("Joes name is: " + joe.getName());
        jane.raiseSalary(1); //raise salary by 1 percent
        System.out.println("\nNow testing the raiseSalary method");
        System.out.println("Jane's salary is now " + jane.getSalary());
        System.out.println("\nNow testing the getHireDay method");
        System.out.println("Gary was hired " + gary.getHireDay());
        
               
        
    } // main method
} // EmployeeTest class