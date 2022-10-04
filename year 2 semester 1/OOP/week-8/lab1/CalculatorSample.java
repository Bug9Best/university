
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorSample implements ActionListener {

    private final JFrame frame;
    private final JPanel panel;
    private final JTextField textField;
    private final JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private final JButton buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonDelete, buttonEqual;
    private char operator;
    private String firstValue;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int widthScreen = (int) screenSize.getWidth();
    private final int heightScreen = (int) screenSize.getHeight();
    private final int framePositionX = (widthScreen / 2) - 150;
    private final int framePositionY = (heightScreen / 2) - 150;

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

        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonEqual.addActionListener(this);

        frame.setBounds(framePositionX, framePositionY, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button0) {
            textField.setText(textField.getText() + "0");
        } else if (e.getSource() == button1) {
            textField.setText(textField.getText() + "1");
        } else if (e.getSource() == button2) {
            textField.setText(textField.getText() + "2");
        } else if (e.getSource() == button3) {
            textField.setText(textField.getText() + "3");
        } else if (e.getSource() == button4) {
            textField.setText(textField.getText() + "4");
        } else if (e.getSource() == button5) {
            textField.setText(textField.getText() + "5");
        } else if (e.getSource() == button6) {
            textField.setText(textField.getText() + "6");
        } else if (e.getSource() == button7) {
            textField.setText(textField.getText() + "7");
        } else if (e.getSource() == button8) {
            textField.setText(textField.getText() + "8");
        } else if (e.getSource() == button9) {
            textField.setText(textField.getText() + "9");
        } else if (e.getSource() == buttonDelete) {
            textField.setText("");
        } else if (e.getSource() == buttonEqual) {
            this.calculateResult();
        } else {
            this.setOperator(e);
        }
    }

    public void resetValue() {
        this.firstValue = textField.getText();
        textField.setText("");
    }

    public void setOperator(ActionEvent e) {
        if (e.getSource() == buttonPlus) {
            this.operator = '+';
            this.resetValue();
        } else if (e.getSource() == buttonMinus) {
            this.operator = '-';
            this.resetValue();
        } else if (e.getSource() == buttonMultiply) {
            this.operator = '*';
            this.resetValue();
        } else if (e.getSource() == buttonDivide) {
            this.operator = '/';
            this.resetValue();
        }
    }

    public void calculateResult() {
        if (this.operator == '+') {
            textField.setText((Double.parseDouble(firstValue) + Double.parseDouble(textField.getText())) + "");
        } else if (this.operator == '-') {
            textField.setText((Double.parseDouble(firstValue) - Double.parseDouble(textField.getText())) + "");
        } else if (this.operator == '*') {
            textField.setText((Double.parseDouble(firstValue) * Double.parseDouble(textField.getText())) + "");
        } else if (this.operator == '/') {
            textField.setText((Double.parseDouble(firstValue) / Double.parseDouble(textField.getText())) + "");
        }
    }

    public static void main(String[] args) {
        new CalculatorSample();
    }
}
