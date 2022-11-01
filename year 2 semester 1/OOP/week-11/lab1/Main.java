package lab1;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream fin = new FileInputStream("ChatDemo.dat")) 
        {
            new ChatDemo();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}