import java.awt.*;
import javax.swing.*;

public class TellerGUI {
    private JFrame frame;
    private JPanel panelFirst, panelSecond;
    private JTextField textFieldBalance, textFieldAmount;
    private JLabel labelBalance, labelAmount;
    private JButton buttonDeposit, buttonWithdraw, buttonExit;

    public TellerGUI() {
        frame = new JFrame("TellerGUI");
        panelFirst = new JPanel();
        panelSecond = new JPanel();
        labelBalance = new JLabel("Balance");
        labelAmount = new JLabel("Amount");
        textFieldBalance = new JTextField("6000.0");
        textFieldAmount = new JTextField();
        buttonDeposit = new JButton("Deposit");
        buttonWithdraw = new JButton("Withdraw");
        buttonExit = new JButton("Exit");

        panelFirst.setLayout(new GridLayout(2, 2));
        panelSecond.setLayout(new FlowLayout());
        frame.setLayout(new GridLayout(2, 1));
        textFieldBalance.setEditable(false);
        panelFirst.add(labelBalance);
        panelFirst.add(textFieldBalance);
        panelFirst.add(labelAmount);
        panelFirst.add(textFieldAmount);
        panelSecond.add(buttonDeposit);
        panelSecond.add(buttonWithdraw);
        panelSecond.add(buttonExit);
        frame.add(panelFirst);
        frame.add(panelSecond);

        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}