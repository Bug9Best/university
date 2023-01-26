package lab4;
import javax.swing.*;
import java.awt.event.*;

public class MyFrame implements MouseListener {
  public JFrame frame;
  public MyClock clock;
  public Thread t;
  public boolean pause = true;

  public MyFrame() {
    frame = new JFrame();
    clock = new MyClock();
    t = new Thread(clock);
    t.start();

    clock.addMouseListener(this);
    
    frame.add(clock);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new MyFrame();
  }

  public synchronized void mouseClicked(MouseEvent e) {
    if (pause) {
      clock.stopWatch();

    } else {
      clock.resumeWatch();
    }
    this.pause = !this.pause;
  }

  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
}
