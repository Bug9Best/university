public class CheckingAccount extends Account {
    private double credit;

    public CheckingAccount() {
        this(0, "", 0);
    }

    public CheckingAccount(double balance, String name, double credit) {
        super(balance, name);
        this.credit = credit;
    }

    public void setCredit(double credit) {
        if (credit > 0) {
            this.credit = credit;
        } else {
            System.out.println("Input number must be a positive integer.");
        }
    }

    public double getCredit() {
        return this.credit;
    }

    public void withdraw(double a) {
        if (a > 0 && this.balance - a >= 0) {
            this.setBalance(this.balance - a);
            System.out.printf("%.2f baht is withdrawn from %s and your credit balance is %.2f.", a, this.getName(), this.getCredit());
        } 
        else if (a > 0 && this.balance - a < 0 && this.balance - a + this.credit > 0) {
            this.balance = 0;
            this.credit = this.balance - a + this.credit;
            System.out.printf("%.2f baht is withdrawn from %s and your credit balance is %.2f.", a,this.getName(), this.getCredit());
        } else if (a > 0 && this.balance - a < 0 && this.balance - a + this.credit < 0) {
            System.out.println("Not enough money!");
        } else {
            super.withdraw(a);
        }
    }

    public void withdraw(String a) {
        this.withdraw(Double.parseDouble(a));
    }

    public String toString() {
        return "The " + this.getName() + " account has " + this.getBalance() + " baht and " + this.getCredit() + " credits.";
    }
}
