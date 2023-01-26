package lab1;

import java.io.*;

public class MyTextEditorModel {
    private String text;

    public MyTextEditorModel(String text) {
        this.text = text;
    }

    public void loadText(File f, MyTextEditorView view) {
        try (FileInputStream fin = new FileInputStream(f)) {
            int ch = fin.read();
            while (ch != -1) {
                view.getTextArea().setText(view.getTextArea().getText() + (char) ch);
                ch = fin.read();
            }
        } catch (Exception e) {
            System.out.println("Failed...");
        }
    }

    public void saveText(File f, MyTextEditorView view) {
        try (FileOutputStream fout = new FileOutputStream(f)) {
            for (int i = 0; i < view.getTextArea().getText().length(); i++) {
                fout.write(view.getTextArea().getText().charAt(i));
            }
        } catch (Exception e) {
            System.out.println("Failed...");
        }
    }
}
