package Calculator.ViewAndDisplay;

import Calculator.Logic.Filter;
import static Calculator.Logic.Calculator.isNumber;
import static Calculator.Logic.Calculator.isOperator;

public class Display
{
    public static void displayingStrings(String a)
    {
        Window.screen.append(a);
    }

    public static void deleteScreenContent()
    {
        Window.screen.setText("");
    }
}
