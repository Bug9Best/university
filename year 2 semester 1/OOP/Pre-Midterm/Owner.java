
public class Owner {

    protected final String name;
    protected Animal animal;

    public Owner() {
        this("", null);
    }

    public Owner(String name) {
        this(name, null);
    }

    public Owner(Animal animal) {
        this("", animal);
    }

    public Owner(String name, Animal animal) {
        this.name = name;
        this.animal = animal;
    }

    public String getName() {
        return this.name;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void feedFood(Food f) {
        this.getAnimal().eat(f);
    }

    public String toString() {
        return "Owner : name = " + this.name + ", Animal : name = " + animal.getName() + ", power = "
                + animal.getPower() + ", age = " + animal.getAge();
    }

    public void protectOwnerFrom(Animal a) {
        if (animal instanceof Dog) {

//        if (Dog.class.isInstance(animal)) {
            ((Dog) animal).kick(a);
        } else {
            ((Pigeous) animal).wingAttack(a);
        }
    }
}
