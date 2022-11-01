package lab2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class StudentView implements ActionListener, WindowListener {
    private JFrame frame;
    private JPanel panelForm, panelButtons;
    private JLabel labelName, labelID, labelMoney;
    private JTextField textFieldName, textFieldID, textFieldMoney;
    private JButton buttonDeposit, buttonWithdraw;

    private int money = 0;
    Student student = (Student) this.readFile();

    public StudentView() {
        frame = new JFrame("StudentView");
        panelForm = new JPanel();
        panelButtons = new JPanel();
        labelID = new JLabel("ID");
        labelName = new JLabel("Name");
        labelMoney = new JLabel("Money");
        textFieldName = new JTextField(student.getName());
        textFieldID = new JTextField(student.getID() + "");
        textFieldMoney = new JTextField(student.getMoney() + "");
        buttonDeposit = new JButton("Deposit");
        buttonWithdraw = new JButton("Withdraw");

        panelForm.setLayout(new GridLayout(3, 2));
        panelButtons.setLayout(new FlowLayout());
        textFieldMoney.setEditable(false);

        panelForm.add(labelID);
        panelForm.add(textFieldID);
        panelForm.add(labelName);
        panelForm.add(textFieldName);
        panelForm.add(labelMoney);
        panelForm.add(textFieldMoney);
        panelButtons.add(buttonDeposit);
        panelButtons.add(buttonWithdraw);
        frame.add(panelForm, BorderLayout.NORTH);
        frame.add(panelButtons, BorderLayout.SOUTH);

        buttonDeposit.addActionListener(this);
        buttonWithdraw.addActionListener(this);
        frame.addWindowListener(this);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void increasValue() {
        textFieldMoney.setText((this.money += 100) + "");
    }

    public void decreaseValue() {
        if (this.money <= 0) {
            this.money = 0;
        } else {
            textFieldMoney.setText((this.money -= 100) + "");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonDeposit) {
            this.increasValue();
        } else if (e.getSource() == buttonWithdraw) {
            this.decreaseValue();
        }
    }

    public void saveFile() {
        Student s = new Student();
        s.setName(this.textFieldName.getText());
        s.setID(Integer.parseInt(this.textFieldID.getText()));
        s.setMoney(this.money);
        try (FileOutputStream fOut = new FileOutputStream("StudentM.dat");
                ObjectOutputStream oout = new ObjectOutputStream(fOut);) {
            oout.writeObject(s);
            System.out.print("Serialized data is saved");
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public Object readFile() {
        Student s = null;
        try (FileInputStream fin = new FileInputStream("StudentM.dat");
                ObjectInputStream in = new ObjectInputStream(fin);) {
            s = (Student) in.readObject();
            System.out.println("Reading Student successful");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }

    public void windowClosing(WindowEvent e) {
        this.saveFile();
    }

    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}
