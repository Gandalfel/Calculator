package Calculator.Logic;

import java.util.Stack;
import static Calculator.ViewAndDisplay.Display.deleteScreenContent;
import static Calculator.ViewAndDisplay.Display.displayingStrings;

public class Calculator
{
    private static String statement;
    private static String result;

    public static void calculating(String s)
    {
        try
        {
            statement = s;
            statement = statement.trim();
            Stack<Double> numbers = new Stack<>();
            String[] tokens = statement.split(" +");
            double answer = 0.0;

            for (String token : tokens)
            {
                if (!isOperator(token))
                {
                    numbers.add(Double.parseDouble(token));
                }
                else
                {
                    double a = numbers.pop();
                    double b = numbers.pop();
                    switch (token)
                    {
                        case "+":
                            answer = a + b;
                            break;
                        case "-":
                            answer = b - a;
                            break;
                        case "*":
                            answer = a * b;
                            break;
                        case  "/":
                            answer = b / a;
                            break;
                    }
                    numbers.add(answer);
                }
            }
            result = String.valueOf(answer);
        }
        catch (java.util.EmptyStackException e)
        {
            deleteScreenContent();
            displayingStrings("bad data");
        }
    }

    public static void resetResult()
    {
        result = "";
    }

    public static boolean isOperator(String n)
    {
        boolean bool = false;
        if (n.equals("+") || n.equals("-") || n.equals("*") || n.equals("/")) {bool = true;}
        return bool;
    }

    /*public static boolean isOperator(char n)
    {
        boolean bool = false;
        if (n == '+' || n == '-' || n == '*' || n == '/') {bool = true;}
        return bool;
    }*/

    public static boolean isNumber(String c)
    {
        boolean var = false;
        if (c.equals("0") || c.equals("1") || c.equals("2") || c.equals("3") || c.equals("4") ||
                c.equals("5") || c.equals("6") || c.equals("7") || c.equals("8") || c.equals("9"))
        {
            var = true;
        }
        return var;
    }

    public static boolean isNumber(char c)
    {
        boolean var = false;
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
                c == '5' || c == '6' || c == '7' || c == '8' || c == '9')
        {
            var = true;
        }
        return var;
    }

    public static String getResult()
    {
        return result;
    }
}
