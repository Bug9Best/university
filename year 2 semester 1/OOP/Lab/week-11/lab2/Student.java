package lab2;
import java.io.Serializable;

public class Student implements Serializable{
    private String name;
    private int ID;
    private int money;

    public Student() {
        this("", 0, 0);
    }

    public Student(String name, int ID, int money) {
        this.name = name;
        this.ID = ID;
        this.money = money;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
