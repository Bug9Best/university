package lab1;
import java.awt.*;
import javax.swing.*;

public class MyTextEditorView {
    JFrame window;
    JMenuBar menuBar;
    JMenu menuFile;
    JMenuItem itemNew, itemOpen, itemSave, itemClose;
    JTextArea textArea;

    public MyTextEditorView() {
        window = new JFrame("My Text Editor");
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        itemNew = new JMenuItem("New");
        itemOpen = new JMenuItem("Open");
        itemSave = new JMenuItem("Save");
        itemClose = new JMenuItem("Close");
        textArea = new JTextArea(20, 50);

        window.setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuFile.add(itemNew);
        menuFile.add(itemOpen);
        menuFile.add(itemSave);
        menuFile.addSeparator();
        menuFile.add(itemClose);

        window.setLayout(new FlowLayout());
        window.add(textArea);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public void setMenuFile(JMenu menuFile) {
        this.menuFile = menuFile;
    }

    public void setItemNew(JMenuItem itemNew) {
        this.itemNew = itemNew;
    }

    public void setItemOpen(JMenuItem itemOpen) {
        this.itemOpen = itemOpen;
    }

    public void setItemSave(JMenuItem itemSave) {
        this.itemSave = itemSave;
    }

    public void setItemClose(JMenuItem itemClose) {
        this.itemClose = itemClose;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JFrame getWindow() {
        return window;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public JMenu getMenuFile() {
        return menuFile;
    }

    public JMenuItem getItemNew() {
        return itemNew;
    }

    public JMenuItem getItemOpen() {
        return itemOpen;
    }

    public JMenuItem getItemSave() {
        return itemSave;
    }

    public JMenuItem getItemClose() {
        return itemClose;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

}
