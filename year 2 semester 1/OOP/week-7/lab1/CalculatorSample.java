import java.awt.*;
import javax.swing.*;

public class CalculatorSample {
    private final JFrame frame;
    private final JPanel panel;
    private final JTextField textField;
    private final JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private final JButton buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonDelete, buttonEqual;

    public CalculatorSample() {
        frame = new JFrame("Calculator Sample (Week8 Lab3)");
        panel = new JPanel();
        textField = new JTextField();
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMultiply = new JButton("x");
        buttonDivide = new JButton("/");
        buttonDelete = new JButton("c");
        buttonEqual = new JButton("=");

        frame.setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 4));
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonPlus);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonMinus);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonMultiply);
        panel.add(button0);
        panel.add(buttonDelete);
        panel.add(buttonEqual);
        panel.add(buttonDivide);
        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel);

        frame.setSize(250,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}