package lab4;
import java.awt.*;
import javax.swing.JLabel;

public class MyClock extends JLabel implements Runnable {
  boolean pause = false;
  int count = 0;

  public void run() {
    while (true) {
      try {
        checkState();
        int sec = count % 60;
        int min = (count / 60) % 60;
        int hour = (count / 3600) % 24;
        setFont(new Font("TimesRoman", Font.BOLD, 48));
        setHorizontalAlignment(CENTER);
        setText(String.format("%02d:%02d:%02d", hour, min, sec));
        Thread.sleep(1000);
        this.count++;
      } catch (InterruptedException ex) {
      }
    }
  }

  public synchronized void checkState() {
    while (this.pause) {
      try {
        this.wait();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }

  public void stopWatch() {
    this.pause = true;
  }

  public synchronized void resumeWatch() {
    this.pause = false;
    this.notify();
  }

}
