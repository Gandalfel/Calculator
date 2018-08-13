package Calculator.ViewAndDisplay;

import Calculator.Logic.Filter;

import static Calculator.Logic.Filter.deleteStatementSbContent;
import static Calculator.ViewAndDisplay.Display.deleteScreenContent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static Calculator.Logic.Filter.charsFromActionL;
import static Calculator.Logic.Filter.eqalTo;

public class Window extends JFrame {
    protected static JTextArea screen;
    private static Object source;

    static String t0ext = "C", t6ext = "", t11ext = "", t17ext = "", t23ext = "",
            t1ext = "B", t7ext = "", t12ext = "", t18ext = "", t24ext = "",
            t2ext = "7", t8ext = "8", t13ext = "9", t19ext = "/", t25ext = "%",
            t3ext = "4", t9ext = "5", t14ext = "6", t20ext = "*", t26ext = "()",
            t4ext = "1", t10ext = "2", t15ext = "3", t21ext = "-", t27ext = "=",
            t5ext = "0", t16ext = ".", t22ext = "+";

    private static JButton b0utton = new JButton(t0ext), b10utton = new JButton(t10ext), b19utton = new JButton(t19ext),
            b1utton = new JButton(t1ext), b11utton = new JButton(t11ext), b20utton = new JButton(t20ext),
            b2utton = new JButton(t2ext), b12utton = new JButton(t12ext), b21utton = new JButton(t21ext),
            b3utton = new JButton(t3ext), b13utton = new JButton(t13ext), b22utton = new JButton(t22ext),
            b4utton = new JButton(t4ext), b14utton = new JButton(t14ext), b23utton = new JButton(t23ext),
            b5utton = new JButton(t5ext), b15utton = new JButton(t15ext), b24utton = new JButton(t24ext),
            b6utton = new JButton(t6ext), b16utton = new JButton(t16ext), b25utton = new JButton(t25ext),
            b7utton = new JButton(t7ext), b17utton = new JButton(t17ext), b26utton = new JButton(t26ext),
            b8utton = new JButton(t8ext), b18utton = new JButton(t18ext), b27utton = new JButton(t27ext),
            b9utton = new JButton(t9ext);

    public Window()
    {
        setSize(255, 320);
        setResizable(false);
        setTitle("Calculator");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        screen = new JTextArea();
        screen.setBounds(10, 40, 222, 50);
        screen.setEditable(false);
        screen.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        screen.setFont(new Font("Arial", Font.ITALIC, 30));
        screen.setLayout(null);
        screen.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                Filter.charsFromKeyL(e);
            }

            @Override
            public void keyPressed(KeyEvent e)
            {

            }

            @Override
            public void keyReleased(KeyEvent e)
            {

            }
        });
        add(screen);

        b0utton.setBounds(10, 95, 42, 25);
        b0utton.addActionListener(e ->
        {
            deleteScreenContent();
            deleteStatementSbContent();
        });
        add(b0utton);

        b1utton.setBounds(10, 125, 42, 25);
        b1utton.addActionListener(e ->
        {
            charsFromActionL(t1ext);
        });
        add(b1utton);

        b2utton.setBounds(10, 155, 42, 25);
        b2utton.addActionListener(e ->
        {
            charsFromActionL(t2ext);
        });
        add(b2utton);

        b3utton.setBounds(10, 185, 42, 25);
        b3utton.addActionListener(e ->
        {
            charsFromActionL(t3ext);
        });
        add(b3utton);

        b4utton.setBounds(10, 215, 42, 25);
        b4utton.addActionListener(e ->
        {
            charsFromActionL(t4ext);
        });
        add(b4utton);

        b5utton.setBounds(10, 245, 87, 25);
        b5utton.addActionListener(e ->
        {
            charsFromActionL(t5ext);
        });
        add(b5utton);

        //druga kolumna
        b6utton.setBounds(55, 95, 42, 25);
        b6utton.addActionListener(e ->
        {
            charsFromActionL(t6ext);
        });
        add(b6utton);

        b7utton.setBounds(55, 125, 42, 25);
        b7utton.addActionListener(e ->
        {
            charsFromActionL(t7ext);
        });
        add(b7utton);

        b8utton.setBounds(55, 155, 42, 25);
        b8utton.addActionListener(e ->
        {
            charsFromActionL(t8ext);
        });
        add(b8utton);

        b9utton.setBounds(55, 185, 42, 25);
        b9utton.addActionListener(e ->
        {
            charsFromActionL(t9ext);
        });
        add(b9utton);

        b10utton.setBounds(55, 215, 42, 25);
        b10utton.addActionListener(e ->
        {
            charsFromActionL(t10ext);
        });
        add(b10utton);

        //trzecia kolumna
        b11utton.setBounds(100, 95, 42, 25);
        b11utton.addActionListener(e ->
        {
            charsFromActionL(t11ext);
        });
        add(b11utton);

        b12utton.setBounds(100, 125, 42, 25);
        b12utton.addActionListener(e ->
        {
            charsFromActionL(t12ext);
        });
        add(b12utton);

        b13utton.setBounds(100, 155, 42, 25);
        b13utton.addActionListener(e ->
        {
            charsFromActionL(t13ext);
        });
        add(b13utton);

        b14utton.setBounds(100, 185, 42, 25);
        b14utton.addActionListener(e ->
        {
            charsFromActionL(t14ext);
        });
        add(b14utton);

        b15utton.setBounds(100, 215, 42, 25);
        b15utton.addActionListener(e ->
        {
            charsFromActionL(t15ext);
        });
        add(b15utton);

        b16utton.setBounds(100, 245, 42, 25);
        b16utton.addActionListener(e ->
        {
            charsFromActionL(t16ext);
        });
        add(b16utton);

        //czwarta kolumna
        b17utton.setBounds(145, 95, 42, 25);
        b17utton.addActionListener(e ->
        {
            charsFromActionL(t17ext);
        });
        add(b17utton);

        b18utton.setBounds(145, 125, 42, 25);
        b18utton.addActionListener(e ->
        {
            charsFromActionL(t18ext);
        });
        add(b18utton);

        b19utton.setBounds(145, 155, 42, 25);
        b19utton.addActionListener(e ->
        {
            charsFromActionL(t19ext);
        });
        add(b19utton);

        b20utton.setBounds(145, 185, 42, 25);
        b20utton.addActionListener(e ->
        {
            charsFromActionL(t20ext);
        });
        add(b20utton);

        b21utton.setBounds(145, 215, 42, 25);
        b21utton.addActionListener(e ->
        {
            charsFromActionL(t21ext);
        });
        add(b21utton);

        b22utton.setBounds(145, 245, 42, 25);
        b22utton.addActionListener(e ->
        {
            charsFromActionL(t22ext);
        });
        add(b22utton);

        //piąta kolumna
        b23utton.setBounds(190, 95, 42, 25);
        b23utton.addActionListener(e ->
        {
            charsFromActionL(t23ext);
        });
        add(b23utton);

        b24utton.setBounds(190, 125, 42, 25);
        b24utton.addActionListener(e ->
        {
            charsFromActionL(t24ext);
        });
        add(b24utton);

        b25utton.setBounds(190, 155, 42, 25);
        b25utton.addActionListener(e ->
        {
            charsFromActionL(t25ext);
        });
        add(b25utton);

        b26utton.setBounds(190, 185, 42, 25);
        b26utton.addActionListener(e ->
        {
            charsFromActionL(t26ext);
        });
        add(b26utton);

        b27utton.setBounds(190, 215, 42, 55);
        b27utton.addActionListener(e ->
        {
            eqalTo();
        });
        add(b27utton);
    }
}
