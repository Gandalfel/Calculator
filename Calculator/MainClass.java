package Calculator;

import Calculator.Logic.Filter;
import Calculator.ViewAndDisplay.Window;
import javax.swing.*;

public class MainClass
{
    public static void main(String[] args)
    {
        Window window = new Window();
        Filter filter = new Filter();
        try
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("LookAmdFeel Error");
        }
    }
}
