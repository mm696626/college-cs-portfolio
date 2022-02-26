//HW3 by Matt McCullough

class Multithreading implements Runnable{
    private final int radius;

    public Multithreading(int radius) //pass radius into runnable
    {
        this.radius = radius;
    }

    public void run(){
        //area thread code
        double area = 3.14 * radius * radius;
        System.out.println("The area is: " + area);
    }
}


class Multithreading2 implements Runnable{

    private final int radius;
    public Multithreading2(int radius)
    {
        this.radius = radius;
    }
    public void run(){
        //diameter thread code
        int diameter = 2 * radius;
        System.out.println("The diameter is: " + diameter);
    }
}


class Multithreading3 implements Runnable{
    private final int radius;
    public Multithreading3(int radius)
    {
        this.radius = radius;
    }
    public void run(){
        //circumference thread code
        double circumference = 2 * 3.14 * radius;
        System.out.println("The circumference is: " + circumference);
    }
}


public class Threading {
    public static void main(String[] args)
    {


        //check for 1 argument
         if(args.length!=1)
        {
            System.out.println("wrong num arguments");
            System.exit(0);
        }

         //check if negative
        if(Integer.parseInt(args[0])<0)
        {
            System.out.println("r cannot be negative");
            System.exit(0);
        }



        //save argument as integer
        int r = Integer.parseInt(args[0]);


        //make thread from runnable and start
        Runnable area = new Multithreading(r);
        Thread thread1 = new Thread(area);
        thread1.start();

        //join thread with main
        try{
            thread1.join();
        }
        catch(Exception e)
        {
            System.exit(0);
        }


        //repeat for two other threads


        Runnable diameter = new Multithreading2(r);
        Thread thread2 = new Thread(diameter);
        thread2.start();
        try{
            thread2.join();
        }
        catch(Exception e)
        {
            System.exit(0);
        }

        Runnable circumference = new Multithreading3(r);
        Thread thread3 = new Thread(circumference);
        thread3.start();
        try{
            thread3.join();
        }
        catch(Exception e)
        {
            System.exit(0);
        }

        System.out.println("This is everything you need to know");
    }
}
