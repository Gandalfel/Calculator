package Calculator.Logic;

import java.util.Stack;
import java.util.StringTokenizer;

import static Calculator.Logic.Calculator.isOperator;

public class Converter
{
    private static String statement = "";
    private static String result = "";

    public static void converting(String var) //zmienną tej metody jest
    {
        statement = var;
        Stack<String> stackOfSigns= new Stack<>();
        StringTokenizer stringTokenizerOfStatement = new StringTokenizer(var, "+-*/()", true);
        while (stringTokenizerOfStatement.hasMoreTokens())
        {
            String nextTokenFromStatement = stringTokenizerOfStatement.nextToken();
            if (isOperator(nextTokenFromStatement))
            {
                while(!stackOfSigns.empty() && priority(stackOfSigns.peek()) >= priority(nextTokenFromStatement))
                    Converter.result += stackOfSigns.pop() + " ";
                stackOfSigns.push(nextTokenFromStatement);
            }
            else if (nextTokenFromStatement.equals("(")) stackOfSigns.push(nextTokenFromStatement);
            else if (nextTokenFromStatement.equals(")"))
            {
                while(!stackOfSigns.peek().equals("(")) Converter.result += stackOfSigns.pop() + " ";
                stackOfSigns.pop();
            }
            else Converter.result += nextTokenFromStatement + " ";
        }
        while (!stackOfSigns.empty()) Converter.result += stackOfSigns.pop() + " "; //tutaj byćmoże trzeba będzie .length pozostałę
    }

    private static int priority(String operator)
    {
        if (operator.equals("+") || operator.equals("-")) return 1;
        else if (operator.equals("*") || operator.equals("/")) return 2;
        else return 0;
    }

    public static String getResult()
    {
        return result;
    }
}
