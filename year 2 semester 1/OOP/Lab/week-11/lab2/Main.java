package lab2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream fin = new FileInputStream("StudentM.dat");) {
            new StudentView();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
