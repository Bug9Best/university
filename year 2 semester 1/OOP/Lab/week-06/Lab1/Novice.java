
public class Novice extends Player {

    public Novice() {
        super(10.0, 10.0, 5.0);
    }

    public void addEquipment(Item i) {
        i.use(this);
    }

    public void attack(Player p) {
        p.attacked(this.getATK() * 2.5);
    }

    public void attacked(double n) {
        this.setHP(this.getHP() - n);
    }
}
