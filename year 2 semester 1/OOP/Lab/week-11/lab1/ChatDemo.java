package lab1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class ChatDemo implements ActionListener, WindowListener {
    private JFrame frame;
    private JPanel panelFormArea, panelFormField, panelButtons;
    private JTextArea textArea;
    private JTextField textField;
    private JButton buttonSubmit, buttonReset;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public ChatDemo() {
        frame = new JFrame("ChatDemo");
        panelFormArea = new JPanel();
        panelFormField = new JPanel();
        panelButtons = new JPanel();
        textArea = new JTextArea(this.readFile(), 20, 45);
        textField = new JTextField(45);
        buttonSubmit = new JButton("Submit");
        buttonReset = new JButton("Reset");

        textArea.setEditable(false);
        panelButtons.setLayout(new FlowLayout());

        panelFormArea.add(textArea);
        panelFormField.add(textField);
        panelButtons.add(buttonSubmit);
        panelButtons.add(buttonReset);
        frame.add(panelFormArea, BorderLayout.NORTH);
        frame.add(panelFormField, BorderLayout.CENTER);
        frame.add(panelButtons, BorderLayout.SOUTH);

        buttonSubmit.addActionListener(this);
        buttonReset.addActionListener(this);
        frame.addWindowListener(this);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void saveFile() {
        String str = this.textArea.getText();
        try (FileOutputStream fout = new FileOutputStream("ChatDemo.dat");) {
            for (int i = 0; i < str.length(); i++) {
                fout.write(str.charAt(i));
            }
            System.out.println("Writing successful");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String readFile() {
        String str = "";
        try (FileInputStream fin = new FileInputStream("ChatDemo.dat")) {
            fin.read();
            int ch;
            while ((ch = fin.read()) != -1) {
                str += (char) ch;
            }
            System.out.println("Reading successful");
        } catch (IOException e) {
            System.out.println(e);
        }
        return str;
    }

    public void addText() {
        textArea.append(this.dtf.format(LocalDateTime.now()) + " : " + textField.getText() + "\n");
    }

    public void reset() {
        textArea.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSubmit) {
            this.addText();
        } else if (e.getSource() == buttonReset) {
            this.reset();
        }
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
