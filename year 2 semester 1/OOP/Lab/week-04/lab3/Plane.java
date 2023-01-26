public class Plane extends Vehicle {
    public void showPlaneInfo() {
        System.out.printf("Plane detail is, Fuel is %d litre and Top Speed is %s m/s.%n", this.getFuel(), this.getTopSpeed());
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