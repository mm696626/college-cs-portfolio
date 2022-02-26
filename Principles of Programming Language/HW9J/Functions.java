import java.util.Scanner;




public class Functions {

    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int test = reader.nextInt();
        Number n = new Number(test);

        System.out.println((test) + " doubled is: " + Doubler(test));
        Tripler(n);
        System.out.println((test) + " tripled is: " + n.getNum());
        System.out.println((test) + " is prime: " + isPrime(test));



    }
    public static int Doubler(int x)
    {
        int doubled = 0;
        doubled = x*2;
        return doubled;
    }


    public static void Tripler(Number num)
    {
       int numToTriple = num.getNum();
       num.setNum(numToTriple*3);
    }


    public static boolean isPrime(int x)
    {

        if(x <=0)
            return false;

        if (x == 1 || x==2)
            return true;

        for (int i = 2; i < x; i++)
            if (x % i == 0)
                return false;

        return true;

    }

}


