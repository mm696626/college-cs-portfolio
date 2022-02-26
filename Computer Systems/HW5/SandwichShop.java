//HW5 by Matt McCullough
import java.util.concurrent.Semaphore;
public class SandwichShop {

    static Semaphore customerLock = new Semaphore(1);
    static Semaphore s1 = new Semaphore(0);
    static Semaphore s2 = new Semaphore(0);

    public static void main(String[] args) {
        if (args.length != 1) {
            printUsage();
        }

        int num = 0;
        try {
            num = Integer.parseInt(args[0]); //get number of customers
        }
        catch (NumberFormatException e) {
            printUsage();
        }

        System.out.println("Customer:\t\t\t\t\t\t\t\t\t\t\t| Employee:");
        System.out.print("Traveling\tArrived\t\tOrdering\tBrowsing\tAt Register\tLeaving");
        System.out.println("\t\t| Waiting\tSandwich Making\t\tAt Register\tPayment Accepted");
        System.out .println("---------------------------------------------------"
                + "---------------------------------------------+--------"
                + "-------------------------------------------------------------------");

        Thread emp = new EmployeeThread();
        emp.start(); //start and create employee thread

        Thread[] custs = new Thread[num]; //create number of customer threads as command line parameter and start them
        for (int i = 0; i < num; i++) {
            custs[i] = new CustomerThread(i);
            custs[i].start();
        }
        for (int i = 0; i < num; i++) {
            try {
                custs[i].join(); //join when done customer thread which uses the semaphores to not conflict with each other
            }
            catch (InterruptedException e) {
            }
        }

        System.exit(0);
    }

    private static void printUsage() {
        System.out.println("Usage: java SandwichShop <num>");
        System.out.println(" <num>: Number of customers.");
        System.exit(-1);
    }

    public static void randomSleep(int max) {
        try {
            Thread.sleep((int) (Math.random() * max));
        }
        catch (InterruptedException e) {
        }
    }
}

class CustomerThread extends Thread {

    private int id;

    public CustomerThread(int id) {
        this.id = id;
    }

    public void run() { //this code also does similar things to the employee run, but it tracks the state of the employee and other customers as again one at a time

        travelToShop();
        arriveAtShop();
        try
        {
            SandwichShop.customerLock.acquire();   // enter shop one by one
        }
        catch(Exception e)
        {
            System.exit(0);
        }

        try{
            SandwichShop.s1.acquire();
        }
        catch(Exception e)
        {
            System.exit(0);
        }
        placeOrder();
        SandwichShop.s2.release();
        browseShop();
        atRegister();
        try
        {
            SandwichShop.s1.acquire();
        }
        catch(Exception e)
        {
            System.exit(0);
        }

        SandwichShop.s2.release();
        try
        {
            SandwichShop.s1.acquire();
        }
        catch(Exception e)
        {
            System.exit(0);
        }
        leaveShop();
        SandwichShop.customerLock.release();
    }

    private void travelToShop() {
        System.out.println("Customer " + id + "\t\t\t\t\t\t\t\t\t\t\t|");
        SandwichShop.randomSleep(1000);
    }

    private void arriveAtShop() {
        System.out.println("\t\tCustomer " + id + "\t\t\t\t\t\t\t\t\t|");
    }

    private void placeOrder() {
        System.out.println("\t\t\t\tCustomer " + id + "\t\t\t\t\t\t\t|");
    }

    private void browseShop() {
        System.out.println("\t\t\t\t\t\tCustomer " + id + "\t\t\t\t\t|");
        SandwichShop.randomSleep(1000);
    }

    private void atRegister() {
        System.out.println("\t\t\t\t\t\t\t\tCustomer " + id + "\t\t\t|");
    }

    private void leaveShop() {
        System.out.println("\t\t\t\t\t\t\t\t\t\tCustomer " + id + "\t|");
    }
}

class EmployeeThread extends Thread {

    public void run() {

        while (true) { //basically this code is using the semaphores to keep track of what customers are in the shop and if there is one to deal with as it is one at a time
            waitForCustomer();
            SandwichShop.s1.release();
            try
            {
                SandwichShop.s2.acquire();
            }
            catch(Exception e)
            {
                System.exit(0);
            }

            makeSandwich();
            atCashRegister();
            SandwichShop.s1.release();
            try {
                SandwichShop.s2.acquire();
            }
            catch(Exception e)
            {
                System.exit(0);
            }
            paymentAccepted();
            SandwichShop.s1.release();
        }
    }

    private void waitForCustomer() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t| Employee");
    }

    private void makeSandwich() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t| \t\tEmployee");
        SandwichShop.randomSleep(1000);
    }

    private void atCashRegister() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t| \t\t\t\t\tEmployee");
    }

    private void paymentAccepted() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t| \t\t\t\t\t\t\tEmployee");
    }
}


