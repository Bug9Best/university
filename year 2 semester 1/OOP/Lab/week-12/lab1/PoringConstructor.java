package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PoringConstructor implements ActionListener {
  private JButton addButton;
  private JFrame frame;
  private int numberOfPoring = 0;

  public PoringConstructor() {
    addButton = new JButton("Add");
    frame = new JFrame();
    
    frame.setLayout(new FlowLayout());
    frame.add(addButton);
    
    addButton.addActionListener(this);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource().equals(addButton)) {
      numberOfPoring++;
      Poring poring = new Poring(numberOfPoring);
      Thread thread = new Thread(poring);
      thread.start();
    }
  }

  // For Debugging
  public class Main {
    public static void main(String[] args) {
      new PoringConstructor();
    }
  }
}
