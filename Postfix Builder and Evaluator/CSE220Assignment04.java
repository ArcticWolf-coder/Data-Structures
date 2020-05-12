package assignment4;
import java.util.Scanner;
//import java.util.Stack;//you should use the stack you have built in assignment 03. If you are using your own stack, remove this line; otherwise, import & use java's default stack class.
public class CSE220Assignment04{
    public static String postFixBuilder(String s) throws StackUnderflowException,StackOverflowException{
        String sum = "";
        Stack z = new ListStack();
        for (int i = 0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c))
                sum += c;

            else if (c == '(')
                z.push(Character.toString(c));

            else if (c == ')')
            {
                for (;!z.isEmpty() && (!z.peek().equals("("));) {
                    sum += z.pop();
                }

                if (!z.isEmpty() && (!z.peek().equals("(")))
                    return "Not Valid";
                else
                    z.pop();
            }
            else
            {
                for (;!z.isEmpty() && P(c) <= P(z.peek().charAt(0));) {
                    sum += z.pop();
                }
                z.push(Character.toString(c));
            }

        }
        while (!z.isEmpty())
            sum += z.pop();

        return sum;
    }
    public static int P(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

        }
        return -1;
    }
    public static int postFixEvaluator(String s) throws StackOverflowException,StackUnderflowException{
        Stack z=new ArrayStack();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
                z.push(Integer.toString(c - '0'));
            else
            {
                int a = Integer.parseInt(z.pop());
                int b = Integer.parseInt(z.pop());
                switch(c)
                {
                    case '+':
                        z.push(Integer.toString(a+b));
                        break;

                    case '-':
                        z.push(Integer.toString(b-a));
                        break;

                    case '/':
                        z.push(Integer.toString(b/a));
                        break;

                    case '*':
                        z.push(Integer.toString(a*b));
                        break;
                }
            }
        }
        return Integer.parseInt(z.pop());
    }
    public static void main(String[]args) throws StackUnderflowException,StackOverflowException{
        String exp=new Scanner(System.in).next();
        String postFixExp = postFixBuilder(exp);
        System.out.println("Post Fix Expression: "+postFixExp);
        int result = postFixEvaluator(postFixExp);
        System.out.println("Answer: "+result);
    }
}