import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TellerGUI implements ActionListener {
    private JFrame frame;
    private JPanel panelFirst, panelSecond;
    private JTextField textFieldBalance, textFieldAmount;
    private JLabel labelBalance, labelAmount;
    private JButton buttonDeposit, buttonWithdraw, buttonExit;
    private Account account;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int widthScreen = (int) screenSize.getWidth();
    private final int heightScreen = (int) screenSize.getHeight();
    private final int framePositionX = (widthScreen / 2) - 150;
    private final int framePositionY = (heightScreen / 2) - 150;

    public TellerGUI() {
        account = new Account(6000, "");
        frame = new JFrame("TellerGUI  (Week8 Lab4)");
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

        buttonDeposit.addActionListener(this);
        buttonWithdraw.addActionListener(this);
        buttonExit.addActionListener(this);

        frame.setBounds(framePositionX, framePositionY, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonDeposit) {
            account.deposit(Double.parseDouble(textFieldAmount.getText()));
            this.showBalance();
        } else if (e.getSource() == buttonWithdraw) {
            account.withdraw(Double.parseDouble(textFieldAmount.getText()));
            this.showBalance();
        } else {
            System.exit(0);
        }
    }

    public void showBalance() {
        textFieldBalance.setText(account.getBalance() + "");
        textFieldAmount.setText("");
    }

    public static void main(String[] args) {
        new TellerGUI();
    }
}
