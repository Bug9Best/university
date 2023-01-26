
public abstract class Food {
    protected String name;

    public Food() {
        this.name = "";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int getPower();
}
