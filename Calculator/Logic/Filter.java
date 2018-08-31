package Calculator.Logic;

import Calculator.ViewAndDisplay.Window;

import java.awt.event.KeyEvent;
import static Calculator.Logic.Calculator.isNumber;
import static Calculator.Logic.Calculator.isOperator;
import static Calculator.ViewAndDisplay.Window.deleteScreenContent;
import static Calculator.ViewAndDisplay.Window.displayingResult;
import static Calculator.ViewAndDisplay.Window.displayingStrings;

public class Filter
{
    private static String statement = "";
    /*private static String statementJedno = "";
    private static String statementOperator = "";*/
    private static char keyChar;
    private static String keyString = "";
    private static String result = "";
    private static String buffer = "";
    private static String buffer2 = "";

    public static void filtrating()
    {
        keyString.toLowerCase();
        /*System.out.println("buffer: " + buffer);
        System.out.println("keyString: " + keyString);*/
        if(isNumber(keyString) || isOperator(keyString)|| keyString.equals("*") ||
                keyString.equals("/") || keyString.equals("(") || keyString.equals(")") ||
                keyString.equals(",") || keyString.equals("."))
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
                else if (isNumber(buffer) && keyString.equals(")"))//tuuuuuuuu
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
                else if (buffer.equals(")") && keyString.equals("("))
                {
                    statement += "*";
                    statement += keyString;
                    buffer = keyString;
                    displayingStrings("×");
                    displayingStrings(keyString);
                }
                else if (isNumber(buffer)  && keyString.equals(".") || keyString.equals(","))
                {
                    statement += ".";
                    buffer = ".";
                    displayingStrings(keyString);
                }
                else if (buffer.equals(".") && isNumber(keyString))
                {
                    statement += keyString;
                    buffer = keyString;
                    displayingStrings(keyString);
                }
                else if(keyChar == KeyEvent.VK_ENTER)
                {
                    deleteScreenContent();
                    result += statement;
                    Converter.converting(Filter.getResult());
                    Calculator.calculating(Converter.getResult());
                    displayingResult(Calculator.getResult());

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

    public static void deleteLastCharFromStatement()
    {
        char bufferInMethod;
        StringBuilder sb = new StringBuilder(statement);
        if (sb.length() >= 1)
        {
            if (sb.charAt(sb.length() - 1) == '.')
            {
                sb.deleteCharAt(sb.length() - 1);
                buffer = String.valueOf(sb.charAt(sb.length() - 1));
                statement = String.valueOf(sb);
            }
            else if (isOperator(sb.charAt(sb.length() - 1)))
            {
                sb.deleteCharAt(sb.length() - 1);
                buffer = String.valueOf(sb.charAt(sb.length() - 1));
                statement = String.valueOf(sb);
            }
            else if (isNumber(sb.charAt(sb.length() - 1)) && sb.length() >= 1)
            {
                bufferInMethod = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                statement = String.valueOf(sb);
                if (isNumber(buffer) && sb.charAt(sb.length() - 1) == '.')
                {
                    sb.deleteCharAt(sb.length() - 1);
                    statement = String.valueOf(sb);
                }
            }
            else if (sb.charAt(sb.length() - 1) == '.')
            {
                sb.deleteCharAt(sb.length() - 1);
                statement += String.valueOf(sb);
            }
        }
        System.out.println("sb z filtrea: "+sb);
    }

    public static void charsFromKeyL(KeyEvent e)
    {
        if (statement.length() <= 12)
        {
            keyString = "";
            keyChar = e.getKeyChar();
            keyString += keyChar;
            filtrating();
        }
    }

    public static void charsFromActionL(String a)
    {
        if (statement.length() <= 12)
        {
            keyString = a;
            filtrating();
        }
    }

    public static void eqalTo()
    {
        deleteScreenContent();
        result += statement;
        Converter.converting(Filter.getResult());
        Calculator.calculating(Converter.getResult());
        displayingResult(Calculator.getResult());
        resetStatementSbAndResult();
    }

    public static String getResult()
    {
        return result;
    }
}
