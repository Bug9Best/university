package lab2;

import javax.swing.JLabel;
import java.awt.*;
import java.util.*;

public class MyClock extends JLabel implements Runnable {

  public void run() {
    while (true) {
      Calendar d = Calendar.getInstance();
      int sec = d.get(Calendar.SECOND);
      int min = d.get(Calendar.MINUTE);
      int hour = d.get(Calendar.HOUR_OF_DAY);

      setFont(new Font("TimesRoman", Font.BOLD, 48));
      setHorizontalAlignment(CENTER);
      setText(String.format("%02d:%02d:%02d", hour, min, sec));

      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
      }
    }
  }


}
