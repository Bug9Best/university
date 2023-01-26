
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class BookView implements ActionListener, WindowListener {

    private JFrame fr;
    private JPanel pn, pn1, pn2, pn3, pn4, pn5;
    private JLabel lb1, lb2, lb3;
    private JTextField tf1, tf2, tf3;
    private JButton bt1, bt2, bt3, bt4, bt5;
    private JComboBox cb;
    private ArrayList<Book> book;
    private int current = 0;

    public BookView() {
        fr = new JFrame();
        pn = new JPanel();
        pn1 = new JPanel();
        pn2 = new JPanel();
        pn3 = new JPanel();
        pn4 = new JPanel();
        pn5 = new JPanel();
        lb1 = new JLabel(" Name");
        lb2 = new JLabel(" Price");
        lb3 = new JLabel(" Type");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField("0", 5);
        bt1 = new JButton("<<<");
        bt2 = new JButton(">>>");
        bt3 = new JButton("Add");
        bt4 = new JButton("Update");
        bt5 = new JButton("Delete");
        cb = new JComboBox();
        cb.addItem("General");
        cb.addItem("Computer");
        cb.addItem("Math&Sci");
        cb.addItem("Photo");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
        pn.setLayout(new GridLayout(5, 1));
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
        pn4.add(tf3);
        pn4.add(bt2);
        pn5.add(bt3);
        pn5.add(bt4);
        pn5.add(bt5);
        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);
        pn.add(pn4);
        pn.add(pn5);
        fr.addWindowListener(this);
        fr.add(pn);
        fr.setDefaultCloseOperation(3);
        fr.pack();
        fr.setVisible(true);
    }

    public ArrayList<Book> getBook() {
        return book;
    }

    public void setBook(ArrayList<Book> book) {
        this.book = book;
    }

    public static void main(String[] args) {
        new BookView();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(bt1)) {
            System.out.println("1");
            if (current > 1) {
                current -= 1;
                tf1.setText("" + book.get(current - 1).getName());
                tf2.setText("" + book.get(current - 1).getPrice());
                cb.setSelectedItem("" + book.get(current - 1).getType());
                tf3.setText("" + current);
            }
        }
        if (ae.getSource().equals(bt2)) {
            System.out.println("2");
            if (book != null && current < book.size()) {
                current += 1;
                tf1.setText("" + book.get(current - 1).getName());
                tf2.setText("" + book.get(current - 1).getPrice());
                cb.setSelectedItem("" + book.get(current - 1).getType());
                tf3.setText("" + current);
            }
        }
        if (ae.getSource().equals(bt3)) {
            System.out.println("3");
            new BookAdd(this);
            System.out.println(book);
        }
        if (ae.getSource().equals(bt4)) {
            System.out.println("4");
            if (current != 0) {
                book.set(current - 1, new Book(tf1.getText(), Double.parseDouble(tf2.getText()), cb.getSelectedItem() + ""));
                JOptionPane.showMessageDialog(fr, "Done it" + ".", "Update Command", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(fr, "Cann't Update On This Book" + ".", "Invalid Command", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (ae.getSource().equals(bt5)) {
            System.out.println("5");
            if (book.size() != 1) {
                book.remove(current - 1);
                tf1.setText(book.get(current - 1).getName());
                tf2.setText("" + book.get(current - 1).getPrice());
                cb.setSelectedItem("" + book.get(current - 1).getType());
                tf3.setText("" + current);
            } else {
                book.remove(current - 1);
                tf1.setText("");
                tf2.setText("");
                cb.setSelectedItem("General");
                tf3.setText("0");
            }
            JOptionPane.showMessageDialog(fr, "Done it" + ".", "Delete Command", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void windowActivated(WindowEvent arg0) {
        System.out.println("activated");
    }

    public void windowClosed(WindowEvent arg0) {
        System.out.println("closed");
    }

    public void windowDeactivated(WindowEvent arg0) {
        System.out.println("deactivated");
    }

    public void windowDeiconified(WindowEvent arg0) {
        System.out.println("deiconified");
    }

    public void windowIconified(WindowEvent arg0) {
        System.out.println("iconified");
    }

    public void windowOpened(WindowEvent arg0) {
        System.out.println("opened");
        book = new ArrayList<Book>();
        try ( FileInputStream fin = new FileInputStream("Book.data");  ObjectInputStream in = new ObjectInputStream(fin);) {
            book = (ArrayList<Book>) in.readObject();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void windowClosing(WindowEvent arg0) {
        System.out.println("closing");
        try ( FileOutputStream fOut = new FileOutputStream("Book.data");  ObjectOutputStream oout = new ObjectOutputStream(fOut);) {
            oout.writeObject((ArrayList<Book>) book);
            System.out.println("Success");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
