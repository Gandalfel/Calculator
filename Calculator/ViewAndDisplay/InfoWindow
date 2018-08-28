package Calculator.ViewAndDisplay;

import javax.swing.*;

public class InfoWindow extends JFrame
{
    private JScrollPane scroll;
    private JTextArea versionL, dateL, whatsNewsL, descriptionL, toDoL;
    private String version = "1.1 - anti idiot update",
            date = "28.08.2018",
            whatsNews = "-mechanizm idioto-odporny\n-naprawa błędów wczytywania okna",
            description = "Kalkulator zrobiony w Javie przy użyciu biblioteki Swing.\n",
            toDo = "-ZRÓB SCROLLA DO TEGO OKIENKA \n-obsługa potęg i pierwiastków\n-całkowite przeprogramowanie " +
                    "GUI przy użyciu JavaFX";


    protected InfoWindow()
    {
        setSize(400, 550);
        setResizable(false);
        setTitle("Informations");
        setLayout(null);
        setVisible(true);

        versionL = new JTextArea("version: " + version);
        versionL.setBounds(10, 10, 370, 30);
        versionL.setEditable(false);
        add(versionL);

        dateL = new JTextArea("date: " + date);
        dateL.setBounds(10, 50, 370, 30);
        dateL.setEditable(false);
        add(dateL);

        whatsNewsL = new JTextArea("whats news: \n" + whatsNews);
        whatsNewsL.setEditable(false);
        whatsNewsL.setBounds(10, 90, 370, 70);
        add(whatsNewsL);

        descriptionL = new JTextArea("description: \n" + description);
        descriptionL.setBounds(10, 170, 370, 70);
        descriptionL.setEditable(false);
        add(descriptionL);

        toDoL = new JTextArea("to do: \n" + toDo);
        toDoL.setBounds(10, 250, 370, 70);
        toDoL.setEditable(false);
        add(toDoL);
    }
}
