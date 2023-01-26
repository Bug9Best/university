package lab1;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MyTextEditorController implements ActionListener {
    private MyTextEditorView view;
    private MyTextEditorModel model;

    public MyTextEditorController() {
        view = new MyTextEditorView();
        model = new MyTextEditorModel("");

        view.getItemNew().addActionListener(this);
        view.getItemClose().addActionListener(this);
        view.getItemOpen().addActionListener(this);
        view.getItemSave().addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand() == "New") {
            view.getTextArea().setText("");
        } else if (ae.getActionCommand() == "Close") {
            System.exit(0);
        } else if (ae.getActionCommand() == "Open") {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(view.getWindow());
            File f = fc.getSelectedFile();
            model.loadText(f, view);
        } else if (ae.getActionCommand() == "Save") {
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(view.getWindow());
            File f = fc.getSelectedFile();
            model.saveText(f, view);
        }
    }

    public static void main(String[] args) {
        new MyTextEditorController();
    }
}
