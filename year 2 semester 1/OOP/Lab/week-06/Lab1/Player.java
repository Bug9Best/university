
public abstract class Player {
    private double HP;
    private double MP;
    private double EXP;
    private double Money;
    private double ATK;

    public Player() {
        this(0.0, 0.0, 0.0, 0.0, 0.0);
    }

    public Player(double HP, double MP, double ATK) {
        this(HP, MP, 0.0, 0.0, ATK);
    }

    public Player(double HP, double MP, double EXP, double Money, double ATK) {
        this.HP = HP;
        this.MP = MP;
        this.EXP = EXP;
        this.Money = Money;
        this.ATK = ATK;
    }

    public double getHP() {
        return this.HP;
    }

    public void setHP(double HP) {
        if (this.HP < 0) {
            this.HP = 0;
        }
        this.HP = HP;
    }

    public double getMP() {
        return this.MP;
    }

    public void setMP(double MP) {
        this.MP += MP;
    }

    public double getEXP() {
        return this.EXP;
    }

    public void setEXP(double EXP) {
        this.EXP += EXP;
    }

    public double getMoney() {
        return this.Money;
    }

    public void setMoney(double Money) {
        this.Money += Money;
    }

    public double getATK() {
        return this.ATK;
    }

    public void setATK(double ATK) {
        this.ATK += ATK;
    }

    public String toString() {
        return "HP : " + this.HP + " MP : " + this.MP + " ATK : " + this.ATK;
    }

    public abstract void attack(Player p);

    public abstract void attacked(double p);
}
