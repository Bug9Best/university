
public class Pigeous extends Bird {
    public Pigeous() {
        this("", 0);
    }

    public Pigeous(String name, int age) {
        super(name, age);
    }

    public void eat(Food f) {
        this.setPower((getPower() + (f.getPower() * 2)));
    }

    public void fly() {
        System.out.println(getName() + " fly fly ....");
    }

    public void wingAttack(Animal a) {
        a.setPower(a.getPower() - 5);
    }

    public void wingAttack(Animal a, int times) {
        a.setPower(a.getPower() - (5 * times));
    }
}
