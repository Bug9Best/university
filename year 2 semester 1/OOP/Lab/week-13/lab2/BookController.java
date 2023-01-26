package lab2;

import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.*;

public class BookController implements ActionListener, WindowListener {
    BookView bookView;
    BookAdd bookAdd;
    BookModel model;
    Book book;
    private int index;
    private String bookName, bookType;
    private double bookPrice;

    public BookController() {
        bookView = new BookView();
        model = new BookModel();
        index = Integer.parseInt(bookView.getCollectionTextField().getText());
        bookName = ((Book) (model.getBooks().get(index))).getName();
        bookType = ((Book) (model.getBooks().get(index))).getType();
        bookPrice = ((Book) (model.getBooks().get(index))).getPrice();

        bookView.getAddButton().addActionListener(this);
        bookView.getUpdateButton().addActionListener(this);
        bookView.getDeleteButton().addActionListener(this);
        bookView.getLeftButton().addActionListener(this);
        bookView.getRightButton().addActionListener(this);
        bookView.getBookViewWindow().addWindowListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand() == "Add") {
            bookAdd = new BookAdd();
            bookAdd.getInsertButton().addActionListener(this);
        } else if (ae.getActionCommand() == "Insert") {
            book = new Book(bookAdd.getNameTextField().getText(),
                    Double.parseDouble(bookAdd.getPriceTextField().getText()),
                    (String) (bookAdd.getTypeComboBox().getSelectedItem()));
            model.addBook(book);
            JOptionPane.showMessageDialog(null, "Done it.", "", JOptionPane.PLAIN_MESSAGE);
            bookAdd.getBookAddWindow().dispose();
        } else if (ae.getActionCommand() == "Update" && index != 0) {
            model.getBooks().set(index,
                    new Book(bookView.getNameTextField().getText(),
                            Double.parseDouble(bookView.getPriceTextField().getText()),
                            (String) (bookAdd.getTypeComboBox().getSelectedItem())));
            JOptionPane.showMessageDialog(null, "Done it.", "Update", JOptionPane.PLAIN_MESSAGE);
        } else if (ae.getActionCommand() == "Delete" && index != 0) {
            model.getBooks().remove(index);
            index--;
            if (index == 0) {
                bookView.getNameTextField().setText("");
                bookView.getPriceTextField().setText("");
                bookView.getCollectionTextField().setText(index + "");
                bookView.getTypeComboBox().setSelectedItem("General");
            } else {
                bookView.getNameTextField().setText(((Book) (model.getBooks().get(index))).getName());
                bookView.getPriceTextField().setText(((Book) (model.getBooks().get(index))).getPrice() + "");
                bookView.getTypeComboBox().setSelectedItem(((Book) (model.getBooks().get(index))).getType());
                bookView.getCollectionTextField().setText(index + "");
            }
            JOptionPane.showMessageDialog(null, "Done it.", "Delete", JOptionPane.PLAIN_MESSAGE);
        } else if (ae.getActionCommand() == "<<<" && index > 0) {
            index--;
            if (index == 0) {
                bookView.getNameTextField().setText("");
                bookView.getPriceTextField().setText("");
                bookView.getCollectionTextField().setText(index + "");
                bookView.getTypeComboBox().setSelectedItem("General");
            } else {
                bookView.getNameTextField().setText(((Book) (model.getBooks().get(index))).getName());
                bookView.getPriceTextField().setText(((Book) (model.getBooks().get(index))).getPrice() + "");
                bookView.getTypeComboBox().setSelectedItem(((Book) (model.getBooks().get(index))).getType());
                bookView.getCollectionTextField().setText(index + "");
            }

        } else if (ae.getActionCommand() == ">>>" && index + 1 < model.getBooks().size()) {
            index++;
            bookView.getNameTextField().setText(((Book) (model.getBooks().get(index))).getName());
            bookView.getPriceTextField().setText(((Book) (model.getBooks().get(index))).getPrice() + "");
            bookView.getTypeComboBox().setSelectedItem(((Book) (model.getBooks().get(index))).getType());
            bookView.getCollectionTextField().setText(index + "");
        }
    }

    public void windowOpened(WindowEvent ev) {
        try (FileInputStream fin = new FileInputStream("Book.dat");
                ObjectInputStream in = new ObjectInputStream(fin);) {
            try {
                model.setBooks((ArrayList) in.readObject());
            } catch (Exception e) {
                System.out.print(e);
            }
        } catch (IOException e) {
            System.out.print(e);
        }
    }

    public void windowClosed(WindowEvent ev) {
    }

    public void windowClosing(WindowEvent ev) {
        try (FileOutputStream fOut = new FileOutputStream("Book.dat");
                ObjectOutputStream oout = new ObjectOutputStream(fOut);) {
            oout.writeObject((ArrayList) (model.getBooks()));
        } catch (IOException e) {
            System.out.print(e);
        }
    }

    public void windowIconified(WindowEvent ev) {
    }

    public void windowDeiconified(WindowEvent ev) {
    }

    public void windowActivated(WindowEvent ev) {
    }

    public void windowDeactivated(WindowEvent ev) {
    }

    public static void main(String[] args) {
        new BookController();
    }
}
