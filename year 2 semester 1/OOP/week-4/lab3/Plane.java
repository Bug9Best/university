
public class Plane extends Vehicle {
    public void showPlaneInfo() {
        System.out.println("Plane detail is, Fuel is " + this.getFuel() + " litre and Top Speed is " + this.getTopSpeed() + " m/s.");
    }

    public void setPlaneInfo(int s, String t) {
        this.setFuel(s);
        this.setTopSpeed(t);
    }

    public void fly() {
        if (getFuel() < 200) {
            System.out.println("Please add fuel.");
        } else {
            System.out.println("Fly.");
            this.setFuel(getFuel() - 200);
        }
    }
}
