import java.util.Scanner;

public class Recursion {

    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = reader.nextInt();
        System.out.print("Enter another integer: ");
        int r = reader.nextInt();
        System.out.println(choose(n,r));
        System.out.println(josephus(n,r));


    }


    public static int choose(int n, int r){
        if(r==0)
            return 1;
        if(r==n)
            return 1;
        if(r>n)
            return 0;
        else
            return choose(n-1,r-1) + choose(n-1,r);

    }
    public static int josephus(int n, int k)
    {
        if(n==1)
            return 1;
        else
            return ((josephus(n-1,k)+k-1)%n) + 1;
    }

}
