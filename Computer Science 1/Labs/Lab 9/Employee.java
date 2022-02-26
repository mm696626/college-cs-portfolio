public class Employee
{
    private final int    DEFAULT_ID = 99999;
    private final double MIN_SALARY = 10000;
    private final double MAX_SALARY = 10000000;

    private int id;
    private String name;
    private double salary;
    private Date hireDay;
    
    // constructor
    public Employee( int id, String name, double salary, int month, int day, int year )
    {
       this.id = id;
       this.name = name;
       this.salary = salary;
       hireDay = new Date(month, day, year);
       checkId(this.id);
       checkSalary(this.salary);
       
    }
    // copy constructor
    public Employee( Employee e )
    {
       if(e == null)
       {
         System.out.println("Fatal Error");
         System.exit(0);
       }
       else
       {
         id = e.id;
         name = e.name;
         salary = e.salary;
         hireDay = new Date(e.hireDay);
       }
       
       
    } 
    
    
    public int getId()
    {
       return id;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    public void setName( String name )
    {
       this.name = name;
    } 
    
    
    public double getSalary()
    {
       checkSalary(salary);
       return salary;
    }
    
   
    public Date getHireDay()
    {
       return new Date(hireDay);
       
    }
    
    
    public void raiseSalary( double byPercent )
    {
       salary+= (salary*(byPercent/100));
       if(salary>=MAX_SALARY)
         salary = MAX_SALARY;
    }
    
    public String toString( )
    {    
       return(id + ":" + name + ", $" + salary + "," + hireDay);
      
    }
    
    
    private void checkId( int id )
    {
       if(id<=0)
       {
          System.out.println(name + " " + "Invalid ID");
          this.id = DEFAULT_ID;
       }
        
    }

    private void checkSalary( double salary )
    {
        if ( salary > MIN_SALARY && salary < MAX_SALARY )
            this.salary = salary;
        else if ( salary < MIN_SALARY )
        {
            this.salary = MIN_SALARY;
            System.out.println( "WARNING: The salary assigned to employee " + name + 
                                " was below the minimum. The salary has been reset" );
        }
        else 
        {
            this.salary = MAX_SALARY;
            System.out.println( "WARNING: The salary assigned to employee " + name + 
                                " was above the maximum. The salary has been reset" );
        }
    } // end method checkSalary
    
} // end class Employee 