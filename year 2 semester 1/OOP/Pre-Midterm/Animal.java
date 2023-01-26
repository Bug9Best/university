
public abstract class Animal {

    private String name;
    private int power;
    private int age;

    public Animal() {
        this("", 0, 0);
    }

    public Animal(String name, int power, int age) {
        this.name = name;
        this.power = power;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(Animal a) {
        return this.name.equals(a.name) && this.age == a.age;
    }

    public String toString() {
        return "Animal : name = " + this.name + ", power = " + this.power + "], age = " + this.age;
    }

    public abstract void eat(Food f);

}
