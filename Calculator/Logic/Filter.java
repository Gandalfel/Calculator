package Calculator.Logic;

import Calculator.ViewAndDisplay.Display;

import java.awt.event.KeyEvent;
import static Calculator.Logic.Calculator.isNumber;
import static Calculator.ViewAndDisplay.Display.displayingStrings;
import static Calculator.ViewAndDisplay.Display.deleteScreenContent;

public class Filter
{
    private static String statement = "";
    private static StringBuilder statementSb = new StringBuilder(statement);
    private static char keyChar;
    private static String keyString = "";
    private static String result = "";
    private static boolean enter = false;

    public static class FiltratingCharacters implements Runnable
    {
        public FiltratingCharacters()
        {
            run();
        }

        @Override
        public void run()
        {
            if(keyString.equals("0") || keyString.equals("1") || keyString.equals("2") || keyString.equals("3") ||
                    keyString.equals("4") || keyString.equals("5") || keyString.equals("6") || keyString.equals("7") ||
                    keyString.equals("8") || keyString.equals("9") || keyString.equals("+") || keyString.equals("-") ||
                    keyString.equals("*") || keyString.equals("/") || keyString.equals("(") || keyString.equals(")"))
            {
                synchronized (statementSb)
                {
                    statementSb.append(keyString);
                    displayingStrings(keyString);
                    System.out.print(keyChar);
                }
            }
            else if (keyString.equals(",") || keyString.equals("."))
            {
                synchronized (statementSb)
                {
                    displayingStrings(".");
                    statementSb.append(".");
                }
            }
            else if(keyChar == KeyEvent.VK_ENTER)
            {
                deleteScreenContent();
                result += statementSb;
                Converter.converting(Filter.getResult());
                Calculator.calculating(Converter.getResult());
                displayingStrings(Calculator.getResult());

                System.out.println("\r");
                System.out.println("FilterResult(): " + Filter.getResult());
                System.out.println("ConverterResult(): " + Converter.getResult());
                System.out.println("CalculatorResult(): " + Calculator.getResult());
                statementSb.delete(0, statementSb.length());

                result = "";
            }
        }
    }

    public static void charsFromKeyL(KeyEvent e)
    {
        keyString = "";
        keyChar = e.getKeyChar();
        keyString += keyChar;
        new FiltratingCharacters();
        //new AdditionMultiplicationSign();
    }

    public static void charsFromActionL(String a)
    {
        keyString = a;
        new FiltratingCharacters();
    }

    public static void deleteStatementSbContent()
    {
        statementSb.delete(0, statementSb.length());
    }

    public static void eqalTo()
    {
        deleteScreenContent();
        result += statementSb;
        Converter.converting(Filter.getResult());
        Calculator.calculating(Converter.getResult());
        displayingStrings(Calculator.getResult());
    }

    public static String getResult()
    {
        return result;
    }

    public static class AdditionMultiplicationSign  implements Runnable
    {
        public AdditionMultiplicationSign()
        {
            run();
        }

        public void run()
        {
            System.out.println("frsezdf");
            for(int a = 0;a == statementSb.length();a++)
            {
                if (isNumber(statementSb.charAt(a)) == true ||
                        statementSb.charAt(a - 1) == ')') {
                    String numberChar = String.valueOf(statementSb.charAt(a));
                    synchronized (statementSb)
                    {
                        statementSb.deleteCharAt(a);
                        statementSb.append('*');
                        statementSb.append(numberChar);
                        System.out.println("ten wątek wstawiający dodatkowy znak dzielenia");
                    }
                }
                else if (statementSb.charAt(a) == '(' ||
                        isNumber(statementSb.charAt(a - 1)) == true)
                {
                    String numberChar = String.valueOf(statementSb.charAt(a));
                    synchronized (statementSb)
                    {
                        statementSb.deleteCharAt(a);
                        statementSb.append('*');
                        statementSb.append(numberChar);
                    }
                    result += statementSb;
                }
            }
        }
    }
}
