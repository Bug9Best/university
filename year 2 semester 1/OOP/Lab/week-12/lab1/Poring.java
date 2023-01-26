package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Poring extends JFrame implements Runnable, MouseListener {
  private JFrame window;
  private JTextField number;
  private JLabel poringLabel;

  public Poring(int numberOfPoring) {
    window = new JFrame();
    number = new JTextField(numberOfPoring + "");
    poringLabel = new JLabel(new ImageIcon("./lab1/Poring.jpg"));

    number.setEditable(false);
    number.setBorder(null);
    number.setFont(new Font("TimesRoman", Font.BOLD, 14));

    window.setLayout(new FlowLayout());
    window.add(poringLabel);
    window.add(number);

    poringLabel.addMouseListener(this);

    window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    window.setSize(170, 135);
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    window.setLocation((int) (Math.random() * (dimension.getWidth() - window.getWidth())),
        (int) (Math.random() * (dimension.getHeight() - window.getHeight())));
    window.setResizable(false);
    window.setVisible(true);
  }

  public void run() {
    try {
      while (true) {
        Thread.sleep(30);
        if (Math.random() <= 0.5) {
          if (Math.random() <= 0.5) {
            window.setLocation(window.getX() + 2, window.getY() + 2);
          } else {
            window.setLocation(window.getX() - 2, window.getY() - 2);
          }
        } else {
          if (Math.random() <= 0.5) {
            window.setLocation(window.getX() + 2, window.getY() - 2);
          } else {
            window.setLocation(window.getX() - 2, window.getY() + 2);
          }
        }
      }
    } catch (Exception e) {
      System.out.print(e);
    }

  }

  public synchronized void mouseClicked(MouseEvent ev) {}
  public void mouseEntered(MouseEvent ev) {}
  public void mouseExited(MouseEvent ev) {}
  public void mousePressed(MouseEvent ev) {window.dispose();}
  public void mouseReleased(MouseEvent ev) {}
}