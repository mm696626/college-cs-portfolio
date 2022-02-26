import java.util.Scanner;

//Author: Matt McCullough
public class TriangleIf {
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int a = reader.nextInt();
        System.out.print("Enter another integer: ");
        int b = reader.nextInt();
        System.out.print("Enter another integer: ");
        int c = reader.nextInt();

        boolean flag = true;

        if((a+b)<=c)
            flag = false;
        if((b+c)<=a)
            flag = false;
        if((c+a)<=b)
            flag = false;
        if(flag == true)
        {
            System.out.println("Triangle is valid");
        }
        else
            System.out.println("Invalid triangle");

        if((a+b)>c)
        {
            if((b+c)>a){
                if((c+a)>b)
                    System.out.println("Triangle is valid");
            }
        }
        else
            System.out.println("Invalid triangle");

        if((a+b)>c && (b+c)>a && (c+a)>b)
        {
            System.out.println("Triangle is valid");
        }
        else
            System.out.println("Invalid triangle");



    }

}
