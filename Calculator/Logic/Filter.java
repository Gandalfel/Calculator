package Calculator.Logic;

import java.awt.event.KeyEvent;
import static Calculator.Logic.Calculator.isNumber;
import static Calculator.Logic.Calculator.isOperator;
import static Calculator.ViewAndDisplay.Display.displayingStrings;
import static Calculator.ViewAndDisplay.Display.deleteScreenContent;

public class Filter
{
    private static String statement = "";
    private static char keyChar;
    private static String keyString = "";
    private static String result = "";
    private static boolean isNumberDeleteScreenContent = false;

    private static String buffer = "";
    public static void filtrating()
    {
        //System.out.println("statement.length(): " + statement.length());
        System.out.println("buffer: " + buffer);
        System.out.println("keyString: " + keyString);
        if(isNumber(keyString) || isOperator(keyString)|| keyString.equals("*") ||
                keyString.equals("/") || keyString.equals("(") || keyString.equals(")"))
        {
            if ((isNumber(keyString) || keyString.equals("(")) && statement.length() < 1)
            {
                statement += keyString;
                buffer = keyString;
                displayingStrings(keyString);
            }
            else if (statement.length() >= 1)
            {
                if (isNumber(buffer) && isNumber(keyString))
                {
                    statement += keyString;
                    buffer = keyString;
                    displayingStrings(keyString);
                }
                else if (isNumber(buffer) && keyString.equals("("))
                {
                    statement += "*";
                    statement += keyString;
                    buffer = keyString;
                    displayingStrings("×");
                    displayingStrings(keyString);
                }
                else if (buffer.equals("(") && isOperator(keyString))
                {
                    //nothing
                }
                else if (buffer.equals("(") && isNumber(keyString))
                {
                    statement += keyString;
                    buffer = keyString;
                    displayingStrings(keyString);
                }
                else if (isNumber(buffer) && keyString.equals(")"))
                {
                    statement += keyString;
                    buffer = keyString;
                    displayingStrings(keyString);
                }
                else if (buffer.equals(")") && isNumber(keyString))
                {
                    statement += "*";
                    statement += keyString;
                    buffer = keyString;
                    displayingStrings("×");
                    displayingStrings(keyString);
                }
                else if (isNumber(buffer) && isOperator(keyString))
                {
                    statement += keyString;
                    buffer = keyString;
                    displayingStrings(keyString);
                }
                else if (isOperator(buffer) && isNumber(keyString))
                {
                    statement += keyString;
                    buffer = keyString;
                    displayingStrings(keyString);
                }
                else if (isOperator(buffer) && keyString.equals("("))
                {
                    statement += keyString;
                    buffer = keyString;
                    displayingStrings(keyString);
                }
                else if (buffer.equals(")") && isOperator(keyString))
                {
                    statement += keyString;
                    buffer = keyString;
                    displayingStrings(keyString);
                }
                else if(keyChar == KeyEvent.VK_ENTER)
                {
                    if (!isOperator(buffer) && (!buffer.equals("(") || !buffer.equals(")")))
                    deleteScreenContent();
                    result += statement;
                    Converter.converting(Filter.getResult());
                    Calculator.calculating(Converter.getResult());
                    displayingStrings(Calculator.getResult());

                    System.out.println("\r");
                    System.out.println("FilterResult(): " + Filter.getResult());
                    System.out.println("ConverterResult(): " + Converter.getResult());
                    System.out.println("CalculatorResult(): " + Calculator.getResult());
                    statement = "";
                    result = "";
                }
            }
        }
        System.out.println("statement.length(): " + statement.length());
    }

    public static void resetStatementSbAndResult()
    {
        statement = "";
        result = "";
    }

    public static void charsFromKeyL(KeyEvent e)
    {
        keyString = "";
        keyChar = e.getKeyChar();
        keyString += keyChar;
        //System.out.print(keyString);
        filtrating();
    }

    public static void charsFromActionL(String a)
    {
        keyString = a;
        //System.out.print(keyString);
        filtrating();
    }

    public static void eqalTo()
    {
        deleteScreenContent();
        result += statement;
        Converter.converting(Filter.getResult());
        Calculator.calculating(Converter.getResult());
        displayingStrings(Calculator.getResult());
    }

    public static String getResult()
    {
        return result;
    }
}
