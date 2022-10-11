
public class Mage extends Player {

    public Mage() {
        super(10.0, 20.0, 5.0);
    }

    public void addEquipment(Item i) {
        i.use(this);
    }

    public void attack(Player p) {
        p.attacked(this.getATK() * 2.5);
        this.setMP(this.getMP() - 5);
    }

    public void attacked(double n) {
        this.setHP(this.getHP() - n);
    }
}
