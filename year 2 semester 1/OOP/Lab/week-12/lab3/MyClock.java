package lab3;

import javax.swing.JLabel;
import java.awt.*;

public class MyClock extends JLabel implements Runnable {

  public void run() {
    int sec = 0;
    int min = 0;
    int hour = 0;

    while (true) {
      setFont(new Font("TimesRoman", Font.BOLD, 48));
      setHorizontalAlignment(CENTER);
      setText(String.format("%02d:%02d:%02d", hour, min, sec));

      try {
        Thread.sleep(1000);
        sec++;

        if (sec == 60) {
          min++;
          sec = 0;
        }

        if (min == 60) {
          hour++;
          min = 0;
        }

        if (hour == 24) {
          hour = 0;
        }
      } catch (InterruptedException ex) {
      }
    }
  }
}
