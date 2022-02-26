import java.util.Stack;
import java.util.Scanner;

public class DelimiterChecker {
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to the Delimiter Checker Program");
        System.out.println("Written by Matt McCullough");
        System.out.print("Enter a list: ");
        String expression = reader.nextLine();
        Stack<Character> parens = new Stack<Character>();
        boolean balanced = true;
        int index = 0;
        while(balanced == true && index<expression.length())
        {
            char nextChar = expression.charAt(index);
            if(nextChar == '{' || nextChar == '[' || nextChar == '(' || nextChar == '<')
            {
                parens.push(nextChar);
            }
            if(nextChar == '}' || nextChar == ']' || nextChar == ')' || nextChar == '>')
            {
                char testChar; //to check if same
                if(parens.empty() == true)
                {
                    balanced=false;
                }
                if(parens.empty()==false)
                {
                    testChar = parens.pop();
                    if(testChar == '{' && nextChar != '}')
                        balanced=false;
                    if(testChar == '[' && nextChar != ']')
                        balanced=false;
                    if(testChar == '(' && nextChar != ')')
                        balanced=false;
                    if(testChar == '<' && nextChar != '>')
                        balanced=false;
                }
            }
            index++;
        }
        if(parens.empty()==false) //if stack is somehow not empty by the end which it should when its balanced, set balanced to false
            balanced=false;

        if(balanced == true)
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}
