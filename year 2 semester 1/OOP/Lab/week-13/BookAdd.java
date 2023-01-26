
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BookAdd implements ActionListener {

    private JFrame fr;
    private JPanel pn, pn1, pn2, pn3, pn4;
    private JLabel lb1, lb2, lb3;
    private JTextField tf1, tf2;
    private JButton bt1;
    private JComboBox cb;
    private BookView get;

    public BookAdd(BookView info) {
        get = info;
        fr = new JFrame();
        pn = new JPanel();
        pn1 = new JPanel();
        pn2 = new JPanel();
        pn3 = new JPanel();
        pn4 = new JPanel();
        lb1 = new JLabel("Name");
        lb2 = new JLabel("Price");
        lb3 = new JLabel("Type");
        tf1 = new JTextField();
        tf2 = new JTextField();
        bt1 = new JButton("Insert");
        cb = new JComboBox();
        cb.addItem("General");
        cb.addItem("Computer");
        cb.addItem("Math&Sci");
        cb.addItem("Photo");
        pn.setLayout(new GridLayout(4, 1));
        pn1.setLayout(new GridLayout(1, 2));
        pn1.add(lb1);
        pn1.add(tf1);
        pn2.setLayout(new GridLayout(1, 2));
        pn2.add(lb2);
        pn2.add(tf2);
        pn3.setLayout(new GridLayout(1, 2));
        pn3.add(lb3);
        pn3.add(cb);
        pn4.add(bt1);
        bt1.addActionListener(this);
        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);
        pn.add(pn4);
        fr.add(pn);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        Book a = new Book(tf1.getText(), Double.parseDouble(tf2.getText()), cb.getSelectedItem() + "");
        System.out.println(a);
        System.out.println(a.getName());
        System.out.println(a.getPrice());
        System.out.println(a.getType());
        get.getBook().add(a);
        System.out.println("เข้า");
        JOptionPane.showMessageDialog(fr, "Done it" + ".");
        this.fr.dispose();
    }
}
