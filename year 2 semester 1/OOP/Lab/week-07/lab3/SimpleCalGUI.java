import java.awt.*;
import javax.swing.*;

public class SimpleCalGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField textfieldFirst, textfieldSecond, textfieldResult;
    private JButton buttonPlus, buttonMinus, buttonMultiply, buttonDivide;

    public SimpleCalGUI() {
        frame = new JFrame("SimpleCalGUI");
        panel = new JPanel();
        textfieldFirst = new JTextField();
        textfieldSecond = new JTextField();
        textfieldResult = new JTextField();
        buttonPlus = new JButton("Plus");
        buttonMinus = new JButton("Minus");
        buttonMultiply = new JButton("Mutiply");
        buttonDivide = new JButton("Divide");

        frame.setLayout(new GridLayout(4, 1));
        panel.setLayout(new FlowLayout());

        panel.add(buttonPlus);
        panel.add(buttonMinus);
        panel.add(buttonMultiply);
        panel.add(buttonDivide);
        frame.add(textfieldFirst);
        frame.add(textfieldSecond);
        frame.add(panel);
        frame.add(textfieldResult);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
