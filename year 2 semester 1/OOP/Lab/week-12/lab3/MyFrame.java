package lab3;
import javax.swing.*;

public class MyFrame {

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    MyClock clock = new MyClock();
    Thread t = new Thread(clock);

    t.start();
    frame.add(clock);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}
