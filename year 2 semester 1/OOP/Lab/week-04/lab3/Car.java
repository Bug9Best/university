public class Car extends Vehicle {
    private String typeEngine;

    public void setTypeEngine(String t) {
        this.typeEngine = t;
    }

    public String getTypeEngine() {
        return this.typeEngine;
    }

    public void showCarInfo() {
        System.out.printf("Car engine is %s .%n", this.getTypeEngine());
        System.out.printf("Fuel is %d litre and Top Speed is %s m/s.%n", this.getFuel(), this.getTopSpeed());
    }

    public void setCarInfo(int s, String t, String y) {
        this.setFuel(s);
        this.setTopSpeed(t);
        this.typeEngine = y;
    }

    public void move() {

        if (getFuel() < 50) {
            System.out.println("Please add fuel.");
        } else {
            System.out.println("Move.");
            this.setFuel(getFuel() - 50);
        }
    }
}